//package FinalProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    
    private String name;
    private short servings;
    private ArrayList<Ingredient> ingredients;
    private double totalCalories;

    public Recipe() {
        this.name = "";
        this.servings = 0;
        this.ingredients = new ArrayList<>();
        this.totalCalories = 0.0;
    }

    public Recipe(String name, short servings, ArrayList<Ingredient> ingredients, double totalCalories) {
        this.name = name;
        this.servings = servings;
        this.ingredients = ingredients;
        this.totalCalories = totalCalories;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public short getServings() { return servings; }

    public void setServings(short servings) { this.servings = servings; }

    public ArrayList<Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(ArrayList<Ingredient> ingredients) { this.ingredients = ingredients; }

    public double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }

    public void printRecipe() {
        System.out.println("Recipe Name: " + name);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println("- " + ingredient.getName() + " (" + ingredient.getAmount() + " " + ingredient.getUnit() + ")");
        }
        System.out.println("Total Calories: " + totalCalories);
    }

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

            if (choice == 'n') {
                break;
            }
        }
        return new Recipe(name, servings, ingredients, 0.0);
    }

}
