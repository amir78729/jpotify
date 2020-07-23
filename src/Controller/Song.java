package Controller;

import java.io.File;

public class Song {
    private File file;
    private String path;
    private String name;
    public Song(File song){
        this.file = song;
        this.path = song.getPath();
        this.name = song.getName();

    }
}
