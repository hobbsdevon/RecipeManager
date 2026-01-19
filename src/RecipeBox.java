import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a collection of recipes, providing methods to add, edit, delete, and display recipes.
 */
public class RecipeBox {

    private ArrayList<Recipe> recipes;

    // Constructors
    /**
     * Default constructor that initializes an empty recipe box.
     */
    public RecipeBox() {
        this.recipes = new ArrayList<>();
    }

    /**
     * Constructor with a provided list of recipes.
     * @param recipes the list of recipes to initialize the box with
     */
    public RecipeBox(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }
    /**
     * Gets the list of recipes in the recipe box.
     * @return the list of recipes
     */
    // End Constructors

    // Getters and Setters
    public ArrayList<Recipe> getRecipes() { return recipes; }

    /**
     * Sets the list of recipes in the recipe box.
     * @param recipes the recipes to set
     */
    public void setRecipes(ArrayList<Recipe> recipes) { this.recipes = recipes; }
    // End Getters and Setters

    /**
     * Prints the details of a specific recipe.
     * @param recipe the recipe to print
     */
    void PrintRecipeDetails(Recipe recipe) {
        recipe.printRecipe();
    }

    /**
     * Prints the names of all recipes in the box.
     */
    void printAllRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getName());
            System.out.println(); // Print a blank line between recipes
        }
    }

    /**
     * Adds a new recipe by prompting the user for input.
     * @param scnr the Scanner object for reading user input
     */
    void addNewRecipe(Scanner scnr) {
        Recipe newRecipe = new Recipe().addRecipe(scnr);
        recipes.add(newRecipe);
    }

    /**
     * Edits a recipe at the specified index.
     * @param scnr the Scanner object for reading user input
     * @param index the index of the recipe to edit
     */
    void editRecipe(Scanner scnr, int index) {
        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid recipe index.");
            return;
        }
        recipes.get(index).editRecipe(scnr);
    }

    /**
     * Deletes a recipe at the specified index.
     * @param index the index of the recipe to delete
     */
    void deleteRecipe(int index) {
        if (index < 0 || index >= recipes.size()) {
            System.out.println("Invalid recipe index.");
            return;
        }
        recipes.remove(index);
        System.out.println("Recipe deleted successfully!");
    }

}// RecipeBox
