package Arknoid;

import javax.swing.*;

/**
 * Created by 123 on 16/11/2559.
 */

//
public class Item extends Sprite implements Commons {
    private int xdir;
    private int ydir;
    private int type;
    private boolean isItem;

    public Item(){
        isItem = false;
    }

    public Item(int type){
        setType(type);
        isItem = true;
    }

    public boolean isItem() {
        return isItem;
    }

    public void setisItem() {
        this.isItem = false;
    }

    public void move(){
        if (y == 0) {
            x = xdir;
            y = ydir;
        }
        y += 1;
    }

    public void  itemType(int type){

        if (type == 0)
            return;

        xdir = x;
        ydir = y;

        if (type == 1){
            ImageIcon ii = new ImageIcon("picture/item1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
        }else if (type == 2){
            ImageIcon ii = new ImageIcon("picture/ball1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
        }else if (type == 3){
            ImageIcon ii = new ImageIcon("picture/ball.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
        }else if (type == 4) {
            ImageIcon ii = new ImageIcon("picture/item2.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
        }else if (type == 5) {
            ImageIcon ii = new ImageIcon("paddle.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
        }
        state();
        isItem = true;
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

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return  type;
    }

    private void state(){
        x = 0;
        y = 0;
    }
}
