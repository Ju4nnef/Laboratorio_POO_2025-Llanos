package modelo_examen;

import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private String nombre;
    private double costoFijoMantenimiento;
    private List<PlanDeEntrenamiento> planes; 

    public Gimnasio(String nombre, double costoFijoMantenimiento) {
        this.nombre = nombre;
        this.costoFijoMantenimiento = costoFijoMantenimiento;
        this.planes = new ArrayList<>();
    }

    public void agregarPlan(PlanDeEntrenamiento plan) {
        this.planes.add(plan);
    }

    public double calcularCapitalNeto() {
        double totalCostoPlanes = 0;
        
        for (PlanDeEntrenamiento plan : planes) {
            totalCostoPlanes += plan.calcularCostoTotal();
        }
        
        return totalCostoPlanes - this.costoFijoMantenimiento;
    }

    public boolean esDeElite() {
        for (PlanDeEntrenamiento plan : planes) {
            if (plan.esEnPromocion()) {
                return false; 
            }
        }
        return true; 
    }
    
    public String getNombre() {
        return nombre;
    }
}