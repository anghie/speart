/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.experto.BaseConocimiento;
import java.awt.Component;
import modelo.operaciones.CompetenciaUniversal;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlCompUniv;
import vista.paneles.evaluacion.PnlEvaluacion;

/**
 *
 * @author
 */
public class ControladorCompUniv {

    private PnlCompUniv pcu;
    public static PnlEvaluacion pe;
    public static double totalCompUniv = 0;
    private ClassLoader cload = ControladorCompUniv.class.getClassLoader();//para hacer referencia a archivos dentro del programa
    private String dirArchivo = cload.getResource("controlador/experto/evaluacion.pl").getPath();

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

    public void actualizaResCompUniv() {
        sumatoriaUniversales();
        poneRespuesta();
    }

    public static void sumatoriaUniversales() {
        totalCompUniv = 0;
        for (Component c : pe.getPnlDatosCompUnivers().getComponents()) {
            if (c.getClass().equals(PnlCompUniv.class)) {
                PnlCompUniv pct = (PnlCompUniv) c;
                totalCompUniv += califCompUniv(pct.getCbFrecuenciaAplic().getSelectedIndex());
                System.out.println(pct.getTxtCompUniv().getText() + " aquiiiiiiiii  " + califCompUniv(pct.getCbFrecuenciaAplic().getSelectedIndex()));
            }
        }
        ControladorEvaluacion.totCompUniv = totalCompUniv;
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
            a = 0;
        }
        return (a * ControladorEvaluacion.facCompUniv) / 5;
    }

    private void poneRespuesta() {
        double porcen = calculaPorcentaje(totalCompUniv);
        double r = OperacionesVarias.redondeaDosCifras((porcen * ControladorEvaluacion.facCompUniv) / 100);
        pe.getTxtTotalCompUniv().setText(r + "% - " + rptaTexto(porcen));
        ControladorEvaluacion.totCompUniv = r;
    }

    private double calculaPorcentaje(double totalObt) {
        double factor = ControladorEvaluacion.facCompUniv * ControladorEvaluacion.compUniversales.size();//factor asignado por el estado
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
