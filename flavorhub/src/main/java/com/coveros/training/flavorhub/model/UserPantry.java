package com.coveros.training.flavorhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an ingredient in a user's pantry with quantity
 */
@Entity
@Table(name = "user_pantry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPantry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    @NotNull(message = "User ID is required")
    private Long userId; // In a real app, this would be a relationship to a User entity
    
    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    @NotNull(message = "Ingredient is required")
    private Ingredient ingredient;
    
    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity must be positive")
    private Double quantity;
    
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "notes")
    private String notes; // e.g., "expires soon", "in freezer"
    
    public UserPantry(Long userId, Ingredient ingredient, Double quantity, String unit) {
        this.userId = userId;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }
}
