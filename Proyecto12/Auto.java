
/** Práctica 12: Hilos
 * Código 1: Clase Auto.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Clase que representa un automóvil dentro de la carrera y permite ejecutar su recorrido mediante un hilo.
 */
public class Auto extends Thread {

    // Atributos del automóvil
    private String nombre;
    private float distancia;
    private Carrera carrera;

    /** Constructor vacío */
    public Auto() {}

    /** Constructor que inicializa los atributos del automóvil */
    public Auto(String nombre, float distancia, Carrera carrera) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.carrera = carrera;
    }

    /** Métodos setters para modificar los atributos */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    /** Métodos getters para obtener los atributos */
    public String getNombre(){
        return nombre;
    }

    public float getDistancia() {
        return distancia;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    /** Método run que ejecuta el recorrido del automóvil mediante un hilo */
    @Override
    public void run() {
        // El automóvil avanza mientras no alcance los 100 metros
        while (distancia < 100) {

            // Genera un avance aleatorio entre 5 y 15 metros
            int avance = (int)(Math.random() * 11) + 5;

            // Se actualiza la distancia recorrida
            distancia += avance;
            
            // Muestra el avance del automóvil y su distancia total
            System.out.println("\n| " + nombre + " avanzo: " + avance + 
                " metros |\t| Distancia total: " + distancia + " metros |");

            try {
                // Pausa el hilo durante 500 milisegundos
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Muestra un mensaje si el hilo es interrumpido
                System.out.println("Hilo Interrumpido");
            }
        }

        // Registra el nombre del automóvil cuando termina su recorrido
        carrera.registrarGanador(nombre);
    }
}
