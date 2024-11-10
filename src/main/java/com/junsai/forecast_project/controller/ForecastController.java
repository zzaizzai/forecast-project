package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.dto.ForecastCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.service.ForecastService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/forecast")
public class ForecastController {
    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Forecast> forecastList = forecastService.getAllForecasts();
        System.out.println(forecastList);
        model.addAttribute("forecastList", forecastList);
        return "views/forecast/index.html";
    }

    @GetMapping("/add")
    public String add() {
        return "views/forecast/add.html";
    }

    @PostMapping("/add")
    @ResponseBody
    public Forecast addForecast(@ModelAttribute ForecastCreateDTO forecastCreateDTO) {
        System.out.println(forecastCreateDTO);
        return forecastService.createForecast(forecastCreateDTO);
    }

    @GetMapping("/detail/{forecastId}")
    public String detail(@PathVariable String forecastId, Model model) {
        try {
            Long id = Long.parseLong(forecastId);
            Forecast forecast = forecastService.findForeCastById(id)
                    .orElseThrow(() -> new NoSuchElementException());
            model.addAttribute("forecast", forecast);
            return "views/forecast/detail.html";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid forecast ID: " + forecastId);
            return "main/errorPage.html";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", "Forecast not found for ID: " + forecastId);
            return "main/errorPage.html";
        } catch (Exception e) {
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "main/errorPage.html";
        }
    }
}
