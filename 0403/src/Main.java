import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] glasses = new int[N+1];
		for (int i = 1; i <= N; i++) {
			glasses[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = glasses[1];
		if(N>=2) dp[2] = glasses[1]+glasses[2];
		if(N>=3) dp[3] = glasses[3]+Math.max(glasses[1],glasses[2]);
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i-3]+glasses[i-1],dp[i-2])+glasses[i];
			dp[i] = Math.max(dp[i], dp[i-4]+glasses[i-1]+glasses[i]);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}