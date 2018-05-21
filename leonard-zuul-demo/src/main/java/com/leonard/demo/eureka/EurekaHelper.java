package com.leonard.demo.eureka;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

import java.util.List;

/*
 * 文件名：EurekaHelper
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈Eureka 公共方法〉
 * 创建人： wanghaichun
 * 创建时间：2018-05-21 05:29 PM
 */
@Slf4j
public class EurekaHelper {

    private SpringClientFactory springClientFactory;

    /**
     * 根据指定的服务名，从注册中心获取服务的地址和端口
     *
     * @param target
     * @return eg:192.168.30.216:8081
     */
    public String getServiceHostPort(String target) {
        if (!StringUtils.isEmpty(target)) {
            ILoadBalancer loadBalancer = springClientFactory.getLoadBalancer(target);
            List<Server> services = loadBalancer.getReachableServers();
            if (services.size() > 0) {
                Server s = services.get(0);
                return s.getHostPort();
            }
        }
        return null;
    }
}
