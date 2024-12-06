package view.game;

import controller.GameController;
import model.MapMatrix;
import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;

public class LoseFrame extends JFrame {
    private  JButton returnBTn;
    private GamePanel gamePanel;
    private JLabel stringLose;
    private JButton restartBtn;

    private GameController controller;

    public GameController getController() {
        return controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public LoseFrame(GameController controller){
        this.setTitle("LoseFrame");
        this.setLayout(null);
        this.setSize(500, 500);
        this.setController(controller);


        this.stringLose = FrameUtil.createJLabel(this, "you LOSE HAHA!", new Font("serif", Font.ITALIC, 22), new Point(250, 70), 180, 50);
        this.restartBtn = FrameUtil.createButton(this, "Restart", new Point(180, 300), 80, 50);
        this.returnBTn = FrameUtil.createButton(this, "Return", new Point(280, 300), 80, 50);
        this.returnBTn.addActionListener(e -> {
            LevelFrame.getFrameController().returnLevelFrame(this);
            //   gamePanel.requestFocusInWindow();
        });
        this.restartBtn.addActionListener(e -> {
            this.controller.restartGame();
            this.controller.getGameFrame().setVisible(true);
            this.dispose();


        });
    }

}
