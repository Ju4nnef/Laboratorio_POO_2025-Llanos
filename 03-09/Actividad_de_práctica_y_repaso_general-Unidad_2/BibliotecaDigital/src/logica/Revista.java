package logica;

public class Revista extends Material {
    private int numeroEdicion;

    public Revista(String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println(" REVISTA ");
        System.out.println("Título: " + titulo);
        System.out.println("Año: " + anioPublicacion);
        System.out.println("Edición N°: " + numeroEdicion);
    }
    
    public int getNumeroEdicion() { return numeroEdicion; }
    public void setNumeroEdicion(int numeroEdicion) { this.numeroEdicion = numeroEdicion; }
}