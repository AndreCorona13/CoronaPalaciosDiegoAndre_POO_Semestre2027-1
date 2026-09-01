/** Práctica 1: Entorno y lenguaje de programación
 * Código: Calculadora Básica (Operaciones).
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa para realizar suma, resta, multiplicación y división 
 * validando los datos ingresados por el usuario.
 */

import java.util.Scanner; // Importamos la clase Scanner que nos permite leer datos del teclado.

public class CalculadoraBasica {
    
    public static void main(String[] args) {
        // Creamos un objeto de la clase Scanner para leer datos del teclado.
        Scanner leer = new Scanner(System.in);
        
        // Pedimos al usuario que ingrese el primer número.
        System.out.print("Por favor, ingresa el primer número: ");
        
        /* Validamos si el usuario escribió un número válido (puede ser decimal)
         * para evitar que nuestro programa se rompa.
         */
        if (leer.hasNextDouble()) {
            double num1 = leer.nextDouble(); // Guardamos el dato ingresado en la variable num1.
            
            // Pedimos al usuario que ingrese el segundo número.
            System.out.print("Por favor, ingresa el segundo número: ");
            
            // Volvemos a validar que el segundo ingreso también sea un número válido.
            if (leer.hasNextDouble()) {
                double num2 = leer.nextDouble(); // Guardamos el dato ingresado en la variable num2.
                
                System.out.println("\n--- Resultados ---");
                
                // Realizamos e imprimimos la suma directa de ambas variables.
                System.out.println("Suma: " + (num1 + num2));
                
                // Realizamos e imprimimos la resta.
                System.out.println("Resta: " + (num1 - num2));
                
                // Realizamos e imprimimos la multiplicación.
                System.out.println("Multiplicación: " + (num1 * num2));
                
                // Validamos que el divisor (num2) no sea cero antes de intentar la división.
                if (num2 != 0) { // Si num2 es diferente de cero, se hace la división.
                    System.out.println("División: " + (num1 / num2));
                } else { // Si num2 es exactamente cero, se imprime el mensaje de error matemático.
                    System.out.println("División: Ups, no se puede dividir entre cero.");
                }
                
            } else {
                // Si el usuario escribió un valor diferente a un número en el segundo intento, se imprime error.
                System.out.println("Ups, debes ingresar un número válido para el segundo valor.");
            }
            
        } else {
            // Si el usuario escribió un valor diferente a un número en el primer intento, se imprime error.
            System.out.println("Ups, debes ingresar un número válido para el primer valor.");
        }
        
        leer.close(); // Cerramos el objeto de la clase Scanner para liberar recursos.
    }
}
