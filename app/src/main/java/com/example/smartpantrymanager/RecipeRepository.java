
package com.example.smartpantrymanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeRepository {

    public static List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        // 1. Cheese Omelette
        recipes.add(new Recipe(
                "Cheese Omelette",
                "A simple omelette with cheese.",
                ingredients("egg", 2, "cheese", 50),
                "1. Beat the eggs.\n2. Cook in a pan.\n3. Add cheese and fold."
        ));

        // 2. Cheese Sandwich
        recipes.add(new Recipe(
                "Cheese Sandwich",
                "A quick cheese sandwich.",
                ingredients("bread", 2, "cheese", 30),
                "1. Place cheese between two slices of bread.\n2. Toast if desired.\n3. Serve."
        ));

        // 3. Tomato and Eggs
        recipes.add(new Recipe(
                "Tomato and Eggs",
                "Eggs cooked with tomato.",
                ingredients("egg", 2, "tomato", 1),
                "1. Chop the tomato.\n2. Cook until soft.\n3. Add eggs and cook thoroughly."
        ));

        // 4. Scrambled Eggs
        recipes.add(new Recipe(
                "Scrambled Eggs",
                "Soft scrambled eggs for breakfast.",
                ingredients("egg", 2, "butter", 10),
                "1. Beat the eggs.\n2. Melt butter in a pan.\n3. Stir the eggs until cooked."
        ));

        // 5. Tomato and Cheese Sandwich
        recipes.add(new Recipe(
                "Tomato and Cheese Sandwich",
                "A fresh sandwich with tomato and cheese.",
                ingredients("bread", 2, "tomato", 1, "cheese", 30),
                "1. Slice the tomato.\n2. Add tomato and cheese to bread.\n3. Serve."
        ));

        // 6. Banana Pancakes
        recipes.add(new Recipe(
                "Banana Pancakes",
                "Sweet pancakes with banana.",
                ingredients("banana", 1, "egg", 1, "flour", 50, "milk", 100),
                "1. Mash the banana.\n2. Mix with egg, flour and milk.\n3. Cook small pancakes in a pan."
        ));

        // 7. Peanut Butter Banana Toast
        recipes.add(new Recipe(
                "Peanut Butter Banana Toast",
                "Toast topped with peanut butter and banana.",
                ingredients("bread", 2, "banana", 1, "peanut butter", 20),
                "1. Toast the bread.\n2. Spread peanut butter.\n3. Add sliced banana."
        ));

        // 8. Tomato Omelette
        recipes.add(new Recipe(
                "Tomato Omelette",
                "An omelette with fresh tomato.",
                ingredients("egg", 2, "tomato", 1),
                "1. Beat the eggs.\n2. Chop the tomato.\n3. Cook together in a pan."
        ));

        // 9. Cheesy Tomato Toast
        recipes.add(new Recipe(
                "Cheesy Tomato Toast",
                "Toasted bread with tomato and cheese.",
                ingredients("bread", 1, "cheese", 30, "tomato", 1),
                "1. Place tomato on bread.\n2. Add cheese.\n3. Toast until the cheese melts."
        ));

        // 10. Banana Smoothie
        recipes.add(new Recipe(
                "Banana Smoothie",
                "A creamy banana drink.",
                ingredients("banana", 1, "milk", 200),
                "1. Peel the banana.\n2. Blend with milk until smooth.\n3. Serve."
        ));

        // 11. Cheese Toast
        recipes.add(new Recipe(
                "Cheese Toast",
                "Simple toast topped with cheese.",
                ingredients("bread", 2, "cheese", 40),
                "1. Place cheese on bread.\n2. Toast until the cheese melts.\n3. Serve warm."
        ));

        // 12. Egg Sandwich
        recipes.add(new Recipe(
                "Egg Sandwich",
                "A simple egg sandwich.",
                ingredients("bread", 2, "egg", 1),
                "1. Cook the egg thoroughly.\n2. Place it between the bread slices.\n3. Serve."
        ));

        // 13. Basic Pancakes
        recipes.add(new Recipe(
                "Basic Pancakes",
                "Easy homemade pancakes.",
                ingredients("egg", 1, "flour", 50, "milk", 100),
                "1. Mix the egg, flour and milk.\n2. Pour into a warm pan.\n3. Cook both sides."
        ));

        // 14. Tomato Salad
        recipes.add(new Recipe(
                "Tomato Salad",
                "A simple fresh salad.",
                ingredients("tomato", 2, "cucumber", 1),
                "1. Wash the vegetables.\n2. Slice the tomato and cucumber.\n3. Mix and serve."
        ));

        // 15. Cucumber and Cheese Salad
        recipes.add(new Recipe(
                "Cucumber and Cheese Salad",
                "A refreshing salad with cheese.",
                ingredients("cucumber", 1, "cheese", 30),
                "1. Wash and slice the cucumber.\n2. Add cheese.\n3. Mix and serve."
        ));

        // 16. Buttered Toast
        recipes.add(new Recipe(
                "Buttered Toast",
                "Crispy toast with butter.",
                ingredients("bread", 2, "butter", 10),
                "1. Toast the bread.\n2. Spread butter over the warm toast.\n3. Serve."
        ));

        // 17. Banana Milkshake
        recipes.add(new Recipe(
                "Banana Milkshake",
                "A chilled banana and milk drink.",
                ingredients("banana", 1, "milk", 250),
                "1. Peel and slice the banana.\n2. Blend with milk.\n3. Serve chilled."
        ));

        // 18. Cheesy Scrambled Eggs
        recipes.add(new Recipe(
                "Cheesy Scrambled Eggs",
                "Creamy scrambled eggs with cheese.",
                ingredients("egg", 2, "cheese", 30, "butter", 5),
                "1. Beat the eggs.\n2. Melt butter in a pan.\n3. Add eggs and cheese and stir until cooked."
        ));

        // 19. Tomato and Egg Sandwich
        recipes.add(new Recipe(
                "Tomato and Egg Sandwich",
                "A filling sandwich with egg and tomato.",
                ingredients("bread", 2, "egg", 1, "tomato", 1),
                "1. Cook the egg thoroughly.\n2. Slice the tomato.\n3. Assemble the sandwich."
        ));

        // 20. Peanut Butter Toast
        recipes.add(new Recipe(
                "Peanut Butter Toast",
                "A quick toast with peanut butter.",
                ingredients("bread", 2, "peanut butter", 20),
                "1. Toast the bread.\n2. Spread peanut butter.\n3. Serve."
        ));

        return recipes;
    }

    private static Map<String, Double> ingredients(Object... values) {
        Map<String, Double> result = new HashMap<>();

        for (int i = 0; i < values.length; i += 2) {
            String name = (String) values[i];
            double quantity = ((Number) values[i + 1]).doubleValue();
            result.put(name, quantity);
        }

        return result;
    }
}
