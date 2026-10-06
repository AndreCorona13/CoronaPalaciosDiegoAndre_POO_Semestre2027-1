/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Prestamo
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que diga quien tiene el préstamo.
 */

public class Prestamo {
    private Libro libro;
    private Usuario usuario;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }

    @Override
    public String toString() {
        return "Préstamo activo -> Libro: [" + libro.getTitulo() + "] a cargo de ID: " + usuario.getId() + " (" + usuario.getNombre() + ")";
    }
}
