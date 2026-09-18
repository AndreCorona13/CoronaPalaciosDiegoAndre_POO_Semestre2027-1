/** Práctica 3: Programa 2 Listas
 * Usando el LinkedList, For-each, Wrappers, Autoboxing y manejar lista usando LikedList y recorrerá con For-each.
 * Código realizado por: 
 * Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 */
import java.util.LinkedList;
import java.util.Scanner;

public class ProgramaLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. LinkedList y 2. Wrappers: 
        // Usamos la clase Wrapper 'Integer' en lugar del tipo primitivo 'int'
        LinkedList<Integer> listaNumeros = new LinkedList<>();
        
        System.out.println("--- Programa 2: Manejo seguro de LinkedList ---");
        System.out.println("Ingresa números enteros para agregar a la lista.");
        System.out.println("Escribe 'fin' cuando quieras terminar.\n");

        // Ciclo infinito controlado para evitar que se llegue a "romper" el programa
        while (true) {
            System.out.print("Ingresa un número: ");
            String entrada = scanner.nextLine().trim(); // Leemos como texto y quitamos espacios extra

            // Condición de salida
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                // Intentamos convertir el texto ingresado a un tipo primitivo int
                int numeroPrimitivo = Integer.parseInt(entrada);
                
                // 3. Autoboxing:
                // Pasamos un primitivo (int), pero Java lo convierte automáticamente 
                // en un objeto (Integer) para guardarlo en la LinkedList.
                listaNumeros.add(numeroPrimitivo);
                
            } catch (NumberFormatException e) {
                // Aquí evitamos el programa se pueda romper wwww
                // Si ingresa letras, decimales o símbolos, el programa entra aquí en lugar de cerrarse con error.
                System.out.println("--> ERROR: '" + entrada + "' no es un número entero válido. Intenta de nuevo.");
            }
        }

        System.out.println("\n--- Resultados ---");
        
        // Verificamos si la lista está vacía
        if (listaNumeros.isEmpty()) {
            System.out.println("No ingresaste ningún número a la lista.");
        } else {
            System.out.println("Los números guardados en la LinkedList son:");
            
            int sumaTotal = 0;
            
            // 4. For-each:
            // Recorremos la lista de forma limpia. 
            for (Integer numeroObjeto : listaNumeros) {
                System.out.println("- " + numeroObjeto);
                
                // Unboxing (el proceso inverso al Autoboxing): 
                // Java saca el valor primitivo 'int' del objeto 'Integer' para poder sumarlo.
                sumaTotal += numeroObjeto; 
            }
            
            // 5. Manejo de la lista (Cálculo extra para demostrar que funciona)
            System.out.println("La suma de todos los números es: " + sumaTotal);
        }

        scanner.close();
    }
} 
