/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.acciones.Constantes;
import controlador.acciones.ControladorPermisos;
import controlador.acciones.ControladorPrincipal;
import controlador.acciones.servicios.ControladorRecordatorio;
import controlador.acciones.usuario.ControladorUsuario;
import controlador.basedatos.OperacionesBD;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import modelo.pregunta.Pregunta;
import modelo.usuario.AlgoritmoAES;
import modelo.usuario.Pregunta_Recuperar;
import modelo.usuario.Respuesta_Usuario;
import modelo.usuario.Usuario;
import vista.modelo.OperacionesVarias;

/**
 *
 * @author jenny
 */
public class DialogLogin extends javax.swing.JDialog {

    private FrmPrincipal fp;
    private static DialogLogin dl = null;
    public static String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@!#$";

    /**
     * Creates new form DialogLogin
     */
    public DialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ControladorUsuario.listar();
        fp = (FrmPrincipal) parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        lblClave.setText("   Clave:");
        getContentPane().add(lblClave);
        lblClave.setBounds(60, 140, 60, 20);

        lblUsuario.setText("Usuario: ");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(60, 110, 60, 20);

        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(110, 180, 90, 30);

        btnAceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(20, 180, 90, 30);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(110, 110, 180, 25);

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        getContentPane().add(txtClave);
        txtClave.setBounds(110, 140, 180, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/USUARIO.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 346, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/llave.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 30, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cliente.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 30, 30);

        jLabel4.setText("<html>NUNCA: entregue sus datos personales,<br>usuario, clave de acceso<br> por cualquier medio ya sea correo <br>electronico, mensajes de celular, <br>mensajeria instantanea, teléfono, pagina web u otro,<br> el usuario y las claves son secretas>");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(310, 100, 270, 120);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/clave.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 0, 150, 90);

        jButton1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jButton1.setText("<" + "html" + ">Olvido su<" + "br" + ">Contraseña" + "<" + "html" + ">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 180, 110, 30);

        setSize(new java.awt.Dimension(579, 223));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (!txtUsuario.getText().isEmpty() || !String.valueOf(txtClave.getPassword()).isEmpty()) {
            String u = txtUsuario.getText();
            String c = String.valueOf(txtClave.getPassword());
            if (ControladorPrincipal.datosCorrectos(u, c)) {
                this.dispose();
//                JOptionPane.showMessageDialog(null, "Acceso Correcto");
                if (ControladorPrincipal.tipoUs.equals(Constantes.JEFE)) {
                    ControladorPermisos.permisoAdministrador();
                } else if (ControladorPrincipal.tipoUs.equals(Constantes.SERVIDOR)) {
                    ControladorPermisos.permisoServidor();
                } else if (ControladorPrincipal.tipoUs.equals(Constantes.RRHH)) {
                    ControladorPermisos.permisoRRHH();
                }
                fp.ponePermisos();
                ControladorRecordatorio.listarRecordatorios();
                ControladorPrincipal.listarFechasEval();
                System.out.println(FrmPrincipal.estaEvalActiva);
                System.out.println(FrmPrincipal.userLogueado.isEvaluacionActivada());
            } else {
                if (ControladorPrincipal.clavemal) {
                    JOptionPane.showMessageDialog(null, "La clave ingresada es incorrecta");
                } else if (ControladorPrincipal.esInhab == 0) {
                    JOptionPane.showMessageDialog(null, "El usuario ingresado no está registrado pida al administrador su ingreso");
                } else if (ControladorPrincipal.esInhab == 1) {
                    JOptionPane.showMessageDialog(null, "El usuario ingresado está deshabilitado pida al administrador su habilitacion");
                    ControladorPrincipal.esInhab = 0;
                }
                //JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        btnAceptarActionPerformed(evt);
    }//GEN-LAST:event_txtClaveActionPerformed

    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    private boolean enviarEmail(String correo, String body) {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            //Recoger los datos
            String str_De = "iesspeart@gmail.com";
            String str_PwRemitente = "i4e3s7s7p7e3a2r7t8";
            String str_Para = correo;
            String str_Asunto = "Perdidad de Contraseña";
            String str_Mensaje = body;            
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(str_De,"Administrador"));            
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(str_Para, "Sr. Usuario"));
            message.setSubject(str_Asunto);
            message.setText(str_Mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(str_De, str_PwRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            // Cierre de la conexion.
            t.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //new Reset(this, true).setVisible(true);
        //JOptionPane.showMessageDialog(null,"clave");
        //int r = JOptionPane.showConfirmDialog(null, "¿Advertencia: Usted está de acuerdo en calificar  su Test, \n si la  respuesta es afirmativa, no le será posible  revisarlo?", "Calificar", JOptionPane.YES_NO_OPTION);
        //int r = JOptionPane.showConfirmDialog(null, "Prueba de envio", "Calificar", JOptionPane.YES_NO_OPTION);
        //if (r == JOptionPane.YES_OPTION) {

        //}

        String email = JOptionPane.showInputDialog(null, "Ingrese su email");
        if (validateEmail(email)) {
            //JOptionPane.showMessageDialog(null,"Su email "+email+" es correcto");
            Usuario user = (Usuario) OperacionesBD.buscar("Usuario", "email", email);

            if (user != null) {
                Pregunta_Recuperar preg = (Pregunta_Recuperar) OperacionesBD.buscar("Pregunta_Recuperar", "idpreguntarecuperar", String.valueOf(user.getIdpreguntarecuperar()));
                //Pregunta_Recuperar pre = (Pregunta_Recuperar) OperacionesBD.buscar("Pregunta_Recuperar", "idpregunta", user.getIdpreguntarecuperar());
                String respu = JOptionPane.showInputDialog(null, "Responda la siguiente pregunta:\n"
                        + preg.getPregunta());
                Respuesta_Usuario resaux = (Respuesta_Usuario) OperacionesBD.buscar("Respuesta_Usuario", "idpersona", String.valueOf(user.getIdPersona()));
                if (resaux.getIdpreguntarecuperar() == preg.getIdpreguntarecuperar()) {
                    if (resaux.getRespuesta().equals(respu)) {
                        String newclave = generarClave();                        
                        String str = OperacionesVarias.generaAleatoria(16);
                        aes = new AlgoritmoAES(str.getBytes());
                        user.setClave(aes.encriptar(newclave) + str);
                        OperacionesBD.modificar(user);
                       
                        String body = "Estimado Usuario, usted a pedido un cambio de clave por perdida\n"
                                + "El sistema le genero la siguiente clave: " + newclave+"\n"
                                + "Por favor le sugerimos que la clave proporcionada la cambie, muchas gracias";
                        
                        enviarEmail(user.getEmail(), body);
                        
                        JOptionPane.showMessageDialog(null, "Su ha enviado a su email su nueva clave de acceso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Respuesta erronea ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error de consistencia ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Su email " + email + " no esta registrado en nuestro sistema ");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Su email " + email + " no tiene el formato correcto");
        }





    }

    private String generarClave() {
        String contrasena = "";
        int longitud = base.length();

        for (int i = 0; i < 10; i++) {
            int numero = (int) (Math.random() * (longitud));
            String caracter = base.substring(numero, numero + 1);
            contrasena = contrasena + caracter;
        }

        return contrasena;
    }//
//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private AlgoritmoAES aes;
    // End of variables declaration//GEN-END:variables
}
