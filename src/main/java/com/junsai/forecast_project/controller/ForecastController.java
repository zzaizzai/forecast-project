package com.junsai.forecast_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forecast")
public class ForecastController {
    @GetMapping("/index")
    public String index() {
        return "views/forecast/index.html";
    }

//    @GetMapping("/detail")
//    public String detail() {
//        return "views/forecast/detail.html";
//    }
}
