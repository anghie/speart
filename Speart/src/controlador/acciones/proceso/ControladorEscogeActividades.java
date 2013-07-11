/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.proceso;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import modelo.proceso.Actividad;

/**
 *
 * @author 
 */
public class ControladorEscogeActividades {
   
    public static ArrayList<Actividad> actividadesDisponibles;
    public static ArrayList<Actividad> actividadesAsignadas;
    public static JList lstDisp;
    public static JList lstAsig;

    public static void llenaListaDisponibles() {
        DefaultListModel dlm = new DefaultListModel();
        lstDisp.removeAll();
        if (!actividadesDisponibles.isEmpty()) {
            dlm.removeAllElements();
            for (Actividad a : actividadesDisponibles) {
                dlm.addElement(a.getDescripcion());
            }
        }
        lstDisp.setModel(dlm);
    }

    public static void llenaListaAsignadas() {
        DefaultListModel dlm = new DefaultListModel();
        lstAsig.removeAll();
        if (!actividadesAsignadas.isEmpty()) {
            dlm.removeAllElements();
            for (Actividad act : actividadesAsignadas) {
                dlm.addElement(act.getDescripcion());
            }
        }
        lstAsig.setModel(dlm);
    }

    /**
     * Metodo que agrega una actividad a la lista de actividades asignadas
     *
     * @param a La actividad a ser asignada
     */
    public static void agregaItemAsignadas(Actividad a) {
        actividadesAsignadas.add(a);
        actividadesDisponibles.remove(a);
        llenaListaDisponibles();
        llenaListaAsignadas();
    }

    /**
     * Metodo que quita una actividad de la lista de actividades asignadas
     *
     * @param a La actividad a ser quitada
     */
    public static void quitaItemAsignadas(Actividad a) {
        actividadesAsignadas.remove(a);
        actividadesDisponibles.add(a);
        llenaListaAsignadas();
        llenaListaDisponibles();
    }
    
}
