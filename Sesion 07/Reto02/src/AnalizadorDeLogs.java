import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnalizadorDeLogs {

    private static final Path RUTA_LOGS = Paths.get("errores.log");
    private static final Path RUTA_FALLOS = Paths.get("registro_fallos.txt");

    public static void main(String[] args) {
        int totalLineas = 0;
        int contadorErrores = 0;
        int contadorWarnings = 0;

        // Intentamos abrir el archivo errores.log con try-with-resources
        try (BufferedReader lector = Files.newBufferedReader(RUTA_LOGS)) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    contadorErrores++;
                }
                if (linea.contains("WARNING")) {
                    contadorWarnings++;
                }
            }

            // Calcular porcentaje de líneas que contienen ERROR o WARNING
            double porcentaje = totalLineas > 0
                    ? ((double) (contadorErrores + contadorWarnings) / totalLineas) * 100
                    : 0;

            // Imprimir resumen
            System.out.println("📊 Resumen del análisis de logs:");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + contadorErrores);
            System.out.println("Cantidad de advertencias: " + contadorWarnings);
            System.out.printf("Porcentaje de líneas con errores o advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
            registrarFallo(e.getMessage());
        }
    }

    // Método para registrar errores en registro_fallos.txt
    private static void registrarFallo(String mensajeError) {
        try (BufferedWriter escritor = Files.newBufferedWriter(RUTA_FALLOS,
                java.nio.file.StandardOpenOption.CREATE,
                java.nio.file.StandardOpenOption.APPEND)) {

            escritor.write("Error: " + mensajeError);
            escritor.newLine();

        } catch (IOException e) {
            // Si no se puede escribir en el archivo de fallos, mostrar error en consola
            System.err.println("No se pudo registrar el fallo: " + e.getMessage());
        }
    }
}
