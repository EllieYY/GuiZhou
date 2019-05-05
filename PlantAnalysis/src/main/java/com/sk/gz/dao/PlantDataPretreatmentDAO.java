package com.sk.gz.dao;

import com.sk.gz.entity.PlantDataPretreatment;
import com.sk.gz.entity.PlantDataPretreatmentKey;
import org.springframework.stereotype.Repository;

/**
 * PlantDataPretreatmentDAO继承基类
 */
@Repository
public interface PlantDataPretreatmentDAO extends MyBatisBaseDao<PlantDataPretreatment, PlantDataPretreatmentKey> {
}