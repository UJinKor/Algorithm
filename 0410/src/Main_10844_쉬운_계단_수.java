import java.util.Scanner;

public class Main_10844_쉬운_계단_수 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[][] dp = new long[N+1][10];
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][1];
				} else if(j==9) {
					dp[i][j] = dp[i-1][8];
				} else {
					dp[i][j] = (dp[i-1][j+1]+dp[i-1][j-1])%1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum=(sum+dp[N][i])%1000000000;
		}
		System.out.println(sum);
	}

}
