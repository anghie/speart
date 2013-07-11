/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * panelDia.java
 *
 * Created on 10/11/2012, 03:30:08 PM
 */

package vista.modelo.paneles.agenda;


import controlador.acciones.agenda.ControladorItemAgenda;
import controlador.acciones.servicios.ControladorAgenda;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JPanel;
import modelo.agenda.Agenda;
import modelo.agenda.ItemAgenda;
import modelo.proceso.Actividad;
import modelo.usuario.Usuario;
import vista.modelo.Fecha;


/**
 *
 * @author alf
 */
public class PanelDiaHoras extends javax.swing.JPanel {

    /** Creates new form panelDia */
    private int numeroDia;
    private int numeroMes;
    private String nombreDia;
    private Point2D punto;
    private Point2D punto2;
    private int contador;
    private String tiempoTarea;
    private Agenda agenda;
    private Calendar calendario;
    private Actividad actividad;
    private Usuario usuario;

    public PanelDiaHoras(Calendar calendar,Agenda agenda,Actividad actividad) {
        initComponents();
        iniciarHoras();
        this.calendario=calendar;
        nombreDia=Fecha.getNombreDia(calendar.get(Calendar.DAY_OF_WEEK));
        numeroDia=calendar.get(Calendar.DATE);
        this.numeroMes=calendar.get(Calendar.MONTH);
        lblDia.setText(nombreDia+":"+numeroDia);
        this.actividad=actividad;
        this.agenda=agenda;
        setToolTipText(lblDia.getText());
        iniciarTareas();
    }
     public PanelDiaHoras(Calendar calendar,Agenda agenda,Actividad actividad,Usuario usuario) {
        initComponents();
        iniciarHoras();
        this.usuario=usuario;
        this.calendario=calendar;
        nombreDia=Fecha.getNombreDia(calendar.get(Calendar.DAY_OF_WEEK));
        numeroDia=calendar.get(Calendar.DATE);
        this.numeroMes=calendar.get(Calendar.MONTH);
        lblDia.setText(nombreDia+":"+numeroDia);
        this.actividad=actividad;
        this.agenda=agenda;
        setToolTipText(lblDia.getText());
        iniciarTareas(usuario);
    }

    private void  iniciarHoras(){
        for (int i = 0; i < 24; i++) {
            PanelHora panelHora=new PanelHora(i);
            panelHora.setName("h"+i);
            panelContenedorHoras.add(panelHora);
        }
    }
    @SuppressWarnings("static-access")
    private void iniciarTareas(){
//        System.out.println("Tareas:"+agenda.getItemsAgenda());
        panelContenedorTareas.removeAll();
        for (Iterator<ItemAgenda> it = agenda.getItemsAgenda().iterator(); it.hasNext();) {
            ItemAgenda item = it.next();
//         System.out.println(item.getDia_del_mes()+"="+numeroDia+"mes "+Fecha.getNombreMes(calendario.get(Calendar.MONTH)));
             if(item.getMes().equals(Fecha.getNombreMes(numeroMes))
                &&  Integer.parseInt(item.getDia_del_mes())==numeroDia){
                PanelActividad panelActividad=new PanelActividad(false,item,panelContenedorTareas);
                if(item.getActividad()!=null){
                    panelActividad.setTxtActividad(item.getActividad().getTipoActividad());
                    if(item.getActividad().getRol()!=null){
                        panelActividad.setTxtEncargado(item.getActividad().getRol().getUsuario().getNombre()+" "+item.getActividad().getRol().getUsuario().getApellidos());
                        panelActividad.setTxtCargo(item.getActividad().getRol().getCargo());
                    }
                       
                 }
                panelActividad.setTxtFecha(item.getDia()+" "+item.getDia_del_mes()+" "+item.getMes());
                panelActividad.setTxtHoraInicia(item.getHoraInicio());
                panelActividad.setTxtHoraTermina(item.getHoraFin());
                panelActividad.setTiempoDuracion(item.getTiempoDuracion());
//                panelActividad.setBackground(Color.orange);

                panelActividad.setBounds( 10,
                                    ControladorAgenda.calcularPinceles(item.getHoraInicio().getHours(),item.getHoraInicio().getMinutes()),
                                    250,//punto2.x-punto.x
                                    ControladorAgenda.calcularPinceles(item.getTiempoDuracion().getHours(),item.getTiempoDuracion().getMinutes())
                                    );

              panelContenedorTareas.add(panelActividad);
              panelContenedorTareas.revalidate();
            }
           
        }
    }

     private void iniciarTareas(Usuario usuario){
//        System.out.println("Tareas:"+agenda.getItemsAgenda());
        panelContenedorTareas.removeAll();
        for (Iterator<ItemAgenda> it = agenda.getItemsAgenda().iterator(); it.hasNext();) {
            ItemAgenda item = it.next();
//         System.out.println(item.getDia_del_mes()+"="+numeroDia+"mes "+Fecha.getNombreMes(calendario.get(Calendar.MONTH)));
             if(item.getMes().equals(Fecha.getNombreMes(numeroMes))
                &&  Integer.parseInt(item.getDia_del_mes())==numeroDia
                && item.getActividad()!=null){
                if(item.getActividad().getRol().getUsuario().equals(usuario)){
                 PanelActividad panelActividad=new PanelActividad(false,item,panelContenedorTareas);
                    panelActividad.setTxtActividad(item.getActividad().getTipoActividad());
                    if(item.getActividad().getRol()!=null){
                        panelActividad.setTxtEncargado(item.getActividad().getRol().getUsuario().getNombre()+" "+item.getActividad().getRol().getUsuario().getApellidos());
                        panelActividad.setTxtCargo(item.getActividad().getRol().getCargo());
                    }
                     panelActividad.setTxtFecha(item.getDia()+" "+item.getDia_del_mes()+" "+item.getMes());
                    panelActividad.setTxtHoraInicia(item.getHoraInicio());
                    panelActividad.setTxtHoraTermina(item.getHoraFin());
                    panelActividad.setTiempoDuracion(item.getTiempoDuracion());
    //                panelActividad.setBackground(Color.orange);

                    panelActividad.setBounds( 10,
                                        ControladorAgenda.calcularPinceles(item.getHoraInicio().getHours(),item.getHoraInicio().getMinutes()),
                                        250,//punto2.x-punto.x
                                        ControladorAgenda.calcularPinceles(item.getTiempoDuracion().getHours(),item.getTiempoDuracion().getMinutes())
                                        );

                  panelContenedorTareas.add(panelActividad);
                  panelContenedorTareas.revalidate();
                 }
            }

        }
    }

    public void refreshTareas(Calendar calendario){
        panelContenedorTareas.removeAll();
        this.calendario=calendario;
        if(usuario==null)
            iniciarTareas();
        else
            iniciarTareas(usuario);
    }
    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
        lblDia.setText(nombreDia+":"+numeroDia);
        setToolTipText(lblDia.getText());
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
        lblDia.setText(nombreDia+":"+numeroDia);
        setToolTipText(lblDia.getText());
    }
    public Vector<PanelHora> getHoras(){
        Vector<PanelHora> horas=new Vector<PanelHora>();
        Component []componentes=panelContenedorHoras.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            Component component = componentes[i];
            if(component instanceof PanelHora){
                PanelHora hora=(PanelHora)component;
                horas.add(hora);
            }
        }
        return horas;
    }
    public PanelHora getHora(int hora){
        Component []componentes=panelContenedorHoras.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            Component component = componentes[i];
            if(component instanceof PanelHora){
                PanelHora horaAux=(PanelHora)component;
                if(horaAux.getHora()==hora){
                    return  horaAux;
                }else{
                    horaAux.setColorFuente(Color.black);
                    horaAux.setColorFondo(Color.darkGray);
                }
            }
        }
        return null;
    }
    public void marcarHoraActual(int hora){
        getHora(hora).setColorFuente(Color.green);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelContenedorHoras = new javax.swing.JPanel();
        panelContenedorTareas = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        lblDia = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(500, 2455));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        panelContenedorHoras.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelContenedorHoras.setPreferredSize(new java.awt.Dimension(104, 220));
        panelContenedorHoras.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 1));
        panelPrincipal.add(panelContenedorHoras, java.awt.BorderLayout.WEST);

        panelContenedorTareas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelContenedorTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelContenedorTareasMouseClicked(evt);
            }
        });
        panelContenedorTareas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelContenedorTareasMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorTareasLayout = new javax.swing.GroupLayout(panelContenedorTareas);
        panelContenedorTareas.setLayout(panelContenedorTareasLayout);
        panelContenedorTareasLayout.setHorizontalGroup(
            panelContenedorTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        panelContenedorTareasLayout.setVerticalGroup(
            panelContenedorTareasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelContenedorTareas, java.awt.BorderLayout.CENTER);

        add(panelPrincipal, java.awt.BorderLayout.CENTER);

        lblDia.setText("Dia:");
        panelNorte.add(lblDia);

        add(panelNorte, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void panelContenedorTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelContenedorTareasMouseClicked
        // TODO add your handling code here:
        if(contador==0)
            punto=evt.getPoint();
        contador++;
        if(contador==2){
          //----------------------------------------------------------------------------------
          ItemAgenda itemAgenda=new ItemAgenda();
          Date fecha=new Date();
          itemAgenda.setActividad(actividad);
          if(actividad!=null)
            itemAgenda.setNombre_actividad(actividad.getNombreActividad());
          itemAgenda.setMes(Fecha.getNombreMes(numeroMes));
          itemAgenda.setDia_del_mes(numeroDia+"");
          itemAgenda.setDia(nombreDia);
          itemAgenda.setFecha(new Date());
          itemAgenda.setAgenda(agenda);
          itemAgenda.setHoraInicio(new Date(fecha.getYear(),
                                         numeroMes,
                                         numeroDia,
                                         ControladorAgenda.calcularHoras((int)(punto.getY())),
                                         ControladorAgenda.calcularMinutos((int)(punto.getY()))));

          itemAgenda.setHoraFin(new Date(fecha.getYear(),
                                         numeroMes,
                                         numeroDia,
                                         ControladorAgenda.calcularHoras((int)(punto2.getY())),
                                         ControladorAgenda.calcularMinutos((int)(punto2.getY()))));

          ControladorItemAgenda.setTiempoDuracion(itemAgenda,
                                                   fecha,
                                                   numeroMes,
                                                   numeroDia,
                                                  ControladorAgenda.calcularHoras((int)(punto2.getY()-punto.getY())),
                                                  ControladorAgenda.calcularMinutos((int)(punto2.getY()-punto.getY())));
          

          //itemAgenda.setActividad(null);
          agenda.getItemsAgenda().add(itemAgenda);
//-------------------------------------------------------------------
          PanelActividad panelActividad=new PanelActividad(false,itemAgenda, panelContenedorTareas);
          panelActividad.setTiempoDuracion(tiempoTarea);
          panelActividad.setBackground(Color.green);
          panelContenedorTareas.add(panelActividad);
          panelContenedorTareas.repaint();
          
          punto=null;
          contador=0;
        }
    }//GEN-LAST:event_panelContenedorTareasMouseClicked

    private void panelContenedorTareasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelContenedorTareasMouseMoved
        // TODO add your handling code here:
        Graphics2D g= (Graphics2D) panelContenedorTareas.getGraphics();
        g.setColor(Color.red);
        punto2=evt.getPoint();
        if(punto!=null){
            panelContenedorTareas.repaint();
            tiempoTarea=calcularTiempoTarea();
            g.drawString(tiempoTarea,
                            (int)punto2.getX(),
                            (int)punto2.getY());
        }
    }//GEN-LAST:event_panelContenedorTareasMouseMoved
    public String calcularTiempoTarea(){
        String tiempo = null;
         if(punto!=null){
            int espacio=(int)( punto2.getY()-punto.getY());
            tiempo=" "+ControladorAgenda.calcularHoras(espacio)
                    +"h:"+ControladorAgenda.calcularMinutos(espacio)+" min";
        }
        return tiempo;
    }

    public JPanel getPanelContenedorTareas() {
        return panelContenedorTareas;
    }

    public void setPanelContenedorTareas(JPanel panelContenedorTareas) {
        this.panelContenedorTareas = panelContenedorTareas;
    }

    public String getTiempoTarea() {
        return tiempoTarea;
    }

    public void setTiempoTarea(String tiempoTarea) {
        this.tiempoTarea = tiempoTarea;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDia;
    private javax.swing.JPanel panelContenedorHoras;
    private javax.swing.JPanel panelContenedorTareas;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
    
}
