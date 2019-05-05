package com.sk.gz.model.power;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@ApiModel(description = "风机电量折减信息")
@Data
public class PlantReduction {
    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "停机折减")
    @JsonProperty("downtimeReduction")
    private float downtimeReduction;

    @ApiModelProperty(value = "限电折减")
    @JsonProperty("limitReduction")
    private float limitReduction;

    @ApiModelProperty(value = "未知折减")
    @JsonProperty("unknownReduction")
    private float unknownReduction;
}
