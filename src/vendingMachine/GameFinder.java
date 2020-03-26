package vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class GameFinder {
    private GameMachine gameDataBase = new GameMachine();

    Game findGame(String title) {
        for (Game game: gameDataBase.games) {
            if (game.getTitle().equals(title)) {
                return game;
            }
        }
        return null;
    }
}
