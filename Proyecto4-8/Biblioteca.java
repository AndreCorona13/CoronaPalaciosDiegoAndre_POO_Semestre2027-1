/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Biblioteca
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que engloba toda la biblioteca y los "sub"-programas que ya hicimos. 
 */
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> inventario;
    private ArrayList<PersonaP4> registroPersonas;
    private ArrayList<Prestamo> prestamosActivos;

    public Biblioteca() {
        this.inventario = new ArrayList<>();
        this.registroPersonas = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor) {
        inventario.add(new Libro(titulo, autor));
        System.out.println("Libro registrado en la biblioteca.");
    }

    public void agregarPersona(PersonaP4 persona) {
        registroPersonas.add(persona);
        System.out.println(persona.getClass().getSimpleName() + " registrado con éxito.");
    }

    public void prestarLibro(String titulo, int idUsuario) {
        Libro libroPrestar = null;
        for (Libro lib : inventario) {
            if (lib.getTitulo().equalsIgnoreCase(titulo)) {
                libroPrestar = lib;
                break;
            }
        }

        if (libroPrestar == null) {
            System.out.println("Error: El libro no existe en el inventario.");
            return;
        }
        if (!libroPrestar.isDisponible()) {
            System.out.println("Aviso: El libro ya se encuentra prestado.");
            return;
        }

        Usuario usuarioPrestar = null;
        for (PersonaP4 p : registroPersonas) {
            // Buscamos que sea instancia de Usuario y que el ID (entero) coincida
            if (p instanceof Usuario && p.getId() == idUsuario) {
                usuarioPrestar = (Usuario) p;
                break;
            }
        }

        if (usuarioPrestar == null) {
            System.out.println("Error: Usuario no encontrado o el ID pertenece a un Bibliotecario.");
            return;
        }

        // Validación usando el método de tu clase Usuario
        if (!usuarioPrestar.getActivo()) {
            System.out.println("Error: El usuario no puede solicitar libros porque NO está activo.");
            return;
        }

        // Ejecución
        libroPrestar.setDisponible(false);
        usuarioPrestar.solicitarPrestamo(); // Suma 1 a tu contador
        prestamosActivos.add(new Prestamo(libroPrestar, usuarioPrestar));
        System.out.println("Préstamo realizado exitosamente.");
    }

    public void devolverLibro(String titulo) {
        Prestamo prestamoRemover = null;
        for (Prestamo p : prestamosActivos) {
            if (p.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
                prestamoRemover = p;
                break;
            }
        }

        if (prestamoRemover != null) {
            prestamoRemover.getLibro().setDisponible(true);
            prestamoRemover.getUsuario().devolverLibro(); // Resta 1 a tu contador
            prestamosActivos.remove(prestamoRemover);
            System.out.println("Libro devuelto con éxito.");
        } else {
            System.out.println("Error: El libro no consta como prestado.");
        }
    }

    public void mostrarInventario() {
        System.out.println("\n--- INVENTARIO ---");
        if (inventario.isEmpty()) {
            System.out.println("Biblioteca vacía.");
        } else {
            for (Libro lib : inventario) {
                System.out.println(lib.toString());
            }
        }
    }
    
    public void mostrarUsuarios() {
        System.out.println("\n--- REGISTRO DE PERSONAS ---");
        for (PersonaP4 p : registroPersonas) {
            p.mostrarInformacion(); // Aplica polimorfismo, llama al método específico de cada clase
            System.out.println("--------------------");
        }
    }
}
  
