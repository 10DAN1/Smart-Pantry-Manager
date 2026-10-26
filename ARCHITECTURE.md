# Smart Pantry Manager — Architecture

## Overview

Smart Pantry Manager is an Android application developed using Java and XML layouts. It helps users manage pantry ingredients and find recipes that match their available ingredients.

## Main Components

### 1. User Interface

The application uses Android Activities and XML layouts to provide the home screen, pantry management, ingredient entry, recipe suggestions, recipe details, and profile settings.

### 2. Pantry Database

`PantryDatabaseHelper.java` manages the SQLite database. It supports adding, retrieving, updating, and deleting pantry ingredients.

### 3. Recipe Management

`RecipeRepository.java` provides the recipe data, while `RecipeMatcher.java` compares the ingredients and quantities available in the pantry with recipe requirements.

### 4. Recipe Details

`RecipeDetailActivity.java` displays information about a selected recipe.

### 5. Profile Settings

`SettingsActivity.java` uses Android SharedPreferences to save profile information locally.

## Application Flow

1. The user opens the Home screen.
2. The user navigates to the Pantry screen to manage ingredients.
3. Pantry information is stored in SQLite.
4. The recipe matching component checks pantry ingredients against recipe requirements.
5. Matching recipes are displayed to the user.
6. The user can open a recipe to view its details.
7. Profile settings are saved separately using SharedPreferences.

## Technologies

- Java
- XML layouts
- Android Activities and Intents
- SQLite
- SharedPreferences
- Android Studio
- Git and GitHub
