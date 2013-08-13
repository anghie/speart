/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.agenda;

import java.util.Date;
import modelo.proceso.Actividad;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class ItemAgendaTest {
    
    public ItemAgendaTest() {
    }

    /**
     * Test of getActividad method, of class ItemAgenda.
     */
    @Test
    public void testGetActividad() {
        System.out.println("getActividad");
        ItemAgenda instance = new ItemAgenda();
        Actividad expResult = null;
        Actividad result = instance.getActividad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActividad method, of class ItemAgenda.
     */
    @Test
    public void testSetActividad() {
        System.out.println("setActividad");
        Actividad actividad = null;
        ItemAgenda instance = new ItemAgenda();
        instance.setActividad(actividad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgenda method, of class ItemAgenda.
     */
    @Test
    public void testGetAgenda() {
        System.out.println("getAgenda");
        ItemAgenda instance = new ItemAgenda();
        Agenda expResult = null;
        Agenda result = instance.getAgenda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgenda method, of class ItemAgenda.
     */
    @Test
    public void testSetAgenda() {
        System.out.println("setAgenda");
        Agenda agenda = null;
        ItemAgenda instance = new ItemAgenda();
        instance.setAgenda(agenda);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraFin method, of class ItemAgenda.
     */
    @Test
    public void testGetHoraFin() {
        System.out.println("getHoraFin");
        ItemAgenda instance = new ItemAgenda();
        Date expResult = null;
        Date result = instance.getHoraFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraFin method, of class ItemAgenda.
     */
    @Test
    public void testSetHoraFin() {
        System.out.println("setHoraFin");
        Date horaFin = null;
        ItemAgenda instance = new ItemAgenda();
        instance.setHoraFin(horaFin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraInicio method, of class ItemAgenda.
     */
    @Test
    public void testGetHoraInicio() {
        System.out.println("getHoraInicio");
        ItemAgenda instance = new ItemAgenda();
        Date expResult = null;
        Date result = instance.getHoraInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraInicio method, of class ItemAgenda.
     */
    @Test
    public void testSetHoraInicio() {
        System.out.println("setHoraInicio");
        Date horaInicio = null;
        ItemAgenda instance = new ItemAgenda();
        instance.setHoraInicio(horaInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class ItemAgenda.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ItemAgenda instance = new ItemAgenda();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class ItemAgenda.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ItemAgenda instance = new ItemAgenda();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class ItemAgenda.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        ItemAgenda instance = new ItemAgenda();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class ItemAgenda.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        ItemAgenda instance = new ItemAgenda();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDia method, of class ItemAgenda.
     */
    @Test
    public void testGetDia() {
        System.out.println("getDia");
        ItemAgenda instance = new ItemAgenda();
        String expResult = "";
        String result = instance.getDia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDia method, of class ItemAgenda.
     */
    @Test
    public void testSetDia() {
        System.out.println("setDia");
        String dia = "";
        ItemAgenda instance = new ItemAgenda();
        instance.setDia(dia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMes method, of class ItemAgenda.
     */
    @Test
    public void testGetMes() {
        System.out.println("getMes");
        ItemAgenda instance = new ItemAgenda();
        String expResult = "";
        String result = instance.getMes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMes method, of class ItemAgenda.
     */
    @Test
    public void testSetMes() {
        System.out.println("setMes");
        String mes = "";
        ItemAgenda instance = new ItemAgenda();
        instance.setMes(mes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCompletada method, of class ItemAgenda.
     */
    @Test
    public void testIsCompletada() {
        System.out.println("isCompletada");
        ItemAgenda instance = new ItemAgenda();
        boolean expResult = false;
        boolean result = instance.isCompletada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompletada method, of class ItemAgenda.
     */
    @Test
    public void testSetCompletada() {
        System.out.println("setCompletada");
        boolean completada = false;
        ItemAgenda instance = new ItemAgenda();
        instance.setCompletada(completada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTiempoDuracion method, of class ItemAgenda.
     */
    @Test
    public void testGetTiempoDuracion() {
        System.out.println("getTiempoDuracion");
        ItemAgenda instance = new ItemAgenda();
        Date expResult = null;
        Date result = instance.getTiempoDuracion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTiempoDuracion method, of class ItemAgenda.
     */
    @Test
    public void testSetTiempoDuracion() {
        System.out.println("setTiempoDuracion");
        Date tiempoDuracion = null;
        ItemAgenda instance = new ItemAgenda();
        instance.setTiempoDuracion(tiempoDuracion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDia_del_mes method, of class ItemAgenda.
     */
    @Test
    public void testGetDia_del_mes() {
        System.out.println("getDia_del_mes");
        ItemAgenda instance = new ItemAgenda();
        String expResult = "";
        String result = instance.getDia_del_mes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDia_del_mes method, of class ItemAgenda.
     */
    @Test
    public void testSetDia_del_mes() {
        System.out.println("setDia_del_mes");
        String dia_del_mes = "";
        ItemAgenda instance = new ItemAgenda();
        instance.setDia_del_mes(dia_del_mes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre_actividad method, of class ItemAgenda.
     */
    @Test
    public void testGetNombre_actividad() {
        System.out.println("getNombre_actividad");
        ItemAgenda instance = new ItemAgenda();
        String expResult = "";
        String result = instance.getNombre_actividad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre_actividad method, of class ItemAgenda.
     */
    @Test
    public void testSetNombre_actividad() {
        System.out.println("setNombre_actividad");
        String nombre_actividad = "";
        ItemAgenda instance = new ItemAgenda();
        instance.setNombre_actividad(nombre_actividad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRecordar method, of class ItemAgenda.
     */
    @Test
    public void testIsRecordar() {
        System.out.println("isRecordar");
        ItemAgenda instance = new ItemAgenda();
        boolean expResult = false;
        boolean result = instance.isRecordar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecordar method, of class ItemAgenda.
     */
    @Test
    public void testSetRecordar() {
        System.out.println("setRecordar");
        boolean recordar = false;
        ItemAgenda instance = new ItemAgenda();
        instance.setRecordar(recordar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ItemAgenda.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ItemAgenda instance = new ItemAgenda();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservacion method, of class ItemAgenda.
     */
    @Test
    public void testGetObservacion() {
        System.out.println("getObservacion");
        ItemAgenda instance = new ItemAgenda();
        String expResult = "";
        String result = instance.getObservacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservacion method, of class ItemAgenda.
     */
    @Test
    public void testSetObservacion() {
        System.out.println("setObservacion");
        String observacion = "";
        ItemAgenda instance = new ItemAgenda();
        instance.setObservacion(observacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPorcentaje method, of class ItemAgenda.
     */
    @Test
    public void testGetPorcentaje() {
        System.out.println("getPorcentaje");
        ItemAgenda instance = new ItemAgenda();
        double expResult = 0.0;
        double result = instance.getPorcentaje();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPorcentaje method, of class ItemAgenda.
     */
    @Test
    public void testSetPorcentaje() {
        System.out.println("setPorcentaje");
        double porcentaje = 0.0;
        ItemAgenda instance = new ItemAgenda();
        instance.setPorcentaje(porcentaje);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
