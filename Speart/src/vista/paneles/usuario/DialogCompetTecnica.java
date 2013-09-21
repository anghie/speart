/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.acciones.usuario.ControladorDestrezaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.proceso.Rol;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;

/**
 *
 * @author jenny
 */
public class DialogCompetTecnica extends javax.swing.JDialog {

    private ControladorDestrezaUsuario cdu;
    private GestorControladorDestrezaUsuario gcdu;
    private Rol rol;

    /**
     * Creates new form DialogDestrezaUsuario
     */
    public DialogCompetTecnica(java.awt.Frame parent, boolean modal, Rol rol) {
        super(parent, modal);
        initComponents();
        this.rol = rol;
        cdu = new ControladorDestrezaUsuario(this);
        gcdu = new GestorControladorDestrezaUsuario();
        cdu.listarDestreza();
        cdu.poneLstDestrezasDisp();
        cdu.poneLstDestrezasAsig();
        poneEventos();
    }

    private void poneEventos() {
        btnAgregarDestreza.addActionListener(gcdu);
        btnQuitarDestreza.addActionListener(gcdu);
        btnAceptar.addActionListener(gcdu);
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
        lstDestrezasDisponibles = new javax.swing.JList();
        scrollAsignadas = new javax.swing.JScrollPane();
        lstDestrezasAsignadas = new javax.swing.JList();
        btnAgregarDestreza = new javax.swing.JButton();
        btnQuitarDestreza = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1  = new  ImagenJPanel ("images.jpg");
        jPanel1.setLayout(null);

        scrollDisponibles.setViewportView(lstDestrezasDisponibles);

        jPanel1.add(scrollDisponibles);
        scrollDisponibles.setBounds(10, 40, 310, 180);

        scrollAsignadas.setViewportView(lstDestrezasAsignadas);

        jPanel1.add(scrollAsignadas);
        scrollAsignadas.setBounds(430, 40, 310, 180);

        btnAgregarDestreza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/list-add.png"))); // NOI18N
        btnAgregarDestreza.setText("Agregar");
        btnAgregarDestreza.setToolTipText("Agregar Competencias Tecnicas");
        jPanel1.add(btnAgregarDestreza);
        btnAgregarDestreza.setBounds(330, 50, 97, 30);

        btnQuitarDestreza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnQuitarDestreza.setText("Quitar");
        jPanel1.add(btnQuitarDestreza);
        btnQuitarDestreza.setBounds(330, 100, 90, 30);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/acepta.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
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

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Competencias Tecnicas agregadas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(460, 20, 230, 16);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Competencias Tecnicas a agregar:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 20, 240, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 280);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-762)/2, (screenSize.height-320)/2, 762, 320);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarDestreza;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnQuitarDestreza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList lstDestrezasAsignadas;
    private javax.swing.JList lstDestrezasDisponibles;
    private javax.swing.JScrollPane scrollAsignadas;
    private javax.swing.JScrollPane scrollDisponibles;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the rol
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * @return the lstDestrezasAsignadas
     */
    public javax.swing.JList getLstDestrezasAsignadas() {
        return lstDestrezasAsignadas;
    }

    /**
     * @return the lstDestrezasDisponibles
     */
    public javax.swing.JList getLstDestrezasDisponibles() {
        return lstDestrezasDisponibles;
    }

    class GestorControladorDestrezaUsuario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAgregarDestreza) {
                if (lstDestrezasDisponibles.getSelectedIndex() != -1) {
                    cdu.agregaItemDestrezaAsignados();
                } else {
                    Mensaje.campoNoSeleccionado("Destreza");
                }
            } else if (e.getSource() == btnQuitarDestreza) {
                if (lstDestrezasAsignadas.getSelectedIndex() != -1) {
                    cdu.quitaItemDestrezaAsignados();
                } else {
                    Mensaje.campoNoSeleccionado("Destreza");
                }

            } else if (e.getSource() == btnAceptar) {
                int opc = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los datos?", "Guardar", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    cdu.guardaDestrezaUsuario();
                }
                dispose();
            }
        }
    }
}
