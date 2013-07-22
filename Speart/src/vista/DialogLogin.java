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
 * @author francisco
 */
public class DialogLogin extends javax.swing.JDialog {

    private FrmPrincipal fp;

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

        lblClave = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblClave.setText("   Clave:");
        getContentPane().add(lblClave);
        lblClave.setBounds(60, 140, 60, 20);

        lblUsuario.setText("Usuario: ");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(60, 110, 60, 20);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(180, 180, 90, 30);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(80, 180, 90, 30);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(110, 110, 180, 25);
        getContentPane().add(txtClave);
        txtClave.setBounds(110, 140, 180, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/USUARIO.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 340, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/llave.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 30, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/cliente.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 30, 30);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-360)/2, (screenSize.height-252)/2, 360, 252);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (!txtUsuario.getText().isEmpty() || !String.valueOf(txtClave.getPassword()).isEmpty()) {
            String u = txtUsuario.getText();
            String c = String.valueOf(txtClave.getPassword());
            if (ControladorPrincipal.datosCorrectos(u, c)) {
                this.dispose();
                JOptionPane.showMessageDialog(null, "Acceso Correcto");
                if (ControladorPrincipal.tipoUs.equals(Constantes.JEFE)) {
                    ControladorPermisos.permisoAdministrador();
                } else if (ControladorPrincipal.tipoUs.equals(Constantes.SERVIDOR)) {
                    ControladorPermisos.permisoServidor();
                } else if (ControladorPrincipal.tipoUs.equals(Constantes.RRHH)) {
                    ControladorPermisos.permisoRRHH();
                }
                fp.ponePermisos();
                ControladorRecordatorio.listarRecordatorios();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta");
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}