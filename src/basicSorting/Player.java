package basicSorting;

public class Player {
    private String nickname;
    private long points;

    public Player(String nickname, long points) {
        this.nickname = nickname;
        this.points = points;
    }

    public String getNickname() {
        return nickname;
    }

    public long getPoints() {
        return points;
    }
}
