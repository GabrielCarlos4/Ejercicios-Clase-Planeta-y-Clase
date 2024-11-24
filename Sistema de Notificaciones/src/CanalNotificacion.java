abstract public class CanalNotificacion {
    protected String usuario;
    protected String mensaje;

    public CanalNotificacion(String usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    public abstract void enviarNotificacion();

    public String obtenerInformacion() {
        return "Usuario: " + usuario + ", Mensaje: " + mensaje;
    }
}
