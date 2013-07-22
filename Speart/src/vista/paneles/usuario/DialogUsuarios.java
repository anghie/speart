/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.acciones.usuario.ControladorUsuario;
import modelo.usuario.Usuario;

/**
 *
 * @author francisco
 */
public class DialogUsuarios extends javax.swing.JDialog {

    public DialogUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ControladorUsuario.listar();
        llenaComboUsuarios();
    }

    private void llenaComboUsuarios() {
        cbUsuarios.removeAllItems();
        int i = 0;
        for (Usuario u : ControladorUsuario.usuarios) {
            String s = u.getNombre() + " - " + ControladorUsuario.roles.get(i).getCargo();
            cbUsuarios.addItem(s);
            i++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbUsuarios = new javax.swing.JComboBox();
        lblMensaje = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(cbUsuarios);
        cbUsuarios.setBounds(20, 50, 380, 30);

        lblMensaje.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        lblMensaje.setText("Escoja el servidor al que desea pasar las actividades:");
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(30, 10, 390, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(220, 90, 90, 40);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(110, 90, 90, 40);

        setSize(new java.awt.Dimension(444, 186));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        System.out.println("Si llega");
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbUsuarios;
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables
}