/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Bibliotecario
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que hereda de PersonaP4 y define el comportamiento específico del empleado.
 */
public class Bibliotecario extends PersonaP4 {
    
    // 5.2 Atributos
    private String turno;
    private double salario;

    // Métodos especiales: Constructores
    public Bibliotecario() {}

    public Bibliotecario(int id, String nombre, String correo, String turno, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.turno = turno;
        this.salario = salario;
    }

    // 5.3 Métodos operativos
    public void autorizarPrestamo() {
        System.out.println("El bibliotecario " + nombre + " ha autorizado el préstamo del libro.");
    }

    public void registrarLibro() {
        System.out.println("El bibliotecario " + nombre + " ha registrado un nuevo libro en el sistema.");
    }

    public void eliminarLibro() {
        System.out.println("El bibliotecario " + nombre + " ha eliminado un libro del catálogo.");
    }

    // Implementación obligatoria del método abstracto
    @Override 
    public void mostrarInformacion() {
        System.out.println("--- Perfil Bibliotecario ---");
        System.out.println("ID Empleado: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Turno: " + turno);
        System.out.println("Salario: $" + salario);
    }

    // Métodos especiales: Getters y Setters
    public String getTurno() { 
        return turno; 
    }
    
    public void setTurno(String turno) { 
        this.turno = turno; 
    }
    
    public double getSalario() { 
        return salario; 
    }
    
    public void setSalario(double salario) { 
        this.salario = salario; 
    }
}
