/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

/**
 *
 * @author Jose
 */
public class AccionLocal {

    String simbolo;
    double cierre;
    double maximo;
    double minimo;
    int volumen;
    
    public AccionLocal(){
        
    }


    @Override
    public String toString() {
        return "Accion{" + "simbolo=" + this.getSimbolo() + ", cierre=" + this.getCierre() + ", maximo=" + this.getMaximo() + ", minimo=" + this.getMinimo() + ", volumen=" + this.getVolumen() + '}';
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getCierre() {
        return cierre;
    }

    public void setCierre(double cierre) {
        this.cierre = cierre;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    
    

}
