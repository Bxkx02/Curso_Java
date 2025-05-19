import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.println("Ingrese datos para la factura #" + i);

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            System.out.print("Monto: ");
            double monto = Double.parseDouble(sc.nextLine());

            System.out.print("RFC (dejar vacío si no tiene): ");
            String rfc = sc.nextLine();

            Factura factura = new Factura(monto, descripcion, rfc);
            System.out.println("\n" + factura.getResumen());
        }

        sc.close();
    }
}
