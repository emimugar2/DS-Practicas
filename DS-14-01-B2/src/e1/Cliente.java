package e1;

public class Cliente extends Persona {

    private int codigoCliente;
    private int comprasRealizadas;
    private double descuento;

    public Cliente(String nombre, String apellidos, String dni, String direccion, String telefono, int codigo, int compras) {
        super(nombre, apellidos, dni, direccion, telefono);
        this.setCodigoCliente(codigo);
        this.setComprasRealizadas(compras);
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getComprasRealizadas() {
        return comprasRealizadas;
    }

    public void setComprasRealizadas(int comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
        this.descuento = this.comprasRealizadas / 100;
        this.descuento = this.descuento / 100;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return "Nombre: " + super.getNombre() + " Apellidos: " + super.getApellidos()
                + " DNI: " + super.getDni() + " Direccion: " + super.getDireccion()
                + " Telefono: " + super.getTelefono()
                + " Codigo:" + this.getCodigoCliente()
                + " Compras:" + this.getComprasRealizadas()
                + " Descuento:" + this.getDescuento();
    }

}
