import java.util.Random;

public class MinRandom {
    private Random random;

    public MinRandom() {
        random = new Random();
    }

    public int nesteHeltall(int nedre, int ovre) {
        int tilfeldigHeltall = nedre + random.nextInt(ovre - nedre + 1);
        return tilfeldigHeltall;
    }

    public double nesteDesimtaltall(double nedre, double ovre) {
        boolean trekk = false;
        double tall;
        double differanse = ovre - nedre;


        do {
            tall = random.nextDouble();
            if(tall == 0.0) trekk = true;
        }
        while(trekk);
            tall = tall * differanse + nedre;
            return tall;
        }
    }




