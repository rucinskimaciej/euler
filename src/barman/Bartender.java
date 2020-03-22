package barman;

import java.util.*;

class Bartender {

    Drink createDrink(){
        Input input = new Input();
        String drinkName = input.getString("Enter Name of the drink: ");
        List<Ingredient> ingredients = new ArrayList<>();
        do {
            System.out.println("Enter the ingredient or hit ENTER to finish.");
            String ingredientName = input.getString("Ingredient: ");
            if (ingredientName.equals("")){
                input.close();
                break;
            }
            int ingredientQuantity = input.getInt("Quantity (ml): ");
            ingredients.add(new Ingredient(ingredientName, ingredientQuantity));
        } while (true);
        System.out.println("Drink created successfully!");
        return new Drink(drinkName, ingredients);
    }
}