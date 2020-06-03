package e2_e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EuroCoinCollection {

    ArrayList<EuroCoin> coleccion = new ArrayList<>();

    public boolean insertCoin(EuroCoin coin) {
        for (EuroCoin elemento : coleccion) {
            if (elemento.equals(coin)) {
                return false;
            }
        }
        coleccion.add(coin);
        return true;
    }

    public boolean hasCoin(EuroCoin coin) {
        return coleccion.contains(coin);
    }

    public int value() {
        int aux = 0;
        for (EuroCoin elemento : coleccion) {
            aux = aux + elemento.getValue().getValue();
        }
        return aux;
    }

    public int numCoins() {
        return coleccion.size();
    }

    public void removeCoin(EuroCoin coin) {
        coleccion.remove(coin);
    }

    public void naturalOrd() {
        Collections.sort(coleccion);
    }

    public void especificaOrd() {
        Collections.sort(coleccion, paises_valor_año_ordenacion);
    }

    public ArrayList<EuroCoin> getColeccion() {
        return coleccion;
    }
    
    public static Comparator<EuroCoin> paises_valor_año_ordenacion = new Comparator<EuroCoin>() {
        @Override
        public int compare(EuroCoin e1, EuroCoin e2) {
            int comparador = 0;

            if (e1.getPais().compareTo(e2.getPais()) >= 1) {
                comparador = e1.getPais().compareTo(e2.getPais());
            } else if (e1.getPais().compareTo(e2.getPais()) <= -1) {
                comparador = e1.getPais().compareTo(e2.getPais());
            }
             else if (e1.getValue().getValue() > e2.getValue().getValue()) {
                comparador = -1;
            } else if (e1.getValue().getValue() < e2.getValue().getValue()) {
                comparador = 1;
            } else if(e1.getAñoAcuñacion() < e2.getAñoAcuñacion()){
                comparador = -1;
            } else if (e1.getAñoAcuñacion() > e2.getAñoAcuñacion()){
                comparador = 1;
            }

            return comparador;
        }
    };
    
    
    
    

}
