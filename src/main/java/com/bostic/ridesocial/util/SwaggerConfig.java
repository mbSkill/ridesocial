package com.bostic.ridesocial.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ridesocial APIs",
                "List of APIs",
                "1.0",
                "Terms?",
                new Contact(
                        "MattB",
                        "www.ride.com/",
                        "matthewbosticdev@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket api() {
        return new Docket
                (DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
