package Arknoid;

import javax.swing.*;

/**
 * Created by dell on 26/11/2559.
 */
public class Boss extends Item {
    private boolean boss;
    private int hp;
    private int atkboss;
    private int dx,moveState;
    public Boss(){
        hp = 100000;
        x = 600;
        y = 00;
        ImageIcon ii = new ImageIcon("angry.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        boss = false;
    }

    public void setBoss(boolean y){
        boss = y;
    }

    public boolean getBoss(){
        return boss;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return hp;
    }

    public int getAtkboss(){
        return atkboss;
    }


    public void setAtkboss(int s){
        atkboss = s;
    }

    public void move(){
        if (moveState == 1 )
            x += 1;
        else
            x -= 1;

        if (x <= 0) {
            x=0;
            moveState = 1;
        }

        if (x >= WIDTH - i_width) {
            x = WIDTH - i_width;
            moveState = 0;
        }
    }

    public void setMoveState(int state){
        moveState = state;
        if (moveState > 1 ) moveState = 1;
        else moveState = 0;
    }

    public int getMoveState(){
        return moveState;
    }
}
