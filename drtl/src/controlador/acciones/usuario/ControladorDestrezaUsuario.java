/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.usuario;

import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import modelo.operaciones.CompetenciaTecnica;
import vista.paneles.usuario.DialogCompetTecnica;

/**
 *
 * @author 
 */
public class ControladorDestrezaUsuario {

    private DialogCompetTecnica dct;
    private ArrayList<CompetenciaTecnica> competenciasDisponibles;
    private ArrayList<CompetenciaTecnica> competenciasAsignadas;

    public ControladorDestrezaUsuario(DialogCompetTecnica dct) {
        this.dct = dct;
    }

    public void listarDestreza() {
        ArrayList<CompetenciaTecnica> comp = (ArrayList<CompetenciaTecnica>) OperacionesBD.listar("CompetenciaTecnica");
        competenciasDisponibles = new ArrayList<>();
        competenciasAsignadas = new ArrayList<>();
        for (CompetenciaTecnica ct : comp) {
            if (ct.isParaEvaluacionCT() && ct.getRolesCT().contains(dct.getRol())) {
                competenciasAsignadas.add(ct);
            } else {
                competenciasDisponibles.add(ct);
            }
        }
    }

    public void poneLstDestrezasDisp() {
        DefaultListModel dlm = new DefaultListModel();
        dct.getLstDestrezasDisponibles().removeAll();
        if (!competenciasDisponibles.isEmpty()) {
            dlm.removeAllElements();
            for (CompetenciaTecnica c : competenciasDisponibles) {
                dlm.addElement(c.getNombreDestrezaTec());
            }
        }
        dct.getLstDestrezasDisponibles().setModel(dlm);
    }

    public void poneLstDestrezasAsig() {
        DefaultListModel dlm = new DefaultListModel();
        dct.getLstDestrezasAsignadas().removeAll();
        if (!competenciasAsignadas.isEmpty()) {
            dlm.removeAllElements();
            for (CompetenciaTecnica c : competenciasAsignadas) {
                dlm.addElement(c.getNombreDestrezaTec());
            }
        }
        dct.getLstDestrezasAsignadas().setModel(dlm);
    }

    public void agregaItemDestrezaAsignados() {
        CompetenciaTecnica ct = competenciasDisponibles.get(dct.getLstDestrezasDisponibles().getSelectedIndex());
        competenciasAsignadas.add(ct);
        competenciasDisponibles.remove(ct);
        poneLstDestrezasAsig();
        poneLstDestrezasDisp();
    }

    public void quitaItemDestrezaAsignados() {
        CompetenciaTecnica ct = competenciasAsignadas.get(dct.getLstDestrezasAsignadas().getSelectedIndex());
        competenciasDisponibles.add(ct);
        competenciasAsignadas.remove(ct);
        poneLstDestrezasAsig();
        poneLstDestrezasDisp();
    }

    public void guardaDestrezaUsuario() {
        if (!competenciasAsignadas.isEmpty()) {
            for (CompetenciaTecnica s : competenciasAsignadas) {
                s.setParaEvaluacionCT(true);
                s.addRol(dct.getRol());
                OperacionesBD.modificar(s);
            }
        }
        if (!competenciasDisponibles.isEmpty()) {
            for (CompetenciaTecnica s : competenciasDisponibles) {
                s.setParaEvaluacionCT(false);
                OperacionesBD.modificar(s);
            }
        }
    }
}
