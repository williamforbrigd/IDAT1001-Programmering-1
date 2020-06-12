import java.util.Scanner;

public class Klient {
    public static void main(String[]args) {

        Klient klient = new Klient();
        klient.start();

    }

    public int visMeny() {

        Scanner sc = new Scanner(System.in);

        int visMeny = 0;
        System.out.println("----Applikasjon for MenyRegister----");
        System.out.println("1: Registrere en ny rett");
        System.out.println("2: Finne en rett, gitt navnet.");
        System.out.println("3: Finne alle retter av en gitt type.");
        System.out.println("4: Registrere en ny meny som består av ett sett med retter");
        System.out.println("5: Finne alle menyer med totalpris innenfor et gitt intervall.");
        System.out.println("6  Skriv ut alle menyene");
        System.out.println("7: Avslutt");

        if(sc.hasNextInt()) {
            visMeny = sc.nextInt();
            sc.nextLine();
        }

        else
            System.out.println("Vennligst tast inn et av de gyldige alternativene");

        return visMeny;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        MenyRegister menyRegister = new MenyRegister();

        Rett r1 = new Rett("Pizza", "hovedrett", 75.6, "bunn, tomatsaus, ost og pepperoni");
        Rett r2 = new Rett("Pasta bolognais", "hovedrett", 65.7, "spaghetti, tomatsaus, ost og kjøtt");
        System.out.println(menyRegister.regMenyMedRetter(new Meny("Italiensk meny"), r1, r2));

        boolean fortsett = true;

        while(fortsett) {

            int visMeny = this.visMeny();
            switch (visMeny) {

                case 1:
                    System.out.println("Hva heter menyen som retten skal registreres på?");
                    String menyNavn = sc.nextLine();
                    if (menyRegister.finnMenyGittNavn(menyNavn) != -1) {
                        if (menyRegister.regRett(menyNavn, new Rett("Tiramisu", "Dessert", 50.6,
                                "Krem og fløte"))) {
                            System.out.println("Retten ble registrert på menyen");
                        } else
                            System.out.println("Retten ble ikke reistrert");
                    } else
                        System.out.println("Fant ikke den menyen du lette etter");

                    System.out.print("\n");
                    System.out.println("Vennligst press enter for å fortsette");sc.nextLine();

                    break;

                case 2:
                    System.out.println("Hva heter retten du leter etter?");
                    String rettNavn = sc.nextLine();
                    if (menyRegister.finnRettNavn(rettNavn) != null) {
                        System.out.println("Retten med det gitte navnet er: ");
                        System.out.println(menyRegister.finnRettNavn(rettNavn));
                    } else
                        System.out.println("Fant ikke retten du lette etter");

                    System.out.print("\n");
                    System.out.println("Vennligst press enter for å fortsette"); sc.nextLine();

                    break;

                case 3:
                    System.out.println("Hva slags type retter leter du etter?");
                    String type = sc.nextLine().toLowerCase();
                    if (menyRegister.finnRetterType(type) != null) {
                        System.out.println("Alle rettene gitt den bestemte typen: ");
                        System.out.println(menyRegister.skrivUtRetter(menyRegister.finnRetterType(type)));
                    } else
                        System.out.println("Fant ingen av de type rettene du lette etter");

                    System.out.print("\n");
                    System.out.println("Vennligst press enter for å fortsette"); sc.nextLine();

                    break;

                case 4:
                    Rett r3 = new Rett("Taco", "hovedrett", 50.6, "Lefse, kjøtt, ost, guac og rømme");
                    Rett r4 = new Rett("Quasedilla", "hovedrett", 60.5, "Lefse, kjøtt, ost, guac og rømme");
                    Meny m1 = new Meny("Meksikansk meny");
                    if (menyRegister.regMenyMedRetter(m1, r3, r4)) {
                        System.out.println("Menyen med rettene ble registrert");
                    } else
                        System.out.println("Fikk ikke registrert menyen med rettene");


                    System.out.print("\n");
                    System.out.println("Vennligst press enter for å fortsette"); sc.nextLine();


                    break;

                case 5:

                    if (menyRegister.finnMenyerPrisIntervall(100, 300) != null) {
                        System.out.println("Alle menyene med totalpris innenfor det gitte prisintervallet er: ");
                        System.out.println(menyRegister.skrivUtMenyer(menyRegister.finnMenyerPrisIntervall(100, 300)));
                    }
                    else
                        System.out.println("Fant ingen menyer med totalpris innenfor det gitte prisintervallet");

                    System.out.print("\n");
                    System.out.println("Vennligst press enter for å fortsette"); sc.nextLine();

                    break;

                case 6:

                    System.out.println(menyRegister.skrivUtMenyer());

                    System.out.print("\n");
                    System.out.println("Vennligst press enter for å fortsette"); sc.nextLine();

                    break;

                case 7:
                    System.out.println("Programmet avsluttes");
                    fortsett = false;
                    break;

            }
        }

    }
}