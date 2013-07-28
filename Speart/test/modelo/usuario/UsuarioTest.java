/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import modelo.proceso.Rol;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRol method, of class Usuario.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Usuario instance = new Usuario();
        Rol expResult = null;
        instance.setRol(expResult);
        Rol result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class Usuario.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        Rol rol = new Rol();
        Usuario instance = new Usuario();
        instance.setRol(rol);
        assertNotNull(rol);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class Usuario.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Usuario instance = new Usuario();        
        String expResult = "hola";      
        instance.setLogin(expResult);
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class Usuario.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "hola";
        Usuario instance = new Usuario();
        instance.setLogin(login);
        assertNotNull(login);
        // TODO review the geinstnerated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getClave method, of class Usuario.
     */
    @Test
    public void testGetClave() {
        System.out.println("getClave");
        Usuario instance = new Usuario();
        String expResult = "clave";
        instance.setClave(expResult);
        String result = instance.getClave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setClave method, of class Usuario.
     */
    @Test
    public void testSetClave() {
        System.out.println("setClave");
        String clave = "clavecita";
        Usuario instance = new Usuario();
        instance.setClave(clave);
        assertNotNull(clave);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isHabilitado method, of class Usuario.
     */
    @Test
    public void testIsHabilitado() {
        System.out.println("isHabilitado");
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.isHabilitado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilitado method, of class Usuario.
     */
    @Test
    public void testSetHabilitado() {
        System.out.println("setHabilitado");
        boolean habilitado = false;
        Usuario instance = new Usuario();
        instance.setHabilitado(habilitado);
        assertTrue(!habilitado);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
}