package barman;

import java.util.List;

class Drink {
    private String drinkName;
    private List<Ingredient> ingredients;

    public Drink(String drinkName, List<Ingredient> ingredients) {
        this.drinkName = drinkName;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(drinkName + ": \n");
        for (Ingredient ingredient: ingredients){
            output.append("- ").append(ingredient).append("\n");
        }
        return output.toString();
    }
}
