abstract class Vuelo {
    protected String numeroVuelo;
    protected String origen;
    protected String destino;
    protected String fecha;

    public Vuelo(String numeroVuelo, String origen, String destino, String fecha) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
    }

    public abstract double calcularPrecio();

    public String obtenerInformacion() {
        return "Vuelo: " + numeroVuelo + ", Origen: " + origen + ", Destino: " + destino + ", Fecha: " + fecha;
    }
}
