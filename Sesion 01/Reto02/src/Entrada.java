public record Entrada(String nombreEvento, double precioEntrada) {
    // Método personalizado para mostrar información
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento + " | Precio: $" + precioEntrada);
    }
}
