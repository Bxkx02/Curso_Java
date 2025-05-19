public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = new MetodoPago[] {
                new PagoEfectivo(150.0),
                new PagoTarjeta(320.0, 500.0),
                new PagoTransferencia(400.0, false) // transferencia inválida
        };

        for (MetodoPago pago : pagos) {
            System.out.println();
            Autenticable autenticable = (Autenticable) pago;

            if (autenticable.autenticar()) {
                pago.procesarPago();
                pago.mostrarResumen();
            }
        }
    }
}