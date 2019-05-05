package com.sk.gz.model.curve;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/23
 */
@ApiModel(description = "风机功率曲线")
@Data
public class PlantPowerCurve {
    @ApiModelProperty(value = "风机id")
    @JsonProperty("id")
    private int id;

    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "功率曲线点")
    @JsonProperty("points")
    private List<CurvePoint> points;
}
