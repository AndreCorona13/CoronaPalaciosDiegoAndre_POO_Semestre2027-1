/** Práctica 11: Manejo de Archivos
 * Código 1: Principal.java
 * Fecha: 21 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que engloba la función de la agenda y la reservacion. 
 */

// Importamos la excepción específica para detectar fechas mal escritas
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

// Declaramos la clase principal que contiene el método de arranque main
public class Principal {
    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) {
        // Creamos el objeto Scanner conectado a la entrada estándar (teclado)
        Scanner sc = new Scanner(System.in);
        // Instanciamos nuestro GestorAgenda (esto creará el archivo CSV si no existe)
        GestorAgenda agenda = new GestorAgenda();
        // Variable para controlar la opción elegida por el usuario en el menú
        int opcion = 0;

        // Ciclo do-while para mantener el menú activo hasta que el usuario elija salir (opción 3)
        do {
            // Imprimimos las opciones del menú en consola
            System.out.println("=== AGENDA SALÓN DE FIESTAS ===");
            System.out.println("1. Realizar reservación");
            System.out.println("2. Ver agenda completa (archivo)");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            // Bloque try para capturar errores de entrada del usuario o de disponibilidad
            try {
                // Leemos la línea completa y la convertimos a número entero
                opcion = Integer.parseInt(sc.nextLine());

                // Evaluamos la opción elegida
                switch (opcion) {
                    case 1:
                        // Pedimos la fecha al usuario
                        System.out.print("Ingresa la fecha (dd/MM/yyyy, ej. 25/11/2026): ");
                        // Leemos la fecha y quitamos espacios en blanco sobrantes a los lados
                        String fecha = sc.nextLine().trim();

                        // Validar la fecha
                        DateTimeFormatter formato =
                            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

                        LocalDate fechaEvento = LocalDate.parse(fecha, formato);

                        // Evitar fechas pasadas
                        if (fechaEvento.isBefore(LocalDate.now())) {

                            System.out.println("Error: no puedes reservar fechas pasadas.");
                            break;
                        }

                        // Pedimos la hora del evento
                        System.out.print("Ingresa la hora de inicio (HH:mm, ej. 18:00): ");
                        // Leemos la hora y limpiamos espacios
                        String hora = sc.nextLine().trim();

                        try {

                            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm")
                                .withResolverStyle(ResolverStyle.STRICT);

                            LocalTime horaEvento = LocalTime.parse(hora, formatoHora);

                        } catch (DateTimeParseException e) {

                        System.out.println("ERROR: La hora ingresada no es valida.");
                        System.out.println("Ejemplo de formato correcto: 18:00");
                        break;
                        }

                        // Pedimos el nombre de la empresa o persona
                        System.out.print("Nombre de la empresa o persona que reserva: ");
                        // Leemos el nombre y eliminamos cualquier coma para no alterar las columnas del CSV
                        String cliente = sc.nextLine().trim().replace(",", "");

                        // Llamamos al método agendarEvento para validar disponibilidad y guardar
                        agenda.agendarEvento(fecha, hora, cliente);
                        // Salimos del caso 1
                        break;

                    case 2:
                        // Llamamos al método que lee e imprime el archivo completo en consola
                        agenda.mostrarAgenda();
                        // Salimos del caso 2
                        break;

                    case 3:
                        // Mensaje de despedida antes de terminar el ciclo
                        System.out.println("Saliendo del sistema...");
                        // Salimos del caso 3
                        break;

                    default:
                        // Si el usuario escribió un número distinto de 1, 2 o 3
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                // Se ejecuta si el usuario escribió letras en lugar de un número en el menú
                System.out.println("Error: Ingresa un número válido para el menú.");
            } catch (DateTimeParseException e) {
                // Se ejecuta si el usuario escribió una fecha que no cumple el formato dd/MM/yyyy
                System.out.println("Error: Formato de fecha inválido. Usa exactamente dd/MM/yyyy (ej. 05/12/2026).");
            }catch (Exception e) {
                // Se ejecuta cuando agenda.agendarEvento lanza el error de que la fecha/hora ya está ocupada
                System.out.println(e.getMessage());
            }
            // Imprimimos un salto de línea estético entre cada iteración del menú
            System.out.println();
        } while (opcion != 3); // El ciclo se repite mientras la opción sea diferente de 3

        // Cerramos el objeto Scanner para liberar los recursos del teclado
        sc.close();
    }
}
