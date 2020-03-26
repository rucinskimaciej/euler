package newRestaurant;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Client {
    private Map<Integer, Integer> order;
    private double tip;
    private double mealPrice;
    private double payment;

    Client(String orderString) {
        order = makeOrder(convertOrderStringToList(orderString));
        mealPrice = getMealPrice();
        tip = individualServiceTip();
        payment = mealPrice + tip;
    }

    public Map<Integer, Integer> getOrder() {
        return order;
    }

    void setTip(double tip) {
        this.tip += tip;
    }

    double getTip() {
        return tip;
    }

    private Map<Integer, Integer> makeOrder(List<Integer> orderList) {
        TreeMap<Integer, Integer> order = new TreeMap<>();
        orderList.forEach(position -> {
            order.putIfAbsent(position, 0);
            order.computeIfPresent(position, (key, value) -> ++value);
        });

        return order;
    }

    private List<Integer> convertOrderStringToList(String orderString) {
        return Stream.of(orderString.split(" "))
                .filter(element -> {
                    try {
                        Integer.parseInt(element);
                        return true;
                    } catch (NumberFormatException irrelevant) {
                        System.err.println("Could not process your order : " + element);
                        return false;
                    }
                })
                .map(numOrder -> Integer.parseInt(numOrder))
                .filter(element -> isInMenu(element))
                .collect(Collectors.toList());
    }

    private boolean isInMenu(int element) {
        try {
            Menu.choiceFromInt(element);
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(element + " is not in the menu!");
            return false;
        }
    }

    private double individualServiceTip() {
        return getMealPrice() > 100 ? getMealPrice() * 0.15 : getMealPrice() * 0.1;
    }

    double getMealPrice() {
        double mealPrice = 0;
        for (Integer key: order.keySet()) {
            double dishPrice = Menu.choiceFromInt(key - 1).getPrice();
            mealPrice += dishPrice * order.get(key);
        }
        return mealPrice;
    }

    void printClientOrder() {
        System.out.println("Twoje zamówienie:");

        TreeMap<Integer, Integer> sorted = new TreeMap<>(order);
        sorted.forEach((key, val) -> {
            Dish dish = Menu.values()[key - 1].getDish();
            double dishPrice = dish.getPrice();
            String line = String.format("%s (x%2d) SUM= %7.2f zł", dish, val, val * dishPrice);
            System.out.println(line);
        });
        System.out.println();
    }
}
