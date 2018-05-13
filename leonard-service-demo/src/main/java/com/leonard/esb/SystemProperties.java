package com.leonard.esb;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
 * 文件名：SystemProperties.java
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/11/21 04:50 PM
 */
@Data
@Configuration
@ConfigurationProperties(locations = "classpath:application.properties", prefix = "esb.system")
public class SystemProperties {

 	@Value("${os.name}")
	private String  osName;

	@Value("${server.port}")
	private String serverPort;

	@Value("${server.address}")
	private String serverAddress;

	@Value("${esb.system.upload}")
	private String upload;

}
