
public class TerningSpillet {
    public static void main(String[]args) {

        Spiller Willi = new Spiller("Willi");
        Spiller Alex = new Spiller("Alex");

        int rundeNummer = 0;
        boolean vinner = false;

        while(!vinner) {
            rundeNummer++;
            System.out.println(rundeNummer + ": " + Willi.toString() + " " + Willi.kastTerningen() + " " + "\t" + "\t" + "\t" + Alex.toString() + " " + Alex.kastTerningen());

            if(Alex.erFerdig()) {
                System.out.println(Alex.getName() + " vant spillet.");
                vinner = true;
            }
            if(Willi.erFerdig()) {
                System.out.println(Willi.getName() + " vant spillet.");
                vinner = true;
            }
        }
    }
}