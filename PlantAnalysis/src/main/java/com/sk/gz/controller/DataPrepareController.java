package com.sk.gz.controller;

import com.sk.gz.model.result.ResultBean;
import com.sk.gz.model.result.ResultBeanUtil;
import com.sk.gz.service.ScheduledService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/7
 */
@Api(description = "数据准备")
@RestController
public class DataPrepareController {
    @Resource
    private ScheduledService scheduledService;

    @ApiOperation(value = "历史数据生成")
    @RequestMapping(value = "/data/history", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<String> getPlantQuotas(@RequestParam("path") String path) {
        scheduledService.dataTransform(path);
        return ResultBeanUtil.makeOkResp();
    }
}
