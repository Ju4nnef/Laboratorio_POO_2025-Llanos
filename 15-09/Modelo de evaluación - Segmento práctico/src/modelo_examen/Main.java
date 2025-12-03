package modelo_examen;

public class Main {
    public static void main(String[] args) {
        

        PlanDeEntrenamiento planA = new PlanBasico("B01", "baja", 15000.00); 

        PlanDeEntrenamiento planB = new PlanPremium("P02", "alta", 30000.00); 
        
        PlanDeEntrenamiento planC = new PlanPersonalizado("PP03", "media", 60000.00, true); 
        
        PlanDeEntrenamiento planD = new PlanPremium("P04", "media", 45000.00); 
        
        
        System.out.println("--- PRUEBA DE PLANES ---");
        System.out.printf("Plan A (Básico): Costo Total: %.2f | En Promoción: %b\n", 
                          planA.calcularCostoTotal(), planA.esEnPromocion());
        
        System.out.printf("Plan B (Premium): Costo Total: %.2f | En Promoción: %b\n", 
                          planB.calcularCostoTotal(), planB.esEnPromocion());
                           
        System.out.printf("Plan C (Personalizado): Costo Total: %.2f | En Promoción: %b\n", 
                          planC.calcularCostoTotal(), planC.esEnPromocion());
        
        System.out.printf("Plan D (Premium): Costo Total: %.2f | En Promoción: %b\n", 
                          planD.calcularCostoTotal(), planD.esEnPromocion());
        
        System.out.println("\n------------------------");


        Gimnasio gymAlpha = new Gimnasio("Alpha Fitness", 100000.00);
        gymAlpha.agregarPlan(planA); 
        gymAlpha.agregarPlan(planB);
        gymAlpha.agregarPlan(planC); 
        
        System.out.println("--- Gimnasio " + gymAlpha.getNombre() + " (Con Promos) ---");
        System.out.printf("Capital Neto: %.2f\n", gymAlpha.calcularCapitalNeto());
        System.out.println("¿Es de Elite?: " + gymAlpha.esDeElite());
        System.out.println("\n------------------------");


        Gimnasio gymBeta = new Gimnasio("Beta Elite", 50000.00);
        gymBeta.agregarPlan(planC); 
        gymBeta.agregarPlan(planD); 
        

        System.out.println("--- Gimnasio " + gymBeta.getNombre() + " (Sin Promos) ---");
        System.out.printf("Capital Neto: %.2f\n", gymBeta.calcularCapitalNeto());
        System.out.println("¿Es de Elite?: " + gymBeta.esDeElite()); // TRUE
        System.out.println("------------------------");
    }
}