package com.junsai.forecast_project.service;

import com.junsai.forecast_project.dto.ForecastCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.repository.ForecastRepository;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {

    private final ForecastRepository forecastRepository;

    public ForecastService(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    public Forecast createForecast(ForecastCreateDTO forecastCreateDTO) {
        String name = forecastCreateDTO.getName();
        Forecast forecast = new Forecast(name);
        return forecastRepository.save(forecast);
    }
}