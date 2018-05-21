package com.leonard.demo.eureka;

import com.leonard.demo.common.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * 文件名：TestController
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2018-05-21 03:35 PM
 */
@RestController
@EnableEurekaClient
public class TestController {

    @Autowired
    private SystemProperties systemProperties;

    private EurekaHelper eurekaHelper;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        String  applicationName = systemProperties.getApplicationName();
        String ipAndPort = eurekaHelper.getServiceHostPort(applicationName);
        return "Hello Leonard!" + applicationName + "IP和端口 " + ipAndPort;
    }
}
