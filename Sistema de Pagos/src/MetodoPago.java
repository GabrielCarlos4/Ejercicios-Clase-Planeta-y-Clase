abstract public class MetodoPago {
    protected String titular;
    protected String numero;

    public MetodoPago(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
    }

    public abstract void realizarPago(double monto);

    public String obtenerInformacion() {
        return "Titular: " + titular + ", Número: " + numero;
    }
}
