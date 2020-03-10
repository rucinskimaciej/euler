package hangman;

public interface IPhraseSource {

    String getPhrase();

    default boolean noSpecialSigns(String s) {
        char min = '!';
        char max = '\'';
        for (int i = min; i <= max || (i >= '{' && i <= '~'); i++){
            if (s.charAt(0) == i){
                return false;
            }
        }
        return true;
    }
}


