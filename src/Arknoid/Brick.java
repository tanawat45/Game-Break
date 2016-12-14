package Arknoid;

import javax.swing.ImageIcon;

public class Brick extends Sprite{
    private int type = -1;
    private boolean destroyed = false;
    private int hit;


    public Brick(int x, int y,int type) {
        this.x = x;
        this.y = y;

        if (type == 0){
            this.type = type;
            hit = 1;
            ImageIcon ii = new ImageIcon("brick1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 1){
            this.type = type;

            ImageIcon ii = new ImageIcon("brick2.png");
            image = ii.getImage();
            hit = 1;
            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 2){
            this.type = type;

            ImageIcon ii = new ImageIcon("brick3.png");
            image = ii.getImage();
            hit = 2;
            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 3){
            this.type = type;
            hit = 4;
            ImageIcon ii = new ImageIcon("brick4.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 4){
            this.type = type;
            hit = 2;
            ImageIcon ii = new ImageIcon("brick9.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 5){
            this.type = type;
            hit = 8;
            ImageIcon ii = new ImageIcon("brick11.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 7){
            this.type = type;
            hit = 6;
            ImageIcon ii = new ImageIcon("brick5.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = true;
        }else if (type == 6){
            this.type = type;
            hit = 6;
            ImageIcon ii = new ImageIcon("brick7.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }/*else if (type == 8){
            this.type = type;
            hit = 5;
            ImageIcon ii = new ImageIcon("brick11.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }else if (type == 8){
            this.type = type;
            hit = 1;
            ImageIcon ii = new ImageIcon("brick1.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = true;
        }*/
    }

    public void  changState(){
        if (type == 5) {
            if (hit < 5) {
                ImageIcon ii = new ImageIcon("brick11.1.png");
                image = ii.getImage();

                i_width = image.getWidth(null);
                i_heigth = image.getHeight(null);
            }
        }else if (type == 3){
            if (hit < 3) {
                ImageIcon ii = new ImageIcon("brick4.1.png");
                image = ii.getImage();

                i_width = image.getWidth(null);
                i_heigth = image.getHeight(null);
            }
        }else if (type == 6){
            if (hit < 2) {
                ImageIcon ii = new ImageIcon("brick7.1.png");
                image = ii.getImage();

                i_width = image.getWidth(null);
                i_heigth = image.getHeight(null);
            }
        }
    }


    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed() {
        hit--;
        if (hit <= 0){
            destroyed = true;
        }changState();
    }
    public void setBoss(){
        destroyed = false;
    }
    public void reIsDestroyed(int type){
        if (type == 0 || type == 1 || type == 2){
            hit = 1;
        }else if (type == 3){
            hit = 4;
        }else if (type == 4){
            hit = 2;
        }else if (type == 5){
            hit = 8;
        }else if (type == 6 || type == 7){
            hit = 6;
        }else if (type == 8){
            hit = 5;
        }
        destroyed = false;
    }

    public void overDestroyed(){
        destroyed = true;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
