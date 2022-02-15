package com.wpf.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/14 10:33:50
 * @DESCRIPTION:
 */
@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DerbyDatasourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource")
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }
}
