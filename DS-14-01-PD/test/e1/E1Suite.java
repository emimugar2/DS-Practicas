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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author emimu
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({e1.CambioSimpleTest.class, e1.CambioTest.class, e1.CambioDepositoTest.class, e1.EuroCoinTest.class, e1.VendingMachineTest.class, e1.ProductoTest.class})
public class E1Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
