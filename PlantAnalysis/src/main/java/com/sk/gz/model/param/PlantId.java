package com.sk.gz.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Data
public class PlantId {
    @ApiModelProperty(value = "风机id")
    @JsonProperty("id")
    private int id;

}
