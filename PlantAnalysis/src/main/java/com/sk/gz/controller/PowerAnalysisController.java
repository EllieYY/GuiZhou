package com.sk.gz.controller;

import com.sk.gz.dao.PlantDAO;
import com.sk.gz.model.power.Availability;
import com.sk.gz.model.power.BAType;
import com.sk.gz.model.power.MonthPlantPower;
import com.sk.gz.model.power.PowerIndicators;
import com.sk.gz.model.power.PlantPower;
import com.sk.gz.model.power.PlantReduction;
import com.sk.gz.model.result.ResultBean;
import com.sk.gz.model.result.ResultBeanUtil;
import com.sk.gz.service.PowerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/22
 */
@Api(description = "发电量分析")
@RestController
public class PowerAnalysisController {
    @Resource
    PowerInfoService powerInfoService;

    @ApiOperation(value = "指标统计")
    @RequestMapping(value = "/power/indicators", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<PowerIndicators>> getPlantPowerDetails() {
        return ResultBeanUtil.makeOkResp(powerInfoService.getPowerIndicators());
    }

    @ApiOperation(value = "风机逐月统计")
    @RequestMapping(value = "/plant/power/month", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<MonthPlantPower>> getPlantPowerInfoPerMonth() {
        return ResultBeanUtil.makeOkResp(powerInfoService.getPowerInfoPerMonth());
    }

    @ApiOperation(value = "利用率统计")
    @RequestMapping(value = "/station/power/tba", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<Availability>> getPlantTBA() {
        return ResultBeanUtil.makeOkResp(powerInfoService.getAvailabilities(BAType.TBA.getValue()));
    }
    @ApiOperation(value = "利用率统计")
    @RequestMapping(value = "/station/power/pba", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<Availability>> getPlantPBA() {
        return ResultBeanUtil.makeOkResp(powerInfoService.getAvailabilities(BAType.PBA.getValue()));
    }

    @ApiOperation(value = "发电量分布")
    @RequestMapping(value = "/station/power/plant", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<PlantPower>> getPlantPowerPreview() {
        return ResultBeanUtil.makeOkResp(powerInfoService.getPowerPreview());
    }

    @ApiOperation(value = "发电量折减信息")
    @RequestMapping(value = "/station/power/reduction", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<PlantReduction>> getPlantPower() {
        return ResultBeanUtil.makeOkResp(powerInfoService.getReduction());
    }
}
