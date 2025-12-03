package logica;

public class Prestamo {
    private Usuario usuario;
    private Material material;
    private int cantidadDias;

    public Prestamo(Usuario usuario, Material material, int cantidadDias) {
        this.usuario = usuario;
        this.material = material;
        this.cantidadDias = cantidadDias;
    }

    public double calcularMulta(int diasRetraso) {
        if (diasRetraso > 0) {
            return diasRetraso * 10.0; 
        }
        return 0.0;
    }
    
    public Usuario getUsuario() { return usuario; }
    public Material getMaterial() { return material; }
}