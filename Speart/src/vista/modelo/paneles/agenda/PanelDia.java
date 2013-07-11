/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelDia.java
 *
 * Created on 11/11/2012, 02:51:13 PM
 */

package vista.modelo.paneles.agenda;


import java.awt.Color;
import java.util.Calendar;
import java.util.Iterator;
import modelo.agenda.Agenda;
import modelo.agenda.ItemAgenda;
import modelo.usuario.Usuario;
import vista.modelo.Fecha;


/**
 *
 * @author alf
 */
public class PanelDia extends javax.swing.JPanel {

    /** Creates new form PanelDia */
    private int numeroDia;
    private String nombreDia;
    private Calendar calendario;
    private Agenda agenda;
    private int numeroMes;
    private Usuario usuario;
    public PanelDia(Calendar calendar, Agenda agenda) {
        initComponents();
        this.calendario=calendar;
        this.agenda=agenda;
        this.nombreDia=Fecha.getNombreDia(calendar.get(Calendar.DAY_OF_WEEK));
        this.numeroDia=calendar.get(Calendar.DATE);
        this.numeroMes=calendar.get(Calendar.MONTH);
        lblDia.setText(nombreDia+":"+numeroDia);
        iniciarTareas();
    }
    public PanelDia(Calendar calendar, Agenda agenda, Usuario usuario) {
        initComponents();
        this.calendario=calendar;
        this.agenda=agenda;
        this.nombreDia=Fecha.getNombreDia(calendar.get(Calendar.DAY_OF_WEEK));
        this.numeroDia=calendar.get(Calendar.DATE);
        this.numeroMes=calendar.get(Calendar.MONTH);
        lblDia.setText(nombreDia+":"+numeroDia);
        iniciarTareas(usuario);
    }
public void iniciarTareas(){
        System.out.println("Tareas:"+agenda.getItemsAgenda().size());
        panelContenedorActividades.removeAll();
        for (Iterator<ItemAgenda> it = agenda.getItemsAgenda().iterator(); it.hasNext();) {
             ItemAgenda item = it.next();
             // System.out.println("Mes:"+Fecha.getNombreMes(calendario.get(Calendar.MONTH))+" Dia:"+calendario.get(Calendar.DAY_OF_MONTH));
             if(item.getMes().equals(Fecha.getNombreMes(numeroMes))
                    &&  Integer.parseInt(item.getDia_del_mes())==numeroDia){
                PanelActividad panelActividad=new PanelActividad(true,item,panelContenedorActividades);
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
//                panelActividad.setBackground(Color.green);

              panelContenedorActividades.add(panelActividad);
              panelContenedorActividades.revalidate();
            }

        }
    }

public void iniciarTareas(Usuario usuario){
        System.out.println("Tareas:"+agenda.getItemsAgenda().size());
        panelContenedorActividades.removeAll();
        for (Iterator<ItemAgenda> it = agenda.getItemsAgenda().iterator(); it.hasNext();) {
             ItemAgenda item = it.next();
             // System.out.println("Mes:"+Fecha.getNombreMes(calendario.get(Calendar.MONTH))+" Dia:"+calendario.get(Calendar.DAY_OF_MONTH));
             if(item.getMes().equals(Fecha.getNombreMes(numeroMes))
                    &&  Integer.parseInt(item.getDia_del_mes())==numeroDia
                    &&  item.getActividad()!=null ){

                if(item.getActividad().getRol().getUsuario().equals(usuario)){
                    PanelActividad panelActividad=new PanelActividad(true,item,panelContenedorActividades);
                    panelActividad.setTxtActividad(item.getActividad().getTipoActividad());
                    if(item.getActividad().getRol()!=null){
                        panelActividad.setTxtEncargado(item.getActividad().getRol().getUsuario().getNombre()+" "+item.getActividad().getRol().getUsuario().getApellidos());
                        panelActividad.setTxtCargo(item.getActividad().getRol().getCargo());
                    }
                    panelActividad.setTxtFecha(item.getDia()+" "+item.getDia_del_mes()+" "+item.getMes());
                    panelActividad.setTxtHoraInicia(item.getHoraInicio());
                    panelActividad.setTxtHoraTermina(item.getHoraFin());
                    panelActividad.setTiempoDuracion(item.getTiempoDuracion());
    //                panelActividad.setBackground(Color.green);
                    panelContenedorActividades.add(panelActividad);
                    panelContenedorActividades.revalidate();
                 }

            }

        }
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
        lblDia.setText(nombreDia+":"+numeroDia);
    }

    public int getNumeroDia() {
        return numeroDia;

    }
    public void setColorFondo(Color color){
        this.setBackground(color);
    }
    public void setColorFuente(Color color){
        lblDia.setForeground(color);
    }

    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
        lblDia.setText(nombreDia+":"+numeroDia);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelContenedorActividades = new javax.swing.JPanel();
        panelNorte = new javax.swing.JPanel();
        lblDia = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(400, 430));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(210, 210));

        panelContenedorActividades.setOpaque(false);
        panelContenedorActividades.setPreferredSize(new java.awt.Dimension(400, 400));
        panelContenedorActividades.setLayout(new javax.swing.BoxLayout(panelContenedorActividades, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panelContenedorActividades);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelNorte.setOpaque(false);

        lblDia.setText("Dia");
        panelNorte.add(lblDia);

        add(panelNorte, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDia;
    private javax.swing.JPanel panelContenedorActividades;
    private javax.swing.JPanel panelNorte;
    // End of variables declaration//GEN-END:variables

}
