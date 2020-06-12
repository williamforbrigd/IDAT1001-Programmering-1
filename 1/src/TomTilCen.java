import java.util.Scanner;

public class TomTilCen {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        double tommer = sc.nextDouble();

        double centimeter = tommer * 2.54;

        System.out.println(tommer + " tommer er " + centimeter + " centimeter.");
    }
}
