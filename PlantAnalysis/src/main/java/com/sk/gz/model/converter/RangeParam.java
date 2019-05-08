package com.sk.gz.model.converter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/7
 */
@Data
@AllArgsConstructor
public class RangeParam {
    /** 用来选区数据的列 */
    private String filterColumn;

    /** 目标数据列 */
    private String targetColumn;

    /** 风机标识 */
    private int plantId;

    /** 状态过滤值 */
    private int validState;

    /** 值下限 */
    private float rangeMin;

    /** 低于下限标记状态 */
    private int minState;

    /** 值上限 */
    private float rangeMax;

    /** 高于上限标记状态 */
    private int maxState;

    /** 原始值的范围 */
    private float valueMin;
    private float valueMax;

}
