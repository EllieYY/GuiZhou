package com.sk.gz.model.converter;

import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/14
 */
@Data
public class DataTypeParam {
    /** 数据状态 */
    private int normalState = DataState.NORMAL.getValue();
    private int invalidState = DataState.INVALID.getValue();
    private int stopState = DataState.STOP.getValue();
    private int limitState = DataState.CURTAILMENT.getValue();
    private int underState = DataState.UNDER.getValue();
    private int overState = DataState.OVER.getValue();
}
