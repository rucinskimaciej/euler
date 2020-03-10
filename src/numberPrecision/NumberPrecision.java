package numberPrecision;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.Stream;

public class NumberPrecision {
    public static void main(String[] args) {
        int number = getNumber();
        appendToTarget(number);
    }

    private static void appendToTarget(int target){
        BigDecimal step = BigDecimal.valueOf(0.1);
        Stream.iterate(BigDecimal.valueOf(0), x -> x.add(step))
                .limit((Math.abs(target) * 10) + 1)
                .forEach(x -> {
                    if (target > 0){
                        System.out.print(x + " ");
                    } else {
                        System.out.print(x.negate() + " ");
                    }
                });
    }

    private static int getNumber() {
        int number;
        do {
            System.out.print("Podaj liczbę różną o \"0\": ");
            number = new Scanner(System.in).nextInt();
            System.out.println();
        } while (number == 0);
        return number;
    }
}
