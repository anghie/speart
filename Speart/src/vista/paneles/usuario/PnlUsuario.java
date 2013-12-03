/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.usuario;

import controlador.acciones.usuario.ControladorUsuario;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;
import vista.modelo.OperacionesVarias;

/**
 *
 * @author 
 */
public final class PnlUsuario extends javax.swing.JPanel {

    /**
     * Creates new form PnlUsuario
     */
    public PnlUsuario() {
        initComponents();
        evh = new GestorEventos();
        cu = new ControladorUsuario(this);
        poneEventos();
        poneHabilitados(false);
    }

    private void poneEventos() {
        txtApellidos.addKeyListener(evh);
        txtCargo.addKeyListener(evh);
        txtCedula.addKeyListener(evh);
        txtHExt.addKeyListener(evh);
        txtHLab.addKeyListener(evh);
        txtRem.addKeyListener(evh);
        txtNombres.addKeyListener(evh);
        txtProfesion.addKeyListener(evh);
        btnGuardarUsuario.addActionListener(evh);
        tblUsuarios.addMouseListener(evh);
        tabbedUsuario.addChangeListener(evh);
        getBtnDeshabilitar().addActionListener(evh);
        btnModificar.addActionListener(evh);
        btnGuardarModificacion.addActionListener(evh);
        btnConocimientos.addActionListener(evh);
//        btnActivEval.addActionListener(evh);
        btnDestrezas.addActionListener(evh);
        btnCancelar.addActionListener(evh);
        btnQuejas.addActionListener(evh);
        txtNomModif.addKeyListener(evh);
        txtApelModif.addKeyListener(evh);
        txtCargoModif.addKeyListener(evh);
        txtProfModif.addKeyListener(evh);
        txtHExtModif.addKeyListener(evh);
        txtHLabModif.addKeyListener(evh);
        txtRemModif.addKeyListener(evh);
        txtCedulaModif.addKeyListener(evh);
        btnReporteUsuario.addActionListener(evh);

    }

    public void poneHabilitados(boolean habilitado) {
        for (Component c : getPnlAccionesModificar().getComponents()) {
            if (c.getClass().equals(JTextField.class)) {
                JTextField t = (JTextField) c;
                t.setEnabled(habilitado);
            }
        }
        btnGuardarModificacion.setEnabled(habilitado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedUsuario = new javax.swing.JTabbedPane();
        pnlCreaUsuario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        btnGuardarUsuario = new javax.swing.JButton();
        pnlDatosAcceso = new javax.swing.JPanel();
        lblConfirm = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtConfirm = new javax.swing.JPasswordField();
        txtClave = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        dateDesde = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pnlDatosEmpleo = new javax.swing.JPanel();
        lblProfesion = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblHLab = new javax.swing.JLabel();
        lblHExt = new javax.swing.JLabel();
        lblRem = new javax.swing.JLabel();
        txtRem = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtProfesion = new javax.swing.JTextField();
        txtHLab = new javax.swing.JTextField();
        txtHExt = new javax.swing.JTextField();
        cbRol = new javax.swing.JComboBox();
        pnlDatosPers = new javax.swing.JPanel();
        lblApellidos = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        pnlListaUsuarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlLstDatos = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        pnlBotones = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnDeshabilitar = new javax.swing.JButton();
        btnConocimientos = new javax.swing.JButton();
        btnDestrezas = new javax.swing.JButton();
        btnQuejas = new javax.swing.JButton();
        btnReporteUsuario = new javax.swing.JButton();
        pnlAccionesModificar = new javax.swing.JPanel();
        lblProfesionModif = new javax.swing.JLabel();
        lblNomModif = new javax.swing.JLabel();
        lblApelModif = new javax.swing.JLabel();
        lblCargoModif = new javax.swing.JLabel();
        txtProfModif = new javax.swing.JTextField();
        txtNomModif = new javax.swing.JTextField();
        txtApelModif = new javax.swing.JTextField();
        txtCargoModif = new javax.swing.JTextField();
        lblRemModif = new javax.swing.JLabel();
        txtRemModif = new javax.swing.JTextField();
        txtHExtModif = new javax.swing.JTextField();
        lblHExtModif = new javax.swing.JLabel();
        txtHLabModif = new javax.swing.JTextField();
        lblHLabModif = new javax.swing.JLabel();
        btnGuardarModificacion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCedulaModif = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        tabbedUsuario.setToolTipText("");
        tabbedUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        pnlCreaUsuario  = new  ImagenJPanel ("zzz.jpg");
        pnlCreaUsuario.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("<html> Este módulo permite realizar el proceso de<br> ingreso de usuarios o servidores  aquí el<br> Administrador podrá realizar las siguientes tareas: <br>\nIngresar, actualizar o eliminar datos de los servidores, <br>además le permitirá agregar los<br> conocimientos,   destrezas y quejas a los<br> servidores para el proceso de evaluación. <br>\nLe permitirá al administrador  Deshabilitar el<br> o los usuarios o servidores cuando estos ya no<br> trabajen para esta institución <br>\nTambién  al momento de deshabilitar <br> un usuario o servidor el administrador<br>  podrá agregar sus actividades a<br> otro usuario </html>\n");
        pnlCreaUsuario.add(jLabel2);
        jLabel2.setBounds(670, 110, 280, 340);

        pnlDatos.setOpaque(false);
        pnlDatos.setPreferredSize(new java.awt.Dimension(540, 600));
        pnlDatos.setLayout(null);

        btnGuardarUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnGuardarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/document-save.png"))); // NOI18N
        btnGuardarUsuario.setText("Guardar");
        btnGuardarUsuario.setToolTipText("Guardar informacion de los usuarios");
        btnGuardarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGuardarUsuario.setPreferredSize(new java.awt.Dimension(90, 35));
        pnlDatos.add(btnGuardarUsuario);
        btnGuardarUsuario.setBounds(210, 540, 110, 40);

        pnlDatosAcceso.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Datos de Acceso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 18), new java.awt.Color(0, 0, 102))); // NOI18N
        pnlDatosAcceso.setOpaque(false);
        pnlDatosAcceso.setPreferredSize(new java.awt.Dimension(520, 170));
        pnlDatosAcceso.setLayout(null);

        lblConfirm.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblConfirm.setText("Confirmación:");
        pnlDatosAcceso.add(lblConfirm);
        lblConfirm.setBounds(10, 110, 100, 30);

        lblUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblUsuario.setText("   Usuario:");
        pnlDatosAcceso.add(lblUsuario);
        lblUsuario.setBounds(30, 50, 70, 30);

        lblClave.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblClave.setText("      Clave:");
        pnlDatosAcceso.add(lblClave);
        lblClave.setBounds(30, 80, 80, 30);

        txtUsuario.setToolTipText("Ingrese el usuario que usuara para ingresar  a su sesión");
        pnlDatosAcceso.add(txtUsuario);
        txtUsuario.setBounds(90, 50, 170, 30);

        txtConfirm.setToolTipText("Ingrese nuevamente la confirmaicón de su clave");
        pnlDatosAcceso.add(txtConfirm);
        txtConfirm.setBounds(90, 110, 170, 30);

        txtClave.setToolTipText("Ingrese la clave que usuara para iniciar sesión");
        pnlDatosAcceso.add(txtClave);
        txtClave.setBounds(90, 80, 170, 30);

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel4.setText("Elija pregunta de seguridad:");
        pnlDatosAcceso.add(jLabel4);
        jLabel4.setBounds(280, 80, 175, 16);

        dateDesde.setToolTipText("");
        pnlDatosAcceso.add(dateDesde);
        dateDesde.setBounds(450, 50, 190, 20);

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setText("Ingrese la fecha de nacimineto");
        pnlDatosAcceso.add(jLabel5);
        jLabel5.setBounds(270, 50, 175, 16);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una", "Lugar de nacimiento de la madre", "Mejor amigo de la infancia", "Nombre de la primera mascota", "Profesor favorito", "Personaje historico favorito", "Ocupación del abuelo", " " }));
        pnlDatosAcceso.add(jComboBox1);
        jComboBox1.setBounds(450, 80, 190, 20);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel6.setText("Responda la pregunta");
        pnlDatosAcceso.add(jLabel6);
        jLabel6.setBounds(280, 110, 130, 16);
        pnlDatosAcceso.add(jTextField2);
        jTextField2.setBounds(420, 110, 220, 20);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Si pierdes la contraseña, ¿cómo podemos ayudarte a restablecerla? ");
        pnlDatosAcceso.add(jLabel7);
        jLabel7.setBounds(280, 30, 350, 14);

        pnlDatos.add(pnlDatosAcceso);
        pnlDatosAcceso.setBounds(10, 360, 650, 170);

        pnlDatosEmpleo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Datos de Empleo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 18), new java.awt.Color(0, 0, 102))); // NOI18N
        pnlDatosEmpleo.setOpaque(false);
        pnlDatosEmpleo.setPreferredSize(new java.awt.Dimension(520, 170));
        pnlDatosEmpleo.setLayout(null);

        lblProfesion.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblProfesion.setText("Profesión:");
        pnlDatosEmpleo.add(lblProfesion);
        lblProfesion.setBounds(270, 40, 80, 30);

        lblRol.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblRol.setText("Rol:");
        pnlDatosEmpleo.add(lblRol);
        lblRol.setBounds(50, 110, 40, 30);

        lblCargo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblCargo.setText(" Cargo:");
        pnlDatosEmpleo.add(lblCargo);
        lblCargo.setBounds(30, 40, 80, 30);

        lblHLab.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblHLab.setText("Horas Lab:");
        pnlDatosEmpleo.add(lblHLab);
        lblHLab.setBounds(10, 75, 80, 30);

        lblHExt.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblHExt.setText("Horas Extra:");
        pnlDatosEmpleo.add(lblHExt);
        lblHExt.setBounds(180, 75, 80, 30);

        lblRem.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblRem.setText("Remuneración:");
        pnlDatosEmpleo.add(lblRem);
        lblRem.setBounds(340, 75, 100, 30);

        txtRem.setToolTipText("Ingrese la remuneración segun su cargo");
        pnlDatosEmpleo.add(txtRem);
        txtRem.setBounds(440, 75, 60, 30);

        txtCargo.setToolTipText("Ingrese el cargo para esta oficina");
        pnlDatosEmpleo.add(txtCargo);
        txtCargo.setBounds(100, 40, 150, 30);

        txtProfesion.setToolTipText("Ingrese su Profesión");
        pnlDatosEmpleo.add(txtProfesion);
        txtProfesion.setBounds(350, 40, 150, 30);

        txtHLab.setToolTipText("Ingrese sus horas laborables para su cargo");
        pnlDatosEmpleo.add(txtHLab);
        txtHLab.setBounds(100, 75, 60, 30);

        txtHExt.setToolTipText("Ingrese las horas  extras para su cargo");
        pnlDatosEmpleo.add(txtHExt);
        txtHExt.setBounds(270, 75, 60, 30);

        cbRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servidor", "Jefe", "Jefe RRHH" }));
        cbRol.setToolTipText("Ingrese el rol  que ejerce en esta  Área");
        pnlDatosEmpleo.add(cbRol);
        cbRol.setBounds(100, 110, 170, 30);

        pnlDatos.add(pnlDatosEmpleo);
        pnlDatosEmpleo.setBounds(60, 180, 520, 170);

        pnlDatosPers.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Datos personales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB", 0, 18), new java.awt.Color(0, 0, 102))); // NOI18N
        pnlDatosPers.setOpaque(false);
        pnlDatosPers.setPreferredSize(new java.awt.Dimension(520, 170));
        pnlDatosPers.setLayout(null);

        lblApellidos.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos:");
        pnlDatosPers.add(lblApellidos);
        lblApellidos.setBounds(120, 100, 70, 30);

        lblCedula.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblCedula.setText("   Cédula:");
        pnlDatosPers.add(lblCedula);
        lblCedula.setBounds(120, 30, 70, 30);

        lblNombres.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblNombres.setText("Nombres:");
        pnlDatosPers.add(lblNombres);
        lblNombres.setBounds(120, 65, 70, 30);

        txtApellidos.setToolTipText("Ingrese sus apellidos completos");
        pnlDatosPers.add(txtApellidos);
        txtApellidos.setBounds(200, 100, 190, 30);

        txtCedula.setToolTipText("Ingrese su cédula");
        pnlDatosPers.add(txtCedula);
        txtCedula.setBounds(200, 30, 190, 30);

        txtNombres.setToolTipText("Ingrese sus nombres completos");
        pnlDatosPers.add(txtNombres);
        txtNombres.setBounds(200, 65, 190, 30);

        pnlDatos.add(pnlDatosPers);
        pnlDatosPers.setBounds(60, 0, 520, 170);

        pnlCreaUsuario.add(pnlDatos);
        pnlDatos.setBounds(10, 10, 660, 590);

        tabbedUsuario.addTab("CREAR USUARIO", pnlCreaUsuario);

        pnlListaUsuarios  = new  ImagenJPanel ("zzz.jpg");
        pnlListaUsuarios.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel3.setText("<html>Seleccione siempre de esta tabla<br> al Servidor el cual se podra modificar<br> su información personal, podra ser<br> deshabilitado y para agregar Conocimientos,<br> Destrezas y Quejas para el proceso de evaluación </html> n</html> ");
        pnlListaUsuarios.add(jLabel3);
        jLabel3.setBounds(10, 270, 150, 200);

        pnlLstDatos.setOpaque(false);
        pnlLstDatos.setPreferredSize(new java.awt.Dimension(740, 550));
        pnlLstDatos.setLayout(null);

        scrollTabla.setPreferredSize(new java.awt.Dimension(550, 200));

        tblUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres y Apellidos", "Cargo", "Habilitado"
            }
        ));
        scrollTabla.setViewportView(tblUsuarios);

        pnlLstDatos.add(scrollTabla);
        scrollTabla.setBounds(60, 20, 600, 200);

        pnlBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        pnlBotones.setOpaque(false);
        pnlBotones.setPreferredSize(new java.awt.Dimension(550, 50));
        pnlBotones.setLayout(null);

        btnModificar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/kwrite.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Actalizar datos del usuario");
        pnlBotones.add(btnModificar);
        btnModificar.setBounds(10, 10, 120, 40);

        btnDeshabilitar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnDeshabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/personal.png"))); // NOI18N
        btnDeshabilitar.setText("Deshabilitar");
        btnDeshabilitar.setToolTipText("Desactivar usuario del sistema");
        pnlBotones.add(btnDeshabilitar);
        btnDeshabilitar.setBounds(140, 10, 130, 40);

        btnConocimientos.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnConocimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/add.png"))); // NOI18N
        btnConocimientos.setText("Conocimientos");
        btnConocimientos.setToolTipText("Agregar conocimientos a los usuarios");
        pnlBotones.add(btnConocimientos);
        btnConocimientos.setBounds(280, 10, 130, 40);

        btnDestrezas.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnDestrezas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/list-add-user.png"))); // NOI18N
        btnDestrezas.setText("Destrezas");
        pnlBotones.add(btnDestrezas);
        btnDestrezas.setBounds(420, 10, 120, 40);

        btnQuejas.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnQuejas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/PatientMale.png"))); // NOI18N
        btnQuejas.setText("Quejas");
        btnQuejas.setToolTipText("Agregar quejas a los usuarios");
        pnlBotones.add(btnQuejas);
        btnQuejas.setBounds(550, 10, 110, 40);

        btnReporteUsuario.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnReporteUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/imprimir.png"))); // NOI18N
        btnReporteUsuario.setText("Reporte");
        pnlBotones.add(btnReporteUsuario);
        btnReporteUsuario.setBounds(663, 10, 117, 40);

        pnlLstDatos.add(pnlBotones);
        pnlBotones.setBounds(10, 230, 790, 60);

        pnlAccionesModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 2));
        pnlAccionesModificar.setOpaque(false);
        pnlAccionesModificar.setLayout(null);

        lblProfesionModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblProfesionModif.setText("Profesión:");
        pnlAccionesModificar.add(lblProfesionModif);
        lblProfesionModif.setBounds(320, 90, 90, 30);

        lblNomModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblNomModif.setText("Nombres: ");
        pnlAccionesModificar.add(lblNomModif);
        lblNomModif.setBounds(30, 50, 90, 30);

        lblApelModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblApelModif.setText("Apellidos:");
        pnlAccionesModificar.add(lblApelModif);
        lblApelModif.setBounds(30, 90, 90, 30);

        lblCargoModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblCargoModif.setText("Cargo:");
        pnlAccionesModificar.add(lblCargoModif);
        lblCargoModif.setBounds(340, 50, 90, 30);
        pnlAccionesModificar.add(txtProfModif);
        txtProfModif.setBounds(400, 90, 200, 30);
        pnlAccionesModificar.add(txtNomModif);
        txtNomModif.setBounds(100, 50, 210, 30);
        pnlAccionesModificar.add(txtApelModif);
        txtApelModif.setBounds(100, 90, 210, 30);
        pnlAccionesModificar.add(txtCargoModif);
        txtCargoModif.setBounds(400, 50, 200, 30);

        lblRemModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblRemModif.setText("Remuneración:");
        pnlAccionesModificar.add(lblRemModif);
        lblRemModif.setBounds(340, 130, 100, 30);
        pnlAccionesModificar.add(txtRemModif);
        txtRemModif.setBounds(440, 130, 60, 30);
        pnlAccionesModificar.add(txtHExtModif);
        txtHExtModif.setBounds(270, 130, 60, 30);

        lblHExtModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblHExtModif.setText("Horas Extra:");
        pnlAccionesModificar.add(lblHExtModif);
        lblHExtModif.setBounds(180, 130, 80, 30);
        pnlAccionesModificar.add(txtHLabModif);
        txtHLabModif.setBounds(100, 130, 60, 30);

        lblHLabModif.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblHLabModif.setText("Horas Lab:");
        pnlAccionesModificar.add(lblHLabModif);
        lblHLabModif.setBounds(20, 130, 80, 30);

        btnGuardarModificacion.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnGuardarModificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/Save.png"))); // NOI18N
        btnGuardarModificacion.setText("Guardar");
        pnlAccionesModificar.add(btnGuardarModificacion);
        btnGuardarModificacion.setBounds(330, 170, 120, 40);

        btnCancelar.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        pnlAccionesModificar.add(btnCancelar);
        btnCancelar.setBounds(450, 170, 110, 40);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel1.setText("Cédula:");
        pnlAccionesModificar.add(jLabel1);
        jLabel1.setBounds(30, 10, 80, 30);
        pnlAccionesModificar.add(txtCedulaModif);
        txtCedulaModif.setBounds(100, 10, 210, 30);

        pnlLstDatos.add(pnlAccionesModificar);
        pnlAccionesModificar.setBounds(50, 300, 620, 220);

        pnlListaUsuarios.add(pnlLstDatos);
        pnlLstDatos.setBounds(170, 10, 810, 550);

        tabbedUsuario.addTab("LISTA USUARIOS", pnlListaUsuarios);

        add(tabbedUsuario, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConocimientos;
    private javax.swing.JButton btnDeshabilitar;
    private javax.swing.JButton btnDestrezas;
    private javax.swing.JButton btnGuardarModificacion;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuejas;
    private javax.swing.JButton btnReporteUsuario;
    private javax.swing.JComboBox cbRol;
    private org.jdesktop.swingx.JXDatePicker dateDesde;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblApelModif;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargoModif;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblHExt;
    private javax.swing.JLabel lblHExtModif;
    private javax.swing.JLabel lblHLab;
    private javax.swing.JLabel lblHLabModif;
    private javax.swing.JLabel lblNomModif;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblProfesion;
    private javax.swing.JLabel lblProfesionModif;
    private javax.swing.JLabel lblRem;
    private javax.swing.JLabel lblRemModif;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlAccionesModificar;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCreaUsuario;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatosAcceso;
    private javax.swing.JPanel pnlDatosEmpleo;
    private javax.swing.JPanel pnlDatosPers;
    private javax.swing.JPanel pnlListaUsuarios;
    private javax.swing.JPanel pnlLstDatos;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTabbedPane tabbedUsuario;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApelModif;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCargoModif;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaModif;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JTextField txtHExt;
    private javax.swing.JTextField txtHExtModif;
    private javax.swing.JTextField txtHLab;
    private javax.swing.JTextField txtHLabModif;
    private javax.swing.JTextField txtNomModif;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtProfModif;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JTextField txtRem;
    private javax.swing.JTextField txtRemModif;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    private GestorEventos evh;
    private ControladorUsuario cu;

    /**
     * @return the btnGuardar
     */
    public javax.swing.JButton getBtnGuardar() {
        return btnGuardarUsuario;
    }

    /**
     * @return the txtApellidos
     */
    public javax.swing.JTextField getTxtApellidos() {
        return txtApellidos;
    }

    /**
     * @return the txtCedula
     */
    public javax.swing.JTextField getTxtCedula() {
        return txtCedula;
    }

    /**
     * @return the txtNombres
     */
    public javax.swing.JTextField getTxtNombres() {
        return txtNombres;
    }

    /**
     * @return the txtClave
     */
    public javax.swing.JPasswordField getTxtClave() {
        return txtClave;
    }

    /**
     * @return the txtConfirm
     */
    public javax.swing.JPasswordField getTxtConfirm() {
        return txtConfirm;
    }

    /**
     * @return the txtHExt
     */
    public javax.swing.JTextField getTxtHExt() {
        return txtHExt;
    }

    /**
     * @return the txtHLab
     */
    public javax.swing.JTextField getTxtHLab() {
        return txtHLab;
    }

    /**
     * @return the txtProfesion
     */
    public javax.swing.JTextField getTxtProfesion() {
        return txtProfesion;
    }

    /**
     * @return the txtRem
     */
    public javax.swing.JTextField getTxtRem() {
        return txtRem;
    }

    /**
     * @return the txtUsuario
     */
    public javax.swing.JTextField getTxtUsuario() {
        return txtUsuario;
    }

    /**
     * @return the txtCargo
     */
    public javax.swing.JTextField getTxtCargo() {
        return txtCargo;
    }

    /**
     * @return the tblUsuarios
     */
    public javax.swing.JTable getTblUsuarios() {
        return tblUsuarios;
    }

    /**
     * @return the cbRol
     */
    public javax.swing.JComboBox getCbRol() {
        return cbRol;
    }

    /**
     * @return the btnDeshabilitar
     */
    public javax.swing.JButton getBtnDeshabilitar() {
        return btnDeshabilitar;
    }

    /**
     * @return the txtApelModif
     */
    public javax.swing.JTextField getTxtApelModif() {
        return txtApelModif;
    }

    /**
     * @return the txtCargoModif
     */
    public javax.swing.JTextField getTxtCargoModif() {
        return txtCargoModif;
    }

    /**
     * @return the txtHExtModif
     */
    public javax.swing.JTextField getTxtHExtModif() {
        return txtHExtModif;
    }

    /**
     * @return the txtHLabModif
     */
    public javax.swing.JTextField getTxtHLabModif() {
        return txtHLabModif;
    }

    /**
     * @return the txtNomModif
     */
    public javax.swing.JTextField getTxtNomModif() {
        return txtNomModif;
    }

    /**
     * @return the txtProfModif
     */
    public javax.swing.JTextField getTxtProfModif() {
        return txtProfModif;
    }

    /**
     * @return the txtRemModif
     */
    public javax.swing.JTextField getTxtRemModif() {
        return txtRemModif;
    }

    /**
     * @return the pnlAccionesModificar
     */
    public javax.swing.JPanel getPnlAccionesModificar() {
        return pnlAccionesModificar;
    }

    /**
     * @return the txtCedulaModif
     */
    public javax.swing.JTextField getTxtCedulaModif() {
        return txtCedulaModif;
    }

    /**
     * @return the pnlDatosAcceso
     */
    public javax.swing.JPanel getPnlDatosAcceso() {
        return pnlDatosAcceso;
    }

    /**
     * @return the pnlDatosEmpleo
     */
    public javax.swing.JPanel getPnlDatosEmpleo() {
        return pnlDatosEmpleo;
    }

    /**
     * @return the pnlDatosPers
     */
    public javax.swing.JPanel getPnlDatosPers() {
        return pnlDatosPers;
    }

    class GestorEventos extends MouseAdapter implements ActionListener, ChangeListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == btnGuardarUsuario) {
                if (!cu.verificaVacios()) {
                    int n = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos?", "Guardar", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        cu.guardaUsuario();
                    }
                } else {
                    Mensaje.camposVacios();
                }
            } else if (evt.getSource() == btnModificar) {
                if (cu.isRowSelected()) {
                    poneHabilitados(true);
                    cu.getUsuario();
                    cu.getRol();
                } else {
                    Mensaje.filaNoSeleccionada();
                }
            } else if (evt.getSource() == btnDeshabilitar) {
                if (cu.isRowSelected()) {
//                    int i = JOptionPane.showConfirmDialog(null, "¿Desea agregar las actividades a otro usuario?", "Actividads", JOptionPane.YES_NO_OPTION);
//                    if (i == JOptionPane.YES_OPTION) {                        
//                        cu.abreDialogUsuarios();
//                    } else {
                        cu.desHabilitarUsuario();
                    }else {
                    Mensaje.filaNoSeleccionada();
                }
            } else if (evt.getSource() == btnGuardarModificacion) {
                if (!cu.verificaVaciosModif()) {
                    int n = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos modificados?", "Modificar", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        cu.modificarUsuario();
                    } else {
                        cu.limpiaCamposModif();
                    }
                } else {
                    Mensaje.camposVacios();
                }
            } else if (evt.getSource() == btnConocimientos) {
                cu.abreDialogConocUsuario();
            } 
//            else if (evt.getSource() == btnActivEval) {
//                cu.abreDialogEscogeActividades();
//            } 
            else if (evt.getSource() == btnDestrezas) {
                cu.abreDialogCompetTecnica();
            } else if (evt.getSource() == btnQuejas) {
                cu.abreDialogQuejas();
            } else if (evt.getSource() == btnCancelar) {
                cu.limpiaCamposModif();
            }else if (evt.getSource() == btnReporteUsuario){
                cu.imprimeUsuarios();
            }
        }

        @Override
        public void keyTyped(KeyEvent evt) {
            if (evt.getSource() == getTxtCedula()) {
                OperacionesVarias.ingresoNumCedula(evt, getTxtCedula().getText());
            } else if (evt.getSource() == getTxtCedulaModif()) {
                OperacionesVarias.ingresoNumCedula(evt, getTxtCedulaModif().getText());
            } else if (evt.getSource() == getTxtNombres() || evt.getSource() == getTxtApellidos()
                    || evt.getSource() == getTxtCargo() || evt.getSource() == getTxtProfesion()
                    || evt.getSource() == getTxtNomModif() || evt.getSource() == getTxtApelModif()
                    || evt.getSource() == getTxtProfModif() || evt.getSource() == getTxtCargoModif()) {
                OperacionesVarias.ingresoSoloLetras(evt);
            } else if (evt.getSource() == getTxtHLab() || evt.getSource() == getTxtHExt()
                    || evt.getSource() == getTxtRem() || evt.getSource() == getTxtHExtModif()
                    || evt.getSource() == getTxtHLabModif() || evt.getSource() == getTxtRemModif()) {
                OperacionesVarias.ingresoSoloNumeros(evt);
            } 
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if (tabbedUsuario.getSelectedIndex() == 1) {
                cu.actualizaTabla();
            } else if (tabbedUsuario.getSelectedIndex() == 0) {
                btnDeshabilitar.setText("Deshabilitar");
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (cu.isRowSelected()) {
                cu.cambiaTextoBtnDeshab();
                poneHabilitados(false);
            }
            if(tblUsuarios.getSelectedColumn()==3){
              cu.celdaSeleccionada();
           }
        }
    }
}
