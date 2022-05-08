import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2667_단지번호붙이기 {
	
	static int N,arr[][];
	static boolean visited[][];
	static int wholeCnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]&&arr[i][j]!=0) {
					cnt = 1;
					dfs(i,j);
					wholeCnt++;
					ans.add(cnt);
				}
			}
		}
		
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		sb.append(wholeCnt).append("\n");
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append("\n");
		}
		System.out.println(sb);
	}	
	static int[] r = {0,1,0,-1};
	static int[] c = {1,0,-1,0};
	static int cnt;
	
	public static void dfs(int y,int x) {
		
		visited[y][x] = true;
		int nr,nc;
		for (int i = 0; i < 4; i++) {
			nr = y+r[i];
			nc = x+c[i];
			if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]&&arr[nr][nc]!=0) {
				dfs(nr,nc);
				cnt++;
			}
		}
	}
}
