import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to the Recipe Application!");

        RecipeBox recipeBox = new RecipeBox();

        boolean running = true;// Control main loop

        while (running) {
            // Display the main menu options.
            System.out.println("\nMain Menu:");
            System.out.println("1. Create a new recipe");
            System.out.println("2. Display list of recipes");
            System.out.println("3. Select a recipe to view/edit/delete");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            // Try to read and parse the user's choice as an integer.
            int choice = 0;
            try {
                choice = Integer.parseInt(scnr.nextLine());
            } catch (NumberFormatException e) {
                // If input is not a number, inform the user and continue the loop.
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }// try-catch

            // Handle the user's choice.
            switch (choice) {
                case 1:
                    // Add a new recipe.
                    recipeBox.addNewRecipe(scnr);
                    System.out.println("Recipe added successfully!");
                    break;
                case 2:
                    // Display all recipes.
                    recipeBox.printAllRecipes();
                    break;
                case 3:
                    // Handle selecting a recipe for view/edit/delete.
                    handleRecipeSelection(scnr, recipeBox);
                    break;
                case 4:
                    // Exit the application.
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                    break;
                default:
                    // Invalid choice.
                    System.out.println("Invalid option. Please choose 1-4.");
                    break;
            }// switch
        }// while (running)
        
        scnr.close();
    }// main()

    // Handle selecting and managing a specific recipe.
    private static void handleRecipeSelection(Scanner scnr, RecipeBox recipeBox) {
        // Get the list of recipes from the recipe box.
        ArrayList<Recipe> recipes = recipeBox.getRecipes();
        // Check if there are any recipes.
        if (recipes.isEmpty()) {
            System.out.println("No recipes available to select.");
            return;
        }

        // Display the list of recipes with numbers.
        System.out.println("\nSelect a recipe:");
        for (int i = 0; i < recipes.size(); i++) {
            // Print each recipe.
            System.out.println((i + 1) + ". " + recipes.get(i).getName());
        }
        // Ask for the recipe number.
        System.out.print("Enter the number of the recipe: ");

        // Variable for the selected recipe index.
        int index = 0;
        try {
            // Parse input, subtract 1 to get array index.
            index = Integer.parseInt(scnr.nextLine()) - 1;
            // Validate the index is within bounds.
            if (index < 0 || index >= recipes.size()) {
                System.out.println("Invalid selection.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }// try-catch

        // Submenu loop for the selected recipe.
        boolean subRunning = true;
        while (subRunning) {
            // Display submenu options.
            System.out.println("\nRecipe Menu for '" + recipes.get(index).getName() + "':");
            System.out.println("1. View detailed information");
            System.out.println("2. Edit the recipe");
            System.out.println("3. Delete the recipe");
            System.out.println("4. Back to main menu");
            System.out.print("Choose an option (1-4): ");

            // Try to read sub choice.
            int subChoice = 0;
            try {
                subChoice = Integer.parseInt(scnr.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            // Handle sub choices.
            switch (subChoice) {
                case 1:
                    // View recipe details.
                    recipeBox.PrintRecipeDetails(recipes.get(index));
                    break;
                case 2:
                    // Edit the recipe.
                    recipeBox.editRecipe(scnr, index);
                    break;
                case 3:
                    // Delete the recipe and go back.
                    recipeBox.deleteRecipe(index);
                    subRunning = false; // back to main
                    break;
                case 4:
                    // Back to main menu.
                    subRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-4.");
                    break;
            }// switch
        }// while (subRunning)
    }// handleRecipeSelection()
}// Driver
