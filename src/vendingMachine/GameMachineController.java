package vendingMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

class GameMachineController {
    private Scanner input = new Scanner(System.in);
    GameMachine game = new GameMachine();


    String buyGame() {
        String gameTitle = readGameTitle();
        int payment = collectPayment();
        return new GameMachine(gameTitle, payment).buy();
    }


    private String readGameTitle() {
        System.out.print("Enter game title: ");
        return input.nextLine();
    }

    private int collectPayment() {
        while (true) {
            System.out.print("Insert money: ");
            try {
                return filterCorrectPayment();
            } catch (InputMismatchException e) {
                e.getMessage();
            }
        }
    }

    private int filterCorrectPayment() {
        int money = getInt();
        if (money > 0) {
            return money;
        } else {
            throw new InputMismatchException("You must enter a positive, integer value here");
        }
    }

    private int getInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Value must be of integer type! Try again.");
            }
        }
    }
}
