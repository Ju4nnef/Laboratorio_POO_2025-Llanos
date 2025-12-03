package repaso;

public class Borcego extends Calzado {
    public Borcego(int id, int talle, double precioBase) {
        super(id, talle, precioBase);
    }

    @Override
    public double calcularPrecioVenta() {
        return getPrecioBase() * 1.20; 
    }
}