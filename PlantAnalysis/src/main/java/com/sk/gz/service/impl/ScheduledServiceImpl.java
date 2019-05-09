package com.sk.gz.service.impl;

import com.sk.gz.aop.ResultBeanExceptionHandler;
import com.sk.gz.dao.PlantDataPretreatmentDAO;
import com.sk.gz.dao.PowerCurvePointsDAO;
import com.sk.gz.entity.PlantDataInitial;
import com.sk.gz.entity.PowerCurvePoints;
import com.sk.gz.model.converter.DataState;
import com.sk.gz.model.converter.FilterParam;
import com.sk.gz.model.converter.QuartileFilter;
import com.sk.gz.model.converter.RangeParam;
import com.sk.gz.model.converter.SourceDataCache;
import com.sk.gz.model.curve.CurvePoint;
import com.sk.gz.service.ScheduledService;
import com.sk.gz.utils.CsvUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/28
 */
@Service
@EnableScheduling
public class ScheduledServiceImpl implements ScheduledService {
    private final Logger log = LoggerFactory.getLogger(ResultBeanExceptionHandler.class);
    private static final long PREPROCESS_DATA_LENGTH = 10 * 60 * 1000;

    @Resource
    private PretreatmentDataCache pretreatmentDataCache;

    @Resource
    private SourceDataCache sourceDataCache;

    @Resource
    private QuartileFilter quartileFilter;

    @Resource
    private PlantDataPretreatmentDAO plantDataPretreatmentDAO;

    @Resource
    private PowerCurvePointsDAO powerCurvePointsDAO;

//    @Scheduled(cron = "0 59 * * * ? ")
    @Override
    public void dataTransform(List<String> filePathList) {
        int plantId = 30210;
//        String filePath = "";
//        if (filePathList.size() == 0 || filePathList == null) {
//            filePath = "testfiles/hbq-10.csv";
//        }
        for (String filePath : filePathList) {
            //#1 read csv
            List<PlantDataInitial> sourceData = CsvUtil.getCsvData(filePath, PlantDataInitial.class);
            log.info("plant#" + filePath + ", data size = " + sourceData.size());

            //#2 data verify: to 10mins data
            pretreatment(sourceData);
        }

        //#3 filter
        filter(plantId);

        //#4 calculate and save.
//        List<CurvePoint> curve = getPowerCurve(plantId,"ambWindSpeed","griPower", 0.5f);
//        log.info(curve.toString());

        calculatePower(plantId);
    }

    /** 预处理 */
    private void pretreatment(List<PlantDataInitial> sourceData) {
        // 【重要前提】：功率曲线已经存在
//        List<CurvePoint> curvePoints


        sourceDataCache.initCache();
        int size = sourceData.size();
        for (int i = 0; i < size; i++) {
            boolean isDataEnd = ((i+1) == size);

            if(i > 50*120) {
                isDataEnd = true;
            }
            PlantDataInitial data = sourceData.get(i);

            if (sourceDataCache.addData(data, PREPROCESS_DATA_LENGTH, isDataEnd) == 0) {
                pretreatmentDataCache.add(sourceDataCache.getPreData(), isDataEnd);
            }

            if (isDataEnd) {
                break;
            }
        }
    }

    /** 四分位法过滤 */
    private void filter(int plantId) {
        List<FilterParam> params = new ArrayList<>();
        params.add(new FilterParam("griPower", 25f, "ambWindSpeed", 0));
        params.add(new FilterParam("ambWindSpeed", 0.5f, "griPower", 1));
        quartileFilter.filt(plantId, params);
    }

    /** 计算生成功率曲线 */
    private List<CurvePoint> getPowerCurve(int plantId, String xColumn, String yColumn, float scale) {
        List<CurvePoint> curvePoints = new ArrayList<>();

        powerCurvePointsDAO.deleteByType(0);

        float maxValue = plantDataPretreatmentDAO.findMaxByColumn(xColumn, plantId);
        float rangeMin = 0;
        float rangeMax = maxValue;
        while (rangeMin < maxValue) {
            float tempMax = rangeMin + scale;
            rangeMax = tempMax > maxValue ? maxValue : tempMax;
            RangeParam rangeParam = new RangeParam(xColumn, yColumn, plantId,
                    DataState.NORMAL.getValue(),
                    rangeMin, DataState.UNDER.getValue(),
                    rangeMax, DataState.OVER.getValue(),
                    rangeMin, rangeMax);
            CurvePoint point = plantDataPretreatmentDAO.findAvgByColumnAndRange(rangeParam);
            if (point != null) {
                curvePoints.add(point);
            }

            rangeMin += scale;
        }

        //# save to database
        powerCurvePointsDAO.batchInsert(plantId, curvePoints, 0);

        return curvePoints;
    }

    /** 对预处理的数据进行电量计算 */
    private int calculatePower(int plantId) {

        return 0;
    }
}
