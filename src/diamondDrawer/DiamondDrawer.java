package diamondDrawer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DiamondDrawer {
    public static void main(String[] args) {
        String diamond = createDiamond(10);
        System.out.println(diamond);
        System.out.println(Long.MAX_VALUE);
    }

    private static String createDiamond(int length){
        StringBuilder diamond = new StringBuilder();
        for (int i = length - 1; i >= 0; i--){
            diamond.append(createLineOf(' ', i))
            .append(createLineOf('*', length))
            .append("\n");
        }
        return diamond.toString();
    }

    private static String createLineOf(char ch, int lineLength){
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < lineLength; i++){
            stars = stars.append(ch);
        }
        return stars.toString();
    }

    private static int getNumberAboveZero(){
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean correct = false;

        do {
            try {
                number = sc.nextInt();
            } catch (InputMismatchException e){
                System.err.println("input must be a number > 0");
            } finally {
                sc.nextLine();
            }
            if (number > 0){
                correct = true;
            }
        } while (!correct);

        sc.close();
        return number;
    }
}


