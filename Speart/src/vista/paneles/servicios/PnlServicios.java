/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles.servicios;

import controlador.acciones.servicios.ControladorAgenda;
import controlador.acciones.servicios.ControladorRecordatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import vista.FrmPrincipal;
import vista.modelo.Calendario;
import vista.modelo.ImagenJPanel;
import vista.modelo.Mensaje;
import vista.modelo.OperacionesVarias;

/**
 *
 * @author francisco
 */
public class PnlServicios extends javax.swing.JPanel {

    GestorEventosServ ges;
    ControladorRecordatorio cr;
    ControladorAgenda ca;

    /**
     * Creates new form PnlServicios
     */
    public PnlServicios() {
        initComponents();
        poneFechaHora();
        OperacionesVarias.ponerTablaCalendario(tblDiasMes, lblMes);
        ges = new GestorEventosServ();
        cr = new ControladorRecordatorio(this);
        ca = new ControladorAgenda(this);
        poneAcciones();
        ca.poneEnables(false);
        btnGuardarContacto.setText("Guardar");
    }

    private void poneFechaHora() {
        String s = FrmPrincipal.lblHora.getText();
        String l[] = s.split(",");
        String fecha = l[0].trim();
        String hora = l[1].trim();
        lblFecha.setText(fecha);
        lblHora.setText(hora);
    }

    private void poneAcciones() {
        btnAtras.addActionListener(ges);
        btnSiguiente.addActionListener(ges);
        btnNuevo.addActionListener(ges);
        btnEditar.addActionListener(ges);
        btnEliminar.addActionListener(ges);
        btnGuardarContacto.addActionListener(ges);
        tabbedServicios.addChangeListener(ges);
        getTblDiasMes().addMouseListener(ges);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedServicios = new javax.swing.JTabbedPane();
        pnlRecordatorio = new javax.swing.JPanel();
        pnlCalendario = new javax.swing.JPanel();
        lblTxtFecha = new javax.swing.JLabel();
        scrollCalendario = new javax.swing.JScrollPane();
        tblDiasMes = new javax.swing.JTable();
        lblMes = new javax.swing.JLabel();
        lblTxtHora = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        pnlAgenda = new javax.swing.JPanel();
        pnlAgendaContactos = new javax.swing.JPanel();
        scrollAgenda = new javax.swing.JScrollPane();
        tblContactos = new JTable() {
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblTelf = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnGuardarContacto = new javax.swing.JButton();
        lblTituloAgenda = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        pnlRecordatorio  = new  ImagenJPanel ("inicisv.jpg");

        pnlCalendario.setOpaque(false);
        pnlCalendario.setPreferredSize(new java.awt.Dimension(700, 400));
        pnlCalendario.setLayout(null);

        lblTxtFecha.setText("Fecha Actual:");
        pnlCalendario.add(lblTxtFecha);
        lblTxtFecha.setBounds(110, 300, 120, 40);

        tblDiasMes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiasMes.setRowHeight(25);
        tblDiasMes.setRowSelectionAllowed(false);
        scrollCalendario.setViewportView(tblDiasMes);

        pnlCalendario.add(scrollCalendario);
        scrollCalendario.setBounds(60, 120, 590, 180);

        lblMes.setBackground(new java.awt.Color(51, 51, 255));
        lblMes.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lblMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlCalendario.add(lblMes);
        lblMes.setBounds(140, 70, 440, 40);

        lblTxtHora.setText("Hora:");
        pnlCalendario.add(lblTxtHora);
        lblTxtHora.setBounds(440, 300, 60, 40);

        btnSiguiente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguiente.setText(">>");
        btnSiguiente.setToolTipText("Siguiente");
        pnlCalendario.add(btnSiguiente);
        btnSiguiente.setBounds(590, 70, 66, 40);

        btnAtras.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAtras.setText("<<");
        btnAtras.setToolTipText("Anterior");
        pnlCalendario.add(btnAtras);
        btnAtras.setBounds(60, 70, 75, 40);

        lblHora.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        pnlCalendario.add(lblHora);
        lblHora.setBounds(480, 300, 170, 40);

        lblFecha.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        pnlCalendario.add(lblFecha);
        lblFecha.setBounds(220, 300, 200, 40);

        pnlRecordatorio.add(pnlCalendario);

        tabbedServicios.addTab("RECORDATORIO", pnlRecordatorio);

        pnlAgenda  = new  ImagenJPanel ("inicisv.jpg");

        pnlAgendaContactos.setOpaque(false);
        pnlAgendaContactos.setPreferredSize(new java.awt.Dimension(700, 500));
        pnlAgendaContactos.setLayout(null);

        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollAgenda.setViewportView(tblContactos);

        pnlAgendaContactos.add(scrollAgenda);
        scrollAgenda.setBounds(30, 70, 640, 200);

        btnNuevo.setText("Nuevo");
        pnlAgendaContactos.add(btnNuevo);
        btnNuevo.setBounds(30, 280, 90, 30);

        btnEditar.setText("Editar");
        pnlAgendaContactos.add(btnEditar);
        btnEditar.setBounds(130, 280, 90, 30);

        btnEliminar.setText("Eliminar");
        pnlAgendaContactos.add(btnEliminar);
        btnEliminar.setBounds(230, 280, 90, 30);

        lblNombres.setText("Nombres:");
        pnlAgendaContactos.add(lblNombres);
        lblNombres.setBounds(30, 320, 80, 30);
        pnlAgendaContactos.add(txtNombres);
        txtNombres.setBounds(100, 320, 250, 30);

        lblApellidos.setText("Apellidos:");
        pnlAgendaContactos.add(lblApellidos);
        lblApellidos.setBounds(360, 320, 80, 30);
        pnlAgendaContactos.add(txtApellidos);
        txtApellidos.setBounds(420, 320, 250, 30);
        pnlAgendaContactos.add(txtEmail);
        txtEmail.setBounds(100, 350, 250, 30);

        lblEmail.setText("    E-mail:");
        pnlAgendaContactos.add(lblEmail);
        lblEmail.setBounds(30, 350, 80, 30);

        lblTelf.setText("Telf:");
        pnlAgendaContactos.add(lblTelf);
        lblTelf.setBounds(360, 350, 50, 30);
        pnlAgendaContactos.add(txtTelefono);
        txtTelefono.setBounds(420, 350, 90, 30);

        lblCelular.setText("Celular:");
        pnlAgendaContactos.add(lblCelular);
        lblCelular.setBounds(520, 350, 70, 30);
        pnlAgendaContactos.add(txtCelular);
        txtCelular.setBounds(580, 350, 90, 30);

        lblDireccion.setText("   Direccion:");
        pnlAgendaContactos.add(lblDireccion);
        lblDireccion.setBounds(20, 380, 80, 30);
        pnlAgendaContactos.add(txtDireccion);
        txtDireccion.setBounds(100, 380, 470, 30);

        btnGuardarContacto.setText("Guardar");
        pnlAgendaContactos.add(btnGuardarContacto);
        btnGuardarContacto.setBounds(580, 380, 90, 30);

        lblTituloAgenda.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblTituloAgenda.setText("AGENDA DE CONTACTOS");
        pnlAgendaContactos.add(lblTituloAgenda);
        lblTituloAgenda.setBounds(250, 30, 220, 20);

        pnlAgenda.add(pnlAgendaContactos);

        tabbedServicios.addTab("AGENDA DE CONTACTOS", pnlAgenda);

        add(tabbedServicios, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarContacto;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    public static javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTelf;
    private javax.swing.JLabel lblTituloAgenda;
    private javax.swing.JLabel lblTxtFecha;
    private javax.swing.JLabel lblTxtHora;
    private javax.swing.JPanel pnlAgenda;
    private javax.swing.JPanel pnlAgendaContactos;
    private javax.swing.JPanel pnlCalendario;
    private javax.swing.JPanel pnlRecordatorio;
    private javax.swing.JScrollPane scrollAgenda;
    private javax.swing.JScrollPane scrollCalendario;
    private javax.swing.JTabbedPane tabbedServicios;
    private javax.swing.JTable tblContactos;
    private javax.swing.JTable tblDiasMes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tblDiasMes
     */
    public javax.swing.JTable getTblDiasMes() {
        return tblDiasMes;
    }

    /**
     * @return the txtApellidos
     */
    public javax.swing.JTextField getTxtApellidos() {
        return txtApellidos;
    }

    /**
     * @return the txtCelular
     */
    public javax.swing.JTextField getTxtCelular() {
        return txtCelular;
    }

    /**
     * @return the txtDireccion
     */
    public javax.swing.JTextField getTxtDireccion() {
        return txtDireccion;
    }

    /**
     * @return the txtEmail
     */
    public javax.swing.JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * @return the txtNombres
     */
    public javax.swing.JTextField getTxtNombres() {
        return txtNombres;
    }

    /**
     * @return the txtTelefono
     */
    public javax.swing.JTextField getTxtTelefono() {
        return txtTelefono;
    }

    /**
     * @return the tblContactos
     */
    public javax.swing.JTable getTblContactos() {
        return tblContactos;
    }

    class GestorEventosServ extends MouseAdapter implements ActionListener, ChangeListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAtras) {
                Calendario.mesAnterior(getTblDiasMes(), lblMes);
            } else if (e.getSource() == btnSiguiente) {
                Calendario.mesSiguiente(getTblDiasMes(), lblMes);
            } else if (e.getSource() == btnGuardarContacto) {
                switch (btnGuardarContacto.getText()) {
                    case "Guardar": {
                        int i = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos del contacto?", "Guardar", JOptionPane.YES_NO_OPTION);
                        if (i == JOptionPane.YES_OPTION) {
                            ca.guardaContactoAgenda();
                        }
                        break;
                    }
                    case "Modificar": {
                        int i = JOptionPane.showConfirmDialog(null, "¿Desea guardar los datos modificados del contacto?", "Modificar", JOptionPane.YES_NO_OPTION);
                        if (i == JOptionPane.YES_OPTION) {
                            ca.modificarContacto();
                            btnGuardarContacto.setText("Guardar");
                        }
                        break;
                    }
                }

            } else if (e.getSource() == btnEditar) {
                if (ca.filaSeleccionada()) {
                    ca.getContacto();
                    btnGuardarContacto.setText("Modificar");
                } else {
                    Mensaje.filaNoSeleccionada();
                }
            } else if (e.getSource() == btnNuevo) {
                ca.nuevoContacto();
                btnGuardarContacto.setText("Guardar");
            } else if (e.getSource() == btnEliminar) {
                if (ca.filaSeleccionada()) {
                    int i = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el contacto seleccionado?", "Eliminar", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION) {
                        ca.eliminarContacto();
                    }
                } else {
                    Mensaje.filaNoSeleccionada();
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                cr.abreDialogoRecord();
            }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if (tabbedServicios.getSelectedIndex() == 1) {
                ca.actualizar();
            }
        }
    }
}