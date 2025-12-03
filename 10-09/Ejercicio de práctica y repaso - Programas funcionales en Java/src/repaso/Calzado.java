package repaso;

import java.util.ArrayList;

public abstract class Calzado {
    private int id;
    private int talle;
    private double precioBase;

    public Calzado(int id, int talle, double precioBase) {
        this.id = id;
        this.talle = talle;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioVenta();

    public double getPrecioBase() {
        return precioBase;
    }

    public int getTalle() {
        return talle;
    }

    public String getTipo() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString() {
        return String.format("[ID: %d, Talle: %d, Tipo: %s, Base: $%.2f, Venta: $%.2f]",
                id, talle, getTipo(), precioBase, calcularPrecioVenta());
    }
}