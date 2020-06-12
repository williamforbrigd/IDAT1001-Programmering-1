import java.util.Random;

public class Spiller {

    public String name;
    public int sumPoeng;

    public Spiller(String name) {
        this.name = name;
        this.sumPoeng = 0;
    }

    public String getName() {
        return name;
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public int kastTerningen() {
        Random random = new Random();
        int terningKast = random.nextInt(6) + 1;

        if(terningKast == 1)
            sumPoeng = 0;
        if(sumPoeng > 100)
            sumPoeng -= terningKast;
        if(sumPoeng < 100)
            sumPoeng += terningKast;

        return terningKast;
    }

    public boolean erFerdig() {
        if(sumPoeng == 100)
            return true;

        return false;
    }

    public String toString() {
        return name + " " + sumPoeng;
    }
}