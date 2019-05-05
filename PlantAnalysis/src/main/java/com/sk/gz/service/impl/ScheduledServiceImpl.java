package com.sk.gz.service.impl;

import com.sk.gz.entity.PlantDataInitial;
import com.sk.gz.service.ScheduledService;
import com.sk.gz.utils.CsvUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/28
 */
@Service
@EnableScheduling
public class ScheduledServiceImpl implements ScheduledService {
    @Override
    @Scheduled(cron = "0/5 * * * * *")
    public void dataTransform() {
        //#1 read csv
        System.out.println("===== cron ====" + System.currentTimeMillis());
        List<PlantDataInitial> sourceData = CsvUtil.getCsvData("testfiles/hbq-9.csv", PlantDataInitial.class);
        System.out.println("size = " + sourceData.size() + ", " + System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            System.out.println(sourceData.get(i));
        }


        //#2 data verify: to 10mins data





        //#3 calculate and save.


    }
}
