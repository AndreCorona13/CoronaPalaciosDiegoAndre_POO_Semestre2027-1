/** Práctica 3: Utilerías y clases de uso general
 * Código 2: El siguiente codigo genera el promedio con decimal
 * y redondeado tomando en cuenta el número de calificaciones a 
 * ingresar por el usuario.
 * Se implemento el uso de wrappers, Autoboxing, ArrayList, For-each y Math
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class AnalizadorCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList utilizando el Wrapper Double
        ArrayList<Double> calificaciones = new ArrayList<>();

        int cantidad;

        // Pedir cantidad de calificaciones
        while (true) {

            System.out.println("¿Cuantas calificaciones desea ingresar? ");

            if (sc.hasNextInt()) {

                cantidad = sc.nextInt();

                if (cantidad > 0) {
                    break;
                } else {
                    System.out.println("ADVERTENCIA: Debe ingresar un numero mayor que 0.");
                }

            } else {

                System.out.println("ADVERTENCIA: Debe ingresar un numero entero.");
                sc.next();
            }
        }

        // Pedir las calificaciones
        for (int i = 0; i < cantidad; i++) {

            while (true) {

                System.out.print("Ingrese la calificacion " + (i + 1) + ": ");

                if (sc.hasNextDouble()) {

                    double calificacion = sc.nextDouble();

                    if (calificacion >= 0 && calificacion <= 10) {

                        // Autoboxing: double -> Double
                        calificaciones.add(calificacion);
                        break;

                    } else {

                        System.out.println(
                            "ADVERTENCIA: La calificacion debe estar entre 0 y 10."
                        );
                    }

                } else {

                    System.out.println(
                        "ADVERTENCIA: Debe ingresar un numero."
                    );

                    sc.next();
                }
            }
        }

        // Variables para realizar los calculos
        double suma = 0;
        double mayor = calificaciones.get(0);
        double menor = calificaciones.get(0);

        System.out.println("\n===== CALIFICACIONES =====");

        // For-each
        for (Double calificacion : calificaciones) {

            System.out.println(calificacion);

            suma += calificacion;

            // Math
            mayor = Math.max(mayor, calificacion);
            menor = Math.min(menor, calificacion);
        }

        // Calcular promedio
        double promedio = suma / calificaciones.size();

        // Math
        long redondeado = Math.round(promedio);

        System.out.println("\n===== RESULTADOS =====");

        System.out.println("Calificacion mayor: " + mayor);
        System.out.println("Calificacion menor: " + menor);
        System.out.println("Promedio: " + promedio);
        System.out.println("Promedio en acta: " + redondeado);

        sc.close();
    }
}
