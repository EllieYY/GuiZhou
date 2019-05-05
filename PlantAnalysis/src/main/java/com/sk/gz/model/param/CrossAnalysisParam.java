package com.sk.gz.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/23
 */
@ApiModel(description = "交叉分析参数")
@Data
public class CrossAnalysisParam {
    @ApiModelProperty(value = "风机id")
    private int id;

    @ApiModelProperty(value = "散点图指标")
    private int x;

    @ApiModelProperty(value = "散点图指标")
    private int y;

    @ApiModelProperty(value = "直方图指标")
    private int density;
}
