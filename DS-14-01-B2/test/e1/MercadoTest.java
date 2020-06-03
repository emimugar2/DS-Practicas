package e1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class MercadoTest {
    
    private Cliente c1, c2, c3, c4;
    private Reponedor r1, r2, r4;
    private Dependiente d1, d2, d3, d4;
    private List<Cliente> listaClientes;
    private List<Dependiente> listaDependientes;
    private List<Reponedor> listaReponedores;
    
    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @org.junit.Before
    public void setUp() throws Exception {
        //Cliente(String nombre, String apellidos, String dni, String direccion, String telefono, int codigo, int compras)
        c1 = new Cliente("Cliente1", "apellidos", "12123423E", "direccion1", "tel2341234", 1, 0);
        c2 = new Cliente("Cliente2", "apellidos", "12223423E", "direccion1", "tel2341234", 2, 0);
        c3 = new Cliente("Cliente3", "apellidos", "12723423E", "direccion1", "tel2341234", 3, 0);
        c4 = new Cliente("Cliente4", "apellidos", "12423423E", "direccion1", "tel2341234", 4, 0);
        //Dependiente(String nombre, String apellidos, String dni, String direccion, String telefono, String nss, double salario, Empleado.Turno turno, String especialidad)
        d1 = new Dependiente("Dependiente1", "apellidos", "12323423E", "direccion1", "tel2341234", "nss245345", 800, Empleado.Turno.MAÑANA, "carnicero");
        d2 = new Dependiente("Dependiente2", "apellidos", "12323523E", "direccion1", "tel2341234", "nss245345", 800, Empleado.Turno.TARDE, "pescadero");
        d3 = new Dependiente("Dependiente3", "apellidos", "12323623E", "direccion1", "tel2341234", "nss245345", 800, Empleado.Turno.NOCHE, "licorero");
        d4 = new Dependiente("Dependiente4", "apellidos", "12323723E", "direccion1", "tel2341234", "nss245345", 800, Empleado.Turno.MAÑANA, "carnicero");
        //Reponedor( String nombre, String apellidos, String dni, String direccion, String telefono, String nss, double salario, Turno turno,String empresa)
        r1 = new Reponedor("Reponedor1", "apellidos", "12323423A", "direccion1", "tel2341234", "nss245345", 600, Empleado.Turno.MAÑANA, "reponedoresPepe");
        r2 = new Reponedor("Reponedor2", "apellidos", "12323423B", "direccion1", "tel2341234", "nss245345", 600, Empleado.Turno.TARDE, "reponedoresPepe");
        //r3 = new Reponedor("Reponedor3","apellidos","12323423E","direccion1","tel2341234","nss245345",8,Empleado.Turno.NOCHE,"reponedoresPepe");
        r4 = new Reponedor("Reponedor4", "apellidos", "12323423C", "direccion1", "tel2341234", "nss245345", 600, Empleado.Turno.MAÑANA, "reponedoresPepe");
        
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        listaClientes.add(c4);
        
        listaDependientes = new ArrayList<Dependiente>();
        listaDependientes.add(d1);
        listaDependientes.add(d2);
        listaDependientes.add(d3);
        listaDependientes.add(d4);
        
        listaReponedores = new ArrayList<Reponedor>();
        listaReponedores.add(r1);
        listaReponedores.add(r2);
        //listaReponedores.add(r3);
        listaReponedores.add(r4);
    }
    
    @org.junit.After
    public void tearDown() throws Exception {
    }

    /**
     * Test agregar un cliente, dependiente o reponedor sin los campos
     * obligatorios (nombre,apellidos y dni)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testcrearPersonaSinArgumentosObligatorios() {
        Cliente c5 = new Cliente(null, null, null, "direccion1", "tel2341234", 5, 0);
    }

    /**
     * Test comprobar descuento aplicable cada 100 compras
     */
    @Test
    public void testAplicarDescuentoCliente() {
        c1.setComprasRealizadas(100);
        c2.setComprasRealizadas(99);
        c3.setComprasRealizadas(200);
        c4.setComprasRealizadas(0);
        
        assertTrue(0.01 == c1.getDescuento());
        assertTrue(0 == c2.getDescuento());
        assertTrue(0.02 == c3.getDescuento());
        assertTrue(0 == c4.getDescuento());
    }

    /**
     * Test comprobar el extra del turno de noche en los dependientes
     */
    @Test
    public void testTurnoDeNocheReponedores() {
        assertTrue(800 == d1.getSalario());
        assertTrue(800 == d2.getSalario());
        assertTrue(950 == d3.getSalario());
    }

    /**
     * Test comprobar que no podemos meter en el sistema un reponedor con el
     * turno de noche
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReponedorConTurnoDeNoche() {
        Reponedor r = new Reponedor("Reponedor3", "apellidos", "12323423E", "direccion1", "tel2341234", "nss245345", 8, Empleado.Turno.NOCHE, "reponedoresPepe");
    }

    /**
     * Test agregar un cliente al mercado satisfactioriamente
     */
    @Test
    public void testAgregarCliente() {
        Mercado m = new Mercado();
        m.agregarCliente(c1);
        assertEquals(1, m.personasMercado().size());
        assertEquals(c1, m.personasMercado().get(0));
        assertEquals(c1.toString(), m.personasMercado().get(0).toString());
        m.agregarCliente(c2);
        assertEquals(2, m.personasMercado().size());
        assertEquals(c2, m.personasMercado().get(1));
    }

    /**
     * Test agregar un empleado que ya existe
     */
    @Test
    public void testAgregarClienteExistente() {
        Mercado m = new Mercado();
        m.agregarCliente(c1);
        m.agregarCliente(c1);
        
        assertEquals(1, m.personasMercado().size());
    }

    /**
     * Test agregar un Empleado al mercado satisfactioriamente que puede ser o
     * un reponedor o un dependiente
     */
    @Test
    public void testAgregarEmpleados() {
        Mercado m = new Mercado();
        m.agregarEmpleado(r1);        
        assertEquals(1, m.personasMercado().size());
        assertEquals(r1, m.personasMercado().get(0));
        assertEquals(r1.toString(), m.personasMercado().get(0).toString());
        m.agregarEmpleado(d1);
        assertEquals(2, m.personasMercado().size());
        assertEquals(d1, m.personasMercado().get(1));
        assertEquals(d1.toString(), m.personasMercado().get(1).toString());
    }

    /**
     * Test agregar un empleado que ya existe
     */
    @Test
    public void testAgregarEmpleadoExistente() {
        Mercado m = new Mercado();
        m.agregarEmpleado(r1);
        m.agregarEmpleado(r1);
        
        assertEquals(1, m.personasMercado().size());
    }

    /**
     * Test agregar clientes y empleados al mercado
     */
    @Test
    public void testAgregarClientesEmpleados() {
        Mercado m = new Mercado();
        m.agregarCliente(c1);
        m.agregarEmpleado(r1);
        m.agregarEmpleado(d1);
        m.agregarCliente(c2);
        m.agregarCliente(c1);
        
        assertEquals(4, m.personasMercado().size());
    }

    /**
     * Test agregar una lista de clientes
     */
    @Test
    public void testAgregarListaClientes() {
        Mercado m = new Mercado();
        m.agregarClientes(listaClientes);
        
        assertEquals(listaClientes.size(), m.personasMercado().size());
    }

    /**
     * Test agregar una lista de empleados
     */
    @Test
    public void testAgregarListaEmpleados() {
        Mercado m = new Mercado();
        
        m.agregarEmpleados(listaReponedores);
        m.agregarEmpleados(listaDependientes);
        
        assertEquals(listaClientes.size() + listaReponedores.size(), m.personasMercado().size());
    }

    /**
     * Test salariosMercado
     */
    @Test
    public void testSalariosMercado() {
        Mercado m = new Mercado();
        
        m.agregarEmpleados(listaReponedores);
        assertTrue(1800 == m.salariosMercado());
        
        m.agregarEmpleados(listaDependientes);
        assertTrue(5150 == m.salariosMercado());
        
        m.agregarClientes(listaClientes);
        assertTrue(5150 == m.salariosMercado());
        
    }

//    /**
//     * Test of agregarCliente method, of class Mercado.
//     */
//    @org.junit.Test
//    public void testAgregarCliente() {
//        System.out.println("agregarCliente");
//        Mercado mercado = new Mercado();
//        // TODO review the generated test code and remove the default call to fail.
//        System.out.println("cliente: " + c1.toString());
//        mercado.agregarCliente(c1);
//        assertEquals(mercado.personasMercado().get(0), c1);
//    }
//
//    /**
//     * Test of agregarEmpleado method, of class Mercado.
//     */
//    @org.junit.Test
//    public void testAgregarEmpleado() {
//        System.out.println("agregarEmpleado");
//        Empleado e = null;
//        Mercado instance = new Mercado();
//        instance.agregarEmpleado(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregarClientes method, of class Mercado.
//     */
//    @org.junit.Test
//    public void testAgregarClientes() {
//        System.out.println("agregarClientes");
//        List<Cliente> lista = null;
//        Mercado instance = new Mercado();
//        instance.agregarClientes(lista);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregarEmpleados method, of class Mercado.
//     */
//    @org.junit.Test
//    public void testAgregarEmpleados() {
//        System.out.println("agregarEmpleados");
//        List<Empleado> lista = null;
//        Mercado instance = new Mercado();
//        instance.agregarEmpleados(lista);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of salariosMercado method, of class Mercado.
//     */
//    @org.junit.Test
//    public void testSalariosMercado() {
//        System.out.println("salariosMercado");
//        List<Persona> mercado = null;
//        Mercado instance = new Mercado();
//        double expResult = 0.0;
//        double result = instance.salariosMercado(mercado);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of personasMercado method, of class Mercado.
//     */
//    @org.junit.Test
//    public void testPersonasMercado() {
//        System.out.println("personasMercado");
//        Mercado instance = new Mercado();
//        List<Persona> expResult = null;
//        List<Persona> result = instance.personasMercado();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
