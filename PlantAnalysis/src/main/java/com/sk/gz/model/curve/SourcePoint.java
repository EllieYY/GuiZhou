package com.sk.gz.model.curve;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel(description = "原始数据点")
@Data
public class SourcePoint {
    @ApiModelProperty(value = "风速")
    @JsonProperty("speed")
    private float windSpeed;

    @ApiModelProperty(value = "功率")
    @JsonProperty("power")
    private float power;

    @ApiModelProperty(value = "状态")
    @JsonProperty("state")
    private int status;
}
