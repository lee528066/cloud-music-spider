package com.lee.test.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

/**
 * @author liwei
 */
@SpringBootApplication(scanBasePackages = "com.lee", exclude = {SessionAutoConfiguration.class})
@MapperScan("com.lee.dao.mapper")
public class TestConfig {
}
