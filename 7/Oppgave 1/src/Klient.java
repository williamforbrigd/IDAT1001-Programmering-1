import java.util.Arrays;

public class Klient {
    public static void main(String[]args) {

        String string = "Hei hva skjer";


        nyString tekst = new nyString(string.toLowerCase());



        System.out.println(Arrays.toString(tekst.forkort()));

        System.out.println(tekst.fjerningTegn('h'));
    }
}
