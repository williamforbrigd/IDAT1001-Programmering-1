import java.util.Scanner;

public class Multiplikasjonstabellen {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int slutt = sc.nextInt();
        int produkt = 0;

        if (slutt > start && slutt > 0 && start > 0) {
            for (int i = start; i <= slutt; i++) {
                System.out.println(i + "-gangeren");
                System.out.println("---------------");
                for (int j = 1; j <= 10; j++) {
                    produkt = i * j;
                    System.out.println(i + " x " + j + " = " + produkt);
                }
                System.out.print("\n");
            }
        }
        else
            throw new IllegalArgumentException("Vennligst tast inn et gyldig intervall!");
    }
}
