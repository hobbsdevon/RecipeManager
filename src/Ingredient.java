import java.util.Scanner;

// Ingredient class represents a single ingredient with name, amount, unit, and total calories.
public class Ingredient {

    private String name;
    private float amount;
    private String unit;
    private double totalCalories;

    // Constructors
    // Default constructor initializes an empty ingredient.
    public Ingredient() {
        this.name = "";
        this.amount = 0.0f;
        this.unit = "";
        this.totalCalories = 0.0f;
    }

    // Constructor with parameters, includes validation for non-negative calories.
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
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public float getAmount() { return amount; }

    public void setAmount(float amount) { this.amount = amount; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }
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
                }
            }
        }

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
                }
            }
        }

        // Calculate total calories for the ingredient.
        totalCalories = amount * caloriesPerUnit;

        // Print a summary of the ingredient.
        System.out.println(name + " uses " + amount + " "
                + unit + " and has " + totalCalories + " calories.");

        return new Ingredient(name, amount, unit, totalCalories);
    } // addIngredient()

} // Ingredient Class
