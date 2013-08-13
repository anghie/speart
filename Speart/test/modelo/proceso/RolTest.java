/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.proceso;

import com.lowagie.text.ListItem;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import modelo.pregunta.Seccion;
import modelo.usuario.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class RolTest {
    
    public RolTest() {
    }

    /**
     * Test of getUsuario method, of class Rol.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Rol instance = new Rol();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class Rol.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        Rol instance = new Rol();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActividades method, of class Rol.
     */
    @Test
    public void testGetActividades() {
        System.out.println("getActividades");
        Rol instance = new Rol();
        List expResult = new ArrayList<>();
        instance.setActividades(expResult);
        List result = instance.getActividades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setActividades method, of class Rol.
     */
    @Test
    public void testSetActividades() {
        System.out.println("setActividades");
        List<Actividad> actividades = new ArrayList<>();
        Rol instance = new Rol();
        instance.setActividades(actividades);
        assertNotNull(actividades);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdRol method, of class Rol.
     */
    @Test
    public void testGetIdRol() {
        System.out.println("getIdRol");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.getIdRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdRol method, of class Rol.
     */
    @Test
    public void testSetIdRol() {
        System.out.println("setIdRol");
        int idRol = 0;
        Rol instance = new Rol();
        instance.setIdRol(idRol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Rol.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Rol instance = new Rol();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Rol.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Rol instance = new Rol();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEvaluable method, of class Rol.
     */
    @Test
    public void testIsEvaluable() {
        System.out.println("isEvaluable");
        Rol instance = new Rol();
        boolean expResult = false;
        boolean result = instance.isEvaluable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvaluable method, of class Rol.
     */
    @Test
    public void testSetEvaluable() {
        System.out.println("setEvaluable");
        boolean evaluable = false;
        Rol instance = new Rol();
        instance.setEvaluable(evaluable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoEvaluacion method, of class Rol.
     */
    @Test
    public void testGetEstadoEvaluacion() {
        System.out.println("getEstadoEvaluacion");
        Rol instance = new Rol();
        String expResult = "";
        String result = instance.getEstadoEvaluacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoEvaluacion method, of class Rol.
     */
    @Test
    public void testSetEstadoEvaluacion() {
        System.out.println("setEstadoEvaluacion");
        String estadoEvaluacion = "";
        Rol instance = new Rol();
        instance.setEstadoEvaluacion(estadoEvaluacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addActividad method, of class Rol.
     */
    @Test
    public void testAddActividad() {
        System.out.println("addActividad");
        Actividad a = null;
        Rol instance = new Rol();
        instance.addActividad(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gethExt method, of class Rol.
     */
    @Test
    public void testGethExt() {
        System.out.println("gethExt");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.gethExt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sethExt method, of class Rol.
     */
    @Test
    public void testSethExt() {
        System.out.println("sethExt");
        int hExt = 0;
        Rol instance = new Rol();
        instance.sethExt(hExt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gethLab method, of class Rol.
     */
    @Test
    public void testGethLab() {
        System.out.println("gethLab");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.gethLab();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sethLab method, of class Rol.
     */
    @Test
    public void testSethLab() {
        System.out.println("sethLab");
        int hLab = 0;
        Rol instance = new Rol();
        instance.sethLab(hLab);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRem method, of class Rol.
     */
    @Test
    public void testGetRem() {
        System.out.println("getRem");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.getRem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRem method, of class Rol.
     */
    @Test
    public void testSetRem() {
        System.out.println("setRem");
        int rem = 0;
        Rol instance = new Rol();
        instance.setRem(rem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargo method, of class Rol.
     */
    @Test
    public void testGetCargo() {
        System.out.println("getCargo");
        Rol instance = new Rol();
        String expResult = "";
        String result = instance.getCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargo method, of class Rol.
     */
    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        String cargo = "";
        Rol instance = new Rol();
        instance.setCargo(cargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeccions method, of class Rol.
     */
    @Test
    public void testGetSeccions() {
        System.out.println("getSeccions");
        Rol instance = new Rol();
        List expResult = null;
        List result = instance.getSeccions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeccions method, of class Rol.
     */
    @Test
    public void testSetSeccions() {
        System.out.println("setSeccions");
        List<Seccion> seccions = null;
        Rol instance = new Rol();
        instance.setSeccions(seccions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompetenciaTecnicas method, of class Rol.
     */
    @Test
    public void testGetCompetenciaTecnicas() {
        System.out.println("getCompetenciaTecnicas");
        Rol instance = new Rol();
        List expResult = null;
        List result = instance.getCompetenciaTecnicas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
