import java.util.GregorianCalendar;

public class ArbTaker {

    private Person personalia;
    private int arbTakerNr;
    private int ansettelsesAar;
    private double mndLonn;
    private double skatteProsent;

    private GregorianCalendar kalender = new GregorianCalendar();
    private int år = kalender.get(java.util.Calendar.YEAR);

    /*
    public ArbTaker(int arbTakerNr, int ansettelsesAar, double mndLonn, double skatteProsent) {
        personalia = new Person(personalia.getFornavn(), personalia.getEtternavn(), personalia.getFodselsaar());
        this.arbTakerNr = arbTakerNr;
        this.ansettelsesAar = ansettelsesAar;
        this.mndLonn = mndLonn;
        this.skatteProsent = skatteProsent;
    }

     */

    public ArbTaker(Person person, int arbTakerNr, int ansettelsesAar, double mndLonn, double skatteProsent) {
        personalia = person;
        this.arbTakerNr = arbTakerNr;
        this.ansettelsesAar = ansettelsesAar;
        this.mndLonn = mndLonn;
        this.skatteProsent = skatteProsent;
    }

    public ArbTaker() {}

    public Person getPersonalia() {
        return personalia;
    }

    public int getArbTakerNr() {
        return arbTakerNr;
    }

    public int getAnsettelsesAar() {
        return ansettelsesAar;
    }

    public double getMndLonn() {
        return mndLonn;
    }

    public double getSkatteProsent() {
        return skatteProsent;
    }

    public void setPersonalia(Person personalia) {
        this.personalia = personalia;
    }

    public void setArbTakerNr(int arbTakerNr) {
        this.arbTakerNr = arbTakerNr;
    }

    public void setAnsettelsesAar(int ansettelsesAar) {
        this.ansettelsesAar = ansettelsesAar;
    }

    public void setMndLonn(double mndLonn) {
        this.mndLonn = mndLonn;
    }

    public void setSkatteProsent(double skatteProsent) {
        this.skatteProsent = skatteProsent;
    }

    public double skattPrMnd() {
        return skatteProsent * mndLonn;
    }

    public double bruttoLønn() {
        return mndLonn * 12;
    }

    public double skatteTrekkPerÅr() {
        double skattPerÅr = (skattPrMnd()* 10) + (skattPrMnd()/2);


        return skattPerÅr;
    }

    public String navnForm() {
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }

    public int alder() {
        int fodselsÅr = personalia.getFodselsaar();

        return år-fodselsÅr;
    }

    public int ansattIBedriften() {
        return år-ansettelsesAar;
    }

    public boolean ansattGittAntallÅr(int antallÅr) {
        return (antallÅr <= ansattIBedriften()) ? true : false;
    }

}
