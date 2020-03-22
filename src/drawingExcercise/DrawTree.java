package drawingExcercise;

import java.util.Scanner;

class DrawTree implements Drawable {
    private int height;

    @Override
    public void draw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= height; i++){
            for (int j = 0; j < (height - i + 1); j++){
                sb.append(" ");
            }

          //  example of use |
          //         .repeat v
            sb.append("*".repeat(1 + (i * 2))); // means exactly the same as above!!!!!!!!!!!
            sb.append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public void setData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("height: ");
        height = sc.nextInt();
        sc.nextLine();
        System.out.println();

    }
}
