package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel("风机逐月统计")
@Data
@NoArgsConstructor
public class MonthPlantPower {

    @Data
    public class MonthPower {
        @JsonProperty("time")
        Date month;

        @JsonProperty("value")
        float power;

        public MonthPower(Date month, float power) {
            this.month = month;
            this.power = power;
        }
    }

    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "每月发电量数据")
    @JsonProperty("data")
    private List<MonthPower> powers;

    public MonthPlantPower(String name, List<MonthPower> powers) {
        this.name = name;
        this.powers = powers;
    }
}
