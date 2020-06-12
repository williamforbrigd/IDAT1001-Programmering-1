public class Valuta {

    private double omgjøringsKurs;

    public Valuta(double omgjøringsKurs) {
        this.omgjøringsKurs = omgjøringsKurs;
    }

    public Valuta() {}

    public double tilNOK(int antallValuta) {
        double NOK = antallValuta * omgjøringsKurs;
        return NOK;
    }

    public double fraNOK(int antallNOK) {
        double valuta = antallNOK / omgjøringsKurs;
        return valuta;
    }
}
