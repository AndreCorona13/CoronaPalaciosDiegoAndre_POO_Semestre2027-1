
/** Práctica 12: Hilos
 * Código 8: Clase Auto.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que permite interactuar con un cajero automático para realizar depósitos,
 * retiros y consultas de saldo mediante la ejecución de hilos.
 */
import java.util.ArrayList;
import java.util.Scanner; /** Librería que permite la interacción del usuario con el programa */

/** Clase principal del programa */
public class Main3 {

    /** Método que solicita y valida una cantidad ingresada por el usuario */
    public static double leerCantidad(Scanner sc, String mensaje) {

        double cantidad = 0;
        boolean valido = false;

        // Ciclo que se repite hasta que se ingrese una cantidad válida
        while(!valido) {
            try {
                System.out.print(mensaje);

                // Lee la entrada y reemplaza la coma por un punto para convertirla a número
                String entrada = sc.nextLine();
                cantidad = Double.parseDouble(entrada.replace(',', '.'));

                // Verifica que la cantidad sea mayor que cero y un número finito
                if(cantidad > 0 && Double.isFinite(cantidad)) {
                    valido = true;
                } else {
                    System.out.println("Error: ingresa una cantidad mayor a cero");
                }

            } catch(NumberFormatException e) {
                // Maneja el error cuando se ingresa un dato que no tiene un formato numérico válido
                System.out.println("Error: debes ingresar un numero valido");
            }
        }

        return cantidad;
    }

    /** Método que solicita y valida la opción seleccionada en el menú */
    public static int leerOpcion(Scanner sc) {

        int opcion = 0;
        boolean valido = false;

        // Ciclo que se repite hasta que se ingrese una opción válida
        while(!valido) {
            try {
                System.out.print("Selecciona una opcion: ");

                // Convierte la entrada del usuario a un número entero
                opcion = Integer.parseInt(sc.nextLine());

                // Verifica que la opción esté entre 1 y 4
                if(opcion >= 1 && opcion <= 4) {
                    valido = true;
                } else {
                    System.out.println("Error: selecciona una opcion del 1 al 4");
                }

            } catch(NumberFormatException e) {
                // Maneja el error cuando se ingresa un dato que no es un número entero
                System.out.println("Error: ingresa un numero entero");
            }
        }

        return opcion;
    }

    public static void main(String[] args) {

        // Se crea un Scanner para leer los datos ingresados por el usuario
        Scanner sc = new Scanner(System.in);

        // Lista que almacena los hilos utilizados para las operaciones bancarias
        ArrayList<Thread> hilos = new ArrayList<>();

        // Variables para almacenar los datos del titular y el saldo inicial
        String titular;
        double saldoInicial = 0;
        boolean valido = false;

        // Ciclo que solicita y valida el nombre del titular
        do {
            System.out.print("Nombre del titular: ");
            titular = sc.nextLine().trim();

            // Verifica que el nombre contenga únicamente letras y espacios
            if(titular.matches("[\\p{L} ]+")) {
                valido = true;
            } else {
                System.out.println("Error: ingresa un nombre valido");
            }

        } while(!valido);

        // Se reinicia la variable para validar el saldo inicial
        valido = false;

        // Ciclo que solicita y valida el saldo inicial de la cuenta
        while(!valido) {
            try {
                System.out.print("Saldo inicial: $");

                // Convierte la cantidad ingresada a un número decimal
                saldoInicial = Double.parseDouble(sc.nextLine().replace(',', '.'));

                // Verifica que el saldo sea mayor o igual a cero y un número finito
                if(saldoInicial >= 0 && Double.isFinite(saldoInicial)) {
                    valido = true;
                } else {
                    System.out.println("Error: el saldo no puede ser negativo");
                }

            } catch(NumberFormatException e) {
                // Maneja el error cuando el saldo ingresado no tiene un formato numérico válido
                System.out.println("Error: ingresa una cantidad valida");
            }
        }

        // Se crea la cuenta bancaria con el nombre del titular y el saldo inicial
        CuentaBancaria cuenta = new CuentaBancaria(titular, saldoInicial);

        int opcion;

        // Ciclo principal del menú del cajero automático
        do {
            System.out.println("\n----Cajero Automatico----");
            System.out.println("Titular: " + cuenta.getTitular());
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");

            // Se obtiene una opción válida mediante el método leerOpcion
            opcion = leerOpcion(sc);

            // Comprueba si el usuario seleccionó depositar o retirar
            if(opcion == 1 || opcion == 2) {

                // Solicita la cantidad que se desea depositar o retirar
                double cantidad = leerCantidad(sc, "Ingresa la cantidad: $");

                // Se crea un objeto Cajero con los datos de la operación
                Cajero cajero = new Cajero(cuenta, opcion, cantidad);

                // Se crea un hilo para ejecutar la operación bancaria
                Thread hilo = new Thread(cajero);

                // Se agrega el hilo a la lista de hilos
                hilos.add(hilo);

                // Inicia la ejecución del hilo
                hilo.start();

                try {
                    // Espera a que termine la operación antes de continuar con el menú
                    hilo.join();
                } catch(InterruptedException e) {
                    // Muestra un mensaje si la operación es interrumpida
                    System.out.println("La operacion se interrumpio");
                    Thread.currentThread().interrupt();
                }

            } else if(opcion == 3) {

                // Consulta y muestra el saldo actual de la cuenta
                System.out.println("\nSaldo actual: $" + cuenta.getSaldo());

            } else if(opcion == 4) {

                // Muestra un mensaje antes de salir del menú
                System.out.println("\nCerrando sesion...");

            }

        } while(opcion != 4);

        // Recorre la lista de hilos para comprobar que todos hayan terminado
        for(Thread hilo : hilos) {
            try {
                // Espera la finalización de cada hilo
                hilo.join();
            } catch(InterruptedException e) {
                // Maneja la interrupción durante la espera de los hilos
                System.out.println("Error al esperar los hilos");
                Thread.currentThread().interrupt();
                break;
            }
        }

        // Muestra la información final de la cuenta bancaria
        System.out.println("\nInformacion");
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo final: $" + cuenta.getSaldo());

        // Mensaje de despedida
        System.out.println("\nGracias por utilizar el cajero");

        // Se cierra el Scanner
        sc.close();
    }
} 
