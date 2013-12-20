/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.evaluacion;

import controlador.acciones.Constantes;
import controlador.acciones.ControladorPrincipal;
import controlador.acciones.evaluaciones.ControladorEvaluacion;
import controlador.basedatos.OperacionesBD;
import controlador.propiedades.Propiedades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.evaluacion.Efectos;
import modelo.evaluacion.PeriodoEvaluacion;
import modelo.usuario.Usuario;
import vista.FrmPrincipal;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;
import vista.modelo.OperacionesVarias;

/**
 *
 * @author cristina
 */
public class PnlEvaluacion extends javax.swing.JPanel {

    private final ControladorEvaluacion ce;
    private final GestorControladorEvaluacion gce;
    private ArrayList<Usuario> servidoresDisp;
    private ArrayList<Usuario> servidoresPlanif;
    private Efectos efec;
    private ArrayList<Efectos> efectos;
    private String nombreEf;//nombre efecto
    public ArrayList<PeriodoEvaluacion> periodos;

    /**
     * Creates new form PnlEvaluacion
     */
    public PnlEvaluacion() {
        initComponents();
        ce = new ControladorEvaluacion(this);
        gce = new GestorControladorEvaluacion();
        btnAnterior.setEnabled(false);
        btnResultados.setEnabled(false);
//        ce.llenaCbServidores();
        ce.llenaServidorEscogido();
        actualizaTblPeriodos();
        poneEventos();
        llenaCombo();
        poneTabs();

    }

    private void poneTabs() {
        switch (FrmPrincipal.userLogueado.getRol().getTipo()) {
            case Constantes.SERVIDOR:
                if (FrmPrincipal.estaEvalActiva && FrmPrincipal.userLogueado.isEvaluacionActivada()) {
                    //remover todos los tabs menos el primero y el segundo
                    for (int i = 0; i <= tabbedEvaluacion.getTabCount(); i++) {
                        int ultimo = tabbedEvaluacion.getTabCount() - 1;
                        tabbedEvaluacion.removeTabAt(ultimo);
                    }
                    if (tabbedEvaluacion.getTabCount() == 3) {
                        tabbedEvaluacion.removeTabAt(2);
                    }
                } else {
                    tabbedEvaluacion.removeAll();
                }   break;
            case Constantes.RRHH:
                //remover los primeros 3 tabs
                for (int i = 0; i <= tabbedEvaluacion.getTabCount(); i++) {
                    if (i < tabbedEvaluacion.getTabCount()) {
                        tabbedEvaluacion.removeTabAt(0);
                    }
                }   if (FrmPrincipal.estaEvalActiva) {
                tabbedEvaluacion.removeTabAt(0);
            }   if (tabbedEvaluacion.getTabCount() == 3) {
                tabbedEvaluacion.removeTabAt(0);
            }   break;
            case Constantes.JEFE:
                //remover todos los tabs menos el primero y el segundo
                if (FrmPrincipal.userLogueado.isEvaluacionActivada() && FrmPrincipal.estaEvalActiva) {
                    for (int i = 0; i <= tabbedEvaluacion.getTabCount(); i++) {
                        int ultimo = tabbedEvaluacion.getTabCount() - 1;
                        tabbedEvaluacion.removeTabAt(ultimo);
                    }
                } else {
                    for (int i = 0; i < 2; i++) {//remover los primeros dos tabs
                        tabbedEvaluacion.removeTabAt(0);
                    }
                    tabbedEvaluacion.removeTabAt(tabbedEvaluacion.getTabCount() - 1);
                }   break;
        }
        listarServidores();
        llenaListaDisponibles();
        llenaListaAsignados();
    }

    private void poneEventos() {
        getBtnAnterior().addActionListener(gce);
        getBtnSiguiente().addActionListener(gce);
////        getBtnResultados().addActionListener(gce);
////        cbServidores.addActionListener(gce);
        btnGenerar.addActionListener(gce);
        btnResultados.addActionListener(gce);
        txtFactorConoc.addKeyListener(gce);
        txtFactorCompTec.addKeyListener(gce);
        txtFactorUniv.addKeyListener(gce);
        txtFactorTrab.addKeyListener(gce);
//        tabbedEvaluacion.addChangeListener(gce);
        btnIr.addActionListener(gce);
    }

    private void actualizaTblPeriodos() {
        listarPeriodos();
        modeloTablaPeriodos();
    }

    private void listarPeriodos() {
        periodos = (ArrayList<PeriodoEvaluacion>) OperacionesBD.listar("PeriodoEvaluacion");
    }

    private void modeloTablaPeriodos() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nro");
        dtm.addColumn("Desde");
//        dtm.addColumn("Frecuencia");
//        dtm.addColumn("Medio Verificacion");
        dtm.addColumn("Hasta");
        int n = 1;
        for (PeriodoEvaluacion p : periodos) {
            Object[] act = new Object[5];
            act[0] = n++;
            int hi = p.getFechaInicio().get(Calendar.HOUR_OF_DAY);
            int mi = p.getFechaInicio().get(Calendar.MINUTE);
            act[1] = OperacionesVarias.fechaString(p.getFechaInicio().getTime()) + ", " + hi + ":" + mi;
            int hf = p.getFechaFin().get(Calendar.HOUR_OF_DAY);
            int mf = p.getFechaFin().get(Calendar.MINUTE);
            act[2] = OperacionesVarias.fechaString(p.getFechaFin().getTime()) + ", " + hf + ":" + mf;
            dtm.addRow(act);
        }
        getTblPeriodos().setModel(dtm);
        getTblPeriodos().getColumnModel().getColumn(0).setPreferredWidth(20);
        getTblPeriodos().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedEvaluacion = new javax.swing.JTabbedPane();
        pnlUno = new javax.swing.JPanel();
        pnlDatosServidor = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        lblTituloProf = new javax.swing.JLabel();
        lblPuestoDesemp = new javax.swing.JLabel();
        lblApellNomb = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtNombreApellidos = new javax.swing.JTextField();
        txtPuesto = new javax.swing.JTextField();
        pnlDos = new javax.swing.JPanel();
        pnlEvalServ = new javax.swing.JPanel();
        pnlArriba = new javax.swing.JPanel();
        lblPuesto = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblNombreEvaluado = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnlMedio = new javax.swing.JPanel();
        pnlIndicGestionPuesto = new javax.swing.JPanel();
        pnlCabeceras = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlDatosInf = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTotActivEscen = new javax.swing.JLabel();
        txtTotActEsc = new javax.swing.JTextField();
        pnlInfoIndic = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        scrollDatosIndic = new javax.swing.JScrollPane();
        pnlDatosIndic = new javax.swing.JPanel();
        lblActividades = new javax.swing.JLabel();
        txtNroActividades = new javax.swing.JTextField();
        lblFactor = new javax.swing.JLabel();
        txtFactorIndic = new javax.swing.JTextField();
        lblFactor1 = new javax.swing.JLabel();
        dpDesde = new org.jdesktop.swingx.JXDatePicker();
        dpHasta = new org.jdesktop.swingx.JXDatePicker();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        btnIr = new javax.swing.JButton();
        pnlConocimientos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTotalConocimientos = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        scrollDatosConoc = new javax.swing.JScrollPane();
        pnlDatosConoc = new javax.swing.JPanel();
        lblFactorConoc = new javax.swing.JLabel();
        txtFactorConoc = new javax.swing.JTextField();
        txtNroConocimientos = new javax.swing.JTextField();
        lblConocimientos = new javax.swing.JLabel();
        lblFactor2 = new javax.swing.JLabel();
        pnlCompetTecnicas = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTotalCompTec = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        scrollDatosComp = new javax.swing.JScrollPane();
        pnlDatosComp = new javax.swing.JPanel();
        lblCompetTec = new javax.swing.JLabel();
        txtNroCompetTecnic = new javax.swing.JTextField();
        lblFactCompTec = new javax.swing.JLabel();
        txtFactorCompTec = new javax.swing.JTextField();
        lblFactor3 = new javax.swing.JLabel();
        pnlCompetUniver = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTotalCompUniv = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        scrollDatosCompUnivers = new javax.swing.JScrollPane();
        pnlDatosCompUnivers = new javax.swing.JPanel();
        lblCompetUniv = new javax.swing.JLabel();
        txtNroCompetUniv = new javax.swing.JTextField();
        lblFactorUniv = new javax.swing.JLabel();
        txtFactorUniv = new javax.swing.JTextField();
        lblFactor4 = new javax.swing.JLabel();
        pnlTrabEquipo = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTotalTrabEquip = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        scrollDatosTrabEquipo = new javax.swing.JScrollPane();
        pnlDatosTrabEquipo = new javax.swing.JPanel();
        lblFactorTrab = new javax.swing.JLabel();
        txtFactorTrab = new javax.swing.JTextField();
        lblFactor5 = new javax.swing.JLabel();
        pnlQuejas = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        scrollDatosQuejas = new javax.swing.JScrollPane();
        pnlDatosQuejas = new javax.swing.JPanel();
        txtTotalQuejas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pnlAbajo = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnResultados = new javax.swing.JButton();
        pnlCinco = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIneficienteCalificacion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBuenaCalificacion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDeficienteCalificacion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        cbNombres = new javax.swing.JComboBox();
        btnNuevoNombre = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        pnlSeis = new javax.swing.JPanel();
        pnlFactores = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtIGP = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtCON = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtCTP = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtCU = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtTEIL = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        lblFactor6 = new javax.swing.JLabel();
        lblFactor7 = new javax.swing.JLabel();
        lblFactor8 = new javax.swing.JLabel();
        lblFactor9 = new javax.swing.JLabel();
        lblFactor10 = new javax.swing.JLabel();
        lblFactor12 = new javax.swing.JLabel();
        txtAplica = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAplicarFactores = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        pnlCuatro = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDisponibleParaEval = new javax.swing.JList();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstParaEvaluar = new javax.swing.JList();
        btnAceptar = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        pnlTres = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnAplicar = new javax.swing.JButton();
        lblHasta = new javax.swing.JLabel();
        dateHasta = new org.jdesktop.swingx.JXDatePicker();
        dateDesde = new org.jdesktop.swingx.JXDatePicker();
        lblDesde = new javax.swing.JLabel();
        lblSepHasta = new javax.swing.JLabel();
        lblSepDesde = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPeriodos = new javax.swing.JTable();
        spHoraDesde = new javax.swing.JSpinner();
        spMinDesde = new javax.swing.JSpinner();
        spHoraHasta = new javax.swing.JSpinner();
        spMinHasta = new javax.swing.JSpinner();
        btnEliminarPeriodo = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        tabbedEvaluacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tabbedEvaluacion.setPreferredSize(new java.awt.Dimension(940, 560));

        pnlUno.setOpaque(false);
        pnlUno.setPreferredSize(new java.awt.Dimension(940, 560));
        pnlUno  = new  ImagenJPanel ("zzz.jpg");

        pnlDatosServidor.setOpaque(false);
        pnlDatosServidor.setPreferredSize(new java.awt.Dimension(750, 500));
        pnlDatosServidor.setLayout(null);

        btnGenerar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/arrow-right.png"))); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.setToolTipText("Genra la Evaluación  para el servidor logueado");
        pnlDatosServidor.add(btnGenerar);
        btnGenerar.setBounds(310, 360, 140, 40);

        lblTituloProf.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblTituloProf.setText("   Título o Profesion:");
        pnlDatosServidor.add(lblTituloProf);
        lblTituloProf.setBounds(190, 220, 160, 30);

        lblPuestoDesemp.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblPuestoDesemp.setText("  Puesto que desempeña:");
        pnlDatosServidor.add(lblPuestoDesemp);
        lblPuestoDesemp.setBounds(160, 190, 200, 30);

        lblApellNomb.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblApellNomb.setText("  Apellidos y Nombres:");
        pnlDatosServidor.add(lblApellNomb);
        lblApellNomb.setBounds(180, 160, 160, 30);

        txtTitulo.setEditable(false);
        pnlDatosServidor.add(txtTitulo);
        txtTitulo.setBounds(340, 220, 250, 30);

        txtNombreApellidos.setEditable(false);
        pnlDatosServidor.add(txtNombreApellidos);
        txtNombreApellidos.setBounds(340, 160, 250, 30);

        txtPuesto.setEditable(false);
        pnlDatosServidor.add(txtPuesto);
        txtPuesto.setBounds(340, 190, 250, 30);

        pnlUno.add(pnlDatosServidor);

        tabbedEvaluacion.addTab("DATOS DEL SERVIDOR", pnlUno);

        pnlDos.setOpaque(false);
        pnlDos  = new  ImagenJPanel ("zzz.jpg");
        pnlDos.setLayout(null);

        pnlEvalServ.setOpaque(false);
        pnlEvalServ.setPreferredSize(new java.awt.Dimension(930, 550));
        pnlEvalServ.setLayout(new java.awt.BorderLayout());

        pnlArriba.setOpaque(false);

        lblPuesto.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel29.setText("Nombre Evaluado:");

        jLabel31.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel31.setText("Puesto:");

        javax.swing.GroupLayout pnlArribaLayout = new javax.swing.GroupLayout(pnlArriba);
        pnlArriba.setLayout(pnlArribaLayout);
        pnlArribaLayout.setHorizontalGroup(
            pnlArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArribaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblNombreEvaluado, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlArribaLayout.setVerticalGroup(
            pnlArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlArribaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(lblNombreEvaluado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnlEvalServ.add(pnlArriba, java.awt.BorderLayout.PAGE_START);

        pnlMedio.setOpaque(false);
        pnlMedio.setLayout(new java.awt.CardLayout());

        pnlIndicGestionPuesto.setOpaque(false);
        pnlIndicGestionPuesto.setLayout(null);

        pnlCabeceras.setOpaque(false);
        pnlCabeceras.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html>         Nivel de<br>Cumplimiento</html>");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCabeceras.add(jLabel7);
        jLabel7.setBounds(800, 0, 110, 50);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("% Cumplimiento");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCabeceras.add(jLabel6);
        jLabel6.setBounds(690, 0, 110, 50);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cumplidos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCabeceras.add(jLabel5);
        jLabel5.setBounds(580, 0, 110, 50);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>Meta del<br>Periodo<br>Evaluado</html>");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCabeceras.add(jLabel4);
        jLabel4.setBounds(460, 0, 120, 50);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Indicador");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCabeceras.add(jLabel2);
        jLabel2.setBounds(270, 0, 190, 50);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Descripcion de Actividades");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCabeceras.add(jLabel3);
        jLabel3.setBounds(0, 0, 270, 50);

        pnlIndicGestionPuesto.add(pnlCabeceras);
        pnlCabeceras.setBounds(10, 70, 910, 50);

        pnlDatosInf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlDatosInf.setOpaque(false);
        pnlDatosInf.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>¿A más del cumplimiento de la totalidad de metas y objetivos se adelanto <br> y cumplio con objetivos y metas previstas para el siguiente periodo de evaluacion</html> ");
        pnlDatosInf.add(jLabel1);
        jLabel1.setBounds(24, 2, 443, 64);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("APLICA EL 4%");
        pnlDatosInf.add(jLabel8);
        jLabel8.setBounds(473, 2, 223, 26);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("% DE AUMENTO");
        pnlDatosInf.add(jLabel9);
        jLabel9.setBounds(708, 2, 200, 26);

        pnlIndicGestionPuesto.add(pnlDatosInf);
        pnlDatosInf.setBounds(10, 330, 910, 70);

        lblTotActivEscen.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblTotActivEscen.setText("Total Actividades Esenciales:");
        pnlIndicGestionPuesto.add(lblTotActivEscen);
        lblTotActivEscen.setBounds(540, 410, 190, 14);

        txtTotActEsc.setEditable(false);
        txtTotActEsc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlIndicGestionPuesto.add(txtTotActEsc);
        txtTotActEsc.setBounds(720, 400, 200, 30);

        pnlInfoIndic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlInfoIndic.setOpaque(false);
        pnlInfoIndic.setLayout(null);

        jLabel30.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel30.setText("INDICADORES DE GESTIÓN DEL PUESTO");
        pnlInfoIndic.add(jLabel30);
        jLabel30.setBounds(10, 0, 310, 30);

        pnlIndicGestionPuesto.add(pnlInfoIndic);
        pnlInfoIndic.setBounds(10, 40, 910, 30);

        scrollDatosIndic.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDatosIndic.setOpaque(false);

        pnlDatosIndic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        pnlDatosIndic.setOpaque(false);
        pnlDatosIndic.setVerifyInputWhenFocusTarget(false);
        pnlDatosIndic.setLayout(new javax.swing.BoxLayout(pnlDatosIndic, javax.swing.BoxLayout.Y_AXIS));
        scrollDatosIndic.setViewportView(pnlDatosIndic);

        pnlIndicGestionPuesto.add(scrollDatosIndic);
        scrollDatosIndic.setBounds(10, 120, 910, 210);

        lblActividades.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblActividades.setText("# Actividades: ");
        pnlIndicGestionPuesto.add(lblActividades);
        lblActividades.setBounds(10, 10, 100, 20);

        txtNroActividades.setEditable(false);
        txtNroActividades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlIndicGestionPuesto.add(txtNroActividades);
        txtNroActividades.setBounds(130, 10, 60, 20);

        lblFactor.setText("%");
        pnlIndicGestionPuesto.add(lblFactor);
        lblFactor.setBounds(400, 10, 20, 20);

        txtFactorIndic.setEditable(false);
        txtFactorIndic.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlIndicGestionPuesto.add(txtFactorIndic);
        txtFactorIndic.setBounds(330, 10, 60, 20);

        lblFactor1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblFactor1.setText("# Factor: ");
        pnlIndicGestionPuesto.add(lblFactor1);
        lblFactor1.setBounds(260, 10, 70, 20);

        dpDesde.setToolTipText("Elije la fecha desde el dia  que el jefe va a evaluar");
        pnlIndicGestionPuesto.add(dpDesde);
        dpDesde.setBounds(480, 10, 140, 22);

        dpHasta.setToolTipText("Elije la fecha hasta el dia que el jefe va a evaluar");
        pnlIndicGestionPuesto.add(dpHasta);
        dpHasta.setBounds(700, 10, 140, 22);

        jLabel47.setText("Hasta:");
        pnlIndicGestionPuesto.add(jLabel47);
        jLabel47.setBounds(640, 10, 60, 30);

        jLabel48.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel48.setText("Desde:");
        pnlIndicGestionPuesto.add(jLabel48);
        jLabel48.setBounds(420, 10, 60, 30);

        btnIr.setText("Ir");
        pnlIndicGestionPuesto.add(btnIr);
        btnIr.setBounds(850, 10, 41, 23);

        pnlMedio.add(pnlIndicGestionPuesto, "pnlIndicGestionPuesto");

        pnlConocimientos.setOpaque(false);
        pnlConocimientos.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nivel de Conocimiento");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlConocimientos.add(jLabel11);
        jLabel11.setBounds(550, 70, 370, 50);

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Conocimientos");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlConocimientos.add(jLabel12);
        jLabel12.setBounds(10, 70, 540, 50);

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel13.setText("Total Conocimientos:");
        pnlConocimientos.add(jLabel13);
        jLabel13.setBounds(590, 350, 120, 16);

        txtTotalConocimientos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlConocimientos.add(txtTotalConocimientos);
        txtTotalConocimientos.setBounds(720, 340, 200, 30);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel32.setText("CONOCIMIENTOS");
        jPanel4.add(jLabel32);
        jLabel32.setBounds(10, 0, 310, 30);

        pnlConocimientos.add(jPanel4);
        jPanel4.setBounds(10, 40, 910, 30);

        scrollDatosConoc.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDatosConoc.setOpaque(false);

        pnlDatosConoc.setOpaque(false);
        pnlDatosConoc.setLayout(new javax.swing.BoxLayout(pnlDatosConoc, javax.swing.BoxLayout.Y_AXIS));
        scrollDatosConoc.setViewportView(pnlDatosConoc);

        pnlConocimientos.add(scrollDatosConoc);
        scrollDatosConoc.setBounds(10, 120, 910, 210);

        lblFactorConoc.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblFactorConoc.setText("# Factor: ");
        pnlConocimientos.add(lblFactorConoc);
        lblFactorConoc.setBounds(260, 10, 70, 20);

        txtFactorConoc.setEditable(false);
        txtFactorConoc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlConocimientos.add(txtFactorConoc);
        txtFactorConoc.setBounds(330, 10, 60, 20);

        txtNroConocimientos.setEditable(false);
        txtNroConocimientos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlConocimientos.add(txtNroConocimientos);
        txtNroConocimientos.setBounds(130, 10, 60, 20);

        lblConocimientos.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblConocimientos.setText("# Conocimientos: ");
        pnlConocimientos.add(lblConocimientos);
        lblConocimientos.setBounds(10, 10, 120, 20);

        lblFactor2.setText("%");
        pnlConocimientos.add(lblFactor2);
        lblFactor2.setBounds(400, 10, 20, 20);

        pnlMedio.add(pnlConocimientos, "pnlConocimientos");

        pnlCompetTecnicas.setOpaque(false);
        pnlCompetTecnicas.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Destrezas");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetTecnicas.add(jLabel14);
        jLabel14.setBounds(10, 70, 290, 50);

        jLabel15.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Relevancia");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetTecnicas.add(jLabel15);
        jLabel15.setBounds(300, 70, 170, 50);

        jLabel17.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Comportamiento Observable");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetTecnicas.add(jLabel17);
        jLabel17.setBounds(470, 70, 290, 50);

        jLabel19.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("<html>Nivel de<br>Desarrollo</html>");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetTecnicas.add(jLabel19);
        jLabel19.setBounds(760, 70, 160, 50);

        jLabel16.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel16.setText("Total Competencias Tecnicas del Puesto:");
        pnlCompetTecnicas.add(jLabel16);
        jLabel16.setBounds(450, 340, 270, 16);

        txtTotalCompTec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlCompetTecnicas.add(txtTotalCompTec);
        txtTotalCompTec.setBounds(720, 330, 200, 30);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jLabel33.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel33.setText("COMPETENCIAS TÉCNICAS DEL PUESTO");
        jPanel5.add(jLabel33);
        jLabel33.setBounds(10, 0, 500, 30);

        pnlCompetTecnicas.add(jPanel5);
        jPanel5.setBounds(10, 40, 910, 30);

        scrollDatosComp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDatosComp.setWheelScrollingEnabled(false);

        pnlDatosComp.setOpaque(false);
        pnlDatosComp.setLayout(new javax.swing.BoxLayout(pnlDatosComp, javax.swing.BoxLayout.Y_AXIS));
        scrollDatosComp.setViewportView(pnlDatosComp);

        pnlCompetTecnicas.add(scrollDatosComp);
        scrollDatosComp.setBounds(10, 120, 910, 210);

        lblCompetTec.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblCompetTec.setText("# Competencias: ");
        pnlCompetTecnicas.add(lblCompetTec);
        lblCompetTec.setBounds(10, 10, 120, 20);

        txtNroCompetTecnic.setEditable(false);
        txtNroCompetTecnic.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlCompetTecnicas.add(txtNroCompetTecnic);
        txtNroCompetTecnic.setBounds(130, 10, 60, 20);

        lblFactCompTec.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblFactCompTec.setText("# Factor: ");
        pnlCompetTecnicas.add(lblFactCompTec);
        lblFactCompTec.setBounds(260, 10, 70, 20);

        txtFactorCompTec.setEditable(false);
        txtFactorCompTec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlCompetTecnicas.add(txtFactorCompTec);
        txtFactorCompTec.setBounds(330, 10, 60, 20);

        lblFactor3.setText("%");
        pnlCompetTecnicas.add(lblFactor3);
        lblFactor3.setBounds(400, 10, 20, 20);

        pnlMedio.add(pnlCompetTecnicas, "pnlCompetTecnicas");

        pnlCompetUniver.setOpaque(false);
        pnlCompetUniver.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Destrezas");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetUniver.add(jLabel18);
        jLabel18.setBounds(10, 70, 290, 50);

        jLabel20.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Relevancia");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetUniver.add(jLabel20);
        jLabel20.setBounds(300, 70, 170, 50);

        jLabel21.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Comportamiento Observable");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetUniver.add(jLabel21);
        jLabel21.setBounds(470, 70, 290, 50);

        jLabel22.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("<html>Frecuencia de<br>     Aplicacion</html>");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCompetUniver.add(jLabel22);
        jLabel22.setBounds(760, 70, 160, 50);

        jLabel23.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel23.setText("Total Competencias Universales:");
        pnlCompetUniver.add(jLabel23);
        jLabel23.setBounds(450, 340, 270, 16);

        txtTotalCompUniv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlCompetUniver.add(txtTotalCompUniv);
        txtTotalCompUniv.setBounds(720, 330, 200, 30);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        jLabel34.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel34.setText("COMPETENCIAS UNIVERSALES");
        jPanel6.add(jLabel34);
        jLabel34.setBounds(10, 0, 500, 30);

        pnlCompetUniver.add(jPanel6);
        jPanel6.setBounds(10, 40, 910, 30);

        scrollDatosCompUnivers.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDatosCompUnivers.setOpaque(false);

        pnlDatosCompUnivers.setOpaque(false);
        pnlDatosCompUnivers.setLayout(new javax.swing.BoxLayout(pnlDatosCompUnivers, javax.swing.BoxLayout.Y_AXIS));
        scrollDatosCompUnivers.setViewportView(pnlDatosCompUnivers);

        pnlCompetUniver.add(scrollDatosCompUnivers);
        scrollDatosCompUnivers.setBounds(10, 120, 910, 210);

        lblCompetUniv.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblCompetUniv.setText("# Competencias: ");
        pnlCompetUniver.add(lblCompetUniv);
        lblCompetUniv.setBounds(10, 10, 120, 20);

        txtNroCompetUniv.setEditable(false);
        txtNroCompetUniv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlCompetUniver.add(txtNroCompetUniv);
        txtNroCompetUniv.setBounds(130, 10, 60, 20);

        lblFactorUniv.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblFactorUniv.setText("# Factor: ");
        pnlCompetUniver.add(lblFactorUniv);
        lblFactorUniv.setBounds(260, 10, 70, 20);

        txtFactorUniv.setEditable(false);
        txtFactorUniv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlCompetUniver.add(txtFactorUniv);
        txtFactorUniv.setBounds(330, 10, 60, 20);

        lblFactor4.setText("%");
        pnlCompetUniver.add(lblFactor4);
        lblFactor4.setBounds(400, 10, 20, 20);

        pnlMedio.add(pnlCompetUniver, "pnlCompetUniver");

        pnlTrabEquipo.setOpaque(false);
        pnlTrabEquipo.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Descripción");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTrabEquipo.add(jLabel24);
        jLabel24.setBounds(10, 70, 180, 50);

        jLabel25.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Relevancia");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTrabEquipo.add(jLabel25);
        jLabel25.setBounds(190, 70, 120, 50);

        jLabel26.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Comportamiento Observable");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTrabEquipo.add(jLabel26);
        jLabel26.setBounds(310, 70, 440, 50);

        jLabel27.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("<html>Frecuencia de<br>     Aplicacion</html>");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTrabEquipo.add(jLabel27);
        jLabel27.setBounds(750, 70, 170, 50);

        jLabel28.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel28.setText("Trabajo en equipo iniciativa y liderazgo:");
        pnlTrabEquipo.add(jLabel28);
        jLabel28.setBounds(450, 340, 280, 16);

        txtTotalTrabEquip.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlTrabEquipo.add(txtTotalTrabEquip);
        txtTotalTrabEquip.setBounds(720, 330, 200, 30);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setOpaque(false);
        jPanel7.setLayout(null);

        jLabel35.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel35.setText("TRABAJO EN EQUIPO, INICIATIVA Y LIDERAZGO");
        jPanel7.add(jLabel35);
        jLabel35.setBounds(10, 0, 500, 30);

        pnlTrabEquipo.add(jPanel7);
        jPanel7.setBounds(10, 40, 910, 30);

        scrollDatosTrabEquipo.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDatosTrabEquipo.setOpaque(false);

        pnlDatosTrabEquipo.setOpaque(false);
        pnlDatosTrabEquipo.setLayout(new javax.swing.BoxLayout(pnlDatosTrabEquipo, javax.swing.BoxLayout.Y_AXIS));
        scrollDatosTrabEquipo.setViewportView(pnlDatosTrabEquipo);

        pnlTrabEquipo.add(scrollDatosTrabEquipo);
        scrollDatosTrabEquipo.setBounds(10, 120, 910, 210);

        lblFactorTrab.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        lblFactorTrab.setText("# Factor: ");
        pnlTrabEquipo.add(lblFactorTrab);
        lblFactorTrab.setBounds(10, 10, 70, 20);

        txtFactorTrab.setEditable(false);
        txtFactorTrab.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlTrabEquipo.add(txtFactorTrab);
        txtFactorTrab.setBounds(80, 10, 60, 20);

        lblFactor5.setText("  %");
        pnlTrabEquipo.add(lblFactor5);
        lblFactor5.setBounds(140, 10, 20, 30);

        pnlMedio.add(pnlTrabEquipo, "pnlTrabEquipo");

        pnlQuejas.setOpaque(false);
        pnlQuejas.setLayout(null);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel36.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("QUEJAS DEL CIUDADANO");
        jPanel8.add(jLabel36, java.awt.BorderLayout.CENTER);

        pnlQuejas.add(jPanel8);
        jPanel8.setBounds(10, 40, 910, 30);

        jLabel37.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Descripción");
        jLabel37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuejas.add(jLabel37);
        jLabel37.setBounds(190, 70, 350, 50);

        jLabel40.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("<html>Nro. de<br>formulario</html>");
        jLabel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuejas.add(jLabel40);
        jLabel40.setBounds(540, 70, 90, 50);

        jLabel41.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("<html>Nombre de la persona<br>que realiza la queja</html>");
        jLabel41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuejas.add(jLabel41);
        jLabel41.setBounds(10, 70, 180, 50);

        jLabel42.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("<html>Aplica descuento a<br>la evluación<br>de desempeño</html>");
        jLabel42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuejas.add(jLabel42);
        jLabel42.setBounds(630, 70, 170, 50);

        jLabel43.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("<html>% de<br>reducción</html>");
        jLabel43.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuejas.add(jLabel43);
        jLabel43.setBounds(800, 70, 120, 50);

        scrollDatosQuejas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDatosQuejas.setOpaque(false);

        pnlDatosQuejas.setOpaque(false);
        pnlDatosQuejas.setLayout(new javax.swing.BoxLayout(pnlDatosQuejas, javax.swing.BoxLayout.Y_AXIS));
        scrollDatosQuejas.setViewportView(pnlDatosQuejas);

        pnlQuejas.add(scrollDatosQuejas);
        scrollDatosQuejas.setBounds(10, 120, 910, 210);

        txtTotalQuejas.setEditable(false);
        txtTotalQuejas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlQuejas.add(txtTotalQuejas);
        txtTotalQuejas.setBounds(830, 337, 90, 30);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel10.setText("Total:");
        pnlQuejas.add(jLabel10);
        jLabel10.setBounds(780, 340, 50, 20);

        pnlMedio.add(pnlQuejas, "card7");

        pnlEvalServ.add(pnlMedio, java.awt.BorderLayout.CENTER);

        pnlAbajo.setOpaque(false);

        btnSiguiente.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/agt_forward.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setToolTipText("va al indicador siguiente");

        btnAnterior.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/agt_back.png"))); // NOI18N
        btnAnterior.setText("Anterior");
        btnAnterior.setToolTipText("Regresa al indicador anterior");

        btnResultados.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/business.png"))); // NOI18N
        btnResultados.setText("Resultados");
        btnResultados.setToolTipText("Resultados de la calificación obtenida en cada indicador");

        javax.swing.GroupLayout pnlAbajoLayout = new javax.swing.GroupLayout(pnlAbajo);
        pnlAbajo.setLayout(pnlAbajoLayout);
        pnlAbajoLayout.setHorizontalGroup(
            pnlAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAbajoLayout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        pnlAbajoLayout.setVerticalGroup(
            pnlAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAbajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEvalServ.add(pnlAbajo, java.awt.BorderLayout.PAGE_END);

        pnlDos.add(pnlEvalServ);
        pnlEvalServ.setBounds(56, 5, 930, 550);

        tabbedEvaluacion.addTab("EVALUACIÓN AL SERVIDOR", pnlDos);

        pnlCinco.setOpaque(false);
        pnlCinco.setPreferredSize(new java.awt.Dimension(940, 560));
        pnlCinco  = new  ImagenJPanel ("zzz.jpg");
        pnlCinco.setLayout(null);

        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(400, 480));
        jPanel11.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel38.setText("INEFICIENTE CALIFICACIÓN:");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(10, 330, 170, 16);

        jLabel39.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel39.setText("EFECTOS EVALUACIÓN");
        jPanel11.add(jLabel39);
        jLabel39.setBounds(110, 10, 210, 21);

        jLabel44.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel44.setText("BUENA CALIFICACIÓN:");
        jPanel11.add(jLabel44);
        jLabel44.setBounds(10, 90, 140, 16);

        jLabel45.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel45.setText("DEFICIENTE CALIFICACIÓN:");
        jPanel11.add(jLabel45);
        jLabel45.setBounds(10, 210, 170, 16);

        txtIneficienteCalificacion.setColumns(20);
        txtIneficienteCalificacion.setRows(5);
        jScrollPane1.setViewportView(txtIneficienteCalificacion);

        jPanel11.add(jScrollPane1);
        jScrollPane1.setBounds(10, 350, 380, 96);

        txtBuenaCalificacion.setColumns(20);
        txtBuenaCalificacion.setRows(5);
        jScrollPane4.setViewportView(txtBuenaCalificacion);

        jPanel11.add(jScrollPane4);
        jScrollPane4.setBounds(10, 110, 380, 96);

        txtDeficienteCalificacion.setColumns(20);
        txtDeficienteCalificacion.setRows(5);
        jScrollPane5.setViewportView(txtDeficienteCalificacion);

        jPanel11.add(jScrollPane5);
        jScrollPane5.setBounds(10, 230, 380, 96);

        btnGuardar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/document-save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel11.add(btnGuardar);
        btnGuardar.setBounds(150, 450, 110, 30);

        jLabel46.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel46.setText("NOMBRE:");
        jPanel11.add(jLabel46);
        jLabel46.setBounds(9, 37, 70, 30);

        cbNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNombresActionPerformed(evt);
            }
        });
        jPanel11.add(cbNombres);
        cbNombres.setBounds(80, 40, 200, 30);

        btnNuevoNombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnNuevoNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/AQUA ICONS APPLICATIONS TEXT EDIT1.png"))); // NOI18N
        btnNuevoNombre.setText("Nuevo");
        btnNuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoNombreActionPerformed(evt);
            }
        });
        jPanel11.add(btnNuevoNombre);
        btnNuevoNombre.setBounds(290, 40, 100, 30);

        pnlCinco.add(jPanel11);
        jPanel11.setBounds(321, 5, 400, 480);

        jLabel57.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel57.setText("<html>Ingrese los efectos de la evaluación, <br>llene los campos si la nota es Buena<br> Calificación, Deficiente Calificación e<br> Ineficiente Calificación </html> n</html> ");
        pnlCinco.add(jLabel57);
        jLabel57.setBounds(10, 170, 250, 200);

        tabbedEvaluacion.addTab("EFÉCTOS EVALUACIÓN", pnlCinco);

        pnlSeis.setOpaque(false);
        pnlSeis.setPreferredSize(new java.awt.Dimension(940, 560));
        pnlSeis  = new  ImagenJPanel ("zzz.jpg");
        pnlSeis.setLayout(null);

        pnlFactores.setOpaque(false);
        pnlFactores.setPreferredSize(new java.awt.Dimension(750, 500));
        pnlFactores.setLayout(null);

        jLabel49.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel49.setText("FACTOR PARA INDICADORES DE GESTION DE PUESTO:");
        pnlFactores.add(jLabel49);
        jLabel49.setBounds(110, 70, 340, 14);

        txtIGP.setToolTipText("Fator  que evaluara las activiades por puesto");
        txtIGP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIGPKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIGPKeyReleased(evt);
            }
        });
        pnlFactores.add(txtIGP);
        txtIGP.setBounds(430, 60, 90, 30);

        jLabel50.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel50.setText("                                 FACTOR PARA CONOCIMIENTO:");
        pnlFactores.add(jLabel50);
        jLabel50.setBounds(140, 100, 310, 14);

        txtCON.setToolTipText("Factor que evaluara el conocimiento");
        txtCON.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCONKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCONKeyReleased(evt);
            }
        });
        pnlFactores.add(txtCON);
        txtCON.setBounds(430, 90, 90, 30);

        jLabel51.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel51.setText(" FACTOR PARA COMPETENCIAS TÉCNICAS DE PUESTO:");
        pnlFactores.add(jLabel51);
        jLabel51.setBounds(110, 130, 340, 14);

        txtCTP.setToolTipText("Fator que evaluara las destrezas  de Cometencias Tecnicas de Puesto");
        txtCTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTPKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCTPKeyReleased(evt);
            }
        });
        pnlFactores.add(txtCTP);
        txtCTP.setBounds(430, 120, 90, 30);

        jLabel52.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel52.setText("             FACTOR PARA COMPETENCIAS UNIVERSALES:");
        pnlFactores.add(jLabel52);
        jLabel52.setBounds(120, 160, 330, 14);

        txtCU.setToolTipText("Factor que evaluara las Competencias Universales");
        txtCU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCUKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCUKeyReleased(evt);
            }
        });
        pnlFactores.add(txtCU);
        txtCU.setBounds(430, 150, 90, 30);

        jLabel53.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel53.setText("SUBTOTAL:");
        pnlFactores.add(jLabel53);
        jLabel53.setBounds(340, 220, 90, 14);

        txtTEIL.setToolTipText("Factor que evaluara las Destrezas de Trabajo en Equipo");
        txtTEIL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTEILKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTEILKeyReleased(evt);
            }
        });
        pnlFactores.add(txtTEIL);
        txtTEIL.setBounds(430, 180, 90, 30);

        txtSubTotal.setEditable(false);
        pnlFactores.add(txtSubTotal);
        txtSubTotal.setBounds(430, 210, 90, 30);

        jLabel54.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel54.setText("        TOTAL:");
        pnlFactores.add(jLabel54);
        jLabel54.setBounds(340, 280, 110, 14);

        jLabel55.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel55.setText("FACTOR PARA TRABAJO EN EQUIPO, INICIATIVA Y LIDERAZGO:");
        pnlFactores.add(jLabel55);
        jLabel55.setBounds(70, 190, 380, 14);

        lblFactor6.setText("%");
        pnlFactores.add(lblFactor6);
        lblFactor6.setBounds(530, 240, 20, 20);

        lblFactor7.setText("%");
        pnlFactores.add(lblFactor7);
        lblFactor7.setBounds(530, 60, 20, 20);

        lblFactor8.setText("%");
        pnlFactores.add(lblFactor8);
        lblFactor8.setBounds(530, 90, 20, 20);

        lblFactor9.setText("%");
        pnlFactores.add(lblFactor9);
        lblFactor9.setBounds(530, 120, 20, 20);

        lblFactor10.setText("%");
        pnlFactores.add(lblFactor10);
        lblFactor10.setBounds(530, 150, 20, 20);

        lblFactor12.setText("%");
        pnlFactores.add(lblFactor12);
        lblFactor12.setBounds(530, 180, 20, 20);

        txtAplica.setToolTipText("Porcentaje que se aplicara en caso de haber sobrepasado las metas de las actividades");
        txtAplica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAplicaKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAplicaKeyReleased(evt);
            }
        });
        pnlFactores.add(txtAplica);
        txtAplica.setBounds(430, 240, 90, 30);

        jLabel56.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel56.setText("        APLICA:");
        pnlFactores.add(jLabel56);
        jLabel56.setBounds(340, 250, 110, 14);

        txtTotal.setEditable(false);
        pnlFactores.add(txtTotal);
        txtTotal.setBounds(430, 270, 90, 30);

        btnAplicarFactores.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnAplicarFactores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Select.png"))); // NOI18N
        btnAplicarFactores.setText("Aplicar");
        btnAplicarFactores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarFactoresActionPerformed(evt);
            }
        });
        pnlFactores.add(btnAplicarFactores);
        btnAplicarFactores.setBounds(341, 349, 110, 40);

        jLabel58.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel58.setText("<html>Estos factores  seran actualizados <br>en base a la Normativa SENRES</html> ");
        pnlFactores.add(jLabel58);
        jLabel58.setBounds(550, 70, 200, 200);

        pnlSeis.add(pnlFactores);
        pnlFactores.setBounds(190, 10, 750, 500);

        tabbedEvaluacion.addTab("FACTORES", pnlSeis);

        pnlCuatro.setOpaque(false);
        pnlCuatro.setPreferredSize(new java.awt.Dimension(940, 560));
        pnlCuatro  = new  ImagenJPanel ("zzz.jpg");
        pnlCuatro.setLayout(null);

        jPanel10.setOpaque(false);
        jPanel10.setPreferredSize(new java.awt.Dimension(550, 350));
        jPanel10.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ACTIVACIÓN DE EVALUACIÓN");
        jPanel10.add(lblTitulo);
        lblTitulo.setBounds(180, 20, 250, 30);

        jScrollPane3.setViewportView(lstDisponibleParaEval);

        jPanel10.add(jScrollPane3);
        jScrollPane3.setBounds(40, 60, 200, 200);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/1rightarrow.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel10.add(btnAgregar);
        btnAgregar.setBounds(250, 110, 50, 31);

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/1leftarrow.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel10.add(btnQuitar);
        btnQuitar.setBounds(250, 160, 50, 31);

        jScrollPane2.setViewportView(lstParaEvaluar);

        jPanel10.add(jScrollPane2);
        jScrollPane2.setBounds(310, 60, 200, 200);

        btnAceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Save.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Aceptar para guardar los usuarios activos para la evaluación");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel10.add(btnAceptar);
        btnAceptar.setBounds(220, 290, 120, 40);

        pnlCuatro.add(jPanel10);
        jPanel10.setBounds(246, 5, 550, 350);

        jLabel59.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel59.setText("<html>Seleccione de esta lista los usuarios <br>o servidores que seran evaluados posteriormente<br> y Acepte los cambios realizados para guardar la información</html>");
        pnlCuatro.add(jLabel59);
        jLabel59.setBounds(110, 280, 250, 110);

        tabbedEvaluacion.addTab("ACTIVAR EVALUACIÓN", pnlCuatro);

        pnlTres.setOpaque(false);
        pnlTres.setPreferredSize(new java.awt.Dimension(940, 560));
        pnlTres  = new  ImagenJPanel ("zzz.jpg");
        pnlTres.setLayout(null);

        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(650, 450));
        jPanel9.setLayout(null);

        btnAplicar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnAplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Select.png"))); // NOI18N
        btnAplicar.setText("Aplicar");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });
        jPanel9.add(btnAplicar);
        btnAplicar.setBounds(480, 60, 110, 40);

        lblHasta.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblHasta.setText("Hasta:");
        jPanel9.add(lblHasta);
        lblHasta.setBounds(90, 90, 70, 30);
        jPanel9.add(dateHasta);
        dateHasta.setBounds(160, 90, 180, 30);

        dateDesde.setToolTipText("");
        jPanel9.add(dateDesde);
        dateDesde.setBounds(160, 50, 180, 30);

        lblDesde.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblDesde.setText("Desde:");
        jPanel9.add(lblDesde);
        lblDesde.setBounds(90, 50, 60, 30);

        lblSepHasta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSepHasta.setText(":");
        jPanel9.add(lblSepHasta);
        lblSepHasta.setBounds(400, 90, 10, 30);

        lblSepDesde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSepDesde.setText(":");
        jPanel9.add(lblSepDesde);
        lblSepDesde.setBounds(400, 50, 10, 30);

        tblPeriodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));
        tblPeriodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro", "Desde", "Hasta"
            }
        ));
        jScrollPane6.setViewportView(tblPeriodos);

        jPanel9.add(jScrollPane6);
        jScrollPane6.setBounds(30, 140, 600, 150);

        spHoraDesde.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jPanel9.add(spHoraDesde);
        spHoraDesde.setBounds(350, 50, 50, 20);

        spMinDesde.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel9.add(spMinDesde);
        spMinDesde.setBounds(410, 50, 50, 20);

        spHoraHasta.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jPanel9.add(spHoraHasta);
        spHoraHasta.setBounds(350, 90, 50, 20);

        spMinHasta.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel9.add(spMinHasta);
        spMinHasta.setBounds(410, 90, 50, 20);

        btnEliminarPeriodo.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnEliminarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/button_cancel.png"))); // NOI18N
        btnEliminarPeriodo.setText("Eliminar");
        btnEliminarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeriodoActionPerformed(evt);
            }
        });
        jPanel9.add(btnEliminarPeriodo);
        btnEliminarPeriodo.setBounds(30, 300, 110, 33);

        pnlTres.add(jPanel9);
        jPanel9.setBounds(196, 5, 650, 450);

        jLabel60.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel60.setText("<html>En esta ventana,  seleccionará la fecha  <br>y hora de inicio y fin  para la activación de la <br>evaluación  a los usuarios o servidores del Área<br> y Aplique para Guardar cambios</html>");
        pnlTres.add(jLabel60);
        jLabel60.setBounds(10, 160, 190, 180);

        tabbedEvaluacion.addTab("FECHA EVALUACIÓN", pnlTres);

        add(tabbedEvaluacion, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        Calendar actual = Calendar.getInstance();
        Calendar inicio = Calendar.getInstance();
        Calendar fin = Calendar.getInstance();

        inicio.setTime(dateDesde.getDate());
        inicio.set(Calendar.HOUR_OF_DAY, Integer.parseInt(String.valueOf(spHoraDesde.getValue())));
        inicio.set(Calendar.MINUTE, Integer.parseInt(String.valueOf(spMinDesde.getValue())));
//        System.out.println(inicio.getTime().toString());

        fin.setTime(dateHasta.getDate());
        fin.set(Calendar.HOUR_OF_DAY, Integer.parseInt(String.valueOf(spHoraHasta.getValue())));
        fin.set(Calendar.MINUTE, Integer.parseInt(String.valueOf(spMinHasta.getValue())));
//        System.out.println(fin.getTime().toString());

        if (fin.after(inicio)) {
            if ((inicio.after(actual) || inicio.equals(actual))
                    && (fin.after(actual))) {
                PeriodoEvaluacion pe = new PeriodoEvaluacion(inicio, fin);
                if (OperacionesBD.guardar(pe)) {
                    actualizaTblPeriodos();
                    JOptionPane.showMessageDialog(null, "Periodo asignado correctamente. \n Recuerde: ACTIVAR LA EVALUACIÓN para los servidores correspondientes");
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al asignar el periodo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No puede asignar a una fecha anterior");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La fecha de fin debe ser posterior a la de inicio");
        }
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void listarServidores() {
        servidoresDisp = new ArrayList<>();
        servidoresPlanif = new ArrayList<>();
        ArrayList<Usuario> serv = (ArrayList<Usuario>) OperacionesBD.listar("Usuario");
        String actual = FrmPrincipal.userLogueado.getRol().getTipo();//tipo Servidor, jefe o rrhh
        for (Usuario s : serv) {
            if ((!s.getRol().getTipo().equals(actual)) && !s.isEvaluacionActivada()) {// si es de recursos humanos no se listaran los de rrhh por ejemplo
                if (actual.equals(Constantes.JEFE)
                        && !s.getRol().getTipo().equals(Constantes.RRHH)) {
                    servidoresDisp.add(s);
                } else if (actual.equals(Constantes.RRHH)
                        && !s.getRol().getTipo().equals(Constantes.SERVIDOR)) {
                    servidoresDisp.add(s);
                }
            } else if ((!s.getRol().getTipo().equals(actual)) && s.isEvaluacionActivada()) {
                if ((actual.equals(Constantes.JEFE) && !s.getRol().getTipo().equals(Constantes.RRHH)) || (actual.equals(Constantes.RRHH)
                        && !s.getRol().getTipo().equals(Constantes.SERVIDOR))) {
                    servidoresPlanif.add(s);
                }
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

    private void llenaCombo() {
        efectos = (ArrayList<Efectos>) OperacionesBD.listar("Efectos");
        cbNombres.removeAllItems();
        cbNombres.addItem("Sin Efecto");
        if (!efectos.isEmpty()) {
            for (Efectos e : efectos) {
                cbNombres.addItem(e.getNombre());
            }
        }
    }

    private boolean hayVacios() {
        return txtBuenaCalificacion.getText().isEmpty()
                || txtDeficienteCalificacion.getText().isEmpty()
                || txtIneficienteCalificacion.getText().isEmpty();
    }

    private boolean nombreEscogido() {
        return cbNombres.getSelectedIndex() != 0;
    }
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
    private void suma() {
        try {
            double suma = poneNro(txtCON.getText())
                    + poneNro(txtCTP.getText())
                    + poneNro(txtCU.getText())
                    + poneNro(txtIGP.getText())
                    + poneNro(txtTEIL.getText());
            if (suma <= 100) {
                txtSubTotal.setText(String.valueOf(suma));
            } else {
                JOptionPane.showMessageDialog(this, "La suma de los factores no puede exceder el 100%");
            }

        } catch (NumberFormatException ex) {
        }
    }

    private int poneNro(String s) {
        if (s.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(s);
        }
    }

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (nombreEscogido()) {
            if (!hayVacios()) {
                int opc = JOptionPane.showConfirmDialog(null, "¿Desea guardar el Efecto?", "Guardar", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.YES_OPTION) {
                    if (!OperacionesBD.existe("Efecto", "nombre", nombreEf)) {
                        efec = new Efectos();
                        efec.setNombre(nombreEf);
                        efec.setBueno(txtBuenaCalificacion.getText());
                        efec.setDeficiente(txtDeficienteCalificacion.getText());
                        efec.setIneficiente(txtIneficienteCalificacion.getText());
                        if (OperacionesBD.guardar(efec)) {
                            Mensaje.datosGuardados();
                            limpiaCampos();
                        }
                    } else {
                        efec = efectos.get(cbNombres.getSelectedIndex());
                        efec.setNombre(nombreEf);
                        efec.setBueno(txtBuenaCalificacion.getText());
                        efec.setDeficiente(txtDeficienteCalificacion.getText());
                        efec.setIneficiente(txtIneficienteCalificacion.getText());
                        if (OperacionesBD.modificar(efec)) {
                            Mensaje.datosGuardados();
                        }
                    }
                }
            } else {
                Mensaje.camposVacios();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe escoger el nombre del Efecto");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void limpiaCampos() {
        txtBuenaCalificacion.setText("");
        txtDeficienteCalificacion.setText("");
        txtIneficienteCalificacion.setText("");
    }

    private void cbNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNombresActionPerformed
        if (cbNombres.getSelectedIndex() != -1) {
            nombreEf = cbNombres.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cbNombresActionPerformed

    private void btnNuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoNombreActionPerformed
        nombreEf = JOptionPane.showInputDialog("Ingrese el nombre del Efecto");
        cbNombres.addItem(nombreEf);
    }//GEN-LAST:event_btnNuevoNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        boolean oper = false;
        if (!servidoresPlanif.isEmpty()) {
            for (Usuario u : servidoresPlanif) {
                u.setEvaluacionActivada(true);
                if (OperacionesBD.modificar(u)) {
                    System.out.println("Evaluacion activada a: " + u.getNombre());
                }
            }
            oper = true;
        }
        if (!servidoresDisp.isEmpty()) {
            for (Usuario u : servidoresDisp) {
                u.setEvaluacionActivada(false);
                if (OperacionesBD.modificar(u)) {
                    System.out.println("Evaluacion desactivada a: " + u.getNombre());
                }
            }
            oper = true;
        }
        if (oper) {
            JOptionPane.showMessageDialog(null, "Operacion realizada correctamente ");
        } else {
            JOptionPane.showMessageDialog(null, "Error al realizar la operación");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCONKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCONKeyReleased
        suma();
    }//GEN-LAST:event_txtCONKeyReleased

    private void txtCTPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTPKeyReleased
        suma();
    }//GEN-LAST:event_txtCTPKeyReleased

    private void txtCUKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUKeyReleased
        suma();
    }//GEN-LAST:event_txtCUKeyReleased

    private void txtTEILKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTEILKeyReleased
        suma();
    }//GEN-LAST:event_txtTEILKeyReleased

    private void txtIGPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIGPKeyReleased

        suma();
    }//GEN-LAST:event_txtIGPKeyReleased

    private void txtIGPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIGPKeyTyped
        OperacionesVarias.ingresoSoloNumeros(evt);
    }//GEN-LAST:event_txtIGPKeyTyped

    private void txtCONKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCONKeyTyped
        txtIGPKeyTyped(evt);
    }//GEN-LAST:event_txtCONKeyTyped

    private void txtCTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTPKeyTyped
        txtIGPKeyTyped(evt);
    }//GEN-LAST:event_txtCTPKeyTyped

    private void txtCUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUKeyTyped
        txtIGPKeyTyped(evt);
    }//GEN-LAST:event_txtCUKeyTyped

    private void txtTEILKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTEILKeyTyped
        txtIGPKeyTyped(evt);
    }//GEN-LAST:event_txtTEILKeyTyped

    private void txtAplicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAplicaKeyTyped
        txtIGPKeyTyped(evt);
    }//GEN-LAST:event_txtAplicaKeyTyped

    private void txtAplicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAplicaKeyReleased
        double subt = Double.parseDouble(txtSubTotal.getText());
        if (subt == 100) {
            int n = poneNro(txtAplica.getText());
            double sum = n + subt;
            if (sum <= 105) {
                txtTotal.setText(String.valueOf(sum));
            } else {
                JOptionPane.showMessageDialog(null, "Verifique el valor del campo Aplica, parece ser muy elevado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El valor de subtotal debe ser 100. Verifique los valores ingresados antes de asignar un valor al campo Aplica");
        }
    }//GEN-LAST:event_txtAplicaKeyReleased

    private void btnAplicarFactoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarFactoresActionPerformed
        if (!compruebaVacios()) {
            Propiedades p = new Propiedades();
            Properties prop = p.getProperties("controlador/propiedades/factores.properties");
            prop.setProperty("FIGP", txtIGP.getText());
            prop.setProperty("FCON", txtCON.getText());
            prop.setProperty("FCTP", txtCTP.getText());
            prop.setProperty("FCU", txtCU.getText());
            prop.setProperty("FTIL", txtTEIL.getText());
            prop.setProperty("APLICA", txtAplica.getText());
            p.setProperties(prop, "controlador/propiedades/factores.properties");
            JOptionPane.showMessageDialog(null, "Factores asignados correctamente!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Existen campos vacios");
        }
    }//GEN-LAST:event_btnAplicarFactoresActionPerformed

    private void btnEliminarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeriodoActionPerformed
        int f = tblPeriodos.getSelectedRow();
        if (f != -1) {
            PeriodoEvaluacion pe = periodos.get(f);
            if (OperacionesBD.eliminar(pe, pe.getIdPeriodoEval())) {
                  int n = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la fecha seleccionada, realizada esta accion se desactivara la evaluación?", "Modificar", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                Mensaje.datosEliminados();
                actualizaTblPeriodos();
            } else {
                Mensaje.datosNoEliminados();
            }
        } else {
            Mensaje.filaNoSeleccionada();
        }
            }  
    }//GEN-LAST:event_btnEliminarPeriodoActionPerformed
    private boolean compruebaVacios() {
        return txtIGP.getText().isEmpty()
                || txtCON.getText().isEmpty()
                || txtCTP.getText().isEmpty()
                || txtCU.getText().isEmpty()
                || txtTEIL.getText().isEmpty()
                || txtAplica.getText().isEmpty();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnAplicarFactores;
    private javax.swing.JButton btnEliminarPeriodo;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIr;
    private javax.swing.JButton btnNuevoNombre;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnResultados;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox cbNombres;
    private org.jdesktop.swingx.JXDatePicker dateDesde;
    private org.jdesktop.swingx.JXDatePicker dateHasta;
    private org.jdesktop.swingx.JXDatePicker dpDesde;
    private org.jdesktop.swingx.JXDatePicker dpHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblActividades;
    private javax.swing.JLabel lblApellNomb;
    private javax.swing.JLabel lblCompetTec;
    private javax.swing.JLabel lblCompetUniv;
    private javax.swing.JLabel lblConocimientos;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblFactCompTec;
    private javax.swing.JLabel lblFactor;
    private javax.swing.JLabel lblFactor1;
    private javax.swing.JLabel lblFactor10;
    private javax.swing.JLabel lblFactor12;
    private javax.swing.JLabel lblFactor2;
    private javax.swing.JLabel lblFactor3;
    private javax.swing.JLabel lblFactor4;
    private javax.swing.JLabel lblFactor5;
    private javax.swing.JLabel lblFactor6;
    private javax.swing.JLabel lblFactor7;
    private javax.swing.JLabel lblFactor8;
    private javax.swing.JLabel lblFactor9;
    private javax.swing.JLabel lblFactorConoc;
    private javax.swing.JLabel lblFactorTrab;
    private javax.swing.JLabel lblFactorUniv;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblNombreEvaluado;
    private javax.swing.JLabel lblPuesto;
    private javax.swing.JLabel lblPuestoDesemp;
    private javax.swing.JLabel lblSepDesde;
    private javax.swing.JLabel lblSepHasta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloProf;
    private javax.swing.JLabel lblTotActivEscen;
    private javax.swing.JList lstDisponibleParaEval;
    private javax.swing.JList lstParaEvaluar;
    private javax.swing.JPanel pnlAbajo;
    private javax.swing.JPanel pnlArriba;
    private javax.swing.JPanel pnlCabeceras;
    private javax.swing.JPanel pnlCinco;
    private javax.swing.JPanel pnlCompetTecnicas;
    private javax.swing.JPanel pnlCompetUniver;
    private javax.swing.JPanel pnlConocimientos;
    private javax.swing.JPanel pnlCuatro;
    private javax.swing.JPanel pnlDatosComp;
    private javax.swing.JPanel pnlDatosCompUnivers;
    private javax.swing.JPanel pnlDatosConoc;
    private javax.swing.JPanel pnlDatosIndic;
    private javax.swing.JPanel pnlDatosInf;
    private javax.swing.JPanel pnlDatosQuejas;
    private javax.swing.JPanel pnlDatosServidor;
    private javax.swing.JPanel pnlDatosTrabEquipo;
    private javax.swing.JPanel pnlDos;
    private javax.swing.JPanel pnlEvalServ;
    private javax.swing.JPanel pnlFactores;
    private javax.swing.JPanel pnlIndicGestionPuesto;
    private javax.swing.JPanel pnlInfoIndic;
    private javax.swing.JPanel pnlMedio;
    private javax.swing.JPanel pnlQuejas;
    private javax.swing.JPanel pnlSeis;
    private javax.swing.JPanel pnlTrabEquipo;
    private javax.swing.JPanel pnlTres;
    private javax.swing.JPanel pnlUno;
    private javax.swing.JScrollPane scrollDatosComp;
    private javax.swing.JScrollPane scrollDatosCompUnivers;
    private javax.swing.JScrollPane scrollDatosConoc;
    private javax.swing.JScrollPane scrollDatosIndic;
    private javax.swing.JScrollPane scrollDatosQuejas;
    private javax.swing.JScrollPane scrollDatosTrabEquipo;
    private javax.swing.JSpinner spHoraDesde;
    private javax.swing.JSpinner spHoraHasta;
    private javax.swing.JSpinner spMinDesde;
    private javax.swing.JSpinner spMinHasta;
    private javax.swing.JTabbedPane tabbedEvaluacion;
    private javax.swing.JTable tblPeriodos;
    private javax.swing.JTextField txtAplica;
    private javax.swing.JTextArea txtBuenaCalificacion;
    private javax.swing.JTextField txtCON;
    private javax.swing.JTextField txtCTP;
    private javax.swing.JTextField txtCU;
    private javax.swing.JTextArea txtDeficienteCalificacion;
    private javax.swing.JTextField txtFactorCompTec;
    private javax.swing.JTextField txtFactorConoc;
    private javax.swing.JTextField txtFactorIndic;
    private javax.swing.JTextField txtFactorTrab;
    private javax.swing.JTextField txtFactorUniv;
    private javax.swing.JTextField txtIGP;
    private javax.swing.JTextArea txtIneficienteCalificacion;
    private javax.swing.JTextField txtNombreApellidos;
    private javax.swing.JTextField txtNroActividades;
    private javax.swing.JTextField txtNroCompetTecnic;
    private javax.swing.JTextField txtNroCompetUniv;
    private javax.swing.JTextField txtNroConocimientos;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTEIL;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTotActEsc;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalCompTec;
    private javax.swing.JTextField txtTotalCompUniv;
    private javax.swing.JTextField txtTotalConocimientos;
    private javax.swing.JTextField txtTotalQuejas;
    private javax.swing.JTextField txtTotalTrabEquip;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the pnlMedio
     */
    public javax.swing.JPanel getPnlMedio() {
        return pnlMedio;
    }

//    /**
//     * @return the cbServidores
//     */
//    public javax.swing.JComboBox getCbServidores() {
//        return cbServidores;
//    }
    /**
     * @return the btnAnterior
     */
    public javax.swing.JButton getBtnAnterior() {
        return btnAnterior;
    }

    /**
     * @return the btnSiguiente
     */
    public javax.swing.JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    /**
     * @return the pnlDatosIndic
     */
    public javax.swing.JPanel getPnlDatosIndic() {
        return pnlDatosIndic;
    }

    /**
     * @return the pnlDatosConoc
     */
    public javax.swing.JPanel getPnlDatosConoc() {
        return pnlDatosConoc;
    }

    /**
     * @return the pnlDatosComp
     */
    public javax.swing.JPanel getPnlDatosComp() {
        return pnlDatosComp;
    }

    /**
     * @return the pnlDatosCompUnivers
     */
    public javax.swing.JPanel getPnlDatosCompUnivers() {
        return pnlDatosCompUnivers;
    }

    /**
     * @return the pnlDatosTrabEquipo
     */
    public javax.swing.JPanel getPnlDatosTrabEquipo() {
        return pnlDatosTrabEquipo;
    }

    /**
     * @return the btnResultados
     */
    public javax.swing.JButton getBtnResultados() {
        return btnResultados;
    }

//    /**
//     * @return the txtApellidosNombres
//     */
//    public javax.swing.JTextField getTxtApellidosNombres() {
//        return txtApellidosNombres;
//    }
//
//    /**
//     * @return the txtPuestoDesemp
//     */
//    public javax.swing.JTextField getTxtPuestoDesemp() {
//        return txtPuestoDesemp;
//    }
//
//    /**
//     * @return the txttituloProf
//     */
//    public javax.swing.JTextField getTxttituloProf() {
//        return txttituloProf;
//    }
    /**
     * @return the txtNombreApellidos
     */
    public javax.swing.JTextField getTxtNombreApellidos() {
        return txtNombreApellidos;
    }

    /**
     * @return the txtPuesto
     */
    public javax.swing.JTextField getTxtPuesto() {
        return txtPuesto;
    }

    /**
     * @return the txtTitulo
     */
    public javax.swing.JTextField getTxtTitulo() {
        return txtTitulo;
    }

    /**
     * @return the txtTotalConocimientos
     */
    public javax.swing.JTextField getTxtTotalConocimientos() {
        return txtTotalConocimientos;
    }

    /**
     * @return the txtNroActividades
     */
    public javax.swing.JTextField getTxtNroActividades() {
        return txtNroActividades;
    }

    /**
     * @return the txtNroConocimientos
     */
    public javax.swing.JTextField getTxtNroConocimientos() {
        return txtNroConocimientos;
    }

    /**
     * @return the txtNroCompetTecnic
     */
    public javax.swing.JTextField getTxtNroCompetTecnic() {
        return txtNroCompetTecnic;
    }

    /**
     * @return the txtNroCompetUniv
     */
    public javax.swing.JTextField getTxtNroCompetUniv() {
        return txtNroCompetUniv;
    }

    /**
     * @return the txtTotalCompTec
     */
    public javax.swing.JTextField getTxtTotalCompTec() {
        return txtTotalCompTec;
    }

    /**
     * @return the txtTotalCompUniv
     */
    public javax.swing.JTextField getTxtTotalCompUniv() {
        return txtTotalCompUniv;
    }

    /**
     * @return the txtTotalTrabEquip
     */
    public javax.swing.JTextField getTxtTotalTrabEquip() {
        return txtTotalTrabEquip;
    }

    /**
     * @return the pnlDatosQuejas
     */
    public javax.swing.JPanel getPnlDatosQuejas() {
        return pnlDatosQuejas;
    }

    /**
     * @return the txtTotalQuejas
     */
    public javax.swing.JTextField getTxtTotalQuejas() {
        return txtTotalQuejas;
    }

    /**
     * @return the txtTotActEsc
     */
    public javax.swing.JTextField getTxtTotActEsc() {
        return txtTotActEsc;
    }

    /**
     * @return the tblPeriodos
     */
    public javax.swing.JTable getTblPeriodos() {
        return tblPeriodos;
    }

    class GestorControladorEvaluacion extends KeyAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == getBtnSiguiente()) {
                ce.siguientePanel();
            } else if (e.getSource() == getBtnAnterior()) {
                ce.anteriorPanel();
            } else if (e.getSource() == getBtnResultados()) {
                ce.resultadosFinales();
                btnAnterior.setEnabled(false);
            } //            else if (e.getSource() == cbServidores) {
            //                ce.llenaServidorEscogido();
            //            } 
            else if (e.getSource() == btnGenerar) {
                generacionEval();
            } else if (e.getSource() == btnIr) {
                try {
                    Date desde = dpDesde.getDate();
                    Date hasta = dpHasta.getDate();
                    ce.listarMetas(desde, hasta);
                } catch (NullPointerException npe) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un rango de fechas");
                }
            }
        }

        private void generacionEval() {
            tabbedEvaluacion.setSelectedIndex(1);
            ce.listarSeccion();
            ce.listarCompetenciasTecnicas();
            ce.listarCompetenciasUniversales();
            ce.listarTrabajoEquipo();
            ce.listarQuejas();
            ControladorEvaluacion.txtTotalConoc = getTxtTotalConocimientos();
            ControladorEvaluacion.totConoc = 0;
            propFactores();
            ControladorPrincipal.estaEnEval = true;
        }

        private void propFactores() {
            Propiedades prop = new Propiedades();
            Properties p = prop.getProperties("controlador/propiedades/factores.properties");
            ControladorEvaluacion.facIndic = Double.parseDouble(p.getProperty("FIGP"));
            ControladorEvaluacion.facConoc = Double.parseDouble(p.getProperty("FCON"));
            ControladorEvaluacion.facCompTec = Double.parseDouble(p.getProperty("FCTP"));
            ControladorEvaluacion.facCompUniv = Double.parseDouble(p.getProperty("FCU"));
            ControladorEvaluacion.facTrabEquip = Double.parseDouble(p.getProperty("FTIL"));
            ControladorEvaluacion.aplica = Double.parseDouble(p.getProperty("APLICA"));

            txtFactorIndic.setText(p.getProperty("FIGP"));
            txtFactorConoc.setText(p.getProperty("FCON"));
            txtFactorCompTec.setText(p.getProperty("FCTP"));
            txtFactorUniv.setText(p.getProperty("FCU"));
            txtFactorTrab.setText(p.getProperty("FTIL"));

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() == txtFactorConoc) {
                try {
                    ControladorEvaluacion.facConoc = Double.parseDouble(txtFactorConoc.getText()) / ControladorEvaluacion.secciones.size();
//                    System.out.println("Factor conocimiento: "+ControladorEvaluacion.facConoc);
                } catch (NumberFormatException nfe) {
                }
            } else if (e.getSource() == txtFactorCompTec) {
                try {
                    ControladorEvaluacion.facCompTec = Double.parseDouble(txtFactorCompTec.getText()) / ControladorEvaluacion.compTecnicas.size();
                    //System.out.println("Factor comp tec: "+ControladorEvaluacion.facCompTec+" "+ControladorEvaluacion.compTecnicas.size());
                } catch (NumberFormatException nfe) {
                }
            } else if (e.getSource() == txtFactorUniv) {
                try {
                    ControladorEvaluacion.facCompUniv = Double.parseDouble(txtFactorUniv.getText()) / ControladorEvaluacion.compUniversales.size();
                } catch (NumberFormatException nfe) {
                }
            } else if (e.getSource() == txtFactorTrab) {
                try {
                    if (FrmPrincipal.userLogueado.getRol().getTipo().equals(Constantes.JEFE)) {
                        ControladorEvaluacion.facTrabEquip = Double.parseDouble(txtFactorTrab.getText()) / ControladorEvaluacion.trabequip.size();
                    } else {
                        ControladorEvaluacion.facTrabEquip = Double.parseDouble(txtFactorTrab.getText()) / (ControladorEvaluacion.trabequip.size() - 1);
                    }
                } catch (NumberFormatException nfe) {
                }
            }
        }

    }
}
