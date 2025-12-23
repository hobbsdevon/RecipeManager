//package FinalProject;

import java.util.Scanner;

public class Ingredient {

    private String name;
    private float amount;
    private String unit;
    private double totalCalories;

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
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public float getAmount() { return amount; }

    public void setAmount(float amount) { this.amount = amount; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }
    
    /* 
    addIngredient takes user input for name, amount, unit measurement, and calories,
    and returns an Ingredient object with those attributes.
    */
    public static Ingredient addIngredient(Scanner scnr) {

        String name = "";
        float amount = 0.0f;
        String unit = "";
        float caloriesPerUnit = 0;
        float totalCalories = 0.0f;

        System.out.println("Please enter the ingredient name: ");
        if (scnr.hasNextLine()) {
            name = scnr.nextLine();
        }

        System.out.println("Please enter the unit of measurement for " + name + ": ");
        if (scnr.hasNextLine()) {
            unit = scnr.nextLine();
        }

        System.out.println("Please enter the number of " + unit + " of " + name + " we'll need: ");
        if (scnr.hasNextFloat()) {
            amount = scnr.nextFloat();
        }

        System.out.println("Please enter the calories per " + unit + ": ");
        if (scnr.hasNextFloat()) {
            caloriesPerUnit = scnr.nextFloat();
        }

        totalCalories = amount * caloriesPerUnit;

        System.out.println(name + " uses " + amount + " " 
                + unit + " and has " + totalCalories + " calories.");

        return new Ingredient(name, amount, unit, totalCalories);
    }

}

