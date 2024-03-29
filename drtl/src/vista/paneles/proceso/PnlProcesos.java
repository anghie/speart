/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.proceso;

import controlador.acciones.proceso.ControladorProceso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;

/**
 *
 * @author jenny
 */
public class PnlProcesos extends javax.swing.JPanel {

    private ControladorProceso cpr;
    private GestorControlProceso gcp;

    /**
     * Creates new form PnlProcesos
     */
    public PnlProcesos() {
        initComponents();
        cpr = new ControladorProceso(this);
        gcp = new GestorControlProceso();
        poneAcciones();
        cpr.poneComboProcesos();
        cpr.poneComboPuestos();
        btnCancelar.setVisible(false);
    }

    private void poneAcciones() {
        btnNuevoProceso.addActionListener(gcp);
        getBtnGuardarActividad().addActionListener(gcp);
        cbProcesosLista.addActionListener(gcp);
        getTabbedProcesos().addChangeListener(gcp);
        btnEditarProceso.addActionListener(gcp);
        btnEditarActividad.addActionListener(gcp);
        btnEliminarActividad.addActionListener(gcp);
        btnCancelar.addActionListener(gcp);
        txtBuscar.addKeyListener(gcp);
        btnReporteActiv.addActionListener(gcp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        tabbedProcesos = new javax.swing.JTabbedPane();
        pnlUno = new javax.swing.JPanel();
        pnlProcesos = new javax.swing.JPanel();
        pnlAddActiv = new javax.swing.JPanel();
        lblPuestoResponsable = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreActividad = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        btnGuardarActividad = new javax.swing.JButton();
        cbPuesto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        pnlAddProceso = new javax.swing.JPanel();
        btnNuevoProceso = new javax.swing.JButton();
        cbProcesos = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        pnlDos = new javax.swing.JPanel();
        pnlListaProcesos = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActividades = new javax.swing.JTable();
        cbProcesosLista = new javax.swing.JComboBox();
        btnEditarProceso = new javax.swing.JButton();
        lblProceso = new javax.swing.JLabel();
        btnEliminarActividad = new javax.swing.JButton();
        btnEditarActividad = new javax.swing.JButton();
        btnReporteActiv = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        tabbedProcesos.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        pnlUno  = new  ImagenJPanel ("zzz.jpg");
        pnlUno.setLayout(null);

        pnlProcesos.setOpaque(false);
        pnlProcesos.setPreferredSize(new java.awt.Dimension(670, 450));
        pnlProcesos.setLayout(null);

        pnlAddActiv.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Actividades", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 18), new java.awt.Color(0, 0, 102))); // NOI18N
        pnlAddActiv.setOpaque(false);
        pnlAddActiv.setPreferredSize(new java.awt.Dimension(650, 250));
        pnlAddActiv.setLayout(null);

        lblPuestoResponsable.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblPuestoResponsable.setText("   Puesto Responsable:");
        pnlAddActiv.add(lblPuestoResponsable);
        lblPuestoResponsable.setBounds(10, 140, 160, 30);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel3.setText("Tipo:");
        pnlAddActiv.add(jLabel3);
        jLabel3.setBounds(390, 140, 50, 30);

        txtNombreActividad.setToolTipText("Ingrese el nombre de la actividad");
        pnlAddActiv.add(txtNombreActividad);
        txtNombreActividad.setBounds(160, 30, 470, 30);

        lblNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");
        pnlAddActiv.add(lblNombre);
        lblNombre.setBounds(80, 30, 90, 30);

        cbTipo.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNA OPCIÓN", "ADMINISTRATIVA", "TECNICA", "PROFESIONAL", "DIRECCION", "DE SERVICIO" }));
        cbTipo.setToolTipText("Seleccione el tipo de actividad q ha ingresado");
        pnlAddActiv.add(cbTipo);
        cbTipo.setBounds(440, 140, 190, 30);

        btnGuardarActividad.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnGuardarActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Save.png"))); // NOI18N
        btnGuardarActividad.setText("Guardar");
        btnGuardarActividad.setToolTipText("Guardar informacion del proceso");
        pnlAddActiv.add(btnGuardarActividad);
        btnGuardarActividad.setBounds(280, 190, 120, 40);

        cbPuesto.setToolTipText("Elija a que puesto pertenecera la actividad ingresada");
        pnlAddActiv.add(cbPuesto);
        cbPuesto.setBounds(160, 140, 200, 30);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel1.setText("  Descripcion:   ");
        pnlAddActiv.add(jLabel1);
        jLabel1.setBounds(60, 90, 90, 16);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setToolTipText("Ingrese la descripcion de la actividad que ha sido ingresada");
        jScrollPane2.setViewportView(txtDescripcion);

        pnlAddActiv.add(jScrollPane2);
        jScrollPane2.setBounds(160, 70, 470, 60);

        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/button_cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar si desea salir sin guardar");
        pnlAddActiv.add(btnCancelar);
        btnCancelar.setBounds(400, 190, 110, 40);

        pnlProcesos.add(pnlAddActiv);
        pnlAddActiv.setBounds(10, 130, 650, 270);

        pnlAddProceso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Procesos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 18), new java.awt.Color(0, 0, 102))); // NOI18N
        pnlAddProceso.setOpaque(false);
        pnlAddProceso.setPreferredSize(new java.awt.Dimension(650, 70));
        pnlAddProceso.setLayout(null);

        btnNuevoProceso.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnNuevoProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Edit.png"))); // NOI18N
        btnNuevoProceso.setText("Nuevo");
        btnNuevoProceso.setToolTipText("Ingresar un nuevo proceso");
        pnlAddProceso.add(btnNuevoProceso);
        btnNuevoProceso.setBounds(520, 20, 110, 40);

        cbProcesos.setToolTipText("Nuevos procesos");
        pnlAddProceso.add(cbProcesos);
        cbProcesos.setBounds(20, 25, 460, 30);

        pnlProcesos.add(pnlAddProceso);
        pnlAddProceso.setBounds(10, 40, 650, 70);

        pnlUno.add(pnlProcesos);
        pnlProcesos.setBounds(270, 10, 670, 450);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setText("<html> Este módulo permite realizar el ingreso de<br> procesos,  aquí el Administrador podrá<br> realizar las siguientes tareas: <br>\ningresar, actualizar o eliminar procesos<br> con sus respectivas actividades,  <br>además le admitirá  seleccionar a que puesto<br> responsable se le agregará la actividad ingresada.</html>\n");
        pnlUno.add(jLabel2);
        jLabel2.setBounds(30, 160, 170, 280);

        tabbedProcesos.addTab("NUEVO PROCESO", pnlUno);

        pnlDos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        pnlDos  = new  ImagenJPanel ("zzz.jpg");
        pnlDos.setLayout(null);

        pnlListaProcesos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        pnlListaProcesos.setOpaque(false);
        pnlListaProcesos.setPreferredSize(new java.awt.Dimension(680, 380));
        pnlListaProcesos.setLayout(null);
        pnlListaProcesos.add(txtBuscar);
        txtBuscar.setBounds(390, 260, 270, 30);

        lblBuscar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblBuscar.setText("Buscar:");
        pnlListaProcesos.add(lblBuscar);
        lblBuscar.setBounds(320, 260, 70, 30);

        tblActividades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        tblActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblActividades);

        pnlListaProcesos.add(jScrollPane1);
        jScrollPane1.setBounds(40, 60, 620, 190);
        pnlListaProcesos.add(cbProcesosLista);
        cbProcesosLista.setBounds(120, 20, 340, 30);

        btnEditarProceso.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnEditarProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/AGENDA1.png"))); // NOI18N
        btnEditarProceso.setText("Editar Proceso");
        btnEditarProceso.setToolTipText("Actualizar informcion del proceso");
        pnlListaProcesos.add(btnEditarProceso);
        btnEditarProceso.setBounds(470, 20, 140, 30);

        lblProceso.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblProceso.setText("Proceso:");
        pnlListaProcesos.add(lblProceso);
        lblProceso.setBounds(50, 20, 110, 30);

        btnEliminarActividad.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnEliminarActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnEliminarActividad.setText("Eliminar");
        btnEliminarActividad.setToolTipText("Quitar actividades del sistema");
        pnlListaProcesos.add(btnEliminarActividad);
        btnEliminarActividad.setBounds(150, 260, 100, 40);

        btnEditarActividad.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnEditarActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/AGENDA1.png"))); // NOI18N
        btnEditarActividad.setText("Editar");
        btnEditarActividad.setToolTipText("Actualizar informacion de actividad");
        pnlListaProcesos.add(btnEditarActividad);
        btnEditarActividad.setBounds(40, 260, 100, 40);

        btnReporteActiv.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnReporteActiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/imprimir.png"))); // NOI18N
        btnReporteActiv.setText("Reporte");
        btnReporteActiv.setToolTipText("Resporte de actividades y procesos");
        pnlListaProcesos.add(btnReporteActiv);
        btnReporteActiv.setBounds(550, 310, 120, 40);

        pnlDos.add(pnlListaProcesos);
        pnlListaProcesos.setBounds(290, 40, 680, 380);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel4.setText("<html>Para editar un proceso seleccione de la caja <br> el \"Proceso \"  para actualizar su nombre  <br>y elija  siempre de esta tabla<br> la actividad para poder modificar o eliminar su información  </html>\n\n");
        pnlDos.add(jLabel4);
        jLabel4.setBounds(90, 270, 200, 160);

        tabbedProcesos.addTab("LISTA PROCESOS", pnlDos);

        add(tabbedProcesos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarActividad;
    private javax.swing.JButton btnEditarProceso;
    private javax.swing.JButton btnEliminarActividad;
    private javax.swing.JButton btnGuardarActividad;
    private javax.swing.JButton btnNuevoProceso;
    private javax.swing.JButton btnReporteActiv;
    private javax.swing.JComboBox cbProcesos;
    private javax.swing.JComboBox cbProcesosLista;
    private javax.swing.JComboBox cbPuesto;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProceso;
    private javax.swing.JLabel lblPuestoResponsable;
    private javax.swing.JPanel pnlAddActiv;
    private javax.swing.JPanel pnlAddProceso;
    private javax.swing.JPanel pnlDos;
    private javax.swing.JPanel pnlListaProcesos;
    private javax.swing.JPanel pnlProcesos;
    private javax.swing.JPanel pnlUno;
    private javax.swing.JTabbedPane tabbedProcesos;
    private javax.swing.JTable tblActividades;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombreActividad;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the cbProcesos
     */
    public javax.swing.JComboBox getCbProcesos() {
        return cbProcesos;
    }

    /**
     * @return the cbProcesosLista
     */
    public javax.swing.JComboBox getCbProcesosLista() {
        return cbProcesosLista;
    }

    /**
     * @return the cbTipo
     */
    public javax.swing.JComboBox getCbTipo() {
        return cbTipo;
    }

    /**
     * @return the chbAnual
     */
//    public javax.swing.JCheckBox getChbAnual() {
//        return chbAnual;
//    }

    /**
     * @return the chbDiaria
     */
//    public javax.swing.JCheckBox getChbDiaria() {
//        return chbDiaria;
//    }

    /**
     * @return the chbMensual
     */
//    public javax.swing.JCheckBox getChbMensual() {
//        return chbMensual;
//    }

    /**
     * @return the chbQuincenal
     */
//    public javax.swing.JCheckBox getChbQuincenal() {
//        return chbQuincenal;
//    }

    /**
     * @return the chbSemanal
     */
//    public javax.swing.JCheckBox getChbSemanal() {
//        return chbSemanal;
//    }

    /**
     * @return the spTiempoMin
     */
//    public javax.swing.JSpinner getSpTiempoMin() {
//        return spTiempoMin;
//    }

    /**
     * @return the spVolumen
     */
//    public javax.swing.JSpinner getSpVolumen() {
//        return spVolumen;
//    }

    /**
     * @return the txtBuscar
     */
    public javax.swing.JTextField getTxtBuscar() {
        return txtBuscar;
    }

    /**
     * @return the txtMedioVerif
     */
//    public javax.swing.JTextField getTxtMedioVerif() {
//        return txtMedioVerif;
//    }

    /**
     * @return the txtNombreActividad
     */
    public javax.swing.JTextField getTxtNombreActividad() {
        return txtNombreActividad;
    }

    /**
     * @return the grupoBotones
     */
    public javax.swing.ButtonGroup getGrupoBotones() {
        return grupoBotones;
    }

    /**
     * @return the cbPuesto
     */
    public javax.swing.JComboBox getCbPuesto() {
        return cbPuesto;
    }

    /**
     * @return the tblActividades
     */
    public javax.swing.JTable getTblActividades() {
        return tblActividades;
    }

    /**
     * @return the txtDescripcion
     */
    public javax.swing.JTextArea getTxtDescripcion() {
        return txtDescripcion;
    }

    /**
     * @return the pnlAddActiv
     */
    public javax.swing.JPanel getPnlAddActiv() {
        return pnlAddActiv;
    }

    /**
     * @return the btnGuardarActividad
     */
    public javax.swing.JButton getBtnGuardarActividad() {
        return btnGuardarActividad;
    }

    /**
     * @return the tabbedProcesos
     */
    public javax.swing.JTabbedPane getTabbedProcesos() {
        return tabbedProcesos;
    }

    /**
     * @return the btnCancelar
     */
    public javax.swing.JButton getBtnCancelar() {
        return btnCancelar;
    }

    
    
    class GestorControlProceso extends KeyAdapter implements ActionListener, ChangeListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnNuevoProceso) {
                cpr.guardaProceso();
            } else if (e.getSource() == getBtnGuardarActividad()) {
                if (getBtnGuardarActividad().getText().equals("Guardar")) {
                    if (!cpr.hayVacios()) {
                        int n = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos?", "Guardar", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            cpr.guardaActividad();
                        }
                    } else {
                        Mensaje.camposVacios();
                    }
                } else if (getBtnGuardarActividad().getText().equals("Modificar")) {
                    int n = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos modificados?", "Modificar", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION) {
                            cpr.editarActividad();
                        }
                    
                }
            } else if (e.getSource() == cbProcesosLista) {
                cpr.selecProceso();
            } else if (e.getSource() == btnEditarProceso) {
                cpr.editaProceso();
            } else if (e.getSource() == btnEliminarActividad) {
                if (cpr.isRowSelectedTblActiv()) {
                    int i = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la actividad seleccionada?", "Eliminar", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION) {
                        cpr.eliminarActividad();
                    }
                } else {
                    Mensaje.filaNoSeleccionada();
                }
            } else if (e.getSource() == btnEditarActividad) {
                if (cpr.isRowSelectedTblActiv()) {
                    cpr.getActividadModif();
                } else {
                    Mensaje.filaNoSeleccionada();
                }
            }else if(e.getSource() == btnCancelar){
                cpr.cancelarActividad();
            }else if(e.getSource()==btnReporteActiv){
                cpr.imprimeReporteActiv();
            }
        }

        @Override
        public void keyReleased(KeyEvent e){
            if(e.getSource()==txtBuscar){
                cpr.listaPredictiva(ControladorProceso.idProc, txtBuscar.getText());
            }
        }
        @Override
        public void stateChanged(ChangeEvent e) {
            if (getTabbedProcesos().getSelectedIndex() == 1) {
                cpr.poneComboLstProc();
            }
        }
    }
}