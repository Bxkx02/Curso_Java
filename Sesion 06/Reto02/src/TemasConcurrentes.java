import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad; // 1=urgente, 2=importante, 3=opcional

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Orden natural: por título alfabéticamente
    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    @Override
    public String toString() {
        return "Tema{" +
                "titulo='" + titulo + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}

public class TemasConcurrentes {
    public static void main(String[] args) {
        // Lista concurrente para temas activos
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();

        // Agregar temas
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));
        temas.add(new Tema("Biología celular", 1));
        temas.add(new Tema("Arte moderno", 3));

        System.out.println("📋 Temas ordenados alfabéticamente (orden natural):");
        // Orden natural (por título)
        Collections.sort(temas);
        temas.forEach(System.out::println);

        System.out.println("\n📋 Temas ordenados por prioridad (ascendente):");
        // Ordenar por prioridad usando Comparator
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        temas.forEach(System.out::println);

        // Repositorio concurrente de recursos
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");
        recursos.put("Biología celular", "https://recursos.edu/biologia");
        recursos.put("Arte moderno", "https://recursos.edu/arte");

        System.out.println("\n📚 Recursos compartidos por tema:");
        recursos.forEach((tema, enlace) -> {
            System.out.println(tema + " -> " + enlace);
        });
    }
}
