/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.propiedades.Propiedades;
import java.awt.Component;
import java.util.Properties;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlEvaluacion;
import vista.paneles.evaluacion.PnlQuejas;

/**
 *
 * @author
 */
public class ControladorQuejas {
    
    private PnlQuejas pq;
    public static PnlEvaluacion pe;
    public static double totalQuejas = 0;
    
    public ControladorQuejas(PnlQuejas p) {
        p = pq;
    }
    
    public static void sumatoriaQuejas() {
        totalQuejas = 0;
        for (Component c : pe.getPnlDatosQuejas().getComponents()) {
            if (c.getClass().equals(PnlQuejas.class)) {
                if (totalQuejas < 24) {
                    PnlQuejas pct = (PnlQuejas) c;
                    totalQuejas += calificaQuejas();
                }
            }
        }
        
        totalQuejas = OperacionesVarias.redondeaDosCifras(totalQuejas);
        ControladorEvaluacion.totQuejas = totalQuejas;
        pe.getTxtTotalQuejas().setText(ControladorEvaluacion.totQuejas + "%");
    }
    
    public static int calificaQuejas() {
        int n = 0;
        Propiedades prop = new Propiedades();        
        Properties p = prop.getProperties("controlador/propiedades/factores.properties");
        n = Integer.parseInt(p.getProperty("APLICA"));
        return n;
    }
}
