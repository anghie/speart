package controlador.acciones.agenda;

import static controlador.acciones.agenda.ControladorItemAgenda.getDateSQL;
import controlador.basedatos.OperacionesBD;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.agenda.ItemAgenda;
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
    public  static void delateAgenda(){
        if(meta.getAgenda()!=null) {
           if(meta.getActividad()!=null){
               if(meta.getUsuario()!=null){
                    if(meta.getMes()!=0) {
                       try {
                            if (OperacionesBD.eliminar(meta.getClass(), meta.getId())) {
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
        if(items!=null)
            return items;
        else
            return new LinkedList<Meta>();
    }
    public static java.sql.Date getDateSQL(java.util.Date fecha){
        java.sql.Date fechaSQL=new java.sql.Date(fecha.getTime());
        return fechaSQL;
    }
}
