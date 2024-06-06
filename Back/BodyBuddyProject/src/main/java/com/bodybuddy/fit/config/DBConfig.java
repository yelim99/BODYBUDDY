package com.bodybuddy.fit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages="com.bodybuddy.fit.model.dao")
public class DBConfig {

}
