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
import static org.mockito.Mockito.*;

/**
 * Unit tests for RecipeService rating functionality
 */
@ExtendWith(MockitoExtension.class)
class RecipeServiceRatingTest {
    
    @Mock
    private RecipeRepository recipeRepository;
    
    @InjectMocks
    private RecipeService recipeService;
    
    private Recipe testRecipe;
    
    @BeforeEach
    void setUp() {
        testRecipe = new Recipe("Pasta Carbonara", "Classic Italian pasta dish", 
                               10, 15, 4, "Easy", "Italian");
        testRecipe.setId(1L);
        testRecipe.setAverageRating(0.0);
        testRecipe.setRatingCount(0);
    }
    
    @Test
    void testAddRating_WhenFirstRating_ThenReturnsRecipeWithCorrectRating() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 5);
        
        // Assert
        assertEquals(5.0, result.getAverageRating(), "Average rating should be 5.0 for first rating");
        assertEquals(1, result.getRatingCount(), "Rating count should be 1");
        verify(recipeRepository).save(testRecipe);
    }
    
    @Test
    void testAddRating_WhenMultipleRatings_ThenCalculatesAverageCorrectly() {
        // Arrange
        testRecipe.setAverageRating(4.5);
        testRecipe.setRatingCount(4);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 3);
        
        // Assert
        // Expected: ((4.5 * 4) + 3) / 5 = 21 / 5 = 4.2
        assertEquals(4.2, result.getAverageRating(), 0.01, "Average rating should be calculated correctly");
        assertEquals(5, result.getRatingCount(), "Rating count should increment to 5");
    }
    
    @Test
    void testAddRating_WhenRatingIsOne_ThenAccepts() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 1);
        
        // Assert
        assertEquals(1.0, result.getAverageRating(), "Should accept rating of 1");
        assertEquals(1, result.getRatingCount());
    }
    
    @Test
    void testAddRating_WhenRatingIsFive_ThenAccepts() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 5);
        
        // Assert
        assertEquals(5.0, result.getAverageRating(), "Should accept rating of 5");
        assertEquals(1, result.getRatingCount());
    }
    
    @Test
    void testAddRating_WhenRatingIsLessThanOne_ThenThrowsException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> recipeService.addRating(1L, 0)
        );
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
        
        // Verify repository was never called
        verify(recipeRepository, never()).findById(any());
        verify(recipeRepository, never()).save(any());
    }
    
    @Test
    void testAddRating_WhenRatingIsGreaterThanFive_ThenThrowsException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> recipeService.addRating(1L, 6)
        );
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
        
        // Verify repository was never called
        verify(recipeRepository, never()).findById(any());
        verify(recipeRepository, never()).save(any());
    }
    
    @Test
    void testAddRating_WhenRecipeNotFound_ThenThrowsException() {
        // Arrange
        when(recipeRepository.findById(999L)).thenReturn(Optional.empty());
        
        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> recipeService.addRating(999L, 5)
        );
        assertTrue(exception.getMessage().contains("Recipe not found"));
        
        // Verify save was never called
        verify(recipeRepository, never()).save(any());
    }
    
    @Test
    void testAddRating_WhenAddingToExistingRating_ThenPreservesOldRatings() {
        // Arrange
        testRecipe.setAverageRating(4.0);
        testRecipe.setRatingCount(2);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 5);
        
        // Assert
        // Expected: ((4.0 * 2) + 5) / 3 = 13 / 3 = 4.333...
        assertEquals(4.333, result.getAverageRating(), 0.01, "Should preserve and calculate with old ratings");
        assertEquals(3, result.getRatingCount());
    }
    
    @Test
    void testAddRating_WhenAllRatingsAreSame_ThenAverageIsCorrect() {
        // Arrange
        testRecipe.setAverageRating(3.0);
        testRecipe.setRatingCount(5);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 3);
        
        // Assert
        // Expected: ((3.0 * 5) + 3) / 6 = 18 / 6 = 3.0
        assertEquals(3.0, result.getAverageRating(), 0.01, "Average should remain 3.0");
        assertEquals(6, result.getRatingCount());
    }
    
    @Test
    void testAddRating_WhenRatingWillLowerAverage_ThenCalculatesCorrectly() {
        // Arrange
        testRecipe.setAverageRating(5.0);
        testRecipe.setRatingCount(2);
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        when(recipeRepository.save(any(Recipe.class))).thenAnswer(i -> i.getArguments()[0]);
        
        // Act
        Recipe result = recipeService.addRating(1L, 1);
        
        // Assert
        // Expected: ((5.0 * 2) + 1) / 3 = 11 / 3 = 3.666...
        assertEquals(3.666, result.getAverageRating(), 0.01, "Average should decrease correctly");
        assertEquals(3, result.getRatingCount());
    }
}
