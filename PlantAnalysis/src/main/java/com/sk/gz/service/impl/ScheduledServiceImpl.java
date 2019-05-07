package com.sk.gz.service.impl;

import com.sk.gz.aop.ResultBeanExceptionHandler;
import com.sk.gz.dao.PlantDataPretreatmentDAO;
import com.sk.gz.entity.PlantDataInitial;
import com.sk.gz.model.converter.QuartileFilter;
import com.sk.gz.model.converter.SourceDataCache;
import com.sk.gz.service.ScheduledService;
import com.sk.gz.utils.CsvUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
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

//    @Scheduled(cron = "0 59 * * * ? ")
    @Override
    public void dataTransform(String filePath) {
        if (filePath.isEmpty() || filePath == null) {
            filePath = "testfiles/hbq-10.csv";
        }

//        //#1 read csv
//        log.info("[cron time]" + System.currentTimeMillis());
//        List<PlantDataInitial> sourceData = CsvUtil.getCsvData(filePath, PlantDataInitial.class);
//        log.info("plant#" + filePath + ", data size = " + sourceData.size() + ", " + System.currentTimeMillis());
//
//        //#2 data verify: to 10mins data
//        pretreatment(sourceData);

        //#3 filter
        filter(30210);



        //#4 calculate and save.


    }

    /** 预处理 */
    private void pretreatment(List<PlantDataInitial> sourceData) {
        sourceDataCache.initCache();
        int size = sourceData.size();
        for (int i = 0; i < size; i++) {
            boolean isDataEnd = ((i+1) == size);
            PlantDataInitial data = sourceData.get(i);

            if (sourceDataCache.addData(data, PREPROCESS_DATA_LENGTH, isDataEnd) == 0) {
                pretreatmentDataCache.add(sourceDataCache.getPreData(), isDataEnd);
            }
        }
    }

    private void filter(int plantId) {
//        quartileFilter.filt(plantId,"griPower", 25f);
        quartileFilter.filt(plantId,"ambWindSpeed", 0.5f);
    }
}
