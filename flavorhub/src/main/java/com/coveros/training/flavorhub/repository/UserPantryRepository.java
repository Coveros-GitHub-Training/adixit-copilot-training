package com.coveros.training.flavorhub.repository;

import com.coveros.training.flavorhub.model.UserPantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for managing UserPantry entities
 */
@Repository
public interface UserPantryRepository extends JpaRepository<UserPantry, Long> {
    
    /**
     * Find all pantry items for a specific user
     */
    List<UserPantry> findByUserId(Long userId);
    
    /**
     * Find a specific pantry item by user and ingredient
     */
    Optional<UserPantry> findByUserIdAndIngredientId(Long userId, Long ingredientId);
    
    /**
     * Delete all pantry items for a specific user
     */
    void deleteByUserId(Long userId);
}
