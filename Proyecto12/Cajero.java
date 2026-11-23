
/** Práctica 12: Hilos
 * Código 7: Clase Auto.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Clase que representa un cajero automático y permite ejecutar operaciones bancarias
 * mediante la implementación de la interfaz Runnable.
 */

/** Clase que implementa Runnable para ejecutar operaciones mediante hilos */
public class Cajero implements Runnable {

    // Atributos que almacenan la cuenta bancaria, la opción seleccionada y la cantidad
    private CuentaBancaria cuenta;
    private int opcion;
    private double cantidad;

    /** Constructor vacío */
    public Cajero() {}

    /** Constructor que inicializa la cuenta, la operación y la cantidad */
    public Cajero(CuentaBancaria cuenta, int opcion, double cantidad) {
        this.cuenta = cuenta;
        this.opcion = opcion;
        this.cantidad = cantidad;
    }

    /** Métodos setters para modificar los atributos */
    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    // Método setter que valida que la opción sea 1 (depositar) o 2 (retirar)
    public void setOpcion(int opcion) {
        if(opcion == 1 || opcion == 2) {
            this.opcion = opcion;
        }
    }

    // Método setter que valida que la cantidad sea mayor que cero y un número finito
    public void setCantidad(double cantidad) {
        if(cantidad > 0 && Double.isFinite(cantidad)) {
            this.cantidad = cantidad;
        }
    }

    /** Métodos getters para obtener los atributos */
    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public int getOpcion() {
        return opcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    /** Método run que ejecuta la operación bancaria asignada al hilo */
    @Override
    public void run() {

        // Valida que los datos de la operación sean correctos antes de ejecutarla
        if(cuenta == null || (opcion != 1 && opcion != 2)
                || cantidad <= 0 || !Double.isFinite(cantidad)) {
            System.out.println("Error: datos de la operacion no validos");
            return;
        }

        try {
            // Pausa el hilo durante 500 milisegundos
            Thread.sleep(500);

            // Ejecuta un depósito si la opción seleccionada es 1
            if(opcion == 1) {
                cuenta.depositar(cantidad);
            } 
            // Ejecuta un retiro si la opción seleccionada es 2
            else if(opcion == 2) {
                cuenta.retirar(cantidad);
            }

        } catch(InterruptedException e) {
            // Muestra un mensaje cuando la operación es interrumpida
            System.out.println("Operacion interrumpida");

            // Restablece el estado de interrupción del hilo
            Thread.currentThread().interrupt();
        }
    }
}
