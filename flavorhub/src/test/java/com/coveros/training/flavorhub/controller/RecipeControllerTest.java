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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller tests for RecipeController rating endpoint
 */
@WebMvcTest(RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RecipeService recipeService;

    private Recipe testRecipe;

    @BeforeEach
    void setUp() {
        testRecipe = new Recipe("Pasta", "Italian pasta dish", 10, 15, 4, "Easy", "Italian");
        testRecipe.setId(1L);
        testRecipe.setAverageRating(4.5);
        testRecipe.setRatingCount(5);
    }

    @Test
    void testRateRecipe_WhenValidRating_ThenReturnsOk() throws Exception {
        // Arrange
        RatingRequest ratingRequest = new RatingRequest(5);
        when(recipeService.addRating(1L, 5)).thenReturn(testRecipe);

        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ratingRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.averageRating").value(4.5))
                .andExpect(jsonPath("$.ratingCount").value(5));

        verify(recipeService, times(1)).addRating(1L, 5);
    }

    @Test
    void testRateRecipe_WhenInvalidRatingLessThan1_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest ratingRequest = new RatingRequest(0);

        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ratingRequest)))
                .andExpect(status().isBadRequest());

        verify(recipeService, never()).addRating(anyLong(), anyInt());
    }

    @Test
    void testRateRecipe_WhenInvalidRatingGreaterThan5_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest ratingRequest = new RatingRequest(6);

        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ratingRequest)))
                .andExpect(status().isBadRequest());

        verify(recipeService, never()).addRating(anyLong(), anyInt());
    }

    @Test
    void testRateRecipe_WhenRecipeNotFound_ThenReturnsNotFound() throws Exception {
        // Arrange
        RatingRequest ratingRequest = new RatingRequest(5);
        when(recipeService.addRating(99L, 5))
                .thenThrow(new RuntimeException("Recipe not found with id: 99"));

        // Act & Assert
        mockMvc.perform(put("/api/recipes/99/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ratingRequest)))
                .andExpect(status().isNotFound());

        verify(recipeService, times(1)).addRating(99L, 5);
    }

    @Test
    void testRateRecipe_WhenServiceThrowsIllegalArgumentException_ThenReturnsBadRequest() throws Exception {
        // Arrange
        RatingRequest ratingRequest = new RatingRequest(5);
        when(recipeService.addRating(1L, 5))
                .thenThrow(new IllegalArgumentException("Rating must be between 1 and 5"));

        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ratingRequest)))
                .andExpect(status().isBadRequest());

        verify(recipeService, times(1)).addRating(1L, 5);
    }

    @Test
    void testRateRecipe_WhenRatingIsNull_ThenReturnsBadRequest() throws Exception {
        // Arrange
        String invalidJson = "{}";

        // Act & Assert
        mockMvc.perform(put("/api/recipes/1/rate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidJson))
                .andExpect(status().isBadRequest());

        verify(recipeService, never()).addRating(anyLong(), anyInt());
    }
}
