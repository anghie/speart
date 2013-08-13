/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pregunta;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class RespuestaTest {
    
    public RespuestaTest() {
    }

    /**
     * Test of getIdRespuesta method, of class Respuesta.
     */
    @Test
    public void testGetIdRespuesta() {
        System.out.println("getIdRespuesta");
        Respuesta instance = new Respuesta();
        int expResult = 0;
        int result = instance.getIdRespuesta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdRespuesta method, of class Respuesta.
     */
    @Test
    public void testSetIdRespuesta() {
        System.out.println("setIdRespuesta");
        int idRespuesta = 0;
        Respuesta instance = new Respuesta();
        instance.setIdRespuesta(idRespuesta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRpta method, of class Respuesta.
     */
    @Test
    public void testGetRpta() {
        System.out.println("getRpta");
        Respuesta instance = new Respuesta();
        String expResult = "";
        String result = instance.getRpta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRpta method, of class Respuesta.
     */
    @Test
    public void testSetRpta() {
        System.out.println("setRpta");
        String rpta = "";
        Respuesta instance = new Respuesta();
        instance.setRpta(rpta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoRpta method, of class Respuesta.
     */
    @Test
    public void testIsEstadoRpta() {
        System.out.println("isEstadoRpta");
        Respuesta instance = new Respuesta();
        boolean expResult = false;
        boolean result = instance.isEstadoRpta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoRpta method, of class Respuesta.
     */
    @Test
    public void testSetEstadoRpta() {
        System.out.println("setEstadoRpta");
        boolean estadoRpta = false;
        Respuesta instance = new Respuesta();
        instance.setEstadoRpta(estadoRpta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPregunta method, of class Respuesta.
     */
    @Test
    public void testGetPregunta() {
        System.out.println("getPregunta");
        Respuesta instance = new Respuesta();
        Pregunta expResult = null;
        Pregunta result = instance.getPregunta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPregunta method, of class Respuesta.
     */
    @Test
    public void testSetPregunta() {
        System.out.println("setPregunta");
        Pregunta pregunta = null;
        Respuesta instance = new Respuesta();
        instance.setPregunta(pregunta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
