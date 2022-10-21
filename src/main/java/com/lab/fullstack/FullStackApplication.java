package com.lab.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FullStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullStackApplication.class, args);
    }

}
