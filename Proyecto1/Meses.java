
/**Práctica 1:Entorno y lenguaje de programación
Codigo 1.
Código realizado por: Corona Palacios Diego André, De la Cruz Flores Natalia Michelle, Hernández Moreno Emiliano, Martinez Barrios Aarón Rodrigo.
 * Programa para saber la estacion del año con respecto
 *  al mes seleccionado por el usuario.
 */

import java.util.*;

public class Meses{
    public static void main (String[] args){

        //Leer datos del teclado.
        Scanner teclado = new Scanner(System.in);
        int valor1;

        System.out.println("\n\t\t ------Meses del Año------");

        System.out.print("\n\t\nProporcione el número del mes deseado (1 - 12): ");
        valor1 = teclado.nextInt(); //Guarda el dato seleccionado por el usuario.

        /**
         * Se usa la sentencia "swith" para que cada caso sea un mes.
         * 
         * @return El mes seleccionado y la estacion, en casos especiales
         *          se pedira el dia y dependiendo del dia se regresara
         *           el mes y la estacion correspondiente.
         */

        switch (valor1){
            case 1:
                System.out.println("\n\tEl mes seleccionado es ENERO y es Invierno");
                break;

            case 2:
                System.out.println("\n\tEl mes seleccionado es FEBRERO y es Invierno");
                break;

            case 3:
                System.out.println("\n\tEl mes seleccionado es MARZO");
                System.out.print("\n\tProporcione un día del mes seleccionado (1 - 31): ");
                valor1 = teclado.nextInt();
                
                //Pide un dia especifico al usuario y lo compara para dar la estacion exacta. 
                if(valor1 < 21){
                    System.out.println("\n\tEs MARZO y es Invierno");
                }
                else if(valor1 >= 21 && valor1 <= 31){
                    System.out.println("\n\tEs MARZO y es Primavera");
                }
                
                break;

            case 4:
                System.out.println("\n\tEl mes seleccionado es ABRIL y es Primavera");
                break;

            case 5:
                System.out.println("\n\tEl mes seleccionado es MAYO y es Primavera");
                break;

            case 6:
                System.out.println("\n\tEl mes seleccionado es JUNIO");
                System.out.print("\n\tProporcione un día del mes seleccionado: ");
                valor1 = teclado.nextInt();
                
                if(valor1 < 21){
                    System.out.println("\n\tEs JUNIO y es Primavera");
                }
                else if(valor1 >= 21 && valor1 < 30){
                    System.out.println("\n\tEs JUNIO y es Verano");
                }
                break;
            case 7:
                System.out.println("\n\tEl mes seleccionado es JULIO y es Verano");
                break;

            case 8:
                System.out.println("\n\tEl mes seleccionado es AGOSTO y es Verano");
                break;

            case 9:
                System.out.println("\n\tEl mes seleccionado es Septiembre");
                System.out.print("\n\tProporciones un día del mes seleccionado: ");
                valor1 = teclado.nextInt();

                if(valor1 < 21){
                    System.out.println("\n\tEs SEPTIEMBRE y es Verano");
                }
                else if(valor1 >= 21 && valor1 < 30){
                    System.out.println("\n\tEs SEPTIEMBRE y es Otoño");
                }
                break;

            case 10:
                System.out.println("\n\tEl mes seleccionado es OCTUBRE y es Otoño");
                break;

            case 11:
                System.out.println("\n\tEl mes seleccionado es NOVIEMBRE y es Otoño");
                break;

            case 12:
                System.out.println("\n\tEl mes seleccionado es DICIEMBRE");
                System.out.print("\nProporcione un dia del mes seleccionado(1 - 31): ");
                valor1 = teclado.nextInt();

                if(valor1 < 21){
                    System.out.println("\n\tEl mes seleccionado es DICIEMBRE y es Otoño");
                }
                else if(valor1 >= 21 && valor1 < 31){
                    System.out.println("\n\tEl mes seleccionado es DICIEMBRE y es Invierno");
                }
                break;
            /**Si el usuario elige una opcion fuera del rango de los casos en switch se 
                 imprimira el siguiente texto y se acabara el programa
            */
            default:
                System.out.println("\n\tEl mes seleccionado NO ES VALIDO");
                break;
        }
    }
}
