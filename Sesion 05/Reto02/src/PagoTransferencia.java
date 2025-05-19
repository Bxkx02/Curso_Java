public class PagoTransferencia extends MetodoPago implements Autenticable {

    private boolean transferenciaValida;

    public PagoTransferencia(double monto, boolean transferenciaValida) {
        super(monto);
        this.transferenciaValida = transferenciaValida;
    }

    @Override
    public boolean autenticar() {
        if (transferenciaValida) {
            System.out.println("✅ Autenticación exitosa.");
            return true;
        } else {
            System.out.println("❌ Fallo de autenticación. Transferencia no válida.");
            return false;
        }
    }

    @Override
    public void procesarPago() {
        System.out.println("💸 Procesando pago por transferencia bancaria por $" + monto);
    }
}