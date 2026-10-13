// CONCEPTO 1: Herencia Simple (sin super ni override)

class Teclado extends Dispositivo { //Jala desde clase Dispositivo
    // Hereda todo de Dispositivo sin alterar el comportamiento de los métodos ni usar super()
    public int numTeclas;

    public void escribir() { //Comienza vacio pero es porque le vamos a meter
        System.out.println("Escribiendo con " + numTeclas + " teclas...");
    }
}
