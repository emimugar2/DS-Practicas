/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emimu
 */
public class CambioSimpleTest {
    
    public CambioSimpleTest() {
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
     * Test of getInstance method, of class CambioSimple.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        CambioSimple expResult = null;
        CambioSimple result = CambioSimple.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolverCambio method, of class CambioSimple.
     */
    @Test
    public void testDevolverCambio() {
        System.out.println("devolverCambio");
        CambioSimple instance = null;
        EuroCoin[] expResult = null;
        EuroCoin[] result = instance.devolverCambio();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
