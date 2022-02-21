import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int[][] arr;
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		Queue<Integer[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					queue.offer(new Integer[] {i,j});
				}
			}
		}
		bfs(queue);
		int ans=-1;
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0) {
					ans=-1;
					break loop;
				}
				ans = Math.max(ans, arr[i][j]-1);
			}
		}
		System.out.println(ans);
	}
	static int[] r = {0,1,0,-1};
	static int[] c = {1,0,-1,0};
	public static void bfs(Queue<Integer[]> queue) {
		int nr,nc;
		while(!queue.isEmpty()) {
			Integer[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				nr = current[0]+r[i];
				nc = current[1]+c[i];
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&arr[nr][nc]==0) {
					queue.offer(new Integer[] {nr,nc});
					arr[nr][nc] = arr[current[0]][current[1]] + 1;
				}
			}
		}
	}

}
