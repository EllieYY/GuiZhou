package com.sk.gz.service;

import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.PowerIndicators;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
public interface PowerInfoService {

    List<PowerIndicators> getPowerIndicators();

    List<MonthPlantPower> getPowerInfoPerMonth();

    List<Availability> getAvailabilities(String type);

    List<PlantPower> getPowerPreview();

    List<PlantReduction> getReduction();
}
