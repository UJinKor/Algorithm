import java.util.Scanner;

public class Main_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();
        double a = D/Math.sqrt(((H*H)+(W*W)));
        System.out.println((int)(a*H)+" "+(int)(a*W));
    }
}
