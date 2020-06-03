package e4;

import java.util.Objects;

public class EuroCoin {
    Color color;
    Paises pais;
    CoinValue value;
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
    
    
    
    
    
}
