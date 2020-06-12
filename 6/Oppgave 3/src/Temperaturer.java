import java.util.Random;

public class Temperaturer {

    private final int RADER = 2;
    private final int KOLONNER = 2;
    private int[][] desember;

    public Temperaturer() {
        desember = new int[RADER][KOLONNER];
    }

    public void setTemperatuerer() {
        desember = new int[][]{{1, 2}, {5, 7}};
    }

    public int[][] get2DArray() {
        return desember;
    }

    public void skrivUt2DArray() {
        for(int[] rad : desember) {
            for(int kolonne : rad) {
                System.out.print(kolonne + " ");
            }
            System.out.println();
        }
    }

    public String skrivUtArray(double[] array) {
        String println = "";
        for(double i : array)
            println += i + " ";

        return println;
    }

    public String skrivUtIntArray(int[] array) {
        String println = "";
        for(int i : array)
            println += i + " ";

        return println;
    }


    public double[] getMiddelDag() {
        double[] totalTempPerDag = new double[get2DArray().length];
        double[] middelTemperaturPerDag = new double[get2DArray().length];

        for(int i = 0; i < desember.length; i++) {
            for(int j = 0; j < desember[0].length; j++) {
                totalTempPerDag[i] += desember[i][j];
            }
            middelTemperaturPerDag[i] = totalTempPerDag[i] / desember[0].length;
        }
        return middelTemperaturPerDag;
    }

    public double[] getMiddelTemperaturTime() {
        double[] totalTemperatur = new double[get2DArray()[0].length];
        double[] middelTempTime = new double[get2DArray()[0].length];

        for(int j = 0; j < desember[0].length; j++) {
            for(int i = 0; i < desember.length; i++) {
                totalTemperatur[j] += desember[i][j];
            }
            middelTempTime[j] = totalTemperatur[j] / desember[0].length;
        }

        return middelTempTime;
    }

    public double getMiddelTemperaturMnd() {
        int totalTemperatur = 0;
        double middelTempMnd = 0;

        for(int i = 0; i < desember.length; i++) {
            for(int j = 0; j < desember[0].length; j++) {
                totalTemperatur += desember[i][j];
            }
        }
        middelTempMnd = (double)totalTemperatur / (desember[0].length * desember.length);
        return middelTempMnd;
    }

    public int[] middelTempInnenforGrense() {
        int[] grupper = new int[5];

        for(int i = 0; i < getMiddelDag().length; i++) {
            if(getMiddelDag()[i] < -5)
                grupper[0]++;
            if(getMiddelDag()[i] > -5 && getMiddelDag()[i] < 0)
                grupper[1]++;
            if(getMiddelDag()[i] > 0 && getMiddelDag()[i] < 5)
                grupper[2]++;
            if(getMiddelDag()[i] > 5 && getMiddelDag()[i] < 10)
                grupper[3]++;
            if(getMiddelDag()[i] > 10)
                grupper[4]++;
        }
        return grupper;
    }
}
