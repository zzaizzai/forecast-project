package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.AnalyzeService;
import com.junsai.forecast_project.service.ForecastService;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/analyze")
public class AnalyzeController {

    private final ResultService resultService;
    private final ForecastService forecastService;
    private final AnalyzeService analyzeService;

    public AnalyzeController(ResultService resultService, ForecastService forecastService, AnalyzeService analyzeService) {
        this.resultService = resultService;
        this.forecastService = forecastService;
        this.analyzeService = analyzeService;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        List<Result> resultList = resultService.getAllResults();
        model.addAttribute("resultList", resultList);
        return "/views/analyze/index.html";
    }

    @GetMapping("/detail/{analyzeId}")
    public String detail(@PathVariable String analyzeId, Model model) {
        try {
            Result result = resultService.findResultById(analyzeId)
                    .orElseThrow(() -> new NoSuchElementException());

            List<Result> sameGroupResults = resultService.getAllResultsByForecastId(result.getForecastId());

            Iterator<Result> iterator = sameGroupResults.iterator();

//            remove result becauz of duplication
            while (iterator.hasNext()) {
                Result sameGroup = iterator.next();
                if (sameGroup.equals(result)) {
                    iterator.remove();
                    break;
                }
            }

            model.addAttribute("result", result);
            model.addAttribute("sameGroupResults", sameGroupResults);

            return "/views/analyze/detail.html";
        } catch (NoSuchElementException e) {
            return "main/errorPage.html";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "main/errorPage.html";
        }
    }

}
