# Smart Pantry Manager — Testing Checklist

## Functional Tests

| Test | Expected Result | Status |
|---|---|---|
| Open the application | Home screen loads successfully | Passed |
| Navigate between screens | The selected screen opens correctly | Passed |
| Add a pantry ingredient | Ingredient is saved and displayed | Passed |
| Edit an ingredient | Updated details are displayed | Passed |
| Delete an ingredient | Ingredient is removed from the pantry list | Passed |
| Submit an empty ingredient name | Validation prevents saving | Passed |
| Enter a quantity of zero | Validation prevents saving | Passed |
| Match available ingredients to recipes | Only recipes meeting the matching requirements are suggested | Passed |
| Open a recipe | Recipe details screen displays | Passed |
| Save profile settings | Profile information remains available after reopening Settings | Passed |
| View an empty pantry | An empty pantry message is displayed | Passed |

## Testing Notes

Tests were performed using the Android emulator. The results above reflect the functionality tested in the application.

## Future Testing

Further testing could cover different ingredient units, expiry dates, database persistence after restarting the app, and unusual or invalid user input.
