package barman;

import java.util.InputMismatchException;
import java.util.Scanner;

class Input {
    private Scanner scanner = new Scanner(System.in);

    String getString(String message){
        System.out.print(message);
        return scanner.nextLine();
    }

    int getInt(String message) {
        int result = 0;
        boolean intOK = false;
        do {
            try {
                System.out.print(message);
                result = scanner.nextInt();
                intOK = true;
            } catch (InputMismatchException e){
                System.err.println("Wrong value - enter integer!");
            } finally {
                scanner.nextLine();
            }
        } while (!intOK);
        return result;
    }

    void close(){
        scanner.close();
    }
}
