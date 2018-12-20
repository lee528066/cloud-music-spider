package com.lee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liwei
 */

@SpringBootApplication(scanBasePackages={"com.lee"})
@MapperScan("com.lee.dao.mapper")
public class CloudMusicSpiderStarter {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CloudMusicSpiderStarter.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }

}
