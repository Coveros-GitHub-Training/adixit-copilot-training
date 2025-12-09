package com.coveros.training.flavorhub.service;

import com.coveros.training.flavorhub.model.Ingredient;
import com.coveros.training.flavorhub.model.UserPantry;
import com.coveros.training.flavorhub.repository.IngredientRepository;
import com.coveros.training.flavorhub.repository.UserPantryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing user pantry
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserPantryService {
    
    private final UserPantryRepository userPantryRepository;
    private final IngredientRepository ingredientRepository;
    
    public List<UserPantry> getUserPantry(Long userId) {
        return userPantryRepository.findByUserId(userId);
    }
    
    public Optional<UserPantry> getPantryItemById(Long id) {
        return userPantryRepository.findById(id);
    }
    
    public UserPantry addPantryItem(UserPantry pantryItem) {
        return userPantryRepository.save(pantryItem);
    }
    
    public UserPantry updatePantryItem(Long id, UserPantry updatedPantryItem) {
        return userPantryRepository.findById(id)
            .map(existing -> {
                existing.setQuantity(updatedPantryItem.getQuantity());
                existing.setUnit(updatedPantryItem.getUnit());
                existing.setNotes(updatedPantryItem.getNotes());
                return userPantryRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Pantry item not found with id: " + id));
    }
    
    public void deletePantryItem(Long id) {
        userPantryRepository.deleteById(id);
    }
    
    public void clearUserPantry(Long userId) {
        userPantryRepository.deleteByUserId(userId);
    }
    
    /**
     * Check if user has sufficient quantity of an ingredient
     * NOTE: This method is intentionally left incomplete for workshop participants
     */
    // TODO: Implement method to check if user has enough of an ingredient
    
    /**
     * Get list of ingredient names that user has in pantry
     * NOTE: Workshop participants will implement this using Copilot
     */
    // TODO: Implement method to get ingredient names from user's pantry
}
