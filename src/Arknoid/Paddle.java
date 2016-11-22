package Arknoid;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Paddle extends Sprite implements Commons{
    private int dx;
    private int type = 0;
    private int state = 0 ;
    private int moveState ;
    private int moveSpeed ;
    ImageIcon ii;

    public Paddle() {
        ii = new ImageIcon("paddle1.png");
        image = ii.getImage();
        state = 1;
        moveState = 1;
        moveSpeed = 3;
        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();
    }

    public Paddle(int type) {
        this.type = type;
    }

    public void move() {
        if (moveState == 1 )
            x += dx;
        else
            x -= dx;

        if (x <= 0) {
            x = 0;
        }

        if (x >= WIDTH - i_width) {
            x = WIDTH - i_width;
        }
    }


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -moveSpeed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = moveSpeed;
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

    private void resetState() {

        x = INIT_PADDLE_X;
        y = INIT_PADDLE_Y;
    }

    public void setItem(){
        setLongPaddle();
    }

    public void setLongPaddle(){
        if (state == 1){
            ii = new ImageIcon("paddle1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        }else if (state ==2 ){
            ii = new ImageIcon("paddle2.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        }else if (state == 3){
            ii = new ImageIcon("paddle3.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        }else if (state == 4){
            ii = new ImageIcon("paddle4.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
        }

    }

    public  void  setState(int state){
        this.state = state;
        System.out.println("state                              " + state);
        if (this.state >= 4) this.state = 4;
        if (this.state <= 1) this.state = 1;
    }

    public int getState(){
        return this.state;
    }


    public  void  setType(int type){ this.type = type;}

    public int getType(){
        return this.type;
    }

    public void setMoveState(int state){
        moveState = state;
        if (moveState > 2 ) moveState = 1;
    }

    public int getMoveState(){
        return moveState;
    }

    public void setMoveSpeed(int state){
        moveSpeed = state;
        if (moveSpeed > 7) moveSpeed = 7;
        else  if(moveSpeed < 1) moveSpeed = 1;

    }

    public int getMoveSpeed(){
        return  moveSpeed;
    }

}

