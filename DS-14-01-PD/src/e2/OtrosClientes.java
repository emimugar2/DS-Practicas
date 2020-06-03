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
public class OtrosClientes implements Observer {

    private List<String> listaDatos;
    private AccionLocal accionLocal = new AccionLocal();
    private List<AccionLocal> listaAccionesLocales = new ArrayList<AccionLocal>();

    public OtrosClientes(List<AccionMercado> listaAccionesMercado, List<String> listaDatos) {
        this.listaDatos = listaDatos;
        this.obtenerInformacionAccionesMercado(listaAccionesMercado);
    }

    @Override
    public void update(Observable o, Object arg) {
        AccionMercado a = (AccionMercado) o;
        AccionLocal a_l = new AccionLocal();
        this.obtenInformacionAccionMercado(a, a_l);
        for (AccionLocal aL : listaAccionesLocales) {
            if (aL.getSimbolo().equals(a.getSimbolo())) {
                System.out.println("Se encontro la accion");
                String datos = (String) arg;
                if (listaDatos.contains(datos)) {
                    System.out.println("Se encontro los datos");

                    this.obtenInformacionAccionMercado(a);
                    return;
                }
            }
        }

    }

    public void obtenerInformacionAccionesMercado(List<AccionMercado> lista) {

        int n = 0;
        for (AccionMercado a : lista) {
            AccionLocal aux = new AccionLocal();
            this.obtenInformacionAccionMercado(a, aux);
            this.listaAccionesLocales.add(n, aux);
            n++;
        }
    }

    private void obtenInformacionAccionMercado(AccionMercado a, AccionLocal aux) {
        aux.setSimbolo(a.getSimbolo());
        aux.setCierre(a.getCierre());
        aux.setMaximo(a.getMaximo());
        aux.setMinimo(a.getMinimo());
        aux.setVolumen(a.getVolumen());
    }

    private void obtenInformacionAccionMercado(AccionMercado a) {
        
        for(AccionLocal aL : listaAccionesLocales){
            if (aL.getSimbolo().equals(a.getSimbolo())) {
                System.out.println("Se encontro en la lista local");
                aL.setSimbolo(a.getSimbolo());
                aL.setCierre(a.getCierre());
                aL.setMaximo(a.getMaximo());
                aL.setMinimo(a.getMinimo());
                aL.setVolumen(a.getVolumen());
            }
        }
    }

    public AccionLocal getAccion(int n) {
        return listaAccionesLocales.get(n);
    }
}
