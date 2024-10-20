package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Result> resultList = resultService.getAllResults();
        model.addAttribute("resultList", resultList);
        return "views/result/index.html";
    }

}
