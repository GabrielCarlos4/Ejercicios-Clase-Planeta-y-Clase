import java.util.ArrayList;
import java.util.Scanner;

// Clase Ingrediente
class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadDeMedida;

    public Ingrediente(String nombre, double cantidad, String unidadDeMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
    }

    @Override
    public String toString() {
        return nombre + "\t" + cantidad + "\t" + unidadDeMedida;
    }
}

// Clase Plato
class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder(nombreCompleto + "\nPrecio: $ " + precio);
        if (!esBebida) {
            resultado.append("\nIngredientes:\nNombre\tCantidad\tUnidad de Medida\n");
            for (Ingrediente ingrediente : ingredientes) {
                resultado.append(ingrediente).append("\n");
            }
        }
        return resultado.toString();
    }
}

class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        System.out.println("Ingrese la cantidad de platos a cargar:");
        int cantidadPlatos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("Nombre del plato:");
            String nombrePlato = scanner.nextLine();

            System.out.println("Precio del plato:");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("¿Es una bebida? (true/false):");
            boolean esBebida = scanner.nextBoolean();
            scanner.nextLine();

            Plato plato = new Plato(nombrePlato, precio, esBebida);

            if (!esBebida) {
                System.out.println("Ingrese la cantidad de ingredientes (al menos 1):");
                int cantidadIngredientes = Math.max(scanner.nextInt(), 1);
                scanner.nextLine();

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.println("Nombre del ingrediente:");
                    String nombreIngrediente = scanner.nextLine();

                    System.out.println("Cantidad:");
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Unidad de medida:");
                    String unidadDeMedida = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadDeMedida);
                    plato.agregarIngrediente(ingrediente);
                }
            }

            platosMenu.add(plato);
        }

        System.out.println("\nMENÚ:");
        for (Plato plato : platosMenu) {
            System.out.println(plato);
            System.out.println("---------------");
        }

        scanner.close();
    }
}
