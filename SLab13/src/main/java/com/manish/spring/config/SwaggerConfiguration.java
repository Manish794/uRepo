package com.manish.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.manish.spring.controller")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("MANISH APP API").description("MANISH API reference for developers")
                .termsOfServiceUrl("http://manish.com")
                .license("MANISH App License")
                .licenseUrl("manish@manish.com").version("1.0").build();
    }
}
