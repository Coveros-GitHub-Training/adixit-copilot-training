package com.coveros.training.flavorhub.repository;

import com.coveros.training.flavorhub.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for managing Ingredient entities
 */
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    
    /**
     * Find an ingredient by name (case-insensitive)
     */
    Optional<Ingredient> findByNameIgnoreCase(String name);
    
    /**
     * Find all ingredients in a specific category
     */
    List<Ingredient> findByCategory(String category);
    
    /**
     * Find ingredients with names containing the search term (case-insensitive)
     */
    List<Ingredient> findByNameContainingIgnoreCase(String searchTerm);
}
