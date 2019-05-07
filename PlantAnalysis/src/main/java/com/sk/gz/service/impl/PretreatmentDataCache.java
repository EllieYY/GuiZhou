package com.sk.gz.service.impl;

import com.sk.gz.dao.PlantDataPretreatmentDAO;
import com.sk.gz.entity.PlantDataPretreatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PretreatmentDataCache {
    @Autowired
    private PlantDataPretreatmentDAO plantDataPretreatmentDAO;

    private static final int BATCH_SIZE = 100;
    private List<PlantDataPretreatment> cache = new ArrayList<PlantDataPretreatment>();

    public void add(PlantDataPretreatment data, boolean isDataEnd) {
        if (null == data) {
            return;
        }

        cache.add(data);

        // batch insert
        if (cache.size() >= BATCH_SIZE || isDataEnd) {
            plantDataPretreatmentDAO.batchInsert(cache);
            cache.clear();
        }
    }
}
