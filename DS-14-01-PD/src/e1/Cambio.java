package e1;

import java.util.ArrayList;
import java.util.List;

public abstract class Cambio {
	protected int gasto;
	protected int importe;
	protected final List<EuroCoin> introducidas = new ArrayList<>();
		
	public int getImporte(){
		return this.importe;
	}
	
	public void notificarGasto(int gasto){
		if (this.gasto + gasto > importe){
			throw new IllegalStateException("No se puede gastar más del importe introducido.");
		}
		this.gasto += gasto;
	}
	
	public EuroCoin[] cancelar(){
		if (gasto > 0)
			throw new IllegalStateException("Parte del importe ya ha sido gastado y no se puede devolver.");
		EuroCoin[] m = introducidas.toArray(new EuroCoin[0]);
		this.resetear();
		return m;
	}
	
	public void resetear(){
		this.gasto = 0;
		this.importe = 0;
		this.introducidas.clear();
	}
	
	public abstract EuroCoin[] devolverCambio();
}
