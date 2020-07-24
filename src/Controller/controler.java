package Controller;

import Model.Player;
import Model.Playlist;
import Model.Song;
import View.FileChooser;
import javazoom.jl.decoder.JavaLayerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class controler {

//    private static File file = new File("src/Songs/Eminem – Despicable.mp3");
//    private static File file = new File("Gdaal - Parvaneh (Ft Shaan).mp3");
//    private static File file = new File("We Got Used To Us.mp3");
//    private static javazoom.jl.player.advanced.AdvancedPlayer player;


//    static Runnable runnablePlay = new Runnable() {
//        @Override
//        public void run() {
//            try {
//                player = new javazoom.jl.player.advanced.AdvancedPlayer(new FileInputStream(file));
//                player.play();
//
//            } catch (JavaLayerException e) {
//                e.printStackTrace();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//    };

//    static Thread playThread = new Thread(runnablePlay);

    public static void main(String[] args)  {
//        playThread.start();
        try {

            FileChooser fileChooser = new FileChooser("E:\\Project\\src\\songs");
            Playlist playlist1 = new Playlist("1");
            Song s1 = new Song(fileChooser.chooseFile());
            Song s2 = new Song(fileChooser.chooseFile());
            Song s3 = new Song(fileChooser.chooseFile());
            playlist1.addSongToPlaylist(s1);
            playlist1.addSongToPlaylist(s2);
            playlist1.addSongToPlaylist(s3);
            Player player = new Player(s1);
            player.setPlaylist(playlist1);
            Scanner input = new Scanner(System.in);
            boolean run = true;
            Object pauseLock = new Object();
            while (run){
                    switch (input.nextInt()) {
                        case 0:{
                            player.starPlaying();
                            break;
                        }
                        case 1: {
                            player.playNext();
                            break;
                        }
                        case 2: {
                            player.setRepeat(input.nextInt());
                            break;
                        }
                        case 3: {
                        player.pause();
                            break;
                        }
                        case 4: {
                            player.play();
//                            player.playThread.notifyAll();
                            break;
                        }
                        case 5: {
                            run = false;
                            break;
                        }
                        default:
                            System.out.println("????????");
                            break;
                    }

            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
