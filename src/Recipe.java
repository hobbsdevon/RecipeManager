//package FinalProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    
    private String name;
    private short servings;
    private ArrayList<Ingredient> ingredients;
    private double totalCalories;

    // Constructors
    public Recipe() {
        this.name = "";
        this.servings = 0;
        this.ingredients = new ArrayList<>();
        this.totalCalories = 0.0;
    }

    public Recipe(String name, short servings, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.servings = servings;
        this.ingredients = ingredients;
    }
    // End Constructors

    // Getters and Setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public short getServings() { return servings; }

    public void setServings(short servings) { this.servings = servings; }

    public ArrayList<Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(ArrayList<Ingredient> ingredients) { this.ingredients = ingredients; }

    public double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }
    // End Getters and Setters

    // Print Recipe details
    public void printRecipe() {
        // Calculate total calories
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getTotalCalories();
        }
        totalCalories = totalCalories * servings;

        // Print recipe details
        System.out.println("Recipe Name: " + name); // print attributes of recipe
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) { // print attributes of each ingredient
            System.out.println("- " + ingredient.getName() + " (" + ingredient.getAmount() + " " + ingredient.getUnit() + ")");
        }
        System.out.println("Total Calories: " + totalCalories);
    }// printRecipe()

    // Add Recipe by taking user input
    // Returns a Recipe object
    public Recipe addRecipe(Scanner scnr) {
        System.out.print("Enter recipe name: ");
        String name = scnr.nextLine();
        System.out.print("Enter number of servings: ");
        short servings = scnr.nextShort();
        scnr.nextLine(); // consume newline character

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        while (true) {
            System.out.print("Enter ingredient name: ");
            Ingredient ingredient = Ingredient.addIngredient(scnr);
            ingredients.add(ingredient);

            System.out.println("Would you like to add another ingredient? (y/n): ");
            char choice = scnr.next().charAt(0);
            scnr.nextLine(); // consume newline character

            if (choice == 'n') { // quit entering ingredients when user inputs 'n'
                break;
            }
        }
        return new Recipe(name, servings, ingredients);
    } // addRecipe()

    /* 
    Adjust recipe amounts for different number of servings
    In application menu, a user can choose to adjust the number of servings for a recipe
    This method takes the desired number of servings as input and adjusts the ingredient amounts accordingly

    void adjustServings(int newServings)
        if newServings > 0
            for each ingredient in ingredients
                ingredient.amount = ingredient.amount * (newServings / servings)
                ingredient.totalCalories = ingredient.totalCalories * (newServings / servings)
                recipe.totalCalories = recipe.totalCalories * (newServings / servings)
            recipe.servings = newServings
        else
            print "Number of servings must be greater than zero. Please try again."
    */

} // Recipe Class
