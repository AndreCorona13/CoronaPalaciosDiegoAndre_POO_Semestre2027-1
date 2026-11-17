/** Práctica 10: Manejo de excepciones
 * Código 2: Clase validadoresExcepciones.java
 * Fecha: 17 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que contiene los métodos que validan las excepciones de manera dinámica.
 */
/* librerias para entrada/salida */
 import java.util.Scanner;
 /*libreria para manejo de excepciones */
import java.util.InputMismatchException;
/* librerias para manejo de archivos */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;


public class ValidadorExcepciones {

    /*  1. ArithmeticException dinámica */
    public static void probarArithmetic(Scanner scanner) {
        System.out.println("\n--- Probando ArithmeticException ---");
        System.out.print("Ingresa el numerador: ");
        int numerador = scanner.nextInt();
        
        System.out.print("Ingresa el denominador: ");
        int denominador = scanner.nextInt();

        try {
            int resultado = numerador / denominador;
            System.out.println(" Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println(" ¡Excepción atrapada! División por cero no permitida.");
            System.out.println(" Tipo de excepción capturada: " + e.getClass().getName());
            System.out.println("  Mensaje técnico: " + e.getMessage());
        }
    }

    /*  2. InputMismatchException dinámica*/
    public static void probarInputMismatch(Scanner scanner) {
        System.out.println("\n--- Probando InputMismatchException ---");
        System.out.print("Ingresa un número entero (prueba ingresando letras): ");
        
        try {
            int numero = scanner.nextInt();
            System.out.println("BIEN! Ingresaste: " + numero);
        } catch (InputMismatchException e) {
            System.out.println("¡Excepción atrapada! Se esperaba un número entero y recibiste texto.");
            System.out.println("  Tipo de excepción capturada: " + e.getClass().getName());
            System.out.println("  Descripción: Se esperaba un tipo de dato numérico y se recibió texto.");
        } finally {
            scanner.nextLine(); /*Limpiar el buffer */ 
        }
    }
    // 3. NullPointerException dinámica
    public static void probarNullPointerException(Scanner scanner) {
        System.out.println("\n--- Probando NullPointerException ---");
        System.out.print("Escribe una palabra (o escribe 'nulo' para forzar el error): ");
        String texto = scanner.nextLine();

        if (texto.equalsIgnoreCase("nulo")) {
            texto = null; /*  Forzamos que el objeto sea null de manera dinámica*/
        }

        try {
            /*  Intentamos usar un método de un objeto que apunta a null*/
            int longitud = texto.length();
            System.out.println("La longitud de la palabra es: " + longitud);
        } catch (NullPointerException e) {
            System.out.println("¡Excepción atrapada! Intentaste operar sobre un objeto que es null (no inicializado).");
            System.out.println("  Tipo de excepción capturada: " + e.getClass().getName());
            System.out.println("  Detalle: Intento de acceder a un objeto nulo.");
        }
    }

    /* 4. NumberFormatException dinámica */
    public static void probarNumberFormatException(Scanner scanner) {
        System.out.println("\n--- Probando NumberFormatException ---");
        System.out.print("Ingresa un texto para convertirlo a número entero (ej. '45' o 'abc'): ");
        String entrada = scanner.nextLine();

        try {
            int numeroConvertido = Integer.parseInt(entrada);
            System.out.println("¡Conversión exitosa! El número es: " + numeroConvertido);
        } catch (NumberFormatException e) {
            System.out.println(" ¡Excepción atrapada! El texto ingresado no tiene un formato numérico válido.");
            System.out.println("  Tipo de excepción capturada: " + e.getClass().getName());
            System.out.println("  Detalle: " + e.getMessage());
        }
    }
    /* 5. FileNotFoundException dinámica */
   public static void probarFileNotFoundException(Scanner scanner) {
        System.out.println("\n--- Probando FileNotFoundException ---");
        System.out.print("Ingresa el nombre del archivo que deseas abrir: ");
        String nombreArchivo = scanner.nextLine();

        try {
            java.io.FileReader archivo = new java.io.FileReader(nombreArchivo);
            System.out.println(" ¡Archivo encontrado!");
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("¡Excepción atrapada!");
            System.out.println(" Tipo de excepción capturada: " + e.getClass().getName());
            System.out.println(" Detalle técnico: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error general de E/S: " + e.getClass().getName());
        }
    }

    /* 6. IOException dinámica */
    public static void probarIOException(Scanner scanner) {
        System.out.println("\n--- Probando IOException ---");
        System.out.println("Vamos a forzar un error de E/S intentando leer de un lector ya cerrado.");
        
        try {
            /*  Creamos un archivo temporal o simulamos el error cerrando el flujo antes de leer*/
            java.io.BufferedReader lector = new java.io.BufferedReader(new java.io.StringReader("Texto de prueba"));
            lector.close(); // Cerramos el lector inmediatamente
            
            /*  Intentamos leer cuando ya está cerrado para forzar la IOException*/
            String linea = lector.readLine(); 
            System.out.println("Línea leída: " + linea);
            
        } catch (IOException e) {
            System.out.println(" ¡Excepción atrapada! Ocurrió un error de Entrada/Salida (IOException): " + e.getMessage());
            System.out.println(" Tipo de excepción capturada: " + e.getClass().getName());
            System.out.println(" Detalle técnico: " + e.getMessage());
        }
    }
}
