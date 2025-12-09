package com.coveros.training.flavorhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an ingredient that can be used in recipes
 */
@Entity
@Table(name = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Ingredient name is required")
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(name = "category")
    private String category; // e.g., "Dairy", "Vegetable", "Spice", "Meat"
    
    @Column(name = "unit")
    private String unit; // e.g., "cups", "tablespoons", "grams"
    
    public Ingredient(String name, String category, String unit) {
        this.name = name;
        this.category = category;
        this.unit = unit;
    }
}
