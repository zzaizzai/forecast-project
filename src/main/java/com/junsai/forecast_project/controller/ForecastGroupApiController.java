package com.junsai.forecast_project.controller;


import com.junsai.forecast_project.service.ForecastGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forecastGroup")
public class ForecastGroupApiController {

    private final ForecastGroupService forecastGroupService;

    public ForecastGroupApiController(ForecastGroupService forecastGroupService) {
        this.forecastGroupService = forecastGroupService;
    }

}
