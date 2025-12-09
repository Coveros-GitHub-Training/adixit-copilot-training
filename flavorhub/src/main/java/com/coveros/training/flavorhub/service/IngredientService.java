package com.coveros.training.flavorhub.service;

import com.coveros.training.flavorhub.model.Ingredient;
import com.coveros.training.flavorhub.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing ingredients
 */
@Service
@RequiredArgsConstructor
@Transactional
public class IngredientService {
    
    private final IngredientRepository ingredientRepository;
    
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    
    public Optional<Ingredient> getIngredientById(Long id) {
        return ingredientRepository.findById(id);
    }
    
    public Optional<Ingredient> getIngredientByName(String name) {
        return ingredientRepository.findByNameIgnoreCase(name);
    }
    
    public List<Ingredient> getIngredientsByCategory(String category) {
        return ingredientRepository.findByCategory(category);
    }
    
    public List<Ingredient> searchIngredients(String searchTerm) {
        return ingredientRepository.findByNameContainingIgnoreCase(searchTerm);
    }
    
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
    
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
