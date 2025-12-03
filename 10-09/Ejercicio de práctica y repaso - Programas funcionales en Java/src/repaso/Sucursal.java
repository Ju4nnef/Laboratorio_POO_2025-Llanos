package repaso;

import java.util.ArrayList;

public class Sucursal {
    private String nombre;
    private double alquilerMensual;
    private ArrayList<Calzado> calzados; 
    private static final double PRECIO_BARATO = 15000; 

    public Sucursal(String nombre, double alquilerMensual) {
        this.nombre = nombre;
        this.alquilerMensual = alquilerMensual;
        this.calzados = new ArrayList<>();
    }

    public void agregarCalzado(Calzado calzado) {
        this.calzados.add(calzado);
    }
    
    public double calcularCapital() {
        double capitalTotalCalzado = 0;
        for (Calzado calzado : calzados) {
            capitalTotalCalzado += calzado.calcularPrecioVenta(); 
        }
        return capitalTotalCalzado - alquilerMensual;
    }

    public ArrayList<Calzado> getCalzadosEnLiquidacion() {
        ArrayList<Calzado> enLiquidacion = new ArrayList<>();
        for (Calzado calzado : calzados) {
            boolean porPrecio = calzado.getPrecioBase() < PRECIO_BARATO;
            boolean porBorcegoTalle = (calzado instanceof Borcego) && calzado.getTalle() >= 40; 
            
            if (porPrecio || porBorcegoTalle) {
                enLiquidacion.add(calzado);
            }
        }
        return enLiquidacion;
    }
    

    public boolean esLocalRefinado() {
        for (Calzado calzado : calzados) {
            if (calzado.getPrecioBase() < PRECIO_BARATO) {
                return false; 
            }
        }
        return true; 
    }

    public String getNombre() {
        return nombre;
    }
}