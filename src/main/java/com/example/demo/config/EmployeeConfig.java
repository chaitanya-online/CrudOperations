package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class EmployeeConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Employee Api").apiInfo(apiInfo()).select()
                .paths(regex("/employee.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
                .description("Sample Documentation Generated Using SWAGGER3 for our Employee Rest API")
                .termsOfServiceUrl("MyUrl")
                .license("Java License")
                .licenseUrl("MyUrL").version("1.0").build();
    }
}
