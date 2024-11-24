public class Paypal extends MetodoPago implements Cancelable {
    private String correoElectronico;

    public Paypal(String titular, String numero, String correoElectronico) {
        super(titular, numero);
        this.correoElectronico = correoElectronico;
    }

    @Override
    public void realizarPago(double monto) {
        System.out.println("Pago de $" + monto + " realizado con PayPal.");
    }

    @Override
    public void cancelarPago() {
        System.out.println("Pago con PayPal cancelado.");
    }
}
