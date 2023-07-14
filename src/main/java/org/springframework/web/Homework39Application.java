package org.springframework.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Homework39Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework39Application.class, args);
    }
}
