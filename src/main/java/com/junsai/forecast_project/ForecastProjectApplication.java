package com.junsai.forecast_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class ForecastProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForecastProjectApplication.class, args);
    }

}
