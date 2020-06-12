import java.util.Scanner;

public class Primtall {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        int tall = sc.nextInt();
        int dele = tall;

        boolean primtall = false;

        while(--dele > 1 && tall > 1) {
            if(tall % dele != 0)
                primtall = true;
        }
        if(primtall) System.out.println(tall + " er et primtall.");
        else System.out.println(tall + " er ikke et primtall.");
    }
}
