package e2;

import java.util.Observable;
import java.util.Observer;

public class ClienteSencillo implements Observer {

    private String info;
    private AccionLocal accionLocal = new AccionLocal();

    public ClienteSencillo(AccionMercado accion, String info) {
        this.obtenInformacionAccionMercado(accion);
        this.info = info;
    }

    @Override
    public void update(Observable o, Object arg) {
        AccionMercado a = (AccionMercado) o;
        String datos = (String) arg;
        if (datos.equals(info)) {
            this.obtenInformacionAccionMercado(a);
        }
    }

    private void obtenInformacionAccionMercado(AccionMercado a) {
        this.accionLocal.setSimbolo(a.getSimbolo());
        this.accionLocal.setCierre(a.getCierre());
        this.accionLocal.setMaximo(a.getMaximo());
        this.accionLocal.setMinimo(a.getMinimo());
        this.accionLocal.setVolumen(a.getVolumen());
    }

    public AccionLocal getAccion() {
        return this.accionLocal;
    }

}
