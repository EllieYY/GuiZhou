package com.sk.gz.model.curve;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Data
@ApiModel(description = "功率曲线")
public class StationPowerCurve {
    @ApiModelProperty(value = "设计功率曲线")
    @JsonProperty("designCurve")
    private List<CurvePoint> referenceCurve;


    @ApiModelProperty(value = "实际功率曲线")
    @JsonProperty("assessmentCurve")
    private List<CurvePoint> practicalCurve;


    @ApiModelProperty(value = "源数据点")
    @JsonProperty("points")
    private List<SourcePoint> sourcePoints;

    @ApiModelProperty(value = "各状态点的比例")
    @JsonProperty("statistics")
    private StateStatistics stateStatistics;
}
