public class Paciente {
    String nombre;
    int edad;
    String NoExp;

    void mostrarInformacion() {
        System.out.println("\n Información del paciente:");
        System.out.println("Paciente:" + nombre);
        System.out.println("Edad:" + edad);
        System.out.println("Número de expediente:" + NoExp);
    }
}