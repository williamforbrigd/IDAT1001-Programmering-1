public class Klient {
    public static void main(String[]args) {

        ArbTaker a1 = new ArbTaker(new Person("Ingrid", "Forbrigd", 1962), 1, 2010, 100000, 0.5);

        System.out.println(a1.skattPrMnd());
        System.out.println(a1.bruttoLønn());
        System.out.println(a1.skatteTrekkPerÅr());
        System.out.println(a1.navnForm());
        System.out.println(a1.alder());
        System.out.println(a1.ansattIBedriften());
        System.out.println(a1.ansattGittAntallÅr(20));
    }
}
