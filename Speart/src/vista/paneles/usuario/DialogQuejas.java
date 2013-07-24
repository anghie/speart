/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.basedatos.OperacionesBD;
import modelo.proceso.Rol;
import modelo.usuario.Queja;
import vista.modelo.Mensaje;

/**
 *
 * @author francisco
 */
public class DialogQuejas extends javax.swing.JDialog {
private Rol rol;
    /**
     * Creates new form DialogQuejas
     */
    public DialogQuejas(java.awt.Frame parent, boolean modal,Rol rol) {
        super(parent, modal);
        initComponents();
        this.rol=rol;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPersonaQueja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionQueja = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtNroFormulario = new javax.swing.JTextField();
        chbNo = new javax.swing.JCheckBox();
        chbSi = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        btnGuardarQueja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("QUEJAS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 70, 17);

        jLabel2.setText("Descripcion:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 110, 17);

        jLabel3.setText("Nombre de la persona que realiza la queja:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 60, 260, 17);
        getContentPane().add(txtPersonaQueja);
        txtPersonaQueja.setBounds(260, 50, 350, 30);

        txtDescripcionQueja.setColumns(20);
        txtDescripcionQueja.setLineWrap(true);
        txtDescripcionQueja.setRows(5);
        jScrollPane1.setViewportView(txtDescripcionQueja);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 90, 490, 140);

        jLabel4.setText("Formulario Nro:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 240, 90, 20);
        getContentPane().add(txtNroFormulario);
        txtNroFormulario.setBounds(120, 240, 90, 27);

        chbNo.setText("No");
        chbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbNoActionPerformed(evt);
            }
        });
        getContentPane().add(chbNo);
        chbNo.setBounds(460, 240, 60, 22);

        chbSi.setText("Si");
        chbSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSiActionPerformed(evt);
            }
        });
        getContentPane().add(chbSi);
        chbSi.setBounds(400, 240, 60, 22);

        jLabel5.setText("Descuento en evaluacion:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 240, 160, 20);

        btnGuardarQueja.setText("Guardar");
        btnGuardarQueja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarQuejaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarQueja);
        btnGuardarQueja.setBounds(260, 290, 100, 40);

        setSize(new java.awt.Dimension(642, 378));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarQuejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarQuejaActionPerformed
        Queja q = new Queja();
        q.setNombreDenun(txtPersonaQueja.getText());
        q.setDetalle(txtDescripcionQueja.getText());
        q.setNroForm(txtNroFormulario.getText());
        q.setReducePorcent(chbSi.isSelected()?true:false);
        q.setRol(rol);
        if(OperacionesBD.guardar(q)){
            Mensaje.datosGuardados();
            this.dispose();
        }else{
            Mensaje.datosNoGuardados();
        }
    }//GEN-LAST:event_btnGuardarQuejaActionPerformed

    private void chbSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSiActionPerformed
        if(chbNo.isSelected()){
            chbNo.setSelected(false);
            chbSi.setSelected(true);
        }
    }//GEN-LAST:event_chbSiActionPerformed

    private void chbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbNoActionPerformed
        if(chbSi.isSelected()){
            chbNo.setSelected(true);
            chbSi.setSelected(false);
        }
    }//GEN-LAST:event_chbNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarQueja;
    private javax.swing.JCheckBox chbNo;
    private javax.swing.JCheckBox chbSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescripcionQueja;
    private javax.swing.JTextField txtNroFormulario;
    private javax.swing.JTextField txtPersonaQueja;
    // End of variables declaration//GEN-END:variables
}
