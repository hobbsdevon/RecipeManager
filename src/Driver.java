//package RecipeManager;

import java.util.Scanner;
 
public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to the Recipe Application!");

        Recipe recipe = new Recipe();
        recipe.addRecipe(scnr);
        
        scnr.close();
    }
}
