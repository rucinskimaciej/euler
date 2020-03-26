package newRestaurant;

enum Menu {
    PIZZA_MARGHARITA (new Dish("Pizza Margherita", 24.99)),
    PIZZA_MAFIOSO (new Dish("Pizza Mafioso", 29.99)),
    SPAGHETTI_BOLOGNESE (new Dish("Spaghetti Bolognese", 31.99)),
    SPAGHETTI_CARBONARA (new Dish("Spaghetti Carbonara", 26.99)),
    LASAGNE (new Dish("Lasagne", 24.99)),
    GAZPACHO (new Dish("Gazpacho", 16.99)),
    CANNELLONI_ZE_SZPINAKIEM (new Dish("Cannelloni ze szpinakiem", 29.99)),
    BRUSCHETTA (new Dish("Bruschetta", 13.99)),
    TIRAMISU (new Dish("Tiramisu", 19.99)),
    PANNA_COTTA (new Dish("Panna Cotta", 19.99)),
    EXSTRA_SER (new Dish ("Dodatkowy ser", 4.99));


    private final Dish dish;

    Menu(Dish dish) {
        this.dish = dish;
    }

    public Dish getDish() {
        return dish;
    }

    static String menuPrintFormat() {
        return "%2d. %-50s";
    }

    static void printMenu() {
        for (Menu dish: Menu.values()) {
            String position = String.format(menuPrintFormat(), (dish.ordinal() + 1), dish.dish);
            System.out.println(position);
        }
    }

    static Dish choiceFromInt(int number) throws ArrayIndexOutOfBoundsException {
        return values()[number].dish;
    }

    static int getLongestDishName() {
        int maxLength = 0;
        for (Menu position: values()) {
            int dishNameLength = position.dish.getName().length();
            if (dishNameLength > maxLength) {
                maxLength = dishNameLength;
            }
        }
        return maxLength;
    }
}
