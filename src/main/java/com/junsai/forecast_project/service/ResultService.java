package com.junsai.forecast_project.service;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public Optional<Result> findResultById(Long id) {
        return this.resultRepository.findById(id);
    }

    public List<Result> getAllResults() {
        return resultRepository.findByDeleted(false);
    }


}
