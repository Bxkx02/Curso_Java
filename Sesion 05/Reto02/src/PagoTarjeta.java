public class PagoTarjeta extends MetodoPago implements Autenticable {
    private double saldoTarjeta;

    public PagoTarjeta(double monto, double saldoTarjeta) {
        super(monto);
        this.saldoTarjeta = saldoTarjeta;
    }

    @Override
    public boolean autenticar() {
        if (saldoTarjeta >= monto) {
            System.out.println("✅ Autenticación exitosa.");
            return true;
        } else {
            System.out.println("❌ Fallo de autenticación. Fondos insuficientes.");
            return false;
        }
    }

    @Override
    public void procesarPago() {
        System.out.println("💳 Procesando pago con tarjeta por $" + monto);
        saldoTarjeta -= monto; // Simula descuento
    }
}
