package notificaciones;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PolimorfismoTest {

    @Test
    void testEnviosDiferentes() {
        Notificacion email = new NotificacionEmail();
        Notificacion sms = new NotificacionSMS();
        Notificacion push = new NotificacionPush();
        
        String mensajePrueba = "Hola Mundo";


        assertEquals("Enviando EMAIL con cuerpo: Hola Mundo", email.enviar(mensajePrueba));
        
        assertEquals("Enviando SMS al número registrado: Hola Mundo", sms.enviar(mensajePrueba));
        
        assertEquals("Enviando PUSH notification: Hola Mundo", push.enviar(mensajePrueba));
    }
    
    @Test
    void testEsInstanciaDeNotificacion() {
        Notificacion email = new NotificacionEmail();
        assertTrue(email instanceof Notificacion, "El email debería ser un tipo de Notificación");
    }
}