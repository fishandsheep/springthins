package com.zdx.springthin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringthinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringthinApplication.class, args);
    }

}
