/** Práctica 3: Utilerías y clases de uso general
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 */
public class calculadoraALC {

    public static void main(String[] args) {

        // Verificar que se hayan proporcionado exactamente 2 argumentos
        if (args.length != 2) {

            System.out.println("ADVERTENCIA: Debe proporcionar 2 numeros.");
            System.out.println("Ejemplo:\njava CalculadoraALC 10 5");

            return;
        }

        double numero1;
        double numero2;

        // Intentar convertir los argumentos a numeros
        try {

            numero1 = Double.parseDouble(args[0]);
            numero2 = Double.parseDouble(args[1]);
        //Excepción si no se proporciono un numero
        } catch (NumberFormatException error) {

            System.out.println("ADVERTENCIA: Los argumentos deben ser numeros.");
            System.out.println("Ejemplo:\njava CalculadoraALC 10 5");

            return;
        }

        // Operaciones
        double suma = numero1 + numero2;
        double resta = numero1 - numero2;
        double multiplicacion = numero1 * numero2;

        System.out.println("===== CALCULADORA =====");

        System.out.println("Numero 1: " + numero1);
        System.out.println("Numero 2: " + numero2);

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicacion: " + multiplicacion);

        // Verificar division entre cero
        if (numero2 != 0) {

            double division = numero1 / numero2;
            System.out.println("Division: " + division);

        } else {

            System.out.println("ADVERTENCIA: No se puede dividir entre cero.");
        }

        // Math
        System.out.println("Mayor: " + Math.max(numero1, numero2));
        System.out.println("Menor: " + Math.min(numero1, numero2));
        System.out.println("Raiz de numero 1: " + Math.sqrt(Math.abs(numero1)));
        System.out.println("Raiz de numero 2: " + Math.sqrt(Math.abs(numero2)));
    }
}
