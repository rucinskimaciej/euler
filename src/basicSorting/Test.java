package basicSorting;

public class Test {
    public static void main(String[] args) {
        PlayerList players = new PlayerList();

        players.addPlayer(new Player("Maciej", 123));
        players.addPlayer(new Player("Agnieszka", 321));
        players.addPlayer(new Player("Brawurka", 999));
        System.out.println(players);

        players.sortPointsAscending();
        System.out.println(players);

        players.sortNamesAscending();
        System.out.println(players);

        players.sortNamesDescending();
        System.out.println(players);

    }
}
