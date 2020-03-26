package vendingMachine;

public class Main {
    public static void main(String[] args) {
        var result = new GameMachineController().buyGame();
        System.out.println(result);
    }

}
