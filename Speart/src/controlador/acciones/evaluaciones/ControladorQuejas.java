/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import java.awt.Component;
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
                    totalQuejas+=calificaQuejas(pct);
                }
            }
        }
        ControladorEvaluacion.totQuejas = totalQuejas;
        totalQuejas = OperacionesVarias.redondeaDosCifras(totalQuejas);
        pe.getTxtTotalQuejas().setText(totalQuejas + "%");
    }

    public static int calificaQuejas(PnlQuejas p) {
        int n = 0;
        if (p.getTxtPorcentaje().getText().equals("4%")) {
            n = 4;
        }
        return n;
    }
}
