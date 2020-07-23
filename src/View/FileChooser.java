package View;

import javax.swing.*;
import java.io.File;

public class FileChooser {
    private JFileChooser fileChooser;

    public FileChooser() {
        this.fileChooser = new JFileChooser();
    }

    public FileChooser(String path) {
        this.fileChooser = new JFileChooser(path);
    }

    public File chooseFile(){
        int returnValue = this.fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = this.fileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile;
        }
        System.out.println("file not found!");
        return null;
    }
}
