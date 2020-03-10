package arrayPractice;

import java.util.Arrays;

public class CalculationsOnArrays {

    int sumArray(int [][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }

    int sumInArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    int sumLetters(String[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.length();
    }

    int maxNumberInArray(int[] arr){
        return Arrays.stream(arr)
                .max()
                .getAsInt();
    }

    int minNumberInArray(int[] arr){
        return Arrays.stream(arr)
                .min()
                .getAsInt();
    }
}
