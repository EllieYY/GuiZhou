package com.sk.gz.service.impl;

import com.sk.gz.dao.PlantDAO;
import com.sk.gz.model.curve.CrossAnalysisResult;
import com.sk.gz.model.curve.PlantPowerCurve;
import com.sk.gz.model.curve.StationPowerCurve;
import com.sk.gz.model.param.CrossAnalysisParam;
import com.sk.gz.model.param.PlantLabel;
import com.sk.gz.model.param.PowerCurveParam;
import com.sk.gz.model.power.MonthStationPower;
import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.model.power.StationPreview;
import com.sk.gz.service.StationInfoService;
import com.sk.gz.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Service
public class StationInfoServiceImpl implements StationInfoService {
    @Resource
    private PlantDAO plantDAO;

    @Override
    public List<MonthStationPower> getPowerInfoPerMonth() {
        Random random = new Random(47);
        List<MonthStationPower> result = new ArrayList<MonthStationPower>();
        Date now = new Date();
        for (int i = 0; i < 36; i++) {
            int id = i + 1;

            float gen = Math.abs(random.nextFloat());

            result.add(new MonthStationPower(
                    DateUtil.dateAddMonths(now, -i),
                    gen,
                    gen * 0.1f));
        }
        return result;
    }

    @Override
    public StationPreview getPreviewInfo() {
        Random random = new Random(47);
        Date now = new Date();
        StationPreview result = new StationPreview(
                DateUtil.dateAddMonths(now, -36),
                now,
                Math.abs(random.nextFloat()),
                Math.abs(random.nextFloat()),
                Math.abs(random.nextFloat()),
                Math.abs(random.nextFloat()),
                Math.abs(random.nextFloat()),
                Math.abs(random.nextFloat())
                );

        return result;
    }

    @Override
    public List<StationIndicators> getIndcators() {
        Random random = new Random(47);
        List<StationIndicators> result = new ArrayList<StationIndicators>();
        for (int i = 0; i < 79; i++) {
            int id = i + 1;

            int rangeBottom = 0;
            int rangeTop = 100;
            int ran = random.nextInt(rangeTop);

            result.add(new StationIndicators("风机#"+id, id,
                    random.nextInt(2000),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat()),
                    Math.abs(random.nextFloat())));
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

    @Override
    public List<PlantLabel> getPlantList() {
        return plantDAO.findAllIndexInfo();
    }
}
