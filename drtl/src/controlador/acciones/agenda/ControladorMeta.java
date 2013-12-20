package controlador.acciones.agenda;

import static controlador.acciones.agenda.ControladorItemAgenda.getDateSQL;
import controlador.basedatos.OperacionesBD;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.agenda.Meta;
import vista.modelo.Mensaje;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class ControladorMeta {
     private  static Meta meta ;
 
    public static Meta getInstance() {
        if(meta==null)
            meta=new Meta();
        return meta;
    }
    public  static void createMeta(){
       if(meta.getAgenda()!=null) {
           if(meta.getActividad()!=null){
               if(meta.getUsuario()!=null){
                    if(meta.getMes()!=0) {
                        if (OperacionesBD.guardar(meta)) {
                            Mensaje.datosGuardados();
                        } else {
                             Mensaje.datosNoGuardados();
                        }
                    }else{
                       Mensaje.camposVacios();
                    }
                }
           }
       }
    }
     public  static void createMeta(Meta meta){
       if(meta.getAgenda()!=null) {
           if(meta.getActividad()!=null){
               if(meta.getUsuario()!=null){
                    if(meta.getMes()!=0) {
                        if (OperacionesBD.guardar(meta)) {
                            Mensaje.datosGuardados();
                        } else {
                             Mensaje.datosNoGuardados();
                        }
                    }else{
                       Mensaje.camposVacios();
                    }
                }
           }
       }
    }
    public  static void updateMeta(){
       if(meta.getAgenda()!=null) {
           if(meta.getActividad()!=null){
               if(meta.getUsuario()!=null){
                    if(meta.getMes()!=0) {
                        if (OperacionesBD.modificar(meta)) {
                            Mensaje.datosModificados();
                        } else {
                             Mensaje.datosNoModificados();
                        }
                    }else{
                       Mensaje.camposVacios();
                    }
                }
           }
       }
    }
    public  static void updateMeta(Meta meta){
       if(meta.getAgenda()!=null) {
           if(meta.getActividad()!=null){
               if(meta.getUsuario()!=null){
                    if(meta.getMes()!=0) {
                        if (OperacionesBD.modificar(meta)) {
                            Mensaje.datosModificados();
                        } else {
                             Mensaje.datosNoModificados();
                        }
                    }else{
                       Mensaje.camposVacios();
                    }
                }
           }
       }
    }
    public  static void delateMeta(long idMeta){
        try {
                if (OperacionesBD.eliminar(new Meta() ,idMeta)) {
                        Mensaje.datosEliminados();
                } else {
                       Mensaje.datosNoEliminados();
                }
         } catch (Exception ex) {
              Logger.getLogger(ControladorAgenda.class.getName()).log(Level.SEVERE, null, ex);
         }     
                   
       
    }
    public static LinkedList<Meta> searchMetas(String mes) {
        List metas=OperacionesBD.listarconCondicion("Meta", "mes",mes);
        if(metas!=null){
            return  new LinkedList<Meta>(metas);
        }else{
            return  new LinkedList<Meta>();
        }
    }
    public static LinkedList<Meta> searchMetas(Date fechaDesde ,Date fechaHasta, String login) {
        LinkedList<Meta> items= new LinkedList<Meta>(OperacionesBD.buscarMetas("Meta","fecha",getDateSQL(fechaDesde),getDateSQL(fechaHasta),login));
        LinkedList<Meta> metasAcumuladas=new LinkedList<>();
        if(items!=null){
            for (Iterator<Meta> it = items.iterator(); it.hasNext();) {
                Meta meta1 = it.next();
                if(!metasAcumuladas.contains(meta1))
                    metasAcumuladas.add(meta1);
                else{
                   int index= metasAcumuladas.indexOf(meta1);
                   int val=metasAcumuladas.get(index).getValor();
                   metasAcumuladas.get(index).setValor(val+meta1.getValor());
                }
                    
            }
            return metasAcumuladas;
        }else
            return new LinkedList<Meta>();
    }
    public static java.sql.Date getDateSQL(java.util.Date fecha){
        java.sql.Date fechaSQL=new java.sql.Date(fecha.getTime());
        return fechaSQL;
    }
}
