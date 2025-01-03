package com.junsai.forecast_project.controller;


import com.junsai.forecast_project.dto.ResultCreateDTO;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/result")
public class ResultApiController {

    private final ResultService resultService;

    public ResultApiController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/all")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @GetMapping("/one/{resultId}")
    public Result getResultById(@PathVariable String resultId) {
        return resultService.getResultById(resultId).orElse(null);
    }

    @PostMapping("/create")
    public Result createResult(@RequestBody ResultCreateDTO createDTO) {
        return resultService.createResult(createDTO);
    }

    @PostMapping("/createrandom")
    public void createRandomResult() {
        Result result = resultService.createRandomResult();
    }

    @DeleteMapping("/delete/{resultId}")
    public void deleteResultById(@PathVariable String resultId) {
        resultService.deleteResultById(resultId);
    }

    @PutMapping("/update/{resultId}")
    public Result updateResult(@PathVariable String resultId, @RequestBody ResultCreateDTO createDTO) {
        return resultService.updateResult(resultId, createDTO);
    }

    @PostMapping("/deletecancle/{resultId}")
    public void deleteCancleResultById(@PathVariable String resultId) {
        resultService.deletedCancleResultById(resultId);
    }

}
