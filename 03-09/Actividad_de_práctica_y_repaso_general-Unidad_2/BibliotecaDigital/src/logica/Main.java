package logica;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA ===");
        
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, 96);
        Revista revista1 = new Revista("National Geographic", "Varios", 2023, 502);

        System.out.println("\n--- DETALLE DE MATERIALES ---");
        libro1.mostrarInfo();
        System.out.println(""); 
        revista1.mostrarInfo();

        Usuario usuario1 = new Usuario("Juan Pérez", "12.345.678");

        Prestamo prestamo1 = new Prestamo(usuario1, libro1, 7);

        System.out.println("\n--- NUEVO PRÉSTAMO REGISTRADO ---");
        if (prestamo1.getUsuario() != null && prestamo1.getMaterial() != null) {
            System.out.println("Usuario: " + prestamo1.getUsuario().getNombre());
            System.out.println("Se llevó: " + prestamo1.getMaterial().getTitulo());
        }

        int diasDeRetraso = 5; 
        
        double multa = prestamo1.calcularMulta(diasDeRetraso);

        System.out.println("\n--- DEVOLUCIÓN ---");
        System.out.println("Días de retraso: " + diasDeRetraso);
        
        if (multa > 0) {
            System.out.println("¡Alerta! Debe pagar una multa de: $" + multa);
        } else {
            System.out.println("Devolución a tiempo. No hay multa.");
        }
    }
}