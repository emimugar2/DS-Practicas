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
public class CambioTest {
    
    public CambioTest() {
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
     * Test of getImporte method, of class Cambio.
     */
    @Test
    public void testGetImporte() {
        System.out.println("getImporte");
        Cambio instance = new CambioImpl();
        int expResult = 0;
        int result = instance.getImporte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notificarGasto method, of class Cambio.
     */
    @Test
    public void testNotificarGasto() {
        System.out.println("notificarGasto");
        int gasto = 0;
        Cambio instance = new CambioImpl();
        instance.notificarGasto(gasto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelar method, of class Cambio.
     */
    @Test
    public void testCancelar() {
        System.out.println("cancelar");
        Cambio instance = new CambioImpl();
        EuroCoin[] expResult = null;
        EuroCoin[] result = instance.cancelar();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetear method, of class Cambio.
     */
    @Test
    public void testResetear() {
        System.out.println("resetear");
        Cambio instance = new CambioImpl();
        instance.resetear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devolverCambio method, of class Cambio.
     */
    @Test
    public void testDevolverCambio() {
        System.out.println("devolverCambio");
        Cambio instance = new CambioImpl();
        EuroCoin[] expResult = null;
        EuroCoin[] result = instance.devolverCambio();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CambioImpl extends Cambio {

        public EuroCoin[] devolverCambio() {
            return null;
        }
    }
    
}
