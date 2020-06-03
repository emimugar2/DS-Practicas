package e4;

import java.util.ArrayList;

public class EuroCoinCollection {

    ArrayList<EuroCoin> coleccion = new ArrayList<>();
        
    public boolean insertCoin(EuroCoin coin) {
        for (EuroCoin elemento : coleccion){
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
        for (EuroCoin elemento : coleccion){
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

}
