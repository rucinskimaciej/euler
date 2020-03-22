package playlist;

class Song {
    private String songName;
    private int songTime;

    Song(String songName, int songTime) {
        this.songName = songName;
        this.songTime = songTime;
    }

    int getSongTime() {
        return songTime;
    }
}
