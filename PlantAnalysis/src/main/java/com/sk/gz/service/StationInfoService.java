package com.sk.gz.service;

import com.sk.gz.model.curve.CrossAnalysisResult;
import com.sk.gz.model.curve.PlantPowerCurve;
import com.sk.gz.model.curve.StationPowerCurve;
import com.sk.gz.model.param.CrossAnalysisParam;
import com.sk.gz.model.param.PowerCurveParam;
import com.sk.gz.model.power.MonthStationPower;
import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.model.power.StationPreview;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
public interface StationInfoService {
    List<MonthStationPower> getPowerInfoPerMonth();

    StationPreview getPreviewInfo();

    List<StationIndicators> getIndcators();

    StationPowerCurve getPowerCurveById(int id);

    CrossAnalysisResult doCrossAnaysis(CrossAnalysisParam param);

    List<PlantPowerCurve> powerCurveAnalysis(List<PowerCurveParam> params);
}
