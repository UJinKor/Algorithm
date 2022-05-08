import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static int N,M,arr[][];
	static int ice=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0) ice++;

			}
		}
		int result=0;
		
		while(true) {
			cnt=1;
			result++;
			melt();//최초 한덩어리이므로 먼저녹임
			boolean hasIce = false;
			loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j]>0) {
						hasIce = true;
						dfs(i,j,new boolean[N][M]);
						break loop;
					}
				}
			}
			if(!hasIce) {
				result = 0;
				break;
			}
			if(!(cnt==ice)) break;
			
		}
		System.out.println(result);
		
	}
	
	static int[] r = {-1,0,1,0};
	static int[] c = {0,1,0,-1};
	static int cnt;
	public static void melt() {//얼음 녹이기
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]>0) {
					for (int dir = 0; dir < 4; dir++) {
						int nr = i+r[dir];
						int nc = j+c[dir];
						if(nr>=0&&nc>=0&&nr<N&&nc<M) {
							if(arr[nr][nc]==0&&temp[i][j]!=0) {
								temp[i][j]--;
								if(temp[i][j]==0) ice--;
							}
						}
					}
				}
			}
		}
		arr = temp;
	}
	
	public static void dfs(int y,int x,boolean[][] visited) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nr = y+r[i];
			int nc = x+c[i];
			if(nr>=0&&nc>=0&&nr<N&&nc<M&&arr[nr][nc]>0&&!visited[nr][nc]) {
				dfs(nr,nc,visited);
				cnt++;
			}
		}
	}
}
