package com.stackroute.muzix.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2   //@EnableSwagger2 annotation is used to enable the Swagger2 for your Spring Boot application.
public class SwaggerConfig {
//    @Bean
//    public Docket trackApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.stackroute.muzix.controllers"))
//                .paths(regex("/api/v1*"))
//                .build();
//    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.stackroute.muzix.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

}