package com.coveros.training.flavorhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * FlavorHub Application - GitHub Copilot Advanced Workshop
 * 
 * This application demonstrates the use of GitHub Copilot for building
 * a Spring Boot application with CRUD operations, search functionality,
 * and external API integration.
 * 
 * Features:
 * - Manage ingredients in a user's pantry
 * - Browse and search recipes
 * - Get recipe recommendations based on available ingredients
 * - Integration with external recipe APIs (e.g., Spoonacular)
 */
@SpringBootApplication
public class FlavorHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlavorHubApplication.class, args);
    }
}
