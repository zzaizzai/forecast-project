package com.junsai.forecast_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello";
    }
    @GetMapping("/index")
    public String index() {
        return "index.html";
    }
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("abc", "abc is my name");
        return "test.html";
    }

    @GetMapping("/test2")
    public String test2() {
        return "views/test2.html";
    }
}
