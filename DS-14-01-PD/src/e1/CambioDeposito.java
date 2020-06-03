package e1;

import java.util.ArrayList;
import java.util.List;

public class CambioDeposito extends Cambio {

    private static CambioDeposito cambiodeposito;

    public static CambioDeposito getInstance() {
        if (cambiodeposito == null) {
            cambiodeposito = new CambioDeposito();
        }
        return cambiodeposito;
    }

    private CambioDeposito() {

    }

    @Override
    public EuroCoin[] devolverCambio() {
        List<EuroCoin> monedas = new ArrayList<>();
        int cambioNecesario = super.importe - super.gasto;
        int cambioActual = 0;

        //Monedas iteradas de mayor a menor valor
        for (EuroCoin moneda : EuroCoin.values()) {
            while (cambioActual + moneda.getValue() <= cambioNecesario) {
                monedas.add(moneda);
                cambioActual += moneda.getValue();
            }
        }
        super.resetear();
        return monedas.toArray(new EuroCoin[0]);
    }

}
