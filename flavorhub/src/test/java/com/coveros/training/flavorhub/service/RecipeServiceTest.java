package com.coveros.training.flavorhub.service;

import com.coveros.training.flavorhub.model.Recipe;
import com.coveros.training.flavorhub.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Unit tests for RecipeService
 */
@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    private Recipe testRecipe;

    @BeforeEach
    void setUp() {
        testRecipe = new Recipe("Pasta", "Italian pasta dish", 10, 15, 4, "Easy", "Italian");
        testRecipe.setId(1L);
        testRecipe.setAverageRating(0.0);
        testRecipe.setRatingCount(0);
    }

    @Test
    void testAddRating_WhenFirstRating_ThenReturnsRecipeWithCorrectAverage() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Recipe result = recipeService.addRating(1L, 5);

        // Assert
        assertNotNull(result);
        assertEquals(5.0, result.getAverageRating());
        assertEquals(1, result.getRatingCount());
        verify(recipeRepository, times(1)).findById(1L);
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    void testAddRating_WhenMultipleRatings_ThenCalculatesAverageCorrectly() {
        // Arrange
        testRecipe.setAverageRating(4.5);
        testRecipe.setRatingCount(4);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Recipe result = recipeService.addRating(1L, 3);

        // Assert
        assertNotNull(result);
        assertEquals(4.2, result.getAverageRating(), 0.01);
        assertEquals(5, result.getRatingCount());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    void testAddRating_WhenRatingLessThan1_ThenThrowsIllegalArgumentException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> recipeService.addRating(1L, 0)
        );
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    void testAddRating_WhenRatingGreaterThan5_ThenThrowsIllegalArgumentException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> recipeService.addRating(1L, 6)
        );
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    void testAddRating_WhenRecipeNotFound_ThenThrowsRuntimeException() {
        // Arrange
        when(recipeRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> recipeService.addRating(99L, 5)
        );
        assertEquals("Recipe not found with id: 99", exception.getMessage());
        verify(recipeRepository, never()).save(any(Recipe.class));
    }

    @Test
    void testAddRating_WhenValidRatingBoundary1_ThenReturnsCorrectAverage() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Recipe result = recipeService.addRating(1L, 1);

        // Assert
        assertEquals(1.0, result.getAverageRating());
        assertEquals(1, result.getRatingCount());
    }

    @Test
    void testAddRating_WhenValidRatingBoundary5_ThenReturnsCorrectAverage() {
        // Arrange
        testRecipe.setAverageRating(3.0);
        testRecipe.setRatingCount(2);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Recipe result = recipeService.addRating(1L, 5);

        // Assert
        assertEquals(3.666666666666667, result.getAverageRating(), 0.01);
        assertEquals(3, result.getRatingCount());
    }
}
