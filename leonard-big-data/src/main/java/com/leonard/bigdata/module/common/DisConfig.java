package com.leonard.bigdata.module.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author leonard
 * @date 2018/8/21 15:08
 */
@Configuration
@PropertySource({"classpath:application.properties"})
public class DisConfig {

    @Autowired
    Environment env;

    /**
     * 通过key获取消息描述
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        return env.getProperty(key);
    }
}
