/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.acciones.ControladorPrincipal;
import controlador.acciones.usuario.ControladorUsuario;
import java.util.ArrayList;
import modelo.usuario.Usuario;
import vista.modelo.ModeloComboBoxUsuarios;
import vista.modelo.paneles.agenda.PanelAgenda;

/**
 *
 * @author alf
 */
public class DialogoUsuarios extends javax.swing.JDialog {

    /**
     * Creates new form DialogoServidor
     */
    private ControladorPrincipal contenedorPrincipal;
    private ModeloComboBoxUsuarios modeloCmbUsuarios;
    private ArrayList<Usuario>listaUsuarios; 
    private Usuario usuarioLogueado;
    public DialogoUsuarios(Usuario usuarioLogueado,ControladorPrincipal cp,java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        listaUsuarios= ControladorUsuario.usuarios;
        this.usuarioLogueado=usuarioLogueado;
        modeloCmbUsuarios=new ModeloComboBoxUsuarios(listaUsuarios);
        initComponents();
        this.contenedorPrincipal=cp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmbServidor = new javax.swing.JComboBox();
        rbtIndividual = new javax.swing.JRadioButton();
        rbtTodos = new javax.swing.JRadioButton();
        btnVerAgenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");

        jLabel1.setText("Servidor:");

        cmbServidor.setModel(modeloCmbUsuarios);
        cmbServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServidorActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtIndividual);
        rbtIndividual.setSelected(true);
        rbtIndividual.setText("Individual");
        rbtIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIndividualActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtTodos);
        rbtTodos.setText("Todos");
        rbtTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTodosActionPerformed(evt);
            }
        });

        btnVerAgenda.setText("Ver Agenda");
        btnVerAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtIndividual)
                        .addGap(40, 40, 40)
                        .addComponent(rbtTodos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cmbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerAgenda)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtIndividual)
                    .addComponent(rbtTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnVerAgenda)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServidorActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbServidorActionPerformed

    private void btnVerAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAgendaActionPerformed
        // TODO add your handling code here:
        
       if(rbtIndividual.isSelected()){
           Usuario usuario= ((ModeloComboBoxUsuarios)cmbServidor.getModel()).getSelectedUsuario();
           contenedorPrincipal.ponePanel(new PanelAgenda("inicisv_1.jpg", usuario));
       }else{
           contenedorPrincipal.ponePanel(new PanelAgenda("inicisv_1.jpg", usuarioLogueado));
       }
        dispose();
    }//GEN-LAST:event_btnVerAgendaActionPerformed

    private void rbtIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIndividualActionPerformed
        // TODO add your handling code here:
        cmbServidor.setEnabled(true);
    }//GEN-LAST:event_rbtIndividualActionPerformed

    private void rbtTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTodosActionPerformed
        // TODO add your handling code here:
        cmbServidor.setEnabled(false);
    }//GEN-LAST:event_rbtTodosActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DialogoServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogoServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogoServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogoServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogoServidor dialog = new DialogoServidor(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerAgenda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rbtIndividual;
    private javax.swing.JRadioButton rbtTodos;
    // End of variables declaration//GEN-END:variables
}
