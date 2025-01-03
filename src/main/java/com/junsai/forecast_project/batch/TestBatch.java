package com.junsai.forecast_project.batch;


import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ForecastService;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestBatch {

    private final ForecastService forecastService;
    private final ResultService resultService;

    public TestBatch(ForecastService forecastService, ResultService resultService) {
        this.forecastService = forecastService;
        this.resultService = resultService;
    }

    // per 10 seconds
    @Scheduled(cron = "*/10 * * * * *")
    public void test() {
        // show current time formatted
        System.out.println("Current time: " + java.time.LocalTime.now());
    }

    // create random result per minute
    @Scheduled(cron = "0 * * * * *")
    public void createRandomResult() {
        Result result = resultService.createRandomResult();
        System.out.println("Created random result(ID): " + result.getId());
    }

    // create random forecast per minute
    @Scheduled(cron = "0 * * * * *")
    public void createRandomForecast() {
        Forecast forecast = forecastService.createRandomForecast();
        System.out.println("Created random forecast(ID): " + forecast.getId());
    }
}
