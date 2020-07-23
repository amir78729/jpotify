import javazoom.jl.decoder.JavaLayerException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class controler {

//    private static File file = new File("Eminem – Despicable.mp3");
//    private static File file = new File("Gdaal - Parvaneh (Ft Shaan).mp3");
    private static File file = new File("We Got Used To Us.mp3");
    private static javazoom.jl.player.advanced.AdvancedPlayer player;

    {

    }
    static Runnable runnablePlay = new Runnable() {
        @Override
        public void run() {
            try {
                player = new javazoom.jl.player.advanced.AdvancedPlayer(new FileInputStream(file));
                player.play();

            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    static Thread playThread = new Thread(runnablePlay);

    public static void main(String[] args) throws JavaLayerException {
        playThread.start();
    }

}
