package com.junsai.forecast_project.service;

import com.junsai.forecast_project.dto.ForecastCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.model.ForecastGroup;
import com.junsai.forecast_project.repository.ForecastGroupRepository;
import com.junsai.forecast_project.repository.ForecastRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ForecastService {

    private final ForecastRepository forecastRepository;
    private final ForecastGroupRepository forecastGroupRepository;

    public ForecastService(ForecastRepository forecastRepository, ForecastGroupRepository forecastGroupRepository) {
        this.forecastRepository = forecastRepository;
        this.forecastGroupRepository = forecastGroupRepository;
    }

    public List<Forecast> getAllForecasts() {
        return forecastRepository.findByDeleted(false);
    }

    public Forecast createForecast(ForecastCreateDTO forecastCreateDTO) {

        ForecastGroup forecastGroup = forecastGroupRepository.findById(forecastCreateDTO.getForecastGroupId())
                .orElseThrow(() -> new NoSuchElementException());
        Forecast forecast = new Forecast(forecastGroup, forecastCreateDTO.getName(), forecastCreateDTO.getUnit(), forecastCreateDTO.getQuantity());
        return forecastRepository.save(forecast);

    }

    public Optional<Forecast> findForecastById(String foreCastId) {
        return forecastRepository.findById(foreCastId);
    }

    public List<Forecast> getAllForecastsByForecastGroupId(String forecastGroupId) {
        return forecastRepository.findAllByForecastGroupId(forecastGroupId);
    }

    public Optional<Forecast> getForecastById(String forecastId) {
        Optional<Forecast> forecast = forecastRepository.findById(forecastId);
        return forecast;
    }

}