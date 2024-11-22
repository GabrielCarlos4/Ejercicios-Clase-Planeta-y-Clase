public class Persona {
    String nombre;
    String apellidos;
    String númeroDocumentoIdentidad;
    int añoNacimiento;
    String paisNacimiento;
    char genero;

    public Persona(String nombre, String apellidos, String númeroDocumentoIdentidad,
                   int añoNacimiento, String paisNacimiento, char genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.númeroDocumentoIdentidad = númeroDocumentoIdentidad;
        this.añoNacimiento = añoNacimiento;
        this.paisNacimiento = paisNacimiento;
        this.genero = genero;
    }

    void imprimir(){
        System.out.println("Nombre = "+ nombre);
        System.out.println("Apellido = "+ apellidos);
        System.out.println("Número de documento de indentidad = " +
                númeroDocumentoIdentidad);
        System.out.println("Año de nacimeinto = "+ añoNacimiento);
        System.out.println("País de nacimiento = "+ paisNacimiento);
        System.out.println("Genero = "+ (genero == 'H' ? "Hombre" : genero == 'M' ? "Mujer" : "No especificado"));
        System.out.println();
    }
    public static void main(String[] args) {
        Persona p1 = new Persona("Pedro", "Pérez", "1053121010", 1998, "Argentina", 'H');
        Persona p2 = new Persona("Luis", "León", "1053223344", 2001, "Mexico", 'H');
        p1.imprimir();
        p2.imprimir();
    }
}

