package com.sk.gz.model.param;

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
@ApiModel(description = "功率曲线查询参数")
@Data
public class PowerCurveParam {
    @ApiModelProperty(value = "风机id")
    @JsonProperty("id")
    private int id;

    @ApiModelProperty(value = "曲线分析开始时间")
    @JsonProperty("startTime")
    private Date start;

    @ApiModelProperty(value = "曲线分析结束时间")
    @JsonProperty("endTime")
    private Date end;
}
