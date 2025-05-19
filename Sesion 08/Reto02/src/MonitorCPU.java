import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Excepción personalizada
class ConsumoCriticoException extends Exception {
    public ConsumoCriticoException(String mensaje) {
        super(mensaje);
    }
}

public class MonitorCPU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Double> consumosRegistrados = new HashSet<>();
        boolean continuar = true;

        System.out.println("=== Monitor de Consumo CPU ===");
        System.out.println("Ingrese consumos de CPU (%) para servidores. Escriba 'salir' para terminar.");

        try {
            while (continuar) {
                System.out.print("Ingrese consumo CPU: ");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("salir")) {
                    continuar = false;
                    continue;
                }

                try {
                    double consumo = Double.parseDouble(entrada);

                    // Validaciones
                    if (consumo < 0 || consumo > 100) {
                        System.out.println("❌ Error: El consumo debe estar entre 0 y 100.");
                        continue;
                    }

                    if (consumosRegistrados.contains(consumo)) {
                        System.out.println("⚠️ Aviso: Consumo duplicado, no se registra.");
                        continue;
                    }

                    if (consumo > 95) {
                        throw new ConsumoCriticoException("🔥 Consumo crítico detectado: " + consumo + "%");
                    }

                    consumosRegistrados.add(consumo);
                    System.out.println("✔ Consumo registrado: " + consumo + "%");

                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: Entrada no numérica. Intente de nuevo.");
                } catch (ConsumoCriticoException e) {
                    System.out.println("🚨 " + e.getMessage());
                    // Opcional: registrar, alertar o romper el ciclo si se desea
                    // Por ejemplo: continuar = false;
                }
            }
        } finally {
            scanner.close();
            System.out.println("=== Monitoreo finalizado ===");
            System.out.println("Registros válidos:");
            for (Double c : consumosRegistrados) {
                System.out.println("- " + c + "%");
            }
        }
    }
}
