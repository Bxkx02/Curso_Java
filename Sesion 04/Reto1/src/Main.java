import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese datos para la primera factura:");
        System.out.print("Folio: ");
        String folio1 = sc.nextLine();
        System.out.print("Cliente: ");
        String cliente1 = sc.nextLine();
        System.out.print("Total: ");
        double total1 = sc.nextDouble();
        sc.nextLine(); // consumir salto de línea

        System.out.println("\nIngrese datos para la segunda factura:");
        System.out.print("Folio: ");
        String folio2 = sc.nextLine();
        System.out.print("Cliente: ");
        String cliente2 = sc.nextLine();
        System.out.print("Total: ");
        double total2 = sc.nextDouble();

        Factura f1 = new Factura(folio1, cliente1, total1);
        Factura f2 = new Factura(folio2, cliente2, total2);

        System.out.println("\n" + f1);
        System.out.println(f2);

        System.out.println("\n¿Son iguales? " + f1.equals(f2));

        sc.close();
    }
}