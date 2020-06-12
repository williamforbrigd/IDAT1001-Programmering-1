import java.lang.reflect.Array;
import java.util.ArrayList;

public class Meny {

    private ArrayList<Rett> retter;
    private String navn;

    public Meny() {
        retter = new ArrayList<>();
    }

    public Meny(String navn) {
        retter = new ArrayList<>();
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Rett> getRetter() {
        return retter;
    }

    public boolean regRett(Rett rett) {
        if(rett != null) {
            if(!retter.contains(rett)) {
                retter.add(rett);
                return true;
            }
        }
        return false;
    }

    public Rett finnRettNavn(String navn) {
        Rett rettFunnet = new Rett();
        if(navn != null) {
            for(int i = 0; i < retter.size(); i++) {
                if(retter.get(i).getNavn().equals(navn)) {
                    rettFunnet = retter.get(i);
                    return rettFunnet;
                }
            }
        }
        return null;
    }

    public ArrayList<Rett> finnRetterType(String type) {
        ArrayList<Rett> retterFunnet = new ArrayList<>();
        if(type != null) {
            for(Rett rett : retter) {
                if(rett.getType().equals(type.trim())) {
                    retterFunnet.add(rett);
                }
            }
        }
        if(retterFunnet.size() == 0) return null;
        else return retterFunnet;
    }


    public double getTotalPrisMeny() {
        double totalPris = 0;
        for(int i = 0; i < retter.size(); i++) {
            totalPris += retter.get(i).getPris();
        }
        return totalPris;
    }


    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(this == object) return true;
        if(object instanceof Meny) {
            Meny meny = (Meny) object;
            return this.getNavn().equals(meny.getNavn());
        }
        return false;
    }

    public String skrivUtRetter() {
        String println = "";
        int indeks = 0;
        for(Rett rett : retter) {
            indeks++;
            println += indeks + ": " + rett.toString() + "\n";
        }
        return println;
    }


    public String toString() {
        return navn + ": \n" + skrivUtRetter();
    }
}
