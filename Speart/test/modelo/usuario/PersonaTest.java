/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class PersonaTest {
    
    public PersonaTest() {
    }

    /**
     * Test of getProfesion method, of class Persona.
     */
    @Test
    public void testGetProfesion() {
        System.out.println("getProfesion");
        Persona instance = new Persona();
        String expResult = "medico";
        instance.setProfesion(expResult);
        String result = instance.getProfesion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfesion method, of class Persona.
     */
    @Test
    public void testSetProfesion() {
        System.out.println("setProfesion");
        String profesion = "doctor";
        Persona instance = new Persona();
        instance.setProfesion(profesion);
        assertNotNull(profesion);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdPersona method, of class Persona.
     */
    @Test
    public void testGetIdPersona() {
        System.out.println("getIdPersona");
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.getIdPersona();
        instance.setIdPersona(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test ciase is a prototype.");
    }

    /**
     * Test of setIdPersona method, of class Persona.
     */
    @Test
    public void testSetIdPersona() {
        System.out.println("setIdPersona");
        int idPersona = 0;
        Persona instance = new Persona();
        instance.setIdPersona(idPersona);
        assertNotNull(idPersona);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Persona.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Persona instance = new Persona();
        String expResult = "cristina";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Persona.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "cristina";
        Persona instance = new Persona();
        instance.setNombre(nombre);
        assertNotNull(nombre);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidos method, of class Persona.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Persona instance = new Persona();
        String expResult = "carrillo";
        instance.setApellidos(expResult);
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidos method, of class Persona.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = "carrillo";
        Persona instance = new Persona();
        instance.setApellidos(apellidos);
        assertNotNull(apellidos);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getCedula method, of class Persona.
     */
    @Test
    public void testGetCedula() {
        System.out.println("getCedula");
        Persona instance = new Persona();
        String expResult = "1104771181";
        instance.setCedula(expResult);
        String result = instance.getCedula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setCedula method, of class Persona.
     */
    @Test
    public void testSetCedula() {
        System.out.println("setCedula");
        String cedula = "1104771181";
        Persona instance = new Persona();
        instance.setCedula(cedula);
        assertNotNull(cedula);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}
