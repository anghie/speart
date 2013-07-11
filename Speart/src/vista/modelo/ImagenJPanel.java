package vista.modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenJPanel extends JPanel {

    String imagen = "";

    public ImagenJPanel() {
    }

    public ImagenJPanel(String nombreImagen) {
        imagen = nombreImagen;
    }

    public void cambiarImagen(String nombreImagen) {
        imagen = nombreImagen;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Dimension d = this.getSize();
		ClassLoader cl = ImagenJPanel.class.getClassLoader();       
        g.drawImage(new ImageIcon(cl.getResource("vista/imagenes/" + imagen)).getImage(), 0, 0, d.width, d.height, null);
        setOpaque(false);
        super.paint(g);
    }
}
