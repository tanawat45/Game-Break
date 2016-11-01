package Arknoid;

import javax.swing.*;
import java.awt.*;

public class Akanoid extends JFrame{
    private Akanoid() {
        initUI();
    }

    private void initUI() {

        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);  //end rum to closes flrame
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true); // show frame
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Akanoid game = new Akanoid();
                game.setVisible(true);

            }
        });
    }
}
