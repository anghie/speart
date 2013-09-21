/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.servicios;

import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import modelo.recordatorio.Recordatorio;
import vista.FrmPrincipal;
import vista.modelo.Calendario;
import vista.modelo.Mensaje;
import vista.paneles.servicios.DialogoCalendarioRecor;
import vista.paneles.servicios.DialogoCreaRecordatorio;

/**
 *
 * @author 
 */
public class ControladorRecordatorio {

    private DialogoCalendarioRecor ps;
    private DialogoCreaRecordatorio dcr;
    private Recordatorio recordatorio;
    Calendar fecha;
    public static ArrayList<Recordatorio> recordatorios;

    public ControladorRecordatorio(DialogoCalendarioRecor  ps) {
        this.ps = ps;
    }

    public ControladorRecordatorio(DialogoCreaRecordatorio dcr) {
        this.dcr = dcr;
    }

    public void abreDialogoRecord() {
        int f = ps.getTblDiasMes().getSelectedRow();
        int c = ps.getTblDiasMes().getSelectedColumn();
        String dia = String.valueOf(ps.getTblDiasMes().getValueAt(f, c));
        if (!dia.isEmpty() && !dia.equals("null")) {
            if (c != 0) {
                Calendar seleccionado = new GregorianCalendar(Calendario.anioTemporal, Calendario.mesTemporal, Integer.parseInt(dia));
                Calendar actual = new GregorianCalendar(Calendario.anioActual, Calendario.mesActual, Calendario.diaActualMes);
                if (seleccionado.equals(actual) || seleccionado.after(actual)) {
                    dcr = new DialogoCreaRecordatorio(null, true, seleccionado);
                    dcr.setVisible(true);
                } else if (seleccionado.before(actual)) {
                    JOptionPane.showMessageDialog(null, "No se puede asignar "
                            + "recordatorios a fechas anteriores a la actual",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede asignar un recordatorio a los domingos");
            }
        } else {
            Mensaje.campoVacio("Dia");
        }
    }

    public boolean hayVacios() {
        if (dcr.getTxtDescripcion().getText().isEmpty()
                || dcr.getTxtEvento().getText().isEmpty()
                || dcr.getTxtFecha().getText().isEmpty()) {
            return true;
        }
        return false;
    }

    public void guardaRecordatorio() {
        setRecordatorio();
        if (OperacionesBD.guardar(recordatorio)) {
            Mensaje.datosGuardados();
            listarRecordatorios();
            dcr.dispose();
        } else {
            Mensaje.datosNoGuardados();
        }
    }

    public void setRecordatorio() {
        fecha = Calendar.getInstance();
        fecha.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH),
                fecha.get(Calendar.DAY_OF_MONTH),
                Integer.parseInt(String.valueOf(dcr.getSpHora().getValue())),
                Integer.parseInt(String.valueOf(dcr.getSpMinuto().getValue())));
        int num = recordar();
        fecha.add(Calendar.MINUTE, -num);
        recordatorio = new Recordatorio();
        recordatorio.setFechaHora(fecha);
        recordatorio.setTitulo(dcr.getTxtEvento().getText());
        recordatorio.setDetalle(dcr.getTxtDescripcion().getText());
        recordatorio.setCumplido(false);
        recordatorio.setRecordar(num);
        recordatorio.setUsuario(FrmPrincipal.userLogueado);
    }

    private int recordar() {
        int r = 0;
        if (dcr.getCbRecord().getSelectedIndex() == 0) {
            r = 5;
        } else if (dcr.getCbRecord().getSelectedIndex() == 1) {
            r = 10;
        } else if (dcr.getCbRecord().getSelectedIndex() == 2) {
            r = 30;
        } else if (dcr.getCbRecord().getSelectedIndex() == 3) {
            r = 60;
        }
        return r;
    }

    public static void listarRecordatorios() {
//        recordatorios = (ArrayList<Recordatorio>) OperacionesBD.listar("Recordatorio");
        recordatorios = (ArrayList<Recordatorio>) OperacionesBD.listarconCondicion("Recordatorio", "usuario_idPersona", String.valueOf(FrmPrincipal.userLogueado.getIdPersona()));
    }
}
