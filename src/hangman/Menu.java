package hangman;

import java.util.InputMismatchException;
import java.util.Scanner;

enum Menu {
    PLAY("Play"),
    EXIT("Exit");

    private String option;

    Menu(String option) {
        this.option = option;
    }

    static String menuToString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Choose an option:")
                .append("\n");
        for (Menu option: values()){
            stringBuilder.append((option.ordinal() + 1) + ". " + option)
                    .append("\n");
        }
        return stringBuilder.append("> ").toString();
    }

    static Menu chooseOption(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                Menu choice = Menu.values()[sc.nextInt() - 1];
                return choice;
            } catch (InputMismatchException | IndexOutOfBoundsException e){
                System.err.println("Wrong input!");
            } finally {
                sc.nextLine();
            }
        }
    }
}
