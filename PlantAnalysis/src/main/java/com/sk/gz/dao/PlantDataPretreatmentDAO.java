package com.sk.gz.dao;

import com.sk.gz.entity.PlantDataPretreatment;
import com.sk.gz.entity.PlantDataPretreatmentKey;
import com.sk.gz.model.converter.RangeParam;
import com.sk.gz.model.curve.CurvePoint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PlantDataPretreatmentDAO继承基类
 */
@Repository
public interface PlantDataPretreatmentDAO extends MyBatisBaseDao<PlantDataPretreatment, PlantDataPretreatmentKey> {
    int batchInsert(List<PlantDataPretreatment> data);

    float findMaxByColumn(@Param("column") String column, @Param("plantId") int plantId);

    List<Float> findByColumnAndRange(RangeParam param);

    void updateStateByRange(RangeParam param);

    CurvePoint findAvgByColumnAndRange(RangeParam param);
}