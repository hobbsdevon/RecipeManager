//package FinalProject;

import java.util.Scanner;

public class Ingredient {

    private String name;
    private float amount;
    private String unit;
    private float totalCalories;

    public Ingredient() {
        this.name = "";
        this.amount = 0.0f;
        this.unit = "";
        this.totalCalories = 0.0f;
    }

    public Ingredient(String name, float amount, String unit, float totalCalories) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.totalCalories = totalCalories;
    }

    //Getter methods
    public String getName() {
        return name;
    }

    public float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public float getTotalCalories() {
        return totalCalories;
    }
    /* 
    addIngredient takes user input for name, amount, unit measurement, and calories,
    and returns an Ingredient object with those attributes.
    */
    public static Ingredient addIngredient(Scanner scnr) {

        //Ingredient ingredient = new Ingredient();

        String nameOfIngredient = "";
        float ingredientAmount = 0.0f;
        String unitMeasurement = "";
        float numberCaloriesPerUnit = 0;
        float totalCalories = 0.0f;

        System.out.println("Please enter the ingredient name: ");
        if (scnr.hasNextLine()) {
            nameOfIngredient = scnr.nextLine();
        }

        System.out.println("Please enter the unit of measurement for " + nameOfIngredient + ": ");
        if (scnr.hasNextLine()) {
            unitMeasurement = scnr.nextLine();
        }

        System.out.println("Please enter the number of " + unitMeasurement + " of " + nameOfIngredient + " we'll need: ");
        if (scnr.hasNextFloat()) {
            ingredientAmount = scnr.nextFloat();
        }

        System.out.println("Please enter the calories per " + unitMeasurement + ": ");
        if (scnr.hasNextFloat()) {
            numberCaloriesPerUnit = scnr.nextFloat();
        }

        totalCalories = ingredientAmount * numberCaloriesPerUnit;

        // Set the fields on the ingredient object
        /* ingredient.name = nameOfIngredient;
        ingredient.amount = ingredientAmount;
        ingredient.unit = unitMeasurement;
        ingredient.totalCalories = totalCalories; */

        System.out.println(nameOfIngredient + " uses " + ingredientAmount + " " 
                + unitMeasurement + " and has " + totalCalories + " calories.");

        return new Ingredient(nameOfIngredient, ingredientAmount, unitMeasurement, totalCalories);
    }

}

