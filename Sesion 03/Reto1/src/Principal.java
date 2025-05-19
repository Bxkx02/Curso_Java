import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");
        int opcion;

        do {
            System.out.println("\n--- Menú de Reservas de Vuelo ---");
            System.out.println("1. Reservar asiento");
            System.out.println("2. Consultar itinerario");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    if (vuelo.obtenerItinerario().contains("Pasajero: [Sin reserva]")) {
                        System.out.print("Ingrese el nombre del pasajero: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el número de pasaporte: ");
                        String pasaporte = scanner.nextLine();

                        boolean reservado = vuelo.reservarAsiento(nombre, pasaporte);
                        System.out.println(reservado ? "✅ Reserva realizada con éxito." : "❌ No se pudo realizar la reserva.");
                    } else {
                        System.out.println("⚠️ Ya hay un pasajero reservado.");
                    }
                    break;

                case 2:
                    System.out.println(vuelo.obtenerItinerario());
                    break;

                case 3:
                    vuelo.cancelarReserva();
                    break;

                case 4:
                    System.out.println("👋 Gracias por usar el sistema de reservas. ¡Buen viaje!");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
