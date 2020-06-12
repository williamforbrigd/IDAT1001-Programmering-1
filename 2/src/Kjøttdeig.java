
public class Kjøttdeig {
    public static void main(String[]args) {
        double prisA = 450.0 / 35.9;
        double prisB = 500 / 39.5;

        if(prisA < prisB)
            System.out.println("Kjøttdeig A er billigst.");
        else
            System.out.println("Kjøttdeiig B er billigst.");
    }
}
