package com.alcanl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.alcanl")
@EnableJpaRepositories(basePackages = "com.alcanl")
@SpringBootApplication
public class ToDoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ToDoApplication.class, args);
    }
}
