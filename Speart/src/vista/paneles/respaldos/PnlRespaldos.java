/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.respaldos;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.respaldos.ConstantesBD;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;

/**
 *
 * @author jenny
 */
public class PnlRespaldos extends javax.swing.JPanel {

    /**
     * Creates new form PnlRespaldos
     */
    public PnlRespaldos() {
        initComponents();
        filtroSQL = new FileNameExtensionFilter("Archivos SQL", "sql");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedRespaldos = new javax.swing.JTabbedPane();
        pnlDos = new javax.swing.JPanel();
        pnlCargaRespaldo = new javax.swing.JPanel();
        lblUsuarioBdCarga = new javax.swing.JLabel();
        txtUsuarioCarg = new javax.swing.JTextField();
        lblClaveBDCarg = new javax.swing.JLabel();
        txtClaveCarg = new javax.swing.JTextField();
        btnBuscarCarg = new javax.swing.JButton();
        txtDirectorioCarg = new javax.swing.JTextField();
        btnCargarResp = new javax.swing.JButton();
        lblCargResp = new javax.swing.JLabel();
        lblDirSqlGen1 = new javax.swing.JLabel();
        pnlUno = new javax.swing.JPanel();
        pnlGeneraRespaldo = new javax.swing.JPanel();
        lblUsuarioBDGen = new javax.swing.JLabel();
        txtUsuarioGen = new javax.swing.JTextField();
        lblClaveBDGen = new javax.swing.JLabel();
        txtClaveGen = new javax.swing.JTextField();
        lblDirSqlGen = new javax.swing.JLabel();
        txtDirectorioGen = new javax.swing.JTextField();
        btnBuscaGenerac = new javax.swing.JButton();
        btnGenerarResp = new javax.swing.JButton();
        lblGenResp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        tabbedRespaldos.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        pnlDos = new  ImagenJPanel ("zzz.jpg");

        pnlCargaRespaldo.setOpaque(false);
        pnlCargaRespaldo.setPreferredSize(new java.awt.Dimension(540, 320));
        pnlCargaRespaldo.setLayout(null);

        lblUsuarioBdCarga.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblUsuarioBdCarga.setText("UsuarioBD: ");
        pnlCargaRespaldo.add(lblUsuarioBdCarga);
        lblUsuarioBdCarga.setBounds(80, 120, 100, 30);

        txtUsuarioCarg.setToolTipText("Ingrese el usuario de la base de datos");
        pnlCargaRespaldo.add(txtUsuarioCarg);
        txtUsuarioCarg.setBounds(170, 120, 100, 30);

        lblClaveBDCarg.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblClaveBDCarg.setText("ClaveBD: ");
        pnlCargaRespaldo.add(lblClaveBDCarg);
        lblClaveBDCarg.setBounds(280, 120, 100, 30);

        txtClaveCarg.setToolTipText("ingrese la clave de la bases de datos");
        pnlCargaRespaldo.add(txtClaveCarg);
        txtClaveCarg.setBounds(360, 120, 100, 30);

        btnBuscarCarg.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnBuscarCarg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/BUSC.png"))); // NOI18N
        btnBuscarCarg.setText("Buscar");
        btnBuscarCarg.setToolTipText("Buscar la carpeta o lugar donde haya duardado su respaldo  de la informaión");
        btnBuscarCarg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCargActionPerformed(evt);
            }
        });
        pnlCargaRespaldo.add(btnBuscarCarg);
        btnBuscarCarg.setBounds(370, 180, 100, 30);
        pnlCargaRespaldo.add(txtDirectorioCarg);
        txtDirectorioCarg.setBounds(80, 180, 280, 30);

        btnCargarResp.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnCargarResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/respaldo.png"))); // NOI18N
        btnCargarResp.setText("CARGAR");
        btnCargarResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarRespActionPerformed(evt);
            }
        });
        pnlCargaRespaldo.add(btnCargarResp);
        btnCargarResp.setBounds(210, 230, 120, 40);

        lblCargResp.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblCargResp.setText("CARGA DE RESPALDO DESDE ARCHIVO SQL");
        pnlCargaRespaldo.add(lblCargResp);
        lblCargResp.setBounds(100, 60, 360, 21);

        lblDirSqlGen1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblDirSqlGen1.setText("Directorio archivo sql:");
        pnlCargaRespaldo.add(lblDirSqlGen1);
        lblDirSqlGen1.setBounds(80, 160, 190, 16);

        pnlDos.add(pnlCargaRespaldo);

        tabbedRespaldos.addTab("CARGAR RESPALDO", pnlDos);

        pnlUno  = new  ImagenJPanel ("zzz.jpg");
        pnlUno.setLayout(null);

        pnlGeneraRespaldo.setOpaque(false);
        pnlGeneraRespaldo.setPreferredSize(new java.awt.Dimension(540, 320));
        pnlGeneraRespaldo.setLayout(null);

        lblUsuarioBDGen.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblUsuarioBDGen.setText("UsuarioBD: ");
        pnlGeneraRespaldo.add(lblUsuarioBDGen);
        lblUsuarioBDGen.setBounds(80, 125, 100, 20);

        txtUsuarioGen.setToolTipText("Ingrese el usuario de la base de datos");
        pnlGeneraRespaldo.add(txtUsuarioGen);
        txtUsuarioGen.setBounds(170, 120, 100, 30);

        lblClaveBDGen.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblClaveBDGen.setText("ClaveBD: ");
        pnlGeneraRespaldo.add(lblClaveBDGen);
        lblClaveBDGen.setBounds(280, 125, 100, 20);

        txtClaveGen.setToolTipText("ingrese la clave de la bases de datos");
        pnlGeneraRespaldo.add(txtClaveGen);
        txtClaveGen.setBounds(360, 120, 100, 30);

        lblDirSqlGen.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblDirSqlGen.setText("Directorio archivo sql:");
        pnlGeneraRespaldo.add(lblDirSqlGen);
        lblDirSqlGen.setBounds(80, 160, 190, 16);

        txtDirectorioGen.setToolTipText("");
        pnlGeneraRespaldo.add(txtDirectorioGen);
        txtDirectorioGen.setBounds(80, 180, 280, 30);

        btnBuscaGenerac.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnBuscaGenerac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/BUSC.png"))); // NOI18N
        btnBuscaGenerac.setText("Buscar");
        btnBuscaGenerac.setToolTipText("Buscar la carpeta o lugar donde quiere que se respalde la informaión");
        btnBuscaGenerac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaGeneracActionPerformed(evt);
            }
        });
        pnlGeneraRespaldo.add(btnBuscaGenerac);
        btnBuscaGenerac.setBounds(370, 180, 100, 30);

        btnGenerarResp.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnGenerarResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Select.png"))); // NOI18N
        btnGenerarResp.setText("GENERAR");
        btnGenerarResp.setToolTipText("Guardar el respaldo");
        btnGenerarResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRespActionPerformed(evt);
            }
        });
        pnlGeneraRespaldo.add(btnGenerarResp);
        btnGenerarResp.setBounds(210, 230, 130, 40);

        lblGenResp.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblGenResp.setText("GENERACIÓN DE RESPALDO HACIA ARCHIVO SQL");
        pnlGeneraRespaldo.add(lblGenResp);
        lblGenResp.setBounds(80, 60, 390, 16);

        jLabel1.setText("jLabel1");
        pnlGeneraRespaldo.add(jLabel1);
        jLabel1.setBounds(120, 470, 34, 14);

        pnlUno.add(pnlGeneraRespaldo);
        pnlGeneraRespaldo.setBounds(117, 5, 540, 320);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setText("<html>Basicamente un Backup  o resplado es una copia de los datos importantes que no<br> quieres perder por cualquier<br> fallo del sistema informático.<br>\n\nNormalmente se efectúan periódicamente porque los datos se van modificando a medida que trabajas con ellos</html>\n\n");
        pnlUno.add(jLabel2);
        jLabel2.setBounds(210, 340, 450, 110);

        tabbedRespaldos.addTab("GENERAR RESPALDO", pnlUno);

        add(tabbedRespaldos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCargActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileFilter(filtroSQL);
        int opc = jf.showOpenDialog(this);
        if (opc == JFileChooser.APPROVE_OPTION) {
            direccion = jf.getSelectedFile().getPath();
            txtDirectorioCarg.setText(direccion);
        }
    }//GEN-LAST:event_btnBuscarCargActionPerformed

    private void btnCargarRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarRespActionPerformed
        if (!txtDirectorioCarg.getText().isEmpty() && !txtUsuarioCarg.getText().isEmpty()
                && !txtClaveCarg.getText().isEmpty()) {
            usuario = txtUsuarioCarg.getText();
            clave = txtClaveCarg.getText();
            FrmGeneracion fg = new FrmGeneracion(direccion, usuario, clave, ConstantesBD.CARGAR_BACKUP);
            fg.setVisible(true);
        }else{
            Mensaje.camposVacios();
        }
    }//GEN-LAST:event_btnCargarRespActionPerformed

    private void btnBuscaGeneracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaGeneracActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);
        int open = jfc.showSaveDialog(this);
        if (open == JFileChooser.APPROVE_OPTION) {
            direccion = jfc.getSelectedFile().getPath();
            txtDirectorioGen.setText(direccion);
        }
    }//GEN-LAST:event_btnBuscaGeneracActionPerformed

    private void btnGenerarRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRespActionPerformed
        if (!txtDirectorioGen.getText().isEmpty() && !txtUsuarioGen.getText().isEmpty()
                && !txtClaveGen.getText().isEmpty()) {
            usuario = txtUsuarioGen.getText();
            clave = txtClaveGen.getText();
            FrmGeneracion fg = new FrmGeneracion(direccion, usuario, clave, ConstantesBD.CREAR_BACKUP);
            fg.setVisible(true);
        } else {
            Mensaje.camposVacios();
        }
    }//GEN-LAST:event_btnGenerarRespActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaGenerac;
    private javax.swing.JButton btnBuscarCarg;
    private javax.swing.JButton btnCargarResp;
    private javax.swing.JButton btnGenerarResp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCargResp;
    private javax.swing.JLabel lblClaveBDCarg;
    private javax.swing.JLabel lblClaveBDGen;
    private javax.swing.JLabel lblDirSqlGen;
    private javax.swing.JLabel lblDirSqlGen1;
    private javax.swing.JLabel lblGenResp;
    private javax.swing.JLabel lblUsuarioBDGen;
    private javax.swing.JLabel lblUsuarioBdCarga;
    private javax.swing.JPanel pnlCargaRespaldo;
    private javax.swing.JPanel pnlDos;
    private javax.swing.JPanel pnlGeneraRespaldo;
    private javax.swing.JPanel pnlUno;
    private javax.swing.JTabbedPane tabbedRespaldos;
    private javax.swing.JTextField txtClaveCarg;
    private javax.swing.JTextField txtClaveGen;
    private javax.swing.JTextField txtDirectorioCarg;
    private javax.swing.JTextField txtDirectorioGen;
    private javax.swing.JTextField txtUsuarioCarg;
    private javax.swing.JTextField txtUsuarioGen;
    // End of variables declaration//GEN-END:variables
    FileNameExtensionFilter filtroSQL;
    String direccion;
    String usuario;
    String clave;
}
