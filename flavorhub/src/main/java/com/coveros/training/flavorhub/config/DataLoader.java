package com.coveros.training.flavorhub.config;

import com.coveros.training.flavorhub.model.*;
import com.coveros.training.flavorhub.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Loads sample data into the database on application startup
 * This provides a working dataset for the GitHub Copilot workshop
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final UserPantryRepository userPantryRepository;
    
    @Override
    public void run(String... args) {
        loadIngredients();
        loadRecipes();
        loadSamplePantry();
    }
    
    private void loadIngredients() {
        // Dairy
        ingredientRepository.save(new Ingredient("Milk", "Dairy", "cups"));
        ingredientRepository.save(new Ingredient("Butter", "Dairy", "tablespoons"));
        ingredientRepository.save(new Ingredient("Cheese", "Dairy", "cups"));
        ingredientRepository.save(new Ingredient("Eggs", "Dairy", "whole"));
        ingredientRepository.save(new Ingredient("Heavy Cream", "Dairy", "cups"));
        ingredientRepository.save(new Ingredient("Yogurt", "Dairy", "cups"));
        ingredientRepository.save(new Ingredient("Sour Cream", "Dairy", "tablespoons"));
        ingredientRepository.save(new Ingredient("Mozzarella Cheese", "Dairy", "cups"));
        
        // Vegetables
        ingredientRepository.save(new Ingredient("Tomato", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Onion", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Garlic", "Vegetable", "cloves"));
        ingredientRepository.save(new Ingredient("Bell Pepper", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Spinach", "Vegetable", "cups"));
        ingredientRepository.save(new Ingredient("Carrot", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Mushrooms", "Vegetable", "cups"));
        ingredientRepository.save(new Ingredient("Broccoli", "Vegetable", "cups"));
        ingredientRepository.save(new Ingredient("Zucchini", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Potato", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Celery", "Vegetable", "stalks"));
        ingredientRepository.save(new Ingredient("Lettuce", "Vegetable", "heads"));
        ingredientRepository.save(new Ingredient("Cucumber", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Jalapeño", "Vegetable", "whole"));
        ingredientRepository.save(new Ingredient("Cilantro", "Vegetable", "cups"));
        
        // Proteins
        ingredientRepository.save(new Ingredient("Chicken Breast", "Protein", "pounds"));
        ingredientRepository.save(new Ingredient("Ground Beef", "Protein", "pounds"));
        ingredientRepository.save(new Ingredient("Salmon", "Protein", "pounds"));
        ingredientRepository.save(new Ingredient("Shrimp", "Protein", "pounds"));
        ingredientRepository.save(new Ingredient("Tofu", "Protein", "pounds"));
        ingredientRepository.save(new Ingredient("Bacon", "Protein", "slices"));
        ingredientRepository.save(new Ingredient("Pork Chops", "Protein", "whole"));
        ingredientRepository.save(new Ingredient("Chicken Thighs", "Protein", "pounds"));
        
        // Grains
        ingredientRepository.save(new Ingredient("Rice", "Grain", "cups"));
        ingredientRepository.save(new Ingredient("Pasta", "Grain", "cups"));
        ingredientRepository.save(new Ingredient("Bread", "Grain", "slices"));
        ingredientRepository.save(new Ingredient("Flour", "Grain", "cups"));
        ingredientRepository.save(new Ingredient("Tortillas", "Grain", "whole"));
        ingredientRepository.save(new Ingredient("Quinoa", "Grain", "cups"));
        ingredientRepository.save(new Ingredient("Breadcrumbs", "Grain", "cups"));
        
        // Spices & Herbs
        ingredientRepository.save(new Ingredient("Salt", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Black Pepper", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Cumin", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Paprika", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Oregano", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Basil", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Thyme", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Chili Powder", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Cayenne Pepper", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Ginger", "Spice", "teaspoons"));
        ingredientRepository.save(new Ingredient("Cinnamon", "Spice", "teaspoons"));
        
        // Condiments & Sauces
        ingredientRepository.save(new Ingredient("Olive Oil", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Soy Sauce", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Vegetable Oil", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Sesame Oil", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Honey", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Lemon Juice", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Lime Juice", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Vinegar", "Condiment", "tablespoons"));
        ingredientRepository.save(new Ingredient("Tomato Sauce", "Condiment", "cups"));
        ingredientRepository.save(new Ingredient("Chicken Broth", "Condiment", "cups"));
        ingredientRepository.save(new Ingredient("Coconut Milk", "Condiment", "cups"));
        
        // Fruits
        ingredientRepository.save(new Ingredient("Lemon", "Fruit", "whole"));
        ingredientRepository.save(new Ingredient("Lime", "Fruit", "whole"));
        ingredientRepository.save(new Ingredient("Avocado", "Fruit", "whole"));
        ingredientRepository.save(new Ingredient("Tomatoes (Canned)", "Fruit", "cans"));
        ingredientRepository.save(new Ingredient("Apple", "Fruit", "whole"));
        
        // Baking
        ingredientRepository.save(new Ingredient("Sugar", "Baking", "cups"));
        ingredientRepository.save(new Ingredient("Brown Sugar", "Baking", "cups"));
        ingredientRepository.save(new Ingredient("Baking Powder", "Baking", "teaspoons"));
        ingredientRepository.save(new Ingredient("Vanilla Extract", "Baking", "teaspoons"));
        
        // Nuts & Seeds
        ingredientRepository.save(new Ingredient("Almonds", "Nuts & Seeds", "cups"));
        ingredientRepository.save(new Ingredient("Peanuts", "Nuts & Seeds", "cups"));
        ingredientRepository.save(new Ingredient("Sesame Seeds", "Nuts & Seeds", "tablespoons"));
    }
    
    private void loadRecipes() {
        // Recipe 1: Classic Spaghetti Carbonara
        Recipe carbonara = new Recipe(
            "Classic Spaghetti Carbonara",
            "A traditional Italian pasta dish with eggs, cheese, and pancetta",
            15, 15, 4, "Medium", "Italian"
        );
        carbonara.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Pasta", 1.0, "pounds", "spaghetti"),
            new RecipeIngredient("Eggs", 4.0, "whole", ""),
            new RecipeIngredient("Cheese", 1.0, "cups", "Parmesan, grated"),
            new RecipeIngredient("Black Pepper", 1.0, "teaspoons", "freshly ground")
        ));
        carbonara.getInstructions().addAll(Arrays.asList(
            "Cook pasta according to package directions",
            "Beat eggs and mix with grated cheese",
            "Drain pasta and immediately mix with egg mixture",
            "Season with black pepper and serve hot"
        ));
        recipeRepository.save(carbonara);
        
        // Recipe 2: Grilled Chicken with Herbs
        Recipe grilledChicken = new Recipe(
            "Grilled Chicken with Herbs",
            "Juicy grilled chicken breast seasoned with fresh herbs",
            10, 20, 4, "Easy", "American"
        );
        grilledChicken.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Chicken Breast", 2.0, "pounds", ""),
            new RecipeIngredient("Olive Oil", 3.0, "tablespoons", ""),
            new RecipeIngredient("Garlic", 4.0, "cloves", "minced"),
            new RecipeIngredient("Salt", 1.0, "teaspoons", ""),
            new RecipeIngredient("Black Pepper", 0.5, "teaspoons", "")
        ));
        grilledChicken.getInstructions().addAll(Arrays.asList(
            "Marinate chicken with olive oil, garlic, salt, and pepper",
            "Let sit for at least 30 minutes",
            "Preheat grill to medium-high heat",
            "Grill chicken for 6-7 minutes per side until cooked through",
            "Let rest for 5 minutes before serving"
        ));
        recipeRepository.save(grilledChicken);
        
        // Recipe 3: Vegetable Stir-Fry
        Recipe stirFry = new Recipe(
            "Quick Vegetable Stir-Fry",
            "Colorful mix of vegetables stir-fried in a savory sauce",
            10, 10, 3, "Easy", "Asian"
        );
        stirFry.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Bell Pepper", 2.0, "whole", "sliced"),
            new RecipeIngredient("Onion", 1.0, "whole", "sliced"),
            new RecipeIngredient("Garlic", 3.0, "cloves", "minced"),
            new RecipeIngredient("Soy Sauce", 3.0, "tablespoons", ""),
            new RecipeIngredient("Olive Oil", 2.0, "tablespoons", "")
        ));
        stirFry.getInstructions().addAll(Arrays.asList(
            "Heat oil in a large wok or skillet over high heat",
            "Add garlic and stir-fry for 30 seconds",
            "Add vegetables and stir-fry for 5-7 minutes",
            "Add soy sauce and toss to coat",
            "Serve immediately over rice"
        ));
        recipeRepository.save(stirFry);
        
        // Recipe 4: Tomato Basil Soup (intentionally missing some details for workshop)
        Recipe tomatoSoup = new Recipe(
            "Creamy Tomato Basil Soup",
            "A comforting soup perfect for any season",
            15, 30, 6, "Easy", "Italian"
        );
        // NOTE: Ingredients and instructions intentionally incomplete
        // Workshop participants will use Copilot to complete this recipe
        tomatoSoup.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Tomato", 8.0, "whole", "chopped"),
            new RecipeIngredient("Onion", 1.0, "whole", "diced"),
            new RecipeIngredient("Garlic", 4.0, "cloves", "minced")
            // TODO: Add more ingredients using Copilot during the workshop
        ));
        recipeRepository.save(tomatoSoup);
        
        // Recipe 5: Chicken Tikka Masala
        Recipe tikkaMasala = new Recipe(
            "Chicken Tikka Masala",
            "Creamy Indian curry with marinated chicken in a rich tomato sauce",
            20, 30, 6, "Medium", "Indian"
        );
        tikkaMasala.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Chicken Breast", 2.0, "pounds", "cut into chunks"),
            new RecipeIngredient("Yogurt", 1.0, "cups", "plain"),
            new RecipeIngredient("Tomato Sauce", 2.0, "cups", ""),
            new RecipeIngredient("Heavy Cream", 0.5, "cups", ""),
            new RecipeIngredient("Onion", 1.0, "whole", "diced"),
            new RecipeIngredient("Garlic", 4.0, "cloves", "minced"),
            new RecipeIngredient("Ginger", 1.0, "teaspoons", "grated"),
            new RecipeIngredient("Cumin", 2.0, "teaspoons", ""),
            new RecipeIngredient("Paprika", 2.0, "teaspoons", ""),
            new RecipeIngredient("Cayenne Pepper", 0.5, "teaspoons", "")
        ));
        tikkaMasala.getInstructions().addAll(Arrays.asList(
            "Marinate chicken in yogurt, half the garlic, ginger, and spices for 1 hour",
            "Sauté onions until golden, add remaining garlic and ginger",
            "Add tomato sauce and remaining spices, simmer for 10 minutes",
            "Grill or pan-fry marinated chicken until cooked through",
            "Add chicken to sauce, stir in cream",
            "Simmer for 10 minutes and serve with rice or naan"
        ));
        recipeRepository.save(tikkaMasala);
        
        // Recipe 6: Classic Beef Tacos (Easy)
        Recipe beefTacos = new Recipe(
            "Classic Beef Tacos",
            "Quick and delicious Mexican tacos with seasoned ground beef",
            10, 15, 4, "Easy", "Mexican"
        );
        beefTacos.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Ground Beef", 1.0, "pounds", ""),
            new RecipeIngredient("Tortillas", 8.0, "whole", "corn or flour"),
            new RecipeIngredient("Lettuce", 0.5, "heads", "shredded"),
            new RecipeIngredient("Tomato", 2.0, "whole", "diced"),
            new RecipeIngredient("Cheese", 1.0, "cups", "shredded"),
            new RecipeIngredient("Onion", 0.5, "whole", "diced"),
            new RecipeIngredient("Cumin", 1.0, "teaspoons", ""),
            new RecipeIngredient("Chili Powder", 2.0, "teaspoons", ""),
            new RecipeIngredient("Salt", 0.5, "teaspoons", "")
        ));
        beefTacos.getInstructions().addAll(Arrays.asList(
            "Brown ground beef in a large skillet over medium-high heat",
            "Drain excess fat and add cumin, chili powder, and salt",
            "Add 1/4 cup water and simmer for 5 minutes",
            "Warm tortillas in microwave or on griddle",
            "Assemble tacos with beef, lettuce, tomatoes, cheese, and onions",
            "Serve with salsa and sour cream if desired"
        ));
        recipeRepository.save(beefTacos);
        
        // Recipe 7: Mediterranean Quinoa Salad (Easy)
        Recipe quinoaSalad = new Recipe(
            "Mediterranean Quinoa Salad",
            "Fresh and healthy salad with quinoa, vegetables, and lemon dressing",
            15, 15, 6, "Easy", "Mediterranean"
        );
        quinoaSalad.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Quinoa", 1.5, "cups", ""),
            new RecipeIngredient("Cucumber", 1.0, "whole", "diced"),
            new RecipeIngredient("Tomato", 3.0, "whole", "diced"),
            new RecipeIngredient("Bell Pepper", 1.0, "whole", "diced"),
            new RecipeIngredient("Lemon Juice", 3.0, "tablespoons", "fresh"),
            new RecipeIngredient("Olive Oil", 4.0, "tablespoons", ""),
            new RecipeIngredient("Oregano", 1.0, "teaspoons", "dried"),
            new RecipeIngredient("Salt", 1.0, "teaspoons", "")
        ));
        quinoaSalad.getInstructions().addAll(Arrays.asList(
            "Cook quinoa according to package directions and let cool",
            "Chop all vegetables into small, uniform pieces",
            "Whisk together lemon juice, olive oil, oregano, and salt",
            "Combine cooled quinoa with vegetables in a large bowl",
            "Pour dressing over salad and toss well",
            "Refrigerate for at least 30 minutes before serving"
        ));
        recipeRepository.save(quinoaSalad);
        
        // Recipe 8: Pad Thai (Medium)
        Recipe padThai = new Recipe(
            "Authentic Pad Thai",
            "Classic Thai stir-fried noodles with shrimp and peanuts",
            25, 15, 4, "Medium", "Asian"
        );
        padThai.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Rice", 8.0, "cups", "rice noodles, dried"),
            new RecipeIngredient("Shrimp", 1.0, "pounds", "peeled and deveined"),
            new RecipeIngredient("Eggs", 3.0, "whole", ""),
            new RecipeIngredient("Peanuts", 0.5, "cups", "crushed"),
            new RecipeIngredient("Soy Sauce", 3.0, "tablespoons", ""),
            new RecipeIngredient("Lime Juice", 2.0, "tablespoons", ""),
            new RecipeIngredient("Sugar", 2.0, "tablespoons", ""),
            new RecipeIngredient("Garlic", 3.0, "cloves", "minced"),
            new RecipeIngredient("Vegetable Oil", 3.0, "tablespoons", "")
        ));
        padThai.getInstructions().addAll(Arrays.asList(
            "Soak rice noodles in warm water for 30 minutes, then drain",
            "Mix soy sauce, lime juice, and sugar to make sauce",
            "Heat oil in wok over high heat, scramble eggs and set aside",
            "Stir-fry garlic and shrimp until shrimp turns pink",
            "Add noodles and sauce, toss for 2-3 minutes",
            "Add eggs back in, top with crushed peanuts and serve with lime wedges"
        ));
        recipeRepository.save(padThai);
        
        // Recipe 9: Mushroom Risotto (Hard)
        Recipe risotto = new Recipe(
            "Creamy Mushroom Risotto",
            "Classic Italian rice dish with mushrooms and parmesan",
            15, 35, 4, "Hard", "Italian"
        );
        risotto.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Rice", 1.5, "cups", "Arborio rice"),
            new RecipeIngredient("Mushrooms", 2.0, "cups", "sliced"),
            new RecipeIngredient("Chicken Broth", 6.0, "cups", "warm"),
            new RecipeIngredient("Cheese", 0.5, "cups", "Parmesan, grated"),
            new RecipeIngredient("Onion", 1.0, "whole", "finely diced"),
            new RecipeIngredient("Garlic", 3.0, "cloves", "minced"),
            new RecipeIngredient("Butter", 4.0, "tablespoons", ""),
            new RecipeIngredient("Olive Oil", 2.0, "tablespoons", ""),
            new RecipeIngredient("Thyme", 1.0, "teaspoons", "fresh")
        ));
        risotto.getInstructions().addAll(Arrays.asList(
            "Sauté mushrooms in butter until golden, set aside",
            "In same pan, heat oil and cook onions until translucent",
            "Add garlic and rice, stir until rice is lightly toasted",
            "Add warm broth one ladle at a time, stirring constantly",
            "Wait until liquid is absorbed before adding more broth",
            "After 25-30 minutes, rice should be creamy but al dente",
            "Stir in mushrooms, parmesan, remaining butter, and thyme",
            "Let rest 2 minutes before serving"
        ));
        recipeRepository.save(risotto);
        
        // Recipe 10: Beef Bourguignon (Hard)
        Recipe bourguignon = new Recipe(
            "Beef Bourguignon",
            "Classic French beef stew braised in red wine with vegetables",
            30, 150, 6, "Hard", "French"
        );
        bourguignon.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Ground Beef", 3.0, "pounds", "chuck, cubed"),
            new RecipeIngredient("Bacon", 6.0, "slices", "chopped"),
            new RecipeIngredient("Carrot", 3.0, "whole", "sliced"),
            new RecipeIngredient("Onion", 2.0, "whole", "quartered"),
            new RecipeIngredient("Mushrooms", 2.0, "cups", "quartered"),
            new RecipeIngredient("Garlic", 4.0, "cloves", "minced"),
            new RecipeIngredient("Tomato Sauce", 2.0, "cups", ""),
            new RecipeIngredient("Chicken Broth", 2.0, "cups", ""),
            new RecipeIngredient("Flour", 0.25, "cups", ""),
            new RecipeIngredient("Thyme", 2.0, "teaspoons", "fresh"),
            new RecipeIngredient("Butter", 2.0, "tablespoons", "")
        ));
        bourguignon.getInstructions().addAll(Arrays.asList(
            "Cook bacon until crispy, remove and set aside",
            "Brown beef cubes in bacon fat, working in batches",
            "Remove beef and sauté carrots and onions until golden",
            "Sprinkle flour over vegetables, stir for 2 minutes",
            "Add tomato sauce, broth, thyme, and return beef and bacon to pot",
            "Bring to boil, then reduce heat and simmer covered for 2.5 hours",
            "In last 30 minutes, sauté mushrooms in butter and add to stew",
            "Adjust seasoning and serve over mashed potatoes or egg noodles"
        ));
        recipeRepository.save(bourguignon);
        
        // Recipe 11: Shrimp Scampi (Medium)
        Recipe shrimpScampi = new Recipe(
            "Garlic Shrimp Scampi",
            "Succulent shrimp in a buttery garlic and white wine sauce",
            10, 15, 4, "Medium", "Italian"
        );
        shrimpScampi.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Shrimp", 1.5, "pounds", "large, peeled and deveined"),
            new RecipeIngredient("Pasta", 1.0, "pounds", "linguine or spaghetti"),
            new RecipeIngredient("Butter", 6.0, "tablespoons", ""),
            new RecipeIngredient("Garlic", 6.0, "cloves", "minced"),
            new RecipeIngredient("Lemon Juice", 3.0, "tablespoons", "fresh"),
            new RecipeIngredient("Olive Oil", 2.0, "tablespoons", ""),
            new RecipeIngredient("Black Pepper", 0.5, "teaspoons", ""),
            new RecipeIngredient("Salt", 0.5, "teaspoons", "")
        ));
        shrimpScampi.getInstructions().addAll(Arrays.asList(
            "Cook pasta according to package directions, reserve 1 cup pasta water",
            "Heat oil and 2 tablespoons butter in large skillet",
            "Add shrimp, season with salt and pepper, cook 2 minutes per side",
            "Remove shrimp and add garlic to pan, cook 30 seconds",
            "Add lemon juice and 1/2 cup pasta water, bring to simmer",
            "Add remaining butter and cooked pasta, toss to coat",
            "Return shrimp to pan, toss everything together and serve"
        ));
        recipeRepository.save(shrimpScampi);
        
        // Recipe 12: Thai Green Curry (Medium)
        Recipe greenCurry = new Recipe(
            "Thai Green Curry",
            "Aromatic Thai curry with vegetables in coconut milk",
            15, 25, 4, "Medium", "Asian"
        );
        greenCurry.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Chicken Breast", 1.0, "pounds", "sliced thin"),
            new RecipeIngredient("Coconut Milk", 2.0, "cups", ""),
            new RecipeIngredient("Bell Pepper", 2.0, "whole", "sliced"),
            new RecipeIngredient("Zucchini", 1.0, "whole", "sliced"),
            new RecipeIngredient("Basil", 0.5, "cups", "Thai basil"),
            new RecipeIngredient("Garlic", 3.0, "cloves", "minced"),
            new RecipeIngredient("Ginger", 1.0, "teaspoons", "grated"),
            new RecipeIngredient("Vegetable Oil", 2.0, "tablespoons", ""),
            new RecipeIngredient("Soy Sauce", 2.0, "tablespoons", "")
        ));
        greenCurry.getInstructions().addAll(Arrays.asList(
            "Heat oil in large pot over medium-high heat",
            "Add garlic and ginger, cook until fragrant",
            "Add chicken and cook until no longer pink",
            "Pour in coconut milk and bring to simmer",
            "Add bell peppers and zucchini, cook for 10 minutes",
            "Stir in soy sauce and Thai basil just before serving",
            "Serve over jasmine rice"
        ));
        recipeRepository.save(greenCurry);
        
        // Recipe 13: Margherita Pizza (Medium)
        Recipe margheritaPizza = new Recipe(
            "Classic Margherita Pizza",
            "Traditional Italian pizza with tomato, mozzarella, and fresh basil",
            90, 15, 4, "Medium", "Italian"
        );
        margheritaPizza.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Flour", 3.0, "cups", "all-purpose"),
            new RecipeIngredient("Tomato Sauce", 1.0, "cups", ""),
            new RecipeIngredient("Mozzarella Cheese", 2.0, "cups", "fresh, sliced"),
            new RecipeIngredient("Basil", 0.25, "cups", "fresh leaves"),
            new RecipeIngredient("Olive Oil", 3.0, "tablespoons", ""),
            new RecipeIngredient("Sugar", 1.0, "tablespoons", ""),
            new RecipeIngredient("Salt", 2.0, "teaspoons", "")
        ));
        margheritaPizza.getInstructions().addAll(Arrays.asList(
            "Make dough: mix flour, water, yeast, sugar, and salt; knead and let rise 1 hour",
            "Preheat oven to 475°F with pizza stone if available",
            "Divide dough into 2 portions and roll out thin",
            "Spread tomato sauce evenly, leaving 1-inch border",
            "Top with mozzarella slices",
            "Bake for 12-15 minutes until crust is golden and cheese bubbles",
            "Remove from oven and immediately top with fresh basil and drizzle of olive oil"
        ));
        recipeRepository.save(margheritaPizza);
        
        // Recipe 14: Chocolate Lava Cake (Hard)
        Recipe lavaCake = new Recipe(
            "Molten Chocolate Lava Cake",
            "Decadent individual chocolate cakes with a gooey molten center",
            15, 12, 4, "Hard", "French"
        );
        lavaCake.getIngredients().addAll(Arrays.asList(
            new RecipeIngredient("Butter", 8.0, "tablespoons", "plus extra for ramekins"),
            new RecipeIngredient("Sugar", 0.5, "cups", "plus extra for dusting"),
            new RecipeIngredient("Eggs", 2.0, "whole", ""),
            new RecipeIngredient("Flour", 0.25, "cups", ""),
            new RecipeIngredient("Vanilla Extract", 1.0, "teaspoons", ""),
            new RecipeIngredient("Salt", 0.25, "teaspoons", "")
        ));
        lavaCake.getInstructions().addAll(Arrays.asList(
            "Preheat oven to 425°F and butter four 6-oz ramekins, dust with sugar",
            "Melt chocolate and butter together in double boiler",
            "Whisk eggs and sugar until thick and pale",
            "Fold melted chocolate into egg mixture",
            "Gently fold in flour, vanilla, and salt",
            "Divide batter among ramekins and place on baking sheet",
            "Bake for 12-14 minutes until edges are firm but center jiggles",
            "Let rest 1 minute, then invert onto plates and serve immediately"
        ));
        recipeRepository.save(lavaCake);
    }
    
    private void loadSamplePantry() {
        // Add some items to user 1's pantry
        Long userId = 1L;
        
        // Dairy products
        ingredientRepository.findByNameIgnoreCase("Eggs").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 12.0, "whole"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Milk").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 2.0, "cups"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Cheese").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 1.5, "cups"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Butter").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 8.0, "tablespoons"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Heavy Cream").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 1.0, "cups"))
        );
        
        // Grains & Pasta
        ingredientRepository.findByNameIgnoreCase("Pasta").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 2.0, "pounds"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Rice").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 3.0, "cups"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Flour").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 5.0, "cups"))
        );
        
        // Vegetables
        ingredientRepository.findByNameIgnoreCase("Onion").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 3.0, "whole"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Garlic").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 10.0, "cloves"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Tomato").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 4.0, "whole"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Bell Pepper").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 2.0, "whole"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Carrot").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 5.0, "whole"))
        );
        
        // Proteins
        ingredientRepository.findByNameIgnoreCase("Chicken Breast").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 2.0, "pounds"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Ground Beef").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 1.5, "pounds"))
        );
        
        // Condiments & Oils
        ingredientRepository.findByNameIgnoreCase("Olive Oil").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 1.0, "cups"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Soy Sauce").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 6.0, "tablespoons"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Tomato Sauce").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 2.0, "cups"))
        );
        
        // Spices
        ingredientRepository.findByNameIgnoreCase("Salt").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 10.0, "teaspoons"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Black Pepper").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 5.0, "teaspoons"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Cumin").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 3.0, "teaspoons"))
        );
        
        ingredientRepository.findByNameIgnoreCase("Paprika").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 2.0, "teaspoons"))
        );
        
        // Baking supplies
        ingredientRepository.findByNameIgnoreCase("Sugar").ifPresent(ingredient ->
            userPantryRepository.save(new UserPantry(userId, ingredient, 3.0, "cups"))
        );
    }
}
