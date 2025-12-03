package notificaciones;

public class NotificacionEmail extends Notificacion {
    @Override
    public String enviar(String mensaje) {
        return "Enviando EMAIL con cuerpo: " + mensaje;
    }
}