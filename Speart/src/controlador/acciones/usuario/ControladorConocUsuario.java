/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.usuario;

import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.pregunta.Seccion;
import vista.paneles.usuario.DialogConocUsuario;

/**
 *
 * @author 
 */
public class ControladorConocUsuario {
    
    private DialogConocUsuario dcu;
    private ArrayList<Seccion> conocimientosDisponibles;
    private ArrayList<Seccion> conocimientosAsignados;
    
    public ControladorConocUsuario(DialogConocUsuario dcu) {
        this.dcu = dcu;
//        conocimientosAsignados = new ArrayList<>();
    }
    
    public void listarSeccion() {
        ArrayList<Seccion> con = (ArrayList<Seccion>) OperacionesBD.listar("Seccion");
        conocimientosDisponibles = new ArrayList<>();
        conocimientosAsignados = new ArrayList<>();
        for (Seccion c : con) {
            if (c.isParaEvaluacion() && c.getRoles().contains(dcu.getRol())) {
                conocimientosAsignados.add(c);
            } else {
                conocimientosDisponibles.add(c);
            }
        }
    }

    /**
     * @return the conocimientosDisponibles
     */
    public ArrayList<Seccion> getConocimientosDisponibles() {
        return conocimientosDisponibles;
    }

    /**
     * @return the conocimientosAsignados
     */
    public ArrayList<Seccion> getConocimientosAsignados() {
        return conocimientosAsignados;
    }
    
    public void poneLstConocDisp() {
        DefaultListModel dlm = new DefaultListModel();
        dcu.getLstConocimientosDisp().removeAll();
        if (!conocimientosDisponibles.isEmpty()) {
            dlm.removeAllElements();
            for (Seccion c : getConocimientosDisponibles()) {
                dlm.addElement(c.getNombreSeccion());
            }
        }
        dcu.getLstConocimientosDisp().setModel(dlm);
    }
    
    public void poneLstConocAsig() {
        DefaultListModel dlm = new DefaultListModel();
        dcu.getLstConocimientosAsignados().removeAll();
        if (!conocimientosAsignados.isEmpty()) {
            dlm.removeAllElements();
            for (Seccion c : getConocimientosAsignados()) {
                dlm.addElement(c.getNombreSeccion());
            }
        }
        dcu.getLstConocimientosAsignados().setModel(dlm);
    }
    
    public void agregaItemConocAsignados(Seccion s) {
        getConocimientosAsignados().add(s);
        getConocimientosDisponibles().remove(s);
        poneLstConocAsig();
        poneLstConocDisp();
    }
    
    public void quitaItemConocAsignados(Seccion s) {
        getConocimientosAsignados().remove(s);
        getConocimientosDisponibles().add(s);
        poneLstConocAsig();
        poneLstConocDisp();
    }
    
    public void guardaConocUsuario() {
        if (!conocimientosAsignados.isEmpty()) {
            for (Seccion s : conocimientosAsignados) {
                s.setParaEvaluacion(true);
                s.addRol(dcu.getRol());
                OperacionesBD.modificar(s);
            }
        }
        if (!conocimientosDisponibles.isEmpty()) {
            for (Seccion s : conocimientosDisponibles) {
                s.setParaEvaluacion(false);
                OperacionesBD.modificar(s);
            }
        }
    }
}