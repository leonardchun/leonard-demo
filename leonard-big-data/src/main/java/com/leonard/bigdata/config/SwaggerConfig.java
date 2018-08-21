package com.leonard.bigdata.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/*
 * 文件名：SwaggerConfig.java
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈Swagger配置〉
 * 创建人： wanghaichun
 * 创建时间：2017/08/18 04:39 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket selfCareApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("My-Swagger")
                .apiInfo(selfCareApiInfo())
                .select()
                .paths(selfCareApiPaths())
                .build();
    }

    private ApiInfo selfCareApiInfo() {
        return new ApiInfoBuilder()
                .title("Demo Swagger API")
                .version("2.0.0-SNAPSHOT")
                .build();
    }

    private Predicate<String> selfCareApiPaths() {
        //noinspection unchecked
        return or(
                regex("/api.*")
        );
    }
}