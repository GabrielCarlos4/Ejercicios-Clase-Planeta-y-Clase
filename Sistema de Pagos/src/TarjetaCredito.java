public class TarjetaCredito extends MetodoPago implements Cancelable {
    private String fechaExpiracion;
    private String codigoSeguridad;

    public TarjetaCredito(String titular, String numero, String fechaExpiracion, String codigoSeguridad) {
        super(titular, numero);
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;
    }

    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago de $" + monto + " realizado con tarjeta de crédito.");
    }

    @Override
    public void cancelarPago() {
        System.out.println("Pago con tarjeta de crédito cancelado.");
    }
}
