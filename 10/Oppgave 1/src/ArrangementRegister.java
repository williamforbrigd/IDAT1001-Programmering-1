import java.util.ArrayList;

/**
 * Klasse som representerer et ArrangementRegister og holder oversikt over alle arrangementene som er registert.
 * Disse arrangementene samles i en ArrayList, og denne typen liste anses som svært hensiktsmessig i dette tilfellet
 * i den forstand at det opprettes nye arrangementer hele tiden. Samtidig, vil arrangementer arrangeres, og vil dermed
 * bli fjernet fra listen. Det er dermed ubevisst hvor mange arrangementer som vil være på listen i fremtiden, og derfor
 * vil en dynamisk tabell være svært hensiktsmessig.
 *
 * Klassen er utført i henhold til prinsippet om komposisjon. Et arrangementregister er eksistensavhengig av klassen
 * Arrangement, og i praksis omfatter dette at man kan ikke opprette et ArrangementRegister uten å registrere
 * arrangementer. Arrangementene genereres gjennom funksjonene i denne klassen, og på den måten er det bare denne
 * klassen som har tilgang til klassen Arrangement.
 *
 * Klassen er også forsøkt utført i henhold til prinsippet om høy cohesion, nærmere bestemt som høy grad av sammenheng
 * eller høy samstemthet. Klassen representerer en entitet, som er et ArrangementRegister. Funksjonene derimot
 * har mer eller mindre kun ansvar for en bestemt oppgave, og egner seg dermed godt for gjenbruk.
 *
 * @author William Forbrihd
 * @version 1.0
 *
 */
public class ArrangementRegister {

    //Deklarerer en ArrayList med objekter av Arrangement.
    private ArrayList<Arrangement> arrangementer;

    /**
     * Konstruktør som oppretter et objekt av ArrangementRegister. Den dynamiske tabellen initieres i konstruktøren,
     * og på den måten er det ikke nødvendig å opprette en tabell når man oppretter et objekt av ArrangementRegister.
     * Dette samsvarer med prinsippet om samstemthet i den forstand at det er bare denne klassen som har tilgang
     * til tabellen med objektene.
     */
    public ArrangementRegister() {
        arrangementer = new ArrayList<>();
    }

    /**
     * Tilgangsmetode for hente ut tabellen. Viser til prinsippet om innkapsling, ettersom den dynamiske tabellen er
     * satt til private og må aksesseres gjennom en tilgangsmetode. Samtidig viser det til komposisjon i den forstand
     * at der er bare denne klassen som har tilgang til Arrangement-objektet.
     * @return den dynamiske tabellen med objekter av klassen Arrangement.
     */

    public ArrayList<Arrangement> getArrangementer() {
        return arrangementer;
    }

    /**
     * Metode som registrerer et nytt arrangement. Det nye arrangementet sendes inn som argument, og kan dermed
     * genereres gjennom denne metoden ved bruk av "new". Dersom arrangementet skulle være ugyldig, eller nærmere
     * bestemt "null" vil metoden returnere false.
     * Metoden sjekker om tabellen inneholder arrangementet fra før ved å bruke contains()-metoden fra klassen
     * ArrayList. Det som er vesentlig her er at equals()-metoden som ble opprettet i klassen Arrangement blir brukt.
     * Denne metoden sjekker som konstatert om to forskjellige objekter er like, eller nærmere bestemt oppfører seg
     * likt. Dessuten er denne equals()-metoden overskrevet, og på den måten vil den egendefinerte equals()-metoden
     * bli brukt i dette tilfellet. Dermed kan objektene sammenlignes etter hvilke tilstander som er ønskelig, og i
     * dette tilfellet sammenlignes attributtene navn og sted.
     * @param arrangement som skal registreres.
     * @return true dersom arrangementet blir registrert og false dersom arrangement ikke blir registrert. Arrangementet
     * blir ikke registrert dersom det er registert fra før, eller dersom arrangementet er ugyldig.
     */
    //I denne metoden har jeg valgt å bruke boolean som returtype. Denne returtypen er hensiktsmessig i tilfeller hvor
    //det er snakk enten eller. Enten vil arrangementet bli registrert eller så vil arrangementet ikke bli registrert.
    public boolean regArrangement(Arrangement arrangement) {
        //Sjekker om argumentet som sendes inn er gyldig.
        if(arrangement != null) {
            //Sjekker at listen med arrangementer ikke inneholder det arrangementet som skal bli registrert. Contains()
            //metoden til ArrayList har mer eller mindre samme funksjon som en løkke, den går gjennom hvert
            //element i listen og sjekker om det ikke er registrert fra før.
            if(!arrangementer.contains(arrangement)) {
                //Arrangementer registreres dersom det ikke er registrert fra før og det returneres true.
                arrangementer.add(arrangement);
                return true;
            }
        }
        //Returnerer false dersom arrangementet er registrert fra før, eller dersom arrangementet er ugyldig.
        return false;
    }

    /**
     * Metode som finner alle arrangementene på et gitt sted. Det opprettes en ny dynamisk tabell som lokal variabel
     * i denne metoden og denne tabellen fylles fortløpende etter arrangementene som har det gitte stedet.
     * Sjekker om stedet faktisk finnes og at det ikke er null, da det vil være ineffektiv å lete etter et sted
     * som ikke finnes. De arrangementene med det gitte stedet legges til i tabellen, og denne tabellen returneres.
     * @param sted som er stedet hvor arrangementene skal bli arrangert på.
     * @return den dynamiske tabellen med alle arrangementene som arrangeres på det gitte stedet. Eller returnerer
     * null dersom ingen av arrangementene arrangeres på det gitte stedet.
     */

    public ArrayList<Arrangement> finnGittSted(String sted) {
        //Oppretter en ny dynamisk tabell og fyller denne opp.
        ArrayList<Arrangement> gittSted = new ArrayList<>();
        //Sjekker at steder faktisk eksisterer.
        if(sted != null) {
            //Går gjennom hvert element i tabellen.
            for(int i = 0; i < arrangementer.size(); i++) {
                //Sjekker om noen av stedene til arrangementene samsvarer med det gitte stedet.
                if(arrangementer.get(i).getSted().equals(sted.trim())) {
                    //Legger disse til dersom de inneholder det gitte stedet.
                    gittSted.add(arrangementer.get(i));
                }
            }
        }
        //Returnerer null dersom ingen av arrangementene arrangeres på det gitte stedet.
        if(gittSted.size() == 0) return null;
        //Returnerer tabellen hvis den ikke er tom.
        else return gittSted;
    }

    /**
     * Metode som finner alle arrangementene på en gitt dato. Det opprettes en ny dynamisk tabell som lokal variabel
     * i denne metoden og denne tabellen fylles fortløpende etter arrangementene som har den gitte datoen.
     * Sjekker om datoen faktisk er virkelig og at det ikke er null, da det vil være ineffektivt å lette etter
     * arrangementer som arrangeres på en ugyldig tid. De arrangementene med det gitte stedet legges til i tabellen,
     * og denne tabellen returneres.
     * @param dato som er tidspunktet som skal undersøkes om noen av arrangementene arrangeres på.
     * @return den dynamiske tabellen med alle arrangementene som arrangeres på den gitte datoen. Eller returnerer
     * null dersom ingen av arrangementene arrangeres på tidspunktet.
     */

    public ArrayList<Arrangement> finnGittDato(long dato) {
        //Oppretter en ny dynamisk tabell som lokal variabel.
        ArrayList<Arrangement> gittDato = new ArrayList<>();
        //Sjekker at datoen er virkelig
        if(dato != 0) {
            //Går gjennom tabellen ved hjelp av en utvidet for løkke, da man må sjekke hvert element i tabellen.
            for(Arrangement arrangement : arrangementer) {
                //Sjekker om noen av arrangementene arrangeres på det gitte tidspunktet. Sammenligningsoperatoren "=="
                // er hensiktsmessig for å sammenligne primitive datatyper i motsetning til strenger. "==" vil sjekke
                //datainnholdet i disse int-verdiene.
                if(arrangement.getTidspunkt() == dato) {
                    //Legger til de arrangementene med den gitte datoen i tabellen.
                    gittDato.add(arrangement);
                }
            }
        }
        //Returnerer null dersom tabellen er tom.
        if(gittDato.size() == 0) return null;
        //Returnerer tabellen dersom noen av arrangementene blir arrangert på det gitte tidspunktet.
        else return gittDato;
    }

    /**
     * Metode som finner alle arrangementene innenfor et gitt tidsintervall. Sjekker først at tidsintervallet er
     * gyldig, og dersom det ikke er gyldig kastes et egetformulert unntaksargument. Deretter opprettes en ny tabell
     * som lokal variabel, og legger fortløpende arrangementene innefor tidsintervallet i tabellen. Dette gjøres
     * ved å gå gjennom hvert element i tabellen, og undersøke om disse blir arrangert innnenfor tidsintervallet.
     * @param start som er den nedre grensen i tidsintervallet.
     * @param slutt som er den øvre grensen i tidsintervallet.
     * @return en dynamisk tabell med arrangementer innenfor tidsintervallet eller null dersom ingen av arrangementene
     * arrangeres i intervallet.
     */
    public ArrayList<Arrangement> finnGittTidsintervall(long start, long slutt) {
        //Sjekker om tidsintervallet er gyldig. Dersom det ikke er gyldig vil et egetformulert unntaksargument kastes
        //for å gi klienten en spesifikk melding om hva som er problemet.
        if(slutt < start || start == 0 || slutt == 0) {
            throw new IllegalArgumentException("Vennligst tast inn et gyldig tidsintervall");
        }
        //Dersom tidsintervallet er gyldig, opprettes en ny dynamisk tabell.
        ArrayList<Arrangement> gittTidsintervall = new ArrayList<>();
        //Går gjennom elementene i tabellen med alle arrangementene.
        for(Arrangement arrangement : arrangementer) {
            //dersom noen av arrangementene i den opprinnelige tabellene arrangeres innenfor tidsintervallet, vil
            //de bli lagt til i tabellen som opprettes om lokal variabel i metoden.
            if(arrangement.getTidspunkt() >= start && arrangement.getTidspunkt() <= slutt) {
                gittTidsintervall.add(arrangement);
            }
        }
        //Sjekker om tabellen er tom, og dersom den er det returneres null.
        if(gittTidsintervall.size() == 0) return null;
        //Hvis ikke returneres tabellen med arrangementene innenfor tidsintervallet.
        else return gittTidsintervall;
    }

    /**
     * Metode som manuelt soreter den dynamiske tabellen etter tidspunkt. Dette er vel og merke et alternativ
     * til interfacet som ble implementert i Arrangement klasse.
     * Metoden baserer seg på sorteringsprinsippet selection sort, hvor man skal sortere et antall med elementer fra
     * minst til størst eller omvendt. I dette tilfellet sorteres det fra minst til størst tidspunkt, eller nærmere
     * bestemt fra tidspunktet minst til tidspunktet størst. Prinsippet går ut på at man finner det arrangementet
     * med den tidligste datoen, og dette elementet byttes med det første elementet. Disse operasjonene gjentas til
     * det gjenværende elementet er det største.
     * @param start den nedre delen av tidsintervallet.
     * @param slutt den øvre delen av tidsintervallet.
     * @return den dynamiske tabellen med alle arrangementene sortert i stigende rekkefølge.
     */
    //Sorterer listen ved å bruke algoritmen Selection Sort
    public ArrayList<Arrangement> sortertGittTidsintervall(long start, long slutt) {
        //Bruker metoden finnGittTidsintervall() fra denne klassen til å hente ut tabellen som skal sorteres. Dette
        //viser til prinsippet om samstemthet, ved at en metode med en spesifikk oppgave får nytte senere.
        ArrayList<Arrangement> gittTidsintervall = finnGittTidsintervall(start, slutt);

        //I disse løkkene finner jeg det minste elementet ved å bruke metoden compareTo() som ble opprettet i klassen
        //Arrangement. Denne egendefinerte compareTo()-metoden sammenligner datoene.
        int hittilMinst = 0;
        for(int i = 0; i < gittTidsintervall.size(); i++) {
            hittilMinst = i;
            for(int j = i; j < gittTidsintervall.size(); j++) {
                if(gittTidsintervall.get(j).compareTo(gittTidsintervall.get(hittilMinst)) < 0) {
                    hittilMinst = j;
                }
            }
            //Deretter stokkes det om på arrangementene hvor det arrangementet med det minste tidspunktet byttes om
            //med det arrangementet som ligger først i tabellen.
            Arrangement temp = gittTidsintervall.get(hittilMinst);
            gittTidsintervall.set(hittilMinst, gittTidsintervall.get(i));
            gittTidsintervall.set(i, temp);
        }
        //returnerer den sorterte tabellen.
        return gittTidsintervall;
    }

    /**
     * Metode som skriver ut en liste med arrangementer som sendes inn som argument.
     * Bruker utvidet for løkke for å gå gjennom hvert element i tabellen, og bruker toString()-metoden
     * som ble opprettet i klassen Arrangement for å skrive ut tilstandene.
     * @param skrivUt som er den dynamiske tabellen som skal skrives ut.
     * @return en tekststreng med alle arrangenmentene og ny linje for hvert arrangement.
     */
    public String skrivUtListe(ArrayList<Arrangement> skrivUt) {
        //Oppretter en string som skal skrives ut.
        String println = "";
        //Sjekker at tabellen er gyldig og at den har arrangementer som kan skrives ut.
        if(skrivUt != null) {
            //Bruker utvidet for løkke for å gå gjennom alle elementene i tabellen.
            for(Arrangement arrangement : skrivUt) {
                //Bruker toString()-metoden i klassen Arrangement for å skrive ut Arrangementene.
                println += arrangement.toString() + "\n";
            }
        }
        //Returnerer denne tekststrengen med alle arrangementene.
        return println;
    }

    /**
     * En ekstra metode for å skrive ut arrangementene som derimot ikke sendes inn som argument. Skriver dermed ut
     * det objektet som kaller denne metoden. Bruker også utvidet for løkke for å gå gjennom hvert element i tabellen
     * og bruker toString()-metoden fra klassen Arrangement.
     * @return en tekststreng med alle arrangementene skrevet ut.
     */
    public String skrivUtListe() {
        String println = "";
        for(Arrangement arrangement : arrangementer) {
            println += arrangement.toString() + "\n";
        }
        return println;
    }
}
