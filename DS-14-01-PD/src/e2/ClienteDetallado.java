/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jose
 */
public class ClienteDetallado implements Observer {

    private List<String> listaDatos;
    private AccionLocal accionLocal = new AccionLocal();

    public ClienteDetallado(AccionMercado accion, List<String> listaDatos) {
        this.obtenInformacionAccionMercado(accion);
        this.listaDatos = listaDatos;
    }

    @Override
    public void update(Observable o, Object arg) {
        AccionMercado a = (AccionMercado) o;
        String datos = (String) arg;
        if (listaDatos.contains(datos)) {
            this.obtenInformacionAccionMercado(a);
            return;
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
