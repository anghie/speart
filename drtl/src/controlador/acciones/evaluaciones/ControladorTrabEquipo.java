/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.experto.BaseConocimiento;
import java.awt.Component;
import modelo.operaciones.TrabajoEquipo;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlEvaluacion;
import vista.paneles.evaluacion.PnlTrabEquipo;

/**
 *
 * @author
 */
public class ControladorTrabEquipo {

    private PnlTrabEquipo pte;
    public static PnlEvaluacion pe;
    public static double totalTrabEquip = 0;
    private ClassLoader cload = ControladorTrabEquipo.class.getClassLoader();//para hacer referencia a archivos dentro del programa
    private String dirArchivo = cload.getResource("controlador/experto/evaluacion.pl").getPath();

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

    public void actualizaResTrabEquip() {
        sumatoriaTrabEquip();
        poneRespuesta();
    }

    public static void sumatoriaTrabEquip() {
        totalTrabEquip = 0;
        for (Component c : pe.getPnlDatosTrabEquipo().getComponents()) {
            if (c.getClass().equals(PnlTrabEquipo.class)) {
                PnlTrabEquipo pct = (PnlTrabEquipo) c;
                totalTrabEquip += califTrabEquipo(pct.getCbFrecAplic().getSelectedIndex());
//                System.out.println(pct.getTxtTrabEquip().getText() + "  " + califTrabEquipo(pct.getCbFrecAplic().getSelectedIndex()));
            }
        }
        ControladorEvaluacion.totTrabEquip = totalTrabEquip;
        totalTrabEquip = OperacionesVarias.redondeaDosCifras(totalTrabEquip);
//        double p = OperacionesVarias.redondeaDosCifras((totalTrabEquip*100)/ControladorEvaluacion.facTrabEquip);
//        pe.getTxtTotalTrabEquip().setText(p + "%");
    }

    private void poneRespuesta() {
        double porcen = calculaPorcentaje(totalTrabEquip);
        double r = OperacionesVarias.redondeaDosCifras((porcen * ControladorEvaluacion.facTrabEquip) / 100);
        pe.getTxtTotalTrabEquip().setText(r + "% - " + rptaTexto(porcen));
        ControladorEvaluacion.totTrabEquip = r;
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
            a = 0;
        }
        return (a * ControladorEvaluacion.facTrabEquip) / 5;
    }

    private double calculaPorcentaje(double totalObt) {
        double factor = ControladorEvaluacion.facTrabEquip * ControladorEvaluacion.trabequip.size();//factor asignado por el estado
        double porcen = (totalObt * 100) / factor;
        return OperacionesVarias.redondeaDosCifras(porcen);
    }

    private String rptaTexto(double porcen) {
        BaseConocimiento bc = new BaseConocimiento();
        if (bc.compilaArchivo(dirArchivo)) {
            return bc.consultaSegundoElemento("esrespuestacu(" + porcen + ",X)");
        }
        return null;
    }
}
