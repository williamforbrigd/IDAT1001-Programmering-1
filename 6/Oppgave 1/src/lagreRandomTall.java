import java.util.Random;
import java.lang.Math;
import java.util.stream.IntStream;

public class lagreRandomTall {
    public static void main(String[]args) {
        Random random = new Random();

        int tall;
        int[] antall = new int[10];
        String stjerne = "*";
        int antallGjennomløp = 10000;


        for(int i = 0; i < antallGjennomløp; i++) {
            tall = random.nextInt(10);
            antall[tall]++;
        }

        for(int i = 0; i < antall.length; i++) {
            System.out.println(i + ": " + antall[i]);
            for(int j = 0; j < Math.round(antall[i]/10); j++) {
                System.out.print(stjerne);
            }
            System.out.print("\n");
        }
        IntStream stream = IntStream.of(antall);
        System.out.println("-----------");
        System.out.println(stream.sum());
    }
}
