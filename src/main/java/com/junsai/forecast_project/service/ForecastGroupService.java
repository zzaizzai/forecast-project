package com.junsai.forecast_project.service;


import com.junsai.forecast_project.model.ForecastGroup;
import com.junsai.forecast_project.repository.ForecastGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForecastGroupService {

    private final ForecastGroupRepository forecastGroupRepository;

    public Optional<ForecastGroup> getOneForecastGroup(String forecastGroupId) {
        return forecastGroupRepository.findById(forecastGroupId);
    }

    public ForecastGroupService(ForecastGroupRepository forecastGroupRepository) {
        this.forecastGroupRepository = forecastGroupRepository;
    }

    public List<ForecastGroup> getAllForecastGroups() {
        return forecastGroupRepository.findAll();
    }

}
