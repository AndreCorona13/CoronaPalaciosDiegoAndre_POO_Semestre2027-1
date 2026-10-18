/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 4: Clase Libro
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que modela un libro físico, aplicando sobrecarga y variables estáticas.
 */
public class Libro {
    
    // 6.1 Atributos
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    
    // 6.2 Atributo Estático
    private static int totalLibros = 0;

    // 6.3 Constructores (Sobrecarga)
    public Libro() {
        this.disponible = true;
        totalLibros++; // Incrementa el contador global
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
        totalLibros++; // Incrementa el contador global
    }

    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
        totalLibros++; // Incrementa el contador global
    }

    // 6.4 Métodos Operativos
    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Éxito: El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("Error: El libro '" + titulo + "' ya se encuentra prestado.");
        }
    }

    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("Éxito: El libro '" + titulo + "' ha sido devuelto al catálogo.");
        } else {
            System.out.println("Aviso: El libro '" + titulo + "' ya estaba disponible.");
        }
    }

    // Métodos especiales (Getters y Setters)
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    
    // Setter de disponibilidad (se mantiene por si el sistema central lo requiere)
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    // Getter estático para consultar el total de libros creados
    public static int getTotalLibros() {
        return totalLibros;
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "Libro: " + titulo + " | Autor: " + autor + " | Estado: " + estado;
    }
}
