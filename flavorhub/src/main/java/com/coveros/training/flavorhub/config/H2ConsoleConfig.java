package com.coveros.training.flavorhub.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Configuration to enable H2 Console for development and debugging.
 * This ensures the H2 console works properly with Spring Boot 3.x and GitHub Codespaces
 */
@Configuration
@ConditionalOnProperty(name = "spring.h2.console.enabled", havingValue = "true")
public class H2ConsoleConfig {
    
    /**
     * Controller to handle redirect from /h2-console to /h2-console/
     * Uses sendRedirect with relative URL to avoid port number issues in Codespaces
     */
    @Controller
    
    public static class H2ConsoleRedirectController {
        
        @GetMapping("/h2-console")
        public String redirectToH2Console() {
            return "redirect:/h2-console/";
        }
    }
}