package controlador.acciones.agenda;

import controlador.basedatos.OperacionesBD;
import java.util.LinkedList;
import java.util.List;
import modelo.agenda.DiaFeriado;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class ControladorDiasFeriados {
     private  static DiaFeriado diaFeriado ;
 
    public static DiaFeriado getInstance() {
        if(diaFeriado==null)
            diaFeriado=new DiaFeriado();
        return diaFeriado;
    }
    public static List<DiaFeriado> searchDiaFeriado(String nombreDia,String mesNombre , int numeroDiaMes, int idAgenda) {
       Object objeto=OperacionesBD.buscar("DiaFeriado","dia","mes","dia_mes","agenda_id",nombreDia,mesNombre,numeroDiaMes,idAgenda);
       if(objeto!=null)
            return (List<DiaFeriado>)(objeto);
        else
            return null;
    }
}
