//package RecipeManager;

import java.util.Scanner;
 
public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to the Recipe Application!");

        Ingredient ingredient1 = Ingredient.addIngredient();

        // Print the ingredient's attributes
        System.out.println("\nIngredient Details:");
        System.out.println("Name: " + ingredient1.getName());
        System.out.println("Amount: " + ingredient1.getAmount());
        System.out.println("Unit: " + ingredient1.getUnit());
        System.out.println("Total Calories: " + ingredient1.getTotalCalories());

        scnr.close();
    }
}
