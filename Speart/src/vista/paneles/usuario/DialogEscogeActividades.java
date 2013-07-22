/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.acciones.proceso.ControladorEscogeActividades;
import controlador.basedatos.OperacionesBD;
import javax.swing.JOptionPane;
import modelo.proceso.Actividad;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;

/**
 *
 * @author francisco
 */
public class DialogEscogeActividades extends javax.swing.JDialog {

    /**
     * Creates new form DialogEscogeActividades
     */
    public DialogEscogeActividades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ControladorEscogeActividades.lstDisp = lstActivDisponibles;
        ControladorEscogeActividades.lstAsig = lstActividAsignadas;
        ControladorEscogeActividades.llenaListaDisponibles();
        ControladorEscogeActividades.llenaListaAsignadas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollDisponibles = new javax.swing.JScrollPane();
        lstActivDisponibles = new javax.swing.JList();
        scrollAsignadas = new javax.swing.JScrollPane();
        lstActividAsignadas = new javax.swing.JList();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1  = new  ImagenJPanel ("images.jpg");
        jPanel1.setLayout(null);

        scrollDisponibles.setViewportView(lstActivDisponibles);

        jPanel1.add(scrollDisponibles);
        scrollDisponibles.setBounds(20, 10, 310, 180);

        scrollAsignadas.setViewportView(lstActividAsignadas);

        jPanel1.add(scrollAsignadas);
        scrollAsignadas.setBounds(440, 10, 310, 180);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/acepta.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(520, 240, 110, 40);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/exit.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar);
        btnCerrar.setBounds(630, 240, 110, 40);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/list-add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(340, 50, 100, 30);

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitar);
        btnQuitar.setBounds(340, 100, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 760, 280);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-776)/2, (screenSize.height-321)/2, 776, 321);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (lstActivDisponibles.getSelectedIndex() != -1) {
            Actividad a = ControladorEscogeActividades.actividadesDisponibles.get(lstActivDisponibles.getSelectedIndex());
            ControladorEscogeActividades.agregaItemAsignadas(a);
        } else {
            if (ControladorEscogeActividades.actividadesDisponibles.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lista de Actividades Disponibles vacia");
            } else {
                Mensaje.filaNoSeleccionada();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (lstActividAsignadas.getSelectedIndex() != -1) {
            Actividad a = ControladorEscogeActividades.actividadesAsignadas.get(lstActividAsignadas.getSelectedIndex());
            ControladorEscogeActividades.quitaItemAsignadas(a);
        } else {
            if (ControladorEscogeActividades.actividadesAsignadas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lista de Actividades Asignadas vacia");
            } else {
                Mensaje.filaNoSeleccionada();
            }
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int i = 0;
        for (Actividad a : ControladorEscogeActividades.actividadesAsignadas) {
            i++;
            a.setParaEvaluacion(true);
            OperacionesBD.modificar(a);
        }
        for (Actividad a : ControladorEscogeActividades.actividadesDisponibles) {
            a.setParaEvaluacion(false);
            OperacionesBD.modificar(a);
        }        
        if (i == ControladorEscogeActividades.actividadesAsignadas.size()) {
//            DialogInformeActiv.llenaPnlDatosInf();
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList lstActivDisponibles;
    private javax.swing.JList lstActividAsignadas;
    private javax.swing.JScrollPane scrollAsignadas;
    private javax.swing.JScrollPane scrollDisponibles;
    // End of variables declaration//GEN-END:variables
}