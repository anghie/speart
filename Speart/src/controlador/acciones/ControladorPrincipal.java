package controlador.acciones;

import controlador.acciones.usuario.ControladorUsuario;
import controlador.basedatos.OperacionesBD;
import vista.FrmPrincipal;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import modelo.evaluacion.PeriodoEvaluacion;
import modelo.proceso.Rol;
import modelo.usuario.AlgoritmoAES;
import modelo.usuario.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.DialogLogin;

import vista.modelo.OperacionesVarias;

public class ControladorPrincipal {

    private FrmPrincipal frm;
    public static String tipoUs;
    public static Rol rol;
    private static ControladorPrincipal cp = null;
    public static int esInhab = 0;
    public static ArrayList<PeriodoEvaluacion> fechaeval;
    public static boolean clavemal;
    public static boolean faltanCinco = false;
    public static boolean estaEnEval = false;

    private ControladorPrincipal(FrmPrincipal frm) {
        this.frm = frm;
    }

    public synchronized static ControladorPrincipal getInstance(FrmPrincipal frm) {
        if (cp == null) {
            cp = new ControladorPrincipal(frm);
        }
        return cp;
    }

    /*Método que limpia el Panel principal de la ventana principal*/
    public void limpiarPanelPrincipal() {
        frm.getPnlMedio().removeAll();
        frm.getPnlMedio().add(frm.getPnlImagen(), BorderLayout.CENTER);
        frm.getPnlMedio().updateUI();
    }
    /*Método que ubica un panel en el centro de la pantalla principal*/

    public void ponePanel(JPanel p) {

        frm.getPnlMedio().removeAll();
        frm.getPnlMedio().add(p, BorderLayout.CENTER);
        frm.getPnlMedio().updateUI();

    }

    public void abreLogin() {
        new DialogLogin(frm, true).setVisible(true);
    }

    public static boolean datosCorrectos(String user, String clave) {
        boolean existe = false;
        clavemal = false;
        for (Usuario us : ControladorUsuario.usuarios) {
            if (user.equals(us.getLogin()) && us.isHabilitado()) {
                String st = us.getClave();
                String e = st.substring(st.length() - 16, st.length());
                AlgoritmoAES a = new AlgoritmoAES(e.getBytes());
                String r = a.encriptar(clave) + e;
                if (r.equals(st)) {
                    FrmPrincipal.userLogueado = us;
                    tipoUs = us.getRol().getTipo();
                    System.out.println(tipoUs);
                    existe = true;
                } else {
                    clavemal = true;
                }
            } else if (user.equals(us.getLogin()) && !us.isHabilitado()) {
                esInhab = 1;
            }
        }
        return existe;
    }

    public void cierraSesion() {
        limpiarPanelPrincipal();
        tipoUs = null;
        ControladorPermisos.permisoInvitado();
        frm.ponePermisos();
        pasarGarbageCollector();
    }

    public static boolean verificaClave(String claveAnt) {
        String st = FrmPrincipal.userLogueado.getClave();
        String e = st.substring(st.length() - 16, st.length());
        AlgoritmoAES a = new AlgoritmoAES(e.getBytes());
        String r = a.encriptar(claveAnt) + e;
        if (r.equals(st)) {
            return true;
        } else {
            return false;
        }
    }

    public static void cambiaClave(String claveNva) {
        Usuario u = FrmPrincipal.userLogueado;
        String str = OperacionesVarias.generaAleatoria(16);
        AlgoritmoAES a = new AlgoritmoAES(str.getBytes());
        u.setClave(a.encriptar(claveNva) + str);
        if (OperacionesBD.modificar(u)) {
            JOptionPane.showMessageDialog(null, "Clave modificada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar clave");
        }
    }

    public static void coloreaErroresTxt(JPanel conten) {
        JTextField tx = new JTextField();
        Border b = tx.getBorder();
        for (Component c : conten.getComponents()) {
            if (c.getClass().equals(JTextField.class)) {
                JTextField t = (JTextField) c;
                if (t.getText().isEmpty()) {
                    t.setBorder(new EtchedBorder(Color.red, Color.pink));
                } else {
                    t.setBorder(b);
                }

            }
        }
        tx = null;
    }

    public static void coloreaErroresPsw(JPanel conten) {
        JPasswordField tx = new JPasswordField();
        Border b = tx.getBorder();
        for (Component c : conten.getComponents()) {
            if (c.getClass().equals(JPasswordField.class)) {
                JPasswordField t = (JPasswordField) c;
                if (String.valueOf(t.getPassword()).isEmpty()) {
                    t.setBorder(new EtchedBorder(Color.red, Color.pink));
                } else {
                    t.setBorder(b);
                }
            }
        }
        tx = null;
    }

    public static void coloreaErroresATxt(JPanel conten) {
        JTextArea tx = new JTextArea();
        Border b = tx.getBorder();
        for (Component c : conten.getComponents()) {
            if (c.getClass().equals(JScrollPane.class)) {
                JScrollPane p = (JScrollPane) c;
                if (p.getViewport().getComponent(0).getClass().equals(JTextArea.class)) {
                    JTextArea a = (JTextArea) p.getViewport().getComponent(0);
                    if (a.getText().isEmpty()) {
                        a.setBorder(new EtchedBorder(Color.red, Color.pink));
                    } else {
                        a.setBorder(b);
                    }
                }
            }
        }
    }

    public void pasarGarbageCollector() {
        Runtime garbage = Runtime.getRuntime();
//        System.out.println("Memoria antes de pasar garbage: " + garbage.freeMemory());
        garbage.gc();
//        System.out.println("Memoria despues de pasar garbage: " + garbage.freeMemory());
    }

//    public boolean evalActiv(){
//        
//    }
    public void reporteUsuarios() {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) OperacionesBD.listar("Usuario");

        //En caso de que hayan parametros, los parametros son unicos
//        Usuario u = null;
//        if (!usuarios.isEmpty()) {
//            u = usuarios.get(0);
//        } else {
//            u = new Usuario();
//        }
//
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("NOMBRE", u.getNombre());
//        parametros.put("TIPO", u.getRol().getTipo());
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("ReporteUsuarios.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(usuarios));
            JasperViewer vista = new JasperViewer(jasperPrint, false);
            if (!vista.isActive()) {
                vista.setVisible(true);
            }
        } catch (JRException ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listarFechasEval() {
        fechaeval = (ArrayList<PeriodoEvaluacion>) OperacionesBD.listar("PeriodoEvaluacion");
        if (fechaeval.isEmpty() || fechaeval == null) {
            fechaeval = new ArrayList<>();
        }
    }

    public static boolean verificaPeriodoEvaluacion() {
        fechaeval = new ArrayList<>();
        listarFechasEval();
        boolean entre = false;
        Calendar hoy = Calendar.getInstance();
        for (PeriodoEvaluacion pe : fechaeval) {
            Calendar inicio = pe.getFechaInicio();
            Calendar fin = pe.getFechaFin();
//            System.out.println("inicio: "+inicio.getTime());
//            System.out.println("fin"+fin.getTime());
            if ((hoy.getTimeInMillis() > inicio.getTimeInMillis() && hoy.getTimeInMillis() < fin.getTimeInMillis())//si hoy está entre inicio y fin
                    || (hoy.getTimeInMillis() == inicio.getTimeInMillis())) {//si hoy es igual a inicio
                entre = true;
            }
            if ((hoy.get(Calendar.MINUTE) < fin.get(Calendar.MINUTE))
                    && (fin.get(Calendar.MINUTE) - hoy.get(Calendar.MINUTE)) == 5) {
                ControladorPrincipal.faltanCinco = true;
            }
        }
        return entre;
    }
}
