package e1;

import java.util.ArrayList;
import java.util.List;

public class CambioSimple extends Cambio {

    private static CambioSimple cambiosimple;

    public static CambioSimple getInstance() {
        if (cambiosimple == null) {
            cambiosimple = new CambioSimple();
        }
        return cambiosimple;
    }

    private CambioSimple() {

    }

    private int importe(List<EuroCoin> monedas) {
        int importe = 0;
        for (EuroCoin m : monedas) {
            importe += m.getValue();
        }
        return importe;
    }

    private List<List<EuroCoin>> combinarMonedas(int nmonedas, int maxmonedas,
            int primerIndice) {
        if (nmonedas == 1) {
            List<List<EuroCoin>> monedas = new ArrayList<>(maxmonedas);
            for (int i = primerIndice; i < super.introducidas.size(); i++) {
                List<EuroCoin> m = new ArrayList<>();
                m.add(super.introducidas.get(i));
                monedas.add(m);
            }

            return monedas;
        } else {
            List<List<EuroCoin>> monedas = new ArrayList<>();
            for (int i = primerIndice; i < super.introducidas.size(); i++) {
                EuroCoin primeraMoneda = super.introducidas.get(i);
                for (List<EuroCoin> m : combinarMonedas(nmonedas - 1,
                        maxmonedas, i + 1)) {
                    m.add(primeraMoneda);
                    monedas.add(m);
                }
            }
            return monedas;
        }
    }

    @Override
    public EuroCoin[] devolverCambio() {
        int cambio = super.importe - super.gasto;
        List<EuroCoin> monedasCambio = null;
        int cambioMax = 0;
        for (int i = 1; i <= super.introducidas.size(); i++) {
            for (List<EuroCoin> m : combinarMonedas(i, super.introducidas.size(), 0)) {
                int valorCambio = importe(m);
                if (valorCambio <= cambio && valorCambio > cambioMax) {
                    cambioMax = valorCambio;
                    monedasCambio = m;
                }

            }
        }

        super.resetear();
        if (monedasCambio == null) {
            return new EuroCoin[0];
        } else {
            return monedasCambio.toArray(new EuroCoin[0]);
        }
    }

}
