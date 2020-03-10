package hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WordSource {

        private final String FILE_NAME = "HangManWords.txt";

    String fromFile() {
        List<String> outputList = new ArrayList<>();
        try (
                var fr = new FileReader(FILE_NAME);
                var reader = new BufferedReader(fr);
        ) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null){
                outputList.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        outputList = outputList.stream()
//                .filter(s -> noSpecialSigns(s))
//                .collect(Collectors.toList());

        return Arrays.stream(outputList.get(new Random().nextInt(outputList.size())).split(""))
                .filter(s -> noSpecialSigns(s))
                .collect(Collectors.joining());
    }

    private boolean noSpecialSigns(String s) {
        char min = '!';
        char max = '\'';
        for (int i = min; i <= max || (i >= '{' && i <= '~'); i++){
            if (s.charAt(0) == i){
                return false;
            }
        }
        return true;
    }

    String fromList(){
        return WORDS.get(new Random().nextInt(WORDS.size())).toUpperCase();
    }

    private static final List<String> WORDS = new ArrayList<>(List.of(
            "java",
            "programming",
            "dog",
            "yellow",
            "wardrobe",
            "backpack",
            "window",
            "clock",
            "mirror",
            "eyeglasses"
    ));



}
