package view.login;

import view.FrameUtil;
import view.level.LevelFrame;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class signupFrame extends JFrame {
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JLabel confirmPasswordLabel;
    private JTextField confirmPasswordTextField;
    private JButton signupBtn;
    private JButton cancelButton;
    private JButton  resetButton;
    private JLabel errorLabel;
    private JLabel successLabel;
    private JLabel titleLabel;
    private LevelFrame levelFrame;

    public signupFrame(int width, int height) {
        this.setTitle("Sign Up");
        this.setLayout(null);
        this.setSize(width, height);
        JLabel userLabel = FrameUtil.createJLabel(this, new Point(50, 20), 70, 40, "username:");
        JLabel passLabel = FrameUtil.createJLabel(this, new Point(50, 80), 70, 40, "password:");
        JLabel confirmpassLabel = FrameUtil.createJLabel(this, new Point(50, 140), 120, 40, "confirmpassword:");
        nameTextField = FrameUtil.createJTextField(this, new Point(140, 20), 120, 40);
        passwordTextField = FrameUtil.createJTextField(this, new Point(140, 80), 120, 40);
        confirmPasswordTextField = FrameUtil.createJTextField(this, new Point(180, 140), 120, 40);
        signupBtn = FrameUtil.createButton(this, "Sign Up", new Point(60, 190), 100, 40);
        cancelButton = FrameUtil.createButton(this, "Cancel", new Point(180, 190), 100, 40);
        resetButton = FrameUtil.createButton(this, "Reset", new Point(300, 190), 100, 40);
        errorLabel = FrameUtil.createJLabel(this, new Point(50, 240), 200, 40, "");
        successLabel = FrameUtil.createJLabel(this, new Point(50, 280), 200, 40, "");


        cancelButton.addActionListener(e -> {
            if (this.levelFrame == null) {
                this.levelFrame = new LevelFrame(500, 200);
            }

            LoginFrame loginFrame = new LoginFrame(350, 300);
            loginFrame.setLevelFrame(this.levelFrame);
            loginFrame.setVisible(true);
            this.dispose();
        });

        signupBtn.addActionListener(e -> {
            if (nameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || confirmPasswordTextField.getText().isEmpty()) {
                errorLabel.setText("Please fill all the fields");
                errorLabel.setForeground(Color.RED);
                nameTextField.setText("");
                passwordTextField.setText("");
                confirmPasswordTextField.setText("");
            } else if (!passwordTextField.getText().equals(confirmPasswordTextField.getText())) {
                errorLabel.setText("Passwords do not match");
                errorLabel.setForeground(Color.RED);
                passwordTextField.setText("");
                confirmPasswordTextField.setText("");
            } else {
                successLabel.setText("Successfully signed up");
                successLabel.setForeground(Color.GREEN);

                // 检查并初始化 levelFrame
                if (this.levelFrame == null) {
                    this.levelFrame = new LevelFrame(500, 200);
                }

                LoginFrame loginFrame = new LoginFrame(350, 300);
                loginFrame.setLevelFrame(this.levelFrame);
                loginFrame.setVisible(true);
                this.dispose();
            }
        });
        resetButton.addActionListener(e -> {
            nameTextField.setText("");
            passwordTextField.setText("");
        });

        // 如果文本框有文字输入移除错误提示
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!nameTextField.getText().isEmpty()) {
                    errorLabel.setText("");
                }
            }
        });

        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!passwordTextField.getText().isEmpty()) {
                    errorLabel.setText("");
                }
            }
        });

        confirmPasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!confirmPasswordTextField.getText().isEmpty()) {
                    errorLabel.setText("");
                }
            }
        });
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }
}
