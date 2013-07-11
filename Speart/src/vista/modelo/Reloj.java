/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modelo;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vista.modelo.paneles.agenda.PanelAgenda;

/**
 *
 * @author alf
 */
public class Reloj implements Runnable{
   
    private PanelAgenda agenda;
    public Reloj(PanelAgenda agenda) {
        this.agenda=agenda;
    }
    public void run() {
        while (true) {
            try {

                Thread.sleep(1000);
                String fecha=Fecha.getFechaFormateada(new Date(), agenda.getFormatoFecha());
                agenda.getLblFechaActual().setText("Fecha actual:"+fecha);

               // marcarHoraActual(agenda);

            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void marcarHoraActual(PanelAgenda agenda){
        Date fecha=new Date();
       if(agenda.getPanelDia()!=null){
           agenda.getPanelDia().marcarHoraActual(fecha.getHours());
           agenda.getPanelSemana().marcarDiaActual(fecha);
           agenda.getPanelMes().marcarDiaActual(fecha);
       }
    }

}
