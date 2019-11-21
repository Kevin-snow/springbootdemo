package com.example.basemapperdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.basemapperdemo.mapper")
@SpringBootApplication
public class BasemapperdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasemapperdemoApplication.class, args);
    }

}
