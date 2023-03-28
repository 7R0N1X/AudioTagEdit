package main;

import controller.Controller;
import model.FileManager;
import model.Tag;

/**
 *
 * @author 7R0N1X
 */
public class Main {

    public static void main(String[] args) {
        view.Main viewMain = new view.Main();
        Tag tag = new Tag();
        FileManager fileManager = new FileManager(tag);

        Controller ctrl = new Controller(viewMain, tag, fileManager);
        ctrl.Start();

        viewMain.JTF_Year.setText(tag.getYear());
        viewMain.setSize(390, 589);
        viewMain.setVisible(true);
    }
}
