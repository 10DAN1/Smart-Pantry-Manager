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

## Testing the App

The following tests can be performed to verify the main functionality of Smart Pantry Manager:

1. **Navigation:** Open the app and navigate between the Home, My Pantry, Suggested Recipes, Recipe Details, and Settings screens.
2. **Add ingredients:** Add an ingredient by entering its name, quantity, unit, and optional expiry date.
3. **Edit ingredients:** Update the details of an existing pantry ingredient and confirm that the changes are saved.
4. **Delete ingredients:** Delete an ingredient and verify that it no longer appears in the pantry.
5. **Input validation:** Try saving an ingredient without a name or with an invalid quantity and confirm that validation is applied.
6. **Recipe matching:** Add the required ingredients and quantities for a recipe, then verify that the recipe appears in the suggestions. Reduce a required quantity and confirm that the recipe is no longer suggested when the requirements are not met.
7. **Recipe details:** Open a suggested recipe and check its displayed information.
8. **Profile settings:** Save profile details, close and reopen Settings, and confirm that the saved information remains available.

## Data Storage

Smart Pantry Manager uses SQLite for local database storage. The pantry database stores ingredient information, including:

- **ID:** A unique identifier for each ingredient.
- **Name:** The name of the ingredient.
- **Quantity:** The amount of the ingredient available.
- **Unit:** The measurement unit, such as grams or pieces.
- **Expiry date:** The ingredient's expiry date, where provided.

The app supports adding, viewing, editing, and deleting pantry ingredients. Profile information is stored separately using Android SharedPreferences, allowing saved settings to remain available when the app is reopened.

## Application Screens

Smart Pantry Manager contains the following screens:

1. **Home Screen:** Introduces the application and provides access to its main features.
2. **My Pantry Screen:** Displays saved pantry ingredients and provides options to add, edit, and delete ingredients.
3. **Add Ingredient Screen:** Allows users to enter ingredient details, including name, quantity, unit, and expiry date.
4. **Suggested Recipes Screen:** Displays recipes that match the ingredients and quantities available in the pantry.
5. **Recipe Details Screen:** Shows additional information about a selected recipe.
6. **Settings Screen:** Allows users to save and update their profile information.

These screens work together to help users manage pantry ingredients and identify recipes they can prepare with the ingredients available.


## Developer
Developed as part of a Mobile App Development assignment.