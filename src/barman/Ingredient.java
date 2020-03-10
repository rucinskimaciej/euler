package barman;

class Ingredient {
    private String ingredientName;
    private int quantityMilliliters;

    public Ingredient(String ingredientName, int quantityMilliliters) {
        this.ingredientName = ingredientName;
        this.quantityMilliliters = quantityMilliliters;
    }

    @Override
    public String toString() {
        return ingredientName + " (" + quantityMilliliters + ")";
    }
}
