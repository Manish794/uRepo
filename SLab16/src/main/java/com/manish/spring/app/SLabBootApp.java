package com.manish.spring.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.manish.spring", exclude = {DataSourceAutoConfiguration.class})
public class SLabBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SLabBootApp.class, args);
    }
}