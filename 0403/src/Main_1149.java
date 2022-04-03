import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[N+1][3];

		dp[1] = new int[] {arr[1][0],arr[1][1],arr[1][2]};
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for (int j2 = 0; j2 < 3; j2++) {
					if(j2==j) continue;
					if(dp[i-1][j2]<min) {
						min = dp[i-1][j2];
					}
				}
				dp[i][j] = arr[i][j]+ min;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(min>dp[N][i]) {
				min = dp[N][i];
			}
		}
		System.out.println(min);

	}

}