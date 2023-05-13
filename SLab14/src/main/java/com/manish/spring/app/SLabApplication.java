package com.manish.spring.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		scanBasePackages = {
				"com.manish.spring.controller",
				"com.manish.spring.service"
		} )

@EntityScan(basePackages = {"com.manish.spring.entity"} )
@EnableJpaRepositories(basePackages = {"com.manish.spring.repo"})
@OpenAPIDefinition(info = @Info(title = "Users Api", version = "2.0", description = "Users Information"))
public class SLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(SLabApplication.class, args);
	}

}
