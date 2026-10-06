/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Libro
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que pide los datos de un libro y si está disponible. 
 */

public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponible() { return disponible; }
    
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "Libro: " + titulo + " | Autor: " + autor + " | Estado: " + estado;
    }
}

public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponible() { return disponible; }
    
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Prestado";
        return "Libro: " + titulo + " | Autor: " + autor + " | Estado: " + estado;
    }
}
