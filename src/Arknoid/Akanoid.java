package Arknoid;

import javax.swing.*;
import java.awt.*;

public class Akanoid extends JFrame{
    protected Akanoid() {
        initUI();
    }

    private void initUI() {

        add(new Board());
        setTitle("Arkanoid Game");

        setDefaultCloseOperation(EXIT_ON_CLOSE); //end rum to closes flrame
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);// show frame

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //JOptionPane.showMessageDialog(null, "  Press Enter To Start Game");
                //JOptionPane.showMessageDialog(null, "  Stage 1");
                Akanoid game = new Akanoid();
                game.setVisible(true);
            }
        });
    }
}
