package restauracja;

public class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-30.30s %5.2f zł", name + ".".repeat(30), price);
    }
}
