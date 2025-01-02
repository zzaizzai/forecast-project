package com.junsai.forecast_project.controller;


import com.junsai.forecast_project.dto.ForecastCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.service.ForecastService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/one/{forecastId}")
    public Forecast getForecastById(@PathVariable String forecastId) {
        return forecastService.getForecastById(forecastId).orElse(null);
    }

    @PostMapping("/create")
    public Forecast createForecast(@RequestBody ForecastCreateDTO forecastCreateDTO) {
        return forecastService.createForecast(forecastCreateDTO);
    }

    @DeleteMapping("/delete/{forecastId}")
    public void deleteForecastById(@PathVariable String forecastId) {
        forecastService.deleteForecastById(forecastId);
    }
}
