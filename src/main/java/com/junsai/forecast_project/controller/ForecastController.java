package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.dto.ForecastCreateDTO;
import com.junsai.forecast_project.model.Forecast;
import com.junsai.forecast_project.service.ForecastService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/forecast")
public class ForecastController {
    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }
    @GetMapping("/index")
    public String index() {
        return "views/forecast/index.html";
    }

    @GetMapping("/add")
    public String add() {
        return "views/forecast/add.html";
    }

    @PostMapping("/add")
    @ResponseBody
    public Forecast addForecast(@RequestBody  ForecastCreateDTO forecastCreateDTO) {

        return forecastService.createForecast(forecastCreateDTO);
    }

//    @GetMapping("/detail")
//    public String detail() {
//        return "views/forecast/detail.html";
//    }
}
