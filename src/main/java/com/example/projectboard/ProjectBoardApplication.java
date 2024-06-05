package com.example.projectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan // ThymeleafConfig 관련
@SpringBootApplication
public class ProjectBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBoardApplication.class, args);
    }

}
