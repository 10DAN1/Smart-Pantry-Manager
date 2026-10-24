
package com.example.smartpantrymanager;

import java.util.Map;

public class Recipe {

    private final String name;
    private final String description;
    private final Map<String, Double> ingredients;
    private final String instructions;

    public Recipe(
            String name,
            String description,
            Map<String, Double> ingredients,
            String instructions) {

        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Double> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }
}
