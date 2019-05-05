package com.sk.gz.controller;

import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.model.curve.StationPowerCurve;
import com.sk.gz.model.result.ResultBean;
import com.sk.gz.model.result.ResultBeanUtil;
import com.sk.gz.model.power.MonthStationPower;
import com.sk.gz.model.power.StationPreview;
import com.sk.gz.model.param.PlantId;
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
 * @Date : 2019/4/22
 */
@Api(description = "首页")
@RestController
public class HomePageController {
    @Resource
    StationInfoService stationInfoService;

    @ApiOperation(value = "风机指标")
    @RequestMapping(value = "/station/indicators", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<StationIndicators>> getPlantQuotas() {
        return ResultBeanUtil.makeOkResp(stationInfoService.getIndcators());
    }

    @ApiOperation(value = "风机风功率曲线")
    @RequestMapping(value = "/power/curve", method = {RequestMethod.POST})
    public ResultBean<StationPowerCurve> getPowerCurve(@RequestBody PlantId param) {
        int id = param.getId();
        return ResultBeanUtil.makeOkResp(stationInfoService.getPowerCurveById(id));
    }

    @ApiOperation(value = "风电厂逐月统计")
    @RequestMapping(value = "/station/power/month", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<List<MonthStationPower>> getStationPowerByMonth() {
        return ResultBeanUtil.makeOkResp(stationInfoService.getPowerInfoPerMonth());
    }

    @ApiOperation(value = "风电厂统计")
    @RequestMapping(value = "/station/preview", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<StationPreview> getStationPreviewInfo() {
        return ResultBeanUtil.makeOkResp(stationInfoService.getPreviewInfo());
    }
}
