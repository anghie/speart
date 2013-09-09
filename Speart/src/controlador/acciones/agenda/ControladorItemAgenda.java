/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.acciones.agenda;

import controlador.basedatos.OperacionesBD;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import modelo.agenda.ItemAgenda;


public class ControladorItemAgenda {
    private  static ItemAgenda itemAgenda ;
 
    public static ItemAgenda getInstance() {
        if(itemAgenda==null)
            itemAgenda=new ItemAgenda();
        return itemAgenda;
    }
    public static ItemAgenda searchItemAgenda(String nombre) {
       
       LinkedList<ItemAgenda> items= new LinkedList<ItemAgenda>(OperacionesBD.buscarTodos("ItemAgenda","nombre_actividad",nombre));
        if(items!=null)
            return items.getLast();
        else
            return null;
    }
    
    public static LinkedList<ItemAgenda> searchItemAgenda(Date fechaDesde ,Date fechaHasta, String login) {
       
       LinkedList<ItemAgenda> items= new LinkedList<ItemAgenda>(OperacionesBD.buscarTodos("ItemAgenda","fecha",getDateSQL(fechaDesde),getDateSQL(fechaHasta),login));
        if(items!=null)
            return items;
        else
            return new LinkedList<ItemAgenda>();
    }
    public static int searchItemAgendaTotalCumplido(int idActividad,Date fechaDesde ,Date fechaHasta, String login) {
       
       LinkedList<ItemAgenda> items= new LinkedList<ItemAgenda>(OperacionesBD.getItems("ItemAgenda","fecha",idActividad,getDateSQL(fechaDesde),getDateSQL(fechaHasta),login));
        if(items==null)
            return 0;
        if(items.size()==0)
            return 0;
        int totalRealizado=0;
        for (Iterator<ItemAgenda> it = items.iterator(); it.hasNext();) {
            ItemAgenda itemAgenda1 = it.next();
            totalRealizado=totalRealizado+(int)itemAgenda1.getPorcentaje();
        }
        return  totalRealizado;
    }
    
     public static ItemAgenda searchItemAgenda(int idActividad) {
       
       LinkedList<ItemAgenda> items= new LinkedList<ItemAgenda>(OperacionesBD.buscarTodos("ItemAgenda","id",""+idActividad));
        if(items!=null)
            return items.getLast();
        else
            return null;
    }
    public static List<ItemAgenda> searchItemsAgenda(String mes) {
        List<ItemAgenda> itemsAgenda=new LinkedList<ItemAgenda>();
        itemsAgenda= OperacionesBD.listarconCondicion("ItemAgenda", "mes","'"+mes+"'");
        return itemsAgenda;
    }
    public static List<ItemAgenda> searchItemsAgenda(String mes, String dia) {
        List<ItemAgenda> itemsAgenda=new LinkedList<ItemAgenda>();
        itemsAgenda= OperacionesBD.listarconDobleCondicion("ItemAgenda", "mes","'"+mes+"'","dia","'"+dia+"'");
        return itemsAgenda;
    }
    public static void setTiempoDuracion(ItemAgenda itemAgenda,Date fecha,int mes , int dia_mes,int horas, int minutos){
        Date fechaAux;
//        System.out.println("h"+horas+"m"+minutos);
        if(horas<0 || minutos<0){
            fechaAux=itemAgenda.getHoraInicio();
            itemAgenda.setHoraInicio(itemAgenda.getHoraFin());
            itemAgenda.setHoraFin(fechaAux);
        }
        horas=Math.abs(horas);
        minutos=Math.abs(minutos);
        if(horas==0 && minutos<15){
            minutos=15;
            itemAgenda.getHoraFin().setMinutes(minutos);
        }
        itemAgenda.setTiempoDuracion(new Date(fecha.getYear(),
                                         mes,
                                         dia_mes,
                                         horas,
                                         minutos));
    }

    public static void setTiempoDuracion(ItemAgenda itemAgenda,int horas, int minutos){
        Date fechaAux;
        if(horas<0 || minutos<0){
            fechaAux=itemAgenda.getHoraInicio();
            itemAgenda.setHoraInicio(itemAgenda.getHoraFin());
            itemAgenda.setHoraFin(fechaAux);
        }
        horas=Math.abs(horas);
        minutos=Math.abs(minutos);
        if(horas==0 && minutos<15){
            minutos=15;
            itemAgenda.getHoraFin().setMinutes(minutos);
        }
        itemAgenda.getTiempoDuracion().setHours(horas);
        itemAgenda.getTiempoDuracion().setMinutes(minutos);
    }
    
    public static java.sql.Date getDateSQL(java.util.Date fecha){
        java.sql.Date fechaSQL=new java.sql.Date(fecha.getTime());
        return fechaSQL;
    }
}
