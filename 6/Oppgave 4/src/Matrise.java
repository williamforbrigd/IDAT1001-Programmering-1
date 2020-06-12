public class Matrise {

    private final int RADER = 4;
    private final int KOLONNER = 4;

    private int[][] matrise = new int[RADER][KOLONNER];

    public Matrise(int[][] matrise) {
        this.matrise = matrise;
    }

    public int[][] getMatrise() {
        return matrise;
    }

    public int[][] summerMatrise(Matrise matriseObjekt) {
        int[][] nyMatrise = matriseObjekt.getMatrise();
        for(int x = 0; x < matrise.length; x++) {
            for(int y = 0; y < matrise[0].length; y++) {
                matrise[x][y] += nyMatrise[x][y];
            }
        }
        return matrise;
    }

    public int[][] multipliserMatrise(Matrise matriseObjekt) {
        int[][] nyMatrise = matriseObjekt.getMatrise();
        int[][] matriseProdukt = new int[RADER][KOLONNER];
        for (int x = 0; x < matrise.length; x++) {
            for (int y = 0; y < matrise[0].length; y++) {
                for(int i = 0; i < matrise.length; i++) {
                    matriseProdukt[x][y] += matrise[x][i] * nyMatrise[i][y];
                }
            }
        }
        return matriseProdukt;
    }

    public int[][] transponerMatrise() {
        int[][] nyMatrise = new int[RADER][KOLONNER];
        for(int x = 0; x < matrise.length; x++) {
            for(int y = 0; y < matrise[0].length; y++) {
                nyMatrise[x][y] = matrise[y][x];
            }
        }
        return nyMatrise;
    }

    public void skriveUtMatrise(int[][] matrise) {
        for(int[] rader : matrise) {
            for (int kolonner : rader) {
                System.out.print(kolonner + " ");
            }
            System.out.print("\n");
        }

    }
}
