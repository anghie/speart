/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import controlador.basedatos.OperacionesBD;
import controlador.experto.BaseConocimiento;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import modelo.evaluacion.ResultadoConocimientos;
import modelo.evaluacion.ResultadoFinalConocimiento;
import modelo.pregunta.Pregunta;
import modelo.pregunta.Respuesta;
import vista.modelo.OperacionesVarias;
import vista.paneles.evaluacion.DialogTest;
//import vista.paneles.evaluacion.FrmTests;
import vista.paneles.evaluacion.PnlRespuesta;
import vista.paneles.evaluacion.PnlTexto;

/**
 *
 * @author
 */
public class ControladorTest {

    private final DialogTest ft;
    private ArrayList<JPanel> panelesPregRpta;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<Respuesta> respuestasCompletas;
    private ArrayList<ResultadoConocimientos> resultadoPreguntas;
    //private ArrayList<ResultadoConocimientos> auxprint;
//    private Seccion s;
    private final ClassLoader cload = ControladorTest.class.getClassLoader();//para hacer referencia a archivos dentro del programa
    private final String dirArchivo = cload.getResource("controlador/experto/evaluacion.pl").getPath();

    public ControladorTest(DialogTest ft) {
        this.ft = ft;
//        ControladorEvaluacion.totConoc = 0;
    }

//    public void llenaPaneles() {
//        c = panelesPregRpta.size();
//        contenedores = new ArrayList<>();
//        contenedores.add(ft.getPnlUno());
//        contenedores.add(ft.getPnlDos());
//        contenedores.add(ft.getPnlTres());
//        contenedores.add(ft.getPnlCuatro());
//        contenedores.add(ft.getPnlCinco());
//        contenedores.add(ft.getPnlSeis());
//
//        int t = 0;//indica el panel en el que se estan poniendo las preguntas
//        for (int i = 0; i < panelesPregRpta.size(); i++) {
//            if (i != 0 && i % 10 == 0) {
//                t++;
//            }
//            contenedores.get(t).add(panelesPregRpta.get(i));
//        }
//        ft.getPnlMedio().validate();
//        ft.getPnlMedio().updateUI();
//    }
    public void llenaPaneles() {
        for (int i = 0; i < panelesPregRpta.size(); i++) {
            ft.getPnlTest().add(panelesPregRpta.get(i));
        }
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

//    public void siguientePanel() {
//        n += 10;
//        if (n >= c || c < n + 10 || c < n) {
//            n = c;
//        }
//        if (n <= c) {
//            cl = (CardLayout) ft.getPnlMedio().getLayout();
//            cl.next(ft.getPnlMedio());
//        }
//        poneEnables();
//    }
//
//    public void anteriorPanel() {
//        n -= 10;
//        if (n <= 0) {
//            n = 0;
//        }
//        if (n >= 0) {
//            cl = (CardLayout) ft.getPnlMedio().getLayout();
//            cl.previous(ft.getPnlMedio());
//        }
//        poneEnables();
//    }
//
//    public void poneEnables() {
//        if (n < c) {
//            ft.getBtnSiguiente().setEnabled(true);
//            ft.getBtnAnterior().setEnabled(true);
//            ft.getBtnCalificar().setEnabled(false);
//        } else if (n >= c) {
//            ft.getBtnSiguiente().setEnabled(false);
//            ft.getBtnAnterior().setEnabled(true);
//            ft.getBtnCalificar().setEnabled(true);
//        }
//    }
    public void califica() {
        int r = JOptionPane.showConfirmDialog(null, "¿Advertencia: Usted está de acuerdo en calificar  su Test, \n si la  respuesta es afirmativa, no le será posible  revisarlo?", "Calificar", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            resultadoPreguntas = new ArrayList<>();
            //auxprint = new ArrayList<>();
            int n = 0, aux = -1;
            double valPreg;
            double valResp = 0;
            if (hayDeseleccionados()) {
                valPreg = 0;
            } else {
                valPreg = ControladorEvaluacion.facConoc / ft.getPreguntas().size();//Calculando valor de cada pregunta
            }

            for (JPanel p : panelesPregRpta) {
                if (p instanceof PnlRespuesta) {
                    PnlRespuesta pr = (PnlRespuesta) p;
                    int idPreg = respuestasCompletas.get(n).getPregunta().getIdPregunta();
//                    String nompreg = respuestasCompletas.get(n).getPregunta().getPreg();
                    int idResp = respuestasCompletas.get(n).getIdRespuesta();
//                    String nomresp = respuestasCompletas.get(n).getRpta();
                    if (idPreg != aux) {
                        valResp = valRpta(idPreg, valPreg);
                        aux = idPreg;
                    }
                    //si lo escogido por el usuario es correcto
                    if ((respuestasCompletas.get(n).isEstadoRpta() && pr.getChbPregunta().isSelected())//si rpta guradada = true y rpta usuario = true
                            || (!respuestasCompletas.get(n).isEstadoRpta() && !pr.getChbPregunta().isSelected())) {
                        System.out.println("BD: " + respuestasCompletas.get(n).isEstadoRpta() + " RPTA: " + pr.getChbPregunta().isSelected());
                        resultadoPreguntas.add(new ResultadoConocimientos(idPreg, idResp, true, valResp));

                    } else {//si lo escogido por el usuario es falso
                        System.out.println("BD: " + respuestasCompletas.get(n).isEstadoRpta() + " RPTA: " + pr.getChbPregunta().isSelected());
                        resultadoPreguntas.add(new ResultadoConocimientos(idPreg, idResp, false, 0));
                    }
                    n++;
                }
            }
            double total = 0;

            for (ResultadoConocimientos rc : resultadoPreguntas) {
                total += rc.getValor();
//                System.out.print("Pregunta: " + rc.getIdPreg() + " ");
//                System.out.print("Respuesta: " + rc.getIdResp() + " ");
//                System.out.print("Valor: " + rc.getValor() + " ");//lo q contesto el usuario
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
//            System.out.println(rptaTexto(total));
//        if (OperacionesBD.guardar(rfc)) {
//            Mensaje.datosGuardados();
            ControladorEvaluacion.txRptaConocIndiv.setText(rfc.getTotal() + " - " + rptaTexto(total));
            ControladorEvaluacion.totConoc += rfc.getTotal();     
            double p = calculaPorcentaje(ControladorEvaluacion.totConoc);
            double res = OperacionesVarias.redondeaDosCifras((p * ControladorEvaluacion.facConoc) / 100);
            ControladorEvaluacion.txtTotalConoc.setText(res + "%");
            ControladorEvaluacion.btnEvaluarCon.setEnabled(false);
            ControladorEvaluacion.totConoc = res;

            ft.dispose();
            // aqui va

        }

//        } else {
//            Mensaje.datosNoGuardados();
//        }
        presentaResultados();
    }

    public void presentaResultados() {
        //creacion del jframe para la presentacion de las respuestas
        final JFrame frame = new JFrame("Panel de Respuestas");
        //asignacion de la imagen de fondo
        Panel pa = new Panel("/vista/imagenes/quejas.jpg");
        //creacion del contender para el panel del jframe
        Container c = frame.getContentPane();
        // asignamos un tamaño para el panel
        pa.setSize(800, 600);
        //calculo del numero de elementos que contendra el panel
        int numeropre = resultadoPreguntas.size();
        //asignacion de los valores para que el layout se acople al numero de elementos a presentarse
        pa.setLayout(new GridLayout(numeropre * 2, 1));
        //Titulo 
        JLabel title = new JLabel("Preguntas del Servidor");
        Font fon = new Font("Verdana", Font.BOLD, 17);
        title.setFont(fon);
        title.setForeground(Color.RED);
        pa.add(title);
        int idaux = 0;
        //creacion del ciclo para la presentacion de las respuestas de la evaluacion
        for (ResultadoConocimientos rc : resultadoPreguntas) {
            // aqui se presenta los valores                
            if (idaux == rc.getIdPreg()) {
            } else {
                idaux = 0;
            }
            if (idaux == 0) {
                Pregunta pr = (Pregunta) OperacionesBD.buscar("Pregunta", "idPregunta", String.valueOf(rc.getIdPreg()));
                JLabel jl = new JLabel(pr.getPreg());
                Font font = new Font("Arial", Font.BOLD, 12);
                jl.setFont(font);
                jl.setForeground(Color.BLACK);
                pa.add(jl);
                //consulta del atributo de la pregunta
                ArrayList<Respuesta> lisres = (ArrayList<Respuesta>) OperacionesBD.buscarTodos("Respuesta", "Pregunta_idPregunta", String.valueOf(rc.getIdPreg()));
                for (int i = 0; i < lisres.size(); i++) {
//                        if (lisres.get(i).isEstadoRpta() == true) {
                    if (rc.isRptaCorrecta()) {
                        //asignacion de la imagen al label
                        String path = "/vista/imagenes/button_more.png";
                        URL url = this.getClass().getResource(path);
                        ImageIcon icon = new ImageIcon(url);
                        JLabel label = new JLabel("some text");
                        label.setIcon(icon);
                        label.setText(lisres.get(i).getRpta());
//                            label.setText(lisres.get(i).getRpta());
                        pa.add(label);
                    } else {
                        //asignacion de la imagen al label
                        String path = "/vista/imagenes/button_cancel.png";
                        URL url = this.getClass().getResource(path);
                        ImageIcon icon = new ImageIcon(url);
                        JLabel label = new JLabel("some text");
                        label.setIcon(icon);
                        label.setText(lisres.get(i).getRpta());
//                        label.setText(lisres.get(i).getRpta());
                        pa.add(label);
                    }
                }

                idaux = rc.getIdPreg();
            }
        }
        //creacion del scrooll para el panel
        JScrollPane jsp = new JScrollPane(pa);
        c.add(jsp);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        //button para cerrar el frame
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        pa.add(btnSalir);
        frame.setVisible(true);
    }

    //Calcula el valor que vale cada respuesta correspondiente a una pregunta determinada
    public double valRpta(int idPregunta, double valPreg) {
        double v = 0, c = 0;
        for (Respuesta r : respuestasCompletas) {
            if (r.getPregunta().getIdPregunta() == idPregunta) {
                c++;
            }
        }
//        System.out.println("valPreg: " + valPreg + " c:" + c);
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
        System.out.println("Total obtenido: " + totalObt);
        double factor = 0, porcen = 0;
        factor = ControladorEvaluacion.facConoc * ControladorEvaluacion.secciones.size();//factor asignado por el estado
        porcen = (totalObt * 100) / factor;

        return OperacionesVarias.redondeaDosCifras(porcen);
    }

    private boolean hayDeseleccionados() {
        int cont = 0, rs = 0;
        for (JPanel p : panelesPregRpta) {
            if (p instanceof PnlRespuesta) {
                rs++;
                PnlRespuesta pr = (PnlRespuesta) p;
                if (!pr.getChbPregunta().isSelected()) {
                    cont++;
                }
            }
        }
        return cont == rs;
    }
}
