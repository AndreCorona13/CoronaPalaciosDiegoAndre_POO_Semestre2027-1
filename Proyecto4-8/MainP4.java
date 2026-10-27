/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Main
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa de "interfaz" principal del diagrama actividad
 */

import java.util.Scanner;
/**
 * Clase principal que gestiona la interfaz de usuario mediante consola
 * para el sistema de biblioteca, implementando un menú interactivo con validaciones.
 */
public class MainP4 {
    /**
 * Método principal que ejecuta el ciclo del menú interactivo del sistema,
 * permitiendo registrar elementos, realizar operaciones de préstamo y consultar catálogos.
 * 
 * @param args Argumentos de la línea de comandos.
 */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Registrar Bibliotecario");
            System.out.println("4. Buscar libro por título y autor");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("6. Prestar libro");
            System.out.println("7. Devolver libro");
            System.out.println("8. Mostrar catálogo");
            System.out.println("9. Eliminar libro");
            System.out.println("10. Mostrar personas registradas");
            System.out.println("11. Mostrar libros prestados");
            System.out.println("12. Mostrar lista de empleados");
            System.out.println("0. Salir");
            System.out.print("Digite la opción deseada: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1: {
                    System.out.print("\n\t\t---Registrar Libro---");

                    System.out.println("ISBM: ");
                    String isbn = entrada.nextLine().trim();
                    System.out.println("Título: ");
                    String titulo = entrada.nextLine().trim();
                    System.out.println("Autor: ");
                    String autor = entrada.nextLine().trim();

                    if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()){
                        System.out.println("ERROR: Los datos son obligatorios.");
                        break;
                    }

                    int anioPublicacion;
                    
                    try {
                        System.out.println("Año de publicación: ");
                        anioPublicacion = Integer.parseInt(entrada.nextLine().trim());
                    } catch (NumberFormatException e){
                        System.out.println("ERROR: El año debe ser de formato YYYY");
                        break;
                    }

                    if (anioPublicacion <= 0 || anioPublicacion > 2026){
                        System.out.println("ERROR: El año tiene que ser mayor a cero y menor al año en curso.");
                        break;
                    }

                    Libro libro = new Libro(isbn, titulo, autor, anioPublicacion);
                    biblioteca.agregarLibro(libro);

                    break;
                }

                case 2: {
                    System.out.println("\n\t\t---Registro de Usuarios---");

                    int id;
                    try {
                        System.out.println("ID: ");
                        id = Integer.parseInt(entrada.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: El ID debe ser un numero entero.");
                        break;
                    }
                    if (id <= 0){
                        System.out.println("ERROR: El ID debe de ser mayor a cero.");
                        break;
                    }

                    System.out.println("Nombre: ");
                    String nombre = entrada.nextLine().trim();
                    System.out.println("Correo: ");
                    String correo = entrada.nextLine().trim();
                    System.out.println("¿Está activo? (s/n): ");
                    String respuesta = entrada.nextLine().trim().toLowerCase();

                    if (nombre.isEmpty() || correo.isEmpty()){
                        System.out.println("ERROR: El nombre y el correo son obligatorios.");
                        break;
                    }

                    if (!respuesta.equals("s") && !respuesta.equals("n")){
                        System.out.println("ERROR: Responda unicamente 's' o 'n'.");
                        break;
                    }
                    
                    boolean activo = respuesta.equals("s");
                    Usuario usuario = new Usuario(id, nombre, correo, activo);
                    biblioteca.registrarUsuario(usuario);

                    break;
                }
                    
                case 3: {
                    System.out.println("\n\t\t---Registrar Nuevo Bibliotecario---");

                    int id;

                    try {
                        System.out.println("ID: ");
                        id = Integer.parseInt(entrada.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: El ID debe ser un numero entero.");
                        break;
                    }

                    if (id <= 0){
                        System.out.println("ERROR: El ID debe de ser mayor a cero.");
                        break;
                    }

                    System.out.println("Nombre: ");
                    String nombre = entrada.nextLine().trim();
                    System.out.println("Correo: ");
                    String correo = entrada.nextLine().trim();
                    System.out.println("Turno: ");
                    String turno = entrada.nextLine().trim();

                    if (nombre.isEmpty() || correo.isEmpty() || turno.isEmpty()){
                        System.out.println("ERROR: Revisar los datos ingresados.");
                        break;
                    }

                    double salario;
                    try {
                        System.out.print("Salario: ");
                        salario = Double.parseDouble(entrada.nextLine().trim());
                    } catch (NumberFormatException e){
                        System.out.println("ERROR: Ingrese un valor numerico.");
                        break;
                    }

                    if (!Double.isFinite(salario) || salario <= 0){
                        System.out.println("ERROR: El salario debe ser mayor a cero y finito.");
                        break;
                    }

                    Bibliotecario bibliotecario = new Bibliotecario(id, nombre, correo, turno, salario);
                    biblioteca.registrarBibliotecario(bibliotecario);

                    break;
                }

                case 4: {
                    System.out.println("\n\t\t---Buscar Libro por Título y Autor---");

                        System.out.print("Título: ");
                        String titulo = entrada.nextLine().trim();
                        System.out.print("Autor: ");
                        String autor = entrada.nextLine().trim();

                        if (titulo.isEmpty() || autor.isEmpty()){
                            System.out.print("ERROR: El titulo y el autor son obligatorios.");
                        
                        break;
                        }

                        Libro libro = biblioteca.buscarLibro(titulo, autor);
                        if (libro == null){
                            System.out.println("No se encontró el libro.");
                        } else{
                            System.out.println(libro);
                        }
                        
                        break;

                }

                case 5: {
                    System.out.println("\n\t\t---Buscar Libro por ISBN---");
                    System.out.println("ISBN: ");
                    String isbn = entrada.nextLine().trim();

                    if (isbn.isEmpty()){
                        System.out.println("ERROR: El ISBN no puede estar vacío.");
                        break;
                    }

                    Libro libro = biblioteca.buscarLibro(isbn);

                    if (libro == null){
                        System.out.println("No se encontró el libro.");
                    } else{
                        System.out.println(libro);
                    }

                    break;
                }

                case 6: {
                    System.out.println("\n\t\t---Prestamo de un Libro---");
                    
                    int id;

                    try {
                        System.out.println("ID del usuario: ");
                        id = Integer.parseInt(entrada.nextLine().trim());
                    } catch (NumberFormatException e){
                        System.out.println("ERROR: El ID debe de ser un numero entero.");
                        break;
                    }

                    if (id <= 0){
                        System.out.println("ERROR: ID no válido.");
                        break;
                    }

                    Usuario usuario = biblioteca.buscarUsuario(id);

                    if (usuario == null){
                        System.out.println("No existe un usuario con ese ID en el sistema.");
                        break;
                    }

                    System.out.println("Proporcione el ISBN del libro: ");
                    String isbn = entrada.nextLine().trim();

                    if (isbn.isEmpty()){
                        System.out.println("ERROR: El ISBN no puede quedar vacío.");
                        break;
                    }

                    Libro libro = biblioteca.buscarLibro(isbn);

                    if (libro == null){
                        System.out.println("No existe un libro con ese ISBN. ");
                        break;
                    }

                    if (!usuario.getActivo()){
                        System.out.print("El usuario está inactivo.");
                        break;
                    }

                    if (!libro.estaDisponible()){
                        System.out.println("El libro ya está prestado.");
                        break;
                    }

                    biblioteca.realizarPrestamo(usuario, libro);

                    break;
                }

                case 7: {
                    System.out.println("\n\t\t---Devolucion de un Libro---");

                    System.out.println("Proporcione el ISBN del libro: ");
                    String isbn = entrada.nextLine().trim();

                    if (isbn.isEmpty()){
                        System.out.println("ERROR: El ISBN no puede quedar vacío.");
                        break;
                    }

                    Libro libro = biblioteca.buscarLibro(isbn);

                    if (libro == null){
                        System.out.println("No se encontro el ISBN del libro.");
                        break;
                    }

                    Prestamo prestamo = biblioteca.buscarPrestamo(isbn);

                    if (prestamo == null){
                        System.out.println("El libro no tiene un préstamo activo.");
                        break;
                    }

                    biblioteca.devolverLibro(prestamo);

                    break;
                }

                case 8: {
                    System.out.println("\n\t\t---Catálogo de la Biblioteca---");
                    biblioteca.mostrarCatalogo();
                    break;
                }
                    
                case 9: {
                    System.out.println("\n\t\t---Eliminar un Libro---");

                    System.out.println("Proporcione el ISBN del libro: ");
                    String isbn = entrada.nextLine().trim();

                    if (isbn.isEmpty()){
                        System.out.print("ERROR: El ISBN no puede estar vacío.");
                        break;
                    }

                    Libro libro = biblioteca.buscarLibro(isbn);

                    if (libro == null){
                        System.out.println("No se encontro el libro.");
                    } else if(!libro.estaDisponible()){
                        System.out.println("No se puede eliminar un libro prestado.");
                    } else {
                        biblioteca.eliminarLibro(isbn);
                    }

                    break;
                }

                case 10: {
                    System.out.println("\n\t\t---Personas Registradas en la Biblioteca---");
                    biblioteca.mostrarUsuarios();

                    break;
                }

                case 11: {
                    System.out.println("\n\t\t---Libros Prestados---");
                    biblioteca.mostrarPrestamos();

                    break;
                }

                case 12: {
                    System.out.println("\n\t\t---Lista de Empleados---");
                    biblioteca.mostrarBibliotecarios();
                    
                    break;
                }

                case 0: {
                    System.out.println("\n\t\t---Salir del Sistema---");
                    System.out.println("Saliendo del sistema...");

                    ejecutando = false;

                    break;
                }

                default:
                    System.out.println("Opción no válida, seleccione una opcion del 0 al 12");
            }
        }
        entrada.close();
        System.out.println("Programa finalizado. :(");
    }
}
