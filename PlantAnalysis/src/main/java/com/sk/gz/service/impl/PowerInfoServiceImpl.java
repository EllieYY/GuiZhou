package com.sk.gz.service.impl;

import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.MonthStationPower;
import com.sk.gz.model.power.PowerIndicators;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;
import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.service.PowerInfoService;
import com.sk.gz.utils.DateUtil;
import org.springframework.stereotype.Service;

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
public class PowerInfoServiceImpl implements PowerInfoService {
    @Override
    public List<PowerIndicators> getPowerIndicators() {
        Random random = new Random(47);
        List<PowerIndicators> result = new ArrayList<PowerIndicators>();
        for (int i = 0; i < 79; i++) {
            int id = i + 1;

            result.add(new PowerIndicators("风机#"+id,
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
    public List<MonthPlantPower> getPowerInfoPerMonth() {
        Random random = new Random(47);
        Date now = new Date();
        List<MonthPlantPower> result = new ArrayList<MonthPlantPower>();
        for (int i = 0; i < 79; i++) {
            int id = i + 1;

            MonthPlantPower plant = new MonthPlantPower();
            List<MonthPlantPower.MonthPower> monthPowers = new ArrayList<>();
            for (int j = 0; j < 36; j++) {
                monthPowers.add(plant.new MonthPower(
                        DateUtil.dateAddMonths(now, -j),
                        Math.abs(random.nextFloat())));
            }

            plant.setName("风机#"+id);
            plant.setPowers(monthPowers);

            result.add(plant);
        }
        return result;
    }

    @Override
    public List<Availability> getAvailabilities(String type) {
        Random random = new Random(47);

        List<Availability> result = new ArrayList<Availability>();
        for (int i = 0; i < 79; i++) {
            int id = i + 1;

            result.add(new Availability("风机#"+id, Math.abs(random.nextFloat())));
        }
        return result;
    }

    @Override
    public List<PlantPower> getPowerPreview() {
        Random random = new Random(47);

        List<PlantPower> result = new ArrayList<PlantPower>();
        for (int i = 0; i < 79; i++) {
            int id = i + 1;

            float gen = Math.abs(random.nextFloat());

            result.add(new PlantPower(
                    "风机#"+id,
                    gen,
                    gen * 0.1f));
        }
        return result;
    }

    @Override
    public List<PlantReduction> getReduction() {
        Random random = new Random(47);

        List<PlantReduction> result = new ArrayList<PlantReduction>();
        for (int i = 0; i < 79; i++) {
            int id = i + 1;

            float gen = Math.abs(random.nextFloat());

            result.add(new PlantReduction(
                    "风机#"+id,
                    gen * 0.001f,
                    gen * 0.12f,
                    gen * 0.1f));
        }
        return result;
    }
}
