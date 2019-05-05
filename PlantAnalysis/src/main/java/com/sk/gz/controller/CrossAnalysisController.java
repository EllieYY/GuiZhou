package com.sk.gz.controller;

import com.sk.gz.model.curve.CrossAnalysisResult;
import com.sk.gz.model.curve.PlantPowerCurve;
import com.sk.gz.model.param.CrossAnalysisParam;
import com.sk.gz.model.param.PowerCurveParam;
import com.sk.gz.model.result.ResultBean;
import com.sk.gz.model.result.ResultBeanUtil;
import com.sk.gz.service.StationInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/23
 */
@Api(description = "交叉分析")
@RestController
public class CrossAnalysisController {
    @Resource
    StationInfoService stationInfoService;

    @ApiOperation(value = "交叉分析")
    @RequestMapping(value = "/crossAnalysis", method = {RequestMethod.POST})
    public ResultBean<CrossAnalysisResult> crossAnaysis(@RequestBody CrossAnalysisParam param) {
        return ResultBeanUtil.makeOkResp(stationInfoService.doCrossAnaysis(param));
    }

    @ApiOperation(value = "功率曲线查询")
    @RequestMapping(value = "/crossAnalysis/curve", method = {RequestMethod.POST})
    public ResultBean<List<PlantPowerCurve>> getPowerCurveByTime(@RequestBody List<PowerCurveParam> param) {
        return ResultBeanUtil.makeOkResp(stationInfoService.powerCurveAnalysis(param));
    }

}
