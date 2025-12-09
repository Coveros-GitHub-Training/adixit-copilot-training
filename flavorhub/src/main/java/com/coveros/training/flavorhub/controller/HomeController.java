package com.coveros.training.flavorhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for serving the main web pages
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    /**
     * Display the recipes browsing page
     * TODO: Add model attributes for pre-populated data
     * @return the recipes view template
     */
    @GetMapping("/recipes")
    public String recipes() {
        return "recipes";
    }
}
