import java.util.ArrayList;
import java.util.Scanner;

// RecipeBox class manages a collection of recipes.
public class RecipeBox {

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
    public ArrayList<Recipe> getRecipes() { return recipes; }

    public void setRecipes(ArrayList<Recipe> recipes) { this.recipes = recipes; }
    // End Getters and Setters

    // Print the details of a specific recipe.
    void PrintRecipeDetails(Recipe recipe) {
        recipe.printRecipe();
    }

    // Print the names of all recipes in the box.
    void printAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getName());
            System.out.println(); // Print a blank line between recipes
        }
    }

    // Add a new recipe by prompting the user for input.
    void addNewRecipe(Scanner scnr) {
        Recipe newRecipe = new Recipe().addRecipe(scnr);
        recipes.add(newRecipe);
    }

    // Edit a recipe at the specified index.
    void editRecipe(Scanner scnr, int index) {
        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid recipe index.");
            return;
        }
        recipes.get(index).editRecipe(scnr);
    }

    // Delete a recipe at the specified index.
    void deleteRecipe(int index) {
        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid recipe index.");
            return;
        }
        recipes.remove(index);
        System.out.println("Recipe deleted successfully!");
    }

}
