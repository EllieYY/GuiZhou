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
@ApiModel(description = "风机指标信息")
@Data
@AllArgsConstructor
public class StationIndicators {
    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "风机id")
    @JsonProperty("id")
    private int id;

    @ApiModelProperty(value = "有效数据天数")
    @JsonProperty("validDataDays")
    private int dataValidDays;

    @ApiModelProperty(value = "额定功率")
    @JsonProperty("ratedPower")
    private double powerRating;

    @ApiModelProperty(value = "发电量")
    @JsonProperty("power")
    private double power;

    @ApiModelProperty(value = "折减系数")
    @JsonProperty("reductionFactor")
    private double reductionFactor;

    @ApiModelProperty(value = "容量系数")
    @JsonProperty("capacityFactor")
    private double capacityFactor;

    @ApiModelProperty(value = "平均日发电量")
    @JsonProperty("powerAvg")
    private double dailyAveragePower;

    @ApiModelProperty(value = "平均风速")
    @JsonProperty("speedAvg")
    private double averageWindSpeed;

    @ApiModelProperty(value = "时间可利用率")
    @JsonProperty("tba")
    private double tba;

    @ApiModelProperty(value = "电量可利用率")
    @JsonProperty("pba")
    private double pba;


}
