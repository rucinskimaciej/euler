package restauracja;

import java.util.*;
import java.util.stream.Stream;

class Order {
    private Map<Integer, Integer> order;
//    private List<Dish> order;

    void make(){
        System.out.println("Witamy w naszej restauracji! " + "\n" +
                "Oto dzisiejsze menu:" + "\n");
        Menu.printMenu();
        System.out.println("Zamów wybrane potrawy, wymieniając ich numery oddzielone spacjami:");

        boolean orderOK = false;
        while (!orderOK) {
            order = getOrder(new Scanner(System.in).nextLine());
            orderOK = true;
        }
        System.out.println();
        printOrder();
        paymentMessage();
    }

    private void printOrder() {
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

    private void paymentMessage() {
        String formatter = "%-15s" + "%-5.2f zł";
        System.out.println(String.format(formatter, "Do zapłaty:", getTotalPrice()));
        System.out.println(String.format(formatter, "Koszt dań:", getMealPrice()));
        System.out.println(String.format(formatter, "Koszt obsługi:", getServiceTip()));

    }

    private Map<Integer, Integer> getOrder(String orderString) {
        Map<Integer, Integer> order = new TreeMap<>();
        Stream.of(orderString.split(" "))
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
                .forEach(numOrder -> {
                    order.putIfAbsent(numOrder, 0);
                    order.computeIfPresent(numOrder, (key, val) -> val + 1);
                });
        return order;
    }

    private double getTotalPrice() {
        return getMealPrice() + getServiceTip();
    }

    private double getServiceTip() {
        return getMealPrice() > 100 ? getMealPrice() * 0.15 : getMealPrice() * 0.1;
    }

    private double getMealPrice() {
        double mealPrice = 0;
        for (Integer key: order.keySet()) {
            double dishPrice = Menu.choiceFromInt(key - 1).getPrice();
            mealPrice += dishPrice * order.get(key);
        }
        return mealPrice;
    }
}
