package Arknoid;

import javax.swing.ImageIcon;

public class Brick1 extends Sprite{
        private boolean destroyed;
        private int hit = 1;
        public Brick1(int x, int y) {
            this.x = x;
            this.y = y;
            ImageIcon ii = new ImageIcon("brick4.png");
            image = ii.getImage();

            i_width = image.getWidth(null);
            i_heigth = image.getHeight(null);

            destroyed = false;
        }

        public boolean isDestroyed() {

            return destroyed;
        }

        public void setDestroyed() {
            hit--;
            if (hit <=0){
                destroyed = true;
            }
        }
    }

