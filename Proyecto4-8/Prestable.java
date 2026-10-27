/**
 * Interfaz que define las operaciones básicas de préstamo y devolución
 * para los elementos que pueden ser prestados en el sistema de la biblioteca.
 */
public interface Prestable{
    /**
 * Realiza la acción de prestar el elemento, cambiando su disponibilidad.
 */
    void prestar();
    /**
 * Realiza la acción de devolver el elemento al catálogo, restaurando su disponibilidad.
 */
    void devolver();
}
