package com.sk.gz.service.impl;

import com.sk.gz.aop.excption.ServiceException;
import com.sk.gz.dao.PlantDAO;
import com.sk.gz.dao.PlantDataPretreatmentDAO;
import com.sk.gz.dao.PowerCurvePointsDAO;
import com.sk.gz.dao.DesignPowerCurveDAO;
import com.sk.gz.dao.QuotaMonthDAO;
import com.sk.gz.entity.Plant;
import com.sk.gz.model.converter.DataTypeParam;
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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Service
public class StationInfoServiceImpl implements StationInfoService {
    @Resource
    private PowerCurvePointsDAO powerCurvePointsDAO;
    @Resource
    private DesignPowerCurveDAO designPowerCurveDAO;
    @Resource
    private QuotaMonthDAO quotaMonthDAO;
    @Resource
    private PlantDataPretreatmentDAO plantDataPretreatmentDAO;
    @Resource
    private PlantDAO plantDAO;

    /** 按月份统计所有风机 */
    @Override
    public List<MonthStationPower> getPowerInfoPerMonth() {
        return quotaMonthDAO.findStationMonthPower();

//        Random random = new Random(47);
//        List<MonthStationPower> result = new ArrayList<MonthStationPower>();
//        Date now = new Date();
//        for (int i = 0; i < 36; i++) {
//            int id = i + 1;
//
//            float gen = Math.abs(random.nextFloat());
//
//            result.add(new MonthStationPower(
//                    DateUtil.dateAddMonths(now, -i),
//                    gen,
//                    gen * 0.1f));
//        }
//        return result;
    }

    /** 风电厂整厂信息统计 */
    @Override
    public StationPreview getPreviewInfo() {
        return quotaMonthDAO.findStationPreview();

//        Random random = new Random(47);
//        Date now = new Date();
//        StationPreview result = new StationPreview(
//                DateUtil.dateAddMonths(now, -36),
//                now,
//                Math.abs(random.nextFloat()),
//                Math.abs(random.nextFloat()),
//                Math.abs(random.nextFloat()),
//                Math.abs(random.nextFloat()),
//                Math.abs(random.nextFloat()),
//                Math.abs(random.nextFloat())
//                );
//
//        return result;
    }

    /** 风场电量指标 - 按风机统计 */
    @Override
    public List<StationIndicators> getIndcators() {
        return quotaMonthDAO.findStationIndicators();
//        Random random = new Random(47);
//        List<StationIndicators> result = new ArrayList<StationIndicators>();
//        for (int i = 0; i < 79; i++) {
//            int id = i + 1;
//
//            int rangeBottom = 0;
//            int rangeTop = 100;
//            int ran = random.nextInt(rangeTop);
//
//            result.add(new StationIndicators("风机#"+id, id,
//                    random.nextInt(2000),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat()),
//                    Math.abs(random.nextFloat())));
//        }
//        return result;
    }

    @Override
    public StationPowerCurve getPowerCurveById(int id) {
        StationPowerCurve result = new StationPowerCurve();
        // 功率曲线
        result.setPracticalCurve(powerCurvePointsDAO.findByPlantIdAndWindASC(id));

        int plantType = plantDAO.findTypeByPlantId(id);
        result.setReferenceCurve(designPowerCurveDAO.findByTypeAndWindASC(plantType));

        // 原始数据
        result.setSourcePoints(plantDataPretreatmentDAO.findSourceData(id));

        // 统计结果
        result.setStateStatistics(plantDataPretreatmentDAO.findStateStatisticsByPlantId(id, new DataTypeParam()));

        return result;
    }

    /** 交叉分析 */
    @Override
    public CrossAnalysisResult doCrossAnaysis(CrossAnalysisParam param) {
        int plantId = param.getId();
        String xColumn = getColumnName(param.getX());
        String yColumn = getColumnName(param.getY());

        CrossAnalysisResult result = new CrossAnalysisResult();
        result.setPoints(plantDataPretreatmentDAO.findSourceDataByColumn(plantId, xColumn, yColumn));

        int scaleNum = param.getDensityNum() - 1;
        scaleNum = scaleNum < 1 ? 1 : scaleNum;
        float xMax = plantDataPretreatmentDAO.findMaxByColumn(xColumn, plantId);
        float xMin = plantDataPretreatmentDAO.findMinByColumn(xColumn, plantId);
        double scale = (xMax - xMin) / scaleNum;
//        scale = Math.ceil(scale);
        result.setDensity(plantDataPretreatmentDAO.findHistogramByColumn(plantId, xColumn, scale));

        return result;
    }

    /** 功率曲线查询 */
    @Override
    public List<PlantPowerCurve> powerCurveAnalysis(List<PowerCurveParam> params) {
        List<PlantPowerCurve> result = new ArrayList<>();

        for (PowerCurveParam param : params) {
            int plantId = param.getId();
            Plant plant = plantDAO.selectByPrimaryKey(plantId);
            if (plant == null) {
                continue;
            }

            PlantPowerCurve curve = new PlantPowerCurve();
            curve.setId(plantId);
            curve.setName(plant.getName());

            curve.setPoints(plantDataPretreatmentDAO.findCurvePointByTime(
                    plantId,
                    0.5f,
                    param.getStart(),
                    param.getEnd()));
            result.add(curve);
        }

        return result;
    }

    @Override
    public List<PlantLabel> getPlantList() {
        return plantDAO.findAllIndexInfo();
    }


    private String getColumnName(int index) throws ServiceException {
        String column = "";
        switch(index) {
            // 风速
            case 1:
                column = "ambWindSpeed";
                break;

            // 有功功率
            case 2:
                column = "griPower";
                break;

            // 发电机转速
            case 3:
                column = "genRPM";
                break;

            // 平均桨叶角度
            case 4:
                column = "bladeAngle";
                break;
            default:
                break;
        }

        if (column.isEmpty()) {
            throw new ServiceException("[交叉分析] 找不到index#" + index + "对应的数据列");
        }
        return column;
    }
}
