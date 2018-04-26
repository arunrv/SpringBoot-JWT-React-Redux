package com.qp.pms.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String TITLE = "Spring Boot JWT React Redux API Documentation";
    private static final String DESCRIPTION = "Spring Boot Swagger JWT React Redux Example API";
    private static final String API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "Apache License";

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(metaInfo())
            .pathMapping("/")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.qp.pms"))
            .paths(regex("/api.*"))
            .build();
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
            .title(TITLE)
            .description(DESCRIPTION)
            .license(LICENSE_TEXT)
            .version(API_VERSION)
            .contact(
                new Contact("QP", "https://www.example.com", "example@gmail.com")
            )
            .licenseUrl("https://www.apache.org/licesen.html")
            .build();

        return apiInfo;
    }
}