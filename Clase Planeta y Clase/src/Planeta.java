import java.util.zip.ZipFile;

public class Planeta {
    String nombre = null;
    int cantidadSatélites = 0;
    double masa = 0;
    double volumen = 0;
    int diámetro = 0;
    int distanciaSol;
    boolean esObservable;
    tipoPlaneta tipo;
    double periodoOrbital;
    double periodoRotacion;

    public enum tipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }
    public Planeta(String nombre, int cantidadSatélites, double masa, double volumen, int diámetro, tipoPlaneta tipo,
                   boolean esObservable, int distanciaSol, double periodoOrbital, double periodoRotacion) {
        this.nombre = nombre;
        this.cantidadSatélites = cantidadSatélites;
        this.masa = masa;
        this.volumen = volumen;
        this.diámetro = diámetro;
        this.distanciaSol = distanciaSol;
        this.tipo = tipo;
        this.esObservable = esObservable;
        this.periodoOrbital = periodoOrbital;
        this.periodoRotacion = periodoRotacion;
    }

    public double calcularDensidad(){
        double densidad;
        densidad = masa/volumen;
        return densidad;
    }

    public boolean esPlanetaExterior (){
        return distanciaSol > 149747469;
    }
    void imprimir () {
        System.out.println("Nombre del planeta = "+ nombre);
        System.out.println("Cantidad de satélites = "+ cantidadSatélites);
        System.out.println("Masa del planeta = "+ masa);
        System.out.println("Volumen del planeta = "+ volumen);
        System.out.println("Diametro del planeta = "+ diámetro);
        System.out.println("Distancia al sol = "+ distanciaSol);
        System.out.println("Tipo de planeta = "+ tipo);
        System.out.println("¿Es observable? "+ esObservable);
        System.out.println("Densidad del planeta = "+ calcularDensidad());
        System.out.println("¿Es planeta exterior? "+ esPlanetaExterior());
        System.out.println("Periodo orbital del planeta en años = "+ periodoOrbital + " años");
        System.out.println("Periodo de rotación del planeta en días = "+ periodoRotacion + " días");
        System.out.println("");
    }

    public static void main(String[] args) {
        Planeta pl1 = new Planeta("Tierra", 1, 5.9736E24, 1.08321E12, 12742, tipoPlaneta.TERRESTRE,  true, 140000000, 1, 1);
        Planeta pl2 = new Planeta("Jupiter", 79, 1.899E27, 1.4313E15, 139820, tipoPlaneta.GASEOSO, true, 750000000, 11.86, 0.46);
        pl1.imprimir();
        pl2.imprimir();
    }

}
