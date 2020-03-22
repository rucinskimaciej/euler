package basicSorting;

import java.util.Arrays;
import java.util.Comparator;

public class PlayerList {
    private Player[] players = new Player[0];

    void addPlayer(Player player) {
        int currentLength = players.length;
        int newLength = currentLength + 1;
        players = Arrays.copyOf(players, newLength);
        players[newLength - 1] = player;
        sortPointsDescending();
    }

    void sortNamesAscending() {
        Arrays.sort(players, (player1, player2) -> player1.getNickname().compareTo(player2.getNickname()));
    }

    void sortNamesDescending() {
        Arrays.sort(players, (player1, player2) -> player2.getNickname().compareTo(player1.getNickname()));
    }

    void sortPointsAscending() {
        Arrays.sort(players, (player1, player2) -> (int) (player1.getPoints() - player2.getPoints()));
    }

    void sortPointsDescending() {
        Arrays.sort(players, (player1, player2) -> (int) (player2.getPoints() - player1.getPoints()));
    }

    @Override
    public String toString() {
        int counter = 1;
        StringBuilder output = new StringBuilder(formatLine("#", "Nickname", "Points"));
        int lineLength = output.length();
        output.append("-".repeat(lineLength)).append("\n");

        for (Player player: players) {
            output.append(formatLine(String.valueOf(counter++), player.getNickname(), String.valueOf(player.getPoints())));
        }
        return output.toString();
    }

    private String formatLine(String number, String nickname, String points) {
        return String.format("|%3s| %-20.20s | %-10s", number, nickname, points) + "\n";
    }
}
