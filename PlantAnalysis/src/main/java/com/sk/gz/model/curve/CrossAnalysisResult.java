package com.sk.gz.model.curve;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/23
 */
@ApiModel(description = "交叉分析结果")
@Data
public class CrossAnalysisResult {
    @JsonProperty("points")
    private List<CrossPoint> points;

    @JsonProperty("density")
    private List<HistogramPoint> density;
}
