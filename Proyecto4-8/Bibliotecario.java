/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Bibliotecario
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que hereda de PersonaP4 y define el comportamiento específico del empleado.
 */
public class Bibliotecario extends PersonaP4 {
    
    private String turno;

    public Bibliotecario() {}

    public Bibliotecario(int id, String nombre, String correo, String turno) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.turno = turno;
    }

    // Implementación obligatoria del método abstracto de PersonaP4
    @Override 
    public void mostrarInformacion() {
        System.out.println("--- Perfil Bibliotecario ---");
        System.out.println("ID Empleado: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Turno: " + turno);
    }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
}
