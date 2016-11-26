package Arknoid;

import javax.swing.*;

public class Ball extends Sprite implements Commons{
    private int xdir;
    private int ydir;
    private boolean isBall;
    private int numball;

    public Ball() {
        numball = 0;
        x = xdir;
        ydir = -1;
        ImageIcon ii = new ImageIcon("ball5.png");

        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        isBall = true;
        y = INIT_BALL_Y;
        isBall = true;
    }

    public Ball(int number) {

        if (number == 0)
            return;

        x = xdir;
        ydir = -1;

        numball = number;

        ImageIcon ii = new ImageIcon("ball5.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        y = INIT_BALL_Y;

        if (number == 500) {
            ii = new ImageIcon("ball6.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            y = INIT_BALL_Y;
            isBall = false;
        }
        else isBall = true;
    }

    public void move() {

        x += xdir;
        y += ydir;

        if (x <= 0) {
            setXDir(1);
        }

        if (x >= WIDTH - i_width) {
            setXDir(-1);
        }

        if (y <= 0) {
            setYDir(1);
            setXDir(-1);
        }
    }

    private void resetState() {

        x = INIT_BALL_X;
        y = INIT_BALL_Y;
    }

    public void setXDir(int x) {
        xdir = x;
    }

    public void setYDir(int y) {
        ydir = y;
    }

    public int getYDir() {
        return ydir;
    }

    public int getXDir() {
        return xdir;
    }

    public void setIsBall(boolean ball){
        isBall = ball;
    }

    public boolean getIsBall(){
        return isBall;
    }

    public int getNumber(){
        return  numball;
    }

}


