/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pregunta;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class PreguntaTest {
    
    public PreguntaTest() {
    }

    /**
     * Test of getIdPregunta method, of class Pregunta.
     */
    @Test
    public void testGetIdPregunta() {
        System.out.println("getIdPregunta");
        Pregunta instance = new Pregunta();
        int expResult = 0;
        int result = instance.getIdPregunta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdPregunta method, of class Pregunta.
     */
    @Test
    public void testSetIdPregunta() {
        System.out.println("setIdPregunta");
        int idPregunta = 0;
        Pregunta instance = new Pregunta();
        instance.setIdPregunta(idPregunta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreg method, of class Pregunta.
     */
    @Test
    public void testGetPreg() {
        System.out.println("getPreg");
        Pregunta instance = new Pregunta();
        String expResult = "";
        String result = instance.getPreg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreg method, of class Pregunta.
     */
    @Test
    public void testSetPreg() {
        System.out.println("setPreg");
        String preg = "";
        Pregunta instance = new Pregunta();
        instance.setPreg(preg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHabilit method, of class Pregunta.
     */
    @Test
    public void testIsHabilit() {
        System.out.println("isHabilit");
        Pregunta instance = new Pregunta();
        boolean expResult = false;
        boolean result = instance.isHabilit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilit method, of class Pregunta.
     */
    @Test
    public void testSetHabilit() {
        System.out.println("setHabilit");
        boolean habilit = false;
        Pregunta instance = new Pregunta();
        instance.setHabilit(habilit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeccion method, of class Pregunta.
     */
    @Test
    public void testGetSeccion() {
        System.out.println("getSeccion");
        Pregunta instance = new Pregunta();
        Seccion expResult = null;
        Seccion result = instance.getSeccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeccion method, of class Pregunta.
     */
    @Test
    public void testSetSeccion() {
        System.out.println("setSeccion");
        Seccion seccion = null;
        Pregunta instance = new Pregunta();
        instance.setSeccion(seccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRptas method, of class Pregunta.
     */
    @Test
    public void testGetRptas() {
        System.out.println("getRptas");
        Pregunta instance = new Pregunta();
        List expResult = null;
        List result = instance.getRptas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRptas method, of class Pregunta.
     */
    @Test
    public void testSetRptas() {
        System.out.println("setRptas");
        List<Respuesta> rptas = null;
        Pregunta instance = new Pregunta();
        instance.setRptas(rptas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRpta method, of class Pregunta.
     */
    @Test
    public void testAddRpta() {
        System.out.println("addRpta");
        Respuesta r = null;
        Pregunta instance = new Pregunta();
        instance.addRpta(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
