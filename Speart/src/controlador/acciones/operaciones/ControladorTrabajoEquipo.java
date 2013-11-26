/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.operaciones;

import controlador.acciones.ControladorPrincipal;
import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.operaciones.TrabajoEquipo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.modelo.Mensaje;
import vista.paneles.operaciones.PnlOperaciones;

/**
 *
 * @author
 */
public class ControladorTrabajoEquipo {

    private PnlOperaciones po;
    private TrabajoEquipo te;
    private ArrayList<TrabajoEquipo> equipos;

    public ControladorTrabajoEquipo(PnlOperaciones po) {
        this.po = po;
    }

    public boolean hayVaciosTrab() {
        if (po.getTxtDescripcionTrabEq().getText().isEmpty()
                || po.getTxtAltaTrabEquipo().getText().isEmpty()
                || po.getTxtMediaTrabEquipo().getText().isEmpty()
                || po.getTxtBajaTrabEquipo().getText().isEmpty()) {
            ControladorPrincipal.coloreaErroresTxt(po.getPnlTrabajoEquipo());
            ControladorPrincipal.coloreaErroresATxt(po.getPnlTrabajoEquipo());
            return true;
        } else {
            ControladorPrincipal.coloreaErroresTxt(po.getPnlTrabajoEquipo());
            ControladorPrincipal.coloreaErroresATxt(po.getPnlTrabajoEquipo());
            return false;
        }
    }

    public void poneEnablesTrabEquip(boolean enable) {
        po.getTxtAltaTrabEquipo().setEnabled(enable);
        po.getTxtBajaTrabEquipo().setEnabled(enable);
        po.getTxtMediaTrabEquipo().setEnabled(enable);
        po.getTxtDescripcionTrabEq().setEnabled(enable);
    }

    public void nuevoTrabajoEquipo() {
        poneEnablesTrabEquip(true);
        po.getTxtAltaTrabEquipo().setText("");
        po.getTxtBajaTrabEquipo().setText("");
        po.getTxtMediaTrabEquipo().setText("");
        po.getTxtDescripcionTrabEq().setText("");
    }

    public void setTrabajoEquipo() {
        te.setDescripcionTrabEquipo(po.getTxtDescripcionTrabEq().getText());
        te.setAltaTrabEquipo(po.getTxtAltaTrabEquipo().getText());
        te.setMediaTrabEquipo(po.getTxtMediaTrabEquipo().getText());
        te.setBajaTrabEquipo(po.getTxtBajaTrabEquipo().getText());
    }

    public void guardaTrabEquipo() {
        te = new TrabajoEquipo();
        setTrabajoEquipo();
        if (OperacionesBD.guardar(te)) {
            Mensaje.datosGuardados();
            actualizaTablaTrabEquipo();
            nuevoTrabajoEquipo();
            poneEnablesTrabEquip(false);
        } else {
            Mensaje.datosNoGuardados();
        }
    }

    public void actualizaTablaTrabEquipo() {
        listarTrabEquipo();
        modeloTablaTrabEquipo();
    }

    public void listarTrabEquipo() {
        equipos = (ArrayList<TrabajoEquipo>) OperacionesBD.listar("TrabajoEquipo");
    }

    public void modeloTablaTrabEquipo() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Descripcion");
        dtm.addColumn("Alta");
        dtm.addColumn("Media");
        dtm.addColumn("Baja");
        if (!equipos.isEmpty()) {
            for (TrabajoEquipo c : equipos) {
                Object o[] = new Object[4];
                o[0] = c.getDescripcionTrabEquipo();
                o[1] = c.getAltaTrabEquipo();
                o[2] = c.getMediaTrabEquipo();
                o[3] = c.getBajaTrabEquipo();
                dtm.addRow(o);
            }
        }
        po.getTblTrabajoEquipo().setModel(dtm);
    }

    public boolean isRowSelectedTrabEquipo() {
        if (po.getTblTrabajoEquipo().getSelectedRow() != -1) {
            return true;
        }
        return false;
    }

    public void getTrabajoEquipo() {
        te = equipos.get(po.getTblTrabajoEquipo().getSelectedRow());
        poneEnablesTrabEquip(true);
        po.getTxtDescripcionTrabEq().setText(te.getDescripcionTrabEquipo());
        po.getTxtAltaTrabEquipo().setText(te.getAltaTrabEquipo());
        po.getTxtMediaTrabEquipo().setText(te.getMediaTrabEquipo());
        po.getTxtBajaTrabEquipo().setText(te.getBajaTrabEquipo());
        po.getBtnGuardarTrabEquipo().setText("Modificar");
    }

    public void editarTrabajoEquipo() {
        setTrabajoEquipo();
        if (OperacionesBD.modificar(te)) {
            Mensaje.datosModificados();
            actualizaTablaTrabEquipo();
            nuevoTrabajoEquipo();
            poneEnablesTrabEquip(false);
            po.getBtnGuardarTrabEquipo().setText("Guardar");
        } else {
            Mensaje.datosNoModificados();
        }
    }

    public void eliminarTrabajoEquipo() {
        te = equipos.get(po.getTblTrabajoEquipo().getSelectedRow());
        if (OperacionesBD.eliminar(te, te.getIdTrabEquipo())) {
            Mensaje.datosEliminados();
            actualizaTablaTrabEquipo();
        } else {
            Mensaje.datosNoEliminados();
        }
    }
    
    public void imprimeReporteTE(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/controlador/reportes/ReporteTrabEquip.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(equipos));
            JasperViewer vista = new JasperViewer(jasperPrint, false);
            if (!vista.isActive()) {
                vista.setVisible(true);
            }
        } catch (JRException ex) {
            Logger.getLogger(ControladorTrabajoEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
