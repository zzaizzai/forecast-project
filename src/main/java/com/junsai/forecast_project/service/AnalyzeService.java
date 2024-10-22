package com.junsai.forecast_project.service;

import org.springframework.stereotype.Service;

@Service
public class AnalyzeService {

    private final ForecastService forecastService;
    private final ResultService resultService;

    public AnalyzeService(ForecastService forecastService, ResultService resultService) {
        this.forecastService = forecastService;
        this.resultService = resultService;
    }

}
