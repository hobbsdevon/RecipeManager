import java.util.ArrayList;
import java.util.Scanner;

// Recipe class represents a single recipe with name, servings, ingredients, and total calories.
public class Recipe {

    private String name;
    private short servings;
    private ArrayList<Ingredient> ingredients;
    private double totalCalories;

    // Constructors
    // Default constructor initializes an empty recipe.
    public Recipe() {
        this.name = "";
        this.servings = 0;
        this.ingredients = new ArrayList<>();
        this.totalCalories = 0.0;
    }

    // Constructor with parameters to create a recipe with given values.
    public Recipe(String name, short servings, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.servings = servings;
        this.ingredients = ingredients;
    }
    // End Constructors

    // Getters and Setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public short getServings() { return servings; }

    public void setServings(short servings) { this.servings = servings; }

    public ArrayList<Ingredient> getIngredients() { return ingredients; }

    public void setIngredients(ArrayList<Ingredient> ingredients) { this.ingredients = ingredients; }

    public double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }
    // End Getters and Setters

    // Method to print the recipe details, including calculating total calories.
    public void printRecipe() {
        // Loop through ingredients to sum up their calories.
        for (Ingredient ingredient : ingredients) {
            totalCalories += ingredient.getTotalCalories();
        }
        // Multiply by the number of servings.
        totalCalories = totalCalories * servings;

        // Print the recipe details.
        System.out.println("Recipe Name: " + name);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) { // print attributes of each ingredient
            System.out.println("- " + ingredient.getName() + " (" + ingredient.getAmount() + " " + ingredient.getUnit() + ")");
        }
        System.out.println("Total Calories: " + totalCalories);
    }// printRecipe()

    // Method to create a new recipe by prompting the user for input.
    // Returns a Recipe object.
    public Recipe addRecipe(Scanner scnr) {
        // Input validation loop for recipe name.
        String name = "";
        do {
            System.out.print("Enter recipe name: ");
            name = scnr.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Recipe name cannot be empty. Please try again.");
            }
        } while (name.isEmpty());

        // Input validation loop for number of servings.
        short servings = 0;
        do {
            System.out.print("Enter number of servings: ");
            try {
                servings = Short.parseShort(scnr.nextLine());
                if (servings <= 0) {
                    System.out.println("Number of servings must be greater than 0. Please try again.");
                    servings = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (servings <= 0);

        // Create a list to hold ingredients.
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        // Loop to add ingredients until the user chooses to stop.
        while (true) {
            // Add an ingredient using the Ingredient class method.
            Ingredient ingredient = Ingredient.addIngredient(scnr);
            ingredients.add(ingredient);

            // Validate yes/no for adding more ingredients.
            char choice = ' ';
            do {
                System.out.println("Would you like to add another ingredient? (y/n): ");
                String input = scnr.nextLine().trim().toLowerCase();
                if (input.length() > 0) {
                    choice = input.charAt(0);
                    if (choice == 'y' || choice == 'n') {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            } while (true);

            if (choice == 'n') { // quit entering ingredients when user inputs 'n'
                break;
            }
        }
        return new Recipe(name, servings, ingredients);
    } // addRecipe()

    // Method to edit the recipe using a menu.
    public void editRecipe(Scanner scnr) {
        System.out.println("Editing recipe: " + name);
        System.out.println("1. Change name");
        System.out.println("2. Change servings");
        System.out.println("3. Edit ingredients");
        System.out.println("4. Adjust servings");
        System.out.println("5. Cancel");
        System.out.print("Choose what to edit (1-5): ");

        // Parse the user's choice.
        int editChoice = 0;
        try {
            editChoice = Integer.parseInt(scnr.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        // Handle the choice with a switch.
        switch (editChoice) {
            case 1:
                // Edit name.
                String newName = "";
                do {
                    System.out.print("Enter new name: ");
                    newName = scnr.nextLine().trim();
                    if (newName.isEmpty()) {
                        System.out.println("Recipe name cannot be empty. Please try again.");
                    }
                } while (newName.isEmpty());
                setName(newName);
                System.out.println("Name updated!");
                break;
            case 2:
                // Edit servings.
                short newServings = 0;
                do {
                    System.out.print("Enter new number of servings: ");
                    try {
                        newServings = Short.parseShort(scnr.nextLine());
                        if (newServings <= 0) {
                            System.out.println("Number of servings must be greater than 0. Please try again.");
                            newServings = 0;
                        } else {
                            setServings(newServings);
                            System.out.println("Servings updated!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }// try-catch
                } while (newServings <= 0);
                break;
            case 3:
                // Call method to edit ingredients.
                editIngredients(scnr);
                break;
            case 4:
                // Adjust servings.
                int adjustNewServings = 0;
                do {
                    System.out.print("Enter new number of servings: ");
                    try {
                        adjustNewServings = Integer.parseInt(scnr.nextLine());
                        if (adjustNewServings <= 0) {
                            System.out.println("Number of servings must be greater than 0. Please try again.");
                            adjustNewServings = 0;
                        } else {
                            adjustServings(adjustNewServings);
                            System.out.println("Servings adjusted!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }// try-catch
                } while (adjustNewServings <= 0);
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }// switch
    }// editRecipe()

    // Edit ingredients in the recipe.
    private void editIngredients(Scanner scnr) {
        // Loop for the ingredient editing menu.
        while (true) {
            // Display current ingredients.
            System.out.println("Current ingredients:");
            for (int i = 0; i < ingredients.size(); i++) {
                Ingredient ing = ingredients.get(i);
                System.out.println((i + 1) + ". " + ing.getName() + " (" + ing.getAmount() + " " + ing.getUnit() + ")");
            }
            System.out.println("1. Add new ingredient");
            System.out.println("2. Edit existing ingredient");
            System.out.println("3. Remove ingredient");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            // Parse the choice.
            int ingChoice = 0;
            try {
                ingChoice = Integer.parseInt(scnr.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            // Handle the choice.
            switch (ingChoice) {
                case 1:
                    // Add a new ingredient.
                    Ingredient newIng = Ingredient.addIngredient(scnr);
                    ingredients.add(newIng);
                    System.out.println("Ingredient added!");
                    break;
                case 2:
                    // Edit an existing ingredient.
                    System.out.print("Enter ingredient number to edit: ");
                    try {
                        int ingIndex = Integer.parseInt(scnr.nextLine()) - 1;
                        if (ingIndex >= 0 && ingIndex < ingredients.size()) {
                            Ingredient ing = Ingredient.addIngredient(scnr); // re-add to replace
                            ingredients.set(ingIndex, ing);
                            System.out.println("Ingredient updated!");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 3:
                    // Remove an ingredient.
                    System.out.print("Enter ingredient number to remove: ");
                    try {
                        int removeIndex = Integer.parseInt(scnr.nextLine()) - 1;
                        if (removeIndex >= 0 && removeIndex < ingredients.size()) {
                            ingredients.remove(removeIndex);
                            System.out.println("Ingredient removed!");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }// switch
        }// while (true)
    } // editIngredients()

    // Adjust recipe amounts for different number of servings
    public void adjustServings(int newServings) {
        if (newServings > 0) {
            double ratio = (double) newServings / servings;
            for (Ingredient ingredient : ingredients) {
                ingredient.setAmount(ingredient.getAmount() * (float) ratio);
                ingredient.setTotalCalories(ingredient.getTotalCalories() * ratio);
            }
            totalCalories = totalCalories * ratio;
            servings = (short) newServings;
        } else {
            System.out.println("Number of servings must be greater than zero. Please try again.");
        }
    } // adjustServings()

} // Recipe
