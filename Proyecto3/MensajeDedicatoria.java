/** Práctica 3: Utilerías y clases de uso general
 * Codigo 4: El codigo recibe un nombre y fecha de nacimiento
 * para dejar un mensaje creado por el usuario, con fecha del dia actual
 * Se implemento el uso de StringBuffer, StringBuilder, Date y Calendar
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 */
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class MensajeDedicatoria {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Nombre
        String nombre;

        while (true) {
            System.out.print("Ingresa tu nombre: ");
            nombre = entrada.nextLine().trim(); 
            
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacio");
            } else if (!nombre.matches("[\\p{L} ]+")) {
                System.out.println("El nombre solo puede contener letras y espacios.");
            } else {
                break;
            }
        }

        
        // Año de nacimiento
        int añoNacimiento;

        while (true) {
            System.out.print("Ingresa tu año de nacimiento: ");
            
            if (entrada.hasNextInt()) {
                añoNacimiento = entrada.nextInt();

                if (añoNacimiento >= 1920 && añoNacimiento <= 2026) {
                    break;
                } else {
                    System.out.println("Ingresa un año válido.");
                }

            } else {
                System.out.println("Debes ingresar un número.");
                entrada.next();
            }
        }

        entrada.nextLine();

        // Mensaje
        System.out.print("Escribe un mensaje: ");
        String texto = entrada.nextLine();

        // Date
        Date fechaActual = new Date();

        // Calendar
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaActual);

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR);

        // StringBuilder
        StringBuilder mensaje = new StringBuilder();

        mensaje.append("\n===== INFORMACIÓN =====\n");
        mensaje.append("Nombre: ").append(nombre);
        mensaje.append("\nAño de nacimiento: ").append(añoNacimiento);
        mensaje.append("\nFecha actual: ");
        mensaje.append(dia).append("/");
        mensaje.append(mes).append("/");
        mensaje.append(año);

        // StringBuffer
        StringBuffer resultado = new StringBuffer(mensaje);

        resultado.append("\nMensaje: ");
        resultado.append(texto);

        System.out.println(resultado);

        entrada.close();
    }
          } 
