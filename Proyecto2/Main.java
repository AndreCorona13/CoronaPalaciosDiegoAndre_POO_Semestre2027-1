 /** Práctica 2:Fundamentos y sintaxis del lenguaje
 * main del programa para realizar el registro de alumnos
 **/

import java.util.Scanner; //Biblioteca para leer datos de entrada

public class Main { //Clase principal del programa
    public static void main(String[] args) {//Método principal del programa

    Alumno [] alumnos = new Alumno[10];//Arreglo de objetos Alumno
        //Se crean dos objetos Alumno con datos predefinidos
    alumnos[0]  = new Alumno(20, 8.5f, "Pedro", "3er Semestre", "H");
    alumnos[1]  = new Alumno(22, 9.2f, "Ana", "6to Semestre", "M");
    
    Scanner sc = new Scanner(System.in);
        //Variables para almacenar los datos ingresados por el usuario
    int edad;
    float promedio;
    String nombre, semestre;
    int i=2;
    while(i<10){//Ciclo para registrar los datos de los alumnos
        System.out.println("  --REGISTRO DE ALUMNOS--");
        alumnos[i] = new Alumno();

        System.out.println("Por favor proporcione el nombre del alumno: ");
        nombre = sc.next();
        alumnos[i].setNombre(nombre);

        System.out.println("Porfavor proporcione el semestre del alumno: ");
        sc.nextLine();
        semestre = sc.nextLine();
        alumnos[i].setSemestre(semestre);
        //sc.next();
        //Validación de la edad del alumno
        boolean edadValida = false;
        while(!edadValida) {
        System.out.println("Por favor proporcione la edad del alumno: ");
        edad = sc.nextInt();
        if (edad >= 0 && edad <= 100){
             alumnos[i].setEdad(edad);
             edadValida = true;
        }else{
            System.out.println("Edad no valida, por favor ingrese una edad entre 0 y 100");
            }
        } 
        
        //Validación del promedio del alumno
        boolean promedioValido = false;
        while(!promedioValido){
        System.out.println("Por favor proporcione el promedio del alumno: ");
        promedio = sc.nextFloat();
        if (promedio >= 0.0f && promedio <= 10.0f){
           alumnos[i].setPromedio(promedio);
           promedioValido = true;
        }else{
            System.out.println("Promedio no valido, por favor ingrese un promedio entre 0.0 y 10.0");
            }
        }
        //Validación del sexo del alumno
        boolean sexoValido = false;
        while(!sexoValido){
        System.out.println("Por favor proporcione el sexo(H/h o M/m): ");
        String sexoEntrada = sc.next();
        
        if(sexoEntrada.equalsIgnoreCase("H")){
            alumnos[i].setSexo("H");
            sexoValido = true;
        }else if(sexoEntrada.equalsIgnoreCase("M")){
            alumnos[i].setSexo("M");
            sexoValido = true;
        }else{
            System.out.println("Sexo no valido, por favor ingrese H/h o M/m");
            }
        }

        i++;
    }
    //Mostrar la lista de alumnos registrados
    System.out.println("  LISTA DE ALUMNOS:  ");
    for (int j=0; j<i; j++){
        System.out.println("Nombre: "+alumnos[j].getNombre());
        System.out.println("Semestre: "+alumnos[j].getSemestre());
        System.out.println("Edad: "+alumnos[j].getEdad());
        System.out.println("Promedio: "+alumnos[j].getPromedio());
        System.out.println("Sexo: "+alumnos[j].getSexo());
    }
    
    sc.close();//Cierre del objeto Scanner para liberar recursos
    }
}
