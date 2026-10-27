/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Biblioteca
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que engloba toda la biblioteca y los "sub"-programas que ya hicimos. 
 */
import java.util.ArrayList;
/**
 * Clase que representa el sistema central de la biblioteca.
 * Administra colecciones de libros, usuarios, empleados bibliotecarios y préstamos.
 */
public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Bibliotecario> empleados;
    private ArrayList<Prestamo> prestamos;
/**
 * Constructor por defecto que inicializa las listas de libros, usuarios,
 * empleados y préstamos de la biblioteca.
 */
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }
/**
 * Busca un libro dentro del catálogo utilizando su número ISBN.
 * 
 * @param isbn El código ISBN del libro a buscar.
 * @return El objeto Libro si es encontrado, o null en caso contrario.
 */
    //Metodos
    public Libro buscarLibro(String isbn){
        for (Libro libro : libros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
/**
 * Busca un libro dentro del catálogo mediante su título y autor (sobrecarga de método).
 * 
 * @param titulo El título del libro.
 * @param autor El autor del libro.
 * @return El objeto Libro si coincide, o null en caso contrario.
 */
    //Sobrecarga Metodos
    public Libro buscarLibro(String titulo, String autor){
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)
                && libro.getAutor().equalsIgnoreCase(autor)){
                return libro;
            }
        }
        return null;
    }
/**
 * Agrega un nuevo libro al catálogo de la biblioteca si este no existe previamente.
 * 
 * @param libro El objeto Libro a agregar.
 */
    public void agregarLibro(Libro libro){
        if (buscarLibro(libro.getIsbn()) != null){
            System.out.println("El libro que desea agregar ya existe.");
        } else{
            libros.add(libro);
            System.out.println("Se ha agregado el libro correctamente al catalogo. ;)");
        }
    }
/**
 * Elimina un libro del catálogo basándose en su número ISBN.
 * 
 * @param isbn El código ISBN del libro a eliminar.
 */
    public void eliminarLibro(String isbn){
        Libro libro = buscarLibro(isbn);
        if (libro == null){
            System.out.println("El libro que intenta eliminar no existe. :(");
        } else{
            libros.remove(libro);
            System.out.println("El libro se ha eliminado correctamente. ;)");
        }
    }
/**
 * Muestra en la consola todos los libros registrados en el catálogo de la biblioteca.
 */
    public void mostrarCatalogo(){
        if (libros.isEmpty()){
            System.out.println("El catalogo esta vacio. :(");
        } else{
            for (Libro libro : libros){
                System.out.println(libro);
            }
        }
    }
/**
 * Busca un usuario registrado en el sistema mediante su número de identificación único.
 * 
 * @param id El identificador único del usuario.
 * @return El objeto Usuario correspondiente, o null si no se encuentra.
 */
    public Usuario buscarUsuario(int id){
        for (Usuario usuario : usuarios){
            if (usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }
/**
 * Registra un nuevo usuario en el sistema si su ID no se encuentra registrado previamente.
 * 
 * @param usuario El objeto Usuario a registrar.
 */
    public void registrarUsuario(Usuario usuario){
        if (buscarUsuario(usuario.getId()) != null){
            System.out.println("El ID del usuario que desea registrar ya se encuentra en el sistema.");
        } else{
            usuarios.add(usuario);
            System.out.println("El ID del usuario nuevo a sido registrado con exito.");
        }
    }
/**
 * Muestra en la consola la información de todos los usuarios registrados en el sistema.
 */
    public void mostrarUsuarios(){
        if (usuarios.isEmpty()){
            System.out.println("No se han encontrado usuarios registrados en el sistema.");
        } else{
            for (Usuario usuario : usuarios){
                usuario.mostrarInformacion();
            } 
        }
    }
/**
 * Registra un nuevo empleado bibliotecario validando que su ID no esté duplicado.
 * 
 * @param bibliotecario El objeto Bibliotecario a registrar.
 */
    public void registrarBibliotecario(Bibliotecario bibliotecario){
        for (Bibliotecario empleado : empleados){
            if (empleado.getId() == bibliotecario.getId()){
                System.out.println("Ya existe un empleado con ese ID.");
                return;
            }
        }

        empleados.add(bibliotecario);
        System.out.println("Empleado registrado correctamente.");

    }
/**
 * Muestra en la consola la información de todos los empleados bibliotecarios registrados.
 */
    public void mostrarBibliotecarios(){
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados.");
        } else{
            for (Bibliotecario bibliotecario : empleados){
                bibliotecario.mostrarInformacion();
            }
        }
    }
/**
 * Busca un préstamo activo en la biblioteca asociado al ISBN de un libro.
 * 
 * @param isbn El código ISBN del libro prestado.
 * @return El objeto Prestamo activo correspondiente, o null si no existe.
 */
    public Prestamo buscarPrestamo(String isbn){
        for (Prestamo prestamo : prestamos){
            if (prestamo.estaActivo() && prestamo.getLibro() != null &&
                prestamo.getLibro().getIsbn() != null && prestamo.getLibro().getIsbn().equalsIgnoreCase(isbn)){
                    return prestamo;
                }
        }

        return null;
    }
/**
 * Realiza el proceso de préstamo de un libro a un usuario, verificando la disponibilidad 
 * del libro y si el usuario se encuentra activo.
 * 
 * @param usuario El usuario que solicita el préstamo.
 * @param libro El libro que se desea prestar.
 */
    public void realizarPrestamo(Usuario usuario, Libro libro){
        if (! libro.estaDisponible()){
            System.out.println("El libro no esta disponible por el momento.");
            return;
        }
        if (! usuario.getActivo()){
            System.out.println("El usuario no esta activo, no se le puede hacer un prestamo.");
            return;
        } 
        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamo.iniciarPrestamo();
        prestamos.add(prestamo);
    }
/**
 * Gestiona la devolución de un libro finalizando su préstamo correspondiente.
 * 
 * @param prestamo El objeto Prestamo a finalizar.
 */
    public void devolverLibro(Prestamo prestamo){
        if (! prestamo.estaActivo()){
            System.out.println("El libro que se intenta devolver ya ha sido devuelto.");
        } else{
            prestamo.finalizarPrestamo();
        }
    }
/**
 * Muestra en la consola el listado de todos los préstamos registrados en el sistema.
 */
    public void mostrarPrestamos(){
        if (prestamos.isEmpty()){
            System.out.println("No hay ningun prestamo, todos los libros se encuentran seguros. :)");
        } else{
            for (Prestamo prestamo : prestamos){
                System.out.println(prestamo);
            }
        }
    }
}
