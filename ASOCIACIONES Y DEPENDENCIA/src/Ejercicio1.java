import java.util.ArrayList;
import java.util.Scanner;

class Nota {
    private String catedra;
    private double notaExamen;

    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    @Override
    public String toString() {
        return "Cátedra: " + catedra + ", Nota: " + notaExamen;
    }

    public double getNotaExamen() {
        return notaExamen;
    }
}

class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return notas.isEmpty() ? 0.0 : suma / notas.size();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Alumno: " + nombreCompleto + ", Legajo: " + legajo + "\nNotas:\n");
        for (Nota nota : notas) {
            info.append("  ").append(nota).append("\n");
        }
        info.append("Promedio: ").append(calcularPromedio());
        return info.toString();
    }
}

class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        System.out.println("Ingrese la cantidad de alumnos:");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Nombre del alumno:");
            String nombre = scanner.nextLine();

            System.out.println("Legajo del alumno:");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Limpiar el buffer

            Alumno alumno = new Alumno(nombre, legajo);

            System.out.println("Cantidad de notas (al menos 1):");
            int cantidadNotas = Math.max(scanner.nextInt(), 1);
            scanner.nextLine(); // Limpiar el buffer

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Cátedra:");
                String catedra = scanner.nextLine();

                System.out.println("Nota:");
                double nota = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer

                alumno.agregarNota(new Nota(catedra, nota));
            }

            alumnos.add(alumno);
        }

        System.out.println("\nInformación de los alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.println("---------------");
        }

        scanner.close();
    }
}
