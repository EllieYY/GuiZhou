package com.sk.gz.dao;

import com.sk.gz.entity.QuotaMonth;
import com.sk.gz.entity.QuotaMonthKey;
import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.MonthPower;
import com.sk.gz.model.power.MonthStationPower;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;
import com.sk.gz.model.power.PowerIndicators;
import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.model.power.StationPreview;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * QuotaMonthDAO继承基类
 */
@Repository
public interface QuotaMonthDAO extends MyBatisBaseDao<QuotaMonth, QuotaMonthKey> {
    List<PowerIndicators> findPowerIndicators();
    List<StationIndicators> findStationIndicators();

    List<MonthPower> findActualPowerByPlantId(@Param("plantId") int plantId);
    List<MonthStationPower> findStationMonthPower();

    List<PlantPower> findPlantPowerPreview();
    List<PlantReduction> findReducations();


    List<Availability> findTBA();
    List<Availability> findPBA();

    StationPreview findStationPreview();

    void deleteMonthStatistic(@Param("monthBegin") Date monthBegin);

}