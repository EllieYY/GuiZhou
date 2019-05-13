package com.sk.gz.dao;

import com.sk.gz.entity.QuotaMonth;
import com.sk.gz.entity.QuotaMonthKey;
import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.MonthPower;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;
import com.sk.gz.model.power.PowerIndicators;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * QuotaMonthDAO继承基类
 */
@Repository
public interface QuotaMonthDAO extends MyBatisBaseDao<QuotaMonth, QuotaMonthKey> {
    List<PowerIndicators> findSumById();

    List<MonthPower> findActualPowerByPlantId(@Param("plantId") int plantId);

    List<PlantPower> findPlantPowerPreview();
    List<PlantReduction> findReducations();


    List<Availability> findTBA();
    List<Availability> findPBA();

}