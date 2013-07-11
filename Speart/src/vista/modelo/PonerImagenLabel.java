/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jenny
 */
public class PonerImagenLabel {
    
    public static ImageIcon loadImage(Image imagen) {
        ImageIcon tmpIconAux = new ImageIcon(imagen);
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(150, -1, Image.SCALE_DEFAULT));
        return tmpIcon;
    }
}
