/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 4: Clase Libro
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que modela un libro físico, aplicando sobrecarga y variables estáticas.
 */

/**
 * Clase que modela un libro físico dentro del sistema de la biblioteca,
 * implementando la interfaz Prestable y gestionando contadores estáticos.
 */
public class Libro implements Prestable {
    
    // 6.1 Atributos
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    
    // 6.2 Atributo Estático
    private static int totalLibros = 0;
/**
 * Constructor por defecto de la clase Libro.
 */
    // 6.3 Constructores (Sobrecarga)
    public Libro() {}
    /**
 * Constructor parametrizado que inicializa el título y autor del libro,
 * estableciendo su disponibilidad como verdadera e incrementando el contador global.
 * 
 * @param titulo El título del libro.
 * @param autor El autor del libro.
 */
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        totalLibros++; // Incrementa el contador global
    }
/**
 * Constructor parametrizado que inicializa todos los atributos principales del libro,
 * configurando su disponibilidad e incrementando el contador global.
 * 
 * @param isbn El código ISBN del libro.
 * @param titulo El título del libro.
 * @param autor El autor del libro.
 * @param anioPublicacion El año de publicación del libro.
 */
    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
        totalLibros++; // Incrementa el contador global
    }
    /**
     * Verifica si el libro se encuentra disponible para préstamo.
     * 
     * @return true si el libro está disponible, false en caso contrario.
     */
    // 6.4 Métodos Operativos
    public boolean estaDisponible() {
        return disponible;
    }
    /**
     * Cambia el estado del libro a no disponible si este se encontraba libre,
     * o muestra un mensaje de error si ya estaba prestado.
     */
    @Override
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Éxito: El libro " + titulo + "' ha sido prestado.");
        } else {
            System.out.println("Error: El libro " + titulo + "' ya se encuentra prestado.");
        }
    }
        /**
     * Restaura la disponibilidad del libro al ser devuelto al catálogo,
     * o emite un aviso si ya se encontraba disponible.
     */
    @Override
    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("Éxito: El libro '" + titulo + "' ha sido devuelto al catálogo.");
        } else {
            System.out.println("Aviso: El libro  '" + titulo + "' ya estaba disponible.");
        }
    }
        /**
     * Obtiene el código ISBN del libro.
     * 
     * @return El ISBN actual.
     */
    // Métodos especiales (Getters y Setters)
    public String getIsbn() { return isbn; }
        /**
     * Establece o modifica el código ISBN del libro.
     * 
     * @param isbn El nuevo ISBN a asignar.
     */
    public void setIsbn(String isbn) { this.isbn = isbn; }
        /**
     * Obtiene el título del libro.
     * 
     * @return El título actual.
     */
    public String getTitulo() { return titulo; }
        /**
     * Obtiene el título del libro.
     * 
     * @return El título actual.
     */
    public void setTitulo(String titulo) { this.titulo = titulo; }
        /**
     * Obtiene el autor del libro.
     * 
     * @return El nombre del autor.
     */
    public String getAutor() { return autor; }
        /**
     * Establece o modifica el autor del libro.
     * 
     * @param autor El nuevo autor a asignar.
     */
    public void setAutor(String autor) { this.autor = autor; }
        /**
     * Obtiene el año de publicación del libro.
     * 
     * @return El año de publicación.
     */
    public int getAnioPublicacion() { return anioPublicacion; }
        /**
 * Establece o modifica el año de publicación del libro.
 * 
 * @param anioPublicacion El nuevo año de publicación.
 */
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    /**
 * Establece de forma directa el estado de disponibilidad del libro.
 * 
 * @param disponible El estado de disponibilidad booleano.
 */
    // Setter de disponibilidad (se mantiene por si el sistema central lo requiere)
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    /**
     * Obtiene el número total de instancias de libros creadas en el sistema.
     * 
     * @return El conteo global de libros.
     */
    // Getter estático para consultar el total de libros creados
    public static int getTotalLibros() {
        return totalLibros;
    }
    /**
     * Devuelve una representación en cadena con los detalles principales del libro,
     * incluyendo su título, autor y estado actual.
     * 
     * @return Una cadena formateada con la información del libro.
     */
    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "Libro: " + titulo + " | Autor: " + autor + " | Estado: " + estado;
    }
}
