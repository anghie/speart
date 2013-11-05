package vista;

import controlador.acciones.ControladorPermisos;
import javax.swing.*;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.*;
import vista.modelo.*;
import controlador.acciones.ControladorPrincipal;
import controlador.acciones.agenda.ControladorAgenda;
import modelo.usuario.Usuario;
import vista.modelo.paneles.agenda.PanelAgenda;
import vista.paneles.evaluacion.PnlEvaluacion;
import vista.paneles.operaciones.PnlOperaciones;
import vista.paneles.proceso.PnlProcesos;
import vista.paneles.respaldos.PnlRespaldos;
import vista.paneles.servicios.DialogoAgendaContactos;
import vista.paneles.servicios.DialogoCalendarioRecor;
import vista.paneles.usuario.DialogCambiaClave;
import vista.paneles.usuario.PnlUsuario;

public class FrmPrincipal extends JFrame {

    private JMenuBar barraMenu;
    private JMenu menuInicio;
    private JMenu mimenuSesion;
    private JMenuItem miIniciaSesion;
    private JMenuItem miCierraSesion;
    private JMenuItem miCambiaClave;
    private JMenuItem miSalir;
    private JMenu menuServicios;
    private JMenuItem miAgenda;
    private JMenuItem miRecordatorio;
//    private JMenuItem miInforme;
    private JMenuItem miMeta;
//    private JMenu menuAgregados;
//    private JMenuItem miFechaEval;
//    private JMenuItem miActivEval;
//    private JMenuItem miEfectos;
    private JMenu menuAyuda;
    private JMenuItem miAcercaDe;
    private JMenuItem miAyuda;
    private JPanel pnlSur;
    public static JLabel lblHora;
    private JToolBar tbOeste;
//    private JButton btnInicio;
    private JButton btnUsuarios;
    private JButton btnProcesos;
//    private JButton btnServicios;
    private JButton btnRespaldos;
    private JButton btnOperaciones;
    private JButton btnEvaluacion;
    private JPanel pnlMedio;
    private JPanel pnlImagen;
    private ClassLoader cl;
    private EventHandler esc;
    private ControladorPrincipal cp;
    public static Usuario userLogueado;
    public static boolean estaEvalActiva;
    private JButton btnAgenda;
    private JButton btnReportes;
    private JMenuItem miGeneraAgenda;
    private JMenu menuReportes;
    private JMenuItem miReporteEvaluaciones;
    private JMenuItem miReporteUsuarios;
    private static FrmPrincipal fp = null;

    private FrmPrincipal() {
        cl = FrmPrincipal.class.getClassLoader();
        iniciaComponentes();
        estaEvalActiva=ControladorPrincipal.verificaPeriodoEvaluacion();
//        ControladorPrincipal.listarFechasEval();
//        System.out.println(estaEvalActiva);
        
    }

    public synchronized static FrmPrincipal getInstance() {
        if (fp == null) {
            fp = new FrmPrincipal();
        }
        return fp;
    }

    private void iniciaComponentes() {
        this.setTitle("SPEIESS 2013");
//        this.setLocationRelativeTo(null);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(d);
        this.setIconImage(new ImageIcon(cl.getResource("vista/imagenes/linux.png")).getImage());
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        esc = new EventHandler();
        cp = ControladorPrincipal.getInstance(this);
        poneImagenLogo();
        ponePanelInferior();
        poneBarraMenu();
        poneToolbarOeste();
        ControladorPermisos.permisoInvitado();
        ponePermisos();
    }

    public void ponePermisos() {
        btnEvaluacion.setVisible(ControladorPermisos.evaluaciones);
        btnOperaciones.setVisible(ControladorPermisos.operaciones);
        btnProcesos.setVisible(ControladorPermisos.procesos);
        btnRespaldos.setVisible(ControladorPermisos.respaldos);
//        btnServicios.setVisible(ControladorPermisos.servicios);
        btnUsuarios.setVisible(ControladorPermisos.usuarios);
        menuServicios.setVisible(ControladorPermisos.servicios);
        miIniciaSesion.setVisible(ControladorPermisos.itemAbreSesion);
        miCierraSesion.setVisible(ControladorPermisos.itemCierraSesion);
        miCambiaClave.setVisible(ControladorPermisos.itemCambiaClave);
        btnAgenda.setVisible(ControladorPermisos.agenda);
        btnReportes.setVisible(ControladorPermisos.usuarios);
        miAgenda.setVisible(ControladorPermisos.miAgendaCont);
        miGeneraAgenda.setVisible(ControladorPermisos.miGeneraAgenda);
        miMeta.setVisible(ControladorPermisos.miAdminMeta);
//        menuAgregados.setVisible(ControladorPermisos.menuAgregados);
        menuReportes.setVisible(ControladorPermisos.menuReportes);
//        miActivEval.setVisible(ControladorPermisos.miActivaEval);
//        miFechaEval.setVisible(ControladorPermisos.miFechaEval);
//        miEfectos.setVisible(ControladorPermisos.miEfectosEval);

    }

    private void poneImagenLogo() {
        pnlMedio = new JPanel();
        pnlMedio.setLayout(new BorderLayout());

        //Poniendo imagen y logo
        pnlImagen = new ImagenJPanel("zzz.jpg");
        pnlImagen.setLayout(new BorderLayout());
        JLabel lblTitulo = new JLabel("<html><br>SPEIESS</html>", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 15));
        //  JLabel lblLogo = new JLabel(new ImageIcon(cl.getResource("vista/imagenes/logo-iess.png")));
        JLabel lblCopyright = new JLabel("Copyright 2013 - Todos los derechos reservados", SwingConstants.CENTER);
        lblCopyright.setFont(new Font("Dialog", Font.BOLD, 13));
        //Agregando los componentes al panel
        pnlImagen.add(lblTitulo, BorderLayout.NORTH);
        // pnlImagen.add(lblLogo, BorderLayout.);
        pnlImagen.add(lblCopyright, BorderLayout.SOUTH);
        //Añadiendo el panel imagen al panel central
        pnlMedio.add(pnlImagen, BorderLayout.CENTER);
        this.add(pnlMedio, BorderLayout.CENTER);

    }
    /*Metodo que ubica el panel inferior con la fecha y hora*/

    private void ponePanelInferior() {
        pnlSur = new JPanel();
        pnlSur.setLayout(new BorderLayout());
        lblHora = LblHora.getInstance();
        pnlSur.add(lblHora, BorderLayout.EAST);
        this.add(pnlSur, BorderLayout.SOUTH);
    }
    /*Método para poner la barra de menus*/

    private void poneBarraMenu() {
        barraMenu = new JMenuBar();
        /*MENU INICIO*/
        menuInicio = new JMenu("Inicio");
        menuInicio.setFont(new Font("Broadway", Font.BOLD, 15));
        menuServicios = new JMenu("Servicios");
        menuServicios.setFont(new Font("Broadway", Font.BOLD, 15));
//        menuAgregados = new JMenu("Agregados");
//        menuAgregados.setFont(new Font("Broadway", Font.BOLD, 15));
        menuAyuda = new JMenu("Ayuda");
        menuAyuda.setFont(new Font("Broadway", Font.BOLD, 15));
        menuReportes = new JMenu("Reportes");
        menuReportes.setFont(new Font("Broadway", Font.BOLD, 15));
        //Item Sesión
        mimenuSesion = new JMenu();
        creaMenuItem(mimenuSesion, menuInicio, "Sesion", "Iniciar/Cerrar Sesion", "lockstart_session.png");
        //MenuItem Inicia Sesion
        miIniciaSesion = new JMenuItem();
        creaMenuItem(getMiIniciaSesion(), mimenuSesion, "Inicia Sesion", "Inicia una nueva sesion usando un usuario y clave", "sesionIn.png");
        getMiIniciaSesion().addActionListener(esc);
        //MenuItem Cierra Sesion
        miCierraSesion = new JMenuItem();
        creaMenuItem(getMiCierraSesion(), mimenuSesion, "Cierra Sesion", "Cierra la sección actual", "logout.png");
        getMiCierraSesion().addActionListener(esc);
        //MenuItem Cambia Clave
        miCambiaClave = new JMenuItem();
        creaMenuItem(getMiCambiaClave(), mimenuSesion, "Cambia Clave", "Cambia la clave del usuario actual", "password_1.png");
        getMiCambiaClave().addActionListener(esc);
        //Item Salir
        miSalir = new JMenuItem();
        creaMenuItem(miSalir, menuInicio, " Salir ", "Salir del programa", "shutdown.png");
        miSalir.addActionListener(esc);
        miSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
        //Item Agenda
        miAgenda = new JMenuItem();
        creaMenuItem(miAgenda, getMenuServicios(), "Agenda de contactos", "Gestion de Contactos", "agendaTelefonica.png");
        miAgenda.addActionListener(esc);

        //Item Recordatorio
        miRecordatorio = new JMenuItem();
        creaMenuItem(miRecordatorio, menuServicios, "Recordatorio", "Cree sus propios recordatorios", "null.png");
        miRecordatorio.addActionListener(esc);
//        //Item Informe
//        miInforme = new JMenuItem();
//        creaMenuItem(miInforme, menuServicios, "Informe Actividades", "Llenar el informa de actividades del usuario", "copiarbarra.png");
//        miInforme.addActionListener(esc);
        //Item Informe
        miMeta = new JMenuItem();
        creaMenuItem(miMeta, menuServicios, "Administrar Metas", "Administrar las metas palnteadas por los usuario", "agendaTelefonica.png");
        miMeta.addActionListener(esc);

        //Item Acerca
        miAcercaDe = new JMenuItem();
        creaMenuItem(miAcercaDe, menuAyuda, "Acerca de... ", "Informacion acerca del programa", "svn_status.png");
        miAcercaDe.addActionListener(esc);
        //Item Ayuda
        miAyuda = new JMenuItem();
        creaMenuItem(miAyuda, menuAyuda, "Ayuda", "Ayuda acerca el funcionamiento del programa", "help_2.png");
        miAyuda.addActionListener(esc);

        //Item Genera Experto Agenda
        miGeneraAgenda = new JMenuItem();
        creaMenuItem(miGeneraAgenda, menuServicios, "Genera Agenda", "Generador de agendas", "agendaTelefonica.png");
        miAgenda.addActionListener(esc);


        //Item Reportes
        miReporteEvaluaciones = new JMenuItem();
        creaMenuItem(miReporteEvaluaciones, menuReportes, "Genera Reporte Evaluacion", "Genera el reporte de las evaluaciones", "imprimeRep.jpg");
        miReporteEvaluaciones.addActionListener(esc);

        //Item Reporte Usuarios
        miReporteUsuarios = new JMenuItem();
        creaMenuItem(miReporteUsuarios, menuReportes, "Genera Reporte Usuarios", "Generar el reporte de los usuarios en el sistema", "null.png");
        miReporteUsuarios.addActionListener(esc);
        //Item Efectos
//        miEfectos = new JMenuItem();
//        creaMenuItem(miEfectos, menuAgregados, "Efectos Evaluación", "Los efectos que se asignaran a las evaluaciones", "null.png");
//        miEfectos.addActionListener(esc);

        //Añadiendo a la barraMenu y luego a la pantalla
        barraMenu.add(menuInicio);
        barraMenu.add(getMenuServicios());
//        barraMenu.add(menuAgregados);
        barraMenu.add(menuReportes);
        barraMenu.add(menuAyuda);
        poneEventosMenuItems();
        this.add(barraMenu, BorderLayout.NORTH);
    }

    /**
     * Metodo de creación y añadido de un menu item a un menu
     *
     * @param item el menu item inicializado
     * @param menu el menu donde sera ubicado el menu item
     * @param texto el texto del menu item
     * @param tooltip el mensaje que se mostrará al pasar el raton
     * @param imagen la imagen que se pondrá en el menu item
     *
     */
    private void creaMenuItem(JMenuItem item, JMenu menu, String texto, String tooltip, String imagen) {
        item.setText(texto);
        item.setFont(new Font("Dialog", Font.BOLD, 12));
        item.setToolTipText(tooltip);
        item.setIcon(new ImageIcon(cl.getResource("vista/imagenes/" + imagen)));
        menu.add(item);
    }
    /*Método que asigna los eventos a los menuitems*/

    private void poneEventosMenuItems() {
        /**
         * itera sobre todos los componentes de la barra de menú, se les asigna
         * el mismo manejador de eventos a todos excepto a los separadores
         */
        for (Component c1 : barraMenu.getComponents()) {
            //si el componente es un menú
            if (c1.getClass().equals(javax.swing.JMenu.class)) {
                //itera sobre los componentes del menú
                for (Component c2 : ((JMenu) c1).getMenuComponents()) {
                    //si el componente no es un separador
                    if (!c2.getClass().equals(javax.swing.JPopupMenu.Separator.class)) {
                        ((JMenuItem) c2).addActionListener(esc);
                    }
                }
            }
        }
    }
    //-------------------------------------------------------------------
	/*Método para poner el panel de botones izquierdo*/

    private void poneToolbarOeste() {
        tbOeste = new JToolBar();
        tbOeste.setFloatable(false);
        tbOeste.setBackground(new Color(145, 183, 61));
        tbOeste.setOrientation(SwingConstants.VERTICAL);
        tbOeste.setRollover(true);
        tbOeste.setOpaque(true);


        //Para el boton Inicio
//        btnInicio = new JButton("Inicio");
//        creaBotonToolbar(btnInicio, "Extra_sign.png");
        //Para el boton Usuarios
        btnUsuarios = new JButton("Usuarios");
        creaBotonToolbar(getBtnUsuarios(), "033.png");
        btnUsuarios.setToolTipText("<html> Ingresar usuarios al sistema</html> ");
        //Para el botón Procesos
        btnProcesos = new JButton("Procesos");
        creaBotonToolbar(getBtnProcesos(), "procesos.png");
        btnProcesos.setToolTipText("<html> Ingresar procesos al sistema</html> ");
        btnAgenda = new JButton("Agenda");
        creaBotonToolbar(btnAgenda, "agen.png");
        btnAgenda.setToolTipText("<html> Ingresar actividades a la agenda</html> ");
        //Para el botón Operaciones
        btnOperaciones = new JButton("Operaciones");
        creaBotonToolbar(getBtnOperaciones(), "opera.png");
        btnOperaciones.setToolTipText("<html> Ingresar Operaciones al sistema</html> ");
        //Para el botón Evaluación
        btnEvaluacion = new JButton("Evaluación");
        creaBotonToolbar(getBtnEvaluacion(), "eva.png");
        btnEvaluacion.setToolTipText("<html> Evaluacion de servidor</html> ");
        //Para el botón Servicios
//        btnServicios = new JButton("Servicios");
//        creaBotonToolbar(getBtnServicios(), "kwrite.png");
        //Para el botón Respaldos
        btnRespaldos = new JButton("Respaldos");
        creaBotonToolbar(getBtnRespaldos(), "resp.png");
        btnRespaldos.setToolTipText("<html> Respaldar la informacion del sistema</html> ");




        btnReportes = new JButton("Reportes");
        creaBotonToolbar(btnReportes, "kword.png");
        btnReportes.setToolTipText("<html> Obtener reportes impresos de la informacion del sistema</html> ");
        poneEventosToolbar();
        //Añadiendo la barra al la ventana
        this.add(tbOeste, BorderLayout.WEST);
    }
    /*Crea un botón que será agregado en la toolbar
     * @param btn el botón inicializado para editar sus atributos
     * @param nombreIcono el nombre del icono que se le asignará al boton
     * */

    private void creaBotonToolbar(JButton btn, String nombreIcono) {
        btn.setIcon(new ImageIcon(cl.getResource("vista/imagenes/" + nombreIcono)));
        btn.setFocusable(false);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setMaximumSize(new Dimension(80, 80));
        btn.setMinimumSize(new Dimension(80, 80));
        btn.setPreferredSize(new Dimension(80, 80));
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        tbOeste.add(btn);
    }
    /*Metodo que asigna los eventos a los botones de la toolbar*/

    private void poneEventosToolbar() {
        /**
         * itera sobre todos los componentes de la barra de herramientas, se les
         * asigna el mismo margen y el mismo manejador de eventos unicamente a
         * los botones
         */
        for (Component c : tbOeste.getComponents()) {
            //si el componente es un botón
            if (c.getClass().equals(javax.swing.JButton.class)) {
                JButton jb = (JButton) c;
                jb.setMargin(new Insets(0, 0, 0, 0));
                jb.addActionListener(esc);
            }
        }
    }
    //****************************
    //*    GETTERS Y SETTERS     *
    //****************************

    public JPanel getPnlMedio() {
        return pnlMedio;
    }

    public JPanel getPnlImagen() {
        return pnlImagen;
    }

    /**
     * @return the miIniciaSesion
     */
    public JMenuItem getMiIniciaSesion() {
        return miIniciaSesion;
    }

    /**
     * @return the miCierraSesion
     */
    public JMenuItem getMiCierraSesion() {
        return miCierraSesion;
    }

    /**
     * @return the miCambiaClave
     */
    public JMenuItem getMiCambiaClave() {
        return miCambiaClave;
    }

    /**
     * @return the menuServicios
     */
    public JMenu getMenuServicios() {
        return menuServicios;
    }

    /**
     * @return the btnUsuarios
     */
    public JButton getBtnUsuarios() {
        return btnUsuarios;
    }

    /**
     * @return the btnProcesos
     */
    public JButton getBtnProcesos() {
        return btnProcesos;
    }

//    /**
//     * @return the btnServicios
//     */
//    public JButton getBtnServicios() {
//        return btnServicios;
//    }
    /**
     * @return the btnRespaldos
     */
    public JButton getBtnRespaldos() {
        return btnRespaldos;
    }

    /**
     * @return the btnOperaciones
     */
    public JButton getBtnOperaciones() {
        return btnOperaciones;
    }

    /**
     * @return the btnEvaluacion
     */
    public JButton getBtnEvaluacion() {
        return btnEvaluacion;
    }

    //****************************
    //*ACCIONES PARA COMPONENTES *
    //****************************
    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == miSalir) {
                System.exit(0);
            } else if (evt.getSource() == mimenuSesion) {
                System.out.println("Presiono sesion");
            } else if (evt.getSource() == getBtnUsuarios()) {
                cp.ponePanel(new PnlUsuario());
                setTitle("SPEIESS 2013 - Panel de Usuarios");
            } else if (evt.getSource() == getBtnProcesos()) {
                cp.ponePanel(new PnlProcesos());
                setTitle("SPEIESS 2013 - Panel de Procesos");
            } //            else if (evt.getSource() == getBtnServicios()) {
            //                cp.ponePanel(new PnlServicios());
            //                setTitle("SPEIESS 2013 - Panel de Servicios");
            //            }
            else if (evt.getSource() == getBtnRespaldos()) {
                cp.ponePanel(new PnlRespaldos());
                setTitle("SPEIESS 2013 - Panel de respaldos");
            } else if (evt.getSource() == getBtnOperaciones()) {
                cp.ponePanel(new PnlOperaciones());
                setTitle("SPEIESS 2013 - Panel de Operaciones");
            } else if (evt.getSource() == btnAgenda) {
                if (userLogueado.getRol().getTipo().equals("Jefe")) {
                    DialogoUsuarios dialogServidores = new DialogoUsuarios(userLogueado, cp, FrmPrincipal.this, true);
                    dialogServidores.setLocationRelativeTo(null);
                    dialogServidores.setVisible(true);
                } else {
                    cp.ponePanel(new PanelAgenda("inicisv_1.jpg", userLogueado));
                }
                setTitle("SPEIESS 2013 - Panel Agenda Usuario");
            } else if (evt.getSource() == btnReportes) {
                DialogoReportes reportes = new DialogoReportes(FrmPrincipal.this, true, ControladorAgenda.getAgendaActual());
                reportes.setLocationRelativeTo(null);
                reportes.setVisible(true);
            } else if (evt.getSource() == miGeneraAgenda) {
                cp.ponePanel(new PnlUsuario());
                DialogoExpertoAgenda dialogoAgenda = new DialogoExpertoAgenda(new JFrame(), true);
                dialogoAgenda.setLocationRelativeTo(null);
                dialogoAgenda.setVisible(true);
            } else if (evt.getSource() == getBtnEvaluacion()) {
//                JOptionPane.showMessageDialog(null, "Aun no se han activado las evaluaciones");
                cp.ponePanel(new PnlEvaluacion());
            } else if (evt.getSource() == getMiIniciaSesion()) {
                cp.abreLogin();
            } else if (evt.getSource() == getMiCierraSesion()) {
                cp.cierraSesion();
            } //            else if (evt.getSource() == miInforme) {
            //                cp.escogeUsuario();
            //            }
            else if (evt.getSource() == miCambiaClave) {
                DialogCambiaClave dcc = DialogCambiaClave.getInstance();
                if (!dcc.isActive()) {
                    dcc.setVisible(true);
                }
            } //            else if (evt.getSource() == miFechaEval) {
            //                DialogoFechaEvaluacion dfe = DialogoFechaEvaluacion.getInstance();
            //                if (!dfe.isActive()) {
            //                    dfe.setVisible(true);
            //                }
            //            } 
            //            else if (evt.getSource() == miActivEval) {
            //                DialogActivarEvaluacion dae = DialogActivarEvaluacion.getInstance();
            //                if (!dae.isActive()) {
            //                    dae.setVisible(true);
            //                }
            //            } 
            //            else if (evt.getSource() == miEfectos) {
            //                DialogEfectos de = DialogEfectos.getInstance();
            //                if (!de.isActive()) {
            //                    de.setVisible(true);
            //                }
            //            } 
            else if (evt.getSource() == miMeta) {
                DialogoMeta dialogo = DialogoMeta.getInstance(userLogueado);
                if (!dialogo.isActive()) {
                    dialogo.setLocationRelativeTo(null);
                    dialogo.setVisible(true);
                }
            } else if (evt.getSource() == miAgenda) {
                DialogoAgendaContactos dac = DialogoAgendaContactos.getInstance();
                if (!dac.isActive()) {
                    dac.setVisible(true);
                }
            } else if (evt.getSource() == miRecordatorio) {
                DialogoCalendarioRecor dcr = DialogoCalendarioRecor.getInstance();
                if (!dcr.isActive()) {
                    dcr.setVisible(true);
                }
            } else if (evt.getSource() == miReporteUsuarios) {
                cp.reporteUsuarios();
            }
        }
    }
}
