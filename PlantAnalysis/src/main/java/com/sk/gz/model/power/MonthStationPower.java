package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel(description = "电量信息")
@Data
public class MonthStationPower {
    @ApiModelProperty(value = "月份信息")
    @JsonProperty("time")
    private Date month;

    @ApiModelProperty(value = "实际发电量")
    @JsonProperty("power")
    private float power;

    @ApiModelProperty(value = "折减电量")
    @JsonProperty("reduction")
    private float reduction;
}
