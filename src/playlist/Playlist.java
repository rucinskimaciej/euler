package playlist;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    public static void main(String[] args) {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Ulalala", 320));
        songs.add(new Song("Nothing else matters", 650));
        int seconds = playlistLength(songs);
        LocalTime time = LocalTime.ofSecondOfDay(seconds);
        System.out.println(time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private static int playlistLength(List<Song> playlist){
        return playlist.stream()
                .mapToInt(s -> s.getSongTime())
                .sum();
    }

}
