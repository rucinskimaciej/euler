package newRestaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();
        int choice = 0;

        System.out.println("Witamy w restauracji!");
        Menu.printMenu();
        while (choice != 2) {
            printOptions();
            System.out.println();
            switch (choice = sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Wybierz pozycje z menu oddzielając je spacjami.");
                    clients.add(new Client(sc.nextLine()));
                    System.out.println("Pozycje wybrane z menu: ");
                    clients.get(clients.size() - 1).getOrder().forEach((position, count) -> {
                        String formatter = "%-2sx %s";
                        Client current = clients.get(clients.size() - 1);
                        System.out.println(String.format(formatter, count, Menu.choiceFromInt(position)));
                    });
//                    System.out.println("\n");
                    System.out.println("Dziękuję. Oczekuj na zamówienie!");
                    break;
                case 2:
                    if (clients.isEmpty()) {
                        System.out.println("Cannot print an empty receipt - please make an order for at least 1 client.");
                        break;
                    } else {
                        new Order(clients).printReceipt();
                        break;
                    }
                default:
                    System.out.println("Wrong option - try again.");
                    break;

            }
            System.out.println("Co jeszcze chcesz zrobić?");
        }
    }

    private static void printOptions() {
        System.out.println();
        System.out.println("Wybierz:");
        System.out.println("    1. Dodaj nowe zamówienie");
        System.out.println("    2. Wydrukuj rachunek dla wszystkich klientów");
    }
}
