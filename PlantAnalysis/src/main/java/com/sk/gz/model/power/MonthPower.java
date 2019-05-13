package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/13
 */
@Data
@AllArgsConstructor
public class MonthPower {
    @JsonProperty("time")
    Date month;

    @JsonProperty("value")
    float power;
}
