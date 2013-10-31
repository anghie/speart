/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.basedatos.OperacionesBD;
import controlador.experto.BaseConocimiento;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.evaluacion.ResultadoConocimientos;
import modelo.evaluacion.ResultadoFinalConocimiento;
import modelo.pregunta.Pregunta;
import modelo.pregunta.Respuesta;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.FrmTests;
import vista.paneles.evaluacion.PnlRespuesta;
import vista.paneles.evaluacion.PnlTexto;

/**
 *
 * @author
 */
public class ControladorTest {

    private FrmTests ft;
    private int c, n;//c contador de numero de preguntas
    private CardLayout cl;
    private ArrayList<JPanel> contenedores;
    private ArrayList<JPanel> panelesPregRpta;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<Respuesta> respuestasCompletas;
    private ArrayList<ResultadoConocimientos> resultadoPreguntas;
//    private Seccion s;
    private ClassLoader cload = ControladorTest.class.getClassLoader();//para hacer referencia a archivos dentro del programa
    private String dirArchivo = cload.getResource("controlador/experto/evaluacion.pl").getPath();

    public ControladorTest(FrmTests ft) {
        this.ft = ft;
        ft.getBtnCalificar().setEnabled(false);
//        ControladorEvaluacion.totConoc = 0;
    }

    public void llenaPaneles() {
        c = panelesPregRpta.size();
        contenedores = new ArrayList<>();
        contenedores.add(ft.getPnlUno());
        contenedores.add(ft.getPnlDos());
        contenedores.add(ft.getPnlTres());
        contenedores.add(ft.getPnlCuatro());
        contenedores.add(ft.getPnlCinco());
        contenedores.add(ft.getPnlSeis());

        int t = 0;//indica el panel en el que se estan poniendo las preguntas
        for (int i = 0; i < panelesPregRpta.size(); i++) {
            if (i != 0 && i % 10 == 0) {
                t++;
            }
            contenedores.get(t).add(panelesPregRpta.get(i));
        }
        ft.getPnlMedio().validate();
        ft.getPnlMedio().updateUI();
    }
//tengo array de preguntas de acuerdo a la seccion
//tengo array de respuestas
    public void ponePreguntas() {
        panelesPregRpta = new ArrayList<>();
        respuestasCompletas = new ArrayList<>();
        int n = 0;
        for (Pregunta p : ft.getPreguntas()) {
            n++;
            PnlTexto pt = new PnlTexto();
            pt.getLblTexto().setText(n + ". " + p.getPreg());
            panelesPregRpta.add(pt);
            poneRespuestas(p.getIdPregunta());
        }
    }

    public void poneRespuestas(int idPregunta) {
        respuestas = (ArrayList<Respuesta>) OperacionesBD.listarconCondicion("Respuesta", "pregunta_idPregunta", String.valueOf(idPregunta));
        for (Respuesta r : respuestas) {
            PnlRespuesta pr = new PnlRespuesta();
            pr.getChbPregunta().setText(r.getRpta());
            panelesPregRpta.add(pr);
            respuestasCompletas.add(r);
        }
    }

    public void siguientePanel() {
        n += 10;
        if (n >= c || c < n + 10 || c < n) {
            n = c;
        }
        if (n <= c) {
            cl = (CardLayout) ft.getPnlMedio().getLayout();
            cl.next(ft.getPnlMedio());
        }
        poneEnables();
    }

    public void anteriorPanel() {
        n -= 10;
        if (n <= 0) {
            n = 0;
        }
        if (n >= 0) {
            cl = (CardLayout) ft.getPnlMedio().getLayout();
            cl.previous(ft.getPnlMedio());
        }
        poneEnables();
    }

    public void poneEnables() {
        if (n < c) {
            ft.getBtnSiguiente().setEnabled(true);
            ft.getBtnAnterior().setEnabled(true);
            ft.getBtnCalificar().setEnabled(false);
        } else if (n >= c) {
            ft.getBtnSiguiente().setEnabled(false);
            ft.getBtnAnterior().setEnabled(true);
            ft.getBtnCalificar().setEnabled(true);
        }
    }

    public void califica() {
        int r = JOptionPane.showConfirmDialog(null, "¿Usted esta de acuerdo en calificar  su Test \n si considera que si no puede regresar a revisarlo?", "Calificar", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            resultadoPreguntas = new ArrayList<>();
            int n = 0, aux = -1;
            double valPreg = ControladorEvaluacion.facConoc / ft.getPreguntas().size();//Calculando valor de cada pregunta
            double valResp = 0;
            for (JPanel p : panelesPregRpta) {
                if (p instanceof PnlRespuesta) {
                    PnlRespuesta pr = (PnlRespuesta) p;
                    int idPreg = respuestasCompletas.get(n).getPregunta().getIdPregunta();
                    int idResp = respuestasCompletas.get(n).getIdRespuesta();
                    if (idPreg != aux) {
                        valResp = valRpta(idPreg, valPreg);
                        aux = idPreg;
                    }
                    //si lo escogido por el usuario es correcto
                    if ((respuestasCompletas.get(n).isEstadoRpta() && pr.getChbPregunta().isSelected())
                            || (!respuestasCompletas.get(n).isEstadoRpta() && !pr.getChbPregunta().isSelected())) {
                        resultadoPreguntas.add(new ResultadoConocimientos(idPreg, idResp, true, valResp));
                    } else {//si lo escogido por el usuario es falso
                        resultadoPreguntas.add(new ResultadoConocimientos(idPreg, idResp, false, 0));
                    }
                    n++;
                }
            }
            double total = 0;
            for (ResultadoConocimientos rc : resultadoPreguntas) {
                total += rc.getValor();
                System.out.print("Pregunta: " + rc.getIdPreg() + " ");
                System.out.print("Respuesta: " + rc.getIdResp() + " ");
                System.out.print("Valor: " + rc.getValor() + " ");
                System.out.print("Resultado: " + rc.isRptaCorrecta() + "\n");

            }
            total = OperacionesVarias.redondeaDosCifras(total);//este es el total por seccion
//        double total=;
            int idSeccion = (int) respuestasCompletas.get(0).getPregunta().getSeccion().getIdSeccion();
            ResultadoFinalConocimiento rfc = new ResultadoFinalConocimiento();
            rfc.setIdSeccion(idSeccion);
            rfc.setAprobado(true);
            rfc.setTotal(total);
            for (ResultadoConocimientos rc : resultadoPreguntas) {
                rc.setResultadoFinalConocimiento(rfc);
                rfc.addResultadoConocimiento(rc);
            }
            System.out.println(rptaTexto(total));
//        if (OperacionesBD.guardar(rfc)) {
//            Mensaje.datosGuardados();
            ControladorEvaluacion.txRptaConocIndiv.setText(rfc.getTotal() + " - " + rptaTexto(total));
            ControladorEvaluacion.totConoc += rfc.getTotal();
            double p = calculaPorcentaje(ControladorEvaluacion.totConoc);
            double res = OperacionesVarias.redondeaDosCifras((p * ControladorEvaluacion.facConoc) / 100);
            ControladorEvaluacion.txtTotalConoc.setText(res + "%");
            ControladorEvaluacion.btnEvaluarCon.setEnabled(false);
            ft.dispose();

        }

//        } else {
//            Mensaje.datosNoGuardados();
//        }
    }

    //Calcula el valor que vale cada respuesta correspondiente a una pregunta determinada
    public double valRpta(int idPregunta, double valPreg) {
        double v = 0, c = 0;
        for (Respuesta r : respuestasCompletas) {
            if (r.getPregunta().getIdPregunta() == idPregunta) {
                c++;
            }
        }
        System.out.println("valPreg: " + valPreg + " c:" + c);
        v = valPreg / c;
        return v;
    }

    public String rptaTexto(double total) {
        String s;
        BaseConocimiento bc = new BaseConocimiento();
        double r = OperacionesVarias.redondeaDosCifras((total * 100) / ControladorEvaluacion.facConoc);
        if (bc.compilaArchivo(dirArchivo)) {
            return bc.consultaSegundoElemento("califResult(" + r + ",X)");
        }
        return null;
    }

    private double calculaPorcentaje(double totalObt) {
        double factor = ControladorEvaluacion.facConoc * ControladorEvaluacion.secciones.size();//factor asignado por el estado
        double porcen = (totalObt * 100) / factor;
        return OperacionesVarias.redondeaDosCifras(porcen);
    }
}
