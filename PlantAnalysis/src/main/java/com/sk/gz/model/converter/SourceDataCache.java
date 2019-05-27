package com.sk.gz.model.converter;

import com.sk.gz.entity.PlantDataInitial;
import com.sk.gz.entity.PlantDataPretreatment;
import com.sk.gz.model.curve.CurvePoint;
import com.sk.gz.utils.DateUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/5
 */
@Data
@Component
public class SourceDataCache {
    /** 时间单位转换： ms => hour */
    public static final float MS_TO_HOUR = 0.001f / 3600f;

    /** 原始数据时间间隔 */
    private static final long SOURCE_DATA_INTERVAL = 5000;

    /** 处理不同时间块的中间变量 */
    private List<PlantDataInitial> cache = new ArrayList<PlantDataInitial>();
    private Date cacheStartTime = null;
    private Date cacheEndTime = null;
    private Date cacheMonthBegin = null;
    private Integer cacheState = null;
    private boolean stateChanged = false;

    /** 处理不同风机数据的中间变量 */
    private int plantId;
    private PlantDataPretreatment preData = null;
    private double preDataTotalPower = 0;

    public int addData(PlantDataInitial data, long limit, List<CurvePoint> curvePoints,
                       boolean dataEnd, float powerRating) {
        //# init catch info
        if (cacheStartTime == null || cacheState == null) {
            initData(data);
            return 1;
        }

        //# check state change
        int state = data.getState();
        if (state != cacheState) {
            stateChanged = true;
        }

        //# check time length or month changed.
        Date datatime = data.getDatatime();
        Date monthBegin = DateUtil.getFirstDateOfMonth(datatime);
        if (stateChanged ||
                (datatime.getTime() - cacheStartTime.getTime()) >= limit ||
                monthBegin.getTime() != cacheMonthBegin.getTime()) {
            preData = preprocess(curvePoints, powerRating);
            initCache(data);
            return 0;
        }

        cache.add(data);
        cacheEndTime = datatime;

        if (dataEnd) {
            preData = preprocess(curvePoints, powerRating);
            return 0;
        }
        return 1;
    }


    private void initCache(PlantDataInitial data) {
        initCache();
        initData(data);
    }

    public void initCache() {
        cache.clear();
        cacheStartTime = null;
        cacheState = null;
        cacheMonthBegin = null;
        cacheEndTime = null;
        stateChanged = false;
    }

    private void initData(PlantDataInitial data) {
        if (plantId != data.getPlantid()) {
            preData = null;
            preDataTotalPower = 0;
        }

        plantId = data.getPlantid();
        cacheStartTime = data.getDatatime();
        cacheEndTime = cacheStartTime;
        cacheState = data.getState();
        cacheMonthBegin = DateUtil.getFirstDateOfMonth(cacheStartTime);

        cache.add(data);
    }

    private PlantDataPretreatment preprocess(List<CurvePoint> curvePoints, float powerRating) {
        int size = cache.size();
        if (cache.size() < 2 || cacheStartTime == null || cacheState == null) {
            return null;
        }

        PlantDataPretreatment preData = new PlantDataPretreatment();
        //# 风机id
        preData.setPlantid(plantId);

        //# 数据时间
        preData.setTime(cacheStartTime);

        //# 区间时间 - ms
        long duration = cacheEndTime.getTime() - cacheStartTime.getTime() + SOURCE_DATA_INTERVAL;
        preData.setDuration(duration);

        //# 发电状态
        preData.setPowerstate(cacheState);

        //# 数据状态 - 预处理
        int state = getState(cacheState);
        preData.setState(state);


        //# 累计发电量
        double totalPower = cache.get(0).getTotalpower();
        if (state == DataState.INVALID.getValue()) {
            totalPower = this.preDataTotalPower;
        }
        preData.setTotalpower(totalPower);
        this.preDataTotalPower = cache.get(size - 1).getTotalpower();

        //# 风速风向
        float wind = (float)(cache.stream().mapToDouble(PlantDataInitial::getAmbwindspeed).average().getAsDouble());
        preData.setAmbwindspeed(wind);
        preData.setAmbwinddir((float)(cache.stream().mapToDouble(PlantDataInitial::getAmbwinddir).average().getAsDouble()));

        //# 有功功率
        double avg = cache.stream().mapToDouble(PlantDataInitial::getGripower).average().getAsDouble();

        preData.setGripower((float)(cache.stream().mapToDouble(PlantDataInitial::getGripower).average().getAsDouble()));

        //# 转速
        preData.setGenrpm((float)(cache.stream().mapToDouble(PlantDataInitial::getGenrpm).average().getAsDouble()));

        //# 平均桨叶角度
        preData.setBladeangle((float)(cache.stream().mapToDouble(PlantDataInitial::getHubspe).average().getAsDouble()));

        //# 计算理论发电量
        float estimatepower = calculateEstimatepower(wind, curvePoints, duration, powerRating);
        preData.setEstimatepower(estimatepower);

        //# 默认值
        preData.setActualpower(0.0f);
        preData.setReductivepower(0.0f);

        return preData;
    }

    /** 根据功率曲线 */
    private float calculateEstimatepower(float wind, List<CurvePoint> curvePoints, long msesc, float powerRating) {
        float power = 0;
        if (curvePoints.size() < 2) {
            return power;
        }

        CurvePoint prePoint = null;
        CurvePoint nowPoint = null;
        for (CurvePoint point: curvePoints) {
            if (prePoint == null || nowPoint == null) {
                prePoint = point;
                nowPoint = point;
                continue;
            }

            prePoint = nowPoint;
            nowPoint = point;
            if (nowPoint.getWindSpeed() > wind) {
                break;
            }
        }

        float speedLen = nowPoint.getWindSpeed() - prePoint.getWindSpeed();
        if (speedLen != 0) {
            float powerLen = nowPoint.getPower() - prePoint.getPower();
            power = prePoint.getPower() + powerLen * (wind - prePoint.getWindSpeed() / speedLen);
        }

        power = (power < 0) ? 0 : (power > powerRating ? powerRating : power);

        return power * msesc * MS_TO_HOUR;
    }

    /**
     * 发电状态 = {故障、检修、停机}，数据状态 = {停机}
     * 发电状态 = {离线}，数据状态 = {无效}
     * 发电状态 = {发电}，数据状态 = {正常}
     * 发电状态 = else，数据状态 = {欠发}
     */
    private int getState(int powerState) {
        int state = DataState.UNDER.getValue();

        PowerState pState = PowerState.getTypeByValue(powerState);
        switch (pState) {
            case OFF_LINE:
                state = DataState.INVALID.getValue();
                break;

            case GEN:
                state = DataState.NORMAL.getValue();
                break;

            case ERR:
            case FIX:
            case STOP:
                state = DataState.STOP.getValue();
                break;

            default:
                DataState.UNDER.getValue();
                break;
        }

        return state;
    }
}
