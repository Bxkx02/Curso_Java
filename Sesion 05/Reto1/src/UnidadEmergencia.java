public abstract class UnidadEmergencia {
    protected String nombre;

    public UnidadEmergencia(String nombre) {
        this.nombre = nombre;
    }

    public abstract void responder();

    public void activarUnidad() {
        System.out.println(nombre + " activada.");
    }
}

