package repaso;

public class Main {
    public static void main(String[] args) {
        
        Calzado b1 = new Borcego(101, 39, 10000); 
        Calzado b2 = new Borcego(102, 42, 20000); 
        Calzado s1 = new Sandalia(201, 38, 14000);
        Calzado s2 = new Sandalia(202, 37, 16000);
        Calzado t1 = new Taco(301, 36, 30000);
        Calzado l1 = new TacoLuisXV(401, 38, 50000, true);
        Calzado l2 = new TacoLuisXV(402, 38, 50000, false);
        
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(t1);
        System.out.println(l1);
        System.out.println(l2);

        Sucursal centro = new Sucursal("Centro", 50000);
        centro.agregarCalzado(b1); 
        centro.agregarCalzado(s1); 
        centro.agregarCalzado(t1); 
        centro.agregarCalzado(l1); 
        
        Sucursal recoleta = new Sucursal("Recoleta", 100000);
        recoleta.agregarCalzado(b2); 
        recoleta.agregarCalzado(s2); 
        recoleta.agregarCalzado(l2); 
        
        System.out.println("--- SUCURSAL CENTRO (Alquiler: $50000) ---");
        System.out.printf("Capital de Centro: $%.2f\n", centro.calcularCapital());
        
        System.out.println("Calzados en Liquidacion (Centro):");
        for (Calzado c : centro.getCalzadosEnLiquidacion()) {
            System.out.println(" -> " + c);
        }
        System.out.println("¿Es local refinado? " + centro.esLocalRefinado()); 

        System.out.println("--- SUCURSAL RECOLETA (Alquiler: $100000) ---");
        System.out.printf("Capital de Recoleta: $%.2f\n", recoleta.calcularCapital());
        
        System.out.println("Calzados en Liquidacion (Recoleta):");
        for (Calzado c : recoleta.getCalzadosEnLiquidacion()) {
            System.out.println(" -> " + c);
        }
        System.out.println("¿Es local refinado? " + recoleta.esLocalRefinado()); 

        Empresa miEmpresa = new Empresa("Calzados Llanos,Lee and Martinez.");
        miEmpresa.agregarSucursal(centro);
        miEmpresa.agregarSucursal(recoleta);
        
        System.out.println("--- GESTIÓN DE EMPRESA Calzados Llanos,Lee and Martinez. ---");
        System.out.printf("CAPITAL TOTAL DE LA EMPRESA: $%.2f\n", miEmpresa.calcularCapitalTotal());
        
        System.out.println("Cantidad de Locales Refinados: " + miEmpresa.contarLocalesRefinados());
    }
}