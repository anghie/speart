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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.operaciones.CompetenciaUniversal;
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
public class ControladorCompetenciasUniversales {

    private PnlOperaciones po;
    private CompetenciaUniversal cu;
    private ArrayList<CompetenciaUniversal> universales;

    public ControladorCompetenciasUniversales(PnlOperaciones po) {
        this.po = po;
    }

    public boolean hayVaciosUniv() {
        if (po.getTxtDestrezaCompUniv().getText().isEmpty()
                || po.getTxtAltaCompUniv().getText().isEmpty()
                || po.getTxtMediaCompUniv().getText().isEmpty()
                || po.getTxtBajaCompUniv().getText().isEmpty()) {
            ControladorPrincipal.coloreaErroresTxt(po.getPnlCompUniv());
            ControladorPrincipal.coloreaErroresATxt(po.getPnlCompUniv());
            return true;
        } else {
            ControladorPrincipal.coloreaErroresTxt(po.getPnlCompUniv());
            ControladorPrincipal.coloreaErroresATxt(po.getPnlCompUniv());
            return false;
        }
    }

    public void poneEnablesUniv(boolean enable) {
        po.getTxtAltaCompUniv().setEnabled(enable);
        po.getTxtBajaCompUniv().setEnabled(enable);
        po.getTxtMediaCompUniv().setEnabled(enable);
        po.getTxtDestrezaCompUniv().setEnabled(enable);
    }

    public void nuevaCompetenciaUniversal() {
        poneEnablesUniv(true);
        po.getTxtAltaCompUniv().setText("");
        po.getTxtBajaCompUniv().setText("");
        po.getTxtMediaCompUniv().setText("");
        po.getTxtDestrezaCompUniv().setText("");
    }

    public void setCompetenciaUniversal() {
        cu.setNombreDestrezaUniv(po.getTxtDestrezaCompUniv().getText());
        cu.setAltaUniv(po.getTxtAltaCompUniv().getText());
        cu.setMediaUniv(po.getTxtMediaCompUniv().getText());
        cu.setBajaUniv(po.getTxtBajaCompUniv().getText());
    }

    public void guardaCompetenciaUniversal() {
         if (!OperacionesBD.existe("CompetenciaUniversal", "nombreDestrezaUniv", po.getTxtDestrezaCompUniv().getText())) {
        cu = new CompetenciaUniversal();
        setCompetenciaUniversal();
        if (OperacionesBD.guardar(cu)) {
            Mensaje.datosGuardados();
            actualizaTablaUnivers();
            nuevaCompetenciaUniversal();
            poneEnablesUniv(false);
        } else {
            Mensaje.datosNoGuardados();
        }
          }else {
            JOptionPane.showMessageDialog(null, "La competencia ingresada ya existe");
        }
    }

    public void actualizaTablaUnivers() {
        listarCompetenciasUniversales();
        modeloTablaCompUniversales();
    }

    public void listarCompetenciasUniversales() {
        universales = (ArrayList<CompetenciaUniversal>) OperacionesBD.listar("CompetenciaUniversal");
    }

    public void modeloTablaCompUniversales() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Destreza");
        dtm.addColumn("Alta");
        dtm.addColumn("Media");
        dtm.addColumn("Baja");
        if (!universales.isEmpty()) {
            for (CompetenciaUniversal c : universales) {
                Object o[] = new Object[4];
                o[0] = c.getNombreDestrezaUniv();
                o[1] = c.getAltaUniv();
                o[2] = c.getMediaUniv();
                o[3] = c.getBajaUniv();
                dtm.addRow(o);
            }
        }
        po.getTblCompetenciasUniversales().setModel(dtm);
    }

    public boolean isRowSelectedCompUniver() {
        if (po.getTblCompetenciasUniversales().getSelectedRow() != -1) {
            return true;
        }
        return false;
    }

    public void getCompetenciaUniversal() {
        cu = universales.get(po.getTblCompetenciasUniversales().getSelectedRow());
        poneEnablesUniv(true);
        po.getTxtDestrezaCompUniv().setText(cu.getNombreDestrezaUniv());
        po.getTxtAltaCompUniv().setText(cu.getAltaUniv());
        po.getTxtMediaCompUniv().setText(cu.getMediaUniv());
        po.getTxtBajaCompUniv().setText(cu.getBajaUniv());
        po.getBtnGuardarCompetenciaUniversal().setText("Modificar");
    }

    public void editarCompetenciaUniversal() {
        setCompetenciaUniversal();
        if (OperacionesBD.modificar(cu)) {
            Mensaje.datosModificados();
            actualizaTablaUnivers();
            nuevaCompetenciaUniversal();
            poneEnablesUniv(false);
            po.getBtnGuardarCompetenciaUniversal().setText("Guardar");
        } else {
            Mensaje.datosNoModificados();
        }
    }

    public void eliminarCompetenciaUniversal() {
        cu = universales.get(po.getTblCompetenciasUniversales().getSelectedRow());
        if (OperacionesBD.eliminar(cu, cu.getId())) {
            Mensaje.datosEliminados();
            actualizaTablaUnivers();
        } else {
            Mensaje.datosNoEliminados();
        }
    }
    
    public void imprimeReporteUniversales(){
         try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/controlador/reportes/ReporteCompUniv.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(universales));
            JasperViewer vista = new JasperViewer(jasperPrint, false);
            if (!vista.isActive()) {
                vista.setVisible(true);
            }
        } catch (JRException ex) {
            Logger.getLogger(ControladorCompetenciasUniversales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
