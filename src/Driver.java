//package RecipeManager;

import java.util.Scanner;
import java.util.ArrayList;
 
public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to the Recipe Application!");

        // Make list of ingreients to test Recipe constructor 2
        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new Ingredient("Shrimp", 1.0f, "lb", 480));
        ingredients1.add(new Ingredient("Butter", 4.0f, "tbsp", 400));
        ingredients1.add(new Ingredient("Garlic", 4.0f, "cloves", 20));
        ingredients1.add(new Ingredient("Lemon Juice", 2.0f, "tbsp", 8));
        ingredients1.add(new Ingredient("Parsley", 2.0f, "tbsp", 4));

        // Test Recipe constructor 2
        Recipe recipe1 = new Recipe("Shrimp Scampi", (short)4, ingredients1);
        recipe1.printRecipe();

        // Test addRecipe & Recipe constructor 1
        Recipe recipe2 = new Recipe();
        recipe2 = recipe2.addRecipe(scnr);
        recipe2.printRecipe();
        
        scnr.close();
    }
}
