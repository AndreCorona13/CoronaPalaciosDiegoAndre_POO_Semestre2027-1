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

/**
 * Clase que representa a un usuario del sistema de biblioteca, heredando de PersonaP4
 * y gestionando múltiples constructores, atributos específicos y control de préstamos.
 */
public class Usuario extends PersonaP4{

    //Atributos
    private int librosPrestados;
    private String telefonoCelular;
    private boolean activo;

    //Constructores 
    // Constructores 
    
    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario(){}

    /**
     * Constructor parametrizado para inicializar los datos básicos y el estado activo del usuario.
     * 
     * @param id Identificador único del usuario.
     * @param nombre Nombre completo del usuario.
     * @param correo Correo electrónico del usuario.
     * @param activo Estado de actividad del usuario en el sistema.
     */
    public Usuario(int id, String nombre, String correo, boolean activo){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.activo = activo;
    }
    
    // 3. Constructor (Petición 3 del profe) 
    /**
     * Constructor sobrecargado que inicializa el nombre, teléfono, estado activo e ID del usuario.
     * CAMBIO: Movimos el 'int id' al final para que la firma sea (String, String, boolean, int) y Java no marque error.
     * @param nombre Nombre completo del usuario.
     * @param telefonoCelular Número de teléfono celular del usuario.
     * @param activo Estado de actividad del usuario.
     * @param id Identificador único del usuario.
     */
    public Usuario(String nombre, String telefonoCelular, boolean activo, int id){
        this.id = id;
        this.nombre = nombre;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }
    
    // 4. Constructor
    // Asumimos que quería juntar correo y teléfono. 
    // Firma: (boolean, int, String, String)
    /**
     * Constructor sobrecargado que inicializa el estado activo, ID, correo y teléfono del usuario.
     * 
     * @param activo Estado de actividad del usuario.
     * @param id Identificador único del usuario.
     * @param correo Correo electrónico del usuario.
     * @param telefonoCelular Número de teléfono celular del usuario.
     */
    public Usuario(boolean activo, int id, String correo, String telefonoCelular){
        this.id = id;
        this.correo = correo;
        this.telefonoCelular = telefonoCelular;
        this.activo = activo;
    }


    //Metodos
        /**
     * Incrementa el contador de libros prestados si el usuario se encuentra activo,
     * o muestra un mensaje de error si está inactivo.
     */
    public void solicitarPrestamo(){
        if (activo == true){
            librosPrestados += 1;
        } else{
            System.out.println("Usted no puede solicitar prestamo de libros debido a que no esta ACTIVO. :( ");
        }
    }
    /**
 * Decrementa el contador de libros prestados si el usuario tiene libros pendientes,
 * o emite un aviso en caso contrario.
 */
    public void devolverLibro(){
        if (librosPrestados > 0){
            librosPrestados -= 1;
        } else{
            System.out.println("Usted no tiene algun libro prestado. :) ");
        }
    }
/**
 * Muestra en la consola la información detallada del perfil del usuario,
 * incluyendo datos heredados y específicos.
 */
    @Override public void mostrarInformacion(){
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Telefono: " + telefonoCelular);
        System.out.println("Libros Prestados: " + librosPrestados);
        System.out.println("Activo: " + activo);
    }
/**
 * Establece o modifica el número de libros prestados al usuario.
 * 
 * @param librosPrestados La cantidad de libros prestados.
 */
    public void setLibrosPrestados(int librosPrestados){
        this.librosPrestados = librosPrestados;
    }
    /**
 * Establece o modifica el número de teléfono celular del usuario.
 * 
 * @param telefonoCelular El nuevo número telefónico.
 */
    public void setTelefonoCelular(String telefonoCelular){
        this.telefonoCelular = telefonoCelular;
    }
    /**
 * Establece o modifica el estado de actividad del usuario.
 * 
 * @param activo El estado booleano de actividad.
 */
    public void setActivo(boolean activo){
        this.activo = activo;
    }
/**
 * Obtiene el número de libros que tiene actualmente prestados el usuario.
 * 
 * @return La cantidad de libros prestados.
 */
    public int getLibrosPrestados(){
        return librosPrestados;
    }
    /**
 * Obtiene el número de teléfono celular del usuario.
 * 
 * @return El número telefónico actual.
 */
    public String getTelefonoCelular(){
        return telefonoCelular;
    }
    /**
 * Consulta si el usuario se encuentra activo en el sistema.
 * 
 * @return true si está activo, false en caso contrario.
 */
    public boolean getActivo(){
        return activo;
    }

}
