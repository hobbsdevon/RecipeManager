//package FinalProject;

import java.util.Scanner;

public class Ingredient {

    public static Ingredient addIngredient(String ingredient) {
        Scanner scnr = new Scanner(System.in);

        String nameOfIngredient = "";
        float ingredientAmount = 0.0f;
        String unitMeasurement = "";
        float numberCaloriesPerCup = 0;
        float totalCalories = 0.0f;

        nameOfIngredient = ingredient;

        System.out.println("Please enter the unit of measurement for "
                + nameOfIngredient + ": ");
                if(scnr.hasNext()){
                        unitMeasurement = scnr.next();
                }
        

        System.out.println("Please enter the number of " + unitMeasurement + " of "
                + nameOfIngredient + " we'll need: ");
                if(scnr.hasNextFloat()){
                        ingredientAmount = scnr.nextFloat();
                }

        System.out.println("Please enter the name of calories per cup: ");
                if(scnr.hasNextFloat()){
                        numberCaloriesPerCup = scnr.nextFloat();
                }

        totalCalories = ingredientAmount * numberCaloriesPerCup;

        System.out.println(nameOfIngredient + " uses " + ingredientAmount + " "
                + unitMeasurement + " and has " + totalCalories + " calories.");

        scnr.close();        
        return null;
    }

}

/*  * ingredientName (String)
 * ingredientAmount (float)
 * unitMeasurment (String)
 * number of Calories (double) */
