/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.experto.BaseConocimiento;
import java.awt.Component;
import modelo.operaciones.CompetenciaTecnica;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.PnlCompTecn;
import vista.paneles.evaluacion.PnlEvaluacion;

/**
 *
 * @author
 */
public class ControladorCompTecn {

    private PnlCompTecn pct;
    public static PnlEvaluacion pe;
    public static double totalCompTec = 0;
    private ClassLoader cload = ControladorCompTecn.class.getClassLoader();//para hacer referencia a archivos dentro del programa
    private String dirArchivo = cload.getResource("controlador/experto/evaluacion.pl").getPath();

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
        poneRespuesta();
    }

    public static void sumatoriaTecnicas() {
        totalCompTec = 0;
        for (Component c : pe.getPnlDatosComp().getComponents()) {
            if (c.getClass().equals(PnlCompTecn.class)) {
                PnlCompTecn pct = (PnlCompTecn) c;
                totalCompTec += califCompTec(pct.getCbNivelDesarr().getSelectedIndex());
                System.out.println(pct.getTxtCompTec().getText() + " aqui puede ser " + califCompTec(pct.getCbNivelDesarr().getSelectedIndex()));
            }
        }
        ControladorEvaluacion.totCompTec = totalCompTec;
        totalCompTec = OperacionesVarias.redondeaDosCifras(totalCompTec);
    }

    private void poneRespuesta() {
        double porcen = calculaPorcentaje(totalCompTec);
        double r = OperacionesVarias.redondeaDosCifras((porcen * ControladorEvaluacion.facCompTec) / 100);
        pe.getTxtTotalCompTec().setText(r + "% - " + rptaTexto(porcen));
        ControladorEvaluacion.totCompTec = r;
       
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

    private double calculaPorcentaje(double totalObt) {
        double factor = ControladorEvaluacion.facCompTec * ControladorEvaluacion.compTecnicas.size();//factor asignado por el estado
        double porcen = (totalObt * 100) / factor;
        return OperacionesVarias.redondeaDosCifras(porcen);
    }

    private String rptaTexto(double porcen) {
        String s;
        BaseConocimiento bc = new BaseConocimiento();
        if (bc.compilaArchivo(dirArchivo)) {
            return bc.consultaSegundoElemento("esrespuestact(" + porcen + ",X)");
        }
        return null;
    }
}
//8        100
//totcal  x
