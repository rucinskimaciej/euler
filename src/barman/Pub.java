package barman;

class Pub {
    public static void main(String[] args) {
        Bartender carl = new Bartender();

        Drink cubaLibre = carl.createDrink();
        System.out.println(cubaLibre);
    }
}
