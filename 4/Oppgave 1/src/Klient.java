import java.util.Scanner;

public class Klient {
    public static void main(String[]args) {

        Scanner sc = new Scanner(System.in);

        Valuta USD = new Valuta(9.12);
        Valuta EUR = new Valuta(10.11);
        Valuta SEK = new Valuta(0.95);

        boolean fortsett = true;

        do {
            System.out.println("Velg valuta.");
            System.out.println("-------------");
            System.out.println("1: dollar");
            System.out.println("2: euro");
            System.out.println("3: svenske kroner");
            System.out.println("4: avslutt");

            int velg = sc.nextInt();
            sc.nextLine();


            switch(velg) {
                case 1:
                    System.out.println("Gjøre om til (1) eller fra (tast inn hvilket som helst annet tallx) norske kroner?");
                    int velgIgjen = sc.nextInt();
                    sc.nextLine();
                    if(velgIgjen == 1) {
                        System.out.println("Hvor mange dollar?");
                        int antallUSD = sc.nextInt();
                        sc.nextLine();
                        System.out.println(antallUSD + " dollar er " + USD.tilNOK(antallUSD) + " norske kroner.");
                    }
                    else {
                        System.out.println("Hvor mange norske?");
                        int antallNOK = sc.nextInt();
                        sc.nextLine();
                        System.out.println(antallNOK + " nok er " + USD.fraNOK(antallNOK) + " dollar.");
                    }
                    System.out.println("Vennligst press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("Gjøre om til (1) eller fra (2) norske kroner?");
                    velgIgjen = sc.nextInt();
                    sc.nextLine();
                    if(velgIgjen == 1) {
                        System.out.println("Hvor mange euro?");
                        int antallEUR = sc.nextInt();
                        sc.nextLine();
                        System.out.println(antallEUR + " euro er " + EUR.tilNOK(antallEUR) + " norske kroner.");
                    }
                    if(velgIgjen == 2) {
                        System.out.println("Hvor mange norske?");
                        int antallNOK = sc.nextInt();
                        sc.nextLine();
                        System.out.println(antallNOK + " nok er " + EUR.fraNOK(antallNOK) + " euro.");
                    }
                    System.out.println("Vennligst press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("Gjøre om til (1) eller fra (2) norske kroner?");
                    velgIgjen = sc.nextInt();
                    sc.nextLine();
                    if(velgIgjen == 1) {
                        System.out.println("Hvor mange svenske kroner?");
                        int antallSEK = sc.nextInt();
                        sc.nextLine();
                        System.out.println(antallSEK + " sek er " + SEK.tilNOK(antallSEK) + " norske kroner.");
                    }
                    if(velgIgjen == 2) {
                        System.out.println("Hvor mange norske?");
                        int antallNOK = sc.nextInt();
                        sc.nextLine();
                        System.out.println(antallNOK + " nok er " + SEK.fraNOK(antallNOK) + " sek.");
                    }
                    System.out.println("Vennligst press enter for å fortsette.");
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println("Programmet avsluttes!");
                    fortsett = false;
                    break;

                default:
                    System.out.println("Vennligst velg et av de gyldige alternativene!");
            }
        }
        while(fortsett == true);
    }
}
