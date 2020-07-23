package Controller;

import java.util.ArrayList;

public class Playlist {
    private String title;
    private String description;
    private ArrayList<Song> playlistSongs;

    //constructor
    public Playlist(String title, String description) {
        this.title = title;
        this.description = description;
        this.playlistSongs = new ArrayList<>();
    }

    //setters and getter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Song> getPlaylistSongs() {
        return playlistSongs;
    }

    public void setPlaylistSongs(ArrayList<Song> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }

    //methods
    public void addSongToPlaylist(Song song){
        this.playlistSongs.add(song);
        System.out.println(song + " added to " + this.title);
    }

    public void removeSongFromPlaylist(Song song){
        this.playlistSongs.remove(song);
        System.out.println(song + " removed from " + this.title);
    }

    public int countSongs(){
        return this.playlistSongs.size();
    }

}
