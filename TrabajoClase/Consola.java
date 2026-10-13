// CONCEPTO 3: Herencia con Override

class Consola extends Dispositivo { //Jala desde Dispositivo
    protected boolean incluyeJuego; //De nuevo protegemos con un F o V

    public Consola(String marca, double precio, boolean incluyeJuego) {
        this.marca = marca;
        this.precio = precio;
        this.incluyeJuego = incluyeJuego;
    }

    @Override // Sobreescribe el método OG de la clase Dispositivo
    public void mostrarInfo() {
        System.out.println("--- DATOS DE CONSOLA DE VIDEOJUEGOS ---"); //Este es el skibbidi
        System.out.println("Marca de consola: " + marca);
        System.out.println("Precio de lista: $" + precio);
        System.out.println("Incluye juego de regalo: " + (incluyeJuego ? "Sí" : "No")); //Este tambien
    }
}
