import java.util.Scanner;

public class Klient {
    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        String tekst = sc.nextLine();
        TekstBehandling tb = new TekstBehandling(tekst);

        System.out.println(tb.getTekst());
        System.out.println(tb.getTekstStoreBokstaver());
        System.out.println(tb.antallOrd());
        System.out.println(tb.antallBokstaver());
        System.out.println(tb.gjennomsnittOrdLengde());
        System.out.println(tb.gjennomsnittPeriode());

        System.out.println("Hvilket ord skal skiftes ut?"); String finnOrd = sc.nextLine();
        System.out.println("Hvilket ord skal det skiftes ut med?"); String nyttOrd = sc.nextLine();
        System.out.println(tb.skiftUtOrd(finnOrd, nyttOrd));

    }
}
