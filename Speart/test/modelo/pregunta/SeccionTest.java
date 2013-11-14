/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pregunta;

import java.util.ArrayList;
import java.util.List;
import modelo.proceso.Rol;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class SeccionTest {
    
    public SeccionTest() {
    }

    /**
     * Test of getIdSeccion method, of class Seccion.
     */
    @Test
    public void testGetIdSeccion() {
        System.out.println("getIdSeccion");
        Seccion instance = new Seccion();
        long expResult = 0L;
        long result = instance.getIdSeccion();
         assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdSeccion method, of class Seccion.
     */
    @Test
    public void testSetIdSeccion() {
        System.out.println("setIdSeccion");
        int idSeccion = 3;
        Seccion instance = new Seccion();
        instance.setIdSeccion(idSeccion);
        assertTrue(true);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreSeccion method, of class Seccion.
     */
    @Test
    public void testGetNombreSeccion() {
        System.out.println("getNombreSeccion");
        Seccion instance = new Seccion();
        String expResult = "";
        String result = instance.getNombreSeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreSeccion method, of class Seccion.
     */
    @Test
    public void testSetNombreSeccion() {
        System.out.println("setNombreSeccion");
        String nombreSeccion = "";
        Seccion instance = new Seccion();
        instance.setNombreSeccion(nombreSeccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreguntas method, of class Seccion.
     */
    @Test
    public void testGetPreguntas() {
        System.out.println("getPreguntas");
        Seccion instance = new Seccion();
        List expResult = null;
        List result = instance.getPreguntas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreguntas method, of class Seccion.
     */
    @Test
    public void testSetPreguntas() {
        System.out.println("setPreguntas");
        List<Pregunta> preguntas = new ArrayList<>();
        Seccion instance = new Seccion();
        instance.setPreguntas(preguntas);
        assertNotNull(preguntas);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isParaEvaluacion method, of class Seccion.
     */
    @Test
    public void testIsParaEvaluacion() {
        System.out.println("isParaEvaluacion");
        Seccion instance = new Seccion();
        boolean expResult = false;
        boolean result = instance.isParaEvaluacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParaEvaluacion method, of class Seccion.
     */
    @Test
    public void testSetParaEvaluacion() {
        System.out.println("setParaEvaluacion");
        boolean paraEvaluacion = false;
        Seccion instance = new Seccion();
        instance.setParaEvaluacion(paraEvaluacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoles method, of class Seccion.
     */
    @Test
    public void testGetRoles() {
        System.out.println("getRoles");
        Seccion instance = new Seccion();
        List expResult = null;
        List result = instance.getRoles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoles method, of class Seccion.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
        List<Rol> roles = null;
        Seccion instance = new Seccion();
        instance.setRoles(roles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRol method, of class Seccion.
     */
    @Test
    public void testAddRol() {
        System.out.println("addRol");
        Rol r = null;
        Seccion instance = new Seccion();
        instance.addRol(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeRol method, of class Seccion.
     */
    @Test
    public void testRemoveRol() {
        System.out.println("removeRol");
        Rol r = null;
        Seccion instance = new Seccion();
        instance.removeRol(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
