import java.util.Scanner;

public class TimerMinSek {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int sekunder = sc.nextInt();

        int timer = sekunder / 3600;
        int rest = sekunder % 3600;
        int minutter = rest / 60;
        int restSekunder = rest % 60;

        System.out.println(sekunder + " sekunder er " + timer + " timer, " + minutter + " minutter og " + restSekunder + " sekunder.");
    }
}
