package view.login;

import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private JButton VisitorsLogInBtn;
    private LevelFrame levelFrame;
    private JButton signupBtn;


    public LoginFrame(int width, int height) {
        this.setTitle("Login Frame");
        this.setLayout(null);
        this.setSize(width, height);
        JLabel userLabel = FrameUtil.createJLabel(this, new Point(50, 20), 70, 40, "username:");
        JLabel passLabel = FrameUtil.createJLabel(this, new Point(50, 80), 70, 40, "password:");
        password = FrameUtil.createJTextField(this, new Point(120, 80), 120, 40);
        username = FrameUtil.createJTextField(this, new Point(120, 20), 120, 40);
        submitBtn = FrameUtil.createButton(this, "Confirm", new Point(40, 140), 100, 40);
        resetBtn = FrameUtil.createButton(this, "Reset", new Point(160, 140), 100, 40);
        VisitorsLogInBtn = FrameUtil.createButton(this, "Visitors", new Point(40, 190), 100, 40);
        signupBtn=FrameUtil.createButton(this, "Sign Up", new Point(160, 190), 100, 40);
        submitBtn.addActionListener(e -> {
            System.out.println("Username = " + username.getText());
            System.out.println("Password = " + password.getText());
            if (this.levelFrame != null) {
                this.levelFrame.setVisible(true);
                this.setVisible(false);
            }
            //todo: check login info

        });
        VisitorsLogInBtn.addActionListener(e -> {
            this.levelFrame.setVisible(true);
            this.setVisible(false);
        });
        resetBtn.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });
        signupBtn.addActionListener(e -> {
            this.dispose();
            signupFrame  signupFrame=new signupFrame(500,310);
            signupFrame.setVisible(true);
        });


        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }

}
