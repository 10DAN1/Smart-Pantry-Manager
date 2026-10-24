package com.example.smartpantrymanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddIngredientActivity extends AppCompatActivity {

    private EditText edtIngredientName;
    private EditText edtQuantity;
    private EditText edtUnit;
    private EditText edtExpiryDate;

    private int ingredientId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        edtIngredientName = findViewById(R.id.edtIngredientName);
        edtQuantity = findViewById(R.id.edtQuantity);
        edtUnit = findViewById(R.id.edtUnit);
        edtExpiryDate = findViewById(R.id.edtExpiryDate);

        Button btnSave = findViewById(R.id.btnSaveIngredient);
        Button btnCancel = findViewById(R.id.btnCancelIngredient);

        ingredientId = getIntent().getIntExtra("ingredient_id", -1);

        if (ingredientId != -1) {
            setTitle("Edit Ingredient");

            edtIngredientName.setText(
                    getIntent().getStringExtra("ingredient_name"));

            edtQuantity.setText(
                    getIntent().getStringExtra("ingredient_quantity"));

            edtUnit.setText(
                    getIntent().getStringExtra("ingredient_unit"));

            edtExpiryDate.setText(
                    getIntent().getStringExtra("ingredient_expiry"));
        }

        btnSave.setOnClickListener(v -> saveIngredient());
        btnCancel.setOnClickListener(v -> finish());
    }

    private void saveIngredient() {
        String name = edtIngredientName.getText().toString().trim();
        String quantityText = edtQuantity.getText().toString().trim();
        String unit = edtUnit.getText().toString().trim();
        String expiryDate = edtExpiryDate.getText().toString().trim();

        if (name.isEmpty()) {
            edtIngredientName.setError(
                    "Please enter an ingredient name");
            edtIngredientName.requestFocus();
            return;
        }

        if (quantityText.isEmpty()) {
            edtQuantity.setError("Please enter a quantity");
            edtQuantity.requestFocus();
            return;
        }

        double quantity;

        try {
            quantity = Double.parseDouble(quantityText);
        } catch (NumberFormatException e) {
            edtQuantity.setError("Enter a valid quantity");
            edtQuantity.requestFocus();
            return;
        }

        if (!Double.isFinite(quantity) || quantity <= 0) {
            edtQuantity.setError(
                    "Quantity must be greater than zero");
            edtQuantity.requestFocus();
            return;
        }

        if (unit.isEmpty()) {
            edtUnit.setError("Please enter a unit");
            edtUnit.requestFocus();
            return;
        }

        PantryDatabaseHelper databaseHelper =
                new PantryDatabaseHelper(this);

        boolean saved;

        try {
            if (ingredientId == -1) {
                saved = databaseHelper.addIngredient(
                        name, quantity, unit, expiryDate);
            } else {
                saved = databaseHelper.updateIngredient(
                        ingredientId, name, quantity, unit, expiryDate);
            }
        } finally {
            databaseHelper.close();
        }

        if (saved) {
            Toast.makeText(
                    this,
                    ingredientId == -1
                            ? "Ingredient saved successfully!"
                            : "Ingredient updated successfully!",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        } else {
            Toast.makeText(
                    this,
                    "Could not save changes. Please try again.",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}
