package controlador.acciones.proceso;

import controlador.acciones.ControladorPrincipal;
import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.proceso.Actividad;
import modelo.proceso.Proceso;
import modelo.proceso.Rol;
import vista.modelo.Mensaje;
import vista.paneles.proceso.PnlProcesos;

public class ControladorProceso {

    private PnlProcesos pp;
    private Proceso p;
    private Actividad a;
    private ArrayList<Proceso> procesos;
    private ArrayList<Rol> roles;
    private ArrayList<Actividad> actividades;
    public static int idProc;

    public ControladorProceso(PnlProcesos pp) {
        this.pp = pp;
    }

    public void poneComboProcesos() {
        pp.getCbProcesos().removeAllItems();
        listarProcesos();
        if (!procesos.isEmpty()) {
            for (Proceso pr : procesos) {
                pp.getCbProcesos().addItem(pr.getNombreProceso());
            }
        }
    }

    public void poneComboPuestos() {
        pp.getCbPuesto().removeAllItems();
        listarRoles();
        if (!roles.isEmpty()) {
            for (Rol r : roles) {
                pp.getCbPuesto().addItem(r.getCargo());
            }
        }
    }

    public void guardaProceso() {
        String ent = JOptionPane.showInputDialog(null, "Ingrese el nombre del proceso", "Nuevo Proceso", JOptionPane.INFORMATION_MESSAGE);
        try {
            if (!OperacionesBD.existe("Proceso", "nombreProceso", ent)) {
                if (!ent.isEmpty() || !ent.equals("")) {
                    p = new Proceso();
                    p.setNombreProceso(ent);
                    if (OperacionesBD.guardar(p)) {
                        Mensaje.datosGuardados();
                        poneComboProcesos();
                    } else {
                        Mensaje.datosNoGuardados();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre del proceso ingresado ya existe");
            }
        } catch (NullPointerException e) {
        }
    }

    public boolean hayVacios() {
        if (pp.getTxtNombreActividad().getText().isEmpty()
                || pp.getTxtMedioVerif().getText().isEmpty()
                || pp.getTxtDescripcion().getText().isEmpty()) {
            ControladorPrincipal.coloreaErroresTxt(pp.getPnlAddActiv());
            ControladorPrincipal.coloreaErroresATxt(pp.getPnlAddActiv());
            return true;
        }
        ControladorPrincipal.coloreaErroresTxt(pp.getPnlAddActiv());
        ControladorPrincipal.coloreaErroresATxt(pp.getPnlAddActiv());
        return false;
    }

    public void limpiaCampos() {
        pp.getTxtMedioVerif().setText("");
        pp.getTxtNombreActividad().setText("");
        pp.getSpTiempoMin().setValue(0);
        pp.getSpVolumen().setValue(0);
        pp.getTxtDescripcion().setText("");

    }

    public void guardaActividad() {
        a = new Actividad();
        if (obtenerSeleccionado(pp.getGrupoBotones()) != null) {
            setActividad();
            Proceso p = procesos.get(pp.getCbProcesos().getSelectedIndex());
            a.setProcesito(p);
            p.addActividad(a);
            if (OperacionesBD.guardar(p)) {
                Mensaje.datosGuardados();
                limpiaCampos();
            } else {
                Mensaje.datosNoGuardados();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la frecuencia");
        }
    }

    public void setActividad() {
        a.setFrecuencia(obtenerSeleccionado(pp.getGrupoBotones()).getText());
        a.setNombreActividad(pp.getTxtNombreActividad().getText());
        a.setMedioVerificacion(pp.getTxtMedioVerif().getText());
//        a.setProcesito(procesos.get(pp.getCbProcesos().getSelectedIndex()));
        a.setRol(roles.get(pp.getCbPuesto().getSelectedIndex()));
        a.setTipoActividad(String.valueOf(pp.getCbTipo().getSelectedItem()));
        a.setTiempoParcial(Integer.parseInt(String.valueOf(pp.getSpTiempoMin().getValue())));
        a.setVolumen(Integer.parseInt(String.valueOf(pp.getSpVolumen().getValue())));
        a.setDescripcion(pp.getTxtDescripcion().getText());
        a.setParaEvaluacion(false);
    }

    public static JCheckBox obtenerSeleccionado(ButtonGroup grupoBotones) {
        JCheckBox ch = null;
        Enumeration e = grupoBotones.getElements();
        while (e.hasMoreElements() == true) {
            JCheckBox r = (JCheckBox) e.nextElement();
            if (r.isSelected()) {
                ch = r;
                break;
            }
        }
        return ch;
    }

    public void listarProcesos() {
        procesos = (ArrayList<Proceso>) OperacionesBD.listar("Proceso");
    }

    public void listarRoles() {
        roles = (ArrayList<Rol>) OperacionesBD.listar("Rol");
    }

    //**************************************************************************
    //          TABLA ACTIVIDADES 
    //**************************************************************************
    public void poneComboLstProc() {
        pp.getCbProcesosLista().removeAllItems();
        listarProcesos();
        if (!procesos.isEmpty()) {
            for (Proceso pr : procesos) {
                pp.getCbProcesosLista().addItem(pr.getNombreProceso());
            }
        }
        selecProceso();
    }

    public void selecProceso() {
        if (pp.getCbProcesosLista().getSelectedIndex() != -1) {
            idProc = procesos.get(pp.getCbProcesosLista().getSelectedIndex()).getIdProceso();
            actualizaTabla();
        }
    }

    public void actualizaTabla() {
        listarActividades();
        modeloTablaActividades();
    }

    public boolean isRowSelectedTblActiv() {
        if (pp.getTblActividades().getSelectedRow() != -1) {
            return true;
        } else {
            return false;
        }
    }

    public void listarActividades() {
        actividades = (ArrayList<Actividad>) OperacionesBD.listarconCondicion("Actividad", "procesito_idProceso", String.valueOf(idProc));
    }

    public void modeloTablaActividades() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Responsable");
        dtm.addColumn("Frecuencia");
        dtm.addColumn("Medio Verificacion");
        dtm.addColumn("Tipo");

        for (Actividad o : actividades) {
            Object[] act = new Object[5];
            act[0] = o.getNombreActividad();
            act[1] = o.getRol().getCargo();
            act[2] = o.getFrecuencia();
            act[3] = o.getMedioVerificacion();
            act[4] = o.getTipoActividad();
            dtm.addRow(act);
        }
        pp.getTblActividades().setModel(dtm);
        pp.getTblActividades().getColumnModel().getColumn(0).setPreferredWidth(200);
        pp.getTblActividades().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void editaProceso() {
        p = procesos.get(pp.getCbProcesosLista().getSelectedIndex());
        try {
            String s = JOptionPane.showInputDialog("Ingrese el nombre para el proceso: ");
            if (!s.isEmpty()) {
                p.setNombreProceso(s);
                if (OperacionesBD.modificar(p)) {
                    Mensaje.datosModificados();
                    poneComboLstProc();
                    poneComboProcesos();
                } else {
                    Mensaje.datosNoModificados();
                }
            }
        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }
    }

    public void eliminarActividad() {
        a = actividades.get(pp.getTblActividades().getSelectedRow());
        if (OperacionesBD.eliminar(a, a.getIdActividad())) {
            Mensaje.datosEliminados();
            actualizaTabla();
        } else {
            Mensaje.datosNoEliminados();
        }
    }

    public void getActividadModif() {
        pp.getBtnGuardarActividad().setText("Modificar");
        a = actividades.get(pp.getTblActividades().getSelectedRow());
        pp.getTxtNombreActividad().setText(a.getNombreActividad());
        pp.getTxtDescripcion().setText(a.getDescripcion());
        pp.getTxtMedioVerif().setText(a.getMedioVerificacion());
        pp.getCbTipo().setSelectedItem(a.getTipoActividad());
        ponerSeleccionado(pp.getGrupoBotones(), a.getFrecuencia());
        pp.getTabbedProcesos().setSelectedIndex(0);
        pp.getCbProcesos().setSelectedIndex(pp.getCbProcesosLista().getSelectedIndex());

    }

    public void editarActividad() {
        setActividad();
        if (OperacionesBD.modificar(a)) {
            Mensaje.datosModificados();
            actualizaTabla();
            limpiaCampos();
            pp.getTabbedProcesos().setSelectedIndex(1);
            pp.getBtnGuardarActividad().setText("Guardar");
        } else {
            Mensaje.datosNoModificados();
        }
    }

    public static void ponerSeleccionado(ButtonGroup grupoBotones, String txt) {
        JCheckBox ch = null;
        Enumeration e = grupoBotones.getElements();
        while (e.hasMoreElements() == true) {
            JCheckBox r = (JCheckBox) e.nextElement();
            if (r.getText().equals(txt)) {
                r.setSelected(true);
                break;
            }
        }
    }

    public void listaPredictiva(int idProceso, String texto) {
        actividades = (ArrayList<Actividad>) OperacionesBD.listarPrediccionDoble("Actividad",
                "nombreActividad", texto, "procesito_idProceso",
                String.valueOf(idProceso));
        modeloTablaActividades();

    }
}
