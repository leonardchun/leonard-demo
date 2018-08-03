package com.leonard.demo.datasource;

import java.lang.annotation.*;

/**
 * 在方法上使用，用于指定使用哪个数据源
 *
 * @author leonard
 * @date 2018/5/22 0:11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    //ddddd是的撒多
    String name();
}
