/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.respaldos;

import javax.swing.JOptionPane;
import modelo.respaldos.BackupBD;
import modelo.respaldos.ConstantesBD;


/**
 *
 * @author jenny
 */
public class FrmGeneracion extends javax.swing.JDialog implements Runnable {

    String dir;
    String user;
    String clave;
    int tipo;
    Thread hilo;

    /**
     * Creates new form FrmGeneracion
     */
    public FrmGeneracion() {
        initComponents();
    }

    public FrmGeneracion(String dir, String user, String clave, int tipo) {
        initComponents();        
        this.dir = dir;
        this.user = user;
        this.clave = clave;
        this.tipo = tipo;
        hilo = new Thread(this);
        hilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraProgreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        barraProgreso.setIndeterminate(true);

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnCerrar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icono_eliminar.gif"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnCerrar)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-404)/2, (screenSize.height-179)/2, 404, 179);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        if (tipo == ConstantesBD.CREAR_BACKUP) {
            jLabel1.setText("Respaldando Base de Datos...");            
            if (BackupBD.generarBackup(dir, user, clave)) {
                dispose();
                JOptionPane.showMessageDialog(null, "Respaldo generado correctamente", "RESPALDO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (tipo == ConstantesBD.CARGAR_BACKUP) {
            jLabel1.setText("Cargando Backup Base de Datos...");
            if (BackupBD.restaurarBackup(dir, user, clave)) {
                dispose();
                JOptionPane.showMessageDialog(null, "Backup cargado correctamente", "RESPALDO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
