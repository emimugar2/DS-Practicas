package e1;

import java.util.Objects;

public class Empleado extends Persona {

    private String nss;
    private double salario;
    private Turno turno;

    public Empleado(String nombre, String apellidos, String dni, String direccion, String telefono, String nss, double salario, Turno turno) {
        super(nombre, apellidos, dni, direccion, telefono);
        this.setNss(nss);
        this.setSalario(salario);
        this.setTurno(turno);
    }

    public enum Turno {
        MAÑANA,
        TARDE,
        NOCHE;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}
