import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        int[][] matrise1 = {{7,5,4,3}, {6,4,5,3}, {10,13,1,3}, {9,8,3,2}};
        int[][] matrise2 = {{7,5,4,3}, {6,4,5,3}, {10,13,1,3}, {9,8,3,2}};
        int[][] matrise3 = {{1,5,4,2}, {3,4,5,3}, {1,2,1,3}, {9,7,2,2}};

        Matrise m1 = new Matrise(matrise1);
        Matrise m2 = new Matrise(matrise2);
        Matrise m3 = new Matrise(matrise3);

        Scanner sc = new Scanner(System.in);
        int velg = sc.nextInt();

        final int SUMMER = 1;
        final int MULTIPLISER = 2;
        final int TRANSPONER = 3;

        switch(velg) {
            case SUMMER:
                m1.skriveUtMatrise(m1.summerMatrise(m2));
                break;

            case MULTIPLISER:
                m1.skriveUtMatrise(m1.multipliserMatrise(m2));
                break;

            case TRANSPONER:
                m3.skriveUtMatrise(m3.transponerMatrise());
                break;

        }
    }
}
