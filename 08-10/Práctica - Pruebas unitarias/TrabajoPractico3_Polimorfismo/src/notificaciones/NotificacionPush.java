package notificaciones;

public class NotificacionPush extends Notificacion {
    @Override
    public String enviar(String mensaje) {
        return "Enviando PUSH notification: " + mensaje;
    }
}