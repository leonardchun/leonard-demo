package com.leonard.demo.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/*
 * 文件名：SystemProperties
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2018-05-21 04:14 PM
 */
@ConfigurationProperties(prefix = "demo.system")
@Data
public class SystemProperties {

    @Value("${spring.application.name}")
    String applicationName;
}
