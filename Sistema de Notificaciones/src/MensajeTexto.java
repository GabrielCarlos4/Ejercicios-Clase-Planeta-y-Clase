public class MensajeTexto extends CanalNotificacion implements Personalizable {
    private String numeroTelefono;

    public MensajeTexto(String usuario, String mensaje, String numeroTelefono) {
        super(usuario, mensaje);
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void enviarNotificacion() {
        System.out.println("Enviando mensaje de texto a " + numeroTelefono + ": " + mensaje);
    }

    @Override
    public void personalizarMensaje(String nuevoMensaje) {
        this.mensaje = nuevoMensaje;
    }
}
