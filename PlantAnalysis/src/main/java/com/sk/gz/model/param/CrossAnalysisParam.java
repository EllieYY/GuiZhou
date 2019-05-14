package com.sk.gz.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private int id;

    @ApiModelProperty(value = "散点图指标")
    @JsonProperty("x")
    private int x;

    @ApiModelProperty(value = "散点图指标")
    @JsonProperty("y")
    private int y;

    @ApiModelProperty(value = "直方图指标")
    @JsonProperty("densityNum")
    private int densityNum;
}
