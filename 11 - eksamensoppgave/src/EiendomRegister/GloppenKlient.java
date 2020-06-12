package EiendomRegister;

import EiendomRegister.EiendomRegister;

import java.util.Scanner;

/**
 * @Version 1.0 2019
 * @Author William Forbrigd
 *
 * Klasse som skal representere brukerinteraksjonen for alle eiendommene i EiendomRegister.Gloppen-kommune.
 *
 * Valgte å bruke en do-while loop med switch statement, ettersom det gjør det praktisk for brukeren å velge et av de ønskede alternativene.
 */
public class GloppenKlient {
    public static void main(String[]args) {

        EiendomRegister eiendomRegister = new EiendomRegister();

        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(77, 631, 1017.6, "Jens Olsen")));
        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(77, 131, "Syningom", 661.3, "Nicolay Madsen")));
        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(75, 19, "Fugletun", 650.6, "Evilyn Jensen")));
        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(74, 188, 1457.2, "Karl Ove Bråten")));
        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(69, 47, "Høiberg", 1339.4, "Elsa Indregård")));
        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(77, 631, 1017.6, "Jens Olsen")));

        boolean fortsett = true;

        do {
            System.out.print("\n");
            System.out.println("Applikasjon for eiendomsregister.");
            System.out.println("---------------------------------------------------");
            System.out.println("1: Registrere en eiendom.");
            System.out.println("2: Skrive ut alle eiendommene i registeret.");
            System.out.println("3: Søke etter eiendom basert på kommunenr, gårdsnummer og bruksnummer.");
            System.out.println("4: Regne ut og vise gjennomsnittsareal av alle eiendommene i registeret.");
            System.out.println("5: Avslutt");
            System.out.println("---------------------------------------------------");
            System.out.println("Vennligst velg et av alternativene.");

            Scanner sc = new Scanner(System.in);
            int velg = sc.nextInt();
            sc.nextLine();

            switch(velg) {
                case 1:
                    System.out.println("Gårdsnummer: ");
                    int gårdsNr = sc.nextInt();
                    System.out.println("Bruksnummer: ");
                    int bruksNr = sc.nextInt();
                    System.out.println("Areal: "); double areal = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Eier: ");
                    String eier = sc.nextLine();
                    System.out.println("Har eiendomen bruksnavn? 1 for ja, og hvilket som helst annet nummer for nei.");
                    int valg = sc.nextInt();
                    sc.nextLine();
                    if(valg == 1) {
                        System.out.println("Bruksnavn: ");
                        String bruksNavn = sc.nextLine();
                        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(gårdsNr, bruksNr, bruksNavn, areal, eier)));
                    }
                    else {
                        System.out.println(eiendomRegister.registrereEiendom(new Eiendom(gårdsNr, bruksNr, areal, eier)));
                    }

                    System.out.println("Press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println(eiendomRegister.skriveUtEiendommer());
                    System.out.println("Press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("Kommunenummer: "); int finnKommuneNr= sc.nextInt();
                    System.out.println("Gårdsnummer: "); int finnGårdsNr = sc.nextInt();
                    System.out.println("Bruksnummer: "); int finnBruksNr = sc.nextInt();
                    sc.nextLine();
                    System.out.println(eiendomRegister.søkeEiendom(finnKommuneNr, finnGårdsNr, finnBruksNr));
                    System.out.println("Press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println(eiendomRegister.regneGjennomsnittsAreal() + " kvadratmeter er gjennomsnittsarealet av alle eiendommene i registeret.");
                    System.out.println("Press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("Programmet avsluttes!");
                    fortsett = false;
                    break;

                default:
                    System.out.println("Vennligst velg et av de gyldige alternativene!");
            }
        }
        while(fortsett == true);

    } //main end
} //class end
