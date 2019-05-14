package com.sk.gz.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantLabel {
    @ApiModelProperty(value = "风机id")
    @JsonProperty("id")
    private int id;

    @ApiModelProperty(value = "风机名称")
    @JsonProperty("name")
    private String name;
}
