/*

package com.leonard.bigdata.config;

import com.leonard.bigdata.module.common.DisConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class PhoenixDataSourceConfig {

    @Autowired
    private SystemProperties systemProperties;

    @Autowired
    private DisConfig disConfig;

    */
/**
     * phoenix 配置
     *
     * @return
     *//*

    @Lazy
    @Bean("phoenixNamedJdbcTemplate")
    public NamedParameterJdbcTemplate phoenixNamedParameterJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(phoenixDatasource());
        return namedParameterJdbcTemplate;
    }

    public DataSource phoenixDatasource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(disConfig.getProperty("phoenix.datasource.driverClassName"));
        dataSource.setUrl(disConfig.getProperty("phoenix.datasource.url"));
        dataSource.setUsername(disConfig.getProperty("phoenix.datasource.username"));
        dataSource.setPassword(disConfig.getProperty("phoenix.datasource.password"));
        dataSource.setMaxActive(Integer.parseInt(disConfig.getProperty("phoenix.datasource.maxActive")));
        dataSource.setMaxIdle(Integer.parseInt(disConfig.getProperty("phoenix.datasource.maxIdle")));
        dataSource.setMinIdle(Integer.parseInt(disConfig.getProperty("phoenix.datasource.minIdle")));
        dataSource.setInitialSize(Integer.parseInt(disConfig.getProperty("phoenix.datasource.initialSize")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(disConfig.getProperty("phoenix.datasource.testOnReturn")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(disConfig.getProperty("phoenix.datasource.testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(disConfig.getProperty("phoenix.datasource.testOnBorrow")));
        dataSource.setLogAbandoned(Boolean.parseBoolean(disConfig.getProperty("phoenix.datasource.logAbandoned")));
        dataSource.setValidationQuery(disConfig.getProperty("phoenix.datasource.validationQuery"));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(disConfig.getProperty("phoenix.datasource.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(disConfig.getProperty("phoenix.datasource.minEvictableIdleTimeMillis")));
        dataSource.setRemoveAbandoned(Boolean.parseBoolean(disConfig.getProperty("phoenix.datasource.removeAbandoned")));
        dataSource.addConnectionProperty("phoenix.schema.isNamespaceMappingEnabled", disConfig.getProperty("phoenix.schema.isNamespaceMappingEnabled"));
        return dataSource;
    }
}

*/
