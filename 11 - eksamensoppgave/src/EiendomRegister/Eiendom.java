package EiendomRegister;

import java.util.Objects;


/**
 * @Version 1.0 2019
 * @Author William Forbrigd
 *
 * En klasse som representerer en Eiendom i Gloppen.
 * kommuneNavn og kommuneNr er satt til final, ettersom disse attributene er like for alle eiendommene i gloppen.
 * Alle metodene har sin aksessor-metode, ettersom alle attributene skal ha mulighet til å returnere verdier..
 * Er implementert mutator metoder for alle attributene som er mutable.
 * KommuneNavn og kommuneNr derimot er immutable. De kan dermed ikke endres når de først er opprettet, men kun returnere verdier.
 */
public class Eiendom {

    private final String kommuneNavn = "Gloppen";
    private final int kommuneNr = 1445;
    private int gårdsNr;
    private int bruksNr;
    private String bruksNavn;
    private double areal;
    private String eier;

    /**
     * Konstruktør
     * @param gårdsNr
     * @param bruksNr
     * @param bruksNavn
     * @param areal
     * @param eier
     */
    public Eiendom(int gårdsNr, int bruksNr, String bruksNavn, double areal, String eier) {
        this.gårdsNr = gårdsNr;
        this.bruksNr = bruksNr;
        this.bruksNavn = bruksNavn;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Konstruktør
     * @param gårdsNr
     * @param bruksNr
     * @param areal
     * @param eier
     * Lagde en ekstra konstruktør da noen av eiendomene ikke hadde noe bruksnavn.
     */
    //En ekstra konstruktør da et par av eiendommene ikke hadde noe bruksnavn.
    public Eiendom(int gårdsNr, int bruksNr, double areal, String eier) {
        this.gårdsNr = gårdsNr;
        this.bruksNr = bruksNr;
        this.areal = areal;
        this.eier = eier;
    }

    public Eiendom() {}

    public String getKommuneNavnavn() {
        return this.kommuneNavn;
    }

    public int getKommuneNr() {
        return this.kommuneNr;
   }

    public int getGårdsNr() {
        return this.gårdsNr;
   }

   public void setGårdsNr(int nyttGårdsNr) {
        this.gårdsNr = nyttGårdsNr;
   }

    public int getBruksNr() {
        return this.bruksNr;
   }

   public void setBruksNr(int nyttBruksNr) {
        this.bruksNr = nyttBruksNr;
   }

    public String getBruksNavn() {
        return this.bruksNavn;
    }

    public void setBruksNavn(String nyttBruksNavn) {
        this.bruksNavn = nyttBruksNavn;
    }

    public double getAreal() {
        return this.areal;
   }

   public void setAreal(double nyttAreal) {
        this.areal = nyttAreal;
   }

    public String getEier() {
        return this.eier;
   }

   public void setEier(String nyEier) {
        this.eier = nyEier;
   }

    /**
     * Skriver ikke ut bruksnavnet dersom eiendommen ikke har noen.
     * Bruker nummerFormat() for å skrive ut numrene på riktig format.
     * Dette viser god cohesion i den forstand at nummerFormat() metoden blir gjenbrukt.
     *
     * @return en String med alle attributene til en Eiendom i Gloppen.
     */
    //toString metode for å skrive ut eiendommene med alle attributene. Bruker også nummerFormat() metoden.
    public String toString() {
        if(bruksNavn == null) {
            return kommuneNavn + " " + nummerFormat() + " " + areal + " " + eier;
        }
        return kommuneNavn + " " + nummerFormat() + " " + bruksNavn + " " + areal + " " + eier;
    }

    /**
     * Skriver ut henholdsvis kommune-, gårds- og bruksnummer på et spesielt format.
     * @return format i form av en tekst-streng.
     */


    public String nummerFormat() {
        String format = "";
        format += String.format("%d-%d/%d", kommuneNr, gårdsNr, bruksNr);
        return format;
    }

    /**
     * Metoden sjekker om objekter av Eiendom er like.
     * Sammenligner brukesnummeret da alle eiendommene har forskjellig bruksnummer.
     *
     * @param object det vi sammenligner med.
     * @return true eller false dersom this er lik eller ulik objektet.
     */

    @Override
    public boolean equals(Object object) {
        if(this == null)
            return false;
        if(object instanceof Eiendom) {
            Eiendom eiendom = (Eiendom)object;
            return Objects.equals(this.getBruksNr(), eiendom.getBruksNr());
        }
        return false;
    }
} //class end
