/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.proceso;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class ActividadTest {
    
    public ActividadTest() {
    }

    /**
     * Test of getIdActividad method, of class Actividad.
     */
    @Test
    public void testGetIdActividad() {
        System.out.println("getIdActividad");
        Actividad instance = new Actividad();
        int expResult = 0;
        int result = instance.getIdActividad();
        instance.setIdActividad(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdActividad method, of class Actividad.
     */
    @Test
    public void testSetIdActividad() {
        System.out.println("setIdActividad");
        int idActividad = 0;
        Actividad instance = new Actividad();
        instance.setIdActividad(idActividad);
        assertNotNull(idActividad);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcesito method, of class Actividad.
     */
    @Test
    public void testGetProcesito() {
        System.out.println("getProcesito");
        Actividad instance = new Actividad();
        Proceso expResult = new Proceso();
        instance.setProcesito(expResult);
        Proceso result = instance.getProcesito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcesito method, of class Actividad.
     */
    @Test
    public void testSetProcesito() {
        System.out.println("setProcesito");
        Proceso procesito = new Proceso();
        Actividad instance = new Actividad();
        instance.setProcesito(procesito);
        assertNotNull(procesito);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedioVerificacion method, of class Actividad.
     */
    @Test
   
    public void testGetNombreActividad() {
        System.out.println("getNombreActividad");
        Actividad instance = new Actividad();
        String expResult = "accidentes";
        instance.setNombreActividad(expResult);
        String result = instance.getNombreActividad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreActividad method, of class Actividad.
     */
    @Test
    public void testSetNombreActividad() {
        System.out.println("setNombreActividad");
        String nombreActividad = "accidente";
        Actividad instance = new Actividad();
        instance.setNombreActividad(nombreActividad);
        assertNotNull(nombreActividad);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoActividad method, of class Actividad.
     */
    @Test
    public void testGetTipoActividad() {
        System.out.println("getTipoActividad");
        Actividad instance = new Actividad();
        String expResult = "tecnica";
        instance.setTipoActividad(expResult);
        String result = instance.getTipoActividad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoActividad method, of class Actividad.
     */
    @Test
    public void testSetTipoActividad() {
        System.out.println("setTipoActividad");
        String tipoActividad = "Tecnica";
        Actividad instance = new Actividad();
        instance.setTipoActividad(tipoActividad);
        assertNotNull(tipoActividad);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrecuencia method, of class Actividad.
     */
    

    /**
     * Test of setFrecuencia method, of class Actividad.
     */
  

    /**
     * Test of getVolumen method, of class Actividad.
     */
   

    /**
     * Test of setVolumen method, of class Actividad.
     */
    
    /**
     * Test of getTiempoParcial method, of class Actividad.
     */
   

    /**
     * Test of setTiempoParcial method, of class Actividad.
     */
    

    /**
     * Test of getRol method, of class Actividad.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Actividad instance = new Actividad();
        Rol expResult = null;
        instance.setRol(expResult);
        Rol result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class Actividad.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        Rol rol = new Rol();
        Actividad instance = new Actividad();
        instance.setRol(rol);
        assertNotNull(rol);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setMedioVerificacion method, of class Actividad.
     */
   

    /**
     * Test of getDescripcion method, of class Actividad.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Actividad instance = new Actividad();
        String expResult = "1132423";
        instance.setDescripcion(expResult);
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Actividad.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Actividad instance = new Actividad();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isParaEvaluacion method, of class Actividad.
     */
    @Test
    public void testIsParaEvaluacion() {
        System.out.println("isParaEvaluacion");
        Actividad instance = new Actividad();
        boolean expResult = false;
        instance.setParaEvaluacion(expResult);
        boolean result = instance.isParaEvaluacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setParaEvaluacion method, of class Actividad.
     */
    @Test
    public void testSetParaEvaluacion() {
        System.out.println("setParaEvaluacion");
        boolean paraEvaluacion = true;
        Actividad instance = new Actividad();
        instance.setParaEvaluacion(paraEvaluacion);
        assertNotNull(paraEvaluacion);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
