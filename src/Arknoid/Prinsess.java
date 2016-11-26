package Arknoid;

import javax.swing.*;

/**
 * Created by dell on 27/11/2559.
 */
public class Prinsess extends Item {
    private boolean princess;

    public Prinsess(){
        x = 350;
        y = 200;
        ImageIcon ii = new ImageIcon("princess.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        princess = true;
    }

    public void setPrinsess(boolean y){
        princess = y;
    }

    public boolean getPrinsess(){
        return princess;
    }

}
