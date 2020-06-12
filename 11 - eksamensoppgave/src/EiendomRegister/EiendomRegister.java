package EiendomRegister;

import java.util.ArrayList;


/**
 * @Version 1.0 2019
 * @Author William Forbrigd
 *
 * En klasse som representerer eiendomsregisteret.
 * Jeg valgte å håndtere samling av eiendommer ved å bruke en ArrayList, ettersom du kan legge til og fjerne elementer fra en slik liste hele tiden.
 * I denne sammenhengen er det svært hensiktsmessig å bruke en dynamisk tabell, i den forstand at et eiendomsregister ikke har noen bestemt størrelse.
 * Det både bygges og rives eiendommer hele tiden.
 *
 * Jeg mener implementasjonen er utført bra i henhold til prinsipet om kobling.
 * Klassene EiendomRegister og Eiendom er på en måte svært avhengig av hverandre i den forstand at registeret oppretter objekter av klassen Eiendom.
 * På en annen side kan jeg fint gjøre endringer i en av klassene uten av at jeg må gjøre endringer i den andre.
 *
 * Jeg vil si at koden har høy cohesion, fordi hver enkelt metode og klasse har ansvar for sin bestemte oppgave.
 * Var på den måten enkelt å navngi både klassene og metodene.
 * Klassen Eiendom har ansvar for en bestemt eiendom, mens EiendomRegister skal gi en oversikt over alle eiendommene som registreres.
 * Dette gjør det blant annet enkelt å forstå hensikten til klassene og metodene.
 * Dessuten gjenbruker jeg enkelte metoder flere ganger, og dette er kommentert underveis i koden.
 *
 *
 * Det er nesten alltid komposisjon om det er 1 til 1 forhold mellom klassene.
 * Dersom det er 0..* på begge klassene er det derimot nesten alltid aggregering.
 *
 * Kan være vanskelig å skille mellom aggregering og komposisjon når det kommer til ArrayList. kan ofte argumentere for begge deler
 * og argumentasjonen er det viktigste.
 *
 * Dersom det er snakk om fixed-size array, så er det lett å skille mellom aggregering og komposisjon i den forstand
 * at man kan velge mellom vanlig og dyp kopiering.
 *
 */
public class EiendomRegister {

    private ArrayList <Eiendom> eiendommer;

    /**
     * Konstruktør for å opprette et EiendomRegister.EiendomRegister.
     * Initsierer ArrayListen i konstruktøren, og på den måten er det ikke nødvendig å opprette en Arraylist i klienten.
     */
    public EiendomRegister() {
        eiendommer = new ArrayList<Eiendom>();
    }

    /**
     * Metode for å registrere eller legge til en eiendom i registeret.
     * Sjekker om eiendommen ikke har tomme felter og om eiendommen ikke er registrert fra før.
     * Får på den måten bruk for equals metoden som ble opprettet i klassen Eiendom, og dette er et eksempel på høy samstemthet/cohesion.
     * Equals metoden har kun ansvar for en bestemt oppgave, nemlig å sammenligne om objekter av Eiendom er like.
     *
      * @param eiendom som skal registreres.
     * @return true eller false om eiendommen ble registrert eller ikke.
     */
    public boolean registrereEiendom(Eiendom eiendom) {
        if(eiendom != null) {
            for(int i = 0; i < eiendommer.size(); i++) {
                if(eiendommer.get(i).equals(eiendom))
                    return false;
            }
            eiendommer.add(eiendom);
            return true;
        }
        return false;
    }

    /**
     * Metode for å slette eiendom fra registeret.
     * Sjekker om eiendommen ikke har tomme felter.
     * Eiendommen må være registrert fra før for at den skal kunne fjernes
     *
     * @param eiendom som skal slettes.
     * @return true eller false dersom eiendommen slettes eller ikke.
     */
    public boolean slettEiendom(Eiendom eiendom) {
        if(eiendom != null)
            if(eiendommer.contains(eiendom)) {
                eiendommer.remove(eiendom);
                return true;
            }
        return false;
    }

    /**
     * Metode for å returnere alle eiendommene i registere.
     * @return eiendommer.size() som er lengden på ArrayListen.
     */
    public int getAntallEiendommer() {
        return eiendommer.size();
    }

    /**
     * Metode for å skrive ut eiendommene i registeret.
     * Her brukes toString() metoden i klassen Eiendom og gjør at eiendommene kan skrives ut med informasjonen i ønsket rekkefølge.
     * Viser god samstemthet/cohesion, ettersom at toString() metoden i klassen Eiendom brukes.
     *
     * @return en ArrayList med Eiendom som objekt.
     */
    public String skriveUtEiendommer() {
        String println = "";
        for(int i = 0; i < eiendommer.size(); i++) {
            println += eiendommer.get(i).toString() + "\n";
        }
        return println;
    }

    /**
     * Metode for å søke etter en eiendom basert på kommunenummer, gårdsnummer og bruksnummer.
     * Sjekker først om nummerne ikke er lik null.
     * Går gjennom ArrayListen for å finne ut om en eiendom har tilsvarende nummer.
     *
     * @param kommuneNr
     * @param gårdsNr
     * @param bruksNr
     * @return den eiendommen som har de tilsvarende numrene. Eller null dersom numrene ikke samsvarer med numrene til en av eiendommene.
     */
    public Eiendom søkeEiendom(int kommuneNr, int gårdsNr, int bruksNr) {
        if(kommuneNr != 0 && gårdsNr != 0 && bruksNr != 0) {
            for(int i = 0; i < eiendommer.size(); i++) {
                if(eiendommer.get(i).getKommuneNr() == kommuneNr && eiendommer.get(i).getGårdsNr() == gårdsNr && eiendommer.get(i).getBruksNr() == bruksNr) {
                    return eiendommer.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Metode for å regne ut gjennomsnittsarealet til alle eiendommene i registeret.
     * GjennomsnittsArealet er lik det totale arealet dividert med antall eiendommer.
     * Bruker getAntallEiendommer() metoden, og dette er et eksempel på høy samstemthet (cohesion) i den forstand at jeg gjenbruker en metode flere ganger.
     * Går gjennom ArrayListen og henter arealet til alle eiendommene i registeret. Summerer dette i variabelen totalAreal.
     * Kaster også en Exception dersom arealet er negativt.
     * @return double ettersom man bruker ofte et par desimaler for å regne med areal.
     */
    public double regneGjennomsnittsAreal() {
        double totalAreal = 0;
        int antallEiendommer = getAntallEiendommer();
        double gjennomSnittsAreal = 0;

        for(int i = 0; i < eiendommer.size(); i++) {
            if(eiendommer.get(i).getAreal() < 0)
                throw new IllegalArgumentException("Arealet kan ikke være negativt!");
            totalAreal += eiendommer.get(i).getAreal();
        }

        gjennomSnittsAreal = totalAreal / antallEiendommer;
        return gjennomSnittsAreal;
    }

    /**
     * Metode for å søke opp samtlige eiendommer med et gitt gårdsnummer.
     * Sjekker om gårdsnummeret ikke er lik null.
     * Deretter går gjennom listen for å finne de eiendommene med den spesielle indeksen som har det gitte nummeret.
     * Legger disse eiendommene til i en ArrayList
     *
     * @param gårdsNr som skal sjekkes.
     * @return en ArrayList med eiendommer som har det gitte gårdsnummeret.
     * Jeg valgte denne returtypen da den gir en fin oversikt over hvilke eiendommer som har det samme gårdsnummeret.
     */
    public ArrayList<Eiendom> getEiendomMedGårdsNr(int gårdsNr) {
        ArrayList<Eiendom> sammeGårdsNr = new ArrayList<Eiendom>();
        if(gårdsNr != 0)
            for(int i = 0; i < eiendommer.size(); i++) {
                if(eiendommer.get(i).getGårdsNr() == gårdsNr)
                    sammeGårdsNr.add(eiendommer.get(i));
            }
        return sammeGårdsNr;
    }
} //class end
