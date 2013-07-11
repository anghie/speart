/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.acciones.ControladorPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author francisco
 */
public class DialogCambiaClave extends javax.swing.JDialog {

    /**
     * Creates new form DialogCambiaClave
     */
    public DialogCambiaClave(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClaveInterior = new javax.swing.JLabel();
        lblClaveNueva = new javax.swing.JLabel();
        lblConfirmClave = new javax.swing.JLabel();
        btnCambiar = new javax.swing.JButton();
        txtComfirClave = new javax.swing.JPasswordField();
        txtClaveAnterior = new javax.swing.JPasswordField();
        txtClaveNueva = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        lblClaveInterior.setText(" Clave anterior:");
        getContentPane().add(lblClaveInterior);
        lblClaveInterior.setBounds(20, 30, 120, 30);

        lblClaveNueva.setText(" Clave nueva:");
        getContentPane().add(lblClaveNueva);
        lblClaveNueva.setBounds(30, 70, 110, 30);

        lblConfirmClave.setText("Confirme clave:");
        getContentPane().add(lblConfirmClave);
        lblConfirmClave.setBounds(20, 110, 140, 30);

        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambiar);
        btnCambiar.setBounds(150, 160, 110, 40);
        getContentPane().add(txtComfirClave);
        txtComfirClave.setBounds(140, 110, 220, 30);
        getContentPane().add(txtClaveAnterior);
        txtClaveAnterior.setBounds(140, 30, 220, 30);
        getContentPane().add(txtClaveNueva);
        txtClaveNueva.setBounds(140, 70, 220, 30);

        setSize(new java.awt.Dimension(396, 241));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        if (ControladorPrincipal.verificaClave(String.valueOf(txtClaveAnterior.getPassword()))) {
            if (String.valueOf(txtClaveNueva.getPassword()).equals(String.valueOf(txtComfirClave.getPassword()))) {
                ControladorPrincipal.cambiaClave(String.valueOf(txtClaveNueva.getPassword()));
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Claves no coinciden");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Clave anterior no es valida");
        }
    }//GEN-LAST:event_btnCambiarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JLabel lblClaveInterior;
    private javax.swing.JLabel lblClaveNueva;
    private javax.swing.JLabel lblConfirmClave;
    private javax.swing.JPasswordField txtClaveAnterior;
    private javax.swing.JPasswordField txtClaveNueva;
    private javax.swing.JPasswordField txtComfirClave;
    // End of variables declaration//GEN-END:variables
}
