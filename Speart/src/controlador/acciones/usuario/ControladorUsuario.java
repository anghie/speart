package controlador.acciones.usuario;

import controlador.acciones.ControladorPrincipal;
import controlador.acciones.proceso.ControladorEscogeActividades;
import javax.swing.*;
import vista.paneles.usuario.PnlUsuario;
import vista.modelo.*;
import modelo.usuario.*;
import controlador.basedatos.OperacionesBD;
import controlador.reportes.UsuarioRol;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import modelo.proceso.Actividad;
import modelo.proceso.Rol;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.FrmPrincipal;
import vista.paneles.usuario.DialogCompetTecnica;
import vista.paneles.usuario.DialogConocUsuario;
import vista.paneles.usuario.DialogEscogeActividades;
import vista.paneles.usuario.DialogQuejas;
import vista.paneles.usuario.DialogUsuarios;

public class ControladorUsuario {

    private final PnlUsuario pu;
    private Usuario usuario;
    private Rol rol;
    private Respuesta_Usuario preg_userrec;
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Rol> roles;
    private AlgoritmoAES aes;

    public ControladorUsuario(PnlUsuario pu) {
        this.pu = pu;
    }

    //*****************************************************************
    //*             ACCIONES PARA EL TAB USUARIOS                     *                
    //*****************************************************************
    /**
     * Método para verificar si existen campos vacios
     *
     * @return true Si hay campos vacios false Si no hay campos Vacios
     *
     */
    public boolean verificaVacios() {
        if (pu.getTxtCedula().getText().isEmpty()
                || pu.getTxtNombres().getText().isEmpty()
                || pu.getTxtApellidos().getText().isEmpty()
                || pu.getTxtCargo().getText().isEmpty()
                || pu.getTxtProfesion().getText().isEmpty()
                || pu.getTxtUsuario().getText().isEmpty()
                || String.valueOf(pu.getTxtClave().getPassword()).isEmpty()
                || String.valueOf(pu.getTxtConfirm().getPassword()).isEmpty()) {
            colorErroresCreaUsuario();
            return true;
        } else {
            colorErroresCreaUsuario();
            return false;
        }
    }

    public void colorErroresCreaUsuario() {
        ControladorPrincipal.coloreaErroresTxt(pu.getPnlDatosPers());
        ControladorPrincipal.coloreaErroresTxt(pu.getPnlDatosEmpleo());
        ControladorPrincipal.coloreaErroresTxt(pu.getPnlDatosAcceso());
        ControladorPrincipal.coloreaErroresPsw(pu.getPnlDatosAcceso());
    }

    /**
     * Método para verificar si la cedula ingresada es la correcta
     *
     * @return true Si la cedula es correcta
     * @return false Si la cedula no es correcta
     *
     */
    private boolean verificaCedula(String ced) {
        return OperacionesVarias.validadorDeCedula(ced);
    }

    /**
     * Método que limpia todos los campos del panel
     *
     */
    private void limpiaCampos() {
        pu.getTxtCedula().setText("");
        pu.getTxtNombres().setText("");
        pu.getTxtApellidos().setText("");
        pu.getTxtProfesion().setText("");
        pu.getTxtUsuario().setText("");
        pu.getTxtClave().setText("");
        pu.getTxtConfirm().setText("");
        pu.getTxtCargo().setText("");
        pu.getTxtHExt().setText("");
        pu.getTxtHLab().setText("");
        pu.getTxtRem().setText("");
        pu.getTxtEmail().setText("");
        pu.getTxtRespuestapregunta().setText("");
    }

    /**
     * Metodo para el guardado de un usuario en la bd
     *
     */
    public void guardaUsuario() {
        if (verificaCedula(pu.getTxtCedula().getText())) {
            String clave = String.valueOf(pu.getTxtClave().getPassword());
            if (clave.length() > 6) {
                String confirm = String.valueOf(pu.getTxtConfirm().getPassword());
                if (clave.equals(confirm)) {
                    usuario = new Usuario();
                    setUsuario();
                    rol = new Rol();
                    setRol();
                    usuario.setRol(rol);
                    if (OperacionesBD.guardar(usuario)) {
                        Mensaje.datosGuardados();
                        limpiaCampos();
                    } else {
                        Mensaje.datosNoGuardados();
                    }

                } else {
                    Mensaje.clavesNoCoinciden();
                }
            }else{
                JOptionPane.showMessageDialog(null, "La clave debe contener al menos 6 caracteres");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cédula incorrecta", "La cédula ingresada es incorrecta", JOptionPane.ERROR_MESSAGE);
            pu.getTxtCedula().setBorder(new LineBorder(Color.red));
        }
    }

    private void Resuser() {

        String tipopr = String.valueOf(pu.getCbPreguntaseguridad().getSelectedItem());
        Pregunta_Recuperar idpreg = (Pregunta_Recuperar) OperacionesBD.buscar("Pregunta_Recuperar", "pregunta", tipopr);
        ArrayList<Respuesta_Usuario> numelem = (ArrayList<Respuesta_Usuario>) OperacionesBD.listar("Usuario");


        //preg_userrec.setIdpersona(useraux.getIdPersona());

        preg_userrec.setIdpreguntarecuperar(idpreg.getIdpreguntarecuperar());
        //
        preg_userrec.setIdrespuestarecuperar(numelem.size() + 1);

        preg_userrec.setRespuesta(pu.getTxtRespuestapregunta().getText());
    }

    private void setUsuario() {
        usuario.setCedula(pu.getTxtCedula().getText());
        usuario.setNombre(pu.getTxtNombres().getText());
        usuario.setApellidos(pu.getTxtApellidos().getText());
        usuario.setProfesion(pu.getTxtProfesion().getText());
        usuario.setHabilitado(true);
        usuario.setEvaluacionActivada(false);
        usuario.setLogin(pu.getTxtUsuario().getText());
        usuario.setEmail(pu.getTxtEmail().getText());
        String tipopre = String.valueOf(pu.getCbPreguntaseguridad().getSelectedItem());
        Pregunta_Recuperar idpre = (Pregunta_Recuperar) OperacionesBD.buscar("Pregunta_Recuperar", "pregunta", tipopre);
        usuario.setIdpreguntarecuperar(idpre.getIdpreguntarecuperar());

        String str = OperacionesVarias.generaAleatoria(16);
        aes = new AlgoritmoAES(str.getBytes());
        usuario.setClave(aes.encriptar(String.valueOf(pu.getTxtClave().getPassword())) + str);
    }

    private void setRol() {
        String t = String.valueOf(pu.getCbRol().getSelectedItem());
        System.out.println(t);
        rol.setTipo(t);
        rol.sethLab(Integer.parseInt(pu.getTxtHLab().getText()));
        rol.sethExt(Integer.parseInt(pu.getTxtHExt().getText()));
        rol.setRem(Integer.parseInt(pu.getTxtRem().getText()));
        rol.setCargo(pu.getTxtCargo().getText());
        if (t.equals("Servidor") || t.equals("Jefe")) {
            rol.setEvaluable(true);
        } else {
            rol.setEvaluable(false);
        }
        rol.setEstadoEvaluacion("NoEvaluado");

    }
    //*****************************************************************
    //*           ACCIONES PARA EL TAB LISTA DE USUARIOS              *                
    //*****************************************************************

    /**
     * Lista los usuarios contenidos en la tabla Usuario de la base de datos
     */
    public static void listar() {
        usuarios = (ArrayList<Usuario>) OperacionesBD.listar("Usuario");
        roles = (ArrayList<Rol>) OperacionesBD.listar("Rol");
    }

    private void modeloTabla() {
        DefaultTableModel dtm = new DefaultTableModel() {
            //Este metodo sirve para devolver el tipo de valores en la tabla si devuelve booleanos se pone un checkbox
            @Override
            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();//Devuelve un valor de la fila 0 columna c
            }
        };
        dtm.addColumn("Cedula");
        dtm.addColumn("Nombres y Apellidos");
        dtm.addColumn("Profesion");
        dtm.addColumn("Habilitado");
        for (Usuario u : usuarios) {
            Object[] obj = new Object[4];
            obj[0] = u.getCedula();
            obj[1] = u.getNombre() + " " + u.getApellidos();
            obj[2] = u.getProfesion();
            obj[3] = u.isHabilitado();
            System.out.println(u.getNombre() + " " + u.getApellidos() + " " + u.getRol().getTipo());
            dtm.addRow(obj);
        }
        pu.getTblUsuarios().setModel(dtm);
        pu.getTblUsuarios().getColumnModel().getColumn(0).setPreferredWidth(40);
        pu.getTblUsuarios().getColumnModel().getColumn(1).setPreferredWidth(200);
        pu.getTblUsuarios().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    /**
     * Actualiza los campos de la Tabla Usuarios
     */
    public void actualizaTabla() {
        listar();
        modeloTabla();
        pu.getTblUsuarios().validate();
    }

    /**
     * Verifica si una fila está seleccionada en la tabla
     *
     * @return true si hay una fila seleccionada false si no hay una fila
     * seleccionada
     */
    public boolean isRowSelected() {
        return pu.getTblUsuarios().getSelectedRow() != -1;
    }

    public void celdaSeleccionada() {
        int f = pu.getTblUsuarios().getSelectedRow();
        boolean escogido = (boolean) pu.getTblUsuarios().getValueAt(f, 3);
        pu.getTblUsuarios().setValueAt(!escogido, f, 3);//se resetea al estado anterior a escogido
        int n = 0;
        if (!escogido) {
            n = JOptionPane.showConfirmDialog(null, "Desea deshabilitar el usuario", "Deshabilitar", JOptionPane.YES_NO_OPTION);
        } else {
            n = JOptionPane.showConfirmDialog(null, "Desea habilitar el usuario", "Habilitar", JOptionPane.YES_NO_OPTION);
        }
        if (n == JOptionPane.YES_OPTION) {
            this.usuario = usuarios.get(pu.getTblUsuarios().getSelectedRow());
            if (!usuario.equals(FrmPrincipal.userLogueado)) {
                usuario.setHabilitado(escogido);
                if (OperacionesBD.modificar(usuario)) {
                    if (!escogido) {
                        pu.getTblUsuarios().setValueAt(escogido, f, 3);
                        JOptionPane.showMessageDialog(null, "Se ha deshabilitado el usuario");
                    } else {
                        pu.getTblUsuarios().setValueAt(escogido, f, 3);
                        JOptionPane.showMessageDialog(null, "Se ha habilitado el usuario");
                    }
                } else {
                    if (!escogido) {
                        JOptionPane.showMessageDialog(null, "No se pudo deshabilitar el usuario");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo habilitar el usuario");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No puede deshabilitarse a si mismo");
            }
        }

    }

    public void getUsuario() {
        pu.getTxtCedulaModif().setText(usuario.getCedula());
        pu.getTxtApelModif().setText(usuario.getApellidos());
        pu.getTxtNomModif().setText(usuario.getNombre());
        pu.getTxtProfModif().setText(usuario.getProfesion());
        pu.getTxtEmailModif().setText(usuario.getEmail());
    }

    public void getRol() {
        pu.getTxtCargoModif().setText(rol.getCargo());
        pu.getTxtHExtModif().setText(String.valueOf(rol.gethExt()));
        pu.getTxtHLabModif().setText(String.valueOf(rol.gethLab()));
        pu.getTxtRemModif().setText(String.valueOf(rol.getRem()));
    }

    /**
     * Método para verificar si existen campos vacios
     *
     * @return true Si hay campos vacios false Si no hay campos Vacios
     *
     */
    public boolean verificaVaciosModif() {
        if (pu.getTxtNomModif().getText().isEmpty()
                || pu.getTxtApelModif().getText().isEmpty()
                || pu.getTxtCargoModif().getText().isEmpty()
                || pu.getTxtProfModif().getText().isEmpty()
                || pu.getTxtCedulaModif().getText().isEmpty()) {
            ControladorPrincipal.coloreaErroresTxt(pu.getPnlAccionesModificar());
            return true;
        } else {
            ControladorPrincipal.coloreaErroresTxt(pu.getPnlAccionesModificar());
            return false;
        }
    }

    /* Método que limpia todos los campos del panel modifUsuarios 
     **/
    public void limpiaCamposModif() {
        pu.getTxtNomModif().setText("");
        pu.getTxtCedulaModif().setText("");
        pu.getTxtApelModif().setText("");
        pu.getTxtProfModif().setText("");
        pu.getTxtCargoModif().setText("");
        pu.getTxtHExtModif().setText("");
        pu.getTxtHLabModif().setText("");
        pu.getTxtRemModif().setText("");
        pu.getTxtEmailModif().setText("");
    }

    /**
     * Metodo para asignar los datos al usuario a modificar
     */
    public void modificarUsuario() {
        if (verificaCedula(pu.getTxtCedulaModif().getText())) {
            usuario.setCedula(pu.getTxtCedulaModif().getText());
            usuario.setNombre(pu.getTxtNomModif().getText());
            usuario.setApellidos(pu.getTxtApelModif().getText());
            usuario.setProfesion(pu.getTxtProfModif().getText());
            usuario.setEmail(pu.getTxtEmailModif().getText());
                    
            rol.setCargo(pu.getTxtCargoModif().getText());
            rol.sethExt(Integer.parseInt(pu.getTxtHExtModif().getText()));
            rol.sethLab(Integer.parseInt(pu.getTxtHLabModif().getText()));
            rol.setRem(Integer.parseInt(pu.getTxtRemModif().getText()));
            usuario.setRol(rol);
            if (OperacionesBD.modificar(usuario)) {
                Mensaje.datosModificados();
                limpiaCamposModif();
                pu.poneHabilitados(false);
                actualizaTabla();
            } else {
                Mensaje.datosNoModificados();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cedula incorrecta", "La cédula ingresada es incorrecta", JOptionPane.ERROR_MESSAGE);
            pu.getTxtCedulaModif().setBorder(new LineBorder(Color.red));
        }
    }

    /**
     * Método que cambia el texto al boton deshabilitar y llena los objetos
     * usuario y rol de acuerdo a lo seleccionado en la tabla
     */
    public void cambiaTextoBtnDeshab() {
        this.usuario = usuarios.get(pu.getTblUsuarios().getSelectedRow());
        this.rol = roles.get(pu.getTblUsuarios().getSelectedRow());
        if (usuario.isHabilitado()) {
            pu.getBtnDeshabilitar().setText("Deshabilitar");
        } else {
            pu.getBtnDeshabilitar().setText("Habilitar");
        }
    }

    /**
     * Deshabilita un usuario de la bd para que no pueda iniciar sesión
     */
    public void desHabilitarUsuario() {
        int n;
        if (usuario.isHabilitado()) {
            n = JOptionPane.showConfirmDialog(null, "¿Desea deshabilitar el usuario?", "Deshabilitar", JOptionPane.YES_NO_OPTION);
        } else {
            n = JOptionPane.showConfirmDialog(null, "¿Desea habilitar el usuario?", "Habilitar", JOptionPane.YES_NO_OPTION);
        }
        if (n == JOptionPane.YES_OPTION) {
            if (!usuario.equals(FrmPrincipal.userLogueado)) {
                usuario.setHabilitado(!usuario.isHabilitado());
                usuario.setRol(rol);
                if (OperacionesBD.modificar(usuario)) {
                    if (usuario.isHabilitado()) {
                        JOptionPane.showMessageDialog(null, "Se ha habilitado el usuario", "Habilitar", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Se ha deshabilitado el usuario", "Deshabilitar", JOptionPane.INFORMATION_MESSAGE);
                    }
                    actualizaTabla();
                } else {
                    if (usuario.isHabilitado()) {
                        JOptionPane.showMessageDialog(null, "Error al deshabilitar el usuario", "Deshabilitar", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Errol al habilitar el usuario", "Habilitar", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No puede deshabilitar al usuario administrador");
            }
        }
    }

    public void abreDialogUsuarios() {
        new DialogUsuarios(null, true, usuario).setVisible(true);
    }

    public void abreDialogConocUsuario() {
        if (isRowSelected()) {
            rol = usuarios.get(pu.getTblUsuarios().getSelectedRow()).getRol();
            new DialogConocUsuario(null, true, rol).setVisible(true);
        } else {
            Mensaje.filaNoSeleccionada();
        }
    }

    public void abreDialogCompetTecnica() {
        if (isRowSelected()) {
            rol = usuarios.get(pu.getTblUsuarios().getSelectedRow()).getRol();
            new DialogCompetTecnica(null, true, rol).setVisible(true);
        } else {
            Mensaje.filaNoSeleccionada();
        }
    }

    public void abreDialogEscogeActividades() {
        if (isRowSelected()) {
            int r = usuarios.get(pu.getTblUsuarios().getSelectedRow()).getRol().getIdRol();
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
            new DialogEscogeActividades(null, true).setVisible(true);
        } else {
            Mensaje.filaNoSeleccionada();
        }
    }

    public void abreDialogQuejas() {
        if (isRowSelected()) {
            rol = usuarios.get(pu.getTblUsuarios().getSelectedRow()).getRol();
            new DialogQuejas(null, true, rol).setVisible(true);
        } else {
            Mensaje.filaNoSeleccionada();
        }
    }

    public void imprimeUsuarios() {
        ArrayList<UsuarioRol> ur = new ArrayList<>();
        for (Usuario u : usuarios) {
            UsuarioRol us = new UsuarioRol(u.getCedula(), u.getApellidos() + " "
                    + u.getNombre(), u.getRol().getTipo(), u.getProfesion());
            ur.add(us);
        }
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/controlador/reportes/reporteUsuarios.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(ur));
            JasperViewer vista = new JasperViewer(jasperPrint, false);
            if (!vista.isActive()) {
                vista.setVisible(true);
            }
        } catch (JRException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
