import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = (rfc == null || rfc.isBlank()) ? Optional.empty() : Optional.of(rfc);
    }

    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("📄 Factura generada:\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Monto: $").append(monto).append("\n");
        sb.append("RFC: ").append(rfc.orElse("[No proporcionado]")).append("\n");
        return sb.toString();
    }
}
