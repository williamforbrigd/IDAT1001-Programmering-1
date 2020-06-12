public class Rett {

    private String navn;
    private String type;
    private double pris;
    private String oppskrift;

    public Rett(String navn, String type, double pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    public Rett() {}

    public String getNavn() {
        return navn;
    }

    public String getType() {
        return type;
    }

    public double getPris() {
        return pris;
    }

    public String getOppskrift() {
        return oppskrift;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setOppskrift(String oppskrift) {
        this.oppskrift = oppskrift;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(this == object) return true;
        if(object instanceof Rett) {
            Rett rett = (Rett) object;
            return this.getNavn().equals(rett.getNavn());
        }
        return false;
    }

    public String toString() {
        return navn + " " + type + " " + pris + " " + oppskrift;
    }
}
