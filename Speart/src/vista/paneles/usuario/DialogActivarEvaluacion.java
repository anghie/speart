/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.acciones.Constantes;
import controlador.basedatos.OperacionesBD;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.usuario.Usuario;
import vista.FrmPrincipal;
import vista.modelo.Mensaje;

/**
 *
 * @author francisco
 */
public class DialogActivarEvaluacion extends javax.swing.JDialog {
    
    private static DialogActivarEvaluacion dae;
    private ArrayList<Usuario> servidoresDisp;
    private ArrayList<Usuario> servidoresPlanif;

    /**
     * Creates new form DialogActivarEvaluacion
     */
    private DialogActivarEvaluacion() {        
        initComponents();
        setModal(true);
        servidoresPlanif= new ArrayList<>();
        listarServidores();
        llenaListaDisponibles();
    }
    
    public synchronized static DialogActivarEvaluacion getInstance() {
        if (dae == null) {
            dae = new DialogActivarEvaluacion();
        }
        return dae;
    }
    
    private void listarServidores() {
        servidoresDisp = new ArrayList<>();
        ArrayList<Usuario> serv = (ArrayList<Usuario>) OperacionesBD.listar("Usuario");
        String actual = FrmPrincipal.userLogueado.getRol().getTipo();
        for (Usuario s : serv) {
            if ((!s.getRol().getTipo().equals(Constantes.RRHH))
                    && (!s.getRol().getTipo().equals(actual))) {
                servidoresDisp.add(s);
            }
        }
    }
    
    private void llenaListaDisponibles() {
        DefaultListModel dlm = new DefaultListModel();
        lstDisponibleParaEval.removeAll();
        if (servidoresDisp != null) {
            dlm.removeAllElements();
            for (Usuario u : servidoresDisp) {
                dlm.addElement(u.getNombre() + " " + u.getApellidos());
            }
        }
        lstDisponibleParaEval.setModel(dlm);
    }
    
    private void llenaListaAsignados() {
        DefaultListModel dlm = new DefaultListModel();
        lstParaEvaluar.removeAll();
        if (servidoresPlanif != null) {
            dlm.removeAllElements();
            for (Usuario u : servidoresPlanif) {
                dlm.addElement(u.getNombre() + " " + u.getApellidos());
            }
        }
        lstParaEvaluar.setModel(dlm);
    }
    
    private void addToList(Usuario u) {
        servidoresDisp.remove(u);
        servidoresPlanif.add(u);
        llenaListaAsignados();
        llenaListaDisponibles();
    }
    
    private void removeToList(Usuario u) {
        servidoresPlanif.remove(u);
        servidoresDisp.add(u);
        llenaListaAsignados();
        llenaListaDisponibles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstParaEvaluar = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDisponibleParaEval = new javax.swing.JList();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Activacion Evaluacion");
        getContentPane().setLayout(null);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(260, 280, 100, 40);

        btnAceptar.setText("Aceptar");
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(140, 280, 100, 40);

        jScrollPane2.setViewportView(lstParaEvaluar);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(290, 50, 200, 200);

        jScrollPane3.setViewportView(lstDisponibleParaEval);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 50, 200, 200);

        btnQuitar.setText("<");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar);
        btnQuitar.setBounds(230, 150, 50, 27);

        btnAgregar.setText(">");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(230, 100, 50, 27);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ACTIVACIÓN DE EVALUACIÓN");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(160, 10, 200, 30);

        setSize(new java.awt.Dimension(525, 369));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (lstDisponibleParaEval.getSelectedIndex() != -1) {
            Usuario u = servidoresDisp.get(lstDisponibleParaEval.getSelectedIndex());
            addToList(u);
        } else {
            if (servidoresDisp.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lista de Servidores Disponibles vacia");
            } else {
                Mensaje.filaNoSeleccionada();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (lstParaEvaluar.getSelectedIndex() != -1) {
            Usuario u = servidoresPlanif.get(lstParaEvaluar.getSelectedIndex());
            removeToList(u);
        } else {
            if (servidoresPlanif.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lista de Servidores Planificados vacia");
            } else {
                Mensaje.filaNoSeleccionada();
            }
        }
    }//GEN-LAST:event_btnQuitarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstDisponibleParaEval;
    private javax.swing.JList lstParaEvaluar;
    // End of variables declaration//GEN-END:variables
}