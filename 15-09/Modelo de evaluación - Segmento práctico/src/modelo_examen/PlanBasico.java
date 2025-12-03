package modelo_examen;

public class PlanBasico extends PlanDeEntrenamiento {

    public PlanBasico(String codigo, String intensidad, double costoBase) {
        super(codigo, intensidad, costoBase);
    }

    @Override
    public double calcularCostoTotal() {
        return this.getCostoBase();
    }
}