
/** Práctica 12: Hilos
 * Código 3: Clase ManejoExcepcionesApp.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que inicia la carrera de automóviles mediante la ejecución de varios hilos
 */

/** Clase principal del programa */
public class Main { 
    public static void main(String[] args) {

        // Se crea un objeto Carrera para administrar los resultados
        Carrera carrera = new Carrera();

        // Se crean los automóviles y se les asigna un nombre, distancia inicial y la carrera
        Auto auto1 = new Auto("Ferrari", 0, carrera);
        Auto auto2 = new Auto("Bugatti", 0, carrera);
        Auto auto3 = new Auto("Koenigsegg", 0, carrera);
        Auto auto4 = new Auto("McLaren", 0, carrera);
        Auto auto5 = new Auto("Porsche", 0, carrera);
        Auto auto6 = new Auto("Pagani", 0, carrera);
        Auto auto7 = new Auto("Lamborghini", 0, carrera);

        // Mensaje de inicio de la carrera
        System.out.println("\n\t\t\t\t----Que comience la carrera----\n");

        // Se inician los hilos para que todos los automóviles comiencen a correr
        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
        auto6.start();
        auto7.start();

        try {
            // El método join espera a que cada automóvil termine su recorrido
            auto1.join();
            auto2.join();
            auto3.join();
            auto4.join();
            auto5.join();
            auto6.join();
            auto7.join();
        } catch(InterruptedException e) {
            // Muestra un mensaje si ocurre un error al esperar los hilos
            System.out.println("Error al esperar los hilos");
        }

        // Se muestran los resultados cuando todos los automóviles han terminado
        carrera.mostrarResultados();
    }
}
