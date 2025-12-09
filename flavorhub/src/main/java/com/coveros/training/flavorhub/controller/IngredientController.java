package com.coveros.training.flavorhub.controller;

import com.coveros.training.flavorhub.model.Ingredient;
import com.coveros.training.flavorhub.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * REST Controller for managing ingredients
 */
@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    
    private final IngredientService ingredientService;
    
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Ingredient>> searchIngredients(@RequestParam String query) {
        return ResponseEntity.ok(ingredientService.searchIngredients(query));
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Ingredient>> getIngredientsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(ingredientService.getIngredientsByCategory(category));
    }
    
    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody Ingredient ingredient) {
        Ingredient saved = ingredientService.saveIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @PathVariable Long id, 
            @Valid @RequestBody Ingredient ingredient) {
        return ingredientService.getIngredientById(id)
                .map(existing -> {
                    ingredient.setId(id);
                    return ResponseEntity.ok(ingredientService.saveIngredient(ingredient));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }
}
