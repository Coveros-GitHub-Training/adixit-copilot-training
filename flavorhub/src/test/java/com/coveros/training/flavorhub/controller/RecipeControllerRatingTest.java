package com.coveros.training.flavorhub.controller;

import com.coveros.training.flavorhub.dto.RatingRequest;
import com.coveros.training.flavorhub.model.Recipe;
import com.coveros.training.flavorhub.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for RecipeController rating endpoint
 */
@WebMvcTest(RecipeController.class)
class RecipeControllerRatingTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private RecipeService recipeService;
    
    private Recipe testRecipe;
    
    @BeforeEach
    void setUp() {
        testRecipe = new Recipe("Pasta Carbonara", "Classic Italian pasta dish", 
                               10, 15, 4, "Easy", "Italian");
        testRecipe.setId(1L);
        testRecipe.setAverageRating(4.2);
        testRecipe.setRatingCount(5);
    }
    
    @Test
    void testRateRecipe_WhenValidRating_ThenReturnsOkWithUpdatedRecipe() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(5);
        when(recipeService.addRating(eq(1L), eq(5))).thenReturn(testRecipe);
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Pasta Carbonara"))
                .andExpect(jsonPath("$.averageRating").value(4.2))
                .andExpect(jsonPath("$.ratingCount").value(5));
    }
    
    @Test
    void testRateRecipe_WhenRatingIsOne_ThenReturnsOk() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(1);
        when(recipeService.addRating(eq(1L), eq(1))).thenReturn(testRecipe);
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
    
    @Test
    void testRateRecipe_WhenRatingIsFive_ThenReturnsOk() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(5);
        when(recipeService.addRating(eq(1L), eq(5))).thenReturn(testRecipe);
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
    
    @Test
    void testRateRecipe_WhenRatingIsLessThanOne_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(0);
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testRateRecipe_WhenRatingIsGreaterThanFive_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(6);
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testRateRecipe_WhenRatingIsNull_ThenReturnsBadRequest() throws Exception {
        // Arrange
        String requestJson = "{}";
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testRateRecipe_WhenRecipeNotFound_ThenReturnsNotFound() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(5);
        when(recipeService.addRating(eq(999L), eq(5)))
                .thenThrow(new RuntimeException("Recipe not found with id: 999"));
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/999/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound());
    }
    
    @Test
    void testRateRecipe_WhenServiceThrowsIllegalArgumentException_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(5);
        when(recipeService.addRating(eq(1L), eq(5)))
                .thenThrow(new IllegalArgumentException("Rating must be between 1 and 5"));
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testRateRecipe_WhenInvalidJson_ThenReturnsBadRequest() throws Exception {
        // Arrange
        String invalidJson = "{rating: 'invalid'}";
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testRateRecipe_WhenNegativeRating_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest request = new RatingRequest(-1);
        
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    void testRateRecipe_WhenRequestBodyMissing_ThenReturnsBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
