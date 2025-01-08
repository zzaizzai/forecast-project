package com.junsai.forecast_project.controller;


import com.junsai.forecast_project.dto.ResultCreateDTO;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ResultService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> createResult(@RequestBody @Valid ResultCreateDTO createDTO, BindingResult bindingResult) {
        System.out.println(createDTO.toString());
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(error -> {
                        String fieldName = ((FieldError) error).getField();
                        String message = error.getDefaultMessage();
                        return "Field '" + fieldName + "' " + message;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.badRequest().body(errors);
        }
        Result result = resultService.createResult(createDTO);
        return ResponseEntity.ok(result);
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
    public Result updateResult(@PathVariable @Valid String resultId, @RequestBody ResultCreateDTO createDTO) {
        return resultService.updateResult(resultId, createDTO);
    }

    @PostMapping("/deletecancle/{resultId}")
    public void deleteCancleResultById(@PathVariable String resultId) {
        resultService.deletedCancleResultById(resultId);
    }

}
