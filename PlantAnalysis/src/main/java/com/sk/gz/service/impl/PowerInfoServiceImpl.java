package com.sk.gz.service.impl;

import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.PowerIndicators;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;
import com.sk.gz.service.PowerInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Service
public class PowerInfoServiceImpl implements PowerInfoService {
    @Override
    public List<PowerIndicators> getPowerIndicators() {
        return null;
    }

    @Override
    public List<MonthPlantPower> getPowerInfoPerMonth() {
        return null;
    }

    @Override
    public List<Availability> getAvailabilities(String type) {
        return null;
    }

    @Override
    public List<PlantPower> getPowerPreview() {
        return null;
    }

    @Override
    public List<PlantReduction> getReduction() {
        return null;
    }
}
