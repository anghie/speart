/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.acciones.usuario;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class ControladorDestrezaUsuarioTest {
    
    public ControladorDestrezaUsuarioTest() {
    }

    /**
     * Test of listarDestreza method, of class ControladorDestrezaUsuario.
     */
    @Test
    public void testListarDestreza() {
        System.out.println("listarDestreza");
        ControladorDestrezaUsuario instance = null;
        List eList = new ArrayList();
        instance.listarDestreza();
      
        assertEquals(eList, this);
        
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of poneLstDestrezasDisp method, of class ControladorDestrezaUsuario.
     */
    @Test
    public void testPoneLstDestrezasDisp() {
        System.out.println("poneLstDestrezasDisp");
        ControladorDestrezaUsuario instance = null;
        instance.poneLstDestrezasDisp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poneLstDestrezasAsig method, of class ControladorDestrezaUsuario.
     */
    @Test
    public void testPoneLstDestrezasAsig() {
        System.out.println("poneLstDestrezasAsig");
        ControladorDestrezaUsuario instance = null;
        instance.poneLstDestrezasAsig();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregaItemDestrezaAsignados method, of class ControladorDestrezaUsuario.
     */
    @Test
    public void testAgregaItemDestrezaAsignados() {
        System.out.println("agregaItemDestrezaAsignados");
        ControladorDestrezaUsuario instance = null;
        instance.agregaItemDestrezaAsignados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitaItemDestrezaAsignados method, of class ControladorDestrezaUsuario.
     */
    @Test
    public void testQuitaItemDestrezaAsignados() {
        System.out.println("quitaItemDestrezaAsignados");
        ControladorDestrezaUsuario instance = null;
        instance.quitaItemDestrezaAsignados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardaDestrezaUsuario method, of class ControladorDestrezaUsuario.
     */
    @Test
    public void testGuardaDestrezaUsuario() {
        System.out.println("guardaDestrezaUsuario");
        ControladorDestrezaUsuario instance = null;
        instance.guardaDestrezaUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
