

package com.example.smartpantrymanager;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RecipesActivity extends AppCompatActivity {

    private PantryDatabaseHelper databaseHelper;
    private LinearLayout recipeList;
    private TextView txtRecipeStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipeList = findViewById(R.id.recipeList);
        txtRecipeStatus = findViewById(R.id.txtRecipeStatus);

        databaseHelper = new PantryDatabaseHelper(this);

        Button btnBackToHome = findViewById(R.id.btnBackToHome);
        btnBackToHome.setOnClickListener(v -> finish());

        showSuggestedRecipes();
    }

    private void showSuggestedRecipes() {
        Map<String, Double> pantryIngredients = new HashMap<>();
        Map<String, String> pantryUnits = new HashMap<>();

        try (Cursor cursor = databaseHelper.getAllIngredients()) {
            while (cursor != null && cursor.moveToNext()) {
                String name = cursor.getString(
                                cursor.getColumnIndexOrThrow(
                                        PantryDatabaseHelper.COL_NAME))
                        .trim().toLowerCase(Locale.ROOT);

                double quantity = cursor.getDouble(
                        cursor.getColumnIndexOrThrow(
                                PantryDatabaseHelper.COL_QUANTITY));

                String unit = cursor.getString(
                                cursor.getColumnIndexOrThrow(
                                        PantryDatabaseHelper.COL_UNIT))
                        .trim().toLowerCase(Locale.ROOT);

                // Combine quantities for duplicate ingredients
                double existingQuantity = 0.0;

                if (pantryIngredients.containsKey(name)) {
                    existingQuantity = pantryIngredients.get(name);
                }

                pantryIngredients.put(name, existingQuantity + quantity);

                pantryUnits.put(name, unit);
            }
        }

        List<Recipe> recipes = RecipeRepository.getRecipes();
        List<Recipe> matchingRecipes =
                RecipeMatcher.findMatchingRecipes(
                        recipes, pantryIngredients);

        recipeList.removeAllViews();

        if (matchingRecipes.isEmpty()) {
            txtRecipeStatus.setText(
                    "No matching recipes yet. Add the required ingredients "
                            + "to your pantry to see suggestions.");
            return;
        }

        txtRecipeStatus.setText(
                "You can make " + matchingRecipes.size() + " recipe(s)!");

        for (Recipe recipe : matchingRecipes) {
            boolean unitsMatch = true;

            for (String ingredientName :
                    recipe.getIngredients().keySet()) {

                String pantryUnit = pantryUnits.get(ingredientName);

                if (pantryUnit == null ||
                        !isCompatibleUnit(ingredientName, pantryUnit)) {
                    unitsMatch = false;
                    break;
                }
            }

            if (!unitsMatch) {
                continue;
            }

            TextView recipeItem = new TextView(this);

            recipeItem.setText(
                    recipe.getName() + "\n" +
                            recipe.getDescription());

            recipeItem.setTextSize(18);
            recipeItem.setTextColor(
                    getResources().getColor(
                            R.color.pantry_primary, getTheme()));

            recipeItem.setPadding(16, 20, 16, 20);

            recipeItem.setBackgroundColor(
                    getResources().getColor(
                            R.color.pantry_white, getTheme()));

            recipeItem.setClickable(true);
            recipeItem.setFocusable(true);

            recipeItem.setOnClickListener(v -> {
                Intent intent = new Intent(
                        RecipesActivity.this,
                        RecipeDetailActivity.class);

                intent.putExtra("recipe_name", recipe.getName());
                intent.putExtra("recipe_description", recipe.getDescription());
                intent.putExtra("recipe_instructions", recipe.getInstructions());

                StringBuilder ingredientDetails = new StringBuilder();

                for (Map.Entry<String, Double> entry :
                        recipe.getIngredients().entrySet()) {

                    ingredientDetails.append("• ")
                            .append(entry.getKey())
                            .append(": ")
                            .append(entry.getValue())
                            .append("\n");
                }

                intent.putExtra(
                        "recipe_ingredients",
                        ingredientDetails.toString());

                startActivity(intent);
            });

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(0, 0, 0, 16);
            recipeItem.setLayoutParams(params);

            recipeList.addView(recipeItem);
        }

        if (recipeList.getChildCount() == 0) {
            txtRecipeStatus.setText(
                    "No recipes match your ingredient names and units yet.");
        }
    }


    private boolean isCompatibleUnit(
            String ingredientName, String pantryUnit) {

        switch (ingredientName) {
            case "egg":
                return pantryUnit.equals("egg")
                        || pantryUnit.equals("eggs")
                        || pantryUnit.equals("piece")
                        || pantryUnit.equals("pieces");

            case "cheese":
                return pantryUnit.equals("g")
                        || pantryUnit.equals("gram")
                        || pantryUnit.equals("grams");

            case "bread":
                return pantryUnit.equals("slice")
                        || pantryUnit.equals("slices")
                        || pantryUnit.equals("piece")
                        || pantryUnit.equals("pieces");

            case "tomato":
                return pantryUnit.equals("tomato")
                        || pantryUnit.equals("tomatoes")
                        || pantryUnit.equals("piece")
                        || pantryUnit.equals("pieces");

            case "banana":
                return pantryUnit.equals("banana")
                        || pantryUnit.equals("bananas")
                        || pantryUnit.equals("piece")
                        || pantryUnit.equals("pieces");

            case "milk":
                return pantryUnit.equals("ml")
                        || pantryUnit.equals("millilitre")
                        || pantryUnit.equals("millilitres");

            case "flour":
                return pantryUnit.equals("g")
                        || pantryUnit.equals("gram")
                        || pantryUnit.equals("grams");

            case "butter":
                return pantryUnit.equals("g")
                        || pantryUnit.equals("gram")
                        || pantryUnit.equals("grams");

            case "cucumber":
                return pantryUnit.equals("cucumber")
                        || pantryUnit.equals("cucumbers")
                        || pantryUnit.equals("piece")
                        || pantryUnit.equals("pieces");

            case "peanut butter":
                return pantryUnit.equals("g")
                        || pantryUnit.equals("gram")
                        || pantryUnit.equals("grams");

            default:
                return false;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}
