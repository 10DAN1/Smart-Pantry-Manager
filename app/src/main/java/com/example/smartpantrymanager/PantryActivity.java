package com.example.smartpantrymanager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PantryActivity extends AppCompatActivity {

    private PantryDatabaseHelper databaseHelper;
    private LinearLayout ingredientList;
    private TextView txtEmptyPantry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        databaseHelper = new PantryDatabaseHelper(this);

        ingredientList = findViewById(R.id.ingredientList);
        txtEmptyPantry = findViewById(R.id.txtEmptyPantry);

        Button btnAddIngredient = findViewById(R.id.btnAddIngredient);

        btnAddIngredient.setOnClickListener(v -> {
            Intent intent = new Intent(
                    PantryActivity.this,
                    AddIngredientActivity.class
            );
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (databaseHelper != null && ingredientList != null) {
            loadIngredients();
        }
    }


    private void loadIngredients() {
        ingredientList.removeAllViews();

        try (Cursor cursor = databaseHelper.getAllIngredients()) {

            if (cursor == null || cursor.getCount() == 0) {
                txtEmptyPantry.setVisibility(View.VISIBLE);
                return;
            }

            txtEmptyPantry.setVisibility(View.GONE);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(
                        cursor.getColumnIndexOrThrow(
                                PantryDatabaseHelper.COL_ID));

                String name = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                PantryDatabaseHelper.COL_NAME));

                double quantity = cursor.getDouble(
                        cursor.getColumnIndexOrThrow(
                                PantryDatabaseHelper.COL_QUANTITY));

                String unit = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                PantryDatabaseHelper.COL_UNIT));

                String expiryDate = cursor.getString(
                        cursor.getColumnIndexOrThrow(
                                PantryDatabaseHelper.COL_EXPIRY_DATE));

                LinearLayout row = new LinearLayout(this);
                row.setOrientation(LinearLayout.VERTICAL);
                row.setPadding(16, 12, 16, 12);

                TextView ingredient = new TextView(this);

                String details = name + "\nQuantity: "
                        + quantity + " " + unit;

                if (expiryDate != null && !expiryDate.isEmpty()) {
                    details += "\nExpires: " + expiryDate;
                }

                ingredient.setText(details);
                ingredient.setTextSize(17);

                Button btnDelete = new Button(this);
                btnDelete.setText("Delete");


                Button btnEdit = new Button(this);
                btnEdit.setText("Edit");

                btnEdit.setOnClickListener(v -> {
                    Intent intent = new Intent(
                            PantryActivity.this,
                            AddIngredientActivity.class
                    );

                    intent.putExtra("ingredient_id", id);
                    intent.putExtra("ingredient_name", name);
                    intent.putExtra("ingredient_quantity",
                            String.valueOf(quantity));
                    intent.putExtra("ingredient_unit", unit);
                    intent.putExtra("ingredient_expiry",
                            expiryDate == null ? "" : expiryDate);

                    startActivity(intent);
                });


                btnDelete.setOnClickListener(v -> {
                    new android.app.AlertDialog.Builder(this)
                            .setTitle("Delete ingredient")
                            .setMessage("Are you sure you want to delete "
                                    + name + "?")
                            .setNegativeButton("Cancel", (dialog, which) -> {
                                dialog.dismiss();
                            })
                            .setPositiveButton("Delete", (dialog, which) -> {
                                boolean deleted =
                                        databaseHelper.deleteIngredient(id);

                                if (deleted) {
                                    android.widget.Toast.makeText(
                                            this,
                                            name + " deleted",
                                            android.widget.Toast.LENGTH_SHORT
                                    ).show();

                                    loadIngredients();
                                } else {
                                    android.widget.Toast.makeText(
                                            this,
                                            "Could not delete ingredient",
                                            android.widget.Toast.LENGTH_SHORT
                                    ).show();
                                }
                            })
                            .show();
                });

                row.addView(ingredient);
                row.addView(btnEdit);
                row.addView(btnDelete);
                ingredientList.addView(row);
            }
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

