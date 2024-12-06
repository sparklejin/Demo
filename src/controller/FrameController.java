package controller;


import model.MapMatrix;
import util.FileUtil;
import view.game.GameFrame;
import view.level.LevelFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameController {
    private LevelFrame levelFrame;
    FileUtil fileUtil = new FileUtil();


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

    public void loadGame(String path, JFrame frame) {
        System.out.println(path);
        List<String> lines = fileUtil.readFileToList(path);
        for (String line : lines){
            System.out.println(line);
        }
        int[][] map = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String[] elements = lines.get(i).split(" ");
            map[i] = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                map[i][j] = Integer.parseInt(elements[j]);
            }
        }
        frame.dispose();
        MapMatrix mapMatrix = new MapMatrix(map);
        GameFrame gameFrame= new GameFrame(600,450,mapMatrix);
        gameFrame.setVisible(true);

    }
}
