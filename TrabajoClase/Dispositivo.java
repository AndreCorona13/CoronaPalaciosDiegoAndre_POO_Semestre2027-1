import java.util.Scanner; //Lee datos del usuario a escribir y pide datos al usuario
import java.util.InputMismatchException; //Por si el usuario escribe algo que nada que ver

// CLASE PADRE (BASE)

class Dispositivo {
    //Variables declaradas al inicio de la clase
    //Protected, accesibles desde la misma clase y alguna hija que herede, no desde externas
    protected String marca;
    protected double precio;

    public Dispositivo() {
        this.marca = "Sin asignar";
        this.precio = 0.0;
    }

    // CONCEPTO 4: Sobrecarga de métodos
    // Mismo nombre de método (encender), pero diferente firma (parámetros)
    public void encender() {
        System.out.println("Encendiendo dispositivo de forma normal...");
    }

    public void encender(String modo) {
        System.out.println("Encendiendo dispositivo en modo: " + modo);
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca + " | Precio: $" + precio);
    }
}
//El mostrar info de acá es el invocado de clase Laptop

