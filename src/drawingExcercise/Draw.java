package drawingExcercise;

import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to draw? (square / rectangle / tree)" + "\n> ");
        switch (sc.nextLine().toLowerCase()){
            case "square":
                Square square = new Square();
                square.draw();
                System.out.println();
                break;
            case "rectangle":
                Rectangle rectangle = new Rectangle();
                rectangle.setData();
                rectangle.draw();
                break;
            case "tree":
                DrawTree tree = new DrawTree();
                tree.setData();
                tree.draw();
            default:
                break;
        }
    }
}
