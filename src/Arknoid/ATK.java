package Arknoid;

import javax.swing.*;

/**
 * Created by 123 on 19/11/2559.
 */
public class ATK extends Item implements Commons{
    private int type;
    private int xdir;
    private int ydir;
    private boolean isAtk;

    public ATK(){
        type = -1;
        isAtk = false;
    }

    public ATK(int type) {
        if (type == 0)
            return;

        xdir = x;
        ydir = y;

        if (type == 2) {
            ImageIcon ii = new ImageIcon("brick.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
            isAtk = true;
        }/*else if (type == 2){
            ImageIcon ii = new ImageIcon("brick1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
            isAtk = true;
        }*/
    }




    public boolean getIsAtk(){
        return isAtk;
    }

    public void setIsAtk(){
        isAtk = false;
    }


}
