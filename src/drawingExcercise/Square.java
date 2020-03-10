package drawingExcercise;

import java.util.Scanner;

public class Square implements Drawable {

    private int a;

    @Override
    public void draw() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a; i++){
            for (int j = 0; j < a; j++){
                builder.append(" * ");
                if (j == a - 1){
                    builder.append("\n");
                }
            }
        }
        System.out.println(builder);
    }

    @Override
    public void setData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("a: ");
        a = sc.nextInt();
        sc.nextLine();
        System.out.println();
    }


}
