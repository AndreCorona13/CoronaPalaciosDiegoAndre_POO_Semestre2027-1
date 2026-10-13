// CLASE PRINCIPAL (Punto de entrada)
import java.util.Scanner;
import java.util.InputMismatchException;

public class PracticaPOO { //El nucleo
//public que está accesible chido, static que pertenece a la clase sin crear un "new" nombre de clase
    public static void main(String[] args) { //main es clave xd
        // Variables declaradas estrictamente al inicio del bloque principal
        Scanner scanner = new Scanner(System.in);
        
        //Nos preparamos para la ejecución
        int opcion = 0;
        boolean salir = false;
        boolean entradaValida = false;

        String marcaConsola = "";
        double precioConsola = 0.0;
        String respuestaJuego = "";
        boolean conJuego = false;

        Consola miConsola = null;
        Teclado miTeclado = new Teclado(); 
        Laptop miLaptop = new Laptop("TechBrand (marca)", 15000.50, "Core i7"); 

        System.out.println("=== SISTEMA DE DEMOSTRACIÓN DE POO ===");

        // Menú principal con validaciones
        while (!salir) { //Ese !salir = Mientras NO haya que salir, se repite. ! = NO
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Registrar una Consola (Prueba Override y Validaciones)");
            System.out.println("2. Ver demostración de los 4 conceptos");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            // Validación Antierrores para la opción del menú
            entradaValida = false;
            while (!entradaValida) {
                try { //Intentar algo que puede fallar (usuario tonto)
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    entradaValida = true;
                } catch (InputMismatchException e) { //Si el try falla, lo dice, el "e" guarda el error
                    System.out.print("¡Error! Ingrese un número entero válido. Intente de nuevo: ");
                    scanner.nextLine(); // Limpiar el buffer (error) corrupto, si fuera el caso
                }
            }

            if (opcion == 1) {
                // Validación para cadena de texto
                System.out.print("Ingrese la marca de la consola: ");
                marcaConsola = scanner.nextLine();

                // Validación Antierrores para el precio (Double)
                entradaValida = false;
                while (!entradaValida) { //
                    System.out.print("Ingrese el precio (con decimales): ");
                    try {
                        precioConsola = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar buffer
                        if (precioConsola < 0) {
                            System.out.println("El precio no puede ser negativo.");
                        } else {
                            entradaValida = true;
                        }
                    } catch (InputMismatchException e) { //lo mismo que arriba
                        System.out.println("¡Error! Debe ingresar un valor numérico (ej. 5999.99).");
                        scanner.nextLine(); //"bye bye Israel!"
                    }
                }

                // Validación Antierrores para entrada booleana customizada
                entradaValida = false;
                while (!entradaValida) { //El mientras NO sea valida
                    System.out.print("¿Incluye juego de regalo? (si/no): ");
                    respuestaJuego = scanner.nextLine().toLowerCase(); //Nerfeamos al usuario con minusculas
                    //El == compara referencias (mismo objeto?), el .equals compara contenido (mismo texto?).
                    if (respuestaJuego.equals("si") || respuestaJuego.equals("no")) { 
                        conJuego = respuestaJuego.equals("si");
                        entradaValida = true;
                    } else {
                        System.out.println("¡Error! Responda únicamente 'si' o 'no'.");
                    }
                }

                // Instanciación del objeto
                miConsola = new Consola(marcaConsola, precioConsola, conJuego);
                System.out.println("\n¡Consola registrada con éxito!");
                miConsola.mostrarInfo();

            } else if (opcion == 2) {
                System.out.println("\n--- 1. HERENCIA SIMPLE (Teclado) ---");
                miTeclado.marca = "Generica";
                miTeclado.precio = 250.0;
                miTeclado.numTeclas = 105;
                miTeclado.mostrarInfo(); // Utiliza el método heredado intacto
                miTeclado.escribir();

                System.out.println("\n--- 2. HERENCIA CON SUPER (Laptop) ---");
                miLaptop.mostrarInfoCompleta(); // En su interior usa super.mostrarInfo()

                System.out.println("\n--- 3. HERENCIA CON OVERRIDE (Consola) ---");
                if (miConsola != null) {
                    miConsola.mostrarInfo(); // Utiliza el método sobreescrito
                } else {
                    System.out.println("Aún no ha registrado una consola en la opción 1.");
                }

                System.out.println("\n--- 4. SOBRECARGA DE MÉTODOS ---");
                miLaptop.encender();          // Se llama al método sin parámetros de Dispositivo
                miLaptop.encender("Modo Seguro");  // Se llama al método sobrecargado con 1 parámetro

            } else if (opcion == 3) {
                salir = true;
                System.out.println("Saliendo del programa. ¡Éxito en el laboratorio!");
            } else {
                System.out.println("Opción no válida. Ingrese 1, 2 o 3.");
            }
        }
        
        scanner.close(); // Limpiar y cerrar el scanner al finalizar
    }
}
