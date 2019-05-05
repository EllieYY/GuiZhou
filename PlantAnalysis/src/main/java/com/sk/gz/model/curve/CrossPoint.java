package com.sk.gz.model.curve;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/23
 */
@ApiModel(description = "交叉分析结果点")
@Data
public class CrossPoint {
    @ApiModelProperty(value = "分析指标1")
    @JsonProperty("x")
    private float x;

    @ApiModelProperty(value = "分析指标2")
    @JsonProperty("y")
    private float y;

    @ApiModelProperty(value = "状态")
    @JsonProperty("state")
    private int state;

    @ApiModelProperty(value = "时间")
    @JsonProperty("time")
    private Date time;
}
