
/** Práctica 12: Hilos
 * Código 4: Clase Auto.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Clase que representa a un empleado que realiza pedidos mediante la ejecución de un hilo.
 */
public class Pedidos extends Thread {
    
    // Atributos del empleado y la cantidad de pedidos que debe realizar
    private String nombre;
    private int numPedidos;

    /** Constructor vacío */
    public Pedidos() {}

    /** Constructor que inicializa el nombre y el número de pedidos */
    public Pedidos(String nombre, int numPedidos) {
        this.nombre = nombre;
        this.numPedidos = numPedidos;
    }

    /** Métodos setters para modificar los atributos */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    /** Métodos getters para obtener los atributos */
    public String getNombre() {
        return nombre;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    /** Método run que ejecuta el proceso de realización de pedidos */
    @Override
    public void run() {

        // Ciclo que se repite según la cantidad de pedidos asignados
        for(int i = 1; i <= numPedidos; i++) {

            // Muestra el nombre del empleado y el pedido que está realizando
            System.out.println("\n" + nombre + " esta realizando el pedido " + i + "\n");

            // Genera un tiempo aleatorio entre 1000 y 2000 milisegundos
            int tiempo = (int)(Math.random() * 1001) + 1000;

            try {
                // Pausa el hilo durante el tiempo generado
                Thread.sleep(tiempo);
            } catch(InterruptedException e) {
                // Muestra un mensaje si el proceso es interrumpido
                System.out.println("Proceso interrumpido");
                return;
            }

            // Muestra un mensaje cuando el pedido ha terminado
            System.out.println(nombre + " termino el pedido " + i + "\n");
        }
    }
} 
