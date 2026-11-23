
/** Práctica 12: Hilos
 * Código 5: Clase Auto.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que solicita los nombres de los empleados y la cantidad de pedidos que realizarán,
 * ejecutando cada proceso mediante hilos independientes.
 */
import java.util.InputMismatchException;
import java.util.Scanner; /** Librería que permite la interacción del usuario con el programa */

/** Clase principal del programa */
public class Main2 {
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer los datos ingresados por el usuario
        Scanner sc = new Scanner(System.in);

        // Variables que almacenan los nombres de los cuatro empleados
        String nombre1 = "";
        String nombre2 = "";
        String nombre3 = "";
        String nombre4 = "";

        // Variable que controla la validación de los datos
        boolean valido = false;

        // Ciclo que solicita y valida el nombre del primer empleado
        while(!valido) {
            System.out.println("Nombre del empleado 1: ");
            nombre1 = sc.nextLine().trim();

            // Verifica que el nombre no esté vacío y contenga únicamente letras y espacios
            if(!nombre1.isEmpty() && nombre1.matches("[\\p{L} ]+")) {
                valido = true;
            } else {
                System.out.println("Ingrese solo letras");
            }
        }

        // Se reinicia la variable para validar el siguiente nombre
        valido = false;

        // Ciclo que solicita y valida el nombre del segundo empleado
        while(!valido) {
            System.out.println("Nombre del empleado 2: ");
            nombre2 = sc.nextLine().trim();

            if(!nombre2.isEmpty() && nombre2.matches("[\\p{L} ]+")) {
                valido = true;
            } else {
                System.out.println("Ingrese solo letras");
            }
        }

        // Se reinicia la variable para validar el siguiente nombre
        valido = false;

        // Ciclo que solicita y valida el nombre del tercer empleado
        while(!valido) {
            System.out.println("Nombre del empleado 3: ");
            nombre3 = sc.nextLine().trim();

            if(!nombre3.isEmpty() && nombre3.matches("[\\p{L} ]+")) {
                valido = true;
            } else {
                System.out.println("Ingrese solo letras");
            }
        }

        // Se reinicia la variable para validar el siguiente nombre
        valido = false;

        // Ciclo que solicita y valida el nombre del cuarto empleado
        while(!valido) {
            System.out.println("Nombre del empleado 4: ");
            nombre4 = sc.nextLine().trim();

            if(!nombre4.isEmpty() && nombre4.matches("[\\p{L} ]+")) {
                valido = true;
            } else {
                System.out.println("Ingrese solo letras");
            }
        }

        // Se reinicia la variable para validar la cantidad de pedidos
        valido = false;
        int pedidos = 0;

        // Ciclo que solicita y valida la cantidad de pedidos
        while(!valido) {
            try {
                System.out.println("Cantidad de pedidos: ");
                pedidos = sc.nextInt();

                // Verifica que la cantidad de pedidos sea mayor que cero
                if (pedidos > 0) {
                    valido = true;
                } else {
                    System.out.println("Ingresa una cantidad mayor a cero");
                }
            } catch(InputMismatchException e) {
                // Maneja el error cuando se ingresa un dato que no es un número entero
                System.out.println("Error, se debe ingresar un numero entero");
                sc.nextLine();
            }
        }

        // Se crean los objetos de los empleados y se les asigna su nombre y cantidad de pedidos
        Pedidos empleado1 = new Pedidos(nombre1, pedidos);
        Pedidos empleado2 = new Pedidos(nombre2, pedidos);
        Pedidos empleado3 = new Pedidos(nombre3, pedidos);
        Pedidos empleado4 = new Pedidos(nombre4, pedidos);

        // Se inician los cuatro hilos para que los empleados realicen sus pedidos simultáneamente
        empleado1.start();
        empleado2.start();
        empleado3.start();
        empleado4.start();

        try {
            // El método join espera a que todos los empleados terminen de procesar sus pedidos
            empleado1.join();
            empleado2.join();
            empleado3.join();
            empleado4.join();
        } catch(InterruptedException e) {
            // Muestra un mensaje si ocurre un error al esperar la finalización de los hilos
            System.out.println("Error al esperar a los hilos");
        }

        // Mensaje que indica que todos los pedidos han terminado
        System.out.println("\nTodos los pedidos han sido procesados");

        // Se cierra el Scanner
        sc.close();
    }
}
