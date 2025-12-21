//package FinalProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> ingredients;
    private double totalCalories;

    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.ingredients = new ArrayList<>();
        this.totalCalories = 0.0;
    }

    public Recipe(String recipeName, int servings, ArrayList<Ingredient> ingredients, double totalCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.ingredients = ingredients;
        this.totalCalories = totalCalories;
    }

    public String getRecipeName() { return recipeName; }

    public void setRecipeName(String recipeName) { this.recipeName = recipeName; }

    public int getServings() { return servings; }

    public void setServings(int servings) { this.servings = servings; }

    public ArrayList<Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(ArrayList<Ingredient> ingredients) { this.ingredients = ingredients; }

    public double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }

    public void printRecipe() {
        System.out.println("Recipe Name: " + recipeName);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println("- " + ingredient.getName() + " (" + ingredient.getAmount() + " " + ingredient.getUnit() + ")");
        }
        System.out.println("Total Calories: " + totalCalories);
    }

    public Recipe addRecipe(Scanner scnr) {
        System.out.print("Enter recipe name: ");
        String recipeName = scnr.nextLine();
        System.out.print("Enter number of servings: ");
        int servings = scnr.nextInt();
        scnr.nextLine(); // consume newline character

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        while (true) {
            System.out.print("Enter ingredient name: ");
            Ingredient ingredient = Ingredient.addIngredient(scnr);
            ingredients.add(ingredient);

            System.out.println("Would you like to add another ingredient? (y/n): ");
            char choice = scnr.next().charAt(0);
            scnr.nextLine(); // consume newline character
            
            if (choice == 'n') {
                break;
            }
        }
        return new Recipe(recipeName, servings, ingredients, 0.0);
    }

}
