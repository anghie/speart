/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alf
 */
public class Fecha {

     public static String getFechaFormateada(Date fecha,String formato){
        SimpleDateFormat simpleDateformat = new SimpleDateFormat(formato);
         return simpleDateformat.format(fecha);
    }
    public static String getNombreDia(int numeroDia){
        String[]dias = { "Domingo", "Lunes", "Martes", "Miercoles",
	                "Jueves", "Viernes", "Sabado" };
         return dias[numeroDia-1];
    }
    public static String getNombreMes(int numeroMes){
        String[]meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
	                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
	                "Diciembre" };
         return meses[numeroMes];
    }
     public static int getNumeroMes( String mes){
        String[]meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
	                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
	                "Diciembre" };
         for (int i = 0; i < meses.length; i++) {
             String mesAux = meses[i];
             if(mesAux.equals(mes))
                 return i;
         }
         return -1;
    }
     public static String formatTime(Date fecha){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(fecha);
     }
}
