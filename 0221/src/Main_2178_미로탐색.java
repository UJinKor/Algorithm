import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int[][] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		String s;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		System.out.println(bfs(0,0));
	}
	static int[] r = {0,1,0,-1};
	static int[] c = {1,0,-1,0};
	public static int bfs(int y,int x) {
		Queue<Integer[]> queue = new LinkedList<>();
		int[][] level = new int[N][M];
		queue.offer(new Integer[]{y,x});
		level[y][x] = 1;//방문 여부를 레벨로 표시 0 -> 미방문 
		int nr,nc;
		while(!queue.isEmpty()) {
			Integer[] current = queue.poll();
			if(current[0]==N-1&&current[1]==M-1) {
				return level[N-1][M-1];
			}
			for (int i = 0; i < 4; i++) {
				nr = current[0]+r[i];
				nc = current[1]+c[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&arr[nr][nc]!=0&&level[nr][nc]==0) {
					queue.offer(new Integer[] {nr,nc});
					level[nr][nc] = level[current[0]][current[1]]+1;
				}
			}
		}
		return -1;
	}
}
