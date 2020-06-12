import java.util.ArrayList;

public class MenyRegister {

    private ArrayList<Meny> menyer;

    public MenyRegister() {
        menyer = new ArrayList<>();
    }

    public ArrayList<Meny> getMenyer() {
        return menyer;
    }

    public int finnMenyGittNavn(String menyNavn) {
        int indeksFunnet = 0;
        if(menyNavn != null) {
            for(int i = 0; i < menyer.size(); i++) {
                if (menyer.get(i).getNavn().equals(menyNavn.trim())) {
                    indeksFunnet = i;
                    return indeksFunnet;
                }
            }
        }
        return -1;
    }

    public boolean regRett(String menyNavn, Rett rett) {
        int indeksFunnet = finnMenyGittNavn(menyNavn);
        if(rett != null && menyNavn != null && indeksFunnet != -1) {
            if(!menyer.get(indeksFunnet).getRetter().contains(rett)) {
                menyer.get(indeksFunnet).regRett(rett);
                return true;
            }
        }
        return false;
    }


    public Rett finnRettNavn(String rettNavn) {
        Rett rettFunnet = new Rett();

        if(rettNavn != null) {
            for(int i = 0; i < menyer.size(); i++) {
                rettFunnet = menyer.get(i).finnRettNavn(rettNavn);
            }
            return rettFunnet;
        }
        return null;
    }

    public ArrayList<Rett> finnRetterType(String type) {
        ArrayList<Rett> retterFunnet = new ArrayList<>();

        for(int i = 0; i < menyer.size(); i++) {
            retterFunnet = menyer.get(i).finnRetterType(type);
        }
        return retterFunnet;
    }

    public boolean regMeny(Meny meny) {
        if(meny != null) {
            if(!menyer.contains(meny)) {
                menyer.add(meny);
                return true;
            }
        }
        return false;
    }

    public boolean regMenyMedRetter(Meny meny, Rett r1, Rett r2) {
        if(meny != null && r1 != null && r2 != null) {
            if (regMeny(meny)) {
                meny.regRett(r1);
                meny.regRett(r2);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Meny> finnMenyerPrisIntervall(double start, double slutt) {
        if(slutt < start) {
            throw new IllegalArgumentException("Vennligst tast inn et gyldig intervall");
        }

        ArrayList<Meny> menyPrisIntervall = new ArrayList<>();
        for(Meny meny : menyer) {
            if(meny.getTotalPrisMeny() >= start && meny.getTotalPrisMeny() <= slutt) {
                menyPrisIntervall.add(meny);
            }
        }
        return menyPrisIntervall;
    }

    public String skrivUtMenyer(ArrayList<Meny> skrivUt) {
        String println = "";
        if(skrivUt != null) {
            for(Meny meny : skrivUt) {
                println += meny.toString() + "\n";
            }
        }
        return println;
    }

    public String skrivUtMenyer() {
        String println = "";
        for(Meny meny : menyer) {
            println += meny.toString() + "\n";
        }
        return println;
    }

    public String skrivUtRetter(ArrayList<Rett> skrivUtRetter) {
        String println = "";
        if(skrivUtRetter != null) {
            for(int i = 0; i < skrivUtRetter.size(); i++) {
               println += skrivUtRetter.get(i).toString() + "\n";
            }
        }
        return println;
    }
}
