/**Práctica 1:Entorno y lenguaje de programación
Codigo 4.
Código realizado por: 
Corona Palacios Diego André, 
De la Cruz Flores Natalia Michelle, 
Hernández Moreno Emiliano, 
Martinez Barrios Aarón Rodrigo.
* Programa para calcular el IMC del usuario e informar el estado en el que se encuentra.
**/
import java.util.Scanner;
/** Permite el uso de scanner para poder leer lo que el usuario escribe en la terminal **/
public class IMC {
/** Se crea la clase IMC **/  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
/** sc cumple con la funcion de ser el objeto que recibe los datos del teclado**/
    
    System.out.print("Ingresa tu peso en kg: ");
    double peso = sc.nextDouble();
/** Almacena el dato que asigne el usuario en peso**/
    
    System.out.print("Ingresa tu altura en metros: ");
    double altura = sc.nextDouble();
/** De igual modo almacena la informacion para la altura**/
    
    double imc = peso / (altura * altura);
/** Se crea la formula para obtener el imc y almacena el resultado en imc**/
    
    System.out.println("Tu IMC es: " + imc);
/** Imprime a pantalla el resultado del IMC**/

    if (imc < 18.5) {
      System.out.println("Estado: Bajo de peso");
    } else if (imc < 25) {
      System.out.println("Estado: Peso normal");
    } else if (imc < 30) {
      System.out.println("Estado: Sobrepeso");
    } else {
      System.out.println("Estado: Obesidad");
/** Se comienza a comparar el imc, segun datos generales, con el uso de if, cuando este se cumple imprime el estado en pantalla**/    
    }
  }
}
