package com.sk.gz.dao;

import com.sk.gz.entity.PowerCurvePoints;
import org.springframework.stereotype.Repository;

/**
 * PowerCurvePointsDAO继承基类
 */
@Repository
public interface PowerCurvePointsDAO extends MyBatisBaseDao<PowerCurvePoints, Integer> {
}