
package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        TextView txtRecipeName = findViewById(R.id.txtRecipeName);
        TextView txtRecipeDescription =
                findViewById(R.id.txtRecipeDescription);
        TextView txtRecipeIngredients =
                findViewById(R.id.txtRecipeIngredients);
        TextView txtRecipeInstructions =
                findViewById(R.id.txtRecipeInstructions);

        txtRecipeName.setText(
                getIntent().getStringExtra("recipe_name"));

        txtRecipeDescription.setText(
                getIntent().getStringExtra("recipe_description"));

        txtRecipeIngredients.setText(
                getIntent().getStringExtra("recipe_ingredients"));

        txtRecipeInstructions.setText(
                getIntent().getStringExtra("recipe_instructions"));

        Button btnBackToRecipes =
                findViewById(R.id.btnBackToRecipes);

        btnBackToRecipes.setOnClickListener(v -> finish());
    }
}
