package com.sk.gz.model.converter;

import com.sk.gz.utils.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/10
 */
@Data
public class MonthQuotaParam {
    /** 用来判断插入还是更新 */
    private int count;

    /** 过滤数据的时间范围 */
    private Date filtTimeBegin;
    private Date filtTimeEnd;

    /** 数据状态 */
    private int normalState = DataState.NORMAL.getValue();
    private int invalidState = DataState.INVALID.getValue();
    private int stopState = DataState.STOP.getValue();
    private int limitState = DataState.CURTAILMENT.getValue();
    private int underState = DataState.UNDER.getValue();
    private int overState = DataState.OVER.getValue();

    /** 月初时间 - 无法使用mysql进行计算，需外部输入 */
    private Date monthBegin;

    /** 根据过滤的时间范围结束点来计算当月有效天数 */
    private int validDays;

    public MonthQuotaParam(Date filtTimeBegin, Date filtTimeEnd) {
        this.filtTimeBegin = filtTimeBegin;
        this.filtTimeEnd = filtTimeEnd;

        this.monthBegin = DateUtil.getFirstDateOfMonth(filtTimeBegin);
        int curMonthDays = DateUtil.getDaysOfMonth(monthBegin);
        int dayInMonth = Math.abs(DateUtil.daysBetweenDate(monthBegin, filtTimeEnd));
        this.validDays = dayInMonth > curMonthDays ? curMonthDays : dayInMonth;
    }
}
