package com.junsai.forecast_project.config;


import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.model.ForecastGroup;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.repository.ForecastGroupRepository;
import com.junsai.forecast_project.repository.ForecastRepository;
import com.junsai.forecast_project.repository.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class TestDataLoader {

    @Bean
    @Transactional
    CommandLineRunner loadData(
            ForecastGroupRepository forecastGroupRepository,
            ForecastRepository forecastRepository,
            ResultRepository resultRepository
    ) {
        return args -> {

            ForecastGroup testgroup1 = new ForecastGroup("group2");
            forecastGroupRepository.save(testgroup1);

            Forecast forecast50 = new Forecast(testgroup1, "forecast50", "Datetime", 202312121010L);
            forecastRepository.save(forecast50);
            forecastRepository.save(new Forecast(testgroup1, "forecast51", "Date", 20231215));
            forecastRepository.save(new Forecast(testgroup1, "forecast52", "yen", 55555));
            forecastRepository.save(new Forecast(testgroup1, "forecast53", "dollars", 66666));

            resultRepository.save(new Result(forecast50, "result 50", 202312121212L));

        };
    }
}
