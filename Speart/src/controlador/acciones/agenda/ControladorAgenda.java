/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.acciones.agenda;

import controlador.basedatos.OperacionesBD;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.agenda.Agenda;
import vista.modelo.Mensaje;


public class ControladorAgenda {
    private  static Agenda agenda;
    public static double CONSTATE_ESPACIO_TIEMPO=100;// 100px =1h



    public static int calcularHoras(int pinceles){
        double hora=pinceles/CONSTATE_ESPACIO_TIEMPO;
        int h=(int) hora;
        return h;
    }
    public static int calcularMinutos(int pinceles){
         double hora=pinceles/CONSTATE_ESPACIO_TIEMPO;
        int h=(int) hora;
        int m=(int)((hora-h)*60);
        return m;
    }
    public static int calcularPinceles(int h, int min){
        int pinceles=(int)(h*CONSTATE_ESPACIO_TIEMPO);
        pinceles=pinceles+(int) (CONSTATE_ESPACIO_TIEMPO*(min/60.0));
        return pinceles;
    }
    

    public  static void createAgenda(){
       if(agenda.getNombre()!=null) {
           if(!agenda.getNombre().trim().isEmpty()) {
                if (OperacionesBD.guardar(agenda)) {
                    Mensaje.datosGuardados();
                } else {
                     Mensaje.datosNoGuardados();
                }
            }else{
               Mensaje.camposVacios();
            }
       }
    }
    
    public  static void createAgenda(String year){
       if(year!=null) {
           if(!year.trim().isEmpty()) {
               agenda=new Agenda();
               agenda.setNombre(year);
                if (OperacionesBD.guardar(agenda)) {
                    Mensaje.datosGuardados();
                } else {
                     Mensaje.datosNoGuardados();
                }
            }else{
               Mensaje.camposVacios();
            }
       }
    }

    public  static void updateAgenda(){
       if(agenda.getNombre()!=null) {
           if(!agenda.getNombre().trim().isEmpty()) {
               if (OperacionesBD.modificar(agenda)) {
                    Mensaje.datosModificados();
                } else {
                     Mensaje.datosNoModificados();
                }
            }else{
               Mensaje.camposVacios();
            }
       }
    }
    public  static void delateAgenda(){
       if(agenda.getNombre()!=null) {
           if(!agenda.getNombre().trim().isEmpty()) {
                try {
                    if (OperacionesBD.eliminar(agenda.getClass(), agenda.getId())) {
                        Mensaje.datosEliminados();
                    } else {
                        Mensaje.datosNoEliminados();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
               Mensaje.camposVacios();
            }
       }
    }

    public static Agenda getInstance() {
        if(agenda==null)
            agenda=new Agenda();
        return agenda;
    }
   public static Agenda changeAgenda(String year){
        Object obj=OperacionesBD.buscar("Agenda", "nombre", year);
        if(obj!=null)
            agenda=(Agenda) obj;
        else
            createAgenda(year);
        return agenda;
    }
    public static Agenda getAgendaActual() {
        String year=""+(new Date().getYear());
        Object obj=OperacionesBD.buscar("Agenda", "nombre", year);
        if(obj!=null)
            agenda=(Agenda) obj;
        return agenda;
    }

}
