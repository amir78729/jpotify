package Model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Player {
    private javazoom.jl.player.advanced.AdvancedPlayer player;
    private Playlist playlist;
    private Song currentSong;
    private int repeat;
    // -1 for no repeat , 1 for repeat one , 2 for repeat play list
    private FileInputStream fileInputStream;
    public Thread playThread;
    private Runnable runnablePlay ;
    private boolean run;
    private boolean stop;
    int frames = 0;

    public Player(Song currentSong) throws FileNotFoundException, JavaLayerException {
        this.currentSong = currentSong;
        this.playlist = null;
        fileInputStream = new FileInputStream(currentSong.getFile());
        this.player = new javazoom.jl.player.advanced.AdvancedPlayer(fileInputStream);
        this.repeat = -1;
        run = false;
        stop = true;
    }


    public javazoom.jl.player.advanced.AdvancedPlayer getPlayer() {
        return player;
    }

    public void setPlayer(javazoom.jl.player.advanced.AdvancedPlayer player) {
        this.player = player;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void creatPlayer() throws JavaLayerException, FileNotFoundException {
        fileInputStream = new FileInputStream(currentSong.getFile());
        player = new javazoom.jl.player.advanced.AdvancedPlayer(fileInputStream);
    }

    public void starPlaying() throws InterruptedException {
        run = true;
            runnablePlay = new Runnable() {
                @Override
                public void run() {
                    stop = false;
                    while (run) {
                        if (!stop) {
                            try {
                                if (player == null){
                                    System.out.println("no player");
                                    creatPlayer();
                                    sleep(1000);
                                }else {
//                                    creatPlayer();

                                    System.out.println("player is playing " + currentSong.getName());
                                    player.play();
                                }
                            } catch (JavaLayerException | InterruptedException | FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        } else {
//                            player.close();
                            if (player != null)player = null;
                        }
                    }
                }

            };
//        if (playThread.isAlive()){
//            playThread.interrupt();
//        }
        playThread = new Thread(runnablePlay);
        playThread.start();

    }

    public void play(){
        stop = false;
        System.out.println("player started");

//        try {
//            creatPlayer();
//        } catch (JavaLayerException e) {
//            e.printStackTrace();
//        }
    }

    public void pause() throws InterruptedException, IOException {
        stop = true;
        fileInputStream.close();
//        frames = plgetPosition();
        player.close();
        System.out.println("player stopped");
//        player = null;
    }

    public void playNext() throws InterruptedException, IOException {
        pause();
        switch (repeat){
            case 1:{
                starPlaying();
                break;
            }
            case 2:{
                if (playlist == null){
                    if (playlist.getPlaylistSongs().indexOf(currentSong) == playlist.getPlaylistSongs().size()-1){
                        currentSong = playlist.getPlaylistSongs().get(0);
                    }else {
                        currentSong = playlist.getPlaylistSongs().get(playlist.getPlaylistSongs().indexOf(currentSong) + 1);
                    }
                    starPlaying();
                }else {
                    System.out.println("no playlists!");
                }
                break;
            }
            default:{
                currentSong = playlist.getPlaylistSongs().get(playlist.getPlaylistSongs().indexOf(currentSong) + 1);
                System.out.println("current song: "+currentSong.getName());
                starPlaying();
                break;
            }

        }
    }
}
