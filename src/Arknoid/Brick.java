package Arknoid;

import javax.swing.ImageIcon;

public class Brick extends Sprite{
    private int type = -1;
    private boolean destroyed = false;
    private int hit0 = 1;
    private int hit1 = 1;
    private int hit2 = 1;
    private int hit3 = 1;

    public Brick(int x, int y,int type) {
        this.x = x;
        this.y = y;

        if (type == 0){
            this.type = type;

            ImageIcon ii = new ImageIcon("brick.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 1){
            this.type = type;

            ImageIcon ii = new ImageIcon("brick1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 2){
            this.type = type;

            ImageIcon ii = new ImageIcon("brick2.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 3){
            this.type = type;

            ImageIcon ii = new ImageIcon("brick3.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }

    }


    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        if (type == 0) {
            hit0--;
            if (hit0 <= 0)
                 destroyed = true;
        }else if (type == 1){
            hit1--;
            if (hit1 <= 0)
                destroyed = true;
        }else if (type == 2){
            hit2--;
            if (hit2 <= 0)
                destroyed = true;
        }else if (type == 3){
            hit3--;
            if (hit3 <= 0)
                destroyed = true;
        }
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }


}
