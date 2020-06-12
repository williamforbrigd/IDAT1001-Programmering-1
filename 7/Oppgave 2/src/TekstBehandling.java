public class TekstBehandling {

    private String tekst;

    public TekstBehandling(String tekst) {
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public String getTekstStoreBokstaver() {
        return tekst.toUpperCase();
    }

    public int antallOrd() {
        int antallOrd = 0;
        String[] tekstArr = tekst.split(" ");
        for(int i = 0; i < tekstArr.length; i++) {
            antallOrd++;
        }
        return antallOrd;
    }

    public int antallBokstaver() {
        int antallBokstaver = 0;
        for(int i = 0; i < tekst.length(); i++) {
            if(Character.isLetter(tekst.charAt(i)))
                antallBokstaver++;
        }
        return antallBokstaver;
    }

    public double gjennomsnittOrdLengde() {
        int antallBokstaver = antallBokstaver();
        int antallOrd = antallOrd();

        return (double)antallBokstaver / (double)antallOrd;
    }

    public double gjennomsnittPeriode() {
        int antallBokstaver = antallBokstaver();
        int antallPerioder = 0;

        for(int i = 0; i < tekst.length(); i++) {
            if(!Character.isLetter(tekst.charAt(i)) && tekst.charAt(i) != ' ')
                antallPerioder++;
        }
        return (double)antallBokstaver / (double)antallPerioder;
    }

    public String skiftUtOrd(String finnOrd, String nyttOrd) {
        String nyTekst = "";
        nyTekst += tekst.replaceAll(finnOrd, nyttOrd);
        return nyTekst;
    }
}
