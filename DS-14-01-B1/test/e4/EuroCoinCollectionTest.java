package e4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EuroCoinCollectionTest {
    EuroCoin e1_sp1, // Juan Carlos I coin
             e1_sp2, // Felipe VI coin
             e2_sp_2002,  // Juan Carlos I coin of 2002
             e2_sp_2005,  // Juan Carlos I coin of 2005
             c50_it, 
             c20_fr, 
             c1_pt;
    EuroCoinCollection collection;
    
    
    @Before
    public void setUp() {
        collection = new EuroCoinCollection();
        
        // THIS COINS MUST BE PROPERLY CREATED IN ORDER TO THE TEST TO WORK CORRECTLY
        e1_sp1 = new EuroCoin(Color.ORO_PLATA,Paises.SPAIN,CoinValue.UN_EURO,"Juan Carlos I",1998);
        e1_sp2 = new EuroCoin(Color.ORO_PLATA,Paises.SPAIN,CoinValue.UN_EURO,"Felipe VI",2018);
        e2_sp_2005  = new EuroCoin(Color.ORO_PLATA,Paises.SPAIN,CoinValue.DOS_EUROS,"Juan Carlos I",2005);
        e2_sp_2002  = new EuroCoin(Color.ORO_PLATA,Paises.SPAIN,CoinValue.DOS_EUROS,"Juan Carlos I",2002);
        c50_it = new EuroCoin(Color.ORO,Paises.ITALY,CoinValue.CINCUENTA_CENTIMOS,"",2002);
        c20_fr = new EuroCoin(Color.ORO,Paises.FRANCE,CoinValue.VEINTE_CENTIMOS,"",2002);
        c1_pt = new EuroCoin(Color.BRONCE,Paises.PORTUGAL,CoinValue.UN_CENTIMO,"",2002);
       
        assertTrue(collection.insertCoin(e1_sp1));
        assertTrue(collection.insertCoin(e1_sp2));
        assertTrue(collection.insertCoin(e2_sp_2002));
        assertFalse(collection.insertCoin(e2_sp_2005)); // Not inserted
        assertTrue(collection.insertCoin(c50_it));
        assertTrue(collection.insertCoin(c20_fr));
        assertFalse(collection.insertCoin(c50_it)); // Not inserted        
    }
    
    @Test
    public void testNumCoins() {       
        assertEquals(5, collection.numCoins());
    }

    @Test
    public void testHasCoin() {
        assertTrue(collection.hasCoin(e1_sp1));
        assertTrue(collection.hasCoin(e2_sp_2005));
        assertFalse(collection.hasCoin(c1_pt));
    }

    @Test
    public void testCollectionValue() {
        assertEquals(470, collection.value());
    }    
    
    @Test
    public void testRemoveCoin() {
        collection.removeCoin(c50_it);
        assertEquals(4, collection.numCoins());
        assertEquals(420, collection.value());
        
        collection.removeCoin(e2_sp_2005); // removes the 2002 coin
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
        
        collection.removeCoin(c1_pt); // No coin removed
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
    }    
}
