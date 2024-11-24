public class SistemaNotificaciones {
    public static void main(String[] args) {
        Notificaciones sistemaNotificaciones = new Notificaciones();

        CanalNotificacion correo = new CorreoElectronico("Juan Pérez", "Bienvenido a nuestro sistema", "juan.perez@example.com");
        CanalNotificacion mensajeTexto = new MensajeTexto("Ana López", "Tu código de verificación es 1234", "555-1234");

        sistemaNotificaciones.agregarCanal(correo);
        sistemaNotificaciones.agregarCanal(mensajeTexto);

        System.out.println("Canales de notificación:");
        sistemaNotificaciones.mostrarCanales();

        System.out.println("\nEnviando notificaciones:");
        sistemaNotificaciones.enviarNotificaciones();

        System.out.println("\nPersonalizando mensajes:");
        sistemaNotificaciones.personalizarMensajes("Este es un mensaje personalizado.");
        sistemaNotificaciones.mostrarCanales();

        System.out.println("\nEnviando notificaciones nuevamente:");
        sistemaNotificaciones.enviarNotificaciones();
    }
}
