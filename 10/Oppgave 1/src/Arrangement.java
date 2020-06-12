import java.util.Comparator;
import java.util.Objects;

/**
 * Klasse for å opprette et Arrangement. Et Arrangement har tilstandene nummer, navn, sted, arrangor, type og tidspunkt.
 * Klassen er mutabel, og på den måten anses det logisk å implementere både tilgangs- og mutasjonsmetoder.
 * Klassen er utført i henhold til prinsippet om innkapsling, og på den måten får man tilgang til objektvariablene
 * gjennom metoder i denne klassen. På den måten er alle variablene satt til private, og man må dermed kalle noen av
 * tilgangsmetodene. Dermed hindrer man direkte tilgang til tilstanden til et Arrangement-objekt fra andre objekter
 * av andre klasser. På den måten er dataene gjemt inne i objektene, og hvordan oppgavene blir løst er gjemt inne i
 * objektene
 *
 * @author William Forbrigd
 * @version 1.0
 *
 *
 */
public class Arrangement {

    //Deklarerer alle objektvariablene i klassen.
    private int nummer;
    private String navn;
    private String sted;
    private String arrangor;
    private String type;
    private long tidspunkt;

    /**
     * Konstruktør som oppretter et objekt av Arrangement.
     * Alle variablene initieres i denne konstruktøren, og på den måten får alle objektvariablene verdi.
     * Dersom en variabel ikke får verdi i konstruktøren som brukes, er det den verdien variabelen får i deklarasonen
     * som gjelder.
     *
     * @param nummer til et Arrangement
     * @param navn som er hva arrangementet heter.
     * @param sted hvor arrangementet blir arrangert.
     * @param arrangor som er hvem som arrangerer.
     * @param type er hva slags type arrangement det er snakk om.
     * @param tidspunkt når arrangemetet arrangeres.
     */
    public Arrangement(int nummer, String navn, String sted, String arrangor, String type, long tidspunkt) {
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    /**
     * Standardkonstruktør som ikke initierer noen av objektvariablene.
     * I utgangspunktet blir en standardkonstruktør implementert dersom det er ingen andre konstruktører i klassen.
     */

    //Jeg har valgt å implementere en standardkonstruktør da den gir mer fleksibilitet. Man kan ha et ønske om
    //å opprettet et objekt uten å fylle ut noen parameter.
    public Arrangement() {}

    //Tilgangs og mutasjonsmetoder
    //Jeg anser det logisk å implementere både tilgangs- og mutasjonsmetoder i den forstand at denne klassen er mutabel.
    //På den måten skal man få tilgang til objektvariablene gjennom tilgangsmetoder som returnerer verdier, og det
    //Skal kunne være heniktsmessig å endre objektvariablene etter at de er deklarert gjennom mutasjonsmetoder.
    /**
     * Tilgangsmetode for nummeret
     * @return nummeret til et Arrangement
     */

    public int getNummer() {
        return nummer;
    }

    /**
     * Tilgangsmetode for navnet
     * @return navnet til et arrangement
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Tilgangsmetode for stedet
     * @return stedet til et Arrangement
     */
    public String getSted() {
        return sted;
    }

    /**
     * Tilgangsmetode for arrangøren
     * @return hvem som arrangerer
     */

    public String getArrangor() {
        return arrangor;
    }

    /**
     * Tilgangsmetode for hva slags type arrangementet er
     * @return type til arrangementet.
     */
    public String getType() {
        return type;
    }

    /**
     * Tilgangsmetode for tidspunktet
     * @return tidspunktet til et arrangement
     */
    public long getTidspunkt() {
        return tidspunkt;
    }

    /**
     * Mutasjonsmetode for å endre nummeret
     * @param nummer som er det nye nummeret
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Mutasjonsmetode for å endre navn
     * @param navn som er det nye navnet
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * Mutasjonsmetode for sted
     * @param sted det nye stedet.
     */
    public void setSted(String sted) {
        this.sted = sted;
    }

    /**
     * Mutasjonsmetode for arrangør
     * @param arrangor den nye arrangøren
     */
    public void setArrangor(String arrangor) {
        this.arrangor = arrangor;
    }

    /**
     * Mutasjonsmetode for type
     * @param type som er den nye typen til arrangementet
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Mutasjonsmetode for å endre tidspunkt
     * @param tidspunkt som er det nye tidspunktet
     */

    public void setTidspunkt(long tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    /**
     * Indikerer om et objekt er likt et objekt av denne klassen.
     * This refererer til et objekt av klassen Arrangement. Objektet som sendes inn som parameter,
     * er et tilfeldig objekt.
     * Er en egendefinert utgave av equals() som overskriver equals()-metoden som arves fra klassen Object. Object er
     * bestefaren til alle til alle objekter, og er allerede bygget en equals()-metode som sjekker om minnereferansen
     * er den samme. Ved å overskrive denne metoden, sikrer man seg at denne egendefinerte equals()-metoden blir
     * brukt for å sjekke minnereferansen. Dette er svært hensiktsmessig i den forstand at i java er det ikke
     * gitt om et objekt er likt et annet.
     * Equals tar inn et objekt og sammenligner to objekter av forskjellige klasser.
     *
     * @param object er referanseobjektet som skal sammenlignes.
     * @return true dersom minnereferansen til "this" objektet er likt som objektet som sendes inn som argument.
     */

    //Jeg anser det som logisk å implementere en egendefinert equals()-metode, fordi i Java ikke er gitt hva
    //som gjør at to objekter er like. På den måten kan jeg sjekke objekter har samme innhold, altså at de nødvendigvis
    //ikke er indentiske objekter, men oppfører seg likt. Jeg kan selv definere hva som gjør at to objekter
    //av denne klassen er like, og jeg anser det som logisk å sammenligne både navnet og stedet til to arrangementer.

    //Overskriver equals metoden som arves fra klassen Object.
    @Override
    //Sender inn et objekt som parameter, slik at jeg kan sammeligne to objekter av forskjellige klasser.
    public boolean equals(Object object) {
        //Sjekker først om objektet som sendes inn er gyldig. Blir unødvendig å
        //sammenligne et ugyldig objekt som er helt tomt.
        if(object == null) return false;
        //Dersom referansene er de samme, vil det returneres true og dette kan vil være en rask løsning.
        if(this == object) return true;
        //Sjekker om objektet er et objekt av klassen og på den måte sjekkes det om objektene har samme klasse
        //tilhørighet.
        if(object instanceof Arrangement) {
            //Dersom objektene har samme klassetilhørighet, vil objektet castes, eller med andre ord gjøres om, til et
            //objekt av klassen. På den måten kan man bruke metodene i denne klassen for å sammenligne de ønskede
            //attributtene.
            Arrangement arrangement = (Arrangement) object;
            //Bruker this for å kunne refere til en instansvariabel/objektvariabel av denne klassen.
            //This sammenlignes med objektet som har blitt gjort om
            //til et objekt av denne klassen. Returnerer true dersom de i dette tilfellet har samme tid.
            return this.navn.equals(arrangement.getNavn()) && this.sted.equals(arrangement.getSted());
        }
        //Returnerer false dersom de ikke har samme tid.
        return false;
    }

    /**
     * Metode som sammenligner "this" objektet med objektet som sendes inn som argument. Denne metoden kan anses som
     * svært nyttig i tilfeller hvor man er nødt til å sortere objekter i en bestemt rekkefølge.
     *
     * @param arrangement som er Arrangement-objektet som skal sammenlignes.
     * @return en negativ integer, null, eller en positiv integer dersom "this" objektet er henholdsvis mindre enn,
     * lik, eller større enn objektet som sendes inn som argument.
     */

    //Jeg anser det som logisk å implementere en compareTo()-metode for å kunne sortere alle Arrangementene
    //etter hvilket arrangement som blir arrangert først og hvilket som blir arrangert sist. Er dermed enklere
    //å holde oversikt over hvilke arrangementer kan kan dra på når de er sortert etter hvilke arrangementer som blir
    //arrangert først og så videre.
    public int compareTo(Arrangement arrangement) {
        return Long.compare(this.tidspunkt, arrangement.getTidspunkt());
    }

    /**
     * toString()-metode som er forebeholdt å skrive ut objeketvariablene til et objekt av klassen.
     * @return en tekststreng med henholdsvis nummer, navn, sted, arrangør, type og tidspunkt til et arrangement.
     */
    public String toString() {
        return nummer + ": " + navn + ", " + sted + ", " + arrangor + " " + type + ", " + tidspunkt;
     }
}

/**
 * Interfacet Comparator tilbyr sortering av objekter for hver klasse som implementerer denne. Denne sorteringen er
 * referert til som klassens naturlige orden, og klassens compareTo()-metode anses som klassens naturlige
 * sammenligningsmetode.
 * Dette interfacet består dermed av en tom compare()-metode som må fylles ut.
 * På den måten kan en samling av objekter sorteres etter tidspunkt ved å hente ut denne Comparator-klassen.
 * Bruker en compare()-metode i klassen Long for å kunne sammenligne to long-verdier numerisk.
 * Compare-metoden returnerer en negativ integer, null eller en positiv integer dersom a1-objektet er henholdsvis
 * mindre enn, lik eller større enn a2-objektet.
 */
class sortertArrangementTidspunkt implements Comparator<Arrangement> {
    //Fyller ut compare()-metoden som er metodesignaturen i interfacet Comparator som må fylles ut.
    public int compare(Arrangement a1, Arrangement a2) {
        //Bruker en metode i klassen Long for å sammenligne to long-verdier numerisk.
        return Long.compare(a1.getTidspunkt(), a2.getTidspunkt());
    }
}

/**
 * Interfacet Comparator tilbyr sortering av objekter for hver klasse som implementerer denne. Denne sorteringen er
 * referert til som klassens naturlige orden, og klassens compareTo()-metode anses som klassens naturlige
 * sammenligningsmetode.
 * Dette interfacet består dermed av en tom compare()-metode som må fylles ut.
 * Dermed kan en samling av objekter sorteres etter henholdsvis sted, type og tidspunkt.
 * Som konstatert, returnerer compare()-metoden en negativ integer, null eller en positiv integer dersom a1-objektet
 * er henholdsvis mindre enn, lik eller større enn a2-objektet.
 * Dermed kan først stedet to til arrangementer sammenlignes. Dersom de er like og returnerer null, er det stedet som
 * sammenlignes. Dersom de også skulle ha samme sted, vil det til slutt være tidspunktet som sammenlignes.
 */
class sortertStedTypeTid implements Comparator<Arrangement> {
    //Fyller ut compare()-metoden som er metodesignaturen i interfacet Comparator som må fylles ut.
    public int compare(Arrangement a1, Arrangement a2) {
        //Deklarerer en int verdi for den integeren som returneres når stedene til arrangementene sammenlignes.
        int c = a1.getSted().compareTo(a2.getSted());
        if(c == 0) {
            //Dersom denne int-verdien skulle være null, vil den initieres på nytt slik at det er stedene som
            //sammenlignes.
            c = a1.getType().compareTo(a2.getType());
        }
        if(c == 0) {
            //Dersom null blir returnert når stedene sammenlignes, vil int-verdien initieres på nytt slik at det er
            //tindspunktene som sammenlignes.
            c = Long.compare(a1.getTidspunkt(), a2.getTidspunkt());
        }
        //returnerer denne verdien slik at objektene kan bli sortert etter henholdsvis sted, type og tidspunkt.
        return c;
    }
}





