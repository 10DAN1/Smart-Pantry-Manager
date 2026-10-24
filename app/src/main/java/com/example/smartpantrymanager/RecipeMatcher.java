
package com.example.smartpantrymanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RecipeMatcher {

    public static List<Recipe> findMatchingRecipes(
            List<Recipe> recipes,
            Map<String, Double> pantryIngredients) {

        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            boolean allIngredientsAvailable = true;

            for (Map.Entry<String, Double> required :
                    recipe.getIngredients().entrySet()) {

                String ingredientName = normalise(
                        required.getKey());

                double requiredQuantity = required.getValue();

                Double pantryQuantity =
                        pantryIngredients.get(ingredientName);

                if (pantryQuantity == null ||
                        pantryQuantity < requiredQuantity) {

                    allIngredientsAvailable = false;
                    break;
                }
            }

            if (allIngredientsAvailable) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }

    private static String normalise(String name) {
        return name.trim().toLowerCase(Locale.ROOT);
    }
}

