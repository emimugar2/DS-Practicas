package e2_e3;

import java.util.Objects;

public class EuroCoin implements Comparable<EuroCoin>{
    private Color color;
    private Paises pais;
    private CoinValue value;
    private final String diseño;
    private final int añoAcuñacion;

    public EuroCoin(Color color, Paises pais, CoinValue value, String diseño, int añoAcuñacion) {
        this.color = color;
        this.pais = pais;
        this.value = value;
        this.diseño = diseño;
        this.añoAcuñacion = añoAcuñacion;
    }

    public Color getColor() {
        return color;
    }

    public Paises getPais() {
        return pais;
    }

    public CoinValue getValue() {
        return value;
    }

    public String getDiseño() {
        return diseño;
    }

    public int getAñoAcuñacion() {
        return añoAcuñacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public void setValue(CoinValue value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EuroCoin other = (EuroCoin) obj;
        if (!Objects.equals(this.diseño, other.diseño)) {
            return false;
        }
        if (this.pais != other.pais) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(EuroCoin o) {
        int comparador = 0;
        
        if(this.getValue().getValue() > o.getValue().getValue()){
            comparador = -1;
        }else if(this.getValue().getValue() < o.getValue().getValue()){
            comparador = 1;
        }else if(this.getPais().compareTo(o.getPais()) <= -1){
            comparador = this.getPais().compareTo(o.getPais());
        }else if (this.getDiseño().compareToIgnoreCase(o.getDiseño()) <= -1){
            comparador = this.getDiseño().compareToIgnoreCase(o.getDiseño());
        }
        
        return comparador;
    }
    
    
 
    
    
}
