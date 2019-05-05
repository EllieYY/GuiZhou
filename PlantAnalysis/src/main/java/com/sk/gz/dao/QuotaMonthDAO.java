package com.sk.gz.dao;

import com.sk.gz.entity.QuotaMonth;
import com.sk.gz.entity.QuotaMonthKey;
import org.springframework.stereotype.Repository;

/**
 * QuotaMonthDAO继承基类
 */
@Repository
public interface QuotaMonthDAO extends MyBatisBaseDao<QuotaMonth, QuotaMonthKey> {
}