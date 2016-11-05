package Arknoid;

import javax.swing.ImageIcon;

public class Brick1 extends Sprite{
    private int type = -1;
    private boolean destroyed = false;
    private int hit0 = 1;
    private int hit1 = 1;

    public Brick1(int x, int y,int type) {
        this.x = x;
        this.y = y;

        if (type == 1){
            ImageIcon ii = new ImageIcon("brick.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            this.type = type;
            destroyed = false;
        }else if (type == 0){
            ImageIcon ii = new ImageIcon("brick1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            this.type = type;
            destroyed = false;
        }

    }


    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed( ) {
        if (type == 0) {
            hit0--;
            if (hit0 <= 0)
                destroyed = true;
        }else if (type == 1){
            hit1--;
            if (hit1 <= 0)
                destroyed = true;
        }
    }
}
