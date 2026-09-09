 /** Práctica 2: Fundamentos y sintaxis del lenguaje
 * Código2: Registro de computadoras
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa para realizar el registro de computadoras, 
 * donde se solicita al usuario ingresar los datos de cada computadora
 * y posteriormente se muestran en pantalla.
 */
public class Computadora {
    //atributos.
    String CPU;
    int RAM, almacenamiento, fuente_energia ;
    boolean GPU;
    //constructores

    public Computadora(){}

    public Computadora(String CPU, int RAM, int almacenamiento, boolean GPU, int fuente_energia){
        this.CPU = CPU;
        this.RAM = RAM;
        this.almacenamiento = almacenamiento;
        this.GPU = GPU;
        this.fuente_energia = fuente_energia;
    }
    /*setters */
    public void setGPU(boolean GPU){
        this.GPU = GPU;
    }
    public void setCPU(String CPU){
        this.CPU = CPU;
    }
    public void setRAM(int RAM){
        this.RAM = RAM;
    }
    public void setAlmacenamiento(int almacenamiento){
        this.almacenamiento = almacenamiento;
    }
    public void setFuente_energia(int fuente_energia){
        this.fuente_energia = fuente_energia;
    }
    /*getters */
    public boolean getGPU(){
        return GPU;
    }       
    public String getCPU(){
        return CPU;
    }
    public int getRAM(){
        return RAM;
    }
    public int getAlmacenamiento(){
        return almacenamiento;
    }
    public int getFuente_energia(){
        return fuente_energia;
    }
    
}
