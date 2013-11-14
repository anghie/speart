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
public class AlgoritmoAESTest {
    
    public AlgoritmoAESTest() {
    }

    /**
     * Test of encriptar method, of class AlgoritmoAES.
     */
    @Test
    public void testEncriptar() {
        System.out.println("encriptar");
        String valorEncriptar = "1234567";
        AlgoritmoAES instance = null;
        String expResult = "1234567890poiuy2";
        String result = instance.encriptar(valorEncriptar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of desencriptar method, of class AlgoritmoAES.
     */
    @Test
    public void testDesencriptar() throws Exception {
        System.out.println("desencriptar");
        String valorEncriptado = "";
        AlgoritmoAES instance = null;
        String expResult = "";
        String result = instance.desencriptar(valorEncriptado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
