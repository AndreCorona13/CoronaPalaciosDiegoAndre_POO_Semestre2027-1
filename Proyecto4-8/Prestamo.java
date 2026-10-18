/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 5: Clase Prestamo
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que representa la relación entre un usuario y un libro, 
 * aplicando composición y comunicación entre objetos.
 */
import java.time.LocalDate;

public class Prestamo {
    
    // 7.1 Atributos
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean activo;

    // 7.2 Constructor
    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.activo = false; // Se inicializa inactivo hasta llamar a iniciarPrestamo()
    }

    // 7.3 y 7.4 Métodos Operativos y Comunicación Entre Objetos
    public void iniciarPrestamo() {
        // Interacción directa con los objetos contenidos
        libro.prestar();
        usuario.solicitarPrestamo();
        
        this.activo = true;
        this.fechaPrestamo = LocalDate.now().toString(); // Asigna la fecha actual
        this.fechaDevolucion = "Pendiente";
        System.out.println("-> Registro interno: Préstamo iniciado el " + fechaPrestamo);
    }

    public void finalizarPrestamo() {
        // Interacción directa para revertir los estados
        libro.devolver();
        usuario.devolverLibro();
        
        this.activo = false;
        this.fechaDevolucion = LocalDate.now().toString(); // Registra cuándo se entregó
        System.out.println("-> Registro interno: Préstamo finalizado el " + fechaDevolucion);
    }

    public boolean estaActivo() {
        return activo;
    }

    // Métodos especiales (Getters y Setters)
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    public String getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public String getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(String fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public void setActivo(boolean activo) { this.activo = activo; }
}
