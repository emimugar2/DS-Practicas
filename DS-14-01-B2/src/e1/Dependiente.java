package e1;

public class Dependiente extends Empleado {

    private String especialidad;

    public Dependiente(String nombre, String apellidos, String dni, String direccion, String telefono, String nss, double salario, Empleado.Turno turno, String especialidad) {
        super(nombre, apellidos, dni, direccion, telefono, nss, salario, turno);
        this.setEspecialidad(especialidad);
        this.setSalario();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setSalario() {
        double sal = super.getSalario();
        if (this.getTurno() == Empleado.Turno.NOCHE) {
            sal += 150;
        }
        super.setSalario(sal);
    }
    
    

    @Override
    public String toString() {
        return "nss: " + this.getNss() + " Nombre: " + this.getNombre()
                + " Apellidos: " + this.getApellidos() + " DNI: " + this.getDni()
                + " Dirección: " + this.getDireccion() + " Telefono: " + this.getTelefono()
                + " Turno: " + this.getTurno() + " Salario: " + this.getSalario()
                + " Especialidad: " + this.getEspecialidad();
    }
}
