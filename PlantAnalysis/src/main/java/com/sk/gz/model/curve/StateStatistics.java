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
@ApiModel(description = "按状态对点进行统计")
@Data
public class StateStatistics {
    @ApiModelProperty(value = "正常")
    @JsonProperty("normalData")
    private float normal;

    @ApiModelProperty(value = "限电")
    @JsonProperty("limitData")
    private float limit;

    @ApiModelProperty(value = "停机")
    @JsonProperty("downtimeData")
    private float downtime;

    @ApiModelProperty(value = "超发")
    @JsonProperty("extraData")
    private float extra;

    @ApiModelProperty(value = "欠发")
    @JsonProperty("arrearsData")
    private float arrears;

    @ApiModelProperty(value = "无效")
    @JsonProperty("invalidData")
    private float invalid;

}
