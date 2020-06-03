package e1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private List<EuroCoin> moneda = new ArrayList<EuroCoin>();
    private Map<Producto, Integer> productos = new HashMap<>();
    private Cambio cambio;

    public VendingMachine() {
    }

    public void insertProduct(String product, int price) {
        Producto p = new Producto(product, price);
        if (productos.get(p) == null) {
            productos.put(p, 1);
        } else {
            productos.replace(p, productos.get(p) + 1);
        }
    }

    public void insertCoin(EuroCoin e) {
        moneda.add(e);
    }

    public List<EuroCoin> cancel() {
        List<EuroCoin> monedaDevolver = new ArrayList<EuroCoin>();
        for (EuroCoin m : this.moneda) {
            monedaDevolver.add(m);
        }
        this.moneda = new ArrayList<EuroCoin>();
        return monedaDevolver;
    }
    
    public List<EuroCoin> buy(String product){
        Producto productoCompra = null;
        for(Producto p: this.productos.keySet()){
            if(p.getNombre().equals(product)){
                productoCompra = p;
                break;
            }
        }
        if(productoCompra == null){
            return null;
        }
        return null;
    }

}
