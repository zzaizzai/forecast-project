package com.junsai.forecast_project.service;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }


}
