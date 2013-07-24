/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelMes.java
 *
 * Created on 10/11/2012, 11:53:29 PM
 */

package vista.modelo.paneles.agenda;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JLabel;
import modelo.agenda.Agenda;
import modelo.usuario.Usuario;
import vista.modelo.Fecha;

/**
 *
 * @author alf
 */
public class PanelMes extends javax.swing.JPanel {

    /** Creates new form PanelMes */
    private Calendar calendar;
    private Agenda agenda;
    private Usuario usuario;
   
    public PanelMes(Calendar calendar, Agenda agenda, Usuario usuario) {
        initComponents();
        this.usuario=usuario;
        this.agenda=agenda;
        this.calendar=calendar;
        iniciarMes(usuario);
    }
    
   private void iniciarMes(Usuario usuario){
        int diaSeleccinado=calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DATE,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        int diasDelMes=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //System.out.println(agenda.getItemsAgenda());
        this.setLayout(new GridLayout(7,(diasDelMes/7)+1));
        for (int i = 1; i <= diasDelMes; i++) {
            PanelDia dia=new PanelDia(calendar,agenda, usuario);
            dia.setNombreDia(Fecha.getNombreDia(calendar.get(Calendar.DAY_OF_WEEK)));
            dia.setNumeroDia(calendar.get(Calendar.DAY_OF_MONTH));
            this.add(dia);
            calendar.add(Calendar.DATE, 1);
        }
        calendar.add(Calendar.DATE, -diasDelMes);
        calendar.add(Calendar.DATE, diaSeleccinado-1);
    }

    public void refreshTareas(Calendar calendar){
        this.removeAll();
        this.calendar=calendar;
        iniciarMes(usuario);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(2800, 2800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     public Vector<PanelDia> getDias(){
        Vector<PanelDia> dias=new Vector<PanelDia>();
        Component []componentes=this.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            Component component = componentes[i];
            if(component instanceof PanelDia){
                PanelDia panelDia=(PanelDia)component;
                dias.add(panelDia);
            }
        }
        return dias;
    }

    public PanelDia getDia(int diaMes){
        Component []componentes=this.getComponents();
        for (int i = 0; i < componentes.length; i++) {
            Component component = componentes[i];
            if(component instanceof PanelDia){
                PanelDia diaAux=(PanelDia)component;
                if(diaAux.getNumeroDia()==diaMes){
                    return  diaAux;
                }
            }
        }
        return null;
    }
    public void marcarDiaActual(Date fechaActual){
        int diaMes=Integer.parseInt(Fecha.getFechaFormateada(fechaActual,"dd"));
        PanelDia diaActual=getDia(diaMes);
        if(diaActual!=null)
            diaActual.setBackground(Color.WHITE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
