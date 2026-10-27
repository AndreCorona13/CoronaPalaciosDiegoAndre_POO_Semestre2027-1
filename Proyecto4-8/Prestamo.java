/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 5: Clase Prestamo
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que representa la relación entre un usuario y un libro, 
 * aplicando composición y comunicación entre objetos.
 */
import java.time.LocalDate; //Para ver que show con la fecha en nuestro programa

/**
 * Clase que modela la relación de préstamo entre un usuario y un libro,
 * aplicando composición, manejo de fechas y comunicación entre objetos.
 */
public class Prestamo {
    
    // 7.1 Atributos
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean activo;

    /**
 * Constructor parametrizado que inicializa el préstamo con un usuario y un libro,
 * estableciendo inicialmente el estado del préstamo como inactivo.
 * 
 * @param usuario El usuario que solicita el préstamo.
 * @param libro El libro que va a ser prestado.
 */
    // 7.2 Constructor
    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.activo = false; // Se inicializa inactivo hasta llamar a iniciarPrestamo()
    }
    
    /**
 * Inicia el proceso de préstamo interactuando directamente con los objetos 
 * relacionados (libro y usuario), activando el estado y registrando la fecha actual.
 */
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
    /**
     * Finaliza el préstamo actual, revirtiendo el estado de disponibilidad del libro
     * y del usuario, y registrando la fecha de devolución.
     */
    public void finalizarPrestamo() {
        // Interacción directa para revertir los estados
        libro.devolver();
        usuario.devolverLibro();
        
        this.activo = false;
        this.fechaDevolucion = LocalDate.now().toString(); // Registra cuándo se entregó
        System.out.println("-> Registro interno: Préstamo finalizado el " + fechaDevolucion);
    }
    /**
 * Verifica si el préstamo se encuentra actualmente activo.
 * 
 * @return true si el préstamo está activo, false en caso contrario.
 */
    public boolean estaActivo() {
        return activo;
    }

    // Métodos especiales (Getters y Setters)
    /**
 * Obtiene el usuario asociado al préstamo.
 * 
 * @return El objeto Usuario correspondiente.
 */
    public Usuario getUsuario() { return usuario; }
    /**
 * Establece o modifica el usuario asociado al préstamo.
 * 
 * @param usuario El nuevo usuario a asignar.
 */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
/**
 * Obtiene el libro asociado al préstamo.
 * 
 * @return El objeto Libro correspondiente.
 */
    public Libro getLibro() { return libro; }
    /**
 * Establece o modifica el libro asociado al préstamo.
 * 
 * @param libro El nuevo libro a asignar.
 */
    public void setLibro(Libro libro) { this.libro = libro; }
/**
 * Obtiene la fecha en que se realizó el préstamo.
 * 
 * @return La fecha de préstamo en formato de cadena.
 */
    public String getFechaPrestamo() { return fechaPrestamo; }
    /**
 * Establece o modifica la fecha de préstamo.
 * 
 * @param fechaPrestamo La nueva fecha de préstamo a asignar.
 */
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
/**
 * Obtiene la fecha de devolución del libro.
 * 
 * @return La fecha de devolución o el estado pendiente.
 */
    public String getFechaDevolucion() { return fechaDevolucion; }
    /**
 * Establece o modifica la fecha de devolución.
 * 
 * @param fechaDevolucion La nueva fecha de devolución a asignar.
 */
    public void setFechaDevolucion(String fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
/**
 * Establece de forma directa el estado de activación del préstamo.
 * 
 * @param activo El estado booleano de activación.
 */
    public void setActivo(boolean activo) { this.activo = activo; }
/**
 * Devuelve una representación en cadena con los detalles completos del préstamo,
 * incluyendo usuario, libro, fechas y estado de activación.
 * 
 * @return Una cadena formateada con la información del préstamo.
 */
    @Override
    public String toString() {
        return "Usuario " + usuario + " | Libro: " + 
            libro + " | Fecha de prestamo: " + fechaPrestamo + 
            " | Fecha de devolucion: " + fechaDevolucion + 
            " | Activo: " + activo;
    }
}
