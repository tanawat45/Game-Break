package Arknoid;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class BackgroundPanel extends Item {
    private boolean isBackground;
    private int dx;

    public BackgroundPanel() {
        isBackground = false;
    }

    public BackgroundPanel(int state) {
        if (state == 0) {
            ImageIcon ii = new ImageIcon("background.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        } else if (state == 5) {
            ImageIcon ii = new ImageIcon("Backgroundbegin1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        } else if (state == 6) {
            ImageIcon ii = new ImageIcon("backgroundend.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        }else if (state == 1) {
            ImageIcon ii = new ImageIcon("backgroundcastle1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        } else if (state == 2) {
            ImageIcon ii = new ImageIcon("background1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        } else if (state == 3) {
            ImageIcon ii = new ImageIcon("background2.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        } else if (state == 4) {
            ImageIcon ii = new ImageIcon("background5.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        }
        isBackground = true;

    }

    public boolean getIsBackground() {
        return isBackground;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

    }
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}


