package com.example.userresourceblocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ResourceBlockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceBlockerApplication.class, args);
    }

}
