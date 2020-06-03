package e1;


public abstract class Persona {

    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;

    public Persona(String nombre, String apellidos, String dni, String direccion, String telefono) {
        if (nombre != null && apellidos != null && dni != null) {
            this.setNombre(nombre);
            this.setApellidos(apellidos);
            this.setDni(dni);
            this.setDireccion(direccion);
            this.setTelefono(telefono);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return (this.getDni().equals(other.getDni()));
    }

}
