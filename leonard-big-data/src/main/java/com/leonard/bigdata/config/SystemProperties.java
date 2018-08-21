package com.leonard.bigdata.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author leonard
 * @date 2018/8/20 20:15
 */
@Data
@Configuration
@ConfigurationProperties(locations = "classpath:application.properties", prefix = "leonard.system")
public class SystemProperties {

    @Value("${leonaed.system.name}")
    private String name;

}
