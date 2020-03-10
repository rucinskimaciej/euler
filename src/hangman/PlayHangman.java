package hangman;

import java.util.Scanner;

public class PlayHangman {
    public static void main(String[] args) {
        Gameplay play;
        play = new Gameplay(chooseSource());
        play.hangMan();

    }

    private static IPhraseSource chooseSource() {
        System.out.println("Which phrase source do you want to use?");
        System.out.print("FILE or LIST > ");
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "FILE":
                return new FilePhraseSource();
            case "LIST":
                return new ListPhraseSource();
            default:
                throw new ArrayIndexOutOfBoundsException("No such option");
        }
    }
}
