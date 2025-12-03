package repaso;

public class Calzado {
    protected String marca;
    protected int talle;
    protected double precio;

    public Calzado(String marca, int talle, double precio) {
        this.marca = marca;
        this.talle = talle;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }
}