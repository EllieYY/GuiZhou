package com.sk.gz.model.curve;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/23
 */
@ApiModel(description = "直方图展示的参数")
@Data
public class HistogramPoint {
    @ApiModelProperty(value = "刻度")
    @JsonProperty("scale")
    private float scale;

    @ApiModelProperty(value = "值")
    @JsonProperty("value")
    private float value;
}
