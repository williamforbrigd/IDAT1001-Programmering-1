import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);


        TekstAnalyse2 t1;

        for(int i = 0; i < 3; i++) {
            String tekst = sc.nextLine();
            t1 = new TekstAnalyse2(tekst);
            System.out.println(t1.finnAntallUlikeBokstaver());
            System.out.println(t1.finnTotaltAntallBokstaver());
            System.out.println(t1.finnProsentIkkeBokstaver());
            System.out.println(t1.forekomstBestemtBokstav('å'));
            System.out.println(t1.finnAlleBokstaveneMaks());
        }
    }
}
