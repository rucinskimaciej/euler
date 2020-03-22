package drawingExcercise;

import java.util.Scanner;

class Rectangle implements Drawable{
    private int a;
    private int b;


    @Override
    public void draw() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                builder.append(" * ");
                if (j == b - 1){
                    builder.append("\n");
                }
            }
        }
        System.out.println(builder);
    }

    @Override
    public void setData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("a: ");
        a = sc.nextInt();
        sc.nextLine();

        System.out.print("b: ");
        b = sc.nextInt();
        sc.nextLine();
        System.out.println();
    }
}
