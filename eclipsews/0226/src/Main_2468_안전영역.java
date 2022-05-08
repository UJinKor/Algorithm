import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int N,arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
			}
		}
		int result = 0;
		int cnt;
		for (int i = 0; i < max; i++) {
			cnt=0;
			boolean[][] visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(arr[j][j2]>i&&!visited[j][j2]) { //빗물에 잠기지 않고 아직 방문하지 않음
						dfs(j,j2,visited,i);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
		
	}
	
	static int[] r = {-1,0,1,0};
	static int[] c = {0,1,0,-1};
	public static void dfs(int y,int x,boolean[][] visited,int rain) {
		
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nr = y+r[i];
			int nc = x+c[i];
			if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]&&arr[nr][nc]>rain) {
				dfs(nr,nc,visited,rain);
			}
		}
	}
}
