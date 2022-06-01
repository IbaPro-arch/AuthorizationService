package com.example.authorizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@EnableAuthorizationServer
@SpringBootApplication
public class AuthorizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServiceApplication.class, args);
    }

}
