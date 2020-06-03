/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class Mercado {

    private List<Persona> mercado = new ArrayList<>();

    public void agregarCliente(Cliente c) {
        if (!this.mercado.contains(c)) {
            this.mercado.add(c);
        }

    }

    public void agregarEmpleado(Empleado e) {
        if (!this.mercado.contains(e)) {
            this.mercado.add(e);
        }
    }

    public void agregarClientes(List<Cliente> lista) {
        for (Cliente c : lista) {
            this.agregarCliente(c);
        }
    }

    public void agregarEmpleados(List<? extends Empleado> lista) {
        for (Empleado e : lista) {
            this.agregarEmpleado(e);
        }
    }

    public double salariosMercado() {
        double salarioTotal = 0;
        for (Persona p : mercado) {
            if (p instanceof Empleado) {
                salarioTotal += ((Empleado) p).getSalario();
            }
        }

        return salarioTotal;
    }

    public List<Persona> personasMercado() {
        return mercado;
    }

}
