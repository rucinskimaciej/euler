package playlist;

public class Song {
    private String songName;
    private int songTime;

    public Song(String songName, int songTime) {
        this.songName = songName;
        this.songTime = songTime;
    }

    public int getSongTime() {
        return songTime;
    }
}
