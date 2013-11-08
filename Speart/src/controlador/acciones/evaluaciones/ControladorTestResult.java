/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.evaluaciones;

import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.evaluacion.ResultadoConocimientos;
import modelo.pregunta.Pregunta;
import modelo.pregunta.Respuesta;
import vista.paneles.evaluacion.DialogResultEval;
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

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     * @param resultadoPreguntas the resultadoPreguntas to set
     */
    public void setResultadoPreguntas(ArrayList<ResultadoConocimientos> resultadoPreguntas) {
        this.resultadoPreguntas = resultadoPreguntas;
    }
    

}
