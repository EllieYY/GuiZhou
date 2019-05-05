package com.sk.gz.dao;

import com.sk.gz.entity.Station;
import org.springframework.stereotype.Repository;

/**
 * StationDAO继承基类
 */
@Repository
public interface StationDAO extends MyBatisBaseDao<Station, Integer> {
}