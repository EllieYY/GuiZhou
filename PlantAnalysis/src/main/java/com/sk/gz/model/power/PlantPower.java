package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel(description = "风机发电量信息总览")
@Data
@AllArgsConstructor
public class PlantPower {
    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "实际发电量")
    @JsonProperty("power")
    private float power;

    @ApiModelProperty(value = "折减电量")
    @JsonProperty("reduction")
    private float reduction;
}
