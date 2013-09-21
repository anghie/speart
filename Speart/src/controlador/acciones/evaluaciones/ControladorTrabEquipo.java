/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import java.awt.Component;
import modelo.operaciones.TrabajoEquipo;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlEvaluacion;
import vista.paneles.evaluacion.PnlTrabEquipo;

/**
 *
 * @author jenny
 */
public class ControladorTrabEquipo {

    private PnlTrabEquipo pte;
    public static PnlEvaluacion pe;
    public static double totalTrabEquip = 0;

    public ControladorTrabEquipo(PnlTrabEquipo pte) {
        this.pte = pte;
    }

    public void frecuenciaAplic(int n, TrabajoEquipo te) {
        if (n == 0) {
            pte.getTxtComObserv().setText(te.getAltaTrabEquipo());
        } else if (n == 1) {
            pte.getTxtComObserv().setText(te.getMediaTrabEquipo());
        } else if (n == 2) {
            pte.getTxtComObserv().setText(te.getBajaTrabEquipo());
        }
    }
    
    public void actualizaResTrabEquip(){
        sumatoriaTrabEquip();
    }

    public static void sumatoriaTrabEquip() {
        totalTrabEquip = 0;
        for (Component c : pe.getPnlDatosTrabEquipo().getComponents()) {
            if (c.getClass().equals(PnlTrabEquipo.class)) {
                PnlTrabEquipo pct = (PnlTrabEquipo) c;
                totalTrabEquip += califTrabEquipo(pct.getCbFrecAplic().getSelectedIndex());
                System.out.println(pct.getTxtTrabEquip().getText() + "  " + califTrabEquipo(pct.getCbFrecAplic().getSelectedIndex()));
            }
        }
        ControladorEvaluacion.totTrabEquip = totalTrabEquip;
        totalTrabEquip = OperacionesVarias.redondeaDosCifras(totalTrabEquip);
        pe.getTxtTotalTrabEquip().setText(totalTrabEquip + "");
    }

    public static double califTrabEquipo(int index) {
        double a = 0;
        if (index == 0) {
            a = 5;
        } else if (index == 1) {
            a = 4;
        } else if (index == 2) {
            a = 3;
        } else if (index == 3) {
            a = 2;
        } else if (index == 4) {
            a = 1;
        }
        return (a * ControladorEvaluacion.facTrabEquip) / 5;
    }
}
