package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Data
@AllArgsConstructor
public class Availability {
    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "利用率")
    @JsonProperty("value")
    private float availability;

    public Availability(String name, Float availability) {
        this.name = name;

        if (availability == null) {
            this.availability = 0;
        } else {
            this.availability = availability;
        }
    }
}
