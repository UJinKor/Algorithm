import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_카드_구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int[] cards = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = cards[1];
		for (int i = 2; i <= N; i++) {
			int max = cards[i];
			for (int j = 1; j < i; j++) {
				max = Math.max(max,dp[i-j]+cards[j]);
			}
			dp[i] = max;
		}
		System.out.println(dp[N]);
	}

}
