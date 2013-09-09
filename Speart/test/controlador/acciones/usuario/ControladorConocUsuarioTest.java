/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.usuario;

import java.util.ArrayList;
import java.util.List;
import modelo.pregunta.Seccion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class ControladorConocUsuarioTest {
    
    public ControladorConocUsuarioTest() {
    }

    /**
     * Test of listarSeccion method, of class ControladorConocUsuario.
     */
    @Test
    public void testListarSeccion() {
        System.out.println("listarSeccion");
        ControladorConocUsuario instance = null;
        instance.listarSeccion();
      
        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getConocimientosDisponibles method, of class ControladorConocUsuario.
     */
    @Test
    public void testGetConocimientosDisponibles() {
        System.out.println("getConocimientosDisponibles");
        ControladorConocUsuario instance = null;
        ArrayList expResult = new  ArrayList();
        ArrayList result =  new ArrayList();
      
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getConocimientosAsignados method, of class ControladorConocUsuario.
     */
    @Test
    public void testGetConocimientosAsignados() {
        System.out.println("getConocimientosAsignados");
        ControladorConocUsuario instance = null;
        ArrayList expResult = new ArrayList();
        ArrayList result = new ArrayList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of poneLstConocDisp method, of class ControladorConocUsuario.
     */
    @Test
    public void testPoneLstConocDisp() {
        System.out.println("poneLstConocDisp");
        ControladorConocUsuario instance = null;
        instance.poneLstConocDisp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poneLstConocAsig method, of class ControladorConocUsuario.
     */
    @Test
    public void testPoneLstConocAsig() {
        System.out.println("poneLstConocAsig");
        ControladorConocUsuario instance = null;
        instance.poneLstConocAsig();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregaItemConocAsignados method, of class ControladorConocUsuario.
     */
    @Test
    public void testAgregaItemConocAsignados() {
        System.out.println("agregaItemConocAsignados");
        Seccion s = null;
        ControladorConocUsuario instance = null;
        instance.agregaItemConocAsignados(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitaItemConocAsignados method, of class ControladorConocUsuario.
     */
    @Test
    public void testQuitaItemConocAsignados() {
        System.out.println("quitaItemConocAsignados");
        Seccion s = null;
        ControladorConocUsuario instance = null;
        instance.quitaItemConocAsignados(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardaConocUsuario method, of class ControladorConocUsuario.
     */
    @Test
    public void testGuardaConocUsuario() {
        System.out.println("guardaConocUsuario");
        ControladorConocUsuario instance = null;
        instance.guardaConocUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
