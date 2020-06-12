import java.util.Scanner;

public class Klient {
    public static void main(String[]args) {

        System.out.println("1: Summer");
        System.out.println("2: Subtraher");
        System.out.println("3: Multipliser");
        System.out.println("4: Divider");
        System.out.println("5: Avlustt");

        boolean fortsett = true;

        do {
            Scanner sc = new Scanner(System.in);
            int velg = sc.nextInt();

            switch(velg) {
                case 1:
                    Brøk b1 = new Brøk(7, 10);
                    Brøk b2 = new Brøk(5,6);
                    b1.summerBrøk(b2);
                    System.out.println(b1);
                    break;
                case 2:
                    Brøk b3 = new Brøk(7, 10);
                    Brøk b4 = new Brøk(5,6);
                    b3.subtrahereBrøk(b4);
                    System.out.println(b3);
                    break;
                case 3:
                    Brøk b5 = new Brøk(7, 10);
                    Brøk b6 = new Brøk(5, 6);
                    b5.multiplisereBrøk(b6);
                    System.out.println(b5);
                    break;
                case 4:
                    Brøk b7 = new Brøk(7, 10);
                    Brøk b8 = new Brøk(5, 6);
                    b7.dividereBrøk(b8);
                    System.out.println(b7);
                    break;
                case 5:
                    System.out.println("Programmet avluttes.");
                    fortsett = false;
                    break;
                default:
                    System.out.println("Vennligst tast inn et av de gyldige alternativene.");
            }
        }
        while(fortsett == true);
    }
}
