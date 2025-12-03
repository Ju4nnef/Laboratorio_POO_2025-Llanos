package repaso;

public class TacoLuisXV extends Taco {
    private boolean esImportado; 
    public TacoLuisXV(int id, int talle, double precioBase, boolean esImportado) {
        super(id, talle, precioBase);
        this.esImportado = esImportado;
    }

    @Override
    public double calcularPrecioVenta() {
        double precioTaco = super.calcularPrecioVenta();

        if (esImportado) {
            return precioTaco * 1.50; 
        }
        
        return precioTaco; 
    }
    
    @Override
    public String toString() {
        String base = super.toString().replace("Taco", "LuisXV");
        return base.substring(0, base.length() - 1) + ", Importado: " + esImportado + "]";
    }
}