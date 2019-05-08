package com.sk.gz.model.converter;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterResult extends BaseRowModel {
    @ExcelProperty(value = "范围",index = 0)
    private String range;

    @ExcelProperty(value = "最小值", index = 1)
    private float dataMin;

    @ExcelProperty(value = "最大值", index = 2)
    private float dataMax;

    @ExcelProperty(value = "四分位1", index = 5)
    private float index1;

    @ExcelProperty(value = "四分位3", index = 6)
    private float index3;

    @ExcelProperty(value = "IQR", index = 7)
    private float IQR;

    @ExcelProperty(value = "FL", index = 3)
    private float FL;

    @ExcelProperty(value = "FU", index = 4)
    private float FU;
}
