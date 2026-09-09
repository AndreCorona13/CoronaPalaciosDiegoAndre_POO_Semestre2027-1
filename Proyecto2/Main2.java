/** Práctica 2:Fundamentos y sintaxis del lenguaje
 * main del programa para realizar el registro de computadoras
 **/
import java.util.Scanner;

public class Main2{//Clase principal del programa
    public static void main(String[] args) {//Método principal del programa
        Computadora [] computadoras = new Computadora[10];

        computadoras[0]= new Computadora("Intel Core i7", 16, 512, true, 650);
        computadoras[1]= new Computadora("AMD Ryzen 5", 8, 256, false, 500);
        Scanner scanner = new Scanner(System.in);
        //Variables para almacenar los datos ingresados por el usuario
        int RAM, almacenamiento, fuente_energia; 
        String CPU;
        boolean GPU;
        int i=2;

        do{//Ciclo para registrar los datos de las computadoras
            System.out.println("   --REGISTRO DE COMPUTADORAS-- ");
            computadoras[i] = new Computadora();

            System.out.print("Ingrese la CPU: ");
            scanner.nextLine(); // Limpiar el buffer
            String cpu = scanner.nextLine();
            computadoras[i].setCPU(cpu);

            //Validación de la RAM
            boolean ramValido = false;
            while(!ramValido){
                System.out.print("Ingrese la RAM: ");
                try{//Se utiliza un bloque try-catch para manejar posibles excepciones al leer la entrada del usuario
                    RAM = scanner.nextInt();
                if (RAM > 0){
                    computadoras[i].setRAM(RAM);
                    ramValido = true;
                }else{
                    System.out.println("RAM no valida, por favor ingrese un valor mayor a 0");
                }
                }catch(Exception e){
                    System.out.println("Entrada no valida, por favor ingrese un valor numerico");
                    scanner.nextLine();
                }
            }
            //Validación del almacenamiento
            boolean almacenamientoValido = false;
            while(!almacenamientoValido){
                System.out.print("Ingrese el almacenamiento: ");
                try{
                almacenamiento = scanner.nextInt();
                if (almacenamiento > 0){
                    computadoras[i].setAlmacenamiento(almacenamiento);
                    almacenamientoValido = true;
                }else{
                    System.out.println("Almacenamiento no valido, por favor ingrese un valor mayor a 0");
                }
                }catch(Exception e){
                    System.out.println("Entrada no valida, por favor ingrese un valor numerico");
                    scanner.nextLine();
                }
            }
            //Validación de la GPU
            boolean gpuValido = false;
            while(!gpuValido){
                System.out.print("¿Cuenta con gráficos dedicados? (S/s o N/n): ");
                String gpuEntrada = scanner.next();

                if(gpuEntrada.equalsIgnoreCase("S")){
                    computadoras[i].setGPU(true);
                    gpuValido = true;
                }else if(gpuEntrada.equalsIgnoreCase("N")){
                    computadoras[i].setGPU(false);
                    gpuValido = true;
                }else{
                    System.out.println("Entrada no valida, por favor ingrese S/s o N/n");
                }
            }
            //Validación de la fuente de energía
            boolean fuenteValida = false;
            while(!fuenteValida){
            System.out.print("Ingrese la fuente de energía: ");
            try{
                int fuenteEnergia = scanner.nextInt();
                if (fuenteEnergia > 0){
                    computadoras[i].setFuente_energia(fuenteEnergia);
                    fuenteValida = true;
                }else{
                    System.out.println("Fuente de energía no valida, por favor ingrese un valor mayor a 0");
                }
            }catch(Exception e){
                System.out.println("Entrada no valida, por favor ingrese un valor numerico");
                scanner.nextLine();
            }
            }
    

            i++;
        }while(i<10);//Cierre del ciclo para registrar los datos de las computadoras

        System.out.println("   Computadoras registradas:");

        for(int j=0; j<10; j++){
            System.out.println("Información de la computadora " + (j+1) + ":");
            System.out.println("CPU: " + computadoras[j].getCPU());
            System.out.println("RAM: " + computadoras[j].getRAM());
            System.out.println("Almacenamiento: " + computadoras[j].getAlmacenamiento());
            System.out.println("Tiene GPU: " + computadoras[j].getGPU());
            System.out.println("Fuente de energía: " + computadoras[j].getFuente_energia());
        }
        scanner.close();
    }
}
