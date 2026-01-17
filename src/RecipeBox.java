// Import necessary classes for ArrayList and Scanner.
import java.util.ArrayList;
import java.util.Scanner;

// RecipeBox class manages a collection of recipes.
public class RecipeBox {

    // Private list to store all recipes.
    private ArrayList<Recipe> recipes;

    // Constructors
    // Default constructor initializes an empty list of recipes.
    public RecipeBox() {
        this.recipes = new ArrayList<>();
    }

    // Constructor with a provided list of recipes.
    public RecipeBox(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
    // End Constructors

    // Getters and Setters
    // Methods to get and set the list of recipes.
    public ArrayList<Recipe> getRecipes() { return recipes; }

    public void setRecipes(ArrayList<Recipe> recipes) { this.recipes = recipes; }
    // End Getters and Setters

    // Method to print the details of a specific recipe.
    void PrintRecipeDetails(Recipe recipe) {
        recipe.printRecipe();
    }

    // Method to print the names of all recipes in the box.
    void printAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getName());
            System.out.println(); // Print a blank line between recipes
        }
    }

    // Method to add a new recipe by prompting the user for input.
    void addNewRecipe(Scanner scnr) {
        Recipe newRecipe = new Recipe().addRecipe(scnr);
        recipes.add(newRecipe);
    }

    // Method to edit a recipe at the specified index.
    void editRecipe(Scanner scnr, int index) {
        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid recipe index.");
            return;
        }
        recipes.get(index).editRecipe(scnr);
    }

    // Method to delete a recipe at the specified index.
    void deleteRecipe(int index) {
        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid recipe index.");
            return;
        }
        recipes.remove(index);
        System.out.println("Recipe deleted successfully!");
    }

}
