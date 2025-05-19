import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto de tipo Paciente
        Paciente paciente = new Paciente();

        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del paciente: ");
        paciente.nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");paciente.edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el número de expediente: ");
        paciente.NoExp = scanner.nextLine();

        System.out.println(); // Línea en blanco para estética

        // Mostrar la información del paciente
        paciente.mostrarInformacion();

        scanner.close();
    }
}
