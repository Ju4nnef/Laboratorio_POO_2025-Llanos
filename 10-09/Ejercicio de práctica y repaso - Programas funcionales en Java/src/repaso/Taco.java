package repaso;

public class Taco extends Calzado {
    public Taco(int id, int talle, double precioBase) {
        super(id, talle, precioBase);
    }

    @Override
    public double calcularPrecioVenta() {
        return getPrecioBase() * 1.30;
    }
}