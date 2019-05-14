package com.sk.gz.service.impl;


import com.sk.gz.dao.PlantDAO;
import com.sk.gz.dao.QuotaMonthDAO;
import com.sk.gz.model.param.PlantLabel;
import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.BAType;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.MonthPower;
import com.sk.gz.model.power.PowerIndicators;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;
import com.sk.gz.service.PowerInfoService;
import com.sk.gz.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description :
 * @Author : Ellie
 * @De : 2019/4/22
 */
@Service
public class PowerInfoServiceImpl implements PowerInfoService {
    @Resource
    QuotaMonthDAO quotaMonthDAO;

    @Resource
    PlantDAO plantDAO;


    /** 电量关键指标统计 - 风机月电量信息累加 */
    @Override
    public List<PowerIndicators> getPowerIndicators() {
        return quotaMonthDAO.findPowerIndicators();

//        Random random = new Random(47);
//        List<PowerIndicators> result = new ArrayList<PowerIndicators>();
//        for (int i = 0; i < 79; i++) {
//            int id = i + 1;
//
//            result.add(new PowerIndicators("风机#"+id,
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

    /** 风机电量信息 - 按月统计 */
    @Override
    public List<MonthPlantPower> getPowerInfoPerMonth() {
        List<MonthPlantPower> result = new ArrayList<MonthPlantPower>();

        List<PlantLabel> plants = plantDAO.findAllIndexInfo();
        for (PlantLabel plant : plants) {
            int plantId = plant.getId();
            List<MonthPower> monthPowers = quotaMonthDAO.findActualPowerByPlantId(plantId);
            result.add(new MonthPlantPower(plant.getName(), monthPowers));
        }

//        Random random = new Random(47);
//        Date now = new Date();
//
//        for (int i = 0; i < 79; i++) {
//            int id = i + 1;
//
//            MonthPlantPower plant = new MonthPlantPower();
//            List<MonthPlantPower.MonthPower> monthPowers = new ArrayList<>();
//            for (int j = 0; j < 36; j++) {
//                monthPowers.add(plant.new MonthPower(
//                        DateUtil.dateAddMonths(now, -j),
//                        Math.abs(random.nextFloat())));
//            }
//
//            plant.setName("风机#"+id);
//            plant.setPowers(monthPowers);
//
//            result.add(plant);
//        }
        return result;
    }

    /** 统计利用率 */
    @Override
    public List<Availability> getAvailabilities(int type) {
        List<Availability> result = new ArrayList<Availability>();
        if (type == BAType.TBA.getValue()) {
            return quotaMonthDAO.findTBA();
        } else if (type == BAType.PBA.getValue()) {
            return quotaMonthDAO.findPBA();
        }

//        Random random = new Random(47);
//        for (int i = 0; i < 79; i++) {
//            int id = i + 1;
//
//            result.add(new Availability("风机#"+id, Math.abs(random.nextFloat())));
//        }
        return result;
    }

    /** 电量预览 */
    @Override
    public List<PlantPower> getPowerPreview() {
        return quotaMonthDAO.findPlantPowerPreview();

//        List<PlantPower> result = new ArrayList<PlantPower>();
//        Random random = new Random(47);
//        for (int i = 0; i < 79; i++) {
//            int id = i + 1;
//
//            float gen = Math.abs(random.nextFloat());
//
//            result.add(new PlantPower(
//                    "风机#"+id,
//                    gen,
//                    gen * 0.1f));
//        }
//        return result;
    }

    /** 折减详情 */
    @Override
    public List<PlantReduction> getReduction() {
        return quotaMonthDAO.findReducations();
//        Random random = new Random(47);
//
//        List<PlantReduction> result = new ArrayList<PlantReduction>();
//        for (int i = 0; i < 79; i++) {
//            int id = i + 1;
//
//            float gen = Math.abs(random.nextFloat());
//
//            result.add(new PlantReduction(
//                    "风机#"+id,
//                    gen * 0.001f,
//                    gen * 0.12f,
//                    gen * 0.1f));
//        }
//        return result;
    }
}
