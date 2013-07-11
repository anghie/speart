/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.acciones.agenda;

import controlador.basedatos.OperacionesBD;
import java.util.LinkedList;
import java.util.List;
import modelo.proceso.Actividad;




public class ControladorActividades {
    private  static Actividad actividad;
    
    public static Actividad getInstance() {
        if(actividad==null)
            actividad=new Actividad();
        return actividad;
    }
//
//    public static Actividad getActividad() {
//        String year=""+(new Date().getYear());
//        Object obj=OperacionesBD.buscar("Actividad", "nombre", year);
//        if(obj!=null)
//            actividad=(Actividad) obj;
//        return actividad;
//    }
    public static LinkedList<Actividad> getAllActividades() {
       List list =OperacionesBD.listar("Actividad");
//       System.out.println(list);
       if(list!=null){
             LinkedList<Actividad> lista=new LinkedList<Actividad>(list) ;
             return lista;
        }   
        return new LinkedList<Actividad>();
    }

}
