package com.sk.gz.service.impl;

import com.sk.gz.model.curve.CrossAnalysisResult;
import com.sk.gz.model.curve.PlantPowerCurve;
import com.sk.gz.model.curve.StationPowerCurve;
import com.sk.gz.model.param.CrossAnalysisParam;
import com.sk.gz.model.param.PowerCurveParam;
import com.sk.gz.model.power.MonthStationPower;
import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.model.power.StationPreview;
import com.sk.gz.service.StationInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Service
public class StationInfoServiceImpl implements StationInfoService {
    @Override
    public List<MonthStationPower> getPowerInfoPerMonth() {
        return null;
    }

    @Override
    public StationPreview getPreviewInfo() {
        StationPreview result = new StationPreview();

        return result;
    }

    @Override
    public List<StationIndicators> getIndcators() {
        Random random = new Random(47);
        List<StationIndicators> result = new ArrayList<StationIndicators>();
        for (int i = 0; i < 5; i++) {
            int id = i + 1;

            int rangeBottom = 0;
            int rangeTop = 100;
            int ran = random.nextInt(rangeTop);

            result.add(new StationIndicators("风机#"+id, id,
                    random.nextInt(2000),
                    random.nextFloat(),
                    random.nextFloat(),
                    random.nextFloat(),
                    random.nextFloat(),
                    random.nextFloat(),
                    random.nextFloat(),
                    random.nextFloat(),
                    random.nextFloat()));
        }
        return result;
    }

    @Override
    public StationPowerCurve getPowerCurveById(int id) {

        StationPowerCurve result = new StationPowerCurve();

        return result;
    }


    @Override
    public CrossAnalysisResult doCrossAnaysis(CrossAnalysisParam param) {
        return null;
    }

    @Override
    public List<PlantPowerCurve> powerCurveAnalysis(List<PowerCurveParam> params) {
        return null;
    }
}
