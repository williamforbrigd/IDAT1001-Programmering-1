public class nyString {

    private final String string;

    public nyString(String string) {
        this.string = string;
    }

    public char[] forkort() {
        int antall = 0;
        String[] ordTabell = string.split(" ");
        char[] forsteBokstav = new char[ordTabell.length];
        for(int i = 0; i < ordTabell.length; i++) {
            forsteBokstav[i] = ordTabell[i].charAt(0);
        }
        return forsteBokstav;
    }

    public String fjerningTegn(char bokstav) {
        String nyTekst = this.string;
        while(nyTekst.indexOf(bokstav) > -1) {
            nyTekst = nyTekst.substring(0, nyTekst.indexOf(bokstav)) + nyTekst.substring(nyTekst.indexOf(bokstav)+1);
        }
        return nyTekst;
    }
}
