import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese datos para la Declaración de Impuestos:");
        System.out.print("RFC contribuyente: ");
        String rfcDeclaracion = sc.nextLine();
        System.out.print("Monto declarado: ");
        double montoDeclarado = sc.nextDouble();
        sc.nextLine(); // consumir salto de línea

        DeclaracionImpuestos declaracion = new DeclaracionImpuestos(rfcDeclaracion, montoDeclarado);

        System.out.println("\nIngrese datos para la Cuenta Fiscal:");
        System.out.print("RFC: ");
        String rfcCuenta = sc.nextLine();
        System.out.print("Saldo disponible: ");
        double saldoDisponible = sc.nextDouble();

        CuentaFiscal cuenta;
        try {
            cuenta = new CuentaFiscal(rfcCuenta, saldoDisponible);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.close();
            return;
        }

        System.out.println("\n--- Resumen ---");
        System.out.println("Declaración de impuestos:");
        System.out.println("RFC: " + declaracion.rfcContribuyente());
        System.out.println("Monto declarado: $" + declaracion.montoDeclarado());

        System.out.println("\nCuenta fiscal:");
        System.out.println("RFC: " + cuenta.getRfc());
        System.out.println("Saldo disponible: $" + cuenta.getSaldoDisponible());

        boolean rfcCoincide = cuenta.validarRFC(declaracion);
        System.out.println("\n¿RFC coincide? " + rfcCoincide);

        sc.close();
    }
}
