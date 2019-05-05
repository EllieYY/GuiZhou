package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel("风机逐月统计")
@Data
public class MonthPlantPower {

    @Data
    class MonthPower {
        @JsonProperty("time")
        Date month;

        @JsonProperty("value")
        float power;
    }

    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "每月发电量数据")
    @JsonProperty("data")
    private List<MonthPower> powers;
}
