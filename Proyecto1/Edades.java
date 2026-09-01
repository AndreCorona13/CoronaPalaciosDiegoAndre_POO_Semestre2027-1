/**Práctica 1:Entorno y lenguaje de programación
Codigo 2.
Código realizado por: Corona Palacios Diego André, 
De la Cruz Flores Natalia Michelle, 
Hernández Moreno Emiliano, 
Martinez Barrios Aarón Rodrigo.
 * Programa para calificar según la edad del usuario.
 * */
import java.util.Scanner; //Importamos la clase Scaner que nos permite leer datos del teclado.

public class Edades {
    public static void main(String[] args) { 
      //Creamos un objeto de la clase Scanner para leer datos del teclado.
        Scanner leer = new Scanner(System.in);
        //Pedimos al usuario que ingrese su edad.
        System.out.print("Por favor ingresa tu edad: ");
         /*validamos si el usuario escribio un numero entero 
         * asi evitar que nuestro programa se rompa 
         */
        if(leer.hasNextInt()){
          int edad= leer.nextInt();//Guardamos el dato ingresado por el usuario en la variable edad.

          if (edad <=18){ //Si la edad es menor o igual a 18, se imprime el siguiente mensaje.
            System.out.println("Apenas eres un escuincle");
            } else { //si la edad es superir se imprime el segundo mensaje
            System.out.println("Ya eres un anciano, de seguro ya te truena la rodilla");
            }
         } else { //si el usuario escribio un valor diferente a int se imprime el mensaje de error
            System.out.println("Ups, debes ingresar un numero entero valido:)");
          } 
         leer.close();//Cerramos el objeto de la clase Scanner para liberar recursos.
   }
} 
       
