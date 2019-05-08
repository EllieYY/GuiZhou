package com.sk.gz.model.converter;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.sk.gz.dao.PlantDataPretreatmentDAO;
import lombok.Data;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 四分位过滤
 * @Author : Ellie
 * @Date : 2019/5/7
 */
@Data
@Component
public class QuartileFilter {
    private final Logger log = LoggerFactory.getLogger(QuartileFilter.class);

    @Resource
    private PlantDataPretreatmentDAO plantDataPretreatmentDAO;
    private float FL,FU;

    public void filt(int plantId, List<FilterParam> params) {
        List<FilterResult> filterResults = new ArrayList<>();
        for (int i = 0; i < params.size(); i++) {
            FilterParam param = params.get(i);
            String scaleColumn = param.getScaleColumn();
            String targetColumn = param.getTargetColumn();
            float scale = param.getScale();
            int rangeValidFlag = param.getRangeValidFlag();

            float maxValue = plantDataPretreatmentDAO.findMaxByColumn(scaleColumn, plantId);
            float rangeMin = 0;
            float rangeMax = maxValue;
            while (rangeMin < maxValue) {
                float tempMax = rangeMin + scale;
                rangeMax = tempMax > maxValue ? maxValue : tempMax;

                //#1 get data
                RangeParam rangeParam = new RangeParam(scaleColumn, targetColumn, plantId,
                        DataState.NORMAL.getValue(),
                        rangeMin, DataState.UNDER.getValue(),
                        rangeMax, DataState.OVER.getValue(),
                        rangeMin, rangeMax);
                List<Float> data = plantDataPretreatmentDAO.findByColumnAndRange(rangeParam);
                log.info("[rang param] = " + rangeParam);

                //#2 calculate filt factor
                FL = rangeMin;
                FU = rangeMax;
                FilterResult filterResult = getQuartile(data, rangeValidFlag);
                if (filterResult == null) {
                    rangeMin += scale;
                    continue;
                }

                filterResults.add(filterResult);
                if (FL == rangeMin && FU == rangeMax) {
                    rangeMin += scale;
                    continue;
                }

                //#3 update data state
                RangeParam updateRangeParam = new RangeParam(
                        scaleColumn, targetColumn, plantId,
                        DataState.NORMAL.getValue(),
                        FL, DataState.UNDER.getValue(),
                        FU, DataState.OVER.getValue(),
                        rangeMin, rangeMax);
                plantDataPretreatmentDAO.updateStateByRange(updateRangeParam);

                rangeMin += scale;
            }

            filterResults.add(new FilterResult());
        }

        //# print result to excel
        try {
            toExcel(plantId, filterResults);
        } catch (IOException e) {
            log.info("fail to save to excel");
        }
    }


    private FilterResult getQuartile(List<Float> data, int rangeValidFlag) {
        int size = data.size();
        if (size < 4) {
            log.info("negligible data size: " + size);
            return null;
        }

        String range = FL + "~" + FU;

        int k = size / 4;
        int i = size % 4;
        float Q1 = 0,Q3 = 0,IQR = 0;
        if (i == 0) {
            Q1 = 0.5f * data.get(k-1) + 0.5f * data.get(k);
            Q3 = 0.5f * data.get(3 * k - 1) + 0.5f * data.get(3 * k);
        }
        else if (i == 1) {
            Q1 = 0.25f * data.get(k - 1) + 0.75f * data.get(k);
            Q3 = 0.75f * data.get(3 * k) + 0.25f * data.get(3 * k + 1);
        }
        else if (i == 2) {
            Q1 = data.get(k);
            Q3 = data.get(3 * k + 1);
        }
        else if (i == 3) {
            Q1 = 0.75f * data.get(k) + 0.25f * data.get(k + 1);
            Q3 = 0.25f * data.get(3 * k + 1) + 0.75f * data.get(3 * k + 2);
        }
        IQR = Q3 - Q1;

        FL = Q1 - 1.5f * IQR;
        FU = Q3 + 1.5f * IQR;


        float valueMin = data.get(0);
        float valueMax = data.get(size-1);
        if (rangeValidFlag == 1) {
            FL = valueMin;
        } else if (rangeValidFlag == -1) {
            FU = valueMax;
        } else if (rangeValidFlag == 2) {
            return null;
        }

        return new FilterResult(range, valueMin, valueMax, Q1, Q3, IQR, FL, FU);
    }


    private void toExcel(int plantId, List<FilterResult> result) throws IOException {
        int sheetNo = plantId % 100 + 1;

        try (OutputStream out = new FileOutputStream("result" + plantId + ".xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            Sheet sheet = new Sheet(sheetNo, 0, FilterResult.class);
            String name = "FJ" + plantId;
            sheet.setSheetName(name);

            writer.write(result, sheet);
            writer.finish();
        }
    }
}
