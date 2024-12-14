package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.model.ForecastGroup;
import com.junsai.forecast_project.service.AnalyzeService;
import com.junsai.forecast_project.service.ForecastGroupService;
import com.junsai.forecast_project.service.ForecastService;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/analyze")
public class AnalyzeController {

    private final ResultService resultService;
    private final ForecastService forecastService;
    private final AnalyzeService analyzeService;
    private final ForecastGroupService forecastGroupService;

    public AnalyzeController(ResultService resultService,
                             ForecastService forecastService,
                             AnalyzeService analyzeService,
                             ForecastGroupService forecastGroupService) {
        this.resultService = resultService;
        this.forecastService = forecastService;
        this.analyzeService = analyzeService;
        this.forecastGroupService = forecastGroupService;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {

        List<ForecastGroup> forecastGroups = forecastGroupService.getAllForecastGroups();
//        List<Result> resultList = resultService.getAllResults();
        model.addAttribute("forecastGroups", forecastGroups);
        return "/views/analyze/index.html";
    }

    @GetMapping("/detail/{groupId}")
    public String detail(@PathVariable String groupId, Model model) {
        try {

            ForecastGroup forecastGroup = forecastGroupService.getOneForecastGroup(groupId)
                    .orElseThrow(() -> new NoSuchElementException());
            model.addAttribute("forecastGroup", forecastGroup);
            
            List<Forecast> forecasts = forecastService.getAllForecastsByForecastGroupId(groupId);
            model.addAttribute("forecasts", forecasts);

            return "/views/analyze/detail.html";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", "No Such Element Exception: " + e.getMessage());
            return "main/errorPage.html";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "main/errorPage.html";
        }
    }

}
