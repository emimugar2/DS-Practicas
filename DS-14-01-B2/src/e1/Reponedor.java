package e1;

import java.util.Objects;

public class Reponedor extends Empleado {

    String empresa;

    public Reponedor(String nombre, String apellidos, String dni, String direccion, String telefono, String nss, double salario, Turno turno, String empresa) {
        super(nombre, apellidos, dni, direccion, telefono, nss, salario, turno);

        this.setTurno(turno);

        this.setEmpresa(empresa);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public void setTurno(Turno turno) {
        if (turno == Empleado.Turno.NOCHE) {
            throw new IllegalArgumentException();
        } else {
            super.setTurno(turno);
        }
    }

    @Override
    public String toString() {
        return "nss: " + this.getNss() + " Nombre: " + this.getNombre()
                + " Apellidos: " + this.getApellidos() + " DNI: " + this.getDni()
                + " Dirección: " + this.getDireccion() + " Telefono: "
                + this.getTelefono() + " Turno: " + this.getTurno() + " Salario: "
                + this.getSalario() + " Empresa: " + this.getEmpresa();
    }

}
