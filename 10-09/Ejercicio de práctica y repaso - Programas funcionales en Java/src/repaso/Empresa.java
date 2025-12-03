package repaso;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Sucursal> sucursales;
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal sucursal) {
        this.sucursales.add(sucursal);
    }

    public double calcularCapitalTotal() {
        double capitalTotal = 0;
        for (Sucursal sucursal : sucursales) {
            capitalTotal += sucursal.calcularCapital();
        }
        return capitalTotal;
    }

    public int contarLocalesRefinados() {
        int count = 0;
        for (Sucursal sucursal : sucursales) {
            if (sucursal.esLocalRefinado()) {
                count++;
            }
        }
        return count;
    }
}