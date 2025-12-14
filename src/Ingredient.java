//package FinalProject;

import java.util.Scanner;

public class Ingredient {

    public static Ingredient addIngredient() {
        Scanner scnr = new Scanner(System.in);

        String nameOfIngredient = "";
        float ingredientAmount = 0.0f;
        String unitMeasurement = "";
        float numberCaloriesPerCup = 0;
        float totalCalories = 0.0f;
        boolean moreIngredients = true;

        while(moreIngredients == true) { // Loop to add multiple ingredients
            System.out.println("Let's add an ingredient. Please enter the ingredient name: ");
                    if(scnr.hasNextLine()){
                            nameOfIngredient = scnr.nextLine();
                    }
                    //System.out.println("The value of nameOfIngredient is: " + nameOfIngredient);

            System.out.println("Please enter the unit of measurement for "
                    + nameOfIngredient + ": ");
                    if(scnr.hasNextLine()){
                            unitMeasurement = scnr.nextLine();
                    }
            

            System.out.println("Please enter the number of " + unitMeasurement + " of "
                    + nameOfIngredient + " we'll need: ");
                    if(scnr.hasNextFloat()){
                            ingredientAmount = scnr.nextFloat();
                    }

            System.out.println("Please enter the name of calories per " + unitMeasurement + ": ");
                    if(scnr.hasNextFloat()){
                            numberCaloriesPerCup = scnr.nextFloat();
                    }

            totalCalories = ingredientAmount * numberCaloriesPerCup;

            System.out.println(nameOfIngredient + " uses " + ingredientAmount + " "
                    + unitMeasurement + " and has " + totalCalories + " calories.");

            System.out.println("Would you like to add another ingredient? (y/n): ");

            char userChoice = scnr.next().charAt(0);
            scnr.nextLine(); // Consume the newline character
            if(userChoice == 'y' || userChoice == 'Y'){
                    moreIngredients = true;
            }
            else{
                    moreIngredients = false;
            }
            //System.out.println("The value of moreIngredients is: " + moreIngredients);
        }      

        scnr.close();        
        return null;
    }

}

