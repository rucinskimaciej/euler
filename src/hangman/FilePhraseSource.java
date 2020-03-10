package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;



public class FilePhraseSource implements IPhraseSource {

    private final String FILE_NAME = "HangManWords.txt";

    @Override
    public String getPhrase() {
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
        String phrase = outputList.get(new Random().nextInt(outputList.size()));

        return Arrays.stream(phrase.split(""))
                .filter(s -> noSpecialSigns(s))
                .collect(Collectors.joining());
    }
}
