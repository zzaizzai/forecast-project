package com.junsai.forecast_project.service;

import com.junsai.forecast_project.model.Forecast;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ForecastServiceTest {

    @Autowired
    private ForecastService forecastService;

    @Test
    public void testAdd() {
        List<Forecast> result = forecastService.getAllForecasts();
        assertTrue(result.size() > 0);
    }
}