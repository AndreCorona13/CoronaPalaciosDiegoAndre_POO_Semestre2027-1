
/** Práctica 12: Hilos
 * Código 6: Clase Auto.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Clase que representa una cuenta bancaria y permite realizar operaciones de depósito,
 * retiro y consulta de saldo de manera sincronizada.
 */

/** Clase que administra la información y las operaciones de la cuenta bancaria */
public class CuentaBancaria {

    // Atributos que almacenan el nombre del titular y el saldo de la cuenta
    private String titular;
    private double saldo;

    /** Constructor vacío */
    public CuentaBancaria() {}

    /** Constructor que inicializa el titular y el saldo de la cuenta */
    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    /** Métodos setters para modificar los atributos */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Método setter que valida que el saldo sea positivo o igual a cero y un número finito
    public void setSaldo(double saldo) {
        if(saldo >= 0 && Double.isFinite(saldo)) {
            this.saldo = saldo;
        }
    }

    /** Métodos getters para obtener los atributos */
    public String getTitular() {
        return titular;
    }

    // Método sincronizado que permite consultar el saldo de forma segura entre hilos
    public synchronized double getSaldo() {
        return saldo;
    }

    /** Método sincronizado que permite realizar depósitos en la cuenta */
    public synchronized void depositar(double cantidad) {

        // Verifica que la cantidad sea mayor que cero y un número finito
        if(cantidad <= 0 || !Double.isFinite(cantidad)) {
            System.out.println("Error: cantidad no valida");
            return;
        }

        // Se suma la cantidad depositada al saldo actual
        saldo += cantidad;

        // Muestra los datos de la operación realizada
        System.out.println("\nDeposito realizado correctamente");
        System.out.println("Cantidad depositada: $" + cantidad);
        System.out.println("Saldo actual: $" + saldo);
    }

    /** Método sincronizado que permite realizar retiros de la cuenta */
    public synchronized void retirar(double cantidad) {

        // Verifica que la cantidad sea mayor que cero y un número finito
        if(cantidad <= 0 || !Double.isFinite(cantidad)) {
            System.out.println("Error: cantidad no valida");
            return;
        }

        // Comprueba si existe saldo suficiente para realizar el retiro
        if(saldo >= cantidad) {
            // Se resta la cantidad retirada del saldo actual
            saldo -= cantidad;

            // Muestra los datos del retiro realizado
            System.out.println("\nRetiro realizado correctamente");
            System.out.println("Cantidad retirada: $" + cantidad);
            System.out.println("Saldo actual: $" + saldo);

        } else {
            // Muestra un mensaje cuando no hay saldo suficiente
            System.out.println("\nSaldo insuficiente");
            System.out.println("Cantidad que intentaste retirar: $" + cantidad);
            System.out.println("Saldo disponible: $" + saldo);
        }
    }
} 
