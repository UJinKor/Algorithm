import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < 2; j++) {
					if(j==0) {
						dp[j][i] = Math.max(dp[1][i-1]+arr[j][i], dp[0][i-1]);
					} else {
						dp[j][i] = Math.max(dp[0][i-1]+arr[j][i], dp[1][i-1]);
					}
				}
			}
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb);
		
	}

}
