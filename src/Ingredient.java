import java.util.Scanner;

/**
 * Represents a single ingredient in a recipe, including name, amount, unit of measurement, and total calories.
 */
public class Ingredient {

    private String name;
    private float amount;
    private String unit;
    private double totalCalories;

    // Constructors
    /**
     * Default constructor that initializes an empty ingredient with default values.
     */
    public Ingredient() {
        this.name = "";
        this.amount = 0.0f;
        this.unit = "";
        this.totalCalories = 0.0f;
    }

    /**
     * Constructor with parameters to create an ingredient with specified values.
     * Includes validation to ensure total calories are non-negative.
     * @param name the name of the ingredient
     * @param amount the quantity of the ingredient
     * @param unit the unit of measurement for the amount
     * @param totalCalories the total calories for the ingredient
     */
    public Ingredient(String name, float amount, String unit, float totalCalories) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        if (totalCalories >= 0) { // Validate non-negative calories
            this.totalCalories = totalCalories;
        } else {
            System.out.println("Total calories cannot be negative. Please try again.");
        }
    }
    // End Constructors

    // Getters and Setters
    /**
     * Gets the name of the ingredient.
     * @return the name
     */
    public String getName() { return name; }

    /**
     * Sets the name of the ingredient.
     * @param name the name to set
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the amount of the ingredient.
     * @return the amount
     */
    public float getAmount() { return amount; }

    /**
     * Sets the amount of the ingredient.
     * @param amount the amount to set
     */
    public void setAmount(float amount) { this.amount = amount; }

    /**
     * Gets the unit of measurement for the ingredient.
     * @return the unit
     */
    public String getUnit() { return unit; }

    /**
     * Sets the unit of measurement for the ingredient.
     * @param unit the unit to set
     */
    public void setUnit(String unit) { this.unit = unit; }

    /**
     * Gets the total calories for the ingredient.
     * @return the total calories
     */
    public double getTotalCalories() { return totalCalories; }

    /**
     * Sets the total calories for the ingredient.
     * @param totalCalories the total calories to set
     */
    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }
    /**
     * Static method to create a new ingredient by prompting the user for input via the console.
     * Validates user inputs for name, unit, amount, and calories.
     * @param scnr the Scanner object for reading user input
     * @return a new Ingredient object with the user-provided values
     */
    // End Getters and Setters

    // Static method to create an ingredient by taking user input.
    // Returns an Ingredient object.
    public static Ingredient addIngredient(Scanner scnr) {

        String name = "";
        float amount = 0.0f;
        String unit = "";
        float caloriesPerUnit = 0;
        float totalCalories = 0.0f;

        // Input validation loop for ingredient name.
        do {
            System.out.println("Please enter the ingredient name: ");
            if (scnr.hasNextLine()) {
                name = scnr.nextLine().trim();
            }
            if (name.isEmpty()) {
                System.out.println("Ingredient name cannot be empty. Please try again.");
            }
        } while (name.isEmpty());

        // Input validation loop for unit of measurement.
        do {
            System.out.println("Please enter the unit of measurement for " + name + ": ");
            if (scnr.hasNextLine()) {
                unit = scnr.nextLine().trim();
            }
            if (unit.isEmpty()) {
                System.out.println("Unit cannot be empty. Please try again.");
            }
        } while (unit.isEmpty());

        // Prompt and validate amount.
        System.out.println("Please enter the number of " + unit + " of " + name + " we'll need: ");
        if (scnr.hasNextFloat()) { // Validate input is a float
            amount = scnr.nextFloat();
            scnr.nextLine(); // Consume newline character
            while (amount <= 0){ // Re-prompt user until valid input (value greater than 0)
                System.out.println("Invalid input. Please try again. Number must be greater than 0.");
                if (scnr.hasNextFloat()) { // Validate input is a float
                    amount = scnr.nextFloat();
                    scnr.nextLine(); // Consume newline character
                }// if
            }// while
        }// if

        // Prompt and validate calories per unit.
        System.out.println("Please enter the calories per " + unit + ": ");
        if (scnr.hasNextFloat()) { // Validate input is a float
            caloriesPerUnit = scnr.nextFloat();
            scnr.nextLine(); // Consume newline character
            while (caloriesPerUnit < 0){ // Re-prompt user until valid input (non-negative value)
                System.out.println("Invalid input. Please try again. Number must be non-negative");
                if (scnr.hasNextFloat()) { // Validate input is a float
                    caloriesPerUnit = scnr.nextFloat();
                    scnr.nextLine(); // Consume newline character
                }// if
            }// while
        }// if

        // Calculate total calories for the ingredient.
        totalCalories = amount * caloriesPerUnit;

        // Print a summary of the ingredient.
        System.out.println(name + " uses " + amount + " "
                + unit + " and has " + totalCalories + " calories.");

        return new Ingredient(name, amount, unit, totalCalories);
    } // addIngredient()

} // Ingredient
