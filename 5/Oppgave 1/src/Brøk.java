public class Brøk {

    private int teller;
    private int nevner;

    public Brøk(int teller, int nevner) {
        if (nevner == 0)
            throw new IllegalArgumentException("Nevneren kan ikke være null.");
        this.teller = teller;
        this.nevner = nevner;
    }

    public Brøk(int teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    public int getTeller() {
        return teller;
    }

    public int getNevner() {
        return nevner;
    }

    public void summerBrøk(Brøk brøk) {
        teller = teller * brøk.getNevner() + brøk.getTeller() * nevner;
        nevner = nevner * brøk.getNevner();
        forkortBrøk();
    }

    public void subtrahereBrøk(Brøk brøk) {
        teller = teller * brøk.getNevner() - brøk.getTeller() * nevner;
        nevner = nevner * brøk.getNevner();
        forkortBrøk();
    }

    public void multiplisereBrøk(Brøk brøk) {
        teller *= brøk.getTeller();
        nevner *= brøk.getNevner();
        forkortBrøk();
    }

    public void dividereBrøk(Brøk brøk) {
        teller *= brøk.getNevner();
        nevner *= brøk.getTeller();
        forkortBrøk();
    }

    public void forkortBrøk() {
        int i = 20;
        while (--i > 1) {
            if (teller % i == 0 && nevner % i == 0) {
                teller = teller / i;
                nevner = nevner / i;
            }
        }
    }
        //public int forkortBrøk3(int teller, int nevner) {
        //  return teller%nevner == 0 ? teller : forkortBrøk3(nevner, teller%nevner);
        //}


    public String toString () {
        return teller + "/" + nevner;
    }
}

