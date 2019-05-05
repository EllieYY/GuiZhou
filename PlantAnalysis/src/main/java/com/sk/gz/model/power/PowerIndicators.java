package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel(description = "风机电量信息")
@Data
public class PowerIndicators {
    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "实际发电量")
    @JsonProperty("power")
    private float actualPower;

    @ApiModelProperty(value = "应发电量")
    @JsonProperty("academicPower")
    private float academicPower;

    @ApiModelProperty(value = "折减电量")
    @JsonProperty("totalReduction")
    private float totalReduction;

    @ApiModelProperty(value = "停机折减")
    @JsonProperty("downtimeReduction")
    private float downtimeReduction;

    @ApiModelProperty(value = "限电折减")
    @JsonProperty("limitReduction")
    private float limitReduction;

    @ApiModelProperty(value = "未知折减")
    @JsonProperty("unknownReduction")
    private float unknownReduction;

    @ApiModelProperty(value = "时间可利用率")
    @JsonProperty("tba")
    private float tba;

    @ApiModelProperty(value = "电量可利用率")
    @JsonProperty("pba")
    private float pba;

}
