package com.junsai.forecast_project.service;

import com.junsai.forecast_project.dto.ResultCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final ForecastService forecastService;

    public ResultService(ResultRepository resultRepository, ForecastService forecastService) {
        this.resultRepository = resultRepository;
        this.forecastService = forecastService;
    }

    public Optional<Result> findResultById(String id) {
        return this.resultRepository.findById(id);
    }

    public List<Result> getAllResults() {
        return resultRepository.findByDeleted(false);
    }

    public List<Result> getAllResultsByForecastId(String id) {
        return resultRepository.findAllByForecastId(id);
    }

    public Result getRecentResultsByForecastId(String forecastId) {
        return resultRepository.findRecentResultByForecastId(forecastId);
    }

    public Result createResult(ResultCreateDTO resultCreateDTO) {

        System.out.println(resultCreateDTO.getForecastId());
        Forecast forecast = forecastService.findForecastById(resultCreateDTO.getForecastId())
                .orElseThrow(() -> new NoSuchElementException());
        Result result = new Result(forecast, resultCreateDTO.getName(), resultCreateDTO.getQuantity());
        return resultRepository.save(result);
    }
}
