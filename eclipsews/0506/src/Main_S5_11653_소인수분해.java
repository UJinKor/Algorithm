import java.util.Scanner;

public class Main_S5_11653_소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(N>1) {
			for (int i = 2; i <= N; i++) {
				if(N%i==0) {
					sb.append(i).append("\n");
					N /= i;
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
