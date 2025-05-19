import java.util.Scanner;

// Interfaces según responsabilidades

interface TransicionHistoria {
    void avanzarEscena(boolean decision);
}

interface GestorDialogo {
    void mostrarDialogo(String texto);
}

interface LogicaDecision {
    boolean tomarDecision(String pregunta);
}

// Implementaciones concretas

class TransicionSimple implements TransicionHistoria {
    @Override
    public void avanzarEscena(boolean decision) {
        if (decision) {
            System.out.println("La historia avanza a la escena A.");
        } else {
            System.out.println("La historia avanza a la escena B.");
        }
    }
}

class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(String texto) {
        System.out.println("Narrador: \"" + texto + "\"");
    }
}

class DecisionBinaria implements LogicaDecision {
    private final Scanner scanner;

    public DecisionBinaria(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public boolean tomarDecision(String pregunta) {
        System.out.println(pregunta + " (sí/no)");
        while (true) {
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("sí") || respuesta.equals("si") || respuesta.equals("s")) {
                return true;
            } else if (respuesta.equals("no") || respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Por favor, responde 'sí' o 'no'.");
            }
        }
    }
}

// Clase principal que usa solo interfaces (DIP)

public class MainNarrativa {

    private final TransicionHistoria transicion;
    private final GestorDialogo dialogo;
    private final LogicaDecision logica;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo dialogo, LogicaDecision logica) {
        this.transicion = transicion;
        this.dialogo = dialogo;
        this.logica = logica;
    }

    public void ejecutarEscena() {
        dialogo.mostrarDialogo("Estás frente a una puerta misteriosa. ¿Quieres abrirla?");
        boolean decision = logica.tomarDecision("¿Abrir la puerta?");
        transicion.avanzarEscena(decision);
        if (decision) {
            dialogo.mostrarDialogo("La puerta se abre lentamente, revelando una habitación iluminada.");
        } else {
            dialogo.mostrarDialogo("Decides no abrir la puerta y continúas por el pasillo oscuro.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inyección de dependencias con implementaciones concretas
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision logica = new DecisionBinaria(scanner);

        MainNarrativa juego = new MainNarrativa(transicion, dialogo, logica);
        juego.ejecutarEscena();

        scanner.close();
    }
}
