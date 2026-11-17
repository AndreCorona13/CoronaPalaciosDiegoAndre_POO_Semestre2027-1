// Importamos las clases necesarias del paquete java.time para manejar fechas y días
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        // Asignamos el parámetro fecha al atributo de la clase
        this.fecha = fecha;
        // Asignamos el parámetro hora al atributo de la clase
        this.hora = hora;
        // Asignamos el parámetro cliente al atributo de la clase
        this.cliente = cliente;
        // Marcamos como false (no disponible) porque al crearse ya ocupa el lugar
        this.disponible = false;
        // Llamamos al método interno para calcular el día de la semana y del año
        calcularDatosCalendario(fecha);
    }

    // Método privado que extrae información del calendario a partir de una fecha en texto
    private void calcularDatosCalendario(String fechaStr) {
        // Definimos el formato esperado de la fecha (día/mes/año)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Convertimos el texto recibido en un objeto LocalDate real
        LocalDate date = LocalDate.parse(fechaStr, formatter);
        // Obtenemos qué número de día del año es esa fecha y lo guardamos
        this.diaDelAnio = date.getDayOfYear();
        // Obtenemos el día de la semana en inglés y lo traducimos al español
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
