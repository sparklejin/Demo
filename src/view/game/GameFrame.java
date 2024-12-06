package view.game;

import javax.swing.*;
import java.awt.*;

import controller.GameController;
import model.Direction;
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

    private JButton upBTn;
    private JButton downBTn;
    private JButton leftBTn;
    private JButton rightBTn;

    private JButton cancel;

    private WinFrame winFrame = new WinFrame();
    private LoseFrame loseFrame ;



    public GameFrame(int width, int height, MapMatrix mapMatrix) {
        this.setTitle("2024 CS109 Project Demo");
        this.setLayout(null);
        this.setSize(width, height);
        gamePanel = new GamePanel(mapMatrix);
        gamePanel.setLocation(30, height / 2 - gamePanel.getHeight() / 2);
        this.add(gamePanel);
        this.controller = new GameController(gamePanel, mapMatrix);
        this.controller.setGameFrame(this);
        this.restartBtn = FrameUtil.createButton(this, "Restart", new Point(gamePanel.getWidth() + 80, 120), 80, 50);
        this.loadBtn = FrameUtil.createButton(this, "Load", new Point(gamePanel.getWidth() + 80, 210), 80, 50);
        this.returnBTn = FrameUtil.createButton(this, "Return", new Point(gamePanel.getWidth() + 80, 300), 80, 50);
        this.stepLabel = FrameUtil.createJLabel(this, "Start", new Font("serif", Font.ITALIC, 22), new Point(gamePanel.getWidth() + 80, 70), 180, 50);
        gamePanel.setStepLabel(stepLabel);

        this.upBTn = FrameUtil.createButton(this, "Up", new Point(gamePanel.getWidth() + 300, 210), 80, 50);
        this.downBTn = FrameUtil.createButton(this, "Down", new Point(gamePanel.getWidth() + 300, 300), 80, 50);
        this.leftBTn = FrameUtil.createButton(this, "Left", new Point(gamePanel.getWidth() + 200, 300), 80, 50);
        this.rightBTn = FrameUtil.createButton(this, "Right", new Point(gamePanel.getWidth() + 400, 300), 80, 50);
        this.cancel = FrameUtil.createButton(this, "cancel", new Point(gamePanel.getWidth() + 400, 120), 80, 50);


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

        this.upBTn.addActionListener(e -> {
            System.out.println("Click VK_Up");
            if( controller.doMove(gamePanel.getHero().getRow(), gamePanel.getHero().getCol(), Direction.UP)){
                this.gamePanel.afterMove();
            }
        });
        this.downBTn.addActionListener(e -> {
            System.out.println("Click VK_Down");
            if( controller.doMove(gamePanel.getHero().getRow(), gamePanel.getHero().getCol(), Direction.DOWN)){
                this.gamePanel.afterMove();
            }
        });
        this.leftBTn.addActionListener(e -> {
            System.out.println("Click VK_Left");
            if( controller.doMove(gamePanel.getHero().getRow(), gamePanel.getHero().getCol(), Direction.LEFT)){
                this.gamePanel.afterMove();
            }
        });
        this.rightBTn.addActionListener(e -> {
            System.out.println("Click VK_Right");
            if( controller.doMove(gamePanel.getHero().getRow(), gamePanel.getHero().getCol(), Direction.RIGHT)){
                this.gamePanel.afterMove();
            }
        });

        this.cancel.addActionListener(e -> {
            System.out.println("over");
            this.dispose();
        });


        //todo: add other button here
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void win(){
        winFrame.setVisible(true);
        this.dispose();
    }
    public void lose(){
        loseFrame = new LoseFrame(this.controller);
        loseFrame.setVisible(true);
        this.setVisible(false);
    }

}
