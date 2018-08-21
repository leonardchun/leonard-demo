package com.leonard.bigdata.module.web;

import com.leonard.bigdata.config.SystemProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leonard
 * @date 2018/8/20 21:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/api")
@Api(value = "接口管理", description = "接口管理")
public class HelloWorld {

    @Autowired
    private SystemProperties systemProperties;

    @RequestMapping(value = "/getSystemProperties", method = RequestMethod.GET)
    @ApiOperation(value = "获取配置文件值", notes = "获取配置文件值")
    public String getWebserviceUrl() {
        return systemProperties.getName();
    }

}
