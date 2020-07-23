import java.io.File;

public class Song {
    private File file;
    private String path;
    public Song(File song){
        this.file = song;
        this.path = song.getPath();

    }
}
