import java.util.ArrayList;
import java.util.List;

public class Pagos {
    private List<MetodoPago> metodosPago;

    public Pagos() {
        this.metodosPago = new ArrayList<>();
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        metodosPago.add(metodoPago);
    }

    public void realizarPagos(double monto) {
        for (MetodoPago metodo : metodosPago) {
            metodo.realizarPago(monto);
        }
    }

    public void cancelarPagos() {
        for (MetodoPago metodo : metodosPago) {
            if (metodo instanceof Cancelable) {
                ((Cancelable) metodo).cancelarPago();
            }
        }
    }

    public void mostrarMetodosPago() {
        for (MetodoPago metodo : metodosPago) {
            System.out.println(metodo.obtenerInformacion());
        }
    }
}
