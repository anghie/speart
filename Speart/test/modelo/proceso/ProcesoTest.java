/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.proceso;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class ProcesoTest {
    
    public ProcesoTest() {
    }

    /**
     * Test of getIdProceso method, of class Proceso.
     */
    @Test
    public void testGetIdProceso() {
        System.out.println("getIdProceso");
        Proceso instance = new Proceso();
        int expResult = 0;
        instance.setIdProceso(expResult);
        int result = instance.getIdProceso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdProceso method, of class Proceso.
     */
    @Test
    public void testSetIdProceso() {
        System.out.println("setIdProceso");
        int idProceso = 0;
        Proceso instance = new Proceso();
        instance.setIdProceso(idProceso);
        assertNotNull(idProceso);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreProceso method, of class Proceso.
     */
    @Test
    public void testGetNombreProceso() {
        System.out.println("getNombreProceso");
        Proceso instance = new Proceso();
        String expResult = "accidente";
        instance.setNombreProceso(expResult);
        String result = instance.getNombreProceso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreProceso method, of class Proceso.
     */
    @Test
    public void testSetNombreProceso() {
        System.out.println("setNombreProceso");
        String nombreProceso = "prestaciones";
        Proceso instance = new Proceso();
        instance.setNombreProceso(nombreProceso);
        assertNotNull(nombreProceso);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndicador method, of class Proceso.
     */
    @Test
    public void testGetIndicador() {
        System.out.println("getIndicador");
        Proceso instance = new Proceso();
        String expResult = "1";
        instance.setIndicador(expResult);
        String result = instance.getIndicador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setIndicador method, of class Proceso.
     */
    @Test
    public void testSetIndicador() {
        System.out.println("setIndicador");
        String indicador = "1";
        Proceso instance = new Proceso();
        instance.setIndicador(indicador);
        assertNotNull(indicador);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getActividades method, of class Proceso.
     */
    @Test
    public void testGetActividades() {
        System.out.println("getActividades");
        Proceso instance = new Proceso();
        List expResult = new ArrayList<>();
        instance.setActividades(expResult);
        List result = instance.getActividades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setActividades method, of class Proceso.
     */
    @Test
    public void testSetActividades() {
        System.out.println("setActividades");
        List<Actividad> actividades = new ArrayList<>();
        Proceso instance = new Proceso();
        instance.setActividades(actividades);
        assertNotNull(actividades);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addActividad method, of class Proceso.
     */
    @Test
    public void testAddActividad() {
        System.out.println("addActividad");
        Actividad a = new Actividad();
        Proceso instance = new Proceso();
        instance.addActividad(a);
        assertNotNull(a);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
