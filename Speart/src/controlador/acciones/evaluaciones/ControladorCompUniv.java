/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import java.awt.Component;
import modelo.operaciones.CompetenciaUniversal;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlCompUniv;
import vista.paneles.evaluacion.PnlEvaluacion;

/**
 *
 * @author francisco
 */
public class ControladorCompUniv {

    private PnlCompUniv pcu;
    public static PnlEvaluacion pe;
    public static double totalCompUniv = 0;

    public ControladorCompUniv(PnlCompUniv pcu) {
        this.pcu = pcu;
    }

    public void frecuenciaAplic(int n, CompetenciaUniversal cu) {
        if (n == 0) {
            pcu.getTxtCompObserv().setText(cu.getAltaUniv());
        } else if (n == 1) {
            pcu.getTxtCompObserv().setText(cu.getMediaUniv());
        } else if (n == 2) {
            pcu.getTxtCompObserv().setText(cu.getBajaUniv());
        }
    }
    public void actualizaResCompUniv(){
        sumatoriaUniversales();
    }

    public static void sumatoriaUniversales() {
        totalCompUniv = 0;
        for (Component c : pe.getPnlDatosCompUnivers().getComponents()) {
            if (c.getClass().equals(PnlCompUniv.class)) {
                PnlCompUniv pct = (PnlCompUniv) c;
                totalCompUniv += califCompUniv(pct.getCbFrecuenciaAplic().getSelectedIndex());
                System.out.println(pct.getTxtCompUniv().getText() + "  " + califCompUniv(pct.getCbFrecuenciaAplic().getSelectedIndex()));
            }
        }
        ControladorEvaluacion.totCompUniv=totalCompUniv;
        totalCompUniv = OperacionesVarias.redondeaDosCifras(totalCompUniv);
        pe.getTxtTotalCompUniv().setText(totalCompUniv + "");
    }

    public static double califCompUniv(int index) {
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
        return (a * ControladorEvaluacion.facCompUniv) / 5;
    }
}
