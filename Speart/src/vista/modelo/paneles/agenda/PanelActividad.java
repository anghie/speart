/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelActividad.java
 *
 * Created on 17/11/2012, 08:14:56 PM
 */

package vista.modelo.paneles.agenda;


import controlador.acciones.agenda.ControladorActividades;
import controlador.acciones.servicios.ControladorAgenda;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.agenda.Agenda;
import modelo.agenda.ItemAgenda;
import modelo.proceso.Actividad;
import modelo.usuario.Usuario;
import vista.DialogoEditarItemAgenda;
import vista.modelo.Fecha;
import vista.modelo.ModeloComboBoxActividad;

/**
 *
 * @author alf
 */
public class PanelActividad extends javax.swing.JPanel {

    /** Creates new form PanelActividad */
    private boolean compacto;
    private ItemAgenda itemAgenda;
    private JPanel panelContenedor;
    private LinkedList<Actividad>listaActividades;
    private ModeloComboBoxActividad modeloCmbActividades;
    private Usuario usuario;
    public PanelActividad(boolean compacto, ItemAgenda itemAgenda, JPanel panelContenedor,Usuario usuario) {
        this.usuario=usuario;
        this.compacto=compacto;
        this.itemAgenda=itemAgenda;
        this.panelContenedor=panelContenedor;
        iniciarServidores();
        initComponents();
        
        System.out.println(usuario);
        //chbTerminada.setEnabled(false);
          btEditar.setVisible(false);
          btnEliminar.setVisible(false);
        if(!itemAgenda.isCompletada()){// && usuario.getRol().getTipo().equals("Jefe") 
            btEditar.setVisible(true);
            btnEliminar.setVisible(true);
            this.setComponentPopupMenu(popUpMenu);
        }
        if (compacto || getSize().getHeight()<40) {
            setPreferredSize(new Dimension(420, 40));
        }
        loadItemAgenda();
    }
    public void loadItemAgenda(){
       setBackground(Color.WHITE);
       chbTerminada.setSelected(itemAgenda.isCompletada());
       spnPorcentaje.setValue(itemAgenda.getPorcentaje());
       txtObservacion.setText(itemAgenda.getObservacion());
       int h=itemAgenda.getHoraInicio().getHours();
       int m=itemAgenda.getHoraInicio().getMinutes();
       int y=ControladorAgenda.calcularPinceles(h, m);
       this.setBounds(this.getX(), 
                       y,
                       420,
                       ControladorAgenda.calcularPinceles(itemAgenda.getTiempoDuracion().getHours(),itemAgenda.getTiempoDuracion().getMinutes()));
       if(itemAgenda.getActividad()!=null){
//            lblActividad.setText("Actividad:"+itemAgenda.getActividad().getNombreActividad());
          int index=((ModeloComboBoxActividad)cmbServidor.getModel()).getIndex(itemAgenda.getActividad());
           if(index>-1){
                cmbServidor.setSelectedIndex(index);
                if(itemAgenda.getActividad().getRol()!=null){
                    lblCargo.setText("Cargo:"+itemAgenda.getActividad().getRol().getCargo());
                    lblEncargado.setText("Encargado:"+itemAgenda.getActividad().getRol().getUsuario().getNombre()+" "+itemAgenda.getActividad().getRol().getUsuario().getApellidos());
                 }
            }
                
         }
        lblTiempo.setText("Tiempo: "+itemAgenda.getTiempoDuracion().getHours()+":h "+itemAgenda.getTiempoDuracion().getMinutes()+":min");
        lblHoraInicio.setText("Inicia:"+itemAgenda.getHoraInicio().getHours()+":h "+itemAgenda.getHoraInicio().getMinutes()+":min");
        lblHpraTermina.setText("Termina:"+itemAgenda.getHoraFin().getHours()+":h "+itemAgenda.getHoraFin().getMinutes()+":min");
        lblFecha.setText("Fecha:"+itemAgenda.getDia()+" "+itemAgenda.getDia_del_mes()+" "+itemAgenda.getMes());
        
        this.setToolTipText(getTxtInfo());
    }
    
    private void iniciarServidores(){
       listaActividades=ControladorActividades.getAllActividades();
//       System.out.println(listaActividades);
       modeloCmbActividades=new ModeloComboBoxActividad(listaActividades);
    }
    
    public void setTiempoDuracion(Date hora){
        lblTiempo.setText("Tiempo: "+hora.getHours()+":h "+hora.getMinutes()+":min");
        setToolTipText(getTxtInfo());
    }
    public void setTiempoDuracion(String hora){
        lblTiempo.setText("Tiempo: "+hora);
        setToolTipText(getTxtInfo());
    }
    public void setTxtFecha(String fecha){
        lblFecha.setText("Fecha:"+fecha);
        setToolTipText(getTxtInfo());
    }
    public void setTxtActividad(String actividad){
//        lblActividad.setText("Actividad:"+actividad);
        setToolTipText(getTxtInfo());
    }
    public void setTxtEncargado(String encargado){
        lblEncargado.setText("Encargado:"+encargado);
        setToolTipText(getTxtInfo());
    }
     public void setTxtCargo(String cargo){
        lblCargo.setText("Cargo:"+cargo);
        setToolTipText(getTxtInfo());
    }
    public void setTxtHoraInicia(Date hora){
        lblHoraInicio.setText("Inicia:"+hora.getHours()+":h "+hora.getMinutes()+":min");
        setToolTipText(getTxtInfo());
    }
    public void setTxtHoraTermina(Date hora){
        lblHpraTermina.setText("Termina: "+hora.getHours()+":h "+hora.getMinutes()+":min");
        setToolTipText(getTxtInfo());
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpMenu = new javax.swing.JPopupMenu();
        miEditar = new javax.swing.JMenuItem();
        miEliminar = new javax.swing.JMenuItem();
        lblTiempo = new javax.swing.JLabel();
        lblEncargado = new javax.swing.JLabel();
        lblHoraInicio = new javax.swing.JLabel();
        lblHpraTermina = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cmbServidor = new javax.swing.JComboBox();
        lbActividad = new javax.swing.JLabel();
        chbTerminada = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spnPorcentaje = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();

        miEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/AQUA ICONS APPLICATIONS TEXT EDIT1.png"))); // NOI18N
        miEditar.setText("Editar");
        miEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditarActionPerformed(evt);
            }
        });
        popUpMenu.add(miEditar);

        miEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        miEliminar.setText("Eliminar");
        miEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarActionPerformed(evt);
            }
        });
        popUpMenu.add(miEliminar);

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setPreferredSize(new java.awt.Dimension(420, 150));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        setLayout(null);

        lblTiempo.setText("Dura:");
        add(lblTiempo);
        lblTiempo.setBounds(11, 30, 106, 14);

        lblEncargado.setText("Encargado:");
        add(lblEncargado);
        lblEncargado.setBounds(11, 183, 60, 14);

        lblHoraInicio.setText("Inicia:");
        add(lblHoraInicio);
        lblHoraInicio.setBounds(11, 143, 40, 14);

        lblHpraTermina.setText("Termina:");
        add(lblHpraTermina);
        lblHpraTermina.setBounds(11, 163, 50, 14);

        lblFecha.setText("Fecha:");
        add(lblFecha);
        lblFecha.setBounds(11, 76, 40, 15);

        lblCargo.setText("Cargo:");
        add(lblCargo);
        lblCargo.setBounds(11, 123, 40, 14);

        btEditar.setLabel("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        add(btEditar);
        btEditar.setBounds(1, 1, 61, 23);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar);
        btnEliminar.setBounds(70, 0, 57, 23);

        cmbServidor.setModel(modeloCmbActividades);
        cmbServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServidorActionPerformed(evt);
            }
        });
        add(cmbServidor);
        cmbServidor.setBounds(63, 97, 176, 20);

        lbActividad.setText("Actividad:");
        add(lbActividad);
        lbActividad.setBounds(11, 100, 48, 14);

        chbTerminada.setText("Terminada");
        chbTerminada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbTerminadaActionPerformed(evt);
            }
        });
        add(chbTerminada);
        chbTerminada.setBounds(11, 49, 75, 23);

        jLabel1.setText("Total Hecho:");
        add(jLabel1);
        jLabel1.setBounds(258, 53, 61, 14);

        jLabel2.setText("Observaciones:");
        add(jLabel2);
        jLabel2.setBounds(260, 90, 75, 14);

        spnPorcentaje.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        spnPorcentaje.setPreferredSize(new java.awt.Dimension(100, 20));
        spnPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPorcentajeStateChanged(evt);
            }
        });
        add(spnPorcentaje);
        spnPorcentaje.setBounds(323, 50, 100, 20);

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        txtObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObservacionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtObservacion);

        add(jScrollPane1);
        jScrollPane1.setBounds(260, 110, 190, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x=this.getX()+evt.getX()-getWidth()/2;
        int y=this.getY()+evt.getY()-getHeight()/2;
        setBounds(x,y, getWidth(), getHeight());
        lblHoraInicio.setText("inicia:"+getTxtHora(this.getY()));
        lblHpraTermina.setText("Termina:"+getTxtHora(this.getY()+ getHeight()));
        Date fecha=new Date();

        itemAgenda.setHoraInicio(new Date(fecha.getYear(),
                                         Fecha.getNumeroMes(itemAgenda.getMes()),
                                         Integer.parseInt(itemAgenda.getDia_del_mes()),
                                         ControladorAgenda.calcularHoras((int)(this.getY())),
                                         ControladorAgenda.calcularMinutos((int)(this.getY()))));

         itemAgenda.setHoraFin(new Date(fecha.getYear(),
                                         Fecha.getNumeroMes(itemAgenda.getMes()),
                                         Integer.parseInt(itemAgenda.getDia_del_mes()),
                                         ControladorAgenda.calcularHoras((int)(this.getY()+ getHeight())),
                                         ControladorAgenda.calcularMinutos((int)(this.getY()+ getHeight()))));

        this.setToolTipText(getTxtInfo());

    }//GEN-LAST:event_formMouseDragged

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        DialogoEditarItemAgenda dialogo=new DialogoEditarItemAgenda(new JFrame(), true,itemAgenda);
        dialogo.setVisible(true);
        loadItemAgenda();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(itemAgenda!=null){
            Agenda agenda=itemAgenda.getAgenda();
            agenda.getItemsAgenda().remove(itemAgenda);
            panelContenedor.remove(this);
            panelContenedor.repaint();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void miEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditarActionPerformed
        // TODO add your handling code here:
        DialogoEditarItemAgenda dialogo=new DialogoEditarItemAgenda(new JFrame(), true,itemAgenda);
        dialogo.setVisible(true);
        loadItemAgenda();
    }//GEN-LAST:event_miEditarActionPerformed

    private void miEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarActionPerformed
        // TODO add your handling code here:
        if(itemAgenda!=null){
            Agenda agenda=itemAgenda.getAgenda();
            agenda.getItemsAgenda().remove(itemAgenda);
            panelContenedor.remove(this);
            panelContenedor.repaint();
        }
    }//GEN-LAST:event_miEliminarActionPerformed

    private void cmbServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServidorActionPerformed
        // TODO add your handling code here:        
        ModeloComboBoxActividad modelo=(ModeloComboBoxActividad)cmbServidor.getModel();
        Actividad actividad= modelo.getSelectedActividad();
        if(actividad!=null){
            itemAgenda.setActividad(actividad);
            itemAgenda.setNombre_actividad(actividad.getNombreActividad());
            
            if(itemAgenda.getActividad().getRol()!=null){
                lblCargo.setText("Cargo:"+itemAgenda.getActividad().getRol().getCargo());
                lblEncargado.setText("Encargado:"+itemAgenda.getActividad().getRol().getUsuario().getNombre()+" "+itemAgenda.getActividad().getRol().getUsuario().getApellidos());
            }
        }else{
            JOptionPane.showMessageDialog(this, "No existen actividades creadas");
        }

        getTxtInfo();
    }//GEN-LAST:event_cmbServidorActionPerformed

    private void chbTerminadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbTerminadaActionPerformed
        // TODO add your handling code here:
        if(itemAgenda!=null){
            itemAgenda.setCompletada(chbTerminada.isSelected());
            getTxtInfo();
        }else{
            JOptionPane.showMessageDialog(this, "No existen actividad");
        }
    }//GEN-LAST:event_chbTerminadaActionPerformed

    private void spnPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPorcentajeStateChanged
        // TODO add your handling code here:
        if(itemAgenda!=null){
            itemAgenda.setPorcentaje(Double.parseDouble(spnPorcentaje.getValue().toString()));
            getTxtInfo();
        }else{
            JOptionPane.showMessageDialog(this, "No existen actividad");
        }
    }//GEN-LAST:event_spnPorcentajeStateChanged

    private void txtObservacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyReleased
        // TODO add your handling code here:
        if(itemAgenda!=null){
            itemAgenda.setObservacion(txtObservacion.getText());
            getTxtInfo();
        }else{
            JOptionPane.showMessageDialog(this, "No existen actividad");
        }
    }//GEN-LAST:event_txtObservacionKeyReleased
    public String getTxtHora(int y){
        String tiempo=null;
        tiempo=" "+ControladorAgenda.calcularHoras(y)
                  +"h:"+ControladorAgenda.calcularMinutos(y)+" min";
        return tiempo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JCheckBox chbTerminada;
    private javax.swing.JComboBox cmbServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbActividad;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblEncargado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblHpraTermina;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JMenuItem miEditar;
    private javax.swing.JMenuItem miEliminar;
    private javax.swing.JPopupMenu popUpMenu;
    private javax.swing.JSpinner spnPorcentaje;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables

    public String getTxtInfo(){
        String info="<html>";
            info=info+"<br>"+lblFecha.getText();
            if(itemAgenda.getActividad()!=null)
                info=info+"<br>"+"Actividad:"+itemAgenda.getActividad().getNombreActividad();
            info=info+"<br>"+lblCargo.getText();
            info=info+"<br>"+lblEncargado.getText();
            info=info+"<br>"+lblHoraInicio.getText();
            info=info+"<br>"+lblHpraTermina.getText();
            info=info+"<br>"+lblTiempo.getText();
        info=info+"</html>";
        return info;
    }
}
