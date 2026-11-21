/** Práctica 11: Manejo de Archivos
 * Código 1: Clase Reservacion.java
 * Fecha: 21 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que muestra el funcionamiento y validación de la reservacion en la agenda. 
 */

// Importamos las clases necesarias del paquete java.time para manejar fechas y días
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

// Declaramos la clase pública Reservacion que servirá como modelo de datos
public class Reservacion {
    // Atributo privado para guardar la fecha en formato texto (dd/MM/yyyy)
    private String fecha;
    // Atributo privado para guardar la hora del evento (HH:mm)
    private String hora;
    // Atributo privado para almacenar el nombre del día de la semana en español
    private String diaSemana;
    // Atributo privado para guardar el número de día del año (del 1 al 365 o 366)
    private int diaDelAnio;
    // Atributo privado booleano para indicar si el espacio está libre o no
    private boolean disponible;
    // Atributo privado para guardar el nombre de la persona o empresa que reserva
    private String cliente;

    // Constructor que recibe los datos básicos al crear una nueva reservación
    public Reservacion(String fecha, String hora, String cliente) {

    this.fecha = fecha;

    // Validar que la hora sea correcta
    DateTimeFormatter formatoHora =
        DateTimeFormatter.ofPattern("HH:mm")
        .withResolverStyle(ResolverStyle.STRICT);

    LocalTime.parse(hora, formatoHora);

    this.hora = hora;
    this.cliente = cliente;
    this.disponible = false;

    calcularDatosCalendario(fecha);
    }

    // Método privado que extrae información del calendario a partir de una fecha en texto
    private void calcularDatosCalendario(String fechaStr) {

    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MM/uuuu")
        .withResolverStyle(ResolverStyle.STRICT);

    LocalDate date = LocalDate.parse(fechaStr, formatter);

    this.diaDelAnio = date.getDayOfYear();

    this.diaSemana = traducirDia(date.getDayOfWeek());
    }

    // Método privado para convertir la constante DayOfWeek (en inglés) a texto en español
    private String traducirDia(DayOfWeek dia) {
        // Evaluamos qué día de la semana llegó como parámetro
        switch (dia) {
            case MONDAY:    return "Lunes";     // Si es MONDAY, devuelve "Lunes"
            case TUESDAY:   return "Martes";    // Si es TUESDAY, devuelve "Martes"
            case WEDNESDAY: return "Miércoles"; // Si es WEDNESDAY, devuelve "Miércoles"
            case THURSDAY:  return "Jueves";    // Si es THURSDAY, devuelve "Jueves"
            case FRIDAY:    return "Viernes";   // Si es FRIDAY, devuelve "Viernes"
            case SATURDAY:  return "Sábado";    // Si es SATURDAY, devuelve "Sábado"
            case SUNDAY:    return "Domingo";   // Si es SUNDAY, devuelve "Domingo"
            default:        return "";          // Caso por defecto vacío
        }
    }

    // Método que formatea todos los atributos en una sola línea separada por comas (CSV)
    public String toCSV() {
        // Operador ternario: si disponible es true pone "DISPONIBLE", si es false pone "OCUPADO"
        String estado = disponible ? "DISPONIBLE" : "OCUPADO";
        // Concatenamos los datos con comas para representar las casillas del archivo
        return fecha + "," + hora + "," + diaSemana + "," + diaDelAnio + "," + estado + "," + cliente;
    }

    // Método getter para obtener la fecha de la reservación
    public String getFecha() { return fecha; }
    // Método getter para obtener la hora de la reservación
    public String getHora() { return hora; }
}
