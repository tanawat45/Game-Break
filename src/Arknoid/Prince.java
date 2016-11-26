package Arknoid;

import javax.swing.*;

/**
 * Created by dell on 27/11/2559.
 */
public class Prince extends Item{
    private boolean princess;

    public Prince(){
        x = 200;
        y = 210;
        ImageIcon ii = new ImageIcon("prince.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        princess = true;
    }

    public void setPrince(boolean y){
        princess = y;
    }

    public boolean getPrince(){
        return princess;
    }
}
