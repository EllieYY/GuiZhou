package com.sk.gz.dao;

import com.sk.gz.entity.PracticalPowerCurve;
import com.sk.gz.model.curve.CurvePoint;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PracticalPowerCurveDAO继承基类
 */
@Repository
public interface DesignPowerCurveDAO extends MyBatisBaseDao<PracticalPowerCurve, Integer> {
    List<CurvePoint> findByTypeAndWindASC(@Param("plantType") int type);
}