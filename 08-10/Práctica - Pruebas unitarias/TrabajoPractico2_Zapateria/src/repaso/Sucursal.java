package repaso;
import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String nombre;
    private List<Calzado> stock; 

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.stock = new ArrayList<>();
    }

    public void agregarCalzado(Calzado calzado) {
        stock.add(calzado);
    }

    public int getCantidadCalzados() {
        return stock.size();
    }

    public double calcularValorTotalStock() {
        double total = 0;
        for (Calzado c : stock) {
            total += c.getPrecio();
        }
        return total;
    }
}