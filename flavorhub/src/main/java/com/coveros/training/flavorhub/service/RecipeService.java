package com.coveros.training.flavorhub.service;

import com.coveros.training.flavorhub.model.Recipe;
import com.coveros.training.flavorhub.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing recipes
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RecipeService {
    
    private final RecipeRepository recipeRepository;
    
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }
    
    public List<Recipe> getRecipesByDifficulty(String difficultyLevel) {
        return recipeRepository.findByDifficultyLevel(difficultyLevel);
    }
    
    public List<Recipe> getRecipesByCuisine(String cuisineType) {
        return recipeRepository.findByCuisineType(cuisineType);
    }
    
    public List<Recipe> searchRecipes(String searchTerm) {
        return recipeRepository.findByNameContainingIgnoreCase(searchTerm);
    }
    
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
    
    /**
     * Add a rating to a recipe and update the average rating
     * 
     * @param recipeId the ID of the recipe to rate
     * @param rating the rating value (must be between 1 and 5)
     * @return the updated recipe with new average rating
     * @throws IllegalArgumentException if rating is not between 1 and 5
     * @throws RuntimeException if recipe is not found
     */
    public Recipe addRating(Long recipeId, Integer rating) {
        // Validate rating is between 1 and 5
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        
        // Find the recipe
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + recipeId));
        
        // Calculate new average rating - handle null values for existing recipes
        Double currentAverage = recipe.getAverageRating() != null ? recipe.getAverageRating() : 0.0;
        Integer currentCount = recipe.getRatingCount() != null ? recipe.getRatingCount() : 0;
        
        Double newAverage = ((currentAverage * currentCount) + rating) / (currentCount + 1);
        
        // Update recipe with new rating
        recipe.setAverageRating(newAverage);
        recipe.setRatingCount(currentCount + 1);
        
        // Save and return updated recipe
        return recipeRepository.save(recipe);
    }
    
    /**
     * Find recipes that can be made based on available ingredients in the pantry
     * NOTE: This method is intentionally left incomplete for workshop participants
     * Participants will use GitHub Copilot to implement this recommendation logic
     */
    // TODO: Implement method to recommend recipes based on pantry ingredients
    
    /**
     * Get recipes that match specific dietary requirements or filters
     * NOTE: This is a more advanced feature to be implemented during the workshop
     */
    // TODO: Implement advanced filtering logic
}
