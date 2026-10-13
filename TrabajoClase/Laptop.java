// CONCEPTO 2: Herencia con 'super'

class Laptop extends Dispositivo { //Jala desde Dispositivo
    protected String procesador; //Solo se modifica desde aquí y clases hijas

    public Laptop(String marca, double precio, String procesador) { //Datos a recibir
        super(); // Uso 1 de super: Llama directamente al constructor de la clase Padre Dispositivo
        this.marca = marca;
        this.precio = precio;
        this.procesador = procesador;
    } //Acá recibe normal los datos

    public void mostrarInfoCompleta() {
        super.mostrarInfo(); // Uso 2 de super: Jala al método original de la clase Dispositivo
        //En la siguiente linea... De clase padre, pone completo, de hijo lo complementa
        System.out.println("Procesador integrado: " + procesador); 
    }
}
