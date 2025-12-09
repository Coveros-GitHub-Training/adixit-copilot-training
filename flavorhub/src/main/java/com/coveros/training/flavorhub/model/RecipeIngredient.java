package com.coveros.training.flavorhub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an ingredient used in a recipe with quantity
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {
    
    @Column(name = "ingredient_name")
    private String ingredientName;
    
    @Column(name = "quantity")
    private Double quantity;
    
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "notes")
    private String notes; // e.g., "chopped", "diced", "optional"
}
