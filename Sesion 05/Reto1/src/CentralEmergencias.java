public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia = new Ambulancia("Ambulancia A1", "Carlos");
        Patrulla patrulla = new Patrulla("Patrulla P1", "Laura");
        UnidadBomberos bomberos = new UnidadBomberos("Bomberos B1", "Miguel");

        System.out.println("Iniciando operaciones de unidades de emergencia...\n");

        ambulancia.iniciarOperacion();
        System.out.println();

        patrulla.iniciarOperacion();
        System.out.println();

        bomberos.iniciarOperacion();
    }
}