/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jfernandojb
 */
public class Panel extends JPanel{
    ImageIcon imagen;
    String nombre;
    public Panel(String nombre){
        this.nombre=nombre;
    }
    public void paint(Graphics g){
        Dimension tamanio=getSize();
        imagen=new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(), 0,0, tamanio.width,tamanio.height,null);
        setOpaque(false);
        super.paint(g);
    }
}
