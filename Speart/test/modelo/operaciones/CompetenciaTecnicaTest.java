/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.operaciones;

import java.util.ArrayList;
import java.util.List;
import modelo.proceso.Rol;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateo
 */
public class CompetenciaTecnicaTest {
    
    public CompetenciaTecnicaTest() {
    }

    /**
     * Test of getId method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreDestrezaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetNombreDestrezaTec() {
        System.out.println("getNombreDestrezaTec");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        String expResult = "";
        String result = instance.getNombreDestrezaTec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreDestrezaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetNombreDestrezaTec() {
        System.out.println("setNombreDestrezaTec");
        String nombreDestreza = "";
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setNombreDestrezaTec(nombreDestreza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAltaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetAltaTec() {
        System.out.println("getAltaTec");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        String expResult = "";
        String result = instance.getAltaTec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAltaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetAltaTec() {
        System.out.println("setAltaTec");
        String alta = "";
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setAltaTec(alta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMediaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetMediaTec() {
        System.out.println("getMediaTec");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        String expResult = "";
        String result = instance.getMediaTec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMediaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetMediaTec() {
        System.out.println("setMediaTec");
        String media = "";
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setMediaTec(media);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBajaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetBajaTec() {
        System.out.println("getBajaTec");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        String expResult = "";
        String result = instance.getBajaTec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBajaTec method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetBajaTec() {
        System.out.println("setBajaTec");
        String baja = "";
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setBajaTec(baja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isParaEvaluacionCT method, of class CompetenciaTecnica.
     */
    @Test
    public void testIsParaEvaluacionCT() {
        System.out.println("isParaEvaluacionCT");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        boolean expResult = false;
        boolean result = instance.isParaEvaluacionCT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParaEvaluacionCT method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetParaEvaluacionCT() {
        System.out.println("setParaEvaluacionCT");
        boolean paraEvaluacionCT = false;
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setParaEvaluacionCT(paraEvaluacionCT);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRolesCT method, of class CompetenciaTecnica.
     */
    @Test
    public void testGetRolesCT() {
        System.out.println("getRolesCT");
        CompetenciaTecnica instance = new CompetenciaTecnica();
        List expResult = null;
        List result = instance.getRolesCT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRolesCT method, of class CompetenciaTecnica.
     */
    @Test
    public void testSetRolesCT() {
        System.out.println("setRolesCT");
        List<Rol> rolesCT = new ArrayList<> ();
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.setRolesCT(rolesCT);
        assertNotNull(rolesCT);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addRol method, of class CompetenciaTecnica.
     */
    @Test
    public void testAddRol() {
        System.out.println("addRol");
        Rol r = null;
        CompetenciaTecnica instance = new CompetenciaTecnica();
        instance.addRol(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
