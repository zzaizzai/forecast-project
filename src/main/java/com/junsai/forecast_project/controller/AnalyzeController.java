package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.model.ForecastGroup;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.AnalyzeService;
import com.junsai.forecast_project.service.ForecastGroupService;
import com.junsai.forecast_project.service.ForecastService;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public String detail(@PathVariable String groupId,
                         @RequestParam Optional<String> updated,
                         @RequestParam Optional<String> quantity,
                         Model model) {
        try {
            //get forecast group
            ForecastGroup forecastGroup = forecastGroupService.getOneForecastGroup(groupId)
                    .orElseThrow(() -> new NoSuchElementException());
            model.addAttribute("forecastGroup", forecastGroup);

            // get forecasts
            List<Forecast> forecasts = forecastService.getAllForecastsByForecastGroupId(groupId);
            model.addAttribute("forecasts", forecasts);

            //sorting by dateif
            if (updated.isPresent()) {
                //sotring by updated date
                if (updated.get().equals("asc")) {
                    System.out.println("asc");
                    forecasts.sort((f1, f2) -> f1.getLastResult().getCreatedDate().compareTo(f2.getLastResult().getCreatedDate()));
                } else if (updated.get().equals("desc")) {
                    forecasts.sort((f1, f2) -> f2.getLastResult().getCreatedDate().compareTo(f1.getLastResult().getCreatedDate()));
                }
            }

            //sorting by quantity
            if (quantity.isPresent()) {
                if (quantity.get().equals("asc")) {
                    forecasts.sort((f1, f2) -> f1.getLastResult().getQuantity().compareTo(f2.getLastResult().getQuantity()));
                } else if (quantity.get().equals("desc")) {
                    forecasts.sort((f1, f2) -> f2.getLastResult().getQuantity().compareTo(f1.getLastResult().getQuantity()));
                }
            }

            // Add Results from each forecast
            List<Result> results = new ArrayList<>();
            for (Forecast forecast : forecasts) {
                results.add(forecast.getLastResult());
            }
            model.addAttribute("results", results);
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
