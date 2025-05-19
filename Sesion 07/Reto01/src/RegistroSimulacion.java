import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class RegistroSimulacion {

    private static final Path RUTA_ARCHIVO = Paths.get("config", "parametros.txt");

    public static void main(String[] args) {
        String parametros = """
            Tiempo de ciclo: 55,8 segundos
            Velocidad de línea: 1,2 m/s
            Número de estaciones: 8
            """;

        try {
            guardarParametros(parametros);
            if (validarArchivo()) {
                System.out.println("✅ Archivo creado correctamente.");
                String contenido = leerParametros();
                System.out.println("📄 Contenido del archivo:");
                System.out.println(contenido);
            } else {
                System.out.println("❌ El archivo no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    // Método para guardar los parámetros en el archivo, creando carpeta si no existe
    private static void guardarParametros(String contenido) throws IOException {
        Path carpeta = RUTA_ARCHIVO.getParent();
        if (!Files.exists(carpeta)) {
            Files.createDirectories(carpeta);
            System.out.println("📁 Carpeta 'config/' creada.");
        }
        // Escribir el contenido en el archivo (crea o reemplaza)
        Files.writeString(RUTA_ARCHIVO, contenido, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // Método para validar si el archivo existe
    private static boolean validarArchivo() {
        return Files.exists(RUTA_ARCHIVO);
    }

    // Método para leer el contenido del archivo y devolverlo como String
    private static String leerParametros() throws IOException {
        return Files.readString(RUTA_ARCHIVO);
    }
}