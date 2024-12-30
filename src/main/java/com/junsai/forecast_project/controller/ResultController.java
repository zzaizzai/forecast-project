package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.dto.ResultCreateDTO;
import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ForecastService;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/result")
public class ResultController {

    private final ResultService resultService;
    private final ForecastService forecastService;

    public ResultController(ResultService resultService, ForecastService forecastService) {
        this.resultService = resultService;
        this.forecastService = forecastService;

    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Result> resultList = resultService.getAllResults();
        model.addAttribute("resultList", resultList);
        return "views/result/index.html";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "views/result/add.html";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ResultCreateDTO resultCreateDTO, Model model) {

        System.out.println(resultCreateDTO.toString());

        try {
            resultService.createResult(resultCreateDTO);
            return "redirect:/result/index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "main/errorPage.html";
        }
    }

    @GetMapping("/detail/{resultId}")
    public String detail(@PathVariable String resultId, Model model) {
        try {
            Result result = resultService.findResultById(resultId)
                    .orElseThrow(() -> new NoSuchElementException());
            model.addAttribute("result", result);
            return "views/result/detail.html";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid forecast ID: " + resultId);
            return "main/errorPage.html";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", "Forecast not found for ID: " + resultId);
            return "main/errorPage.html";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "main/errorPage.html";
        }
    }

}
