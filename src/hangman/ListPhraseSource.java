package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListPhraseSource implements IPhraseSource {
    @Override
    public String getPhrase() {
        String keyword = PHRASES.get(new Random().nextInt(PHRASES.size())).toUpperCase();
        return Arrays.stream(keyword.split(""))
                .filter(s -> noSpecialSigns(s))
                .toString();
    }

    private final List<String> PHRASES = new ArrayList<>(List.of(
            "java programming",
            "writing code",
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
