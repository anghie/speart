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
import javax.swing.JOptionPane;

/**
 *
 * @author jenny
 */
public class DialogLogin extends javax.swing.JDialog {

    private FrmPrincipal fp;
    private static DialogLogin dl = null;

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
        jButton2 = new javax.swing.JButton();

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
        btnCancelar.setBounds(130, 180, 90, 30);

        btnAceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(40, 180, 90, 30);
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

        jLabel4.setText("<html>NUNCA: entregue sus datos personales,<br>usuario, clave de acceso<br>\npor cualquier medio ya sea correo <br>elefctronico, mensajes de celular, <br>mensajeria instanatnea,\nteelefono, pagina web u otro,<br> el usuario y las claves son secretas>");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(390, 100, 240, 100);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/clave.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 0, 150, 90);

        jButton2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jButton2.setText("Resetear clave");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 180, 110, 30);

        setSize(new java.awt.Dimension(635, 226));
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         new Reset(this, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Reset(this, true).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton2;
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
    // End of variables declaration//GEN-END:variables
}
