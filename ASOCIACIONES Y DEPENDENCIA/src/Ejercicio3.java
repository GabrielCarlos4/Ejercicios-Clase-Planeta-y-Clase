import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

    static class DetalleFactura {
        private String codigoArticulo;
        private String nombreArticulo;
        private int cantidad;
        private double precioUnitario;
        private double descuentoItem;
        private double subtotal;

        public DetalleFactura(String codigoArticulo, String nombreArticulo, int cantidad, double precioUnitario, double descuentoItem) {
            this.codigoArticulo = codigoArticulo;
            this.nombreArticulo = nombreArticulo;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
            this.descuentoItem = descuentoItem;
            this.subtotal = (precioUnitario * cantidad) - (descuentoItem * cantidad);
        }

        public double getSubtotal() {
            return subtotal;
        }

        @Override
        public String toString() {
            return codigoArticulo + "\t" + nombreArticulo + "\t" + cantidad + "\t" + precioUnitario + "\t" + descuentoItem + "\t" + subtotal;
        }
    }

    static class Factura {
        private String fechaFactura;
        private long numeroFactura;
        private String cliente;
        private double totalCalculadoFactura;
        private ArrayList<DetalleFactura> detallesFactura;

        public Factura(String fechaFactura, long numeroFactura, String cliente) {
            this.fechaFactura = fechaFactura;
            this.numeroFactura = numeroFactura;
            this.cliente = cliente;
            this.detallesFactura = new ArrayList<>();
        }

        public void agregarDetalle(DetalleFactura detalle) {
            detallesFactura.add(detalle);
        }

        public void calcularMontoTotal() {
            totalCalculadoFactura = 0;
            for (DetalleFactura detalle : detallesFactura) {
                totalCalculadoFactura += detalle.getSubtotal();
            }
        }

        @Override
        public String toString() {
            StringBuilder info = new StringBuilder();
            info.append("Fecha: ").append(fechaFactura)
                    .append("\nNúmero: ").append(numeroFactura)
                    .append("\nCliente: ").append(cliente)
                    .append("\n\nCódigo\tNombre\tCantidad\tPrecio\tDescuento\tSubtotal\n");
            for (DetalleFactura detalle : detallesFactura) {
                info.append(detalle).append("\n");
            }
            info.append("Total: ").append(totalCalculadoFactura);
            return info.toString();
        }
    }

    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la fecha de la factura:");
        String fechaFactura = scanner.nextLine();

        long numeroFactura;
        do {
            System.out.println("Ingrese el número de factura (entero positivo):");
            numeroFactura = scanner.nextLong();
            scanner.nextLine();
        } while (numeroFactura <= 0);

        System.out.println("Ingrese el nombre del cliente:");
        String cliente = scanner.nextLine();

        Factura factura = new Factura(fechaFactura, numeroFactura, cliente);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese el código del artículo:");
            String codigoArticulo = scanner.nextLine();
            String[] articuloEncontrado = buscarArticulo(codigoArticulo);

            if (articuloEncontrado == null) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
                continue;
            }

            System.out.println("Ingrese la cantidad:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            double precioUnitario = Double.parseDouble(articuloEncontrado[2]);
            double descuentoItem = (cantidad > 5) ? precioUnitario * 0.1 : 0;

            DetalleFactura detalle = new DetalleFactura(
                    articuloEncontrado[0],
                    articuloEncontrado[1],
                    cantidad,
                    precioUnitario,
                    descuentoItem
            );

            factura.agregarDetalle(detalle);

            System.out.println("¿Desea agregar otro artículo? (true/false):");
            continuar = scanner.nextBoolean();
            scanner.nextLine();
        }

        factura.calcularMontoTotal();

        System.out.println("\nFACTURA:");
        System.out.println(factura);

        scanner.close();
    }

    private static String[] buscarArticulo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
}
