package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ResultService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("/detail/{resultId}")
    public String detail(@PathVariable String resultId, Model model) {
        try {
            Long id = Long.parseLong(resultId);
            Result result = resultService.findResultById(id)
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
