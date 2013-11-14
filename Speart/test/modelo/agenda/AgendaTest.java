/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.agenda;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class AgendaTest {
    
    public AgendaTest() {
    }

    /**
     * Test of getId method, of class Agenda.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Agenda instance = new Agenda();
        int expResult = 0;
        int result = instance.getId();
        instance.setId(result);
        assertSame(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Agenda.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Agenda instance = new Agenda();
        instance.setId(id);
        assertNotSame(instance, id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsAgenda method, of class Agenda.
     */
    @Test
    public void testGetItemsAgenda() {
        System.out.println("getItemsAgenda");
        Agenda instance = new Agenda();
        List expResult = new  ArrayList<>();
        instance.setItemsAgenda(expResult);
        List result = instance.getItemsAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemsAgenda method, of class Agenda.
     */
    @Test
    public void testSetItemsAgenda() {
        System.out.println("setItemsAgenda");
        List<ItemAgenda> itemsAgenda = new ArrayList<>();
        Agenda instance = new Agenda();
        instance.setItemsAgenda(itemsAgenda);
        assertNotNull(itemsAgenda);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Agenda.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Agenda instance = new Agenda();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Agenda.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Agenda instance = new Agenda();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiasFeriados method, of class Agenda.
     */
    @Test
    public void testGetDiasFeriados() {
        System.out.println("getDiasFeriados");
        Agenda instance = new Agenda();
        List expResult = null;
        List result = instance.getDiasFeriados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiasFeriados method, of class Agenda.
     */
    @Test
    public void testSetDiasFeriados() {
        System.out.println("setDiasFeriados");
        List<DiaFeriado> diasFeriados = null;
        Agenda instance = new Agenda();
        instance.setDiasFeriados(diasFeriados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
