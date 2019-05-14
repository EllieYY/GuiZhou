package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel(description = "电厂整体概况")
@Data
public class StationPreview {
    @ApiModelProperty(value = "名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "电厂数据开始时间")
    @JsonProperty("startTime")
    private Date startTime;

    @ApiModelProperty(value = "电厂数据结束时间")
    @JsonProperty("endTime")
    private Date endTime;

    @ApiModelProperty(value = "实际发电量")
    @JsonProperty("power")
    private float powerGeneration;

    @ApiModelProperty(value = "折减电量")
    @JsonProperty("reduction")
    private float reduction;

    @ApiModelProperty(value = "折减率")
    @JsonProperty("reductionRatio")
    private float reductionRatio;

    @ApiModelProperty(value = "平均风速")
    @JsonProperty("speedAvg")
    private float averageWindSpeed;

    @ApiModelProperty(value = "时间可利用率")
    @JsonProperty("tba")
    private float tba;

    @ApiModelProperty(value = "电量可利用率")
    @JsonProperty("pba")
    private float pba;
}
