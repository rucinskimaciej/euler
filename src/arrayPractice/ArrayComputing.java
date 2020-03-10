package arrayPractice;

import java.util.Arrays;

public class ArrayComputing {

    int[][] biggerSum(int[][] arr1, int[][] arr2){
        CalculationsOnArrays calc = new CalculationsOnArrays();
        if (calc.sumArray(arr1) > calc.sumArray(arr2)){
            return arr1;
        } else {
            return arr2;
        }
    }

    String[] moreLetters(String[] arr1, String[] arr2){
        CalculationsOnArrays calc = new CalculationsOnArrays();
        if (calc.sumLetters(arr1) > calc.sumLetters(arr2)){
            return arr1;
        } else {
            return arr2;
        }
    }


    // CORRECT -> TESTED
    int[] arrayWithBiggestSum(int[][] arrays){
        int index = 0;
        int[] sums = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++){
            sums[i] = new CalculationsOnArrays().sumInArray(arrays[i]);
        }
        int max = 0;
        for (int i = 0; i < sums.length; i++){
            if (sums[i] >= max){
                max += sums[i];
                index = i;
            }
        }
        return arrays[index];
    }

}
