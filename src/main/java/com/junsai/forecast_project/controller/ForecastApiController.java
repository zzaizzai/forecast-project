package com.junsai.forecast_project.controller;


import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.service.ForecastService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/forecast")
public class ForecastApiController {

    private final ForecastService forecastService;

    public ForecastApiController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/all")
    public List<Forecast> getAllForecasts() {
        return forecastService.getAllForecasts();
    }
}
