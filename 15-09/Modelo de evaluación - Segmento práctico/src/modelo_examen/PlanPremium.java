package modelo_examen;

public class PlanPremium extends PlanDeEntrenamiento {

    public PlanPremium(String codigo, String intensidad, double costoBase) {
        super(codigo, intensidad, costoBase);
    }

    @Override
    public double calcularCostoTotal() {

        return this.getCostoBase() * 1.40;
    }
}