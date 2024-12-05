package view.game;

import javax.swing.*;
import java.awt.*;

import controller.GameController;
import model.MapMatrix;
import view.FrameUtil;
import view.level.LevelFrame;

public class GameFrame extends JFrame {

    private GameController controller;
    private JButton restartBtn;
    private JButton loadBtn;

    private JButton returnBTn;
    private JLabel stepLabel;
    private GamePanel gamePanel;

    public GameFrame(int width, int height, MapMatrix mapMatrix) {
        this.setTitle("2024 CS109 Project Demo");
        this.setLayout(null);
        this.setSize(width, height);
        gamePanel = new GamePanel(mapMatrix);
        gamePanel.setLocation(30, height / 2 - gamePanel.getHeight() / 2);
        this.add(gamePanel);
        this.controller = new GameController(gamePanel, mapMatrix);

        this.restartBtn = FrameUtil.createButton(this, "Restart", new Point(gamePanel.getWidth() + 80, 120), 80, 50);
        this.loadBtn = FrameUtil.createButton(this, "Load", new Point(gamePanel.getWidth() + 80, 210), 80, 50);
        this.returnBTn = FrameUtil.createButton(this, "Return", new Point(gamePanel.getWidth() + 80, 300), 80, 50);
        this.stepLabel = FrameUtil.createJLabel(this, "Start", new Font("serif", Font.ITALIC, 22), new Point(gamePanel.getWidth() + 80, 70), 180, 50);
        gamePanel.setStepLabel(stepLabel);

        this.restartBtn.addActionListener(e -> {
            controller.restartGame();
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.loadBtn.addActionListener(e -> {
            String path = JOptionPane.showInputDialog(this, "Input path:");
            //String path = String.format("resource/%s/game1.txt",user.name());
            LevelFrame.getFrameController().loadGame(path, this);
            //System.out.println(string);
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.returnBTn.addActionListener(e -> {
            LevelFrame.getFrameController().returnLevelFrame(this);
            gamePanel.requestFocusInWindow();
        });

        //todo: add other button here
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
