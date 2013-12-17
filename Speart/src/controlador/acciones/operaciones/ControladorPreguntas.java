/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.operaciones;

import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.pregunta.Pregunta;
import modelo.pregunta.Respuesta;
import modelo.pregunta.Seccion;
import vista.modelo.Mensaje;
import vista.paneles.operaciones.PnlOperaciones;
import vista.paneles.operaciones.PnlPregunta;

/**
 *
 * @author
 */
public class ControladorPreguntas {

    private PnlOperaciones po;
    private Seccion seccion;
    private Pregunta pregunta;
    private ArrayList<Seccion> secciones;
    private ArrayList<Pregunta> preguntas;
    private ArrayList<Respuesta> respuestas;
    private ArrayList<PnlPregunta> lstPnlPregunta;
    public static boolean btnPresionado;
    private int idSeccion;

    public ControladorPreguntas(PnlOperaciones po) {
        this.po = po;
    }

    public void listarSecciones() {
        secciones = (ArrayList<Seccion>) OperacionesBD.listar("Seccion");
    }

    public void poneCbSeccion() {
        po.getCbSeccion().removeAllItems();
        listarSecciones();
        if (!secciones.isEmpty()) {
            for (Seccion sec : secciones) {
                po.getCbSeccion().addItem(sec.getNombreSeccion());
            }
        }
    }
//
    public void guardaSeccion() {
        String s = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nueva seccion: ", "Nueva Seccion", JOptionPane.INFORMATION_MESSAGE);
        try {
            if (!OperacionesBD.existe("seccion", "nombreSeccion", s)) {
                if (!s.isEmpty()|| !s.equals("")) {
                    seccion = new Seccion();
                    seccion.setNombreSeccion(s);
                    seccion.setParaEvaluacion(false);
                    if (OperacionesBD.guardar(seccion)) {
                        Mensaje.datosGuardados();
                        poneCbSeccion();
                    } else {
                        Mensaje.datosNoGuardados();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de la seccion ingresada ya existe");
            }
        } catch (NullPointerException e) {

        }

    }

    public void editaSeccion() {
        String l = JOptionPane.showInputDialog("Ingrese nombre para la sección ");
        if (!l.isEmpty()) {
            seccion = secciones.get(po.getCbSeccionLstPreg().getSelectedIndex());
            seccion.setNombreSeccion(l);
            if (OperacionesBD.modificar(seccion)) {
                Mensaje.datosModificados();
                listarSecciones();
                poneCbSeccionLst();
                poneCbSeccion();
            } else {
                Mensaje.datosNoModificados();
            }
        }
    }

    public void ponePosibleRptas(int n) {
        limpiaPnlRptas();
        po.getPnlRespuestas().validate();
        lstPnlPregunta = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            PnlPregunta preg = new PnlPregunta();
            po.getPnlRespuestas().add(preg);
            lstPnlPregunta.add(preg);
        }
        po.getPnlRespuestas().validate();
        po.getPnlRespuestas().updateUI();
    }

    public void limpiaPnlRptas() {
        po.getPnlRespuestas().removeAll();
        po.getPnlRespuestas().validate();
        po.getPnlRespuestas().updateUI();
    }


    public void guardaPregunta() {
//        if (!OperacionesBD.existe("pregunta", "preg", po.getTxtNuevaPregunt().getText())) {
        pregunta = new Pregunta();
        setPregunta();
        respuestas = new ArrayList<>();
        setRpta(pregunta);
        btnPresionado = false;
        if (OperacionesBD.guardar(pregunta)) {
            Mensaje.datosGuardados();
            limpiaCampos();
        } else {
            Mensaje.datosNoGuardados();
        }
//          }else {
//            JOptionPane.showMessageDialog(null, "La pregunta  ya existe");
//        }
    }

    public void cancelaPregunta() {
        limpiaCampos();
    }

    public void setPregunta() {
        pregunta.setPreg(po.getTxtNuevaPregunt().getText());
        pregunta.setHabilit(true);
        pregunta.setSeccion(secciones.get(po.getCbSeccion().getSelectedIndex()));
    }

    public void setRpta(Pregunta p) {
        for (PnlPregunta pp : lstPnlPregunta) {
            Respuesta r = new Respuesta();
            r.setRpta(pp.getTxtPregunta().getText());
            if (pp.getChbFalso().isSelected()) {
                r.setEstadoRpta(false);
            } else if (pp.getChbVerdad().isSelected()) {
                r.setEstadoRpta(true);
            }
            p.addRpta(r);
            r.setPregunta(p);
            respuestas.add(r);
        }
    }
//
//    public boolean guardaRespuesta() {
//        boolean guardado = false;
//        for (Respuesta r : respuestas) {
//            if (OperacionesBD.guardar(r)) {
//                guardado = true;
//            } else {
//                guardado = false;
//                break;
//            }
//        }
//        return guardado;
//    }

    public boolean compruebatextos() {
        for (PnlPregunta pp : lstPnlPregunta) {
            if (pp.getTxtPregunta().getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean compruebaSeleccionados() {
        for (PnlPregunta pp : lstPnlPregunta) {
            if (!pp.getChbFalso().isSelected() && !pp.getChbVerdad().isSelected()) {
                return false;
            }
        }
        return true;
    }

    public void limpiaCampos() {
        limpiaPnlRptas();
        po.getTxtNuevaPregunt().setText("");
        po.getSpNroPreg().setValue(2);
        po.getPnlRespuestas().validate();
    }

    //**************************************************************************
    //          TABLA PREGUNTAS
    //**************************************************************************
    public void poneCbSeccionLst() {
        po.getCbSeccionLstPreg().removeAllItems();
        listarSecciones();
        if (!secciones.isEmpty()) {
            for (Seccion sec : secciones) {
                po.getCbSeccionLstPreg().addItem(sec.getNombreSeccion());
            }
        }
        selecSeccion();
    }

    public void selecSeccion() {
        if (po.getCbSeccionLstPreg().getSelectedIndex() != -1) {
            idSeccion = (int) secciones.get(po.getCbSeccionLstPreg().getSelectedIndex()).getIdSeccion();
            actualizaTablaPreguntas();
        }
    }

    public void listarPreguntas() {
        preguntas = (ArrayList<Pregunta>) OperacionesBD.listarconCondicion("Pregunta", "seccion_idSeccion", String.valueOf(idSeccion));
    }

    public void actualizaTablaPreguntas() {
        listarPreguntas();
        modeloTablaPreguntas();
    }

    public void modeloTablaPreguntas() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nro");
        dtm.addColumn("Pregunta");
        int n = 1;
        for (Pregunta p : preguntas) {
            Object[] o = new Object[2];
            o[0] = n;
            o[1] = p.getPreg();
            dtm.addRow(o);
            n++;
        }
        po.getTblPreguntas().setModel(dtm);
        po.getTblPreguntas().getColumnModel().getColumn(0).setPreferredWidth(10);
        po.getTblPreguntas().getColumnModel().getColumn(1).setPreferredWidth(400);
        po.getTblPreguntas().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public boolean isRowSelectedTblPreg() {
        if (po.getTblPreguntas().getSelectedRow() != -1) {
            return true;
        } else {
            return false;
        }
    }

    public void eliminarPregunta() {
        pregunta = preguntas.get(po.getTblPreguntas().getSelectedRow());
        if (OperacionesBD.eliminar(pregunta, pregunta.getIdPregunta())) {
            Mensaje.datosEliminados();
            actualizaTablaPreguntas();
        } else {
            Mensaje.datosNoEliminados();
        }

    }
}
