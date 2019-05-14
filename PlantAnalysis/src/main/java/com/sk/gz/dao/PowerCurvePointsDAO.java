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
    int batchInsert(@Param("plantId") int plantId, @Param("list")List<CurvePoint> points, @Param("type") int type);

    int deleteByType(@Param("plantId") int plantId, @Param("type") int type);

    List<CurvePoint> findByPlantIdAndTypeAndWindASC(@Param("plantId") int plantId, @Param("type") int type);

}