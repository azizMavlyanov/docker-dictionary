package com.aziz.dictionary.web;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PageController {
    @ApiResponse(responseCode = "200", description = "Fetching page")
    @GetMapping
    public String getPage(Model model) {
        return "index";
    }
}
