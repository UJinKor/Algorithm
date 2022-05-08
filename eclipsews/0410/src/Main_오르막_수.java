import java.util.Scanner;

public class Main_오르막_수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] dp = new int[N+1][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int j2 = j; j2 < 10; j2++) {
					dp[i][j] = (dp[i][j]+dp[i-1][j2])%10007;
				}
			}
		}
		int sum=0;
		for (int i = 0; i < 10; i++) {
			sum=(sum+dp[N][i])%10007;
		}
		System.out.println(sum);
	}

}
