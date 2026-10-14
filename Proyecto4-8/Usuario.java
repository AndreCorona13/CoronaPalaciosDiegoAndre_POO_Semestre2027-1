/** Práctica 4-8: Sistema de Gesti ́on de Biblioteca
 * Código2: Clase Usuario 
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que hereda los metodos de la clase padre
 * utilizando Varios constructores y definiendo los metodos de la clase padre y la clase hija
 * usando varios constructores y definiendo los metodos de la clase padre y la clase hija. 
 */
public class Usuario extends PersonaP4{

    //Atributos
    private int librosPrestados;
    private String telefonoCelular;
    private boolean activo;

    //Constructores 
    // Constructores 
    
    // 1. Constructor vacío (Petición 1 del profe)
    public Usuario(){}

    // 2. Constructor (Petición 2 del profe) -> Firma: (int, String, String, boolean)
    public Usuario(int id, String nombre, String correo, boolean activo){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.activo = activo;
    }
    
    // 3. Constructor (Petición 3 del profe) 
    // *CAMBIO:* Movimos el 'int id' al final para que la firma sea (String, String, boolean, int) y Java no marque error.
    public Usuario(String nombre, String telefonoCelular, boolean activo, int id){
        this.id = id;
        this.nombre = nombre;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }
    
    // 4. Constructor
    // Asumimos que quería juntar correo y teléfono. 
    // Firma: (boolean, int, String, String)
    public Usuario(boolean activo, int id, String correo, String telefonoCelular){
        this.id = id;
        this.correo = correo;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }


    //Metodos
    public void solicitarPrestamo(){
        if (activo == true){
            librosPrestados += 1;
        } else{
            System.out.println("Usted no puede solicitar prestamo de libros debido a que no esta ACTIVO. :( ");
        }
    }

    public void devolverLibro(){
        if (librosPrestados > 0){
            librosPrestados -= 1;
        } else{
            System.out.println("Usted no tiene algun libro prestado. :) ");
        }
    }

    @Override public void mostrarInformacion(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Telefono: " + telefonoCelular);
        System.out.println("Libros Prestados: " + librosPrestados);
        System.out.println("Activo: " + activo);
    }

    public void setLibrosPrestados(int librosPrestados){
        this.librosPrestados = librosPrestados;
    }
    public void setTelefonoCelular(String telefonoCelular){
        this.telefonoCelular = telefonoCelular;
    }
    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public int getLibrosPrestados(){
        return librosPrestados;
    }
    public String getTelefonoCelular(){
        return telefonoCelular;
    }
    public boolean getActivo(){
        return activo;
    }

}
