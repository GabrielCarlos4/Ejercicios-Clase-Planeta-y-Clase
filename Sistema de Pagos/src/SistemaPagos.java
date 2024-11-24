public class SistemaPagos {
    public static void main(String[] args) {
        Pagos sistemaPagos = new Pagos();

        MetodoPago tarjeta = new TarjetaCredito("Juan Pérez", "1234-5678-9876-5432", "12/26", "123");
        MetodoPago paypal = new Paypal("Ana López", "98765", "ana.lopez@example.com");

        sistemaPagos.agregarMetodoPago(tarjeta);
        sistemaPagos.agregarMetodoPago(paypal);

        System.out.println("Métodos de pago disponibles:");
        sistemaPagos.mostrarMetodosPago();

        System.out.println("\nRealizando pagos:");
        sistemaPagos.realizarPagos(150.0);

        System.out.println("\nCancelando pagos:");
        sistemaPagos.cancelarPagos();
    }
}
