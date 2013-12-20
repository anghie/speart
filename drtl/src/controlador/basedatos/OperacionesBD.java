/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.basedatos;

import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
//~ import modelo.Usuario;

public class OperacionesBD {

    protected static EntityManager entidad;
    protected static List lista;

    //private Query consulta;
    //Constructor de la clase
    public OperacionesBD() {
        //entidad = Persistence.createEntityManagerFactory("MedicosPU").createEntityManager();
    }

    public static void conectar(String user, String clave, String host) {
        try {
            Properties p = getHibernateConfig(user, clave, host);
            entidad = Persistence.createEntityManagerFactory("SpeiessDefinitivoPU", p).createEntityManager();
        } catch (Exception e) {
//            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static Properties getHibernateConfig(String user, String clave, String host) {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.username", user);
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("hibernate.connection.password", clave);
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://" + host + ":3306/speiess");
        prop.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        return prop;
    }

    /**
     * Guarda un objeto en la base de datos
     *
     * @param object el objeto a ser guardado en la base de datos *
     */
    public static boolean guardar(Object object) {
        entidad.getTransaction().begin();
        try {
            entidad.persist(object);
            entidad.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, e);
            entidad.getTransaction().rollback();
            return false;
        }
    }

    public static boolean modificar(Object object) {
        entidad.getTransaction().begin();
        try {
            Object o = entidad.merge(object);
            entidad.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, e);
            entidad.getTransaction().rollback();
            return false;
        }
    }

    /**
     * Elimina un objeto en la base de datos
     *
     * @param campoId el id del objeto a ser eliminado en la base de datos
     * @param clase
     * @return boolean .- true si es eliminado de la base de datos y false si no
     * es eliminado de la base de datos
     *
     */
    public static boolean eliminar(Object clase, int campoId) { //codigo implementado a las 10:AM de hoy 14 Junio 2012
        try {
            entidad.getTransaction().begin();
            clase = entidad.find(clase.getClass(), campoId);
            if (clase != null) {                
                entidad.remove(clase);
                System.out.println("si llega");
            } else {
                return false;
            }
            entidad.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            entidad.getTransaction().rollback();
            return false;
        }
    }
    public static boolean eliminar(Object clase, long campoId) {
        try {
            entidad.getTransaction().begin();
            clase = entidad.find(clase.getClass(), campoId);
            if (clase != null) {                
                entidad.remove(clase);
                System.out.println("si llega");
            } else {
                return false;
            }
            entidad.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            entidad.getTransaction().rollback();
            return false;
        }
    }
    public static boolean existe(String nombreTabla, String nombreCampo, String campo) {
        entidad.getTransaction().begin();
        try {
            entidad.createQuery("Select a from " + nombreTabla + " a where " + nombreCampo + " = '" + campo + "'").getSingleResult();
            entidad.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entidad.getTransaction().rollback();
            return false;
        }
    }
    
    public static boolean fechaMayor(String nombreTabla, String nombreCampo, String fecha){
        entidad.getTransaction().begin();
        try{
            entidad.createQuery("Select a from " + nombreTabla + " a where " + nombreCampo + " >= '" + fecha + "'").getSingleResult();
            entidad.getTransaction().commit();
            return true;
        }catch(Exception e){
            entidad.getTransaction().rollback();
            return false;
        }
    }

    public static List listar(String nombreEntidad) {
         entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + nombreEntidad + " a ").getResultList();
            entidad.getTransaction().commit();

        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }
    
    public static List listar(String nombreEntidad, String campo,int id) {
        Object obj = null;
        entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + nombreEntidad + " a where "+campo+" = "+id).getResultList();
            entidad.getTransaction().commit();

        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }
    
    public static Object buscar(String nombreTabla, String nombreCampo, String campo) {
        Object obj = null;
        entidad.getTransaction().begin();
        try {
            obj = entidad.createQuery("Select a from " + nombreTabla + " a where " + nombreCampo + " = '" + campo + "' ").getSingleResult();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return obj;
    }

    public static Object buscar(String nombreTabla, String nomCampo1, String nomCampo2, String nomCampo3, String nomCampo4, String campo1, String campo2, int campo3, int campo4) {
        Object obj = null;
        entidad.getTransaction().begin();
        try {
            Query consulta = entidad.createQuery("Select a from " + nombreTabla + " a where " + nomCampo1 + " = '" + campo1 + "' and " + nomCampo2 + " = '" + campo2 + "' and " + nomCampo3 + " = " + campo3+ " and " + nomCampo4 + " = " + campo4 );
            if(consulta!=null){
                obj=consulta.getResultList();
                entidad.getTransaction().commit();
            }
        } catch (Exception e) {
            System.out.println(e);
            entidad.getTransaction().rollback();
        }
        return obj;
    }
    
    public static List buscarTodos(String nombreTabla, String nombreCampo, String campo) {
        List obj = null;
        entidad.getTransaction().begin();
        try {
            obj = entidad.createQuery("Select a from " + nombreTabla + " a where " + nombreCampo + " = '" + campo + "' ").getResultList();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entidad.getTransaction().rollback();
        }
        return obj;
    }
    
    public static List buscarTodos(String nombreTabla, String nombreCampo, Date fechaDesde, Date fechaHasta, String login) {
        List obj = null;
        entidad.getTransaction().begin();
        try {
            obj = entidad.createQuery(  "Select distinct a from " + nombreTabla + " a "
                                        + "where " + nombreCampo + " >= '" + fechaDesde.toString() + "' "
                                        + "and "+nombreCampo+"<= '"+fechaHasta+"' "
                                        + "and a.actividad.rol.usuario.login= '"+login+"'" 
                                    ).getResultList();//+"and a.actividad.rol.usuario.login= '"+login+"'"
            entidad.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entidad.getTransaction().rollback();
        }
        return obj;
    }
    
    public static List buscarMetas(String nombreTabla, String nombreCampo, Date fechaDesde, Date fechaHasta, String login) {
        List obj = null;
         entidad.clear();
        entidad.getTransaction().begin();
        try {
            obj = entidad.createQuery(  "Select distinct a from " + nombreTabla + " a "
                                        + "where  mes>= "+fechaDesde.getMonth()+" "
                                        + "and mes<= "+fechaHasta.getMonth()+" "
                                        + "and a.actividad.rol.usuario.login= '"+login+"'" 
                                    ).getResultList();//+"and a.actividad.rol.usuario.login= '"+login+"'"
            entidad.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entidad.getTransaction().rollback();
        }
        return obj;
    }
    
    public static List  getItems(String nombreTabla, String nombreCampo,int idActividad ,Date fechaDesde, Date fechaHasta, String login) {
        List obj = null;
        entidad.getTransaction().begin();
        try {
            obj = entidad.createQuery(  "Select  a from " + nombreTabla + " a "
                                        + "where " + nombreCampo + " >= '" + fechaDesde.toString() + "' "
                                        + "and "+nombreCampo+"<= '"+fechaHasta+"' "
                                        + "and a.actividad.id= "+idActividad+" "
                                        + "and a.actividad.rol.usuario.login= '"+login+"'" 
                                    ).getResultList();//+"and a.actividad.rol.usuario.login= '"+login+"'"
            entidad.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entidad.getTransaction().rollback();
        }   
       return obj;
    }
    
    public static List listarPrediccion(String tabla, String colum, String contenido) {
        entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + tabla + " a where " + colum + " like '%" + contenido + "%'").setMaxResults(50).getResultList();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }
    public static List listarPrediccionDoble(String tabla, String colum1, String contenido1,String colum2,String contenido2) {
        entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + tabla + " a where " + colum2 + " = "+contenido2+" AND "+colum1+" like '%" + contenido1 + "%'").setMaxResults(50).getResultList();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }

    public static List listarconCondicion(String nombreEntidad, String columna, String valor) {
        entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + nombreEntidad + " a where " + columna + " = " + valor + " ").getResultList();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }
    
    public static List listarconDobleCondicion(String nombreEntidad, String columna1, String valor1, String columna2, String valor2) {
        entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + nombreEntidad + " a where " + columna1 + " = " + valor1 + " and " + columna2 + " = " + valor2 + " ").getResultList();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }
    
    public static List listarconDobleCondicion(String nombreEntidad, String columna1, String valor1, String columna2, String valor2,String columna3, String valor3) {
        entidad.getTransaction().begin();
        try {
            lista = entidad.createQuery("Select a from " + nombreEntidad + " a where " + columna1 + " = " + valor1 + " and " + columna2 + " = " + valor2 + " and "+columna3+" = "+valor3).getResultList();
            entidad.getTransaction().commit();
        } catch (Exception e) {
            entidad.getTransaction().rollback();
        }
        return lista;
    }
    
    public static boolean eliminar(Object object) {
        entidad.getTransaction().begin();
        try {
            entidad.remove(object);
            entidad.getTransaction().commit();
            System.out.println("si llega aca :P");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            entidad.getTransaction().rollback();
            return false;
        }
    }

    public static void terminar() {
        entidad.close();
    }
}
