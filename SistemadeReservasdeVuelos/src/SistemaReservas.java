public class SistemaReservas {
    public static void main(String[] args) {
        Reservas reservas = new Reservas();

        Vuelo vuelo1 = new VueloRegular("VR123", "Buenos Aires", "Santiago", "2024-12-01", 150, 100);
        Vuelo vuelo2 = new VueloCharter("VC456", "Lima", "Bogotá", "2024-12-02", 5000);

        reservas.agregarVuelo(vuelo1);
        reservas.agregarVuelo(vuelo2);

        System.out.println("Vuelos antes de aplicar promociones:");
        reservas.mostrarVuelos();

        reservas.aplicarPromociones(10);

        System.out.println("\nVuelos después de aplicar promociones:");
        reservas.mostrarVuelos();

        System.out.println("\nPrecio total de las reservas: " + reservas.calcularPrecioTotal());
    }
}
