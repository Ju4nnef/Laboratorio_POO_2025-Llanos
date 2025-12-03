package repaso;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ZapateriaTest {

    @Test
    void testCreacionCalzados() {
        Borcego miBorcego = new Borcego("CAT", 40, 15000.0);
        Sandalia miSandalia = new Sandalia("Crocs", 38, 5000.0);

        assertTrue(miBorcego instanceof Calzado);
        assertEquals(15000.0, miBorcego.getPrecio());
        assertEquals("Crocs", miSandalia.getMarca());
    }

    @Test
    void testSucursalYStock() {
        Sucursal sucursalCentro = new Sucursal("Centro");

        Borcego b1 = new Borcego("DrMartens", 39, 20000.0);
        Sandalia s1 = new Sandalia("Havaianas", 37, 3000.0);

        sucursalCentro.agregarCalzado(b1);
        sucursalCentro.agregarCalzado(s1);

        assertEquals(2, sucursalCentro.getCantidadCalzados(), "La sucursal debería tener 2 calzados");
        
        assertEquals(23000.0, sucursalCentro.calcularValorTotalStock(), "El valor del stock es incorrecto");
    }
}