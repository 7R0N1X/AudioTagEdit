package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.FileManager;
import model.Tag;
import view.Main;

/**
 *
 * @author 7R0N1X
 */
public class Controller implements ActionListener {

    private final Main viewMain;
    private final Tag tag;
    private final FileManager fileManager;

    public Controller(Main viewMain, Tag tag, FileManager fileManager) {
        this.viewMain = viewMain;
        this.tag = tag;
        this.fileManager = fileManager;

        this.viewMain.JMI_SelectFolder.addActionListener(this);
        this.viewMain.JMI_SelectCover.addActionListener(this);
        this.viewMain.JMI_EditAllFiles.addActionListener(this);
        this.viewMain.JMI_GenerateList.addActionListener(this);
    }

    public void Start() {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/image/music-icon.png"));
            viewMain.setIconImage(icon.getImage());
            viewMain.setTitle("Audio Tag Edit");
            viewMain.setLocationRelativeTo(null);
            viewMain.setResizable(false);

            tag.setArtist(viewMain.JTF_Artist.getText());
            tag.setAlbum(viewMain.JTF_Album.getText());
            tag.setPublisher(viewMain.JTF_Publisher.getText());
            tag.setCopyright(viewMain.JTF_Copyright.getText());

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewMain.JMI_SelectFolder) {
            fileManager.selectFolder(viewMain.JTF_FolderPath);
        }
        if (e.getSource() == viewMain.JMI_SelectCover) {
            fileManager.selectCover(viewMain.JL_Cover, viewMain);
        }
        if (e.getSource() == viewMain.JMI_EditAllFiles) {
            try {
                fileManager.labelConfiguration();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == viewMain.JMI_GenerateList) {
            try {
                fileManager.generateList();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
