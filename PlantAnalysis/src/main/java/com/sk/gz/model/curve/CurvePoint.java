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
@Data
@ApiModel(description = "功率曲线点")
public class CurvePoint {
    @ApiModelProperty(value = "风速")
    @JsonProperty("speed")
    float windSpeed;

    @ApiModelProperty(value = "功率")
    @JsonProperty("power")
    float power;
}
