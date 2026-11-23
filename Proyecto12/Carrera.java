/** Práctica 12: Hilos
 * Código 2: Clase ManejoExcepcionesApp.java
 * Fecha: 22 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Clase que administra los resultados de la carrera 
 */

import java.util.ArrayList; /** Librería que permite almacenar los resultados en una lista */

public class Carrera {

    // Lista que almacena los nombres de los automóviles según su llegada
    private ArrayList<String> resultados = new ArrayList<>();

    /** Constructor vacío */
    public Carrera() {}

    /** Constructor que inicializa la lista de resultados */
    public Carrera(ArrayList<String> resultados) {
        this.resultados = resultados;
    }

    /** Método setter para modificar la lista de resultados */
    public void setResultados(ArrayList<String> resultados) {
        this.resultados = resultados;
    }

    /** Método getter para obtener la lista de resultados */
    public ArrayList<String> getResultados() {
        return resultados;
    }

    /** Método sincronizado que registra al automóvil ganador */
    public synchronized void registrarGanador(String nombre) {

        // Agrega el nombre del automóvil a la lista de resultados
        resultados.add(nombre);
    }

    /** Método que muestra los resultados finales de la carrera */
    public void mostrarResultados() {
        System.out.println("\n\t   ----Resultados----");

        // Recorre la lista y muestra la posición y el nombre de cada automóvil
        for(int i = 0; i < resultados.size(); i++) {
            System.out.println((i + 1) + ". " + resultados.get(i));
        }
        System.out.println("\n\t----Fin de la Carrera----\n");
    }
}
 
