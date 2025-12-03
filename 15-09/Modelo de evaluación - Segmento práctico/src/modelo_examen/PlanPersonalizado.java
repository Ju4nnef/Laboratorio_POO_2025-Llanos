package modelo_examen;

public class PlanPersonalizado extends PlanDeEntrenamiento {
    private boolean incluyeNutricion;

    public PlanPersonalizado(String codigo, String intensidad, double costoBase, boolean incluyeNutricion) {
        super(codigo, intensidad, costoBase);
        this.incluyeNutricion = incluyeNutricion;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = this.getCostoBase(); 

        costo *= 1.60;

        if (this.incluyeNutricion) {
            costo += this.getCostoBase() * 0.20;
        }
        return costo;
    }
}