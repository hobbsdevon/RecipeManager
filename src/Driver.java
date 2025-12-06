//package RecipeManager;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Welcome to the Recipe Application!");

        String ingredient = "";
        System.out.println("Let's add an ingredient. Please enter the ingredient name: ");
        ingredient = scnr.nextLine();
        Ingredient.addIngredient(ingredient);

        scnr.close();
        return;
    }
}
