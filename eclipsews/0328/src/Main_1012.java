import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
	static int arr[][], M, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]==1) {
						dfs(i,j);
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	static int[] r = {-1,0,1,0};
	static int[] c = {0,1,0,-1};
	public static void dfs(int y,int x) {
		arr[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = y+r[i];
			int nc = x+c[i];
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
	}

}
