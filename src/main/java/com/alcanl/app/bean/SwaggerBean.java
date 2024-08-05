package com.alcanl.app.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class SwaggerBean {

    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI().info(new Info()
                .version("v 1.0.0")
                .description("Spring Boot & React Js")
                .termsOfService(" Software INC")
                .contact(new Contact()
                        .name("Alican Keçici")
                        .email("alican.kecici@gmail.com")
                        .url("https://github.com/alcanl")
                )
                .license(new License()
                        .name("licence INC xyz")
                        .url("https://github.com/alcanl")
                )
        );
    }
}
