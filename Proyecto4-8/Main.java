/** Práctica 4-8: Sistema de Gestión de Biblioteca
 * Código 3: Clase Main
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa de "interfaz" principal del diagrama actividad
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Biblioteca miBiblioteca = new Biblioteca();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Registrar Bibliotecario");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Mostrar inventario");
            System.out.println("7. Mostrar personas registradas");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = entrada.nextLine().trim();
                    System.out.print("Autor: ");
                    String autor = entrada.nextLine().trim();
                    if (!titulo.isEmpty() && !autor.isEmpty()) {
                        miBiblioteca.agregarLibro(titulo, autor);
                    }
                    break;
                case 2:
                    try {
                        System.out.print("ID del usuario (Número): ");
                        int idUsu = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Nombre: ");
                        String nomUsu = entrada.nextLine().trim();
                        System.out.print("Correo: ");
                        String correoUsu = entrada.nextLine().trim();
                        System.out.print("El usuario está activo? (true/false): ");
                        boolean activoUsu = Boolean.parseBoolean(entrada.nextLine().trim());
                        
                        miBiblioteca.agregarPersona(new Usuario(idUsu, nomUsu, correoUsu, activoUsu));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un número entero.");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("ID de empleado (Número): ");
                        int idBib = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Nombre: ");
                        String nomBib = entrada.nextLine().trim();
                        System.out.print("Correo: ");
                        String correoBib = entrada.nextLine().trim();
                        System.out.print("Turno (Matutino/Vespertino): ");
                        String turnoBib = entrada.nextLine().trim();
                        
                        miBiblioteca.agregarPersona(new Bibliotecario(idBib, nomBib, correoBib, turnoBib));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un número entero.");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Título del libro a prestar: ");
                        String tituloPrestar = entrada.nextLine().trim();
                        System.out.print("ID del usuario (Número): ");
                        int idPrestar = Integer.parseInt(entrada.nextLine().trim());
                        miBiblioteca.prestarLibro(tituloPrestar, idPrestar);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El ID debe ser un número entero.");
                    }
                    break;
                case 5:
                    System.out.print("Título del libro a devolver: ");
                    String tituloDevolver = entrada.nextLine().trim();
                    miBiblioteca.devolverLibro(tituloDevolver);
                    break;
                case 6:
                    miBiblioteca.mostrarInventario();
                    break;
                case 7:
                    miBiblioteca.mostrarUsuarios();
                    break;
                case 8:
                    ejecutando = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        entrada.close();
    }
}
