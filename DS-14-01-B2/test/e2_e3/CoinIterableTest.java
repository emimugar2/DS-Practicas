/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
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
public class CoinIterableTest {

    public CoinIterableTest() {
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
     * Test of getLista method, of class CoinIterable.
     */
    @Test
    public void testGetLista() {
        System.out.println("getLista");
        CoinIterable instance = new CoinIterable();
        ArrayList<EuroCoin> expResult = new ArrayList<>();
        ArrayList<EuroCoin> result = instance.getLista();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLista method, of class CoinIterable.
     */
    @Test
    public void testSetLista() {
        System.out.println("setLista");
        ArrayList<EuroCoin> lista = null;
        CoinIterable instance = new CoinIterable();
        instance.setLista(lista);
    }
    /**
     * Test of recorrerMonedas method, of class CoinIterable.
     */
    @Test
    public void testRecorrerMonedas() {
        System.out.println("recorrerMonedas");
        Paises pais = null;
        CoinIterable instance = new CoinIterable();
        List expResult = new ArrayList<>();
        List result = instance.recorrerMonedas(pais);
        assertEquals(expResult, result);
    }

    public CoinIterable prepararTest() {
        // THIS COINS MUST BE PROPERLY CREATED IN ORDER TO THE TEST TO WORK CORRECTLY
        EuroCoin e1_sp1 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.UN_EURO, "Juan Carlos I", 1998);
        EuroCoin e1_sp2 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.UN_EURO, "Felipe VI", 2018);
        EuroCoin e2_sp_2005 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.DOS_EUROS, "Juan Carlos I", 2005);
        EuroCoin e2_sp_2002 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.DOS_EUROS, "Juan Carlos I", 2002);
        EuroCoin c50_it = new EuroCoin(Color.ORO, Paises.ITALY, CoinValue.CINCUENTA_CENTIMOS, "", 2002);
        EuroCoin c20_fr = new EuroCoin(Color.ORO, Paises.FRANCE, CoinValue.VEINTE_CENTIMOS, "", 2002);
        EuroCoin c1_pt = new EuroCoin(Color.BRONCE, Paises.PORTUGAL, CoinValue.UN_CENTIMO, "", 2002);
        EuroCoin c1_es = new EuroCoin(Color.BRONCE, Paises.SPAIN, CoinValue.UN_CENTIMO, "", 2002);

        CoinIterable iterable = new CoinIterable();
        iterable.getLista().add(e1_sp1);
        iterable.getLista().add(e1_sp2);
        iterable.getLista().add(e2_sp_2005);
        iterable.getLista().add(e2_sp_2002);
        iterable.getLista().add(c50_it);
        iterable.getLista().add(c20_fr);
        iterable.getLista().add(c1_pt);
        iterable.getLista().add(c1_es);
        return iterable;
    }

    @Test
    public void testRecorrerLista() {
        EuroCoin moneda = null;
        CoinIterable iterable = prepararTest();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            moneda = (EuroCoin) iterator.next();
        }
        EuroCoin c1_es = new EuroCoin(Color.BRONCE, Paises.SPAIN, CoinValue.UN_CENTIMO, "", 2002);
        assertEquals(c1_es, moneda);

    }

    @Test
    public void testBorrarElemento() {
        EuroCoin moneda = null;
        int i = 0;
        CoinIterable iterable = prepararTest();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            moneda = (EuroCoin) iterator.next();
            i++;
            if (i == 2) {
                iterator.remove();
            }
        }
        EuroCoin c1_es = new EuroCoin(Color.BRONCE, Paises.SPAIN, CoinValue.UN_CENTIMO, "", 2002);
        assertEquals(c1_es, moneda);
    }

    @Test(expected = ConcurrentModificationException.class)
    
    public void testBorrarElementoFallo() {
        EuroCoin moneda = null;
        int i = 0;
        CoinIterable iterable = prepararTest();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            moneda = (EuroCoin) iterator.next();
            i++;
            if (i == 2) {
                iterable.getLista().remove(i);
            }
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    
    public void testBorrarElementoFallo2() {
        EuroCoin moneda = null;
        int i = 0;
        CoinIterable iterable = prepararTest();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            moneda = (EuroCoin) iterator.next();
            i++;
            if (i == 2) {
                moneda.setColor(Color.ORO);
                moneda.setValue(CoinValue.UN_EURO);
                moneda.setPais(Paises.LITHUANIA);
                moneda.getColor();
                moneda.getDiseño();
                moneda.getPais();
                moneda.getValue();
                moneda.getAñoAcuñacion();
                iterable.getLista().set(i, moneda);

            }
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testBorrarElementoSinNext() {
        CoinIterable iterable = prepararTest();
        Iterator iterator = iterable.iterator();
        iterator.remove();
    }

    @Test
    public void testPais1() {
        CoinIterable iterable = prepararTest();
        assertEquals(iterable.getLista(), iterable.recorrerMonedas(null));
    }
    
    @Test
    public void testPais2() {
        CoinIterable iterable = prepararTest();
        EuroCoin e1_sp1 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.UN_EURO, "Juan Carlos I", 1998);
        EuroCoin e1_sp2 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.UN_EURO, "Felipe VI", 2018);
        EuroCoin e2_sp_2005 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.DOS_EUROS, "Juan Carlos I", 2005);
        EuroCoin e2_sp_2002 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.DOS_EUROS, "Juan Carlos I", 2002);
        EuroCoin c1_es = new EuroCoin(Color.BRONCE, Paises.SPAIN, CoinValue.UN_CENTIMO, "", 2002);
        List test = new ArrayList();
        test.add(e1_sp1);
        test.add(e1_sp2);
        test.add(e2_sp_2005);
        test.add(e2_sp_2002);
        test.add(c1_es);
        assertEquals(test, iterable.recorrerMonedas(Paises.SPAIN));
        
        
        
    
    }

}
