package view.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Box extends JComponent {
    private final int value = 10;
    private boolean atTarget = false;
    private boolean atCorner = false;

    public boolean isAtTarget() {
        return atTarget;
    }

    public void setAtTarget(boolean atTarget) {
        this.atTarget = atTarget;
    }

    public Box(int width, int height) {
        this.setSize(width, height);
        this.setLocation(5, 5);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, getWidth(), getHeight());
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(border);
    }

    public int getValue() {
        return value;
    }

    public void checkTarget(int i) {
        if (i==12){
            this.setAtTarget(true);

        } else {
            this.setAtTarget(false);
        }
    }
}
