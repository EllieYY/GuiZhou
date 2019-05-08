package com.sk.gz.model.converter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/8
 */
@Data
@AllArgsConstructor
public class FilterParam {
    /** 用来限制范围的列 */
    private String scaleColumn;
    private float scale;

    /** 进行分析的列 */
    private String targetColumn;

    /** 是否进行上下限过滤， -1-仅下限有效， 0-上下限均有效， 1-仅上限有效， 2-上下限均无效 */
    private int rangeValidFlag;
}
