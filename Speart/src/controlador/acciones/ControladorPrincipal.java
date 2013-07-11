package controlador.acciones;

import controlador.acciones.proceso.ControladorEscogeActividades;
import controlador.acciones.usuario.ControladorUsuario;
import controlador.basedatos.OperacionesBD;
import vista.FrmPrincipal;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import modelo.proceso.Actividad;
import modelo.proceso.Rol;
import modelo.usuario.AlgoritmoAES;
import modelo.usuario.Usuario;
import vista.DialogLogin;
import vista.DialogUsuaroisInforme;
import vista.modelo.OperacionesVarias;
import vista.paneles.usuario.DialogInformeActiv;

public class ControladorPrincipal {

    private FrmPrincipal frm;
    public static String tipoUs;
    public static Rol rol;

    public ControladorPrincipal(FrmPrincipal frm) {
        this.frm = frm;
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
        for (Usuario us : ControladorUsuario.usuarios) {
            if (user.equals(us.getLogin())) {
                String st = us.getClave();
                String e = st.substring(st.length() - 16, st.length());
                AlgoritmoAES a = new AlgoritmoAES(e.getBytes());
                String r = a.encriptar(clave) + e;
                if (r.equals(st)) {
                    FrmPrincipal.userLogueado = us;
                    tipoUs = us.getRol().getTipo();
                    existe = true;
                }
            }
        }
        return existe;
    }

    public void cierraSesion() {
        limpiarPanelPrincipal();
        tipoUs = null;
        ControladorPermisos.permisoInvitado();
        frm.ponePermisos();
    }
    public void escogeUsuario(){
        new DialogUsuaroisInforme(frm, true).setVisible(true);
    }

    public static void abreInformeActividades() {
        int r = rol.getIdRol();//id del rol
        ArrayList<Actividad> ac = (ArrayList<Actividad>) OperacionesBD.listarconCondicion("Actividad", "rol_idRol", String.valueOf(r));
        ControladorEscogeActividades.actividadesAsignadas = new ArrayList<>();
        ControladorEscogeActividades.actividadesDisponibles = new ArrayList<>();
        for (Actividad act : ac) {
            if (act.isParaEvaluacion()) {
                ControladorEscogeActividades.actividadesAsignadas.add(act);
            } else {
                ControladorEscogeActividades.actividadesDisponibles.add(act);
            }
        }
        new DialogInformeActiv(null, true).setVisible(true);
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
}
