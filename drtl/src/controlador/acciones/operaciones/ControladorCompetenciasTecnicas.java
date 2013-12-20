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
import modelo.operaciones.CompetenciaTecnica;
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
public class ControladorCompetenciasTecnicas {

    private PnlOperaciones po;
    private CompetenciaTecnica ct;
    private ArrayList<CompetenciaTecnica> competencias;

    public ControladorCompetenciasTecnicas(PnlOperaciones po) {
        this.po = po;
    }

    public void poneEnables(boolean enable) {
        po.getTxtAlta().setEnabled(enable);
        po.getTxtBaja().setEnabled(enable);
        po.getTxtMedia().setEnabled(enable);
        po.getTxtDestreza().setEnabled(enable);
    }

    public boolean hayVacios() {
        if (po.getTxtDestreza().getText().isEmpty()
                || po.getTxtAlta().getText().isEmpty()
                || po.getTxtMedia().getText().isEmpty()
                || po.getTxtBaja().getText().isEmpty()) {
            ControladorPrincipal.coloreaErroresTxt(po.getPnlCompTecPuesto());
            ControladorPrincipal.coloreaErroresATxt(po.getPnlCompTecPuesto());
            return true;
        } else {
            ControladorPrincipal.coloreaErroresTxt(po.getPnlCompTecPuesto());
            ControladorPrincipal.coloreaErroresATxt(po.getPnlCompTecPuesto());
            return false;
        }
    }

    public void nuevaCompetenciaTecnica() {
        poneEnables(true);
        po.getTxtAlta().setText("");
        po.getTxtBaja().setText("");
        po.getTxtMedia().setText("");
        po.getTxtDestreza().setText("");
    }

    public void setCompetenciaTecnica() {
        ct.setNombreDestrezaTec(po.getTxtDestreza().getText());
        ct.setAltaTec(po.getTxtAlta().getText());
        ct.setMediaTec(po.getTxtMedia().getText());
        ct.setBajaTec(po.getTxtBaja().getText());
        ct.setParaEvaluacionCT(false);
    }

    public void guardaCompetenciaTecnica() {

        if (!OperacionesBD.existe("CompetenciaTecnica", "nombreDestrezaTec", po.getTxtDestreza().getText())) {
            ct = new CompetenciaTecnica();
            setCompetenciaTecnica();
            if (OperacionesBD.guardar(ct)) {
                Mensaje.datosGuardados();
                actualizaTabla();
                nuevaCompetenciaTecnica();
                poneEnables(false);
            } else {
                Mensaje.datosNoGuardados();
            }
        }else {
            JOptionPane.showMessageDialog(null, "La competencia ingresada ya existe");
        }
    }

    public void actualizaTabla() {
        listarCompetenciasTecnicas();
        modeloTablaCompTec();
    }

    public void listarCompetenciasTecnicas() {
        competencias = (ArrayList<CompetenciaTecnica>) OperacionesBD.listar("CompetenciaTecnica");
    }

    public void modeloTablaCompTec() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Destreza");
        dtm.addColumn("Alta");
        dtm.addColumn("Media");
        dtm.addColumn("Baja");
        if (!competencias.isEmpty()) {
            for (CompetenciaTecnica c : competencias) {
                Object o[] = new Object[4];
                o[0] = c.getNombreDestrezaTec();
                o[1] = c.getAltaTec();
                o[2] = c.getMediaTec();
                o[3] = c.getBajaTec();
                dtm.addRow(o);
            }
        }
        po.getTblCompetencias().setModel(dtm);
    }

    public boolean isRowSelectedCompTec() {
        if (po.getTblCompetencias().getSelectedRow() != -1) {
            return true;
        }
        return false;
    }

    public void getCompetenciaTecnica() {
        ct = competencias.get(po.getTblCompetencias().getSelectedRow());
        poneEnables(true);
        po.getTxtDestreza().setText(ct.getNombreDestrezaTec());
        po.getTxtAlta().setText(ct.getAltaTec());
        po.getTxtMedia().setText(ct.getMediaTec());
        po.getTxtBaja().setText(ct.getBajaTec());
        po.getBtnGuardarCompetencia().setText("Modificar");
    }

    public void editarCompetenciaTecnica() {
        setCompetenciaTecnica();
        if (OperacionesBD.modificar(ct)) {
            Mensaje.datosModificados();
            actualizaTabla();
            nuevaCompetenciaTecnica();
            poneEnables(false);
            po.getBtnGuardarCompetencia().setText("Guardar");
        } else {
            Mensaje.datosNoModificados();
        }
    }

    public void eliminarCompetenciaTecnica() {
        ct = competencias.get(po.getTblCompetencias().getSelectedRow());
        if (OperacionesBD.eliminar(ct, ct.getId())) {
            Mensaje.datosEliminados();
            actualizaTabla();
        } else {
            Mensaje.datosNoEliminados();
        }
    }
    
    public void imprimeReporteTecnicas(){
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/controlador/reportes/ReporteCompTec.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(competencias));
            JasperViewer vista = new JasperViewer(jasperPrint, false);
            if (!vista.isActive()) {
                vista.setVisible(true);
            }
        } catch (JRException ex) {
            Logger.getLogger(ControladorCompetenciasTecnicas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
