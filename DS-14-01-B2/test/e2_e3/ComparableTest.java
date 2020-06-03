/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jose
 */
public class ComparableTest {

    EuroCoin e1_sp1, // Juan Carlos I coin
            e1_sp2, // Felipe VI coin
            e2_sp_2002, // Juan Carlos I coin of 2002
            e2_sp_2005, // Juan Carlos I coin of 2005
            c50_it,
            c20_fr,
            c1_pt,
            c1_es;
    EuroCoinCollection collection;
    EuroCoinCollection coleccionNatural;
    EuroCoinCollection coleccionEspecifica;
    EuroCoinCollection coleccionEspecifica2;

    @Before
    public void setUp() {
        collection = new EuroCoinCollection();
        coleccionNatural = new EuroCoinCollection();
        coleccionEspecifica = new EuroCoinCollection();
        coleccionEspecifica2 = new EuroCoinCollection();

        // THIS COINS MUST BE PROPERLY CREATED IN ORDER TO THE TEST TO WORK CORRECTLY
        e1_sp1 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.UN_EURO, "Juan Carlos I", 1998);
        e1_sp2 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.UN_EURO, "Felipe VI", 2018);
        e2_sp_2005 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.DOS_EUROS, "Juan Carlos I", 2005);
        e2_sp_2002 = new EuroCoin(Color.ORO_PLATA, Paises.SPAIN, CoinValue.DOS_EUROS, "Juan Carlos I", 2002);
        c50_it = new EuroCoin(Color.ORO, Paises.ITALY, CoinValue.CINCUENTA_CENTIMOS, "", 2002);
        c20_fr = new EuroCoin(Color.ORO, Paises.FRANCE, CoinValue.VEINTE_CENTIMOS, "", 2002);
        c1_pt = new EuroCoin(Color.BRONCE, Paises.PORTUGAL, CoinValue.UN_CENTIMO, "", 2002);
        c1_es = new EuroCoin(Color.BRONCE, Paises.SPAIN, CoinValue.UN_CENTIMO, "", 2002);
        
        assertTrue(collection.insertCoin(e1_sp1));
        assertTrue(collection.insertCoin(e1_sp2));
        assertTrue(collection.insertCoin(e2_sp_2002));
        assertFalse(collection.insertCoin(e2_sp_2005)); // Not inserted
        assertTrue(collection.insertCoin(c50_it));
        assertTrue(collection.insertCoin(c20_fr));
        assertFalse(collection.insertCoin(c50_it)); // Not inserted 

        assertTrue(coleccionNatural.insertCoin(e2_sp_2002));
        assertTrue(coleccionNatural.insertCoin(e1_sp2));
        assertTrue(coleccionNatural.insertCoin(e1_sp1));
        assertTrue(coleccionNatural.insertCoin(c50_it));
        assertTrue(coleccionNatural.insertCoin(c20_fr));

        assertTrue(coleccionEspecifica.insertCoin(c20_fr));
        assertTrue(coleccionEspecifica.insertCoin(c50_it));
        assertTrue(coleccionEspecifica.insertCoin(e2_sp_2002));
        assertTrue(coleccionEspecifica.insertCoin(e1_sp1));
        assertTrue(coleccionEspecifica.insertCoin(e1_sp2));
        
        
        assertTrue(coleccionEspecifica2.insertCoin(c1_es));
        assertTrue(coleccionEspecifica2.insertCoin(c20_fr));
        assertTrue(coleccionEspecifica2.insertCoin(c50_it));
        assertTrue(coleccionEspecifica2.insertCoin(e2_sp_2002));
        assertTrue(coleccionEspecifica2.insertCoin(e1_sp1));
        assertTrue(coleccionEspecifica2.insertCoin(e1_sp2));

    }

    @Test
    public void testNumCoins() {
        assertEquals(5, collection.numCoins());
    }

    /**
     * Test para comprobar la ordenacion natural
     */
    @Test
    public void naturalOrdTest() {
        collection.naturalOrd();

        assertEquals(collection.getColeccion(), coleccionNatural.getColeccion());
    }

    /**
     * Test para comprobar una ordenacion especifica
     */
    @Test
    public void especificaOrdTest() {

        collection.especificaOrd();

        assertEquals(collection.getColeccion(), coleccionEspecifica.getColeccion());
    }

    /**
     * Test ordenar una coleccion ordenada de la misma forma
     */
    @Test
    public void especificaOrdTest2() {

        EuroCoinCollection c1 = coleccionEspecifica;

        coleccionEspecifica.especificaOrd();

        assertEquals(c1.getColeccion(), coleccionEspecifica.getColeccion());
    }

    /**
     * Test ordenar una coleccion ordenada de forma natural
     */
    @Test
    public void especificaOrdTest3() {

        EuroCoinCollection c1 = coleccionNatural;

        coleccionNatural.especificaOrd();

        assertEquals(c1.getColeccion(), coleccionNatural.getColeccion());
    }
    
    /**
     * Test borrar y reordenar
     */
    @Test
    public void borraOrdTest(){
        
        collection.removeCoin(c50_it);
        collection.naturalOrd();
        coleccionNatural.removeCoin(c50_it);
        
        assertEquals(coleccionNatural.getColeccion().get(0).toString(),collection.getColeccion().get(0).toString());
        assertEquals(coleccionNatural.getColeccion(), collection.getColeccion());
        
    }
}
