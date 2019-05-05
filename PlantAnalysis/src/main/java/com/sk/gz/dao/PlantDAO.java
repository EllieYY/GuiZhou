package com.sk.gz.dao;

import com.sk.gz.entity.Plant;
import org.springframework.stereotype.Repository;

/**
 * PlantDAO继承基类
 */
@Repository
public interface PlantDAO extends MyBatisBaseDao<Plant, Integer> {
}