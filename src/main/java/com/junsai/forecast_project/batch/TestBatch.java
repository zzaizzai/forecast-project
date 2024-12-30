package com.junsai.forecast_project.batch;


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

    public void createRandomResult() {

        forecastService.getAllForecasts().forEach(forecast -> {
            // create random result
            int random = (int) (Math.random() * 100);
        });


    }
}
