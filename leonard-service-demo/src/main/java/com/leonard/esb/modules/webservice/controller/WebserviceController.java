package com.leonard.esb.modules.webservice.controller;

import com.leonard.esb.SystemProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * 文件名：WebserviceController
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:09 .
 */
@Slf4j
@RestController
@Api(value = "Webservice管理", description = "Webservice管理")
public class WebserviceController {

    @Autowired
    private SystemProperties systemProperties;

    @RequestMapping(value = "/Webservice", method = RequestMethod.GET)
    @ApiOperation(value = "获取Webservice接口路径", notes = "获取Webservice接口路径")
    public String getWebserviceUrl(){

        return systemProperties.getServerAddress() + ":" + systemProperties.getServerPort() + "/services";
    }
}
