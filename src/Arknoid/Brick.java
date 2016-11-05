package Arknoid;

import javax.swing.ImageIcon;

public class Brick extends Sprite{
    private boolean destroyed;
    private int type;
    private int hit;

    public Brick(int x, int y, int type) {

        this.x = x;
        this.y = y;

        if (type == 0){
            ImageIcon ii = new ImageIcon("brick0.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
            hit = 1;
        }else if (type == 1){
            ImageIcon ii = new ImageIcon("brick1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);
            setType(type);
            hit = 2;
        }


        destroyed = false;
    }

    public boolean isDestroyed() {

        return destroyed;
    }

    public void setDestroyed() {
        hit--;
        if (type == 0){
            if (hit == 0)
                destroyed = true;
        }else if (type == 1){
            if (hit == 0)
                destroyed = true;
        }
    }

    public void  setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}

