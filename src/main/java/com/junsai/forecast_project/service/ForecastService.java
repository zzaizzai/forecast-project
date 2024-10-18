package com.junsai.forecast_project.service;

import com.junsai.forecast_project.dto.ForecastCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.repository.ForecastRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForecastService {

    private final ForecastRepository forecastRepository;

    public ForecastService(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    public List<Forecast> getAllForecasts() {
        return forecastRepository.findAll();
    }

    public Forecast createForecast(ForecastCreateDTO forecastCreateDTO) {
        Forecast forecast = new Forecast(forecastCreateDTO.getName(), forecastCreateDTO.getUnit(), forecastCreateDTO.getQuantity());
        return forecastRepository.save(forecast);
    }

    public Optional<Forecast> findForeCastById(Long foreCastId) {
        return forecastRepository.findById(foreCastId);
    }
}