package com.example.smartpantrymanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private EditText edtProfileName;
    private EditText edtProfileEmail;
    private TextView txtProfileStatus;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        edtProfileName = findViewById(R.id.edtProfileName);
        edtProfileEmail = findViewById(R.id.edtProfileEmail);
        txtProfileStatus = findViewById(R.id.txtProfileStatus);

        Button btnSaveProfile = findViewById(R.id.btnSaveProfile);
        Button btnBackSettings = findViewById(R.id.btnBackSettings);

        preferences = getSharedPreferences(
                "SmartPantryProfile",
                MODE_PRIVATE
        );

        loadProfile();

        btnSaveProfile.setOnClickListener(v -> saveProfile());

        btnBackSettings.setOnClickListener(v -> finish());
    }

    private void loadProfile() {
        String savedName = preferences.getString("profile_name", "");
        String savedEmail = preferences.getString("profile_email", "");

        edtProfileName.setText(savedName);
        edtProfileEmail.setText(savedEmail);

        if (!savedName.isEmpty()) {
            txtProfileStatus.setText("Welcome back, " + savedName + "!");
        }
    }

    private void saveProfile() {
        String name = edtProfileName.getText().toString().trim();
        String email = edtProfileEmail.getText().toString().trim();

        if (name.isEmpty()) {
            edtProfileName.setError("Please enter your name");
            edtProfileName.requestFocus();
            return;
        }

        if (!email.isEmpty()
                && !android.util.Patterns.EMAIL_ADDRESS
                .matcher(email).matches()) {
            edtProfileEmail.setError("Please enter a valid email address");
            edtProfileEmail.requestFocus();
            return;
        }

        boolean saved = preferences.edit()
                .putString("profile_name", name)
                .putString("profile_email", email)
                .commit();

        if (saved) {
            txtProfileStatus.setText("Profile saved for " + name + ".");
            Toast.makeText(
                    this,
                    "Profile saved successfully!",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    this,
                    "Could not save profile. Please try again.",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}
