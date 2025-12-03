package instanciado;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class VehiculosTest {

    @Test
    void testCreacionAuto() {
        Auto miAuto = new Auto("Ford", "Focus");
        
        assertEquals("Ford", miAuto.getMarca(), "La marca del auto debería ser Ford");
        assertEquals("Focus", miAuto.getModelo(), "El modelo debería ser Focus");
    }

    @Test
    void testHerenciaYPolimorfismo() {
        Moto miMoto = new Moto("Honda", "CBR");
        
        assertNotNull(miMoto);
        

        assertTrue(miMoto instanceof Vehiculo, "La clase Moto debería heredar de Vehiculo");
    }
    
    @Test
    void testCamion() {
        Camion miCamion = new Camion("Volvo", "FH16");
        assertEquals("Volvo", miCamion.getMarca());
    }
}