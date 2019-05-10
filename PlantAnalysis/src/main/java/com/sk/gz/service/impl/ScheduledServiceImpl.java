package com.sk.gz.service.impl;

import com.sk.gz.aop.ResultBeanExceptionHandler;
import com.sk.gz.dao.PlantDAO;
import com.sk.gz.dao.PlantDataPretreatmentDAO;
import com.sk.gz.dao.PowerCurvePointsDAO;
import com.sk.gz.entity.PlantDataInitial;
import com.sk.gz.entity.PowerCurvePoints;
import com.sk.gz.model.converter.CurvePointType;
import com.sk.gz.model.converter.DataState;
import com.sk.gz.model.converter.FilterParam;
import com.sk.gz.model.converter.QuartileFilter;
import com.sk.gz.model.converter.RangeParam;
import com.sk.gz.model.converter.SourceDataCache;
import com.sk.gz.model.curve.CurvePoint;
import com.sk.gz.model.param.PlantLabel;
import com.sk.gz.service.ScheduledService;
import com.sk.gz.utils.CsvUtil;
import com.sk.gz.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    private PlantDAO plantDAO;


    /** 定时任务，每天执行一次 */
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public void scheduleTask() {
        Date today = new Date();
        Date startTime = DateUtil.dateTimeToDate(today);
        Date endTime = DateUtil.dateAddDays(startTime, 1, false);
        dataTransform(startTime, endTime, false);
    }

    @Override
    public void dataTransform(Date startTime, Date endTime, boolean isHis) {
        List<PlantLabel> plants = plantDAO.findAllIndexInfo();

        // TODO:test
        plants.clear();
        plants.add(new PlantLabel(30210, "测试机组"));

        // 文件存放规则适配
        String pathPrefix = "testfiles/";
        String fileDatePattern = isHis ? "yyyy_mm/" : "yyyy_mm_dd/";
        Date cur = startTime;
        Date pre = cur;
        while (cur.before(endTime)) {
            String filePath = pathPrefix + DateUtil.dateFormat(cur, fileDatePattern);

            for (PlantLabel plant : plants) {
                int plantId = plant.getId();
                String fileName = "hbq-" + plantId + ".csv";

                //#1 read csv
                List<PlantDataInitial> sourceData = CsvUtil.getCsvData(filePath + fileName, PlantDataInitial.class);
                log.info("plant#" + filePath + fileName + ", data size = " + sourceData.size());

                //#2 data verify: to 10mins data
                pretreatment(plantId, sourceData);

                //#3 filter
                filter(plantId);

                //#4 update power curve.
//            List<CurvePoint> curve = getPowerCurve(plantId,"ambWindSpeed","griPower", 0.5f);
//            log.info(curve.toString());
            }

            pre = cur;
            if (isHis) {
                cur = DateUtil.dateAddMonths(cur, 1);
            } else {
                cur = DateUtil.dateAddDays(cur, 1, false);
            }

            //# calculate power for all plant
            Date startUpdateDate = DateUtil.dateAddDays(pre, 1, false);
            plantDataPretreatmentDAO.updatePower(DataState.INVALID.getValue(),
                    startUpdateDate, cur);

            //# 对当前时间窗内电量进行统计，存储到月电量信息表中
            // TODO:

        }
    }

    /** 预处理 */
    private void pretreatment(int plantId, List<PlantDataInitial> sourceData) {
        // 【重要前提】：功率曲线已经存在
        List<CurvePoint> curvePoints = powerCurvePointsDAO.findByPlantIdAndTypeAndWindASC(
                plantId,
                CurvePointType.FFIT_CURVE.getValue());

        sourceDataCache.initCache();
        int size = sourceData.size();
        for (int i = 0; i < size; i++) {
            boolean isDataEnd = ((i+1) == size);

            PlantDataInitial data = sourceData.get(i);
            if (sourceDataCache.addData(data, PREPROCESS_DATA_LENGTH, curvePoints, isDataEnd) == 0) {
                pretreatmentDataCache.add(sourceDataCache.getPreData(), isDataEnd);
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

        powerCurvePointsDAO.deleteByType(CurvePointType.FFIT_CURVE.getValue());

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
        powerCurvePointsDAO.batchInsert(plantId, curvePoints, CurvePointType.FFIT_CURVE.getValue());

        return curvePoints;
    }
}
