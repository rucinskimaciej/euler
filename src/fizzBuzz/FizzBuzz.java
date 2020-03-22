package fizzBuzz;

import java.util.stream.IntStream;

class FizzBuzz {
    public static void main(String[] args) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";

//        for (int i = 1; i <= 100; i++){
//            if (instruction(i, 3) && instruction(i, 5)){
//                System.out.println(i + " "+ fizz);
//            } else if (instruction(i, 3)){
//                System.out.println(i + " " + buzz);
//            } else if (instruction(i, 5)){
//                System.out.println(i + " " + fizzBuzz);
//            }
//        }

        IntStream.rangeClosed(1, 100)
                .filter(x -> isDividedBy(x, 3) || isDividedBy(x, 5) || (isDividedBy(x, 3) && isDividedBy(x, 5)))
                .forEach(x -> {
                    if (isDividedBy(x, 3) && isDividedBy(x, 5)){
                        System.out.println(x + " " + fizzBuzz);
                    } else if (isDividedBy(x, 3)){
                        System.out.println(x + " " + fizz);
                    } else if (isDividedBy(x, 5)){
                        System.out.println(x + " " + buzz);
                    }
                });

    }

    private static boolean isDividedBy(int number, int divider) {
        return number % divider == 0;
    }


}
