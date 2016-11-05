package Arknoid;

import javax.swing.ImageIcon;

public class Ball extends Sprite implements Commons{
    private int xdir;
    private int ydir;
    private int number;


    public Ball() {
        xdir = (( (int)Math.random() * 3)+1 >= 2) ? 1:-1;
        ydir = (( (int)Math.random() * 3)+1 >= 2) ? 1:-1;;
        this.number =1 ;

        ImageIcon ii = new ImageIcon("picture/ball.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();
    }

    /*public void newBall(){
        Ball ball = new Ball();
        xdir = 1;
        ydir = -1;
        number++;

        ImageIcon ii = new ImageIcon("ball.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();

    }*/

    public void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {
            setXDir(1);
        }

       if (x == WIDTH - i_width) {
            setXDir(-1);
        }

        if (y == 0) {
            setYDir(1);
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

    public  boolean isNumZero(){
        if (number <= 0) return  true;
        else  return  false;
    }

}

