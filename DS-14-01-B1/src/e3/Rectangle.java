package e3;

public class Rectangle {

    private int base;
    private int height;

    public Rectangle(int base, int height) {
        if ((base < 0) || (height < 0)) {
            throw new IllegalArgumentException("Medida negativa");
        } else {
            this.base = base;
            this.height = height;
        }
    }

    public Rectangle(Rectangle r) {
        this.base = r.base;
        this.height = r.height;
    }

    public int getBase() {
        return this.base;
    }

    public int getHeight() {
        return this.height;
    }

    public void setBase(int base) {
        if (base < 0) {
            throw new IllegalArgumentException("La base no puede ser negativa");
        } else {
            this.base = base;
        }

    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new IllegalArgumentException("La altura no puede ser negativa");
        } else {
            this.height = height;
        }

    }

    public boolean isSquare() {
        return this.base == this.height;
    }

    public int area() {
        return this.base * this.height;
    }

    public int perimeter() {
        return 2*this.base + 2* this.height;
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(this.base,2) + Math.pow(this.height, 2));
    }

    public void turn() {
        int aux = this.base;
        this.base = this.height;
        this.height = aux;
    }

    public void putHorizontal() {
        if(this.base < this.height){
            this.turn();
        }
    }

    public void putVertical() {
        if(this.base > this.height){
            this.turn();
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Rectangle r = (Rectangle) obj;
        return ((this.base == r.base && this.height == r.height) || this.base == r.height && this.height == r.base);
    }
    
    @Override
    public int hashCode() {
        int hash = 17;
        
        this.putHorizontal();
        
        hash = 7 * hash + this.getBase();
        hash = 11 * hash + this.getHeight();
        
        return hash;
    }

}
