package com.sk.gz.model.converter;

import com.sk.gz.entity.PlantDataInitial;
import com.sk.gz.entity.PlantDataPretreatment;
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
    private List<PlantDataInitial> cache = new ArrayList<PlantDataInitial>();
    private PlantDataPretreatment preData = null;
    private Date cacheStartTime = null;
    private Date cacheEndTime = null;
    private Date cacheMonthBegin = null;
    private Integer cacheState = null;
    private boolean stateChanged = false;
    private int plantId;

    public int addData(PlantDataInitial data, long limit, boolean dataEnd) {
        //# init catch info
        if (cacheStartTime == null || cacheState == null || plantId != data.getPlantid()) {
            initData(data);
            return 1;
        }

        //# check time length or month changed.
        Date datatime = data.getDatatime();
        Date monthBegin = DateUtil.getFirstDateOfMonth(datatime);
        if ((datatime.getTime() - cacheStartTime.getTime()) >= limit ||
                monthBegin.getTime() != cacheMonthBegin.getTime()) {
            preData = preprocess();
            initCache(data);
            return 0;
        }

        //# if state change, discard rest data in this limit length.
        int state = data.getState();
        boolean isStateDefine = false;
        for (PowerState s : PowerState.values()) {
            if (state == s.getValue()) {
                isStateDefine = true;
            }
        }

        if (isStateDefine && (!stateChanged) && state == cacheState) {
            cache.add(data);
            cacheEndTime = datatime;
        } else {
            stateChanged = true;
        }

        if (dataEnd) {
            preData = preprocess();
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
        plantId = data.getPlantid();
        cacheStartTime = data.getDatatime();
        cacheEndTime = cacheStartTime;
        cacheState = data.getState();
        cacheMonthBegin = DateUtil.getFirstDateOfMonth(cacheStartTime);

        cache.add(data);
    }

    private PlantDataPretreatment preprocess() {
        if (cache.size() < 2 || cacheStartTime == null || cacheState == null) {
            return null;
        }

        PlantDataPretreatment preData = new PlantDataPretreatment();
        //# 风机id
        preData.setPlantid(plantId);

        //# 数据时间
        preData.setTime(cacheStartTime);

        //# 区间时间 - ms
        preData.setDuration(cacheEndTime.getTime() - cacheStartTime.getTime());

        //# 发电状态
        preData.setPowerstate(cacheState);


        //# 数据状态 - 预处理：
        // 发电状态为故障、检修、停机时，数据状态均标记为停机
        // 发电状态为离线时，数据状态均标记为无效
        boolean isStopPowerState = (
                cacheState == PowerState.ERR.getValue() ||
                cacheState == PowerState.FIX.getValue() ||
                cacheState == PowerState.STOP.getValue());
        boolean isInvalid = (cacheState == PowerState.OFF_LINE.getValue());
        preData.setState(isInvalid ? DataState.INVALID.getValue() :
                (isStopPowerState ? DataState.STOP.getValue() : DataState.NORMAL.getValue()));

        //# 累计发电量
        double totalPower = cache.get(0).getTotalpower();
        preData.setTotalpower(totalPower);

        //# 风速风向
        preData.setAmbwindspeed((float)(cache.stream().mapToDouble(PlantDataInitial::getAmbwindspeed).average().getAsDouble()));
        preData.setAmbwinddir((float)(cache.stream().mapToDouble(PlantDataInitial::getAmbwinddir).average().getAsDouble()));

        //# 有功功率
        double avg = cache.stream().mapToDouble(PlantDataInitial::getGripower).average().getAsDouble();

        preData.setGripower((float)(cache.stream().mapToDouble(PlantDataInitial::getGripower).average().getAsDouble()));

        //# 转速
        preData.setGenrpm((float)(cache.stream().mapToDouble(PlantDataInitial::getGenrpm).average().getAsDouble()));

        //# 平均桨叶角度
        preData.setBladeangle((float)(cache.stream().mapToDouble(PlantDataInitial::getHubspe).average().getAsDouble()));


        preData.setActualpower(0.0f);
        preData.setEstimatepower(0.0f);
        preData.setReductivepower(0.0f);

        return preData;
    }
}
