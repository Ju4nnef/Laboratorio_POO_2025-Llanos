package notificaciones;

public class NotificacionSMS extends Notificacion {
    @Override
    public String enviar(String mensaje) {
        return "Enviando SMS al número registrado: " + mensaje;
    }
}