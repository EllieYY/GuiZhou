package com.sk.gz.dao;

import com.sk.gz.entity.PowerCurvePoints;
import com.sk.gz.model.curve.CurvePoint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PowerCurvePointsDAO继承基类
 */
@Repository
public interface PowerCurvePointsDAO extends MyBatisBaseDao<PowerCurvePoints, Integer> {
    int batchInsert(@Param("plantId") int plantId, @Param("list")List<CurvePoint> points);

    int deleteByPlantId(@Param("plantId") int plantId);

    List<CurvePoint> findByPlantIdAndWindASC(@Param("plantId") int plantId);

}