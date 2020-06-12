import java.util.Arrays;

public class TekstAnalyse2 {

    private int[] antallTegn = new int[30];
    private final int APOS = 'a';
    private final int ZPOS = 'z';
    private final int ÆPOS = 'æ';
    private final int ØPOS = 'ø';
    private final int ÅPOS = 'å';

    private String tekst;

    public TekstAnalyse2(String tekst) {
        this.tekst = tekst.toLowerCase();

        for(int i = 0; i < this.tekst.length(); i++) {
            char tegn = this.tekst.charAt(i);
            int posisjon = tegn;

            if((posisjon - APOS) >= 0 && (posisjon - APOS) < antallTegn.length)
                antallTegn[posisjon - APOS]++;
            else if(posisjon == ÆPOS)
                antallTegn[26]++;
            else if(posisjon == ØPOS)
                antallTegn[27]++;
            else if(posisjon == ÅPOS)
                antallTegn[28]++;
            else
                antallTegn[29]++;
        }
    }

    public int finnAntallUlikeBokstaver() {
        int antall = 0;
        for(int i = 0; i < antallTegn.length-1; i++) {
            if(antallTegn[i] != 0)
                antall++;
        }
        return antall;
    }

    public int finnTotaltAntallBokstaver() {
        int antall = 0;
        for(int i = 0; i < antallTegn.length-1; i++) {
            if(antallTegn[i] != 0)
                antall += antallTegn[i];
        }
        return antall;
    }

    public double finnProsentIkkeBokstaver() {
        double prosent = (double)antallTegn[29] / tekst.length() * 100;
        return prosent;
    }

    public int forekomstBestemtBokstav(char bokstav) {
        int antall = 0;
        for(int i = 0; i < tekst.length(); i++) {
            if(tekst.charAt(i) == bokstav)
                antall++;
        }
        return antall;
    }

    public int finnMaks() {
        int maks = 0;
        for(int i = 0; i < antallTegn.length-1; i++) {
            if(antallTegn[i] > maks)
                maks = antallTegn[i];
        }
        return maks;
    }

    public String finnAlleBokstaveneMaks() {
        char[] alfabet = "abcdefghijklmnopqrstuvwxyzæøå".toCharArray();
        int maks = finnMaks();
        int posisjon = 0;
        int[] flereAvMaks = new int[] {};
        char[] alleBokstaveneMaks = new char[] {};
        String println = "";

        //Finne ut om det er flere bokstaver som forekommer like mange ganger som maks.
        for(int i = 0; i < antallTegn.length - 1; i++) {
            if(antallTegn[i] == maks) {
                flereAvMaks = Arrays.copyOf(flereAvMaks, flereAvMaks.length + 1);
                flereAvMaks[posisjon] = i;
                posisjon++;
            }
        }

        //Legge bokstavene med størst forekomst inn i char-arrayen.
        for(int i = 0; i < flereAvMaks.length; i++) {
            alleBokstaveneMaks = Arrays.copyOf(alleBokstaveneMaks, alleBokstaveneMaks.length + 1);
            alleBokstaveneMaks[i] = alfabet[flereAvMaks[i]];
        }

        for(int i = 0; i < alleBokstaveneMaks.length; i++) {
            println += alleBokstaveneMaks[i] + " forekommer " + maks + " ganger.";
        }
        return println;
    }
}
