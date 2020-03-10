package hangman;

import java.util.List;
import java.util.Scanner;

class Gameplay {
    private KeyWord word;
    private int count = 1;
    private final int TRIALS = 8;

    Gameplay(IPhraseSource iws) {
        this.word = new KeyWord(iws.getPhrase());
    }

    void hangMan(){
        Menu choice;
        do{
            System.out.println();
            System.out.println("Welcome to HangMan!");
            System.out.println(Menu.menuToString());
            switch (choice = Menu.chooseOption()){
                case PLAY:
                    game();
                    break;
                case EXIT:
                    System.out.println("Thank you, bye!");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (choice != Menu.EXIT);
    }

    private void game(){
        System.out.println("You have " + TRIALS + " trials. Good luck! :)");
        System.out.println(count + "/ " + TRIALS + ": " + word.getMaskedKeyWord());
        gamePlay();
        System.out.println(endGameMessage());
    }

    private String endGameMessage(){
        return word.correct() ? "Congratulations!" : "You loose!";
    }

    private void gamePlay(){
        while (count <= TRIALS && !word.correct()) {
            word.setMaskedKeyWord(enterNewGuess());
            System.out.println(count + "/ " + TRIALS + ": " + word.getMaskedKeyWord());
        }
    }

    private String enterNewGuess(){
        StringBuilder currentGuess = new StringBuilder(word.getMaskedKeyWord());
        System.out.print("Enter a letter: ");
        String guess = new Scanner(System.in).nextLine().toUpperCase();
        List<String> keyWordList = List.of(word.getKeyWord().split(""));
        int hits = 0;
        for (int i = 0; i < keyWordList.size(); i++){
            String letter = keyWordList.get(i);
            if (guess.equals(letter)){
                currentGuess.replace(i, i + 1, guess);
                hits++;
            }
        }
        if (hits == 0){
            count++;
        }

        return currentGuess.toString();
    }

}
