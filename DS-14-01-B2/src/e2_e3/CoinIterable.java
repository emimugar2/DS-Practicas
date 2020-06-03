package e2_e3;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CoinIterable implements Iterable<EuroCoin> {

    protected transient int modCount = 0;
    private ArrayList<EuroCoin> lista = new ArrayList<>();

    public ArrayList<EuroCoin> getLista() {
        return lista;
    }

    public void setLista(ArrayList<EuroCoin> lista) {
        this.lista = lista;
    }

    @Override
    public Iterator<EuroCoin> iterator() {
        return new CoinIterator<>();
    }

    public List recorrerMonedas(Paises pais) {
        if (pais == null) {
            return lista;
        }
        Iterator itr = iterator();
        List<EuroCoin> listaPaises = new ArrayList<>();

        while (itr.hasNext()) {
            EuroCoin moneda = (EuroCoin) itr.next();
            if (moneda.getPais().equals(pais)) {
                listaPaises.add(moneda);
                System.out.println(moneda.getPais());

            }
        }
        return listaPaises;
    }

    private class CoinIterator<EuroCoin> implements Iterator<EuroCoin> {

        private ArrayList<EuroCoin> listaFailFast = null;
        private int cursor = 0;

        public CoinIterator() {
        }

        @Override
        public boolean hasNext() {
            return (lista.size() > cursor);
        }

        @Override
        public EuroCoin next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (cursor == 0) {
                listaFailFast = (ArrayList<EuroCoin>) lista.clone();
            }
            checkForComodification();
            EuroCoin elem = (EuroCoin) lista.get(cursor);
            cursor++;
            return elem;
        }

        @Override
        public void remove() {

            if (cursor == 0) {
                throw new IllegalStateException("¡Se debe llamar a la función next() antes de eliminar un elemento!");
            }
            checkForComodification();
            lista.remove(--cursor);
            listaFailFast = (ArrayList<EuroCoin>) lista.clone();

        }

        final void checkForComodification() {
            if (!lista.equals(listaFailFast)) {       
                throw new ConcurrentModificationException();
            }
        }

    }

}
