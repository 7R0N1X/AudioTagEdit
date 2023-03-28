package model;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v24Tag;
import com.mpatric.mp3agic.Mp3File;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.Main;

/**
 *
 * @author 7R0N1X
 */
public class FileManager {

    private String path, pathImg, data, folderName, newPath;
    private final Tag tag;

    public FileManager(Tag tag) {
        this.tag = tag;
    }

    public void selectFolder(JTextField folderPath) {
        JFileChooser jFile = new JFileChooser();
        jFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFile.setMultiSelectionEnabled(false);
        int answer = jFile.showOpenDialog(jFile);
        if (answer == JFileChooser.APPROVE_OPTION) {
            path = jFile.getSelectedFile().getPath();
            folderName = jFile.getSelectedFile().getName();
            folderPath.setText(path);
        }
    }

    public void selectCover(JLabel labelName, Main view) {
        JFileChooser jFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
        jFile.setFileFilter(filter);
        int answer = jFile.showOpenDialog(jFile);
        if (answer == JFileChooser.APPROVE_OPTION) {
            pathImg = jFile.getSelectedFile().getPath();
            adaptImage(labelName, view, pathImg);
        }
    }

    public void adaptImage(JLabel labelName, Main view, String pathImg) {
        Image img = new ImageIcon(pathImg).getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setBorder(BorderFactory.createEmptyBorder());
        labelName.setIcon(icon);
        view.repaint();
    }

    public void labelConfiguration() throws IOException, InterruptedException {
        createFolder(path);
        AudioConverter audioConverter = new AudioConverter(path, path);
        deleteFiles(path);

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(path))) {
            for (Path path : ds) {
                if (path.getFileName().toString().endsWith(".mp3")) {
                    Mp3File mp3file = new Mp3File(path);
                    
                    ID3v2 id3v2Tag;
                    if (mp3file.hasId3v2Tag()) {
                        id3v2Tag = mp3file.getId3v2Tag();
                    } else {
                        id3v2Tag = new ID3v24Tag();
                        mp3file.setId3v2Tag(id3v2Tag);
                    }
                    id3v2Tag.setTrack("");
                    id3v2Tag.setArtist(tag.getArtist());
                    id3v2Tag.setTitle(removeExtension(path.getFileName().toString()));
                    id3v2Tag.setAlbum(tag.getAlbum());
                    id3v2Tag.setYear(tag.getYear());
                    id3v2Tag.setGenre(12);
                    id3v2Tag.setComment("");
                    id3v2Tag.setPublisher(tag.getPublisher());
                    id3v2Tag.setCopyright(tag.getCopyright());

                    byte[] bytes;
                    try (RandomAccessFile file = new RandomAccessFile(pathImg, "r")) {
                        bytes = new byte[(int) file.length()];
                        file.read(bytes);
                    }
                    id3v2Tag.setAlbumImage(bytes, "image/jpeg");

                    mp3file.save(newPath + "\\" + path.getFileName().toString());
                }
            }
            JOptionPane.showMessageDialog(null, "Process successfully completed.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has ocurred in the process.");
            System.err.println("Error aaaaa: " + e.toString());
        }
    }

    String removeExtension(String nameFile) {
        int quantity = 4;
        String newTitle = nameFile.substring(0, nameFile.length() - quantity);
        return newTitle;
    }

    void deleteFiles(String path) {
        File file = new File(path);
        File[] filesToDelete = file.listFiles((dir, nombre)
                -> nombre.toLowerCase().endsWith(".wav")
                || nombre.toLowerCase().endsWith(".m4a")
                || nombre.toLowerCase().endsWith(".flac"));
        for (File f : filesToDelete) {
            f.delete();
        }
    }

    public void createFolder(String path) {
        File file = new File(path + "/Modified files");
        if (!file.exists()) {
            if (file.mkdirs()) {
                newPath = file.toString();
            }
        }else{
            newPath = file.toString();
        }
    }

    public void generateList() throws IOException {
        createFolder(path);
        String path = newPath + "\\" + folderName + ".txt";
        File file = new File(path);
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(newPath))) {
            for (Path _path : ds) {
                if (_path.getFileName().toString().endsWith(".mp3")) {
                    data = removeExtension(_path.getFileName().toString()) + "\n";
                    bw.write(data);
                }
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Process successfully completed.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has ocurred in the process.");
            System.out.println("Error: " + e.toString());
        }
    }
}
