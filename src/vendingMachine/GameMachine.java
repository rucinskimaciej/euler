package vendingMachine;

import java.util.*;

class GameMachine {
    final Set<Game> games = new HashSet<>(List.of(
            new Game("Heroes 3", 29.99),
            new Game("The Witcher 3", 99.99),
            new Game("Need For Speed: Most Wanted", 42.49)
    ));

    private String gameTitle;
    private double payment;
    private Game game;

    GameMachine() {
    }

    GameMachine(String gameTitle, int payment) {
        this.gameTitle = gameTitle;
        this.payment = payment;
    }

    String buy() {
        game = getGame();
        String output = gameNotInDatabase();
        if (output == null) {
            return gameIsInDatabase();
        }
        return output;
    }

    private String gameNotInDatabase() {
        if (game == null) {
            return String.format("The game \"%s\" is not in the database.", gameTitle);
        }
        return null;
    }

    private String gameIsInDatabase(){
        if (payment < game.getPrice()) {
            return String.format("The game \"%s\" costs %.2f PLN, while you paid %.2f PLN", game.getTitle(), game.getPrice(), payment);
        } else {
            double change = payment - game.getPrice();
            var output = String.format("You bought the game: %s", game.getTitle()) + "\n";
            output += String.format("Here is your change: %.2f", change);
            return output;
        }
    }

    private Game getGame() {
        return new GameFinder().findGame(gameTitle);
    }

}
