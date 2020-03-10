package hangman;

import java.util.Arrays;
import java.util.stream.Collectors;

class KeyWord {
    private String  keyWord,
                    maskedKeyWord;

    KeyWord(String keyPhrase) {
        this.keyWord = keyPhrase.toUpperCase();
        maskedKeyWord = Arrays.stream(keyPhrase.split(""))
                .map(s -> {
                    if (s.equals(" ")){
                        return " ";
                    } else {
                        return "*";
                    }
                })
                .collect(Collectors.joining());
    }

    boolean correct(){
        return keyWord.equals(maskedKeyWord);
    }


    void setMaskedKeyWord(String maskedKeyWord) {
        this.maskedKeyWord = maskedKeyWord;
    }

    String getKeyWord() {
        return keyWord;
    }

    String getMaskedKeyWord() {
        return maskedKeyWord;
    }
}
