package arrayPractice;

class ArrayPractice {
    public static void main(String[] args) {

        ArrayComputing a = new ArrayComputing();

        int[][] input = {{1, 2, 3}, {7, 8, 9}, {3, 4, 5}};

        String[] s1 = {"maciej", "costam"};
        String[] s2 = {"aa", "bb"};
        String[] resultString = a.moreLetters(s1, s2);

        int[][] input1 = {{1, 2, 3}, {7, 8, 9}};
        int[][] input2 = {{7, 8, 9}, {3, 4, 5}};
        int[][] result = a.biggerSum(input1, input2);
        System.out.println(input1 == result);
        System.out.println(input2 == result);

        for (String i: resultString) {
            System.out.print(i + " ");
        }
    }
}
