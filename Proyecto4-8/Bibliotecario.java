/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Bibliotecario
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que hereda de PersonaP4 y define el comportamiento específico del empleado.
 */
/**
 * Clase que representa a un empleado bibliotecario, heredando atributos y 
 * comportamientos base de la clase PersonaP4.
 */
public class Bibliotecario extends PersonaP4 {
/**
 * Constructor por defecto de la clase Bibliotecario.
 */    
    // 5.2 Atributos
    private String turno;
    private double salario;

    // Métodos especiales: Constructores
    public Bibliotecario() {}
    /**
     * Constructor parametrizado para inicializar los atributos del bibliotecario,
     * incluyendo tanto los heredados como los específicos de la clase.
     * 
     * @param id Identificador único del bibliotecario.
     * @param nombre Nombre completo del bibliotecario.
     * @param correo Correo electrónico del bibliotecario.
     * @param turno Turno laboral asignado.
     * @param salario Salario mensual del bibliotecario.
     */
    public Bibliotecario(int id, String nombre, String correo, String turno, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.turno = turno;
        this.salario = salario;
    }
        /**
     * Simula la autorización de un préstamo de libro por parte del bibliotecario.
     */
    // 5.3 Métodos operativos
    public void autorizarPrestamo() {
        System.out.println("El bibliotecario " + nombre + " ha autorizado el préstamo del libro.");
    }
        /**
     * Simula el registro de un nuevo libro en el sistema por parte del bibliotecario.
     */
    public void registrarLibro() {
        System.out.println("El bibliotecario " + nombre + " ha registrado un nuevo libro en el sistema.");
    }
        /**
     * Simula la eliminación de un libro del sistema por parte del bibliotecario.
     */
    public void eliminarLibro() {
        System.out.println("El bibliotecario " + nombre + " ha eliminado un libro del sistema.");
    }
    /**
 * Muestra en la consola la información detallada del perfil del bibliotecario.
 */
    @Override 
    public void mostrarInformacion() {
        System.out.println("--- Perfil Bibliotecario ---");
        System.out.println("ID Empleado: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Turno: " + turno);
        System.out.println("Salario: $" + salario);
    }
    /**
 * Obtiene el turno laboral del bibliotecario.
 * 
 * @return El turno actual.
 */

    // Métodos especiales: Getters y Setters
    public String getTurno() { 
        return turno; 
    }
    
    public void setTurno(String turno) { 
        this.turno = turno; 
    }
    /**
 * Obtiene el salario del bibliotecario.
 * 
 * @return El salario actual.
 */
    public double getSalario() { 
        return salario; 
    }
    /**
 * Establece o modifica el salario del bibliotecario.
 * 
 * @param salario El nuevo salario a asignar.
 */
    public void setSalario(double salario) { 
        this.salario = salario; 
    }
}
