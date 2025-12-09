package com.coveros.training.flavorhub.controller;

import com.coveros.training.flavorhub.model.UserPantry;
import com.coveros.training.flavorhub.service.UserPantryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * REST Controller for managing user pantry
 * NOTE: Some endpoints are intentionally incomplete for workshop exercises
 */
@RestController
@RequestMapping("/api/pantry")
@RequiredArgsConstructor
public class UserPantryController {
    
    private final UserPantryService userPantryService;
    
    /**
     * Get all pantry items for a specific user
     * For simplicity, we're using a hardcoded userId (1)
     * In a real application, this would come from authentication
     */
    @GetMapping
    public ResponseEntity<List<UserPantry>> getUserPantry() {
        Long userId = 1L; // Hardcoded for workshop purposes
        return ResponseEntity.ok(userPantryService.getUserPantry(userId));
    }
    
    /**
     * Get a specific pantry item by ID
     * NOTE: Workshop participants will implement this endpoint using Copilot
     */
    // TODO: Implement GET /api/pantry/{id} endpoint
    
    /**
     * Add an item to the user's pantry
     */
    @PostMapping
    public ResponseEntity<UserPantry> addPantryItem(@Valid @RequestBody UserPantry pantryItem) {
        Long userId = 1L; // Hardcoded for workshop purposes
        pantryItem.setUserId(userId);
        UserPantry saved = userPantryService.addPantryItem(pantryItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    /**
     * Update quantity of a pantry item
     * NOTE: Workshop participants will implement this endpoint using Copilot
     */
    // TODO: Implement PUT /api/pantry/{id} endpoint
    
    /**
     * Delete a pantry item
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePantryItem(@PathVariable Long id) {
        userPantryService.deletePantryItem(id);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Clear all items from user's pantry
     * NOTE: Workshop participants will implement this endpoint using Copilot
     */
    // TODO: Implement DELETE /api/pantry endpoint to clear all items
}
