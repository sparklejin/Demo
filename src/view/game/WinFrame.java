package view.game;

import model.MapMatrix;
import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;

public class WinFrame extends JFrame {
    private  JButton returnBTn;
    private GamePanel gamePanel;
    private JLabel stringWin;



    public WinFrame(){
        this.setTitle("WinFrame");
        this.setLayout(null);
        this.setSize(500, 500);
        this.stringWin = FrameUtil.createJLabel(this, "you win", new Font("serif", Font.ITALIC, 22), new Point(250, 70), 180, 50);

        this.returnBTn = FrameUtil.createButton(this, "Return", new Point(250, 300), 80, 50);
        this.returnBTn.addActionListener(e -> {
            LevelFrame.getFrameController().returnLevelFrame(this);
         //   gamePanel.requestFocusInWindow();
        });
    }

}
