package Arknoid;

import javax.swing.*;

/**
 * Created by dell on 26/11/2559.
 */
public class wizard extends  Item {
    private boolean wizard;

    public  wizard(){

        x = 10 ;
        y = 480;
        ImageIcon ii = new ImageIcon("wizard2.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        wizard = true;
    }

    public void setWizard(boolean y){
        wizard = y;
    }

    public boolean getWizard(){
        return wizard;
    }

}
