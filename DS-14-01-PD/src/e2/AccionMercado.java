package e2;

import java.util.Observable;


public class AccionMercado extends Observable{   
    private String simbolo;
    private double cierre;
    private double maximo;
    private double minimo;
    private int volumen;

    public AccionMercado(String simbolo, double cierre, double maximo, double minimo, int volumen) {
        this.setSimbolo(simbolo);
        this.setCierre(cierre);
        this.setMaximo(maximo);
        this.setMinimo(minimo);
        this.setVolumen(volumen);
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setCierre(double cierre) {
        this.cierre = cierre;
        this.setChanged();
        this.notifyObservers("cierre");
        
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
        this.setChanged();
        this.notifyObservers("maximo");
 
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
        this.setChanged();
        this.notifyObservers("minimo");
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
        this.setChanged();
        this.notifyObservers("volumen");
    }
    
    public String getSimbolo() {
        return simbolo;
    }

    public double getCierre() {
        return cierre;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getMinimo() {
        return minimo;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return "Accion{" + "simbolo=" + simbolo + ", cierre=" + cierre + ", maximo=" + maximo + ", minimo=" + minimo + ", volumen=" + volumen + '}';
    }
    
    
}
