/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import java.awt.Component;
import modelo.operaciones.CompetenciaTecnica;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlCompTecn;
import vista.paneles.evaluacion.PnlEvaluacion;

/**
 *
 * @author francisco
 */
public class ControladorCompTecn {

    private PnlCompTecn pct;
    public static PnlEvaluacion pe;
    public static double totalCompTec=0;

    public ControladorCompTecn(PnlCompTecn pct) {
        this.pct = pct;
//        ControladorEvaluacion.totCompTec = 0;
    }

    public void comportaObservTec(int n, CompetenciaTecnica ct) {
        if (n == 0) {
            pct.getTxtCompObserv().setText(ct.getAltaTec());
        } else if (n == 1) {
            pct.getTxtCompObserv().setText(ct.getMediaTec());
        } else if (n == 2) {
            pct.getTxtCompObserv().setText(ct.getBajaTec());
        }
    }

    //0. Altamente Desarrollada 5
    //1. Desarrollada 4
    //2. Medianamente Desarrollada 3
    //3. Poco Desarrollada 2
    //4. No Desarrollada 1
    public void actualizaResCompTec() {
        sumatoriaTecnicas();
    }

    public static void sumatoriaTecnicas() {
        totalCompTec=0;
        for (Component c : pe.getPnlDatosComp().getComponents()) {
            if (c.getClass().equals(PnlCompTecn.class)) {
                PnlCompTecn pct = (PnlCompTecn) c;
                totalCompTec+=califCompTec(pct.getCbNivelDesarr().getSelectedIndex());
                System.out.println(pct.getTxtCompTec().getText() + "  " + califCompTec(pct.getCbNivelDesarr().getSelectedIndex()));
            }
        }
        ControladorEvaluacion.totCompTec=totalCompTec;
        totalCompTec= OperacionesVarias.redondeaDosCifras(totalCompTec);
        pe.getTxtTotalCompTec().setText(totalCompTec+"");
    }

    public static double califCompTec(int index) {
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
        return (a * ControladorEvaluacion.facCompTec) / 5;
    }
}
//8        100
//totcal  x
