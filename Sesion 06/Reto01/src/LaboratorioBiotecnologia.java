import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class LaboratorioBiotecnologia {
    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar todas las especies en orden de llegada (pueden repetirse)
        ArrayList<String> muestrasOrdenadas = new ArrayList<>();
        muestrasOrdenadas.add("Homo sapiens");
        muestrasOrdenadas.add("Mus musculus");
        muestrasOrdenadas.add("Arabidopsis thaliana");
        muestrasOrdenadas.add("Homo sapiens"); // Repetida

        // Paso 2: HashSet para obtener especies únicas procesadas
        HashSet<String> especiesUnicas = new HashSet<>(muestrasOrdenadas);

        // Paso 3: HashMap para asociar ID de muestra con nombre de investigador responsable
        HashMap<String, String> muestraInvestigador = new HashMap<>();
        muestraInvestigador.put("M-001", "Dra. López");
        muestraInvestigador.put("M-002", "Dr. Hernández");
        muestraInvestigador.put("M-003", "Dra. Pérez");
        muestraInvestigador.put("M-004", "Dr. Ramírez");

        // Mostrar resultados:

        // Lista completa y ordenada de muestras (con repeticiones)
        System.out.println("📥 Lista completa y ordenada de muestras:");
        for (String especie : muestrasOrdenadas) {
            System.out.println("- " + especie);
        }

        System.out.println();

        // Especies únicas procesadas
        System.out.println("🧬 Especies únicas procesadas:");
        for (String especieUnica : especiesUnicas) {
            System.out.println("- " + especieUnica);
        }

        System.out.println();

        // Relación ID muestra → investigador
        System.out.println("🧑‍🔬 Relación de ID de muestra → investigador:");
        for (String idMuestra : muestraInvestigador.keySet()) {
            System.out.println(idMuestra + " → " + muestraInvestigador.get(idMuestra));
        }

        System.out.println();

        // Búsqueda por ID de muestra
        String idBusqueda = "M-002";
        System.out.println("🔍 Búsqueda por ID de muestra: " + idBusqueda);
        if (muestraInvestigador.containsKey(idBusqueda)) {
            System.out.println("Investigador responsable: " + muestraInvestigador.get(idBusqueda));
        } else {
            System.out.println("No se encontró el ID de muestra: " + idBusqueda);
        }
    }
}
