package com.cisdi;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Heyinqing
 * @date 2024/10/9
 */
@SpringBootApplication
@MapperScan("com.cisdi.mapper")
public class PoiTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoiTrainingApplication.class,args);
    }

}
