# Smart Pantry Manager

## Overview
Smart Pantry Manager is an Android application developed in Java to help users manage pantry ingredients and discover recipes based on the ingredients and quantities they have available.

## Features
- Add pantry ingredients with quantities, units and optional expiry dates.
- View, edit and delete pantry ingredients.
- Suggest recipes only when the required ingredients and quantities are available.
- View recipe ingredients and preparation instructions.
- Save a profile name and optional email address.
- Store pantry ingredients locally using SQLite.
- Save profile details using Android SharedPreferences.

## Technologies Used
- Java
- Android Studio
- SQLite
- SharedPreferences
- Git and GitHub

## Project Structure
- `MainActivity` – home screen and navigation.
- `PantryActivity` – displays pantry ingredients.
- `AddIngredientActivity` – adds and edits ingredients.
- `RecipesActivity` – displays suggested recipes.
- `RecipeDetailActivity` – displays recipe details.
- `SettingsActivity` – manages profile details.
- `PantryDatabaseHelper` – manages the local pantry database.
- `RecipeRepository` and `RecipeMatcher` – provide recipes and check ingredient availability.

## Running the App
1. Clone or download this repository.
2. Open the project in Android Studio.
3. Allow Gradle to sync.
4. Run the app on an Android emulator or compatible device.

## Developer
Developed as part of a Mobile App Development assignment.