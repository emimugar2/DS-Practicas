/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.List;
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
public class VendingMachineTest {
    
    public VendingMachineTest() {
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
     * Test of insertProduct method, of class VendingMachine.
     */
    @Test
    public void testInsertProduct() {
        System.out.println("insertProduct");
        String product = "";
        int price = 0;
        VendingMachine instance = new VendingMachine();
        instance.insertProduct(product, price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCoin method, of class VendingMachine.
     */
    @Test
    public void testInsertCoin() {
        System.out.println("insertCoin");
        EuroCoin e = null;
        VendingMachine instance = new VendingMachine();
        instance.insertCoin(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancel method, of class VendingMachine.
     */
    @Test
    public void testCancel() {
        System.out.println("cancel");
        VendingMachine instance = new VendingMachine();
        List<EuroCoin> expResult = null;
        List<EuroCoin> result = instance.cancel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buy method, of class VendingMachine.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        String product = "";
        VendingMachine instance = new VendingMachine();
        List<EuroCoin> expResult = null;
        List<EuroCoin> result = instance.buy(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
