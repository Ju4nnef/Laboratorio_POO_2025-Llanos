package modelo_examen;

public abstract class PlanDeEntrenamiento {
    private String codigo;
    private String intensidad; 
    private double costoBase;

    public PlanDeEntrenamiento(String codigo, String intensidad, double costoBase) {
        this.codigo = codigo;
        this.intensidad = intensidad;
        this.costoBase = costoBase;
    }


    public double getCostoBase() {
        return costoBase;
    }


    public abstract double calcularCostoTotal();

 
    public boolean esEnPromocion() {
    	
        if (this.costoBase < 20000) {
            return true;
        }

        if (this instanceof PlanPremium && this.intensidad.equalsIgnoreCase("alta")) {
            return true;
        }
        return false;
    }
}