package com.junsai.forecast_project.service;


import com.junsai.forecast_project.model.ForecastGroup;
import com.junsai.forecast_project.repository.ForecastGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastGroupService {

    private final ForecastGroupRepository forecastGroupRepository;


    public ForecastGroupService(ForecastGroupRepository forecastGroupRepository) {
        this.forecastGroupRepository = forecastGroupRepository;
    }

    public List<ForecastGroup> getAllForecastGroups() {
        return forecastGroupRepository.findAll();
    }

}
