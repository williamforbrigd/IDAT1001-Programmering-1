import java.util.Scanner;
import java.util.Collections;

/**
 * En klient-klasse som lager et menystyrt program som oppretter et ArrangementRegister og lar brukeren velge mellom
 * en rekke funksjoner. Klassen er forsøkt utført i henhold til samstemthet, men samtidig er ikke hver metode begrenset
 * til hver sin oppgave. Det er derimot forsøkt å begrense antall oppgaver til hver funksjon.
 *
 * Legg merke til at det er lagt til "sc.nextLine()" en rekke steder i klassen da en Scanner har tendenser til å hoppe
 * over en linje når den leser inn en int-verdi.
 *
 * @author William
 * @version 1.0
 *
 */
public class Klient {
    public static void main(String[]args) {

        Klient klient = new Klient();
        klient.start();

    }

    /**
     * Metode som viser en meny som inneholder en rekke alternativer til ArrangementRegisteret.
     * Først skrives ut alle alternativene, og deretter leses det inn et valg fra brukeren gitt at brukeren ikke
     * skriver inn tekst istedenfor et tall. Dersom brukeren skriver inn tekst, sendes det ut en melding om
     * at det må tastes inn et gyldig alternativ.
     * @return denne menyen som et valg, ved hjelp av scanner, som lar brukeren velge mellom de forskjellige
     * alternativene.
     */

    public int visMeny() {

        Scanner sc = new Scanner(System.in);

        //Deklarerer visMeny og initierer den til 0.
        int visMeny = 0;
        System.out.println("----Applikasjon for registrering av Arrangementer----");
        System.out.println("1: Registrer et nytt arrangement");
        System.out.println("2: Finn alle arrangementer på et gitt sted");
        System.out.println("3: Finn alle arrangementer på en gitt dato");
        System.out.println("4: Finn alle arrangementer innenfor et gitt tidsintervall");
        System.out.println("5: Skriv ut liste over arrangementer sortert etter sted, type og tidspunkt");
        System.out.println("6: Avslutt");

        //Sjekker at brukeren skriver inn et tall og ikke tekst.
        if(sc.hasNextInt()) {
            //Hvis brukeren skriver inn tall, initieres visMeny-variabelen på nytt.
            visMeny = sc.nextInt();
            sc.nextLine();
        }

        //gir brukeren en melding om at han/hun må taste inn et gyldig alternativ.
        else
            System.out.println("Vennligst tast inn et av de gyldige alternativene");

        //Returnerer visMeny som lar brukeren velge mellom de forskjellige alternativene.
        return visMeny;
    }

    /**
     * Metode som har den oppgaven å starte programmet. ArrangementRegisteret opprettes og fylles opp fortløpende med
     * objekter for å teste. Deretter kjøres en løkke helt til brukeren velger å avslutte. Når løkken kjøres, vises
     * menyen for hvert gjennomløp.
     */
    public void start() {

        Scanner sc = new Scanner(System.in);

        ArrangementRegister register = new ArrangementRegister();

        System.out.println(register.regArrangement(new Arrangement(1, "PGA", "BUSA", "PGA-tour", "Golf", 201406201200L)));
        System.out.println(register.regArrangement(new Arrangement(2, "Europatour", "AEuropa", "PGA european tour", "Golf", 201006201700L)));
        System.out.println(register.regArrangement(new Arrangement(3, "VM", "Crasil", "FIFA", "Fotball", 200210301800L)));



        boolean fortsett = true;

        while(fortsett) {

            //Henter menyen for hvert gjennomløp.
            int visMeny = this.visMeny();
            switch(visMeny) {

                //regArrangement()-metoden returnerer true dersom arrangementet ble registrert og false dersom det ikke
                //ble registrert og kan på den måten gi brukeren informasjon om arrangementet blir registrert eller ikke.
                case 1:
                    if(register.regArrangement(new Arrangement(4, "Fortnite VM", "NY", "Epic", "Gaming", 201907251800L)))
                        System.out.println("Arrangementet ble registrert");
                    else
                        System.out.println("Arrangementer ble ikke registrert");

                    System.out.println("Press enter for å fortsette"); sc.nextLine();
                    break;


                case 2:
                    //Metoden returneres null dersom ingen av arrangementene arrangeres på det gitte stedet.
                    if(register.finnGittSted("Brasil") != null) {
                        System.out.println("Arrangementene du lette etter på det gitte stedet: ");
                        System.out.println(register.skrivUtListe(register.finnGittSted("Brasil")));
                    }
                    else
                        System.out.println("Fant ikke arrangementet på stedet du lette etter");

                    System.out.println("Press enter for å fortsette"); sc.nextLine();
                    break;

                case 3:
                    //Metoden returnerer null dersom ingen av arrangementene arrangeres på den gitte datoen.
                    if(register.finnGittDato(200210301800L) != null) {
                        System.out.println("Arrangementene du lette etter på den gitte datoen: ");
                        System.out.println(register.skrivUtListe(register.finnGittDato(200210301800L)));
                    }
                    else
                        System.out.println("Fant ikke arrangementet på tiden du lette etter");

                    System.out.println("Press enter for å fortsette"); sc.nextLine();
                    break;

                case 4:
                    //Metoden returnerer null dersom ingen av arrangementene er innenfor det gitte tidsintervallet.
                    if(register.finnGittTidsintervall(200210301800L, 201907251800L) != null) {
                        System.out.println("Alle arrangementer innenfor et gitt tidsintervall sortert etter tid: ");
                        System.out.println(register.skrivUtListe(register.sortertGittTidsintervall(200210301800L, 201907251800L)));
                    }
                    else
                        System.out.println("Fant ingen arrangementer innenfor det gitte tidsintervallet");

                    System.out.println("Press enter for å fortsette"); sc.nextLine();
                    break;

                case 5:
                    //Skriver ut før sortering
                    System.out.println("Før sortering etter henholdsvis sted, type og tid: ");
                    System.out.println(register.skrivUtListe());
                    System.out.print("\n");

                    //Skriver ut etter sortering. Her hentes interface-klassen som sorterer de forskjellige objektene
                    //etter henholdsvis sted, type og tindspunkt. Bruker en sort()-metode fra klassen Collections.
                    Collections.sort(register.getArrangementer(), new sortertStedTypeTid());
                    System.out.println("Liste etter sortering etter henholdsvis sted type og tid: ");
                    System.out.println(register.skrivUtListe());

                    System.out.println("Press enter for å fortsette"); sc.nextLine();
                    break;

                case 6:
                    System.out.println("Programmet avsluttes!");
                    fortsett = false;
                    break;
            }
        }

    }
}