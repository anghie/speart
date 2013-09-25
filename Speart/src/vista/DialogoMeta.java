/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.acciones.agenda.ControladorActividades;
import controlador.acciones.agenda.ControladorMeta;
import controlador.acciones.servicios.ControladorAgenda;
import controlador.acciones.usuario.ControladorUsuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.agenda.Agenda;
import modelo.agenda.Meta;
import modelo.proceso.Actividad;
import modelo.usuario.Usuario;
import vista.modelo.Fecha;
import vista.modelo.ModeloComboBoxActividad;
import vista.modelo.ModeloComboBoxUsuarios;
import vista.modelo.ModeloTablaMeta;

/**
 *
 * @author alf
 */
public class DialogoMeta extends javax.swing.JDialog {

    /**
     * Creates new form DialogoMeta
     */
    private LinkedList<Actividad> listaActividades;
    private ArrayList<Usuario> listaUsuarios;
    private Agenda agenda;
    private boolean modificado;
    private ModeloTablaMeta modeloTablaMeta;

    public DialogoMeta(JFrame parent, boolean modal) {
        super(parent, modal);
        this.agenda = ControladorAgenda.getAgendaActual();
        this.modeloTablaMeta = new ModeloTablaMeta();
        initComponents();
        iniciarActividades();
        iniciarRoles();
    }

    private void iniciarActividades() {
        listaActividades = ControladorActividades.getAllActividades();
        cmbActividad.setModel(new ModeloComboBoxActividad(listaActividades));
    }

    private void iniciarRoles() {
        listaUsuarios = ControladorUsuario.usuarios;
        cmbUsuario.setModel(new ModeloComboBoxUsuarios(listaUsuarios));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMetas = new javax.swing.JTable();
        cmbIndic = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        spnIndicador = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spnMeta = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        cmbActividad = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        panelSur = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelCenter.setLayout(new java.awt.BorderLayout());

        tablaMetas.setModel(modeloTablaMeta);
        jScrollPane1.setViewportView(tablaMetas);

        panelCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        cmbIndic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cmbIndic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mes:");
        cmbIndic.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo ", "Abril", "Mayo ", "Junio", "Julio ", "Agosto", "Septiembre", "Octubre ", "Noviembre", "Diciembre" }));
        cmbMes.setMinimumSize(new java.awt.Dimension(100, 20));
        cmbMes.setPreferredSize(new java.awt.Dimension(100, 20));
        cmbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesActionPerformed(evt);
            }
        });
        cmbIndic.add(cmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel2.setText("Indicador:");
        cmbIndic.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        spnIndicador.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(1.0d)));
        spnIndicador.setPreferredSize(new java.awt.Dimension(60, 20));
        cmbIndic.add(spnIndicador, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel3.setText("Meta:");
        cmbIndic.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        spnMeta.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnMeta.setPreferredSize(new java.awt.Dimension(60, 20));
        cmbIndic.add(spnMeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel4.setText("Actividad:");
        cmbIndic.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        cmbActividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbActividad.setPreferredSize(new java.awt.Dimension(80, 20));
        cmbIndic.add(cmbActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 11, 190, -1));

        jLabel5.setText("Usuario:");
        cmbIndic.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUsuario.setPreferredSize(new java.awt.Dimension(80, 20));
        cmbIndic.add(cmbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/list-add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        cmbIndic.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/list-remove.png"))); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        cmbIndic.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, -1, -1));

        getContentPane().add(cmbIndic, java.awt.BorderLayout.PAGE_START);

        panelSur.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelSur.add(btnCancelar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/filesave.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelSur.add(btnGuardar);

        getContentPane().add(panelSur, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Meta nuevaMeta = new Meta();
        nuevaMeta.setAgenda(agenda);
        Actividad actividad = ((ModeloComboBoxActividad) cmbActividad.getModel()).getSelectedActividad();
        nuevaMeta.setActividad(actividad);

        Usuario usuario = ((ModeloComboBoxUsuarios) cmbUsuario.getModel()).getSelectedUsuario();
        nuevaMeta.setUsuario(usuario);

        nuevaMeta.setFecha(Calendar.getInstance().getTime());
        nuevaMeta.setIndicador(Double.parseDouble(spnIndicador.getValue().toString()));
        nuevaMeta.setValor(Integer.parseInt(spnMeta.getValue().toString()));
        nuevaMeta.setMes(Fecha.getNumeroMes(cmbMes.getSelectedItem().toString()));

        ModeloTablaMeta modeloTabla = (ModeloTablaMeta) tablaMetas.getModel();
        modeloTabla.addMeta(nuevaMeta);
        //ControladorMeta.createMeta();
        //nuevaMeta.setTotalHecho(WIDTH);
        modificado = true;

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        ModeloTablaMeta modeloTabla = (ModeloTablaMeta) tablaMetas.getModel();
        modeloTabla.removMeta(tablaMetas.getSelectedRow());
        modificado = true;
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        guardarDatos();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        guardarActualizar();
        modificado = false;
        dispose();




    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesActionPerformed
        // TODO add your handling code here:
        String mes = cmbMes.getSelectedItem().toString();
        mes = "" + Fecha.getNumeroMes(mes);
        LinkedList<Meta> metas = ControladorMeta.searchMetas(mes);
        modeloTablaMeta.setItemsMeta(metas);
        guardarDatos();
    }//GEN-LAST:event_cmbMesActionPerformed
    public void guardarDatos() {
        if (modificado) {
            int x = JOptionPane.showConfirmDialog(panelCenter, "Se han realizado modificaciones desea gurdar");
            if (x == JOptionPane.YES_OPTION) {
                guardarActualizar();
                modificado = false;
            }
        }
    }

    public void guardarActualizar() {
        ModeloTablaMeta modeloTabla = (ModeloTablaMeta) tablaMetas.getModel();
        LinkedList<Meta> metas = modeloTabla.getDatos();
        for (Iterator<Meta> it = metas.iterator(); it.hasNext();) {
            Meta meta = it.next();
            if (meta.getId() == null || meta.getId() == -1) {
                ControladorMeta.createMeta(meta);
            } else {
                ControladorMeta.updateMeta(meta);
            }
        }
    }
    /**
     * @param args the command line arguments
     *///
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
//            java.util.logging.Logger.getLogger(DialogoMeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogoMeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogoMeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogoMeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogoMeta dialog = new DialogoMeta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox cmbActividad;
    private javax.swing.JPanel cmbIndic;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JComboBox cmbUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelSur;
    private javax.swing.JSpinner spnIndicador;
    private javax.swing.JSpinner spnMeta;
    private javax.swing.JTable tablaMetas;
    // End of variables declaration//GEN-END:variables
}
