package vista;

import javax.swing.*;
import java.awt.*;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estilos {

    public static final int ESTILO_SISTEMA = 0;
    public static final int ESTILO_GTK = 1;
    public static final int ESTILO_NIMBUS = 2;
    public static final int ESTILO_NIMROD = 3;
    public static final int ESTILO_AQUA=4;
    private static Estilos estilo;
    public JFrame vtn;

    private Estilos() {
    }

    public synchronized static Estilos getInstance() {
        if (estilo == null) {
            estilo = new Estilos();
        }
        return estilo;
    }

    private void aplicaEstiloSistema() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void aplicaEstiloGtk() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    private void aplicaEstiloAqua (){
        try {
            UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Estilos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void aplicaEstiloNimbus() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void aplicaEstiloNimrod() {
        try {
            NimRODTheme nt = new NimRODTheme();
            nt.setPrimary1(new Color(0x001FEB));
            nt.setPrimary2(new Color(0x0029F5));
            nt.setPrimary3(new Color(0x0033FF));
            nt.setSecondary1(new Color(0xB8EBEB));
            nt.setSecondary2(new Color(0xC2F5F5));
            nt.setSecondary3(new Color(0xCCFFFF));
            nt.setWhite(new Color(0xFFFFFF));
            nt.setBlack(new Color(0x000000));
            nt.setMenuOpacity(195);
            nt.setOpacity(180);
            nt.setFrameOpacity(0);
            NimRODLookAndFeel nlf = new NimRODLookAndFeel();
              
            NimRODLookAndFeel.setCurrentTheme(nt);
            UIManager.setLookAndFeel(nlf);
           System.out.println("llegas");
//           SwingUtilities.updateComponentTreeUI(vtn);
             
        } catch (UnsupportedLookAndFeelException ex) {
                   System.err.println(ex.getMessage());
        }
    }

    /*Este método se usa en caso de que se use el estilo Nimrod*/
    public void setFrame(JFrame vtn) {
      
        
        this.vtn = vtn;
    }

    public void aplicarEstilo(int tipoEstilo) {
        switch (tipoEstilo) {
            case ESTILO_SISTEMA:
                aplicaEstiloSistema();
                break;
            case ESTILO_GTK:
                aplicaEstiloGtk();
                break;
            case ESTILO_NIMBUS:
                aplicaEstiloNimbus();
                break;            
            
            
            case ESTILO_NIMROD:
                aplicaEstiloNimrod();
                break;
        case ESTILO_AQUA:
                    aplicaEstiloAqua();
            break;
            default:
        }
    }
}
