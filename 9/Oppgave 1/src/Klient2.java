import java.util.Scanner;
import java.util.HashMap;

public class Klient2 {
    public static void main(String[]args) {

        Klient2 klient2 = new Klient2();
        klient2.start();

    }

    public int visMeny() {

        Scanner sc = new Scanner(System.in);

        int visMeny = 0;
        System.out.println("----Applikasjon for oversikt over oppgaver til studenter----");
        System.out.println("1: Finn antall studenter registrert");
        System.out.println("2: Finn antall oppgaver som en bestemt student har løst");
        System.out.println("3: Registrer ny student");
        System.out.println("4: Øk antall oppgaver for en bestemt student");
        System.out.println("5: Skriv ut informasjon om alle studenter");
        System.out.println("6: Avslutt");

        if(sc.hasNextInt())
            visMeny = sc.nextInt();

        else
            System.out.println("Vennligst tast inn et av de gyldige alternativene");

        return visMeny;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Student> studenter = new HashMap<Integer, Student>();
        OppgaveOversikt2 oversikt = new OppgaveOversikt2(studenter);



        boolean fortsett = true;

        while(fortsett) {

            int visMeny = this.visMeny();
            switch(visMeny) {

                case 1:
                    System.out.println(oversikt.getAntStud());
                    break;

                case 2:
                    System.out.println("Hva heter studenten?"); String navn = sc.nextLine();
                    System.out.println(oversikt.antOppgStudent(navn));
                    break;

                case 3:
                    System.out.println("Hva heter studenten?"); String regNavn = sc.nextLine();
                    System.out.println("Hvor mange oppgaver har studenten løst?"); int antOppg = sc.nextInt();
                    sc.nextLine();
                    if(oversikt.regStudent(new Student(regNavn, antOppg))) {
                        System.out.println("Studenten ble registrert");
                        break;
                    }

                    else {
                        System.out.println("Studenten ble ikke registrert");
                        break;
                    }

                case 4:
                    System.out.println("Hva heter studenten?"); String finnNavn = sc.nextLine();
                    System.out.println("Hvor mange oppgaver skal økes med?"); int økning = sc.nextInt();
                    sc.nextLine();
                    if(oversikt.økAntOppg(finnNavn, økning))
                        System.out.println("Studenten har økt antall oppgaver");
                    else
                        System.out.println("Studenten har ikke økt antall oppgaver");

                    break;

                case 5:
                    System.out.println(oversikt.listAlleStudenter());
                    break;

                case 6:
                    System.out.println("Programmet avsluttes");
                    fortsett = false;
                    break;
            }
        }

    }
}
