import java.util.Scanner;

public class TotaltSekunder {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Timer: "); int timer = sc.nextInt();
        System.out.println("Minutter: "); int minutter = sc.nextInt();
        System.out.println("Sekunder: "); int sekunder = sc.nextInt();

        int sekunderTotalt = (timer * 3600) + (minutter * 60) + sekunder;

        System.out.println(timer + " timer, " + minutter + " minutter og " + sekunder + " sekunder er " + sekunderTotalt + " sekunder.");

    }
}
