package com.junsai.forecast_project.controller;

import com.junsai.forecast_project.model.Result;
import com.junsai.forecast_project.service.ResultService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CSVController {

    private final ResultService resultService;

    public CSVController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/download-csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        String csvFileName = "data.csv";

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + csvFileName + "\"");

        PrintWriter writer = response.getWriter();
        List<Result> resultList = resultService.getAllResults();
        writer.write("Name,Unit,Forecast,Result,FormattedQuantityDiff\n");
        for (Result result : resultList) {
            writer.write(String.format("%s,%s,%s,%s,%s\n",
                    result.getForecastName(),
                    result.getUnit(),
                    result.getForecastQuantity(),
                    result.formattedQuantity(),
                    result.formattedDiff()));
        }

        writer.flush();
        writer.close();

    }
}