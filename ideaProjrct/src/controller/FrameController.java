package controller;

import util.FileUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.util.List;


public class FrameController {
    private LevelFrame levelFrame;
    FileUtil fileUtil=new FileUtil();
    public LevelFrame getLevelFrame() {
        return levelFrame;
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }

    public void returnLevelFrame(JFrame frame) {
        frame.dispose();
        levelFrame.setVisible(true);
    }

    public void loadGame(String path) {
        System.out.println(path);
        List<String> lines = fileUtil.readFileToList(path);
        for(String line:lines){
            System.out.println(line);
        }

    }
}
