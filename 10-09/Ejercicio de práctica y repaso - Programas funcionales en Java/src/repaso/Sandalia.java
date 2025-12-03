package repaso;

public class Sandalia extends Calzado {
    public Sandalia(int id, int talle, double precioBase) {
        super(id, talle, precioBase);
    }

    @Override
    public double calcularPrecioVenta() {
        return getPrecioBase(); 
    }
}