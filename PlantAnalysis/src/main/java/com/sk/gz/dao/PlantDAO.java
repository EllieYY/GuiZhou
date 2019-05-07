package com.sk.gz.dao;

import com.sk.gz.entity.Plant;
import com.sk.gz.model.param.PlantLabel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PlantDAO继承基类
 */
@Repository
public interface PlantDAO extends MyBatisBaseDao<Plant, Integer> {
    List<PlantLabel> findAllIndexInfo();
}