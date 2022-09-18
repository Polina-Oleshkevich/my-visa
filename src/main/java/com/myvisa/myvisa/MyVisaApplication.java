package com.myvisa.myvisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
public class MyVisaApplication { public static void main(String[] args) {
    SpringApplication.run(MyVisaApplication.class, args);
}
}
