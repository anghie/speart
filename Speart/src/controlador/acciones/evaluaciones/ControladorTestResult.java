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
import vista.paneles.evaluacion.DialogResultEval;
import vista.paneles.evaluacion.PnlRespuesta;
import vista.paneles.evaluacion.PnlRespuestaResult;
import vista.paneles.evaluacion.PnlTexto;
import vista.paneles.evaluacion.PnlTextoResult;

/**
 *
 * @author
 */
public class ControladorTestResult {

    private final DialogResultEval ft;
    private ArrayList<JPanel> panelesPregRpta;
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<ResultadoConocimientos> resultadoPreguntas;
    private int n=0;

    public ControladorTestResult(DialogResultEval ft) {
        this.ft = ft;
    }

    public void llenaPaneles() {
        for (int i = 0; i < panelesPregRpta.size(); i++) {
            ft.getPnlTestResult().add(panelesPregRpta.get(i));
        }
    }
//tengo array de preguntas de acuerdo a la seccion
//tengo array de respuestas

    public void ponePreguntas() {
        panelesPregRpta = new ArrayList<>();
        int n = 0;
        for (Pregunta p : preguntas) {
            n++;
            PnlTextoResult pt = new PnlTextoResult();
            pt.getLblTexto().setText(n + ". " + p.getPreg());
            panelesPregRpta.add(pt);
            poneRespuestas(p.getIdPregunta());
        }
    }

    public void poneRespuestas(int idPregunta) {        
        for (Respuesta r : respuestas) {
            if (r.getPregunta().getIdPregunta() == idPregunta) {
//                PnlRespuestaResult pr = new PnlRespuestaResult();
//                pr.getChbPregunta().setText(r.getRpta());
//                panelesPregRpta.add(pr);
            }
        }
    }
    

}
