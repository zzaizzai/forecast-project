package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ForecastService;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/analyze")
public class AnalyzeController {

    private final ResultService resultService;
    private final ForecastService forecastService;

    public AnalyzeController(ResultService resultService, ForecastService forecastService) {
        this.resultService = resultService;
        this.forecastService = forecastService;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        List<Result> resultList = resultService.getAllResults();
        model.addAttribute("resultList", resultList);
        return "/views/analyze/index.html";
    }

}
