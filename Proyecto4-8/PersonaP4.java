/** Práctica 4-8: Sistema de Gesti ́on de Biblioteca
 * Código1: Clase Persona
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa para la creación de la clase Persona, tomándola como la clase padre. 
 */

/**
 * Clase abstracta que sirve como superclase para modelar personas dentro
 * del sistema de la biblioteca (como usuarios y empleados), definiendo atributos y 
 * un método abstracto para mostrar información.
 */
public abstract class PersonaP4 {
    
    //Atributos
    protected int id;
    protected String nombre;
    protected String correo;
    /**
 * Constructor por defecto de la clase PersonaP4.
 */
    //Constructores
    public PersonaP4(){}
    /**
 * Constructor parametrizado que inicializa los atributos básicos de la persona.
 * 
 * @param id Identificador único de la persona.
 * @param nombre Nombre completo de la persona.
 * @param correo Correo electrónico de contacto.
 */
    public PersonaP4(int id, String nombre, String correo){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }
    /**
 * Método abstracto que debe ser implementado obligatoriamente por las subclases
 * para mostrar la información específica del perfil de la persona.
 */
    //Metodos
    public abstract void mostrarInformacion();
    /**
     * Establece o modifica el identificador de la persona.
     * 
     * @param id El nuevo ID a asignar.
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Establece o modifica el nombre de la persona.
     * 
     * @param nombre El nuevo nombre a asignar.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
 * Establece o modifica el correo electrónico de la persona.
 * 
 * @param correo El nuevo correo electrónico a asignar.
 */
    public void setCorreo(String correo){
        this.correo = correo;
    }
    /**
 * Obtiene el identificador de la persona.
 * 
 * @return El ID actual.
 */
    public int getId(){
        return id;
    }
    /**
 * Obtiene el nombre completo de la persona.
 * 
 * @return El nombre actual.
 */
    public String getNombre(){
        return nombre;
    }
    /**
 * Obtiene el correo electrónico de la persona.
 * 
 * @return El correo electrónico actual.
 */
    public String getCorreo(){
        return correo;
    }
}
