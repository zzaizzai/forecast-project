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

            ForecastGroup Electric2024Forecast = new ForecastGroup("FY2024 Electricity Bill", "241219210442");
            forecastGroupRepository.save(Electric2024Forecast);

            Forecast forecast50 = new Forecast(Electric2024Forecast, "Direct Costs of Machine 12", "Yen", 200000);
            forecastRepository.save(forecast50);
            resultRepository.save(new Result(forecast50, "Direct Costs of Machine 12", 150000));
            resultRepository.save(new Result(forecast50, "Direct Costs of Machine 12", 210000));
            resultRepository.save(new Result(forecast50, "Direct Costs of Machine 12", 250000));


            Forecast forecast51 = new Forecast(Electric2024Forecast, "Direct Costs of Machine 15", "Yen", 500000);
            forecastRepository.save(forecast51);
            resultRepository.save(new Result(forecast51, "Direct Costs of Machine 15", 513245));


            Forecast forecast52 = new Forecast(Electric2024Forecast, "InDirect Costs of Machines", "Yen", 600000);
            forecastRepository.save(forecast52);
            resultRepository.save(new Result(forecast52, "InDirect Costs of Machines", 579841));


            Forecast forecast53 = new Forecast(Electric2024Forecast, "Direct Costs of Machine 17", "Yen", 600000);
            forecastRepository.save(forecast53);
            resultRepository.save(new Result(forecast53, "Direct Costs of Machine 17", 579841));


            Forecast forecast54 = new Forecast(Electric2024Forecast, "Direct Costs of Machine 99", "Yen", 600000);
            forecastRepository.save(forecast54);
            resultRepository.save(new Result(forecast54, "Direct Costs of Machine 99", 579841));


        };
    }
}
