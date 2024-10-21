package com.junsai.forecast_project.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/api")
public class CSVController {

    @GetMapping("/download-csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        String csvFileName = "data.csv";

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + csvFileName + "\"");

        PrintWriter writer = response.getWriter();
        writer.write("ID,Name,Value\n");
        writer.write("1,John Doe,1000\n");
        writer.write("2,Jane Doe,2000\n");
        writer.write("3,Sam Smith,3000\n");

        writer.flush();
        writer.close();

    }
}