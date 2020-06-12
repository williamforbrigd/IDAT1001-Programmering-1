public class Main {
    public static void main(String[]args) {

        Temperaturer desember = new Temperaturer();

        desember.setTemperatuerer();
        desember.skrivUt2DArray();

        System.out.println("--------");
        System.out.println(desember.skrivUtArray(desember.getMiddelDag()));
        System.out.println("--------");
        System.out.println(desember.skrivUtArray(desember.getMiddelTemperaturTime()));
        System.out.println("--------");
        System.out.println(desember.getMiddelTemperaturMnd());
        System.out.println("--------");
        System.out.println(desember.skrivUtIntArray(desember.middelTempInnenforGrense()));

    }
}
