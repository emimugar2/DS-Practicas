/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jose
 */
public class AccionTest {

    private Observer c1;
    private Observer cd1;
    private Observer c_otro;
    private List<String> listaDatos;
    private List<String> listaDatos2;
    private List<AccionMercado> listaAcciones;
    private Observable a1,a2,a3;

    static final String VOLUMEN = "volumen";
    static final String MAXIMO = "maximo";
    static final String MINIMO = "minimo";
    static final String CIERRE = "cierre";

    public AccionTest() {
        this.a1 = new AccionMercado("ABB", 7.8, 8.4, 2.3, 123123123);
        this.a2 = new AccionMercado("ORO", 6.4, 7.9, 1.2, 34456);
        this.a3 = new AccionMercado("BITCOIN", 6.7, 9.5, 4.6, 4553);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        listaDatos = new ArrayList<String>();
        listaDatos2 = new ArrayList<String>();
        listaAcciones = new ArrayList<AccionMercado>();
        
        listaDatos.add(CIERRE);
        listaDatos.add(VOLUMEN);
        listaDatos2.add(MAXIMO);
        listaDatos2.add(MINIMO);
        listaAcciones.add((AccionMercado)a1);
        listaAcciones.add((AccionMercado)a2);
        listaAcciones.add((AccionMercado)a3);
        

    }

    @After
    public void tearDown() {
    }

    @Test
    public void setCierreTest() {
        AccionMercado a_m1 = (AccionMercado) a1;
        c1 = new ClienteSencillo(a_m1, VOLUMEN);

        a1.addObserver(c1);
        AccionMercado a = (AccionMercado) a1;
        ClienteSencillo c = (ClienteSencillo) c1;
        a.setCierre(7);

        assertNotEquals(a.toString(), c.getAccion().toString());

    }

    /**
     * Probamos a actualizar la accion a1 y ver que el cliente actualiza la
     * informacion porque solo mira si cambia el volumen
     */
    @Test
    public void setVolumenTest() {
        AccionMercado a_m1 = (AccionMercado) a1;
        c1 = new ClienteSencillo(a_m1, VOLUMEN);
        
        a1.addObserver(c1);
        AccionMercado a = (AccionMercado) a1;
        ClienteSencillo c = (ClienteSencillo) c1;
        a.setVolumen(1000);

        assertEquals(a.toString(), c.getAccion().toString());
    }

    /**
     * Probamos a actualizar la accion a1, el volumen y el cierre y ver que el
     * cliente actualiza la informacion porque solo mira si cambia el volumen
     */
    @Test
    public void setCierreVolumenTest() {
        AccionMercado a_m1 = (AccionMercado) a1;
        c1 = new ClienteSencillo(a_m1, VOLUMEN);
        
        a1.addObserver(c1);
        AccionMercado a = (AccionMercado) a1;
        ClienteSencillo c = (ClienteSencillo) c1;
        a.setCierre(8.9);
        a.setVolumen(1000);

        assertEquals(a.toString(), c.getAccion().toString());
    }

    /**
     * Si probamos el test anterior en orde contrario el cierre no quedaria
     * actualizado en el cliente
     */
    @Test
    public void setVolumenCierreTest() {
        AccionMercado a_m1 = (AccionMercado) a1;
        c1 = new ClienteSencillo(a_m1, VOLUMEN);
        
        a1.addObserver(c1);
        AccionMercado a = (AccionMercado) a1;
        ClienteSencillo c = (ClienteSencillo) c1;
        a.setVolumen(1000);
        a.setCierre(8.9);

        assertNotEquals(a.toString(), c.getAccion().toString());
    }

    /**
     * Probamos el clienteDetallado el cual tiene una lista de datos que quiere
     * actualizar, de manera que si actualizamos alguno de los que tiene, la
     * accion se actualizara localmente
     */
    @Test
    public void setCierreVolumenTestDetallado() {
        AccionMercado a_m1 = (AccionMercado) a1;
        cd1 = new ClienteDetallado(a_m1, listaDatos);

        a1.addObserver(cd1);
        AccionMercado a = (AccionMercado) a1;
        ClienteDetallado cd = (ClienteDetallado) cd1;
        a.setCierre(7);
        a.setVolumen(200);

        assertEquals(a.toString(), cd.getAccion().toString());

    }

    /**
     * Probamos el clienteDetallado el cual tiene una lista de datos que quiere
     * actualizar, de manera que si actualizamos alguno de los que tiene, la
     * accion se actualizara localmente
     */
    @Test
    public void setMinimoMaximoTestDetallado() {
        AccionMercado a_m1 = (AccionMercado) a1;
        cd1 = new ClienteDetallado(a_m1, listaDatos);

        a1.addObserver(cd1);
        AccionMercado a = (AccionMercado) a1;
        ClienteDetallado cd = (ClienteDetallado) cd1;
        a.setMaximo(7);
        a.setMinimo(200);

        assertNotEquals(a.toString(), cd.getAccion().toString());

    }
    
    
    /**
     * Probamos ahora otros tipos de clientes que pueden interesarse por 
     * mas de una accion
     */
    @Test
    public void testOtrosClientes() {
        c_otro = new OtrosClientes(listaAcciones, listaDatos);

        a1.addObserver(c_otro);
        OtrosClientes c_Otro = (OtrosClientes) c_otro;
        listaAcciones.get(0).setCierre(5);
        listaAcciones.get(1).setMaximo(8.6);
        listaAcciones.get(2).setMinimo(1.2);
                
        assertEquals(listaAcciones.get(0).toString(), c_Otro.getAccion(0).toString());
        assertNotEquals(listaAcciones.get(1).toString(), c_Otro.getAccion(1).toString());
        assertNotEquals(listaAcciones.get(2).toString(), c_Otro.getAccion(2).toString());

    }

}
