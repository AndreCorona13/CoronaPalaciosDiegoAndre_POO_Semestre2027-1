/** Práctica 11: Manejo de Archivos
 * Código 1: Clase GestorAgenda.java
 * Fecha: 21 de Noviembre del 2026
 * Código realizado por: Corona Palacios Diego André,
 * De la Cruz Flores Natalia Michelle,
 * Hernández Moreno Emiliano, 
 * Martinez Barrios Aarón Rodrigo.
 * Programa que muestra el cómo funciona una agenda. 
 */

// Importamos todas las clases de entrada/salida (File, FileWriter, BufferedReader, IOException, etc.)
import java.io.*;

// Declaramos la clase encargada de leer, escribir y validar el archivo de la agenda
public class GestorAgenda {
    // Constante privada con el nombre del archivo físico que se creará en el disco
    private final String NOMBRE_ARCHIVO = "agenda_salon.csv";

    // Constructor de la clase GestorAgenda
    public GestorAgenda() {
        // Cada vez que se instancie el gestor, verificamos que el archivo exista
        inicializarArchivo();
    }

    // Método privado que crea el archivo con sus encabezados si es la primera vez que se ejecuta
    private void inicializarArchivo() {
        // Creamos un objeto File apuntando a la ruta del archivo
        File archivo = new File(NOMBRE_ARCHIVO);
        // Verificamos si el archivo NO existe todavía en la computadora
        if (!archivo.exists()) {
            // Abrimos un flujo de escritura seguro (try-with-resources cierra el archivo automáticamente)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                // Escribimos la primera fila que funcionará como encabezados de las casillas
                bw.write("Fecha,Hora,Dia de la Semana,Dia del Anio,Estado,Empresa o Persona");
                // Insertamos un salto de línea al final de los encabezados
                bw.newLine();
            } catch (IOException e) {
                // Si ocurre un error de permisos o disco al crear el archivo, lo mostramos
                System.out.println("Error al crear el archivo de agenda: " + e.getMessage());
            }
        }
    }

    // Método público que revisa el archivo para saber si una fecha y hora están libres
    public boolean estaDisponible(String fecha, String hora) throws IOException {
        // Abrimos un flujo de lectura línea por línea sobre nuestro archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            // Variable temporal para almacenar cada línea que vayamos leyendo
            String linea;
            // Leemos la primera línea (encabezados) y la ignoramos para no evaluarla
            br.readLine();

            // Ciclo que lee el archivo línea por línea hasta llegar al final (null)
            while ((linea = br.readLine()) != null) {
                // Dividimos la línea usando la coma como separador para obtener cada casilla
                String[] casillas = linea.split(",");
                // Verificamos que la fila tenga al menos 5 columnas válidas
                if (casillas.length >= 5) {
                    // Extraemos y limpiamos espacios de la columna 0 (Fecha)
                    String fechaArchivo = casillas[0].trim();
                    // Extraemos y limpiamos espacios de la columna 1 (Hora)
                    String horaArchivo = casillas[1].trim();
                    // Extraemos y limpiamos espacios de la columna 4 (Estado)
                    String estadoArchivo = casillas[4].trim();

                    // Comparamos si coinciden fecha, hora y además el estado es "OCUPADO"
                    if (fechaArchivo.equals(fecha) && horaArchivo.equals(hora) && estadoArchivo.equals("OCUPADO")) {
                        // Si ya existe ese registro ocupado, retornamos false (no disponible)
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
        // Si terminó de revisar todo el archivo sin encontrar coincidencias, está disponible
        return true;
    }

    // Método público para guardar una nueva reservación; lanza Exception si hay conflicto
    public void agendarEvento(String fecha, String hora, String cliente) throws Exception {
        // Validamos disponibilidad llamando al método anterior; si es false, entramos al if
        if (!estaDisponible(fecha, hora)) {
            // Lanzamos una excepción personalizada indicando el error de disponibilidad
            throw new Exception("ERROR: El salón NO está disponible el " + fecha + " a las " + hora + ".");
        }

        // Si está disponible, instanciamos un nuevo objeto Reservacion con los datos
        Reservacion nueva = new Reservacion(fecha, hora, cliente);

        // Abrimos el archivo en modo "append" (el parámetro true evita borrar lo que ya estaba)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            // Escribimos los datos de la reservación en formato CSV
            bw.write(nueva.toCSV());
            // Agregamos un salto de línea para el siguiente registro futuro
            bw.newLine();
            // Confirmamos al usuario que la casilla fue actualizada con su nombre
            System.out.println("¡Éxito! Agenda actualizada. Casilla asignada a: " + cliente);
        } catch (IOException e) {
            // Si falla la escritura en disco, lanzamos una excepción hacia el menú principal
            throw new Exception("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    // Método público para imprimir en consola todo el contenido actual del archivo
    public void mostrarAgenda() {
        // Imprimimos un título decorativo
        System.out.println("\n--- ESTADO ACTUAL DE LA AGENDA ---");
        // Abrimos el archivo en modo lectura
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            // Variable para guardar cada línea leída
            String linea;
            // Leemos hasta el final del documento
            while ((linea = br.readLine()) != null) {
                // Reemplazamos las comas por tabuladores y barras para visualizar las casillas ordenadas
                System.out.println(linea.replace(",", " \t| "));
            }
        } catch (IOException e) {
            throw new RuntimeException(
                "No se pudo crear el archivo de agenda: " + e.getMessage());
        }
        // Imprimimos una línea de cierre
        System.out.println("----------------------------------\n");
    }
}
