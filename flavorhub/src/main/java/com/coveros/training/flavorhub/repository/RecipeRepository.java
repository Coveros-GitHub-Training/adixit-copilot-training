package com.coveros.training.flavorhub.repository;

import com.coveros.training.flavorhub.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing Recipe entities
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    
    /**
     * Find recipes by difficulty level
     */
    List<Recipe> findByDifficultyLevel(String difficultyLevel);
    
    /**
     * Find recipes by cuisine type
     */
    List<Recipe> findByCuisineType(String cuisineType);
    
    /**
     * Find recipes with names containing the search term (case-insensitive)
     */
    List<Recipe> findByNameContainingIgnoreCase(String searchTerm);
    
    /**
     * Find recipes that can be made in a specific time (total time = prep + cook)
     * NOTE: This method is intentionally left incomplete for workshop participants to implement
     * They will use Copilot to complete this query
     */
    // TODO: Implement method to find recipes by max total time
    
    /**
     * Find recipes that contain a specific ingredient
     * NOTE: This is an advanced query that workshop participants will implement using Copilot
     */
    // TODO: Implement method to find recipes containing a specific ingredient name
}
