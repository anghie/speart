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
    public PanelActividad(boolean compacto, ItemAgenda itemAgenda, JPanel panelContenedor) {
        this.compacto=compacto;
        this.itemAgenda=itemAgenda;
        this.panelContenedor=panelContenedor;
        iniciarServidores();
        initComponents();
        //chbTerminada.setEnabled(false);
        if(itemAgenda.isCompletada()){
            btEditar.setVisible(false);
            btnEliminar.setVisible(false);
        }else{
            this.setComponentPopupMenu(popUpMenu);
        }
        if (compacto || getSize().getHeight()<40) {
            setPreferredSize(new Dimension(300, 40));
        }
        loadItemAgenda();
    }
    public void loadItemAgenda(){
       setBackground(Color.WHITE);
       chbTerminada.setSelected(itemAgenda.isCompletada());
       int h=itemAgenda.getHoraInicio().getHours();
       int m=itemAgenda.getHoraInicio().getMinutes();
       int y=ControladorAgenda.calcularPinceles(h, m);
       this.setBounds(this.getX(), 
                       y,
                       300,
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
        setPreferredSize(new java.awt.Dimension(380, 150));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        lblTiempo.setText("Dura:");

        lblEncargado.setText("Encargado:");

        lblHoraInicio.setText("Inicia:");

        lblHpraTermina.setText("Termina:");

        lblFecha.setText("Fecha:");

        lblCargo.setText("Cargo:");

        btEditar.setLabel("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/salir_1.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cmbServidor.setModel(modeloCmbActividades);
        cmbServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServidorActionPerformed(evt);
            }
        });

        lbActividad.setText("Actividad:");

        chbTerminada.setText("Terminada");
        chbTerminada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbTerminadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbActividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCargo)
                    .addComponent(lblHpraTermina)
                    .addComponent(lblHoraInicio)
                    .addComponent(lblEncargado)
                    .addComponent(lblFecha)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chbTerminada)
                        .addGap(43, 43, 43)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, 0, 0, Short.MAX_VALUE))
                    .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTiempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbTerminada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btEditar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbActividad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHoraInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHpraTermina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEncargado)
                .addContainerGap())
        );
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
        Actividad actividad= modelo.getSelectedServidor();
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
