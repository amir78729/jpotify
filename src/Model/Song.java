package Model;

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


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
