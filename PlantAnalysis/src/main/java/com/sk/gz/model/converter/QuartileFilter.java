package com.sk.gz.model.converter;

import com.sk.gz.dao.PlantDataPretreatmentDAO;
import lombok.Data;
import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description : 四分位过滤
 * @Author : Ellie
 * @Date : 2019/5/7
 */
@Data
@Component
public class QuartileFilter {
    @Resource
    private PlantDataPretreatmentDAO plantDataPretreatmentDAO;

    private float FL,FU;

    public void filt(int plantId, String column, float scale) {
        float maxValue = plantDataPretreatmentDAO.findMaxByColumn(column, plantId);
        System.out.println("column " + column + " max value is " + maxValue);
        float rangeMin = 0;
        float rangeMax = maxValue;
        while (rangeMin < maxValue) {
            float tempMax = rangeMin + scale;
            rangeMax = tempMax > maxValue ? maxValue : tempMax;

            //#1 get data
            List<Float> data = plantDataPretreatmentDAO.findByColumnAndRange(new RangeParam(
                    column,
                    plantId,
                    DataState.NORMAL.getValue(),
                    rangeMin,
                    DataState.UNDER.getValue(),
                    rangeMax,
                    DataState.OVER.getValue()));

            System.out.println(data);

            //#2 calculate filt factor
            FL = rangeMin;
            FU = rangeMax;
            if (getQuartile(data) != 0) {
                continue;
            }
            if (FL == rangeMin && FU == rangeMax) {
                continue;
            }

            //#3 update data state
            System.out.println("FL=" + FL + "FU=" + FU);
            new RangeParam(
                    column,
                    plantId,
                    DataState.NORMAL.getValue(),
                    FL,
                    DataState.UNDER.getValue(),
                    FU,
                    DataState.OVER.getValue());





            rangeMin += scale;

            break;
        }


    }

    private int getQuartile(List<Float> data) {
        int size = data.size();
        if (size < 4) {
            return 1;
        }

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

        return 0;
    }
}
